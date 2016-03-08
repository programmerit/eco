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

package vn.com.ecopharma.emp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import vn.com.ecopharma.emp.constant.EMInfo;
import vn.com.ecopharma.emp.constant.ResignationHistoryField;
import vn.com.ecopharma.emp.enumeration.EmployeeStatus;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.ResignationHistory;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.base.ResignationHistoryLocalServiceBaseImpl;

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
 * The implementation of the resignation history local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.ResignationHistoryLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.ResignationHistoryLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.ResignationHistoryLocalServiceUtil
 */
public class ResignationHistoryLocalServiceImpl extends
		ResignationHistoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.ResignationHistoryLocalServiceUtil} to
	 * access the resignation history local service.
	 */
	public static final Log LOGGER = LogFactoryUtil
			.getLog(ResignationHistoryLocalServiceImpl.class);

	public List<ResignationHistory> findAll() {
		try {
			return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<ResignationHistory> findAll(int start, int end)
			throws SystemException {
		return findAll(start, end, null);
	}

	public List<ResignationHistory> findAll(int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return resignationHistoryPersistence.findAll(start, end,
				orderByComparator);
	}

	public List<ResignationHistory> findByEmployee(long employeeId) {
		try {
			return resignationHistoryPersistence.findByEmployee(employeeId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public ResignationHistory createPrePersisted() {
		try {
			long id = counterLocalService.increment();
			ResignationHistory resignationHistory = resignationHistoryPersistence
					.create(id);
			resignationHistory.setResignedDate(new Date());
			return resignationHistory;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public ResignationHistory addResignationHistory(
			ResignationHistory resignationHistory, ServiceContext serviceContext) {
		try {
			resignationHistory.setCompanyId(serviceContext.getCompanyId());
			resignationHistory.setGroupId(serviceContext.getScopeGroupId());
			resignationHistory.setCreateDate(new Date());
			resignationHistory.setModifiedDate(new Date());
			resignationHistory = super
					.addResignationHistory(resignationHistory);
			if (resignationHistory != null) {
				// add permission
				resourceLocalService.addResources(
						resignationHistory.getCompanyId(),
						resignationHistory.getGroupId(),
						resignationHistory.getUserId(),
						ResignationHistory.class.getName(),
						resignationHistory.getResignationHistoryId(), false,
						true, true);

				// index new resignationHistory
				Indexer indexer = IndexerRegistryUtil
						.nullSafeGetIndexer(ResignationHistory.class);
				indexer.reindex(ResignationHistory.class.getName(),
						resignationHistory.getResignationHistoryId());

				// update employee status
				Emp employee = EmpLocalServiceUtil.getEmp(resignationHistory
						.getEmployeeId());
				employee.setResignedDate(resignationHistory.getResignedDate());
				employee.setStatus(EmployeeStatus.RESIGNED.toString());
				empLocalService.updateEmp(employee);

			}
			return resignationHistory;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public ResignationHistory updateResignationHistory(
			long resignationHistoryId, Date resignedDate, String resignedType,
			String comment) {
		try {
			ResignationHistory resignationHistory = super
					.fetchResignationHistory(resignationHistoryId);

			resignationHistory.setResignedDate(resignedDate);
			resignationHistory.setResignedType(resignedType);
			resignationHistory.setComment(comment);

			resignationHistory.setModifiedDate(new Date());
			resignationHistory = super
					.updateResignationHistory(resignationHistory);
			if (resignationHistory != null) {
				// add permission
				resourceLocalService.addResources(
						resignationHistory.getCompanyId(),
						resignationHistory.getGroupId(),
						resignationHistory.getUserId(),
						ResignationHistory.class.getName(),
						resignationHistory.getResignationHistoryId(), false,
						true, true);

				// index new resignationHistory
				Indexer indexer = IndexerRegistryUtil
						.nullSafeGetIndexer(ResignationHistory.class);
				indexer.reindex(ResignationHistory.class.getName(),
						resignationHistory.getResignationHistoryId());

				// update employee status
				Emp employee = EmpLocalServiceUtil.getEmp(resignationHistory
						.getEmployeeId());
				employee.setStatus(EmployeeStatus.RESIGNED.toString());
				empLocalService.updateEmp(employee);

			}
			return resignationHistory;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public ResignationHistory markDeleted(ResignationHistory resignationHistory) {
		try {
			resignationHistory.setDeleted(true);

			resignationHistory = resignationHistoryPersistence
					.update(resignationHistory);

			// re-index modified employee
			Indexer indexer = IndexerRegistryUtil
					.nullSafeGetIndexer(ResignationHistory.class.getName());
			indexer.reindex(resignationHistory);
			return resignationHistory;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (SearchException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public int countSearchAllDocuments(SearchContext searchContext,
			List<Query> filterQueries, long companyId, Sort sort) {
		return searchAllDocuments(searchContext, filterQueries, companyId,
				sort, QueryUtil.ALL_POS, QueryUtil.ALL_POS).size();
	}

	public List<Document> searchAllDocuments(SearchContext searchContext,
			List<Query> filterQueries, long companyId, Sort sort, int start,
			int end) {

		LOGGER.info("FilterQueries size: " + filterQueries.size());
		final BooleanQuery fullQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		final BooleanQuery allEmployeeEntriesBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		final BooleanQuery noneDeletedEmployeesBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		allEmployeeEntriesBooleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				ResignationHistory.class.getName());
		noneDeletedEmployeesBooleanQuery.addExactTerm(
				ResignationHistoryField.IS_DELETED, "false");

		try {
			// add filter queries
			fullQuery.add(allEmployeeEntriesBooleanQuery,
					BooleanClauseOccur.MUST);
			if (filterQueries != null && filterQueries.size() > 0) {
				for (Query query : filterQueries) {
					fullQuery.add(query, BooleanClauseOccur.MUST);
				}
			}

			// always filter for none-delete item
			fullQuery.add(noneDeletedEmployeesBooleanQuery,
					BooleanClauseOccur.MUST);

			final List<Document> documents = SearchEngineUtil.search(
					SearchEngineUtil.getDefaultSearchEngineId(), companyId,
					fullQuery, sort, start, end).toList();
			return documents;

		} catch (SearchException e) {
			LOGGER.info(e);
		} catch (ParseException e) {
			LOGGER.info(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Document> filterByFields(SearchContext searchContext,
			Map<String, Object> filters, Sort sort, long companyId, int start,
			int end) throws ParseException {
		final List<Query> queries = new ArrayList<>();
		if (filters != null) {
			// Date effectiveDateFrom = filters
			// .get(EmpDisciplineField.EFFECTIVE_DATE_FROM) != null ? (Date)
			// filters
			// .get(EmpDisciplineField.EFFECTIVE_DATE_FROM) : null;
			//
			// Date effectiveDateTo = filters
			// .get(EmpDisciplineField.EFFECTIVE_DATE_TO) != null ? (Date)
			// filters
			// .get(EmpDisciplineField.EFFECTIVE_DATE_TO) : null;
			for (Map.Entry<String, Object> filter : filters.entrySet()) {
				final String filterProperty = filter.getKey();
				final Object filterValue = filter.getValue();
				LOGGER.info("Filter Property: " + filterProperty);

				if (filterValue instanceof String) {
					LOGGER.info("Filter Property Value: " + filterValue);
					// TODO
					BooleanQuery stringFilterQuery = BooleanQueryFactoryUtil
							.create(searchContext);
					stringFilterQuery
							.addTerm(filterProperty, (String) filterValue,
									true, BooleanClauseOccur.MUST);
					queries.add(stringFilterQuery);

				} else if (filterValue instanceof List<?>) {
					queries.add(empLocalService.createStringListQuery(
							filterProperty, (List<String>) filterValue,
							searchContext));
				} else if (filterValue instanceof Date) {
					// Query effectiveDateQuery = empLocalService
					// .createDateTermRangeQuery(
					// EmpDisciplineField.EFFECTIVE_DATE,
					// effectiveDateFrom, effectiveDateTo, true,
					// true, searchContext);
					// if (effectiveDateQuery != null) {
					// queries.add(effectiveDateQuery);
					// }
				}
			}
		}
		/* SORT */
		if (sort == null) {
			sort = new Sort(ResignationHistoryField.ID, false);
		}
		return searchAllDocuments(searchContext, queries, companyId, sort,
				start, end);
	}

	public int countFilterByFields(SearchContext searchContext,
			Map<String, Object> filters, Sort sort, long companyId)
			throws ParseException {
		return filterByFields(searchContext, filters, sort, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS).size();
	}

	public Document getIndexedDocument(String id, SearchContext searchContext) {
		return getIndexedDocument(Long.valueOf(id), searchContext);
	}

	public Document getIndexedDocument(long id, SearchContext searchContext) {
		searchContext.setPortletIds(new String[] { EMInfo.PORTLET_ID });
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				ResignationHistory.class.getName());
		booleanQuery.addExactTerm(ResignationHistoryField.ID, id);

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

	public void indexAll() {
		final List<ResignationHistory> all = findAll();
		// re-index modified employee
		Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(ResignationHistory.class.getName());
		for (ResignationHistory item : all) {
			// re-index
			try {
				if (empLocalService.fetchEmp(item.getEmployeeId()) != null)
					indexer.reindex(item);
			} catch (SearchException e) {
				LOGGER.info(e);
			} catch (SystemException e) {
				LOGGER.info(e);
			}
		}
	}

	public void removeAllIndexes(SearchContext searchContext, long companyId) {
		final BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		booleanQuery.addExactTerm(Field.ENTRY_CLASS_NAME,
				ResignationHistory.class.getName());
		try {
			final Hits hits = SearchEngineUtil.search(
					SearchEngineUtil.getDefaultSearchEngineId(), companyId,
					booleanQuery, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			final List<Document> docs = hits.toList();
			for (Document doc : docs) {
				LOGGER.info("DELETE ResignationHistory Index UID: "
						+ doc.getUID());
				SearchEngineUtil.deleteDocument(
						SearchEngineUtil.getDefaultSearchEngineId(), companyId,
						doc.getUID());

			}
		} catch (SearchException e) {
			LOGGER.info(e);
		}
	}

	// fix

	public void addMissingResignedEmployee(ServiceContext serviceContext) {
		List<Emp> resignedEmps = empLocalService.findResignedEmp();
		List<Long> currentResignedList = empIdsFromResignedResignedHistory(findAll());

		List<Emp> toAddedList = new ArrayList<>();

		for (Emp emp : resignedEmps) {
			if (!currentResignedList.contains(emp.getEmpId())) {
				toAddedList.add(emp);
			}
		}

		// add missing
		for (Emp emp : toAddedList) {
			ResignationHistory resignationHistory = createPrePersisted();
			resignationHistory.setEmployeeId(emp.getEmpId());

			addResignationHistory(resignationHistory, serviceContext);
		}
	}

	private List<Long> empIdsFromResignedResignedHistory(
			List<ResignationHistory> resignationHistories) {
		final List<Long> ids = new ArrayList<>();
		for (ResignationHistory r : resignationHistories) {
			ids.add(r.getEmployeeId());
		}
		return ids;
	}

}