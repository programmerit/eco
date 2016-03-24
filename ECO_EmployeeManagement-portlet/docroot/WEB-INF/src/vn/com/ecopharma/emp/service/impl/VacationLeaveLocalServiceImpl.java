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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import vn.com.ecopharma.emp.constant.EMInfo;
import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.constant.VacationLeaveField;
import vn.com.ecopharma.emp.enumeration.EmployeeStatus;
import vn.com.ecopharma.emp.enumeration.VacationLeaveStatus;
import vn.com.ecopharma.emp.enumeration.VacationLeaveType;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpOrgRelationship;
import vn.com.ecopharma.emp.model.VacationLeave;
import vn.com.ecopharma.emp.service.base.VacationLeaveLocalServiceBaseImpl;

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
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;

/**
 * The implementation of the vacation leave local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.VacationLeaveLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.VacationLeaveLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil
 */
public class VacationLeaveLocalServiceImpl extends
		VacationLeaveLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil} to access the
	 * vacation leave local service.
	 */

	private static final Log LOGGER = LogFactoryUtil
			.getLog(VacationLeaveLocalServiceImpl.class);

	private static final String BASIC_FORMAT_DATE = "dd/MM/yyyy";

	public List<VacationLeave> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<VacationLeave> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<VacationLeave> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return vacationLeavePersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public VacationLeave createPrePersistedEntity(ServiceContext serviceContext) {
		try {
			long id = counterLocalService.increment();
			VacationLeave obj = vacationLeavePersistence.create(id);

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

	public VacationLeave addVacationLeave(VacationLeave prePersistedEntity,
			long empId, String leaveType, Date leaveFrom, Date leaveTo,
			Date actualTo, int numberOfHours, String reason, String description) {
		prePersistedEntity.setEmpId(empId);
		prePersistedEntity.setLeaveType(leaveType);
		prePersistedEntity.setLeaveFrom(leaveFrom);
		prePersistedEntity.setLeaveTo(leaveTo);
		prePersistedEntity.setActualTo(actualTo);
		prePersistedEntity.setNumberOfHours(numberOfHours);
		prePersistedEntity.setReason(reason);
		prePersistedEntity.setDescription(description);
		try {
			VacationLeave result = super.addVacationLeave(prePersistedEntity);
			resourceLocalService.addResources(result.getCompanyId(),
					result.getGroupId(), result.getUserId(),
					VacationLeave.class.getName(), result.getVacationLeaveId(),
					false, true, true);

			Indexer indexer = IndexerRegistryUtil
					.nullSafeGetIndexer(VacationLeave.class.getName());

			indexer.reindex(VacationLeave.class.getName(),
					result.getVacationLeaveId());

			// set status to employee
			if (result.getLeaveType().equals(
					VacationLeaveType.POLICY_LEAVE.toString())
					&& result.getSign().equalsIgnoreCase("TS")) {
				Emp emp = empLocalService.fetchEmp(empId);
				emp.setStatus(EmployeeStatus.MATERNITY_LEAVE.toString());
				empLocalService.updateEmp(emp);
			}

			return result;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public VacationLeave addVacationLeave(long empId, String leaveType,
			Date leaveFrom, Date leaveTo, Date actualTo, int numberOfHours,
			String reason, String description, ServiceContext serviceContext) {
		return addVacationLeave(createPrePersistedEntity(serviceContext),
				empId, leaveType, leaveFrom, leaveTo, actualTo, numberOfHours,
				reason, description);
	}

	public VacationLeave addVacationLeave(long empId, VacationLeave leave) {
		leave.setEmpId(empId);
		leave.setStatus(VacationLeaveStatus.PENDING_REQUEST.toString());
		try {
			VacationLeave result = super.addVacationLeave(leave);
			resourceLocalService.addResources(result.getCompanyId(),
					result.getGroupId(), result.getUserId(),
					VacationLeave.class.getName(), result.getVacationLeaveId(),
					false, true, true);

			final Indexer indexer = IndexerRegistryUtil
					.nullSafeGetIndexer(VacationLeave.class.getName());

			indexer.reindex(VacationLeave.class.getName(),
					result.getVacationLeaveId());

			// set status to employee
			if (result.getLeaveType().equals(
					VacationLeaveType.POLICY_LEAVE.toString())
					&& result.getSign().equalsIgnoreCase("TS")) {
				Emp emp = empLocalService.fetchEmp(empId);
				emp.setStatus(EmployeeStatus.MATERNITY_LEAVE.toString());
				empLocalService.updateEmp(emp);
			}

			return result;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public VacationLeave updateVacationLeave(long id, String leaveType,
			String sign, Date leaveFrom, Date leaveTo, Date actualLeaveTo,
			String reason, String description, String status) {
		try {
			VacationLeave leave = fetchVacationLeave(id);
			leave.setLeaveType(leaveType);
			leave.setSign(sign);
			leave.setLeaveFrom(leaveFrom);
			leave.setLeaveTo(leaveTo);
			leave.setActualTo(actualLeaveTo);
			leave.setReason(reason);
			leave.setDescription(description);
			leave.setStatus(status);
			return this.updateVacationLeave(leave);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public VacationLeave updateVacationLeave(VacationLeave vacationLeave) {
		vacationLeave.setModifiedDate(new Date());
		try {
			vacationLeave = super.updateVacationLeave(vacationLeave);
			final Indexer indexer = IndexerRegistryUtil
					.nullSafeGetIndexer(VacationLeave.class.getName());

			indexer.reindex(VacationLeave.class.getName(),
					vacationLeave.getVacationLeaveId());

			return vacationLeave;

		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (SearchException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public VacationLeave setManagerApproval(long leaveId,
			ServiceContext serviceContext) {
		try {
			return setManagerApproval(fetchVacationLeave(leaveId),
					serviceContext);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public VacationLeave setManagerApproval(VacationLeave vacationLeave,
			ServiceContext serviceContext) {
		if (!vacationLeave.getStatus().equalsIgnoreCase(
				VacationLeaveStatus.PENDING_REQUEST.toString()))
			return null;
		try {
			vacationLeave.setModifiedDate(new Date());

			vacationLeave.setUserName(userLocalService.fetchUser(
					serviceContext.getUserId()).getFullName());

			vacationLeave.setStatus(VacationLeaveStatus.MANAGER_APPROVED
					.toString());

			return updateVacationLeave(vacationLeave);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public VacationLeave setHrApproval(long leaveId,
			ServiceContext serviceContext) {
		try {
			return setHrApproval(fetchVacationLeave(leaveId), serviceContext);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public VacationLeave setHrApproval(VacationLeave vacationLeave,
			ServiceContext serviceContext) {
		long empId = vacationLeave.getEmpId();
		if (!vacationLeave.getStatus().equalsIgnoreCase(
				VacationLeaveStatus.MANAGER_APPROVED.toString()))
			return null;
		try {
			// find current number of annual leave of Emp
			vacationLeave.setModifiedDate(new Date());
			vacationLeave.setUserName(userLocalService.fetchUser(
					serviceContext.getUserId()).getFullName());

			vacationLeave.setStatus(VacationLeaveStatus.HR_APPROVED.toString());

			VacationLeave result = updateVacationLeave(vacationLeave);
			// do more actions base on result
			if (result != null) {
				if (result.getLeaveType().equalsIgnoreCase(
						VacationLeaveType.ANNUAL_LEAVE.toString())) {
					double numberOfActualLeaves = calculateNumberOfAnnualLeavesBtwTwoDates(
							vacationLeave.getLeaveFrom(),
							vacationLeave.getLeaveTo(), vacationLeave.getSign());
					empAnnualLeaveLocalService.applyLeaveForEmp(empId,
							numberOfActualLeaves, serviceContext);
				}
				// send email to requester
				final String emailContent = getHrApprovedEmailContent(result);
				sendNotificationEmaiToEmp(empId, emailContent,
						"[Thông báo] Yêu cầu nghỉ phép");

			}
			return result;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	private boolean sendNotificationEmaiToEmp(long empId, String emailContent,
			String subject) {
		try {
			Emp emp = empLocalService.fetchEmp(empId);
			User empUser = userLocalService.fetchUser(emp.getEmpUserId());
			InternetAddress[] receivers = new InternetAddress[] { new InternetAddress(
					empUser.getEmailAddress()) };

			InternetAddress[] cc = new InternetAddress[] { new InternetAddress(
					"tvtao@ecopharma.com.vn") };

			MailEngine.send(new InternetAddress("admin@ecopharma.com.vn"),
					receivers, cc, subject, emailContent, true);
			return true;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (AddressException e) {
			LOGGER.info(e);
		} catch (MailEngineException e) {
			LOGGER.info(e);
		}
		return false;
	}

	private String getHrApprovedEmailContent(VacationLeave vacationLeave) {
		final StringBuilder builder = new StringBuilder();

		final SimpleDateFormat sdf = new SimpleDateFormat(BASIC_FORMAT_DATE);
		final Date dateFrom = vacationLeave.getLeaveFrom();
		final Date dateTo = vacationLeave.getLeaveTo();
		final String leaveType = VacationLeaveType.valueOf(
				vacationLeave.getLeaveType()).getHardCodeVneseString();
		final String sign = vacationLeave.getSign();

		builder.append("Yêu cầu nghỉ của bạn đã được duyệt.");
		builder.append("<p><b>Loại nghỉ: </b>");
		builder.append(leaveType);
		builder.append("</p>");
		builder.append("<p><b>Ngày nghỉ: </b>");
		builder.append(sdf.format(dateFrom) + " - " + sdf.format(dateTo) + " ("
				+ sign + ")");
		builder.append("</p>");
		builder.append("<p><b>Tình trạng: </b><font color='red'>Đã được duyệt.</p>");
		builder.append("Trân trọng,<br />");
		builder.append("Phòng HCNS");

		return builder.toString();
	}

	public double calculateNumberOfAnnualLeavesBtwTwoDates(Date dateFrom,
			Date dateTo, String additionLeaveSign) {
		if (dateFrom.compareTo(dateTo) == 0) {
			if (additionLeaveSign.contains("1/2")) {
				return 0.5D;
			} else {
				return 1.0D;
			}
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateFrom);
			double numberOfLeaves = 1D;
			while (calendar.getTime().before(dateTo)) {
				if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
					numberOfLeaves += 0D;
				} else if (calendar.get(Calendar.DAY_OF_WEEK) == 7) {
					numberOfLeaves += 0.5D;
				} else {
					numberOfLeaves += 1D;
				}
				calendar.add(Calendar.DATE, 1);
			}
			return numberOfLeaves;
		}
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

		return dates;
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
		final BooleanQuery allVacationLeaveEntriesBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		final BooleanQuery noneDeletedVacationLeaveBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		allVacationLeaveEntriesBooleanQuery.addRequiredTerm(
				Field.ENTRY_CLASS_NAME, VacationLeave.class.getName());
		noneDeletedVacationLeaveBooleanQuery.addExactTerm(
				VacationLeaveField.IS_DELETED, "false");

		try {
			// add filter queries
			fullQuery.add(allVacationLeaveEntriesBooleanQuery,
					BooleanClauseOccur.MUST);
			if (filterQueries != null && filterQueries.size() > 0) {
				for (Query query : filterQueries) {
					fullQuery.add(query, BooleanClauseOccur.MUST);
				}
			}

			// always filter for none-delete item
			fullQuery.add(noneDeletedVacationLeaveBooleanQuery,
					BooleanClauseOccur.MUST);

			sort = sort != null ? sort : new Sort(VacationLeaveField.ID, true);

			final List<Document> documents = SearchEngineUtil.search(
					SearchEngineUtil.getDefaultSearchEngineId(), companyId,
					fullQuery, sort, start, end).toList();
			return documents;

		} catch (SearchException e) {
			LOGGER.info(e);
		} catch (ParseException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	public List<Document> filterByFields(SearchContext searchContext,
			Map<String, Object> filters, Sort sort, long companyId, int start,
			int end) throws ParseException {
		final List<Query> queries = new ArrayList<>();
		if (filters != null) {
			// Date joinedDateFrom = filters.get(EmpField.JOINED_DATE_FROM) !=
			// null ? (Date) filters
			// .get(EmpField.JOINED_DATE_FROM) : null;
			//
			// Date joinedDateTo = filters.get(EmpField.JOINED_DATE_TO) != null
			// ? (Date) filters
			// .get(EmpField.JOINED_DATE_TO) : null;

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
					// createDateTermRangeQuery(EmpField.JOINED_DATE, queries,
					// joinedDateFrom, joinedDateTo, searchContext);
					// Query dateRangeQuery = createDateTermRangeQuery(
					// EmpField.JOINED_DATE, joinedDateFrom, joinedDateTo,
					// true, true, searchContext);
					// if (dateRangeQuery != null)
					// queries.add(dateRangeQuery);
				}
			}
		}
		/* SORT */
		if (sort == null) {
			sort = new Sort(VacationLeaveField.ID, false);
		}
		return searchAllUnDeletedDocuments(searchContext, queries, companyId,
				sort, start, end);
	}

	public int countFilterByFields(SearchContext searchContext,
			Map<String, Object> filters, Sort sort, long companyId)
			throws ParseException {
		return filterByFields(searchContext, filters, sort, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS).size();
	}

	public List<Document> searchPendingRequestsOfManager(long managerId,
			SearchContext searchContext, long companyId) {
		try {

			final List<Query> queries = new ArrayList<>();

			List<EmpOrgRelationship> departmentManagers = empOrgRelationshipLocalService
					.findByEmpClassNameAndHeadOfOrg(managerId,
							Department.class.getName(), true);

			List<String> departmentNames = new ArrayList<>();

			for (EmpOrgRelationship item : departmentManagers) {
				departmentNames.add(departmentLocalService.fetchDepartment(
						item.getOrgClassPK()).getName());
			}

			final Query leaveByDepartmentQuery = empLocalService
					.createStringListQuery(EmpField.DEPARTMENT,
							departmentNames, searchContext);
			queries.add(leaveByDepartmentQuery);

			final BooleanQuery pendingRequestQuery = BooleanQueryFactoryUtil
					.create(searchContext);
			pendingRequestQuery.addExactTerm(VacationLeaveField.STATUS,
					empLocalService
							.removeDashChar(VacationLeaveStatus.PENDING_REQUEST
									.toString()));
			queries.add(pendingRequestQuery);

			return searchAllUnDeletedDocuments(searchContext, queries,
					companyId, null, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (ParseException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<Document> searchByStatuses(List<String> statuses,
			SearchContext searchContext, long companyId) {

		final List<Query> queries = new ArrayList<>();
		try {
			final Query statusesQuery = empLocalService.createStringListQuery(
					VacationLeaveField.STATUS, statuses, searchContext);
			queries.add(statusesQuery);
			return searchAllUnDeletedDocuments(searchContext, queries,
					companyId, null, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (ParseException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<Document> searchManagerApprovalList(
			SearchContext searchContext, long companyId) {
		return searchByStatuses(
				Arrays.asList(VacationLeaveStatus.MANAGER_APPROVED.toString()),
				searchContext, companyId);
	}

	public void reindexAll() {
		final Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(VacationLeave.class.getName());
		final List<VacationLeave> vacationLeaves = findAll();
		for (VacationLeave v : vacationLeaves) {
			// index employee
			try {
				indexer.reindex(v);
			} catch (SearchException e) {
				LOGGER.info(e);
			}
		}

	}

	public void removeAllIndexes(SearchContext searchContext, long companyId) {
		final BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		booleanQuery.addExactTerm(Field.ENTRY_CLASS_NAME,
				VacationLeave.class.getName());
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

	public Document getIndexedDocument(String id, SearchContext searchContext) {
		return getIndexedDocument(Long.valueOf(id), searchContext);
	}

	public Document getIndexedDocument(long id, SearchContext searchContext) {
		searchContext.setPortletIds(new String[] { EMInfo.PORTLET_ID });
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				VacationLeave.class.getName());
		booleanQuery.addExactTerm(VacationLeaveField.ID, id);

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
		final List<VacationLeave> all = findAll();
		// re-index modified employee
		Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(VacationLeave.class.getName());
		for (VacationLeave item : all) {
			// re-index
			try {
				indexer.reindex(item);
			} catch (SearchException e) {
				LOGGER.info(e);
			}
		}
	}
}