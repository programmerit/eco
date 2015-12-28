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
import vn.com.ecopharma.emp.constant.PromotedHistoryField;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.PromotedHistory;
import vn.com.ecopharma.emp.service.base.PromotedHistoryLocalServiceBaseImpl;

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
 * The implementation of the promoted history local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.PromotedHistoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.PromotedHistoryLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.PromotedHistoryLocalServiceUtil
 */
public class PromotedHistoryLocalServiceImpl extends
		PromotedHistoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.PromotedHistoryLocalServiceUtil} to access
	 * the promoted history local service.
	 */

	public static final Logger LOGGER = LoggerFactory
			.getLogger(PromotedHistoryLocalServiceImpl.class);

	public List<PromotedHistory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<PromotedHistory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<PromotedHistory> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return promotedHistoryPersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(PromotedHistoryLocalServiceImpl.class)
					.info(e);
		}
		return new ArrayList<>();
	}

	public List<PromotedHistory> findByEmployee(long employeeId) {
		try {
			return promotedHistoryPersistence.findByEmployee(employeeId);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(PromotedHistoryLocalServiceImpl.class)
					.info(e);
		}
		return new ArrayList<>();
	}

	public List<PromotedHistory> findByOldTitles(long oldTitlesId) {
		try {
			return promotedHistoryPersistence.findByOldTitlesId(oldTitlesId);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(PromotedHistoryLocalServiceImpl.class)
					.info(e);
		}
		return null;
	}

	public List<PromotedHistory> findByNewTitles(long newTitlesId) {
		try {
			return promotedHistoryPersistence.findByOldTitlesId(newTitlesId);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(PromotedHistoryLocalServiceImpl.class)
					.info(e);
		}
		return null;
	}

	public PromotedHistory createPrePersisted() {
		try {
			long id = counterLocalService.increment();
			final PromotedHistory promotedHistory = promotedHistoryPersistence
					.create(id);
			promotedHistory.setPromotedDate(new Date());
			return promotedHistory;
		} catch (SystemException e) {
			LogFactoryUtil.getLog(PromotedHistoryLocalServiceImpl.class)
					.info(e);
		}
		return null;
	}

	public PromotedHistory addPromotedHistory(PromotedHistory promotedHistory,
			ServiceContext serviceContext) {
		promotedHistory.setCompanyId(serviceContext.getCompanyId());
		promotedHistory.setGroupId(serviceContext.getScopeGroupId());
		promotedHistory.setUserId(serviceContext.getUserId());
		promotedHistory.setCreateDate(new Date());
		promotedHistory.setModifiedDate(new Date());
		try {
			promotedHistory = super.addPromotedHistory(promotedHistory);
			Emp employee = empLocalService.getEmp(promotedHistory
					.getEmployeeId());
			employee.setTitlesId(promotedHistory.getNewTitlesId());
			empLocalService.updateEmp(employee);

			// add permission
			resourceLocalService.addResources(promotedHistory.getCompanyId(),
					promotedHistory.getGroupId(), promotedHistory.getUserId(),
					PromotedHistory.class.getName(),
					promotedHistory.getPromotedHistoryId(), false, true, true);

			// index new promotedHistory
			Indexer indexer = IndexerRegistryUtil
					.nullSafeGetIndexer(PromotedHistory.class);
			indexer.reindex(PromotedHistory.class.getName(),
					promotedHistory.getPromotedHistoryId());

			return promotedHistory;
		} catch (SystemException e) {
			LogFactoryUtil.getLog(PromotedHistoryLocalServiceImpl.class)
					.info(e);
		} catch (PortalException e) {
			LogFactoryUtil.getLog(PromotedHistoryLocalServiceImpl.class)
					.info(e);
		}
		return null;
	}

	public PromotedHistory markDeleted(PromotedHistory promotedHistory) {
		try {
			promotedHistory.setDeleted(true);

			promotedHistory = promotedHistoryPersistence
					.update(promotedHistory);

			// re-index modified employee
			Indexer indexer = IndexerRegistryUtil
					.nullSafeGetIndexer(PromotedHistory.class.getName());
			indexer.reindex(promotedHistory);
			return promotedHistory;
		} catch (SystemException e) {
			LogFactoryUtil.getLog(PromotedHistoryLocalServiceImpl.class)
					.info(e);
		} catch (SearchException e) {
			LogFactoryUtil.getLog(PromotedHistoryLocalServiceImpl.class)
					.info(e);
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
				PromotedHistory.class.getName());
		noneDeletedEmployeesBooleanQuery.addExactTerm(
				PromotedHistoryField.IS_DELETED, "false");

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
			LogFactoryUtil.getLog(PromotedHistoryLocalServiceImpl.class)
					.info(e);
		} catch (ParseException e) {
			LogFactoryUtil.getLog(PromotedHistoryLocalServiceImpl.class)
					.info(e);
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
				PromotedHistory.class.getName());
		booleanQuery.addExactTerm(PromotedHistoryField.ID, id);

		try {
			fullQuery.add(booleanQuery, BooleanClauseOccur.MUST);
			Hits hits = SearchEngineUtil.search(searchContext, fullQuery);
			return !hits.toList().isEmpty() ? hits.toList().get(0) : null;
		} catch (ParseException e) {
			LogFactoryUtil.getLog(PromotedHistoryLocalServiceImpl.class)
					.info(e);
		} catch (SearchException e) {
			LogFactoryUtil.getLog(PromotedHistoryLocalServiceImpl.class)
					.info(e);
		}

		return null;
	}

	public void indexAll() {
		final Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(PromotedHistory.class.getName());
		final List<PromotedHistory> all = findAll();
		for (PromotedHistory item : all) {
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
				PromotedHistory.class.getName());
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