/**
m  * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package vn.com.ecopharma.hrm.rc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import vn.com.ecopharma.hrm.rc.constant.CandidateField;
import vn.com.ecopharma.hrm.rc.constant.ECO_RCUtils;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateHistoryActionType;
import vn.com.ecopharma.hrm.rc.enumeration.VacancyCandidateType;
import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.model.CandidateActionHistory;
import vn.com.ecopharma.hrm.rc.model.Certificate;
import vn.com.ecopharma.hrm.rc.model.Experience;
import vn.com.ecopharma.hrm.rc.model.VacancyCandidate;
import vn.com.ecopharma.hrm.rc.service.DocumentLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.base.CandidateLocalServiceBaseImpl;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the candidate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.hrm.rc.service.CandidateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.base.CandidateLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil
 */
public class CandidateLocalServiceImpl extends CandidateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil} to access the
	 * candidate local service.
	 */

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CandidateLocalServiceImpl.class);

	public List<Candidate> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<Candidate> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<Candidate> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return candidatePersistence.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * public Candidate findByEmailAddress(String emailAddress) { try { return
	 * candidatePersistence.fetchByEmail(emailAddress); } catch (SystemException
	 * e) { e.printStackTrace(); } return null; }
	 */

	public boolean isEmailExisted(String emailAddress) {
		try {
			List<Candidate> candidates = candidatePersistence
					.findByEmailAddress(emailAddress);
			return candidates != null && candidates.size() > 0;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Candidate findByIdentityCardNo(String identityCardNo) {
		try {
			return candidatePersistence.fetchByIdentityCardNo(identityCardNo);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Candidate findByContactNumber(String contactNumber) {
		try {
			return candidatePersistence.fetchByContactNumber(contactNumber);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Candidate createPrePersistCandidate() {
		try {
			final long id = counterLocalService.increment();
			return candidatePersistence.create(id);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Candidate createPrePersistCandidate(String candidateCode,
			String fullName, String emailAddress, String contactNumber,
			String identityCardNo, long locationId, long vacancyId,
			Date applicationDate, String status) {
		final Candidate candidate = this.createPrePersistCandidate();
		candidate.setCandidateCode(candidateCode);
		candidate.setFullName(fullName);
		candidate.setEmailAddress(emailAddress);
		candidate.setContactNumber(contactNumber);
		candidate.setIdentityCardNo(identityCardNo);
		candidate.setApplicationDate(applicationDate);

		return candidate;
	}

	public Candidate addCandidate(Candidate candidate, long locationId,
			long vacancyId, List<Long> desireVacancies,
			List<Long> fileEntryIds, Map<Experience, Boolean> experienceMap,
			Map<Certificate, Boolean> certificateMap,
			ServiceContext serviceContext) {
		try {
			candidate.setUserId(serviceContext.getUserId());
			candidate.setGroupId(serviceContext.getScopeGroupId());
			candidate.setCompanyId(serviceContext.getCompanyId());
			candidate.setCreateDate(new Date(System.currentTimeMillis()));
			candidate.setModifiedDate(new Date(System.currentTimeMillis()));
			candidate.setLocationId(locationId);

			Candidate result = candidatePersistence.update(candidate);
			if (result != null) {
				vacancyCandidateLocalService.addVacancyCandidate(vacancyId,
						result.getCandidateId(),
						VacancyCandidateType.MAIN.toString());
				// add documents for candidate
				for (long fileEntryId : fileEntryIds) {
					DocumentLocalServiceUtil.addDocument(
							Candidate.class.getName(),
							candidate.getCandidateId(), fileEntryId,
							serviceContext);
				}

				// add candidate experiences
				for (Map.Entry<Experience, Boolean> entry : experienceMap
						.entrySet()) {
					final Experience experience = entry.getKey();
					if (!entry.getValue()) {
						experience.setClassPK(result.getCandidateId());
						experienceLocalService.addExperience(experience,
								serviceContext);
					}
				}

				// add candidate certificates
				for (Map.Entry<Certificate, Boolean> entry : certificateMap
						.entrySet()) {
					final Certificate certificate = entry.getKey();
					if (!entry.getValue()) {
						certificate.setClassPK(result.getCandidateId());
						certificateLocalService.addCertificate(certificate,
								serviceContext);
					}
				}

				// add desired positions
				if (desireVacancies.contains(vacancyId)) {
					desireVacancies.remove(vacancyId);
				}
				for (long id : desireVacancies) {
					vacancyCandidateLocalService.addVacancyCandidate(id,
							result.getCandidateId(),
							VacancyCandidateType.OPTIONAL.toString());
				}

				// add permission
				resourceLocalService.addResources(result.getCompanyId(),
						result.getGroupId(), result.getUserId(),
						Candidate.class.getName(), result.getCandidateId(),
						false, true, true);

				// index new employee
				Indexer indexer = IndexerRegistryUtil
						.nullSafeGetIndexer(Candidate.class);
				indexer.reindex(Candidate.class.getName(),
						result.getCandidateId());

				return result;
			}
			return null;
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SearchException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Candidate updateCandidate(Candidate candidate, long vacancyId,
			List<Long> desireVacancies, List<Long> fileEntryIds,
			Map<Experience, Boolean> experienceMap,
			Map<Certificate, Boolean> certificateMap,
			ServiceContext serviceContext) {
		try {
			/*
			 * vacancyCandidateLocalService.setInActivatedByCandidate(candidate
			 * .getCandidateId());
			 * 
			 * final VacancyCandidate vacancyCandidate =
			 * vacancyCandidateLocalService
			 * .findByVacancyAndCandidate(vacancyId,
			 * candidate.getCandidateId()); if (vacancyCandidate != null) {
			 * vacancyCandidate.setStatus(1); vacancyCandidateLocalService
			 * .updateVacancyCandidate(vacancyCandidate); } else {
			 * vacancyCandidateLocalService.addVacancyCandidate(vacancyId,
			 * candidate.getCandidateId(), 1); }
			 */
			long candidateId = candidate.getCandidateId();
			if (vacancyId != 0) {

				List<VacancyCandidate> oldOPTIONALVacancyCandidates = vacancyCandidateLocalService
						.findByCandidateAndType(candidateId,
								VacancyCandidateType.OPTIONAL.toString());
				List<Long> oldOPTIONALVacancyCandidateIds = RCUtils
						.getIdsFromBasedModelList(oldOPTIONALVacancyCandidates);

				// keep same elements
				List<Long> sameElementList = new ArrayList<Long>(
						desireVacancies);
				sameElementList.retainAll(oldOPTIONALVacancyCandidateIds);

				// remove elements
				List<Long> deletedElementList = new ArrayList<Long>(
						oldOPTIONALVacancyCandidateIds);
				deletedElementList.removeAll(sameElementList);

				// new elements
				List<Long> newElementList = new ArrayList<Long>(desireVacancies);
				newElementList.removeAll(sameElementList);

				// remove VacancyCandidate
				for (long id : deletedElementList) {
					vacancyCandidateLocalService.deleteVacancyCandidate(id);
				}

				// add new VacancyCandidate as OPTIONAL/MAIN
				for (long id : newElementList) {
					String type = id != vacancyId ? VacancyCandidateType.OPTIONAL
							.toString() : VacancyCandidateType.MAIN.toString();
					vacancyCandidateLocalService.addVacancyCandidate(id,
							candidateId, type);
				}

				// set new MAIN vacancy
				final List<VacancyCandidate> vacancyCandidates = vacancyCandidateLocalService
						.findByCandidateAndType(candidateId,
								VacancyCandidateType.MAIN.toString());
				VacancyCandidate currentMAINVacancyCandidate = vacancyCandidates != null
						&& !vacancyCandidates.isEmpty() ? vacancyCandidates
						.get(0) : null;
				if (currentMAINVacancyCandidate != null
						&& vacancyId != currentMAINVacancyCandidate
								.getVacancyId())
					vacancyCandidateLocalService
							.deleteVacancyCandidate(currentMAINVacancyCandidate
									.getVacancyCandidateId());

				vacancyCandidateLocalService.addVacancyCandidate(vacancyId,
						candidateId, VacancyCandidateType.MAIN.toString());
			}

			// add candidate experiences
			for (Map.Entry<Experience, Boolean> entry : experienceMap
					.entrySet()) {
				final Experience experience = entry.getKey();
				if (!entry.getValue()) {
					if (experienceLocalService.fetchExperience(experience
							.getExperienceId()) == null) {
						experience.setClassPK(candidate.getCandidateId());
						experienceLocalService.addExperience(experience,
								serviceContext);
					} else {
						experienceLocalService.updateExperience(experience);
					}
				} else {
					if (experienceLocalService.fetchExperience(experience
							.getExperienceId()) != null)
						experienceLocalService.deleteExperience(experience
								.getExperienceId());
				}
			}

			// add/remove certificates
			for (Map.Entry<Certificate, Boolean> entry : certificateMap
					.entrySet()) {
				final Certificate certificate = entry.getKey();
				if (!entry.getValue()) {
					if (certificateLocalService.fetchCertificate(certificate
							.getCertificateId()) == null) {
						certificate.setClassPK(candidate.getCandidateId());
						certificateLocalService.addCertificate(certificate,
								serviceContext);
					} else {
						certificateLocalService.updateCertificate(certificate);
					}
				} else {
					if (certificateLocalService.fetchCertificate(certificate
							.getCertificateId()) != null)
						certificateLocalService.deleteCertificate(certificate
								.getCertificateId());
				}
			}

			for (Long fileEntryId : fileEntryIds) {
				if (DocumentLocalServiceUtil
						.findByClassAndClassPKAndFileEntryId(
								Candidate.class.getName(),
								candidate.getCandidateId(), fileEntryId) == null) {
					DocumentLocalServiceUtil.addDocument(
							Candidate.class.getName(),
							candidate.getCandidateId(), fileEntryId,
							serviceContext);
				}
			}

			candidate.setModifiedDate(new Date(System.currentTimeMillis()));

			candidate = candidatePersistence.update(candidate);

			Indexer indexer = IndexerRegistryUtil.getIndexer(Candidate.class
					.getName());
			indexer.reindex(candidate);

			// add to history
			/*
			 * final CandidateActionHistory candidateActionHistory =
			 * candidateActionHistoryLocalService
			 * .createPrePersistedEntity(candidate.getCandidateId(), "edit",
			 * CandidateActionType.EDIT.toString(), serviceContext.getUserId(),
			 * "", serviceContext); candidateActionHistoryLocalService
			 * .addCandidateActionHistory(candidateActionHistory);
			 */

			return candidate;

		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SearchException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Candidate changeCandidateStatus(Candidate candidate, String status,
			ServiceContext serviceContext) {
		try {
			final String origStatus = candidate.getStatus();
			candidate.setStatus(status);
			candidate = candidateLocalService.updateCandidate(candidate);
			// add to history

			final CandidateActionHistory candidateActionHistory = candidateActionHistoryLocalService
					.createPrePersistedEntity(
							candidate.getCandidateId(),
							"StatusChanged: " + origStatus + "-> " + status,
							CandidateHistoryActionType.CHANGE_STATUS.toString(),
							serviceContext.getUserId(), "", serviceContext);
			candidateActionHistoryLocalService
					.addCandidateActionHistory(candidateActionHistory);

			return candidate;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Candidate changeCandidateStatus(long candidateId, String status,
			ServiceContext serviceContext) {
		try {
			Candidate candidate = fetchCandidate(candidateId);
			return changeCandidateStatus(candidate, status, serviceContext);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * @Override public Candidate updateCandidate(Candidate candidate) throws
	 * SystemException { Candidate c = super.updateCandidate(candidate); //
	 * index new employee Indexer indexer =
	 * IndexerRegistryUtil.getIndexer(Candidate.class); try {
	 * indexer.reindex(c); } catch (SearchException e) { e.printStackTrace(); }
	 * return c; }
	 */

	public Candidate markDeleted(Candidate candidate,
			ServiceContext serviceContext) {
		try {
			candidate.setDeleted(true);
			candidate = candidatePersistence.update(candidate);
			// index new employee
			Indexer indexer = IndexerRegistryUtil.getIndexer(Candidate.class
					.getName());

			indexer.reindex(candidate);

			/*
			 * final CandidateActionHistory candidateActionHistory =
			 * candidateActionHistoryLocalService
			 * .createPrePersistedEntity(candidate.getCandidateId(),
			 * "Marked Deleted", CandidateActionType.REMOVE.toString(),
			 * serviceContext.getUserId(), "", serviceContext);
			 * candidateActionHistoryLocalService
			 * .addCandidateActionHistory(candidateActionHistory);
			 */

			return candidate;
		} catch (SearchException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Candidate markDeleted(long candidateId, ServiceContext serviceContext) {
		try {
			Candidate candidate = fetchCandidate(candidateId);
			markDeleted(candidate, serviceContext);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int countAllUnDeletedIndexedCandidateDocuments(
			SearchContext searchContext, List<Query> filterQueries,
			long companyId, Sort sort) {
		return searchAllUnDeletedCandidatesIndexedDocument(searchContext,
				filterQueries, companyId, sort, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS).size();
	}

	public List<Document> searchAllUnDeletedCandidatesIndexedDocument(
			SearchContext searchContext, List<Query> filterQueries,
			long companyId, Sort sort, int start, int end) {

		LOGGER.info("FilterQueries size: " + filterQueries.size());
		final BooleanQuery fullQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		final BooleanQuery allCandidateEntriesBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		final BooleanQuery noneDeletedCandidateBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		allCandidateEntriesBooleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				Candidate.class.getName());
		noneDeletedCandidateBooleanQuery.addExactTerm(
				CandidateField.IS_DELETED, "false");

		try {
			// add filter queries
			fullQuery.add(allCandidateEntriesBooleanQuery,
					BooleanClauseOccur.MUST);
			if (filterQueries != null && filterQueries.size() > 0) {
				for (Query query : filterQueries) {
					fullQuery.add(query, BooleanClauseOccur.MUST);
				}
			}

			// always filter for none-delete item
			fullQuery.add(noneDeletedCandidateBooleanQuery,
					BooleanClauseOccur.MUST);

			return SearchEngineUtil.search(
					SearchEngineUtil.getDefaultSearchEngineId(), companyId,
					fullQuery, sort, start, end).toList();
		} catch (SearchException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Document> searchAllUnDeletedEmployeeIndexedDocument1(
			SearchContext searchContext, List<Query> filterQueries,
			long companyId, Sort sort, int start, int end) {
		try {
			BooleanQuery fQuery = BooleanQueryFactoryUtil.create(searchContext);

			fQuery.addTerm("*", "*");
			/*
			 * final BooleanQuery allEmployeeEntriesBooleanQuery =
			 * BooleanQueryFactoryUtil .create(searchContext);
			 * 
			 * allEmployeeEntriesBooleanQuery.addRequiredTerm(
			 * Field.ENTRY_CLASS_NAME, Employee.class.getName());
			 * 
			 * fQuery.add(allEmployeeEntriesBooleanQuery,
			 * BooleanClauseOccur.MUST);
			 */
			List<Document> documents = SearchEngineUtil.search(searchContext,
					fQuery).toList();

			return documents;
		} catch (SearchException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Document getIndexCandidateDocument(long id,
			SearchContext searchContext) {
		searchContext.setPortletIds(new String[] { ECO_RCUtils.PORTLET_ID });
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				Candidate.class.getName());
		booleanQuery.addExactTerm(CandidateField.CANDIDATE_ID, id);

		try {
			fullQuery.add(booleanQuery, BooleanClauseOccur.MUST);
			Hits hits = SearchEngineUtil.search(searchContext, fullQuery);
			return !hits.toList().isEmpty() ? hits.toList().get(0) : null;
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SearchException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Document getIndexCandidateDocument(String id,
			SearchContext searchContext) {
		return getIndexCandidateDocument(Long.valueOf(id), searchContext);
	}

	public void indexAllCandidates() {
		final Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(Candidate.class);
		final List<Candidate> items = findAll();
		for (Candidate candidate : items) {
			// index employee
			try {
				indexer.reindex(candidate);
			} catch (SearchException e) {
				e.printStackTrace();
			}
		}
	}

	public void removeAllCandidateIndexes(SearchContext searchContext,
			long companyId) {
		final BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		booleanQuery.addExactTerm(Field.ENTRY_CLASS_NAME,
				Candidate.class.getName());
		try {
			final Hits hits = SearchEngineUtil.search(
					SearchEngineUtil.getDefaultSearchEngineId(), companyId,
					booleanQuery, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			final List<Document> docs = hits.toList();
			for (Document doc : docs) {
				SearchEngineUtil.deleteDocument(
						SearchEngineUtil.getDefaultSearchEngineId(), companyId,
						doc.getUID());

			}
		} catch (SearchException e) {
			e.printStackTrace();
		}
	}

	public boolean hasAlreadyScheduleForInterview(long candidateId,
			long vacancyId, long interviewId) {
		final VacancyCandidate vacancyCandidate = VacancyCandidateLocalServiceUtil
				.findByVacancyAndCandidate(vacancyId, candidateId);

		return hasAlreadyScheduleForInterview(
				vacancyCandidate.getVacancyCandidateId(), interviewId);
	}

	public boolean hasAlreadyScheduleForInterview(long vacancyCandidateId,
			long interviewId) {

		try {
			return interviewSchedulePersistence
					.fetchByVacancyCandidateAndInterview(vacancyCandidateId,
							interviewId) != null;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return false;
	}

}