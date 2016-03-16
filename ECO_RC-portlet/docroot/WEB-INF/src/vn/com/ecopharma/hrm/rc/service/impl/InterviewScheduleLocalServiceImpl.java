/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

import vn.com.ecopharma.emp.model.Employee;
import vn.com.ecopharma.hrm.rc.NoSuchInterviewScheduleException;
import vn.com.ecopharma.hrm.rc.constant.ECO_RCUtils;
import vn.com.ecopharma.hrm.rc.constant.InterviewScheduleField;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateStatus;
import vn.com.ecopharma.hrm.rc.enumeration.InterviewScheduleStatus;
import vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule;
import vn.com.ecopharma.hrm.rc.model.InterviewSchedule;
import vn.com.ecopharma.hrm.rc.model.VacancyCandidate;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.base.InterviewScheduleLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
 * The implementation of the interview schedule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.base.InterviewScheduleLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalServiceUtil
 */
public class InterviewScheduleLocalServiceImpl extends
		InterviewScheduleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalServiceUtil} to
	 * access the interview schedule local service.
	 */

	private static final Log LOGGER = LogFactoryUtil
			.getLog(InterviewScheduleLocalServiceImpl.class);

	public List<InterviewSchedule> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<InterviewSchedule> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<InterviewSchedule> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return interviewSchedulePersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public InterviewSchedule findByVacancyCandidateAndInterview(
			long vacancyCandidateId, long interviewId) {
		try {
			return interviewSchedulePersistence
					.findByVacancyCandidateAndInterview(vacancyCandidateId,
							interviewId);
		} catch (NoSuchInterviewScheduleException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public InterviewSchedule findByVacancyCandidateAndStatus(
			long vacancyCandidateId, String status) {
		try {
			return interviewSchedulePersistence
					.findByVacancyCandidateAndStatus(vacancyCandidateId, status);
		} catch (NoSuchInterviewScheduleException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public InterviewSchedule findInProgressByVacancyCandidate(
			long vacancyCandidateId) {
		return findByVacancyCandidateAndStatus(vacancyCandidateId,
				InterviewScheduleStatus.PROCESSING.toString());
	}

	public List<InterviewSchedule> findByVacancyCandidate(
			long vacancyCandidateId) {
		try {
			return interviewSchedulePersistence
					.findByVacancyCandidate(vacancyCandidateId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<Long> findInterviewIdsByVacancyCandidate(long vacancyCandidateId) {
		final List<Long> results = new ArrayList<Long>();
		for (InterviewSchedule i : findByVacancyCandidate(vacancyCandidateId)) {
			results.add(i.getInterviewId());
		}
		return results;
	}

	@Deprecated
	public InterviewSchedule addInterviewSchedule(
			InterviewSchedule interviewSchedule,
			VacancyCandidate vacancyCandidate, List<Employee> interviewers,
			ServiceContext serviceContext) {
		try {
			interviewSchedule.setCompanyId(serviceContext.getCompanyId());
			interviewSchedule.setGroupId(serviceContext.getScopeGroupId());
			interviewSchedule.setUserId(serviceContext.getUserId());
			interviewSchedule
					.setCreateDate(new Date(System.currentTimeMillis()));
			interviewSchedule.setModifiedDate(new Date(System
					.currentTimeMillis()));
			interviewSchedule = interviewSchedulePersistence
					.update(interviewSchedule);
			for (Employee employee : interviewers) {
				EmployeeInterviewSchedule employeeInterviewSchedule = employeeInterviewScheduleLocalService
						.createPrePersitedEntity();
				employeeInterviewSchedule.setEmployeeId(employee
						.getEmployeeId());
				employeeInterviewSchedule
						.setInterviewScheduleId(interviewSchedule
								.getInterviewScheduleId());
			}
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public InterviewSchedule addInterviewSchedule(
			InterviewSchedule interviewSchedule, long vacancyCandidateId,
			List<Long> interviewers, long candidateId,
			ServiceContext serviceContext) {
		interviewSchedule.setCompanyId(serviceContext.getCompanyId());
		interviewSchedule.setGroupId(serviceContext.getScopeGroupId());
		interviewSchedule.setUserId(serviceContext.getUserId());
		interviewSchedule.setCreateDate(new Date(System.currentTimeMillis()));
		interviewSchedule.setModifiedDate(new Date(System.currentTimeMillis()));
		// interviewSchedule.setStatus(InterviewScheduleStatus.PROCESSING
		// .toString()); //TODO ??? java.lang.StackOverflowError

		interviewSchedule.setStatus(InterviewScheduleStatus.PROCESSING
				.toString());
		try {
			interviewSchedule = interviewSchedulePersistence
					.update(interviewSchedule);

			for (Long employeeId : interviewers) {
				EmployeeInterviewSchedule employeeInterviewSchedule = employeeInterviewScheduleLocalService
						.createPrePersitedEntity();
				employeeInterviewSchedule.setCompanyId(serviceContext
						.getCompanyId());
				employeeInterviewSchedule.setGroupId(serviceContext
						.getScopeGroupId());
				employeeInterviewSchedule.setUserId(serviceContext.getUserId());
				employeeInterviewSchedule.setCreateDate(new Date(System
						.currentTimeMillis()));
				employeeInterviewSchedule.setModifiedDate(new Date(System
						.currentTimeMillis()));
				employeeInterviewSchedule.setEmployeeId(employeeId);
				employeeInterviewSchedule
						.setInterviewScheduleId(interviewSchedule
								.getInterviewScheduleId());
				employeeInterviewSchedule = employeeInterviewScheduleLocalService
						.updateEmployeeInterviewSchedule(employeeInterviewSchedule);
			}
			candidateLocalService.changeCandidateStatus(candidateId,
					CandidateStatus.INTERVIEW_SCHEDULED.toString(),
					serviceContext);

			// add resource
			resourceLocalService.addResources(interviewSchedule.getCompanyId(),
					interviewSchedule.getGroupId(),
					interviewSchedule.getUserId(),
					InterviewSchedule.class.getName(),
					interviewSchedule.getInterviewScheduleId(), false, true,
					true);

			// index
			Indexer indexer = IndexerRegistryUtil
					.getIndexer(InterviewSchedule.class.getName());
			indexer.reindex(interviewSchedule);

			return interviewSchedule;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public InterviewSchedule updateInterviewSchedule(
			InterviewSchedule interviewSchedule) {
		try {
			interviewSchedule = super
					.updateInterviewSchedule(interviewSchedule);
			Indexer indexer = IndexerRegistryUtil
					.getIndexer(InterviewSchedule.class.getName());
			indexer.reindex(interviewSchedule);
			return interviewSchedule;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (SearchException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public InterviewSchedule setInterviewStatusByCandidateStatus(
			String candidateStatus, long candidateId,
			InterviewSchedule interviewSchedule, ServiceContext serviceContext) {
		if (candidateStatus
				.equalsIgnoreCase(CandidateStatus.MARK_INTERVIEW_PASS
						.toString())) {
			return markInterviewPass(candidateId, interviewSchedule,
					serviceContext);
		} else {
			return markInterviewFail(candidateId, interviewSchedule,
					serviceContext);
		}
	}

	public InterviewSchedule markInterviewFail(long candidateId,
			InterviewSchedule interviewSchedule, ServiceContext serviceContext) {
		interviewSchedule.setStatus(InterviewScheduleStatus.FAILED.toString());
		InterviewSchedule result = updateInterviewSchedule(interviewSchedule);
		if (result != null) {
			CandidateLocalServiceUtil.changeCandidateStatus(candidateId,
					CandidateStatus.MARK_INTERVIEW_FAIL.toString(),
					serviceContext);
		}
		return result;
	}

	public InterviewSchedule markInterviewPass(long candidateId,
			InterviewSchedule interviewSchedule, ServiceContext serviceContext) {
		interviewSchedule.setStatus(InterviewScheduleStatus.PASSED.toString());
		InterviewSchedule result = updateInterviewSchedule(interviewSchedule);
		if (result != null) {
			CandidateLocalServiceUtil.changeCandidateStatus(candidateId,
					CandidateStatus.MARK_INTERVIEW_PASS.toString(),
					serviceContext);
		}
		return result;
	}

	public InterviewSchedule createPrePersitedEntity() {
		try {
			final long id = counterLocalService.increment();
			final InterviewSchedule interviewSchedule = interviewSchedulePersistence
					.create(id);
			interviewSchedule.setInterviewDate(new Date());
			return interviewSchedule;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public int countAllIndexedDocuments(SearchContext searchContext,
			List<Query> filterQueries, long companyId, Sort sort) {
		return searchAllIndexedDocuments(searchContext, filterQueries,
				companyId, sort, QueryUtil.ALL_POS, QueryUtil.ALL_POS).size();
	}

	public List<Document> searchAllIndexedDocuments(
			SearchContext searchContext, List<Query> filterQueries,
			long companyId, Sort sort, int start, int end) {

		final BooleanQuery fullQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		final BooleanQuery allEntriesBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		allEntriesBooleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				InterviewSchedule.class.getName());

		try {
			// add filter queries
			fullQuery.add(allEntriesBooleanQuery, BooleanClauseOccur.MUST);
			if (filterQueries != null && !filterQueries.isEmpty()) {
				for (Query query : filterQueries) {
					fullQuery.add(query, BooleanClauseOccur.MUST);
				}
			}
			// always sort by ID if no specific sort set
			final Sort s = sort != null ? sort : new Sort(
					InterviewScheduleField.ID, false);
			return SearchEngineUtil.search(
					SearchEngineUtil.getDefaultSearchEngineId(), companyId,
					fullQuery, s, start, end).toList();
		} catch (SearchException e) {
			LOGGER.info(e);
		} catch (ParseException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<Document> searchByVacancyCandidateId(
			SearchContext searchContext, long vacancyCandidateId, long companyId) {
		List<Query> queries = new ArrayList<Query>();
		final BooleanQuery vacancyCandidateBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		vacancyCandidateBooleanQuery
				.addExactTerm(InterviewScheduleField.VACANCY_CANDIDATE_ID,
						vacancyCandidateId);

		queries.add(vacancyCandidateBooleanQuery);
		return searchAllIndexedDocuments(searchContext, queries, companyId,
				null, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<Long> getAllInterviewRoundIdsByVacancyCandidateId(
			SearchContext searchContext, long vacancyCandidateId, long companyId) {
		final List<Document> interviewScheduleDocs = searchByVacancyCandidateId(
				searchContext, vacancyCandidateId, companyId);
		final List<Long> results = new ArrayList<Long>(
				interviewScheduleDocs.size());
		for (Document doc : interviewScheduleDocs) {
			results.add(Long.valueOf(doc.getField(
					InterviewScheduleField.INTERVIEW_ID).getValue()));
		}
		return results;
	}

	public void indexAll() {
		final Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(InterviewSchedule.class);
		final List<InterviewSchedule> items = findAll();
		for (InterviewSchedule item : items) {
			try {
				indexer.reindex(item);
			} catch (SearchException e) {
				LOGGER.info(e);
			}
		}
	}

	public void removeAllIndexes(SearchContext searchContext, long companyId) {
		final BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		booleanQuery.addExactTerm(Field.ENTRY_CLASS_NAME,
				InterviewSchedule.class.getName());
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
			LOGGER.info(e);
		}
	}

	public Document getIndexDocument(long id, SearchContext searchContext) {
		searchContext.setPortletIds(new String[] { ECO_RCUtils.PORTLET_ID });
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				InterviewSchedule.class.getName());
		booleanQuery.addExactTerm(InterviewScheduleField.ID, id);

		try {
			fullQuery.add(booleanQuery, BooleanClauseOccur.MUST);
			Hits hits = SearchEngineUtil.search(searchContext, fullQuery);
			return !hits.toList().isEmpty() ? hits.toList().get(0) : null;
		} catch (ParseException e) {
			LOGGER.info(e);
		} catch (SearchException e) {
			LOGGER.info(e);
		}

		return null;
	}
}