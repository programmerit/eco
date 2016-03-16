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
import java.util.Map;

import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.constant.CandidateField;
import vn.com.ecopharma.hrm.rc.constant.ECO_RCUtils;
import vn.com.ecopharma.hrm.rc.constant.VacancyField;
import vn.com.ecopharma.hrm.rc.enumeration.VacancyCandidateType;
import vn.com.ecopharma.hrm.rc.enumeration.VacancyStatus;
import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.model.VacancyCandidate;
import vn.com.ecopharma.hrm.rc.service.base.VacancyLocalServiceBaseImpl;

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
 * The implementation of the vacancy local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.hrm.rc.service.VacancyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.base.VacancyLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil
 */
public class VacancyLocalServiceImpl extends VacancyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil} to access the
	 * vacancy local service.
	 */

	private static final Log LOGGER = LogFactoryUtil
			.getLog(VacancyLocalServiceImpl.class);

	public List<Vacancy> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<Vacancy> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<Vacancy> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return vacancyPersistence.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<Vacancy> findAllUnDeleted() {
		try {
			return vacancyPersistence.findByUnDeleted(false);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public int countAllUnDeletedIndexedVacancyDocuments(
			SearchContext searchContext, List<Query> filterQueries,
			long companyId, Sort sort) {
		return searchAllUnDeletedVacanciesIndexedDocument(searchContext,
				filterQueries, companyId, sort, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS).size();
	}

	public List<Document> searchAllUnDeletedVacanciesIndexedDocument(
			SearchContext searchContext, List<Query> filterQueries,
			long companyId, Sort sort, int start, int end) {

		final BooleanQuery fullQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		final BooleanQuery allVacancyEntriesBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		final BooleanQuery noneDeletedVacancyBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		allVacancyEntriesBooleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				Vacancy.class.getName());
		noneDeletedVacancyBooleanQuery.addExactTerm(VacancyField.IS_DELETED,
				"false");

		try {
			// add filter queries
			fullQuery.add(allVacancyEntriesBooleanQuery,
					BooleanClauseOccur.MUST);
			if (filterQueries != null && filterQueries.size() > 0) {
				for (Query query : filterQueries) {
					fullQuery.add(query, BooleanClauseOccur.MUST);
				}
			}

			// always filter for none-delete item
			fullQuery.add(noneDeletedVacancyBooleanQuery,
					BooleanClauseOccur.MUST);

			/* SORT */
			if (sort == null) {
				sort = new Sort(CandidateField.VACANCY_ID, false);
			}

			return SearchEngineUtil.search(
					SearchEngineUtil.getDefaultSearchEngineId(), companyId,
					fullQuery, sort, start, end).toList();
		} catch (SearchException e) {
			LOGGER.info(e);
		} catch (ParseException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public int countAllUnDeletedAndPublishedIndexedVacancyDocuments(
			SearchContext searchContext, List<Query> filterQueries,
			long companyId, Sort sort) {
		return searchAllUnDeletedAndPublishedVacanciesIndexedDocument(
				searchContext, filterQueries, companyId, sort,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS).size();
	}

	public List<Document> searchAllUnDeletedAndPublishedVacanciesIndexedDocument(
			SearchContext searchContext, List<Query> filterQueries,
			long companyId, Sort sort, int start, int end) {
		BooleanQuery publishedStatusBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		publishedStatusBooleanQuery.addExactTerm(VacancyField.STATUS,
				VacancyStatus.PUBLISHED.toString());
		filterQueries.add(publishedStatusBooleanQuery);
		return searchAllUnDeletedVacanciesIndexedDocument(searchContext,
				filterQueries, companyId, sort, start, end);
	}

	@SuppressWarnings("unchecked")
	public List<Document> filterByFields(SearchContext searchContext,
			Map<String, Object> filters, Sort sort, long companyId, int start,
			int end) throws ParseException {
		final List<Query> queries = new ArrayList<>();

		for (Map.Entry<String, Object> filter : filters.entrySet()) {
			String filterProperty = filter.getKey();
			Object filterValue = filter.getValue();

			if (filterValue instanceof String) {
				if (filterProperty.equalsIgnoreCase(VacancyField.GLOBAL)) {
					final BooleanQuery globalFilterBooleanQuery = BooleanQueryFactoryUtil
							.create(searchContext);
					globalFilterBooleanQuery.addTerms(
							getGlobalSearchableFields(), (String) filterValue,
							true);
					queries.add(globalFilterBooleanQuery);
				} else if (filterProperty
						.equalsIgnoreCase(CandidateField.APPLY_DATE_FROM)
						|| filterProperty
								.equalsIgnoreCase(CandidateField.APPLY_DATE_TO)) {
					// final String dateFrom = filters
					// .get(CandidateField.APPLY_DATE_FROM) != null ? (String)
					// filters
					// .get(CandidateField.APPLY_DATE_FROM)
					// : StringUtils.EMPTY;
					// final String dateTo = filters
					// .get(CandidateField.APPLY_DATE_TO) != null ? (String)
					// filters
					// .get(CandidateField.APPLY_DATE_TO)
					// : StringUtils.EMPTY;
					//
					// EmpLocalServiceUtil.createDateTermRangeQuery(
					// CandidateField.APPLICATION_DATE, queries, dateFrom,
					// dateTo, searchContext);
					// Query dateRangeQuery =
					// candidateLocalService.createDateTermRangeQuery(filterProperty,
					// dateFrom, dateTo, searchContext)
				} else {
					BooleanQuery stringFilterQuery = BooleanQueryFactoryUtil
							.create(searchContext);
					stringFilterQuery
							.addTerm(filterProperty, (String) filterValue,
									true, BooleanClauseOccur.MUST);
					queries.add(stringFilterQuery);
				}
			} else if (filterValue instanceof List<?>) {
				queries.add(EmpLocalServiceUtil.createStringListQuery(
						filterProperty, (List<String>) filterValue,
						searchContext));
			}
		}
		return searchAllUnDeletedVacanciesIndexedDocument(searchContext,
				queries, companyId, sort, start, end);
	}

	public int countFilterByFields(SearchContext searchContext,
			Map<String, Object> filters, Sort sort, long companyId)
			throws ParseException {
		return filterByFields(searchContext, filters, sort, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS).size();
	}

	private String[] getGlobalSearchableFields() {
		return new String[] { VacancyField.TITLES,
				VacancyField.NUMBER_OF_POSITION, VacancyField.STATUS };
	}

	public Vacancy createPrePersistedVacancy() {
		try {
			final long id = counterLocalService.increment();
			return vacancyPersistence.create(id);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Vacancy createPrePersistedVacancy(String vacancyCode, String name,
			int numberOfPosition, long titlesId, String description,
			Date postedDate, Date expiredDate, String status) {
		final Vacancy vacancy = createPrePersistedVacancy();
		vacancy.setCode(vacancyCode);
		vacancy.setTitlesId(titlesId);
		vacancy.setDescription(description);
		vacancy.setPostedDate(postedDate);
		vacancy.setExpiredDate(expiredDate);
		vacancy.setStatus(status);
		return vacancy;
	}

	public Vacancy addVacancy(Vacancy vacancy, List<Long> fileEntryIds,
			ServiceContext serviceContext) {
		try {
			vacancy.setUserId(serviceContext.getUserId());
			vacancy.setGroupId(serviceContext.getScopeGroupId());
			vacancy.setCompanyId(serviceContext.getCompanyId());
			vacancy.setCreateDate(new Date());
			vacancy.setModifiedDate(new Date());
			Vacancy result = super.addVacancy(vacancy);
			// add permission
			resourceLocalService.addResources(vacancy.getCompanyId(),
					vacancy.getGroupId(), vacancy.getUserId(),
					Vacancy.class.getName(), vacancy.getVacancyId(), false,
					true, true);

			// add documents for candidate

			// index new employee
			Indexer indexer = IndexerRegistryUtil
					.nullSafeGetIndexer(Vacancy.class);
			indexer.reindex(Vacancy.class.getName(), result.getVacancyId());

			return result;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Vacancy updateVacancy(Vacancy vacancy, List<Long> fileEntryIds,
			ServiceContext serviceContext) {
		try {
			for (Long fileEntryId : fileEntryIds) {
				// if (DocumentLocalServiceUtil
				// .findByClassAndClassPKAndFileEntryId(
				// Vacancy.class.getName(),
				// vacancy.getVacancyId(), fileEntryId) == null) {
				// DocumentLocalServiceUtil.addDocument(
				// Vacancy.class.getName(), vacancy.getVacancyId(),
				// fileEntryId, serviceContext);
				// }
			}

			vacancy.setModifiedDate(new Date());

			vacancy = super.updateVacancy(vacancy);

			Indexer indexer = IndexerRegistryUtil.getIndexer(Vacancy.class
					.getName());
			indexer.reindex(vacancy);

			return vacancy;
		} catch (SearchException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Vacancy getVacancyByCandidateId(long candidateId) {
		try {
			final List<VacancyCandidate> vacancyCandidates = vacancyCandidateLocalService
					.findByCandidateAndType(candidateId,
							VacancyCandidateType.MAIN.toString());
			return vacancyCandidates != null && !vacancyCandidates.isEmpty() ? fetchVacancy(vacancyCandidates
					.get(0).getVacancyId()) : null;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Document getIndexVacancyDocument(long id, SearchContext searchContext) {
		searchContext.setPortletIds(new String[] { ECO_RCUtils.PORTLET_ID });
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				Vacancy.class.getName());
		booleanQuery.addExactTerm(VacancyField.VACANCY_ID, id);

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

	public Document getIndexVacancyDocument(String id,
			SearchContext searchContext) {
		return getIndexVacancyDocument(Long.valueOf(id), searchContext);
	}

	public Document getUndeletedIndexVacancyDocument(long id,
			SearchContext searchContext) {
		searchContext.setPortletIds(new String[] { ECO_RCUtils.PORTLET_ID });
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		BooleanQuery noneDeletedVacancyBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				Vacancy.class.getName());
		booleanQuery.addExactTerm(VacancyField.VACANCY_ID, id);

		noneDeletedVacancyBooleanQuery.addExactTerm(VacancyField.IS_DELETED,
				"false");
		try {
			fullQuery.add(booleanQuery, BooleanClauseOccur.MUST);
			fullQuery.add(noneDeletedVacancyBooleanQuery,
					BooleanClauseOccur.MUST);
			Hits hits = SearchEngineUtil.search(searchContext, fullQuery);
			return !hits.toList().isEmpty() ? hits.toList().get(0) : null;
		} catch (ParseException e) {
			LOGGER.info(e);
		} catch (SearchException e) {
			LOGGER.info(e);
		}

		return null;
	}

	public Vacancy markDeleted(long id) {
		try {
			return markDeleted(vacancyPersistence.fetchByPrimaryKey(id));
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Vacancy markDeleted(Vacancy vacancy) {
		try {
			vacancy.setDeleted(true);
			vacancy = vacancyPersistence.update(vacancy);
			final Indexer indexer = IndexerRegistryUtil
					.getIndexer(Vacancy.class.getName());
			indexer.reindex(vacancy);
			return vacancy;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (SearchException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public void indexAllVacancies() {
		final Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(Vacancy.class);
		final List<Vacancy> items = findAll();
		for (Vacancy vacancy : items) {
			// index vacancy
			try {
				indexer.reindex(vacancy);
			} catch (SearchException e) {
				LOGGER.info(e);
			}
		}
	}

	public void removeAllVacanciesIndexes(SearchContext searchContext,
			long companyId) {
		final BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		booleanQuery.addExactTerm(Field.ENTRY_CLASS_NAME,
				Vacancy.class.getName());
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
}