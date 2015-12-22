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

import vn.com.ecopharma.emp.constant.EMInfo;
import vn.com.ecopharma.emp.constant.ResignationHistoryField;
import vn.com.ecopharma.emp.enumeration.EmployeeStatus;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.ResignationHistory;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.base.ResignationHistoryLocalServiceBaseImpl;

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
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
	public static final Logger LOGGER = LoggerFactory
			.getLogger(ResignationHistoryLocalServiceImpl.class);

	public List<ResignationHistory> findAll() {
		try {
			return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(ResignationHistoryLocalServiceImpl.class)
					.info(e);
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
			LogFactoryUtil.getLog(ResignationHistoryLocalServiceImpl.class)
					.info(e);
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
			LogFactoryUtil.getLog(ResignationHistoryLocalServiceImpl.class)
					.info(e);
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
			resignationHistory = resignationHistoryPersistence
					.update(resignationHistory);
			if (resignationHistory != null) {
				// update employee status
				Emp employee = EmpLocalServiceUtil.getEmp(resignationHistory
						.getEmployeeId());
				employee.setStatus(EmployeeStatus.RESIGNED.toString());
				EmpLocalServiceUtil.updateEmp(employee);

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

			}
			return resignationHistory;
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
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
			e.printStackTrace();
		} catch (SearchException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int countAllUnDeletedDocuments(SearchContext searchContext,
			List<Query> filterQueries, long companyId, Sort sort) {
		return searchAllUnDeletedDocuments(searchContext, filterQueries,
				companyId, sort, QueryUtil.ALL_POS, QueryUtil.ALL_POS).size();
	}

	public List<Document> searchAllUnDeletedDocuments(
			SearchContext searchContext, List<Query> filterQueries,
			long companyId, Sort sort, int start, int end) {

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
			System.out.println("RESULT SIZE: " + documents.size());

			return documents;

		} catch (SearchException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
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
			e.printStackTrace();
		} catch (SearchException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void indexAll() {
		final Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(ResignationHistory.class.getName());
		final List<ResignationHistory> all = findAll();
		for (ResignationHistory item : all) {
			// index employee
			try {
				indexer.reindex(item);
			} catch (SearchException e) {
				e.printStackTrace();
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
			e.printStackTrace();
		}
	}

}