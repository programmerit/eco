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
import vn.com.ecopharma.emp.constant.EmpDisciplineField;
import vn.com.ecopharma.emp.enumeration.EmployeeStatus;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpDiscipline;
import vn.com.ecopharma.emp.service.base.EmpDisciplineLocalServiceBaseImpl;

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
 * The implementation of the emp discipline local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.EmpDisciplineLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.EmpDisciplineLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.EmpDisciplineLocalServiceUtil
 */
public class EmpDisciplineLocalServiceImpl extends
		EmpDisciplineLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.EmpDisciplineLocalServiceUtil} to access the
	 * emp discipline local service.
	 */

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpDisciplineLocalServiceImpl.class);

	public List<EmpDiscipline> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<EmpDiscipline> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<EmpDiscipline> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return empDisciplinePersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public int countAllDocuments(SearchContext searchContext,
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
		final BooleanQuery allEntriesBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		allEntriesBooleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				EmpDiscipline.class.getName());

		try {
			// add filter queries
			fullQuery.add(allEntriesBooleanQuery, BooleanClauseOccur.MUST);
			if (filterQueries != null && filterQueries.size() > 0) {
				for (Query query : filterQueries) {
					fullQuery.add(query, BooleanClauseOccur.MUST);
				}
			}

			final List<Document> documents = SearchEngineUtil.search(
					SearchEngineUtil.getDefaultSearchEngineId(), companyId,
					fullQuery, sort, start, end).toList();
			LOGGER.info("RESULT SIZE: " + documents.size());

			return documents;

		} catch (SearchException e) {
			LogFactoryUtil.getLog(EmpDisciplineLocalServiceImpl.class).info(e);
		} catch (ParseException e) {
			LogFactoryUtil.getLog(EmpDisciplineLocalServiceImpl.class).info(e);
		}
		return new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	public List<Document> filterByFields(SearchContext searchContext,
			Map<String, Object> filters, Sort sort, long companyId, int start,
			int end) throws ParseException {
		final List<Query> queries = new ArrayList<>();
		if (filters != null) {
			Date effectiveDateFrom = filters
					.get(EmpDisciplineField.EFFECTIVE_DATE_FROM) != null ? (Date) filters
					.get(EmpDisciplineField.EFFECTIVE_DATE_FROM) : null;

			Date effectiveDateTo = filters
					.get(EmpDisciplineField.EFFECTIVE_DATE_TO) != null ? (Date) filters
					.get(EmpDisciplineField.EFFECTIVE_DATE_TO) : null;
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
					Query effectiveDateQuery = empLocalService
							.createDateTermRangeQuery(
									EmpDisciplineField.EFFECTIVE_DATE,
									effectiveDateFrom, effectiveDateTo, true,
									true, searchContext);
					if (effectiveDateQuery != null) {
						queries.add(effectiveDateQuery);
					}
				}
			}
		}
		/* SORT */
		if (sort == null) {
			sort = new Sort(EmpDisciplineField.ID, false);
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
				EmpDiscipline.class.getName());
		booleanQuery.addExactTerm(EmpDisciplineField.ID, id);

		try {
			fullQuery.add(booleanQuery, BooleanClauseOccur.MUST);
			Hits hits = SearchEngineUtil.search(searchContext, fullQuery);
			return !hits.toList().isEmpty() ? hits.toList().get(0) : null;
		} catch (ParseException e) {
			LogFactoryUtil.getLog(EmpDisciplineLocalServiceImpl.class).info(e);
		} catch (SearchException e) {
			LogFactoryUtil.getLog(EmpDisciplineLocalServiceImpl.class).info(e);
		}

		return null;
	}

	public EmpDiscipline createPrePersistedEntity(ServiceContext serviceContext) {
		try {
			final long id = counterLocalService.increment();
			EmpDiscipline obj = empDisciplinePersistence.create(id);

			obj.setCompanyId(serviceContext.getCompanyId());
			obj.setGroupId(serviceContext.getScopeGroupId());
			obj.setUserId(serviceContext.getUserId());
			obj.setCreateDate(new Date());

			return obj;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public EmpDiscipline addEmpDiscipline(EmpDiscipline prePersistedObj,
			ServiceContext serviceContext) {
		try {
			final EmpDiscipline o = super.addEmpDiscipline(prePersistedObj);

			// add permission
			resourceLocalService.addResources(o.getCompanyId(), o.getGroupId(),
					o.getUserId(), EmpDiscipline.class.getName(),
					o.getEmpDisciplineId(), false, true, true);

			// index new EmpDiscipline
			Indexer indexer = IndexerRegistryUtil
					.nullSafeGetIndexer(EmpDiscipline.class);
			indexer.reindex(EmpDiscipline.class.getName(),
					o.getEmpDisciplineId());

			final Emp emp = empLocalService.fetchEmp(o.getEmpId());
			emp.setStatus(EmployeeStatus.DISCIPLINE.toString());
			empLocalService.updateEmp(emp);

			return o;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (SearchException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public void addEmpsDiscipline(List<Long> empIds, String decisionNo,
			String content, String type, Date effectiveDate,
			String additionalType, String description,
			ServiceContext serviceContext) {
		for (long empId : empIds) {
			EmpDiscipline obj = createPrePersistedEntity(serviceContext);
			obj.setEmpId(empId);
			obj.setDecisionNo(decisionNo);
			obj.setContent(content);
			obj.setDisciplineType(type);
			obj.setEffectiveDate(effectiveDate);
			obj.setAdditionalDisciplineType(additionalType);
			obj.setDescription(description);
			this.addEmpDiscipline(obj, serviceContext);
		}
	}

	public EmpDiscipline updateEmpDiscipline(EmpDiscipline empDiscipline)
			throws SystemException {
		try {
			EmpDiscipline o = super.updateEmpDiscipline(empDiscipline);
			// index new EmpDiscipline
			Indexer indexer = IndexerRegistryUtil
					.nullSafeGetIndexer(EmpDiscipline.class);

			indexer.reindex(EmpDiscipline.class.getName(),
					o.getEmpDisciplineId());
			return o;
		} catch (SearchException e) {
			LOGGER.info(e);
		}
		return null;

	}

	public EmpDiscipline updateEmpDiscipline(long id, String decisionNo,
			String type, String content, Date effectiveDate,
			String additionType, String desc) {
		try {
			final EmpDiscipline obj = super.fetchEmpDiscipline(id);
			obj.setDecisionNo(decisionNo);
			obj.setDisciplineType(type);
			obj.setContent(content);
			obj.setEffectiveDate(effectiveDate);
			obj.setAdditionalDisciplineType(additionType);
			obj.setDescription(desc);
			return this.updateEmpDiscipline(obj);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public void indexAll() {
		final List<EmpDiscipline> all = findAll();
		// re-index modified employee
		Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(EmpDiscipline.class.getName());
		for (EmpDiscipline item : all) {
			// re-index
			try {
				indexer.reindex(item);
			} catch (SearchException e) {
				LOGGER.info(e);
			}
		}
	}
}