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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import vn.com.ecopharma.emp.constant.EMInfo;
import vn.com.ecopharma.emp.constant.EmpAnnualLeaveField;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpAnnualLeave;
import vn.com.ecopharma.emp.service.base.EmpAnnualLeaveLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
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
 * The implementation of the emp annual leave local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.EmpAnnualLeaveLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.EmpAnnualLeaveLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.EmpAnnualLeaveLocalServiceUtil
 */
public class EmpAnnualLeaveLocalServiceImpl extends
		EmpAnnualLeaveLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.EmpAnnualLeaveLocalServiceUtil} to access
	 * the emp annual leave local service.
	 */

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpAnnualLeaveLocalServiceImpl.class);

	public List<EmpAnnualLeave> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<EmpAnnualLeave> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<EmpAnnualLeave> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return empAnnualLeavePersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public EmpAnnualLeave createPrePersistedEntity(ServiceContext serviceContext) {
		try {
			long id = counterLocalService.increment();
			EmpAnnualLeave obj = empAnnualLeavePersistence.create(id);

			obj.setCreateDate(new Date());
			obj.setUserId(serviceContext.getUserId());
			obj.setGroupId(serviceContext.getScopeGroupId());
			obj.setCompanyId(serviceContext.getCompanyId());

			return obj;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public EmpAnnualLeave addEmpAnnualLeave(EmpAnnualLeave prePersistedEntity,
			long empId, double totalLeave, double totalLeaveLeft,
			double totalOldLeavesLeft) {

		prePersistedEntity.setEmpId(empId);
		prePersistedEntity.setTotalAnnualLeave(totalLeave);
		prePersistedEntity.setTotalAnualLeaveLeft(totalLeaveLeft);
		try {
			EmpAnnualLeave result = super.addEmpAnnualLeave(prePersistedEntity);
			return result;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public EmpAnnualLeave addEmpAnnualLeave(long empId, double totalLeave,
			double totalLeaveLeft, double totalOldLeavesLeft,
			ServiceContext serviceContext) {
		return addEmpAnnualLeave(createPrePersistedEntity(serviceContext),
				empId, totalLeave, totalLeaveLeft, totalOldLeavesLeft);
	}

	public EmpAnnualLeave updateEmpAnnualLeave(EmpAnnualLeave empAnnualLeave) {
		try {
			empAnnualLeave.setModifiedDate(new Date());
			EmpAnnualLeave result = super.updateEmpAnnualLeave(empAnnualLeave);
			Indexer indexer = IndexerRegistryUtil
					.nullSafeGetIndexer(EmpAnnualLeave.class.getName());
			indexer.reindex(result);
			return result;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (SearchException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public EmpAnnualLeave updateEmpAnnualLeave(EmpAnnualLeave empAnnualLeave,
			double totalLeave, double totalLeaveLeft, double totalOldLeavesLeft) {
		empAnnualLeave.setTotalAnnualLeave(totalLeave);
		empAnnualLeave.setTotalAnualLeaveLeft(totalLeaveLeft);
		empAnnualLeave.setTotalPreviousYearLeavesLeft(totalOldLeavesLeft);
		return this.updateEmpAnnualLeave(empAnnualLeave);
	}

	public void executeFirstAprilQuartzTask() {
		for (EmpAnnualLeave empAnnualLeave : findAll()) {
			if (empAnnualLeave.getEmpId() == 188697)
				System.out.println("TEST");
			double prevLeaveLeft = empAnnualLeave
					.getTotalPreviousYearLeavesLeft();
			if (prevLeaveLeft == 0)
				continue;

			double calculateLeaveLeft = 0;
			double calculateTotalLeaveAfterApril1st = 0;

			double totalLeave = empAnnualLeave.getTotalAnnualLeave();
			double totalLeaveLeft = empAnnualLeave.getTotalAnualLeaveLeft();

			if (totalLeaveLeft >= prevLeaveLeft) {
				calculateLeaveLeft = totalLeave - prevLeaveLeft;
			} else { // totalLeaveLeft < prevLeaveLeft
				calculateLeaveLeft = totalLeave
						- (prevLeaveLeft + (prevLeaveLeft - totalLeaveLeft));
			}
			calculateTotalLeaveAfterApril1st = calculateLeaveLeft;

			this.updateEmpAnnualLeave(empAnnualLeave,
					calculateTotalLeaveAfterApril1st, calculateLeaveLeft,
					prevLeaveLeft);
		}
	}

	public EmpAnnualLeave fetchByEmp(long empId) {
		try {
			return empAnnualLeavePersistence.fetchByemp(empId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public List<Date> getDatesBetweenTwoDates(Date date1, Date date2,
			boolean includedHolidays, boolean includedLowerTerm) {
		List<Date> dates = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);
		while (calendar.getTime().before(date2)) {
			calendar.add(Calendar.DATE, 1);
			if (includedHolidays) {
				dates.add(calendar.getTime());
			} else {
				if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
					dates.add(calendar.getTime());
			}
		}

		if (includedLowerTerm)
			dates.add(date1);

		return dates;
	}

	// / SEARCH ENGINE PART

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
				EmpAnnualLeave.class.getName());

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
					// EmpAnnualLeaveField.EFFECTIVE_DATE,
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
			sort = new Sort(EmpAnnualLeaveField.ID, false);
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
				EmpAnnualLeave.class.getName());
		booleanQuery.addExactTerm(EmpAnnualLeaveField.ID, id);

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

	public void indexAll() {
		final Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(EmpAnnualLeave.class.getName());
		final List<EmpAnnualLeave> all = findAll();
		for (EmpAnnualLeave item : all) {
			// index employee
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
				EmpAnnualLeave.class.getName());
		try {
			final Hits hits = SearchEngineUtil.search(
					SearchEngineUtil.getDefaultSearchEngineId(), companyId,
					booleanQuery, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			final List<Document> docs = hits.toList();
			for (Document doc : docs) {
				LOGGER.info("DELETE EmpAnnualLeave Index UID: " + doc.getUID());
				SearchEngineUtil.deleteDocument(
						SearchEngineUtil.getDefaultSearchEngineId(), companyId,
						doc.getUID());

			}
		} catch (SearchException e) {
			e.printStackTrace();
		}
	}

	public EmpAnnualLeave applyLeaveForEmp(long empId, double numberOfLeaves,
			ServiceContext serviceContext) {
		final EmpAnnualLeave currentAnnualLeave = fetchByEmp(empId);
		if (currentAnnualLeave == null)
			return null;

		double totalLeavesLeft = currentAnnualLeave.getTotalAnualLeaveLeft();
		double totalPreviousYearLeaveLeft = currentAnnualLeave
				.getTotalPreviousYearLeavesLeft();

		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, 04, 01);

		if (today.after(calendar.getTime())) {
			totalLeavesLeft -= numberOfLeaves;
		} else {
			if (totalPreviousYearLeaveLeft > 0) {
				if (totalPreviousYearLeaveLeft > numberOfLeaves) {
					totalPreviousYearLeaveLeft -= numberOfLeaves;
				} else {
					double temp = numberOfLeaves - totalPreviousYearLeaveLeft;
					totalPreviousYearLeaveLeft -= totalPreviousYearLeaveLeft;
					totalLeavesLeft -= temp;
				}
			} else {
				totalLeavesLeft -= numberOfLeaves;
			}
		}

		currentAnnualLeave.setTotalAnualLeaveLeft(totalLeavesLeft);
		currentAnnualLeave
				.setTotalPreviousYearLeavesLeft(totalPreviousYearLeaveLeft);

		return updateEmpAnnualLeave(currentAnnualLeave);

	}

	public void scanAndAutoAddVacationLeave(ServiceContext serviceContext) {
		List<Emp> allEmps = empLocalService.findAll();
		for (Emp emp : allEmps) {
			LOGGER.info("Emp " + emp.getEmpCode() + " joined date: "
					+ emp.getJoinedDate());
			try {
				int numberOfAnnualLeaves = calculateTotalAnnualLeaveByJoinedDate(emp
						.getJoinedDate());
				LOGGER.info("	 	Has " + numberOfAnnualLeaves + " Annual Leave");

				addEmpAnnualLeave(emp.getEmpId(), numberOfAnnualLeaves, 0.0,
						0.0, serviceContext);

			} catch (SystemException e) {
				LOGGER.info(e);
			}
		}
	}

	public int calculateTotalAnnualLeaveByJoinedDate(Date joinedDate)
			throws SystemException {
		if (joinedDate == null) {
			throw new SystemException("joinedDate was null");
		}
		Calendar calendar = Calendar.getInstance();
		int calTotalLeaves = 0;
		Date today = new Date();

		calendar.setTime(today);
		int thisYear = calendar.get(Calendar.YEAR);
		int thisMonth = calendar.get(Calendar.MONTH);
		int thisDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

		calendar.setTime(joinedDate);
		int joinedDateYear = calendar.get(Calendar.YEAR);
		int joinedDateDay = calendar.get(Calendar.DAY_OF_MONTH);
		LOGGER.info("thisYear: " + thisYear + "  vs  " + joinedDateYear);
		if (thisYear == joinedDateYear) {
			if (joinedDateDay > 15) {
				calendar.add(Calendar.MONTH, 1);
				calendar.set(Calendar.DAY_OF_MONTH, 1);
			}
			// new calculate-joinedMonth
			int joinedDateMonth = calendar.get(Calendar.MONTH);
			LOGGER.info("thisMonth: " + thisMonth + "  vs  " + joinedDateMonth);
			if (thisMonth == joinedDateMonth)
				return 0;

		} else {
			calendar.set(thisYear, 00, 01);
		}

		// total month = total leaves incase today is larger than 15
		int totalMonth = getMonthsBetweenTwoDate(calendar.getTime(), today);
		LOGGER.info("No Of Months Btw 2 Dates: " + totalMonth);
		// calTotalLeaves = thisDayOfMonth > 15 ? totalMonth : totalMonth - 1;

		return totalMonth;
	}

	public int getMonthsBetweenTwoDate(Date startDate, Date endDate) {
		Calendar startCalendar = new GregorianCalendar();
		startCalendar.setTime(startDate);
		Calendar endCalendar = new GregorianCalendar();
		endCalendar.setTime(endDate);

		int diffYear = endCalendar.get(Calendar.YEAR)
				- startCalendar.get(Calendar.YEAR);
		int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH)
				- startCalendar.get(Calendar.MONTH);
		return diffMonth;
	}

	public void addOneDayForEachEmp() {
		for (EmpAnnualLeave annualLeave : findAll()) {

		}
	}

}