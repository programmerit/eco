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

package vn.com.ecopharma.hrm.tt.service.impl;

import java.util.Date;
import java.util.List;

import vn.com.ecopharma.hrm.tt.constant.ECO_TT_Info;
import vn.com.ecopharma.hrm.tt.constant.TimeTrackingField;
import vn.com.ecopharma.hrm.tt.model.TimeTracking;
import vn.com.ecopharma.hrm.tt.service.base.TimeTrackingLocalServiceBaseImpl;

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
 * The implementation of the time tracking local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.tt.service.base.TimeTrackingLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalServiceUtil
 */
public class TimeTrackingLocalServiceImpl extends
		TimeTrackingLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalServiceUtil} to access
	 * the time tracking local service.
	 */

	public List<TimeTracking> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<TimeTracking> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<TimeTracking> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return timeTrackingPersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int countSearch(SearchContext searchContext, List<Query> queries,
			long companyId) throws ParseException, SearchException {
		return search(searchContext, queries, companyId,
				new Sort(TimeTrackingField.ID, false), QueryUtil.ALL_POS,
				QueryUtil.ALL_POS).size();
	}

	public List<Document> search(SearchContext searchContext,
			List<Query> queries, long companyId, Sort sort, int start, int end)
			throws ParseException, SearchException {
		final BooleanQuery fullQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		final BooleanQuery allTimeTrackingBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		allTimeTrackingBooleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				TimeTracking.class.getName());

		fullQuery.add(allTimeTrackingBooleanQuery, BooleanClauseOccur.MUST);
		for (Query query : queries) {
			fullQuery.add(query, BooleanClauseOccur.MUST);
		}
		final List<Document> documents = SearchEngineUtil.search(
				SearchEngineUtil.getDefaultSearchEngineId(), companyId,
				fullQuery, sort, start, end).toList();
		return documents;
	}

	public Document getIndexedTimeTracking(long id, SearchContext searchContext) {
		searchContext.setPortletIds(new String[] { ECO_TT_Info.PORTLET_ID });
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				TimeTracking.class.getName());
		booleanQuery.addExactTerm(TimeTrackingField.ID, id);

		try {
			fullQuery.add(booleanQuery, BooleanClauseOccur.MUST);
			final Hits hits = SearchEngineUtil.search(searchContext, fullQuery);
			return !hits.toList().isEmpty() ? hits.toList().get(0) : null;
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SearchException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Document getIndexedTimeTracking(String id,
			SearchContext searchContext) {
		return getIndexedTimeTracking(Long.valueOf(id), searchContext);
	}

	public TimeTracking addTimeTracking(long empId, Date date, Date in1,
			Date out1, Date in2, Date out2, Date in3, Date out3,
			ServiceContext serviceContext) {
		try {
			final long id = counterLocalService.increment();
			TimeTracking timeTracking = timeTrackingPersistence.create(id);

			timeTracking.setEmpId(empId);

			timeTracking.setDate(date);
			timeTracking.setIn1(in1);
			timeTracking.setOut1(out1);

			timeTracking.setIn2(in2);
			timeTracking.setOut2(out2);

			timeTracking.setIn3(in3);
			timeTracking.setOut3(out3);

			timeTracking.setUserId(serviceContext.getUserId());
			timeTracking.setCompanyId(serviceContext.getCompanyId());
			timeTracking.setGroupId(serviceContext.getScopeGroupId());
			timeTracking.setCreateDate(new Date());
			timeTracking.setModifiedDate(new Date());

			timeTracking = super.addTimeTracking(timeTracking);

			// add resource permission
			resourceLocalService.addResources(timeTracking.getCompanyId(),
					timeTracking.getGroupId(), timeTracking.getUserId(),
					TimeTracking.class.getName(),
					timeTracking.getTimeTrackingId(), false, true, true);

			// indexing
			final Indexer indexer = IndexerRegistryUtil
					.nullSafeGetIndexer(TimeTracking.class.getName());
			indexer.reindex(TimeTracking.class.getName(),
					timeTracking.getTimeTrackingId());
			return timeTracking;

		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void completelyRemoveAllTimeTrackings() {
		List<TimeTracking> items = findAll();
		try {
			for (TimeTracking item : items) {
				Indexer indexer = IndexerRegistryUtil
						.nullSafeGetIndexer(TimeTracking.class.getName());
				indexer.delete(item);
				timeTrackingLocalService.deleteTimeTracking(item
						.getTimeTrackingId());
			}
		} catch (SystemException exception) {
			exception.printStackTrace();
		} catch (PortalException exception) {
			exception.printStackTrace();
		}
	}
}