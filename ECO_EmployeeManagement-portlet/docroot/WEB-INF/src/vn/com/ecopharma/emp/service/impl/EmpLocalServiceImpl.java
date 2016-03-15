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
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.constant.EMInfo;
import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.enumeration.EmployeeNotifyType;
import vn.com.ecopharma.emp.enumeration.EmployeeStatus;
import vn.com.ecopharma.emp.enumeration.LaborContractType;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.District;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpBankInfo;
import vn.com.ecopharma.emp.model.EmpNotifyEmail;
import vn.com.ecopharma.emp.model.EmpOrgRelationship;
import vn.com.ecopharma.emp.model.PromotedHistory;
import vn.com.ecopharma.emp.model.ResignationHistory;
import vn.com.ecopharma.emp.service.base.EmpLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
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
import com.liferay.portal.kernel.search.TermQuery;
import com.liferay.portal.kernel.search.TermQueryFactoryUtil;
import com.liferay.portal.kernel.search.TermRangeQuery;
import com.liferay.portal.kernel.search.TermRangeQueryFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;

/**
 * The implementation of the emp local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.EmpLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.EmpLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.EmpLocalServiceUtil
 */
public class EmpLocalServiceImpl extends EmpLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.EmpLocalServiceUtil} to access the emp local
	 * service.
	 */

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpLocalServiceImpl.class);

	private static final String COMMON_DATE_FORMAT = "dd/MM/yyyy";
	private static final String FILTER_DATE_FORMAT = "yyyyMMddhhmmss";

	private static final String GLOBAL_FILTER = "globalString";

	private static final String MISSING_EMPLOYEE_CODE_CHAR = "9";

	private static final String VN_ZIP_CODE = "084";

	@Override
	public List<Emp> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	@Override
	public List<Emp> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	@Override
	public List<Emp> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return empPersistence.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public Emp findByEmpCode(String empCode) {
		try {
			return empPersistence.fetchByEmpCode(empCode);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	@Override
	public Emp findByUser(long empUserId) {
		try {
			return empPersistence.fetchByUser(empUserId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public List<Emp> findByTitles(long titlesId) {
		try {
			return empPersistence.findByTitles(titlesId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<Emp> findResignedEmp() {
		try {
			return empPersistence.findByStatus(EmployeeStatus.RESIGNED
					.toString());
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.com.ecopharma.emp.service.EmpLocalService#
	 * isOnAddingNewWithSameEmployeeCode(long, java.lang.String)
	 */
	@Override
	public boolean isOnAddingNewWithSameEmployeeCode(long prePersistedEmpId,
			String empCode) {
		try {
			return empPersistence.fetchByEmpCode(empCode) != null
					&& fetchEmp(prePersistedEmpId) == null;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return false;
	}

	@Override
	public int countAllUnDeletedIndexedEmpDocuments(
			SearchContext searchContext, List<Query> filterQueries,
			long companyId, Sort sort) {
		return searchAllUnDeletedEmpIndexedDocument(searchContext,
				filterQueries, companyId, sort, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS).size();
	}

	@Override
	public List<Document> searchAllUnDeletedEmpIndexedDocument(
			SearchContext searchContext, List<Query> filterQueries,
			long companyId, Sort sort, int start, int end) {

		final BooleanQuery fullQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		final BooleanQuery allEmpEntriesBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		final BooleanQuery noneDeletedEmpsBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		allEmpEntriesBooleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				Emp.class.getName());
		noneDeletedEmpsBooleanQuery.addExactTerm(EmpField.IS_DELETED, "false");

		try {
			// add filter queries
			fullQuery.add(allEmpEntriesBooleanQuery, BooleanClauseOccur.MUST);
			if (filterQueries != null && !filterQueries.isEmpty()) {
				for (Query query : filterQueries) {
					fullQuery.add(query, BooleanClauseOccur.MUST);
				}
			}

			// always filter for none-delete item
			fullQuery.add(noneDeletedEmpsBooleanQuery, BooleanClauseOccur.MUST);

			LOGGER.info(fullQuery);

			final List<Document> documents = SearchEngineUtil.search(
					SearchEngineUtil.getDefaultSearchEngineId(), companyId,
					fullQuery, sort, start, end).toList();
			LOGGER.info("RESULT SIZE: " + documents.size());

			return documents;

		} catch (SearchException e) {
			LOGGER.info(e);
		} catch (ParseException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public int countFilterEmployeeByFields(SearchContext searchContext,
			Map<String, Object> filters, Sort sort, long companyId)
			throws ParseException {
		return filterEmployeeByFields(searchContext, filters, sort, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS).size();
	}

	@SuppressWarnings("unchecked")
	public List<Document> filterEmployeeByFields(SearchContext searchContext,
			Map<String, Object> filters, Sort sort, long companyId, int start,
			int end) throws ParseException {
		final List<Query> queries = new ArrayList<>();
		if (filters != null) {
			Date joinedDateFrom = filters.get(EmpField.JOINED_DATE_FROM) != null ? (Date) filters
					.get(EmpField.JOINED_DATE_FROM) : null;

			Date joinedDateTo = filters.get(EmpField.JOINED_DATE_TO) != null ? (Date) filters
					.get(EmpField.JOINED_DATE_TO) : null;

			for (Map.Entry<String, Object> filter : filters.entrySet()) {
				final String filterProperty = filter.getKey();
				final Object filterValue = filter.getValue();
				LOGGER.info("Filter Property: " + filterProperty);

				if (filterValue instanceof String) {
					LOGGER.info("Filter Property Value: " + filterValue);
					if (filterProperty.equalsIgnoreCase(GLOBAL_FILTER)) {
						final BooleanQuery globalFilterBooleanQuery = BooleanQueryFactoryUtil
								.create(searchContext);
						globalFilterBooleanQuery.addTerms(
								getGlobalSearchFields(), (String) filterValue,
								true);
						queries.add(globalFilterBooleanQuery);
					} else {
						// TODO
						BooleanQuery stringFilterQuery = BooleanQueryFactoryUtil
								.create(searchContext);
						stringFilterQuery.addTerm(filterProperty,
								(String) filterValue, true,
								BooleanClauseOccur.MUST);
						queries.add(stringFilterQuery);
					}
				} else if (filterValue instanceof List<?>) {
					if ((filterProperty.equalsIgnoreCase(EmpField.GENDER))
							|| filterProperty.equalsIgnoreCase(EmpField.STATUS)) {
						queries.add(createStringListQuery(filterProperty,
								(List<String>) filterValue, searchContext));
					} else if (isOrganizationFilter(filterProperty)) {
						queries.add(createOrganizationFilterQuery(
								filterProperty, (List<String>) filterValue,
								searchContext));
					}
				} else if (filterValue instanceof Date) {
					// createDateTermRangeQuery(EmpField.JOINED_DATE, queries,
					// joinedDateFrom, joinedDateTo, searchContext);
					Query dateRangeQuery = createDateTermRangeQuery(
							EmpField.JOINED_DATE, joinedDateFrom, joinedDateTo,
							true, true, searchContext);
					if (dateRangeQuery != null)
						queries.add(dateRangeQuery);
				}
			}
		}
		/* SORT */
		if (sort == null) {
			sort = new Sort(EmpField.EMP_ID, false);
		}
		return searchAllUnDeletedEmpIndexedDocument(searchContext, queries,
				companyId, sort, start, end);
	}

	/**
	 * @param query
	 * @param searchContext
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public List<Document> filterEmployeeByAutocompleteQuery(String query,
			SearchContext searchContext, int start, int end)
			throws ParseException {
		final Map<String, Object> filters = new HashMap<>();
		filters.put(GLOBAL_FILTER, query);
		return filterEmployeeByFields(searchContext, filters, null,
				searchContext.getCompanyId(), start, end);
	}

	public boolean isOrganizationFilter(String filterProperty) {
		return filterProperty.equalsIgnoreCase(EmpField.DEVISION)
				|| filterProperty.equalsIgnoreCase(EmpField.DEPARTMENT)
				|| filterProperty.equalsIgnoreCase(EmpField.UNIT)
				|| filterProperty.equalsIgnoreCase(EmpField.UNIT_GROUP)
				|| filterProperty.equalsIgnoreCase(EmpField.TITLES);
	}

	public void createDateTermRangeQuery(String field, List<Query> queries,
			Date dateFrom, Date dateTo, SearchContext searchContext) {
		final SimpleDateFormat sdf = new SimpleDateFormat(FILTER_DATE_FORMAT);
		final String defaultDateFromString = "19700101000000";

		final String defaultDateToString = sdf.format(getCurrentDateNextYear());

		final String filterDateFrom = dateFrom != null ? sdf.format(dateFrom)
				: defaultDateFromString;

		final String filterDateTo = dateTo != null ? sdf.format(dateTo)
				: defaultDateToString;

		final boolean isDefaultJDSearch = filterDateFrom
				.equals(defaultDateFromString)
				&& filterDateTo.equals(defaultDateToString);

		final TermRangeQuery dateTermRangeQuery = TermRangeQueryFactoryUtil
				.create(searchContext, field, filterDateFrom, filterDateTo,
						true, true);

		// not include null joined date
		if (!isDefaultJDSearch) {
			queries.add(dateTermRangeQuery);
		}

	}

	public Query createDateTermRangeQuery(String field, Date dateFrom,
			Date dateTo, boolean includesLower, boolean includesUpper,
			SearchContext searchContext) {
		if (dateFrom == null && dateTo == null)
			return null;
		final SimpleDateFormat sdf = new SimpleDateFormat(FILTER_DATE_FORMAT);
		final String defaultDateFromString = "19700101000000";

		final String defaultDateToString = sdf.format(getCurrentDateNextYear());

		// TODO: check the reason why filter by date 30/11/2000 does not include
		// this day.
		final String filterDateFrom = dateFrom != null ? sdf
				.format(subtract1Date(dateFrom)) : defaultDateFromString;

		final String filterDateTo = dateTo != null ? sdf.format(dateTo)
				: defaultDateToString;

		return TermRangeQueryFactoryUtil.create(searchContext, field,
				filterDateFrom, filterDateTo, includesLower, includesUpper);
	}

	private Date subtract1Date(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return calendar.getTime();
	}

	public Query createStringListQuery(String property, List<String> values,
			SearchContext searchContext) throws ParseException {
		final BooleanQuery query = BooleanQueryFactoryUtil
				.create(searchContext);
		for (String value : values) {
			TermQuery termQuery = TermQueryFactoryUtil.create(searchContext,
					property, StringUtils.trimToEmpty(removeDashChar(value)));
			query.add(termQuery, BooleanClauseOccur.SHOULD);
		}

		return query;
	}

	public String[] getGlobalSearchFields() {
		final List<String> allEmpFields = EmpField.getAllFields();
		allEmpFields.remove(EmpField.EMP_ID);
		allEmpFields.remove(EmpField.EMPLOYEE_USER_ID);
		allEmpFields.remove(EmpField.IS_DELETED);
		allEmpFields.remove(EmpField.TITLES_ID);
		allEmpFields.remove(EmpField.UNIVERSITY_ID);
		allEmpFields.remove(EmpField.LEVEL_ID);
		allEmpFields.remove(EmpField.DEVISION_ID);
		allEmpFields.remove(EmpField.TOTAL_SALARY);
		allEmpFields.remove(EmpField.BONUS);
		allEmpFields.remove(EmpField.POSITION_WAGE_RATES);
		allEmpFields.remove(EmpField.BASE_WAGE_RATES);
		allEmpFields.remove(EmpField.JOINED_DATE_FROM);
		allEmpFields.remove(EmpField.JOINED_DATE_TO);

		return allEmpFields.toArray(new String[allEmpFields.size()]);

	}

	public String removeDashChar(String s) {
		final String[] dashChars = new String[] { "-", "_" };

		for (String dashChar : dashChars)
			if (s.contains(dashChar)) {
				s = s.replaceAll(dashChar, " "); // NOSONAR
			}
		return s.replaceAll("\\s+", " ").trim();
	}

	private Query createOrganizationFilterQuery(String property,
			List<String> values, SearchContext searchContext)
			throws ParseException {
		final BooleanQuery query = BooleanQueryFactoryUtil
				.create(searchContext);

		for (String value : values) {
			TermQuery termQuery = TermQueryFactoryUtil.create(searchContext,
					property, StringUtils.trimToEmpty(value));
			query.add(termQuery, BooleanClauseOccur.SHOULD);
		}
		return query;
	}

	public Date getCurrentDateNextYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, 1);
		return calendar.getTime();
	}

	public Emp createPrePersistedEntity(ServiceContext serviceContext) {
		try {
			long empId = counterLocalService.increment();
			Emp emp = empPersistence.create(empId);

			emp.setCompanyId(serviceContext.getCompanyId());
			emp.setGroupId(serviceContext.getScopeGroupId());
			emp.setUserId(serviceContext.getUserId());
			emp.setCreateDate(new Date());
			return emp;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	/**
	 * @param employee
	 * @param autoPassword
	 * @param password1
	 * @param password2
	 * @param autoScreenName
	 * @param screenName
	 * @param emailAddress
	 * @param facebookId
	 * @param openId
	 * @param locale
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param prefixId
	 * @param suffixId
	 * @param male
	 * @param birthdayMonth
	 * @param birthdayDay
	 * @param birthdayYear
	 * @param groupIds
	 * @param organizationIds
	 * @param roleIds
	 * @param userGroupIds
	 * @param sendEmail
	 * @param addresses
	 * @param dependentNameMap
	 * @param bankInfoMap
	 * @param isImportAction
	 *            use to determine wherether emp is imported or create. (For
	 *            notify)
	 * @param serviceContext
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public Emp addEmp(Emp employee, User generatedUser, boolean autoPassword,
			String password1, String password2,
			boolean autoScreenName,
			String screenName,
			boolean male,
			boolean sendEmail, // End user part
			Map<Address, Boolean> addresses,
			Map<String, Boolean> dependentNameMap,
			Map<EmpBankInfo, Boolean> bankInfoMap, boolean isImportAction,
			ServiceContext serviceContext) throws SystemException,
			PortalException {
		// bind fields
		final Calendar cal = Calendar.getInstance();
		cal.setTime(employee.getBirthday());
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);

		// group id: User Personal Site
		long[] groups = new long[] { GroupLocalServiceUtil.getGroup(
				serviceContext.getCompanyId(), "User Personal Site")
				.getGroupId() };
		// role id: User
		long[] roles = new long[] { RoleLocalServiceUtil.getRole(
				serviceContext.getCompanyId(), "User").getRoleId() };

		final long[] organizationIds = null;
		final long[] userGroupIds = null;

		String generatePwd = RandomStringUtils.randomAlphabetic(8);
		String pwd1 = !autoPassword ? password1 : generatePwd;
		String pwd2 = !autoPassword ? password2 : generatePwd;
		String email = generatedUser.getEmailAddress();

		final long facebookId = 0L;
		final int prefixId = 0;
		final int suffixId = 0;
		final String openId = StringUtils.EMPTY;
		final Locale defaultLocale = LocaleUtil.getDefault();

		// add User Part
		// TODO: refactor (removed ??)
		if (userLocalService.fetchUserByEmailAddress(
				serviceContext.getCompanyId(), email) != null) {
			email = regenerateDuplicateEmailAddress(email, 1, // NOSONAR
					serviceContext.getCompanyId());
		}
		final User user = UserLocalServiceUtil
				.addUser(serviceContext.getUserId(), serviceContext
						.getCompanyId(), autoPassword, pwd1, pwd2,
						autoScreenName, screenName, email, facebookId, openId,
						defaultLocale, generatedUser.getFirstName(),
						generatedUser.getMiddleName(), generatedUser
								.getLastName(), prefixId, suffixId, male,
						month, day, year,
						titlesLocalService.getTitles(employee.getTitlesId())
								.getName(), groups, organizationIds, roles,
						userGroupIds, sendEmail, serviceContext);

		// add employee code expando value to user
		addOrUpdateUserEmployeeCodeValue(employee.getEmpCode(),
				user.getUserId(), serviceContext.getCompanyId());

		employee.setEmpUserId(user.getUserId());
		employee.setUserId(serviceContext.getUserId());
		employee.setGroupId(serviceContext.getScopeGroupId());
		employee.setCompanyId(serviceContext.getCompanyId());
		employee.setCreateDate(new Date());

		employee.setStatus(EmployeeStatus.NEWLY_ADDED.toString());

		// Add employee's addresses
		for (Map.Entry<Address, Boolean> address : addresses.entrySet()) {
			// check UIDeleted flag
			if (!address.getValue()) {
				final Address addressEntity = address.getKey();
				addressEntity.setClassName(Emp.class.getName());
				addressEntity.setClassPK(employee.getEmpId());
				addressEntity.setCompanyId(serviceContext.getCompanyId());
				AddressLocalServiceUtil.addAddress(addressEntity);
			}
		}

		// Add employee's dependences
		final StringBuilder namesBuilder = new StringBuilder();
		int dependentNamesCount = 0;
		for (Map.Entry<String, Boolean> entry : dependentNameMap.entrySet()) {
			if (!entry.getValue()
					&& StringUtils.trimToNull(entry.getKey()) != null) {
				namesBuilder.append(entry.getKey());
				namesBuilder.append(";");
				dependentNamesCount++;
			}
		}
		// set back to employee
		employee.setNumberOfDependents(dependentNamesCount);
		employee.setDependentNames(namesBuilder.toString());

		// Add employee's banking info
		for (Map.Entry<EmpBankInfo, Boolean> entry : bankInfoMap.entrySet()) {
			EmpBankInfo empBankInfo = entry.getKey();

			if (!entry.getValue()
					&& StringUtils.trimToNull(empBankInfo.getBankAccountNo()) != null
					&& StringUtils.trimToNull(empBankInfo.getBankName()) != null) {
				empBankInfo.setEmpId(employee.getEmpId());
				empBankInfoLocalService.addEmpBankInfo(empBankInfo,
						serviceContext);
			}
		}

		// persist to DB
		Emp result = super.addEmp(employee);

		// add permission
		resourceLocalService.addResources(employee.getCompanyId(),
				employee.getGroupId(), serviceContext.getUserId(),
				Emp.class.getName(), employee.getEmpId(), false, true, true);

		// index new employee
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Emp.class);
		indexer.reindex(Emp.class.getName(), result.getEmpId());

		// add to notify (if isImportAction false)
		if (!isImportAction) {
			empNotifyEmailLocalService.createEmpNotifyEmail(result.getEmpId(),
					StringUtils.EMPTY, EmployeeNotifyType.WAITING.toString());
		}
		return result;
	}

	public Emp addEmp(Emp employee, User user,
			Map<Address, Boolean> addressesMap,
			Map<String, Boolean> dependentNameMap,
			Map<EmpBankInfo, Boolean> bankInfoMap, ServiceContext serviceContext)
			throws SystemException, PortalException {

		employee.setBirthday(user.getBirthday());
		employee.setEmpUserId(user.getUserId());
		employee.setUserId(serviceContext.getUserId());
		employee.setGroupId(serviceContext.getScopeGroupId());
		employee.setCompanyId(serviceContext.getCompanyId());
		employee.setCreateDate(new Date(System.currentTimeMillis()));
		employee.setModifiedDate(new Date(System.currentTimeMillis()));

		employee.setStatus(EmployeeStatus.NEWLY_ADDED.toString());

		// Add employee's addresses
		for (Map.Entry<Address, Boolean> address : addressesMap.entrySet()) {
			// check UIDeleted flag
			if (!address.getValue()) {
				final Address addressEntity = address.getKey();
				addressEntity.setClassName(Emp.class.getName());
				addressEntity.setClassPK(employee.getEmpId());
				addressEntity.setCompanyId(serviceContext.getCompanyId());
				AddressLocalServiceUtil.updateAddress(addressEntity);
			}
		}

		// Add employee's banking info
		for (Map.Entry<EmpBankInfo, Boolean> entry : bankInfoMap.entrySet()) {
			final EmpBankInfo empBankInfo = entry.getKey();
			if (!entry.getValue()) {
				if (empBankInfoLocalService.fetchEmpBankInfo(empBankInfo
						.getEmpBankInfoId()) == null) {
					if (StringUtils.trimToNull(empBankInfo.getBankAccountNo()) != null
							|| StringUtils
									.trimToNull(empBankInfo.getBankName()) != null) {
						empBankInfo.setEmpId(employee.getEmpId());
						empBankInfoLocalService.addEmpBankInfo(empBankInfo,
								serviceContext);
					}
				} else {
					if (StringUtils.trimToNull(empBankInfo.getBankAccountNo()) == null
							|| StringUtils
									.trimToNull(empBankInfo.getBankName()) == null) {
						empBankInfoLocalService.deleteEmpBankInfo(empBankInfo
								.getEmpBankInfoId());
					} else {
						empBankInfoLocalService.updateEmpBankInfo(empBankInfo);
					}
				}
			} else {
				if (empBankInfoLocalService.fetchEmpBankInfo(empBankInfo
						.getEmpBankInfoId()) != null) {
					empBankInfoLocalService.deleteEmpBankInfo(empBankInfo
							.getEmpBankInfoId());
				}
			}

		}

		// Add employee's dependences
		final StringBuilder namesBuilder = new StringBuilder();
		int dependentNamesCount = 0;
		for (Map.Entry<String, Boolean> entry : dependentNameMap.entrySet()) {
			if (!entry.getValue()
					&& StringUtils.trimToNull(entry.getKey()) != null) {
				namesBuilder.append(entry.getKey());
				namesBuilder.append(";");
				dependentNamesCount++;
			}
		}
		// set back to employee
		employee.setNumberOfDependents(dependentNamesCount);
		employee.setDependentNames(namesBuilder.toString());

		// persist to DB
		Emp result = super.addEmp(employee);

		// add employee code expando value to user
		addOrUpdateUserEmployeeCodeValue(result.getEmpCode(), user.getUserId(),
				serviceContext.getCompanyId());

		// add permission
		resourceLocalService.addResources(employee.getCompanyId(),
				employee.getGroupId(), serviceContext.getUserId(),
				Emp.class.getName(), employee.getEmpId(), false, true, true);

		// index new employee
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Emp.class);
		indexer.reindex(Emp.class.getName(), result.getEmpId());
		return result;
	}

	public Emp addEmp(Emp employee, boolean autoPassword, String password1,
			String password2, boolean autoScreenName, String screenName,
			String emailAddress, long facebookId, String openId, Locale locale,
			String firstName, String middleName, String lastName, int prefixId,
			int suffixId, boolean male, int birthdayMonth, int birthdayDay,
			int birthdayYear, long[] groupIds,
			long[] organizationIds,
			long[] roleIds,
			long[] userGroupIds,
			boolean sendEmail, // End user part
			Map<Address, Boolean> addresses,
			Map<String, Boolean> dependentNameMap,
			Map<EmpBankInfo, Boolean> bankInfoMap, boolean isImportAction,
			ServiceContext serviceContext) throws SystemException,
			PortalException {
		// Add User Part
		if (userLocalService.fetchUserByEmailAddress(
				serviceContext.getCompanyId(), emailAddress) != null) {
			emailAddress = regenerateDuplicateEmailAddress(emailAddress, 1, // NOSONAR
					serviceContext.getCompanyId());
		}
		final User user = UserLocalServiceUtil.addUser(
				serviceContext.getUserId(), serviceContext.getCompanyId(),
				autoPassword, password1, password2, autoScreenName, screenName,
				emailAddress, facebookId, openId, locale, firstName,
				middleName, lastName, prefixId, suffixId, male, birthdayMonth,
				birthdayDay, birthdayYear,
				titlesLocalService.getTitles(employee.getTitlesId()).getName(),
				groupIds, organizationIds, roleIds, userGroupIds, sendEmail,
				serviceContext);

		// add employee code expando value to user
		addOrUpdateUserEmployeeCodeValue(employee.getEmpCode(),
				user.getUserId(), serviceContext.getCompanyId());

		employee.setEmpUserId(user.getUserId());
		employee.setUserId(serviceContext.getUserId());
		employee.setGroupId(serviceContext.getScopeGroupId());
		employee.setCompanyId(serviceContext.getCompanyId());
		employee.setCreateDate(new Date(System.currentTimeMillis()));
		employee.setModifiedDate(new Date(System.currentTimeMillis()));

		employee.setStatus(EmployeeStatus.NEWLY_ADDED.toString());

		// Add employee's addresses
		for (Map.Entry<Address, Boolean> address : addresses.entrySet()) {
			// check UIDeleted flag
			if (!address.getValue()) {
				final Address addressEntity = address.getKey();
				addressEntity.setClassName(Emp.class.getName());
				addressEntity.setClassPK(employee.getEmpId());
				addressEntity.setCompanyId(serviceContext.getCompanyId());
				AddressLocalServiceUtil.addAddress(addressEntity);
			}
		}

		// Add employee's dependences
		final StringBuilder namesBuilder = new StringBuilder();
		int dependentNamesCount = 0;
		for (Map.Entry<String, Boolean> entry : dependentNameMap.entrySet()) {
			if (!entry.getValue()
					&& StringUtils.trimToNull(entry.getKey()) != null) {
				namesBuilder.append(entry.getKey());
				namesBuilder.append(";");
				dependentNamesCount++;
			}
		}
		// set back to employee
		employee.setNumberOfDependents(dependentNamesCount);
		employee.setDependentNames(namesBuilder.toString());

		// Add employee's banking info
		for (Map.Entry<EmpBankInfo, Boolean> entry : bankInfoMap.entrySet()) {
			final EmpBankInfo empBankInfo = entry.getKey();
			if (!entry.getValue()
					&& StringUtils.trimToNull(empBankInfo.getBankAccountNo()) != null
					&& StringUtils.trimToNull(empBankInfo.getBankName()) != null) {
				empBankInfo.setEmpId(employee.getEmpId());
				empBankInfoLocalService.addEmpBankInfo(empBankInfo,
						serviceContext);
			}

		}

		// persist to DB
		Emp result = super.addEmp(employee);

		// add permission
		resourceLocalService.addResources(employee.getCompanyId(),
				employee.getGroupId(), serviceContext.getUserId(),
				Emp.class.getName(), employee.getEmpId(), false, true, true);

		// index new employee
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Emp.class);
		indexer.reindex(Emp.class.getName(), result.getEmpId());

		// add to notify (if isImportAction false)
		if (!isImportAction) {
			empNotifyEmailLocalService.createEmpNotifyEmail(result.getEmpId(),
					StringUtils.EMPTY, EmployeeNotifyType.WAITING.toString());
		}
		return result;
	}

	public Emp update(Emp employee, long userId, long oldTitlesId,
			Map<Address, Boolean> addressesMap,
			Map<String, Boolean> dependentNameMap,
			Map<EmpBankInfo, Boolean> bankInfoMap, boolean isImportAction,
			ServiceContext serviceContext) {
		try {
			User user = userLocalService.fetchUser(userId);
			return update(employee, user, oldTitlesId, addressesMap,
					dependentNameMap, bankInfoMap, isImportAction,
					serviceContext);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Emp update(Emp employee, User user, long oldTitlesId,
			Map<Address, Boolean> addressesMap,
			Map<String, Boolean> dependentNameMap,
			Map<EmpBankInfo, Boolean> bankInfoMap, boolean isImportAction,
			ServiceContext serviceContext) {
		try {
			final long empId = employee.getEmpId();
			boolean isPositionChanged = false;
			isPositionChanged = employee.getTitlesId() != oldTitlesId;
			employee.setModifiedDate(new Date(System.currentTimeMillis()));
			// Update User for Email, name info
			user = userPersistence.update(user);

			LOGGER.info("Firstname " + user.getFirstName());
			LOGGER.info("Lastname " + user.getLastName());

			addOrUpdateUserEmployeeCodeValue(employee.getEmpCode(),
					user.getUserId(), serviceContext.getCompanyId());

			// Insert log (history) in case Employee is promoted to new position
			if (isPositionChanged) {
				employeeTitlesHistoryLocalService.addEmployeeTitlesHistory(
						empId, employee.getTitlesId(),
						"PROMOTED TO NEW TITLES",
						new Date(System.currentTimeMillis()), serviceContext);
			}
			// check where update on Importing or not
			if (isImportAction) {
				final List<Address> addresses = AddressLocalServiceUtil
						.getAddresses(serviceContext.getCompanyId(),
								Emp.class.getName(), empId);
				// to ensure that the address will not be DUPLICATE while update
				// -> remove all
				for (Address address : addresses) {
					AddressLocalServiceUtil.deleteAddress(address
							.getAddressId());
				}

				final List<EmpBankInfo> bankInfos = empBankInfoLocalService
						.findByEmp(empId);

				for (EmpBankInfo bankInfo : bankInfos) {
					empBankInfoLocalService.deleteEmpBankInfo(bankInfo
							.getEmpBankInfoId());
				}
			}

			// update/add addresses
			for (Map.Entry<Address, Boolean> entry : addressesMap.entrySet()) {
				boolean isUIDeleted = entry.getValue();
				Address address = entry.getKey();
				if (!isUIDeleted) {
					if (AddressLocalServiceUtil.fetchAddress(address
							.getAddressId()) != null) {
						AddressLocalServiceUtil.updateAddress(address);
					} else {
						// create new Address
						address.setCompanyId(serviceContext.getCompanyId());
						address.setUserId(serviceContext.getUserId());
						address.setClassName(Emp.class.getName());
						address.setClassPK(empId); // NOSONAR
						AddressLocalServiceUtil.updateAddress(address);
					}
				} else {
					AddressLocalServiceUtil.deleteAddress(address
							.getAddressId());
				}
			}

			// Add employee's dependences
			final StringBuilder namesBuilder = new StringBuilder();
			int dependentNamesCount = 0;
			for (Map.Entry<String, Boolean> entry : dependentNameMap.entrySet()) {
				if (!entry.getValue()
						&& StringUtils.trimToNull(entry.getKey()) != null) {
					namesBuilder.append(entry.getKey());
					namesBuilder.append(";");
					dependentNamesCount++;
				}
			}

			// Is Manager ?
			// if (!isImportAction) {
			// boolean isCurrentlyManager = empOrgRelationshipLocalService
			// .isHeadOfDepartment(empId, employee.getDepartmentId());
			// EmpOrgRelationship currentManagerOfDept =
			// empOrgRelationshipLocalService
			// .fetchByClassNameClassPKHeadOfOrg(
			// Department.class.getName(),
			// employee.getDepartmentId(), true);
			// if (isCurrentlyManager) {
			// // de-select current employee as manager
			// if (!isManager) {
			// // remove relationship
			// currentManagerOfDept.setEmpId(0L);
			// empOrgRelationshipLocalService
			// .updateEmpOrgRelationship(currentManagerOfDept);
			// }
			// } else {
			// if (isManager) {
			// if (currentManagerOfDept != null) {
			// currentManagerOfDept.setEmpId(empId);
			// currentManagerOfDept.setModifiedDate(new Date());
			// empOrgRelationshipLocalService
			// .updateEmpOrgRelationship(currentManagerOfDept);
			// } else {
			// empOrgRelationshipLocalService
			// .addEmpOrgRelationship(empId,
			// Department.class.getName(),
			// employee.getDepartmentId(), true,
			// false, serviceContext);
			//
			// }
			// }
			// }
			//
			// }

			// Add employee's banking info
			for (Map.Entry<EmpBankInfo, Boolean> entry : bankInfoMap.entrySet()) {
				final EmpBankInfo empBankInfo = entry.getKey();
				if (!entry.getValue()) {
					if (empBankInfoLocalService.fetchEmpBankInfo(empBankInfo
							.getEmpBankInfoId()) == null) {
						if (StringUtils.trimToNull(empBankInfo
								.getBankAccountNo()) != null
								|| StringUtils.trimToNull(empBankInfo
										.getBankName()) != null) {
							empBankInfo.setEmpId(employee.getEmpId());
							empBankInfoLocalService.addEmpBankInfo(empBankInfo,
									serviceContext);
						}
					} else {
						if (StringUtils.trimToNull(empBankInfo
								.getBankAccountNo()) == null
								|| StringUtils.trimToNull(empBankInfo
										.getBankName()) == null) {
							empBankInfoLocalService
									.deleteEmpBankInfo(empBankInfo
											.getEmpBankInfoId());
						} else {
							empBankInfoLocalService
									.updateEmpBankInfo(empBankInfo);
						}
					}
				} else {
					if (empBankInfoLocalService.fetchEmpBankInfo(empBankInfo
							.getEmpBankInfoId()) != null) {
						empBankInfoLocalService.deleteEmpBankInfo(empBankInfo
								.getEmpBankInfoId());
					}
				}

			}

			// set back to employee
			employee.setNumberOfDependents(dependentNamesCount); // NOSONAR
			employee.setDependentNames(namesBuilder.toString());

			employee = empPersistence.update(employee);// NOSONAR
			if (employee != null) {
				resourceLocalService.updateResources(employee.getCompanyId(),
						employee.getGroupId(), Emp.class.getName(),
						employee.getEmpId(),
						serviceContext.getGroupPermissions(),
						serviceContext.getGuestPermissions());

				// re-index modified employee
				Indexer indexer = IndexerRegistryUtil
						.nullSafeGetIndexer(Emp.class);
				indexer.reindex(employee);
			}
			return employee;
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Emp updateExistedEmployee(Emp employee, String employeeCode,
			long titlesId, long unitGroupId, long unitId, long departmentId,
			long levelId, Date promotedDate, Date joinedDate,
			Date laborContractSignedDate, Date laborContractExpiredDate,
			String laborContractType, int laborContractSignedTime, Date dob,
			String gender, String placeOfBirth, String education,
			String educationSpecialize, long specializedId, long universityId,
			String maritalStatus, String identityCardNo, Date issuedDate,
			String issuedPlace, String contactNumber,
			String companyEmailAddress, String taxCode, int numberOfDependents,
			String dependentNames, String insurranceCode,
			String healthInsuranceNo) {
		return setInfoToEmp(employee, employeeCode, titlesId, unitGroupId,
				unitId, departmentId, levelId, promotedDate, joinedDate,
				laborContractSignedDate, laborContractExpiredDate,
				laborContractType, laborContractSignedTime, dob, gender,
				placeOfBirth, education, educationSpecialize, specializedId,
				universityId, maritalStatus, identityCardNo, issuedDate,
				issuedPlace, contactNumber, companyEmailAddress, taxCode,
				numberOfDependents, dependentNames, insurranceCode,
				healthInsuranceNo);
	}

	public Emp addOrUpdateWithExistUser(Emp employee, User user,
			long oldTitlesId, Map<Address, Boolean> addressesMap,
			Map<String, Boolean> dependentNameMap,
			Map<EmpBankInfo, Boolean> bankInfoMap, boolean isImportAction,
			ServiceContext serviceContext) {
		try {
			if (super.fetchEmp(employee.getEmpId()) != null) { // call update
				return update(employee, user, oldTitlesId, addressesMap,
						dependentNameMap, bankInfoMap, isImportAction,
						serviceContext);
			} else {
				return addEmp(employee, user, addressesMap, dependentNameMap,
						bankInfoMap, serviceContext);
			}
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Emp addOrUpdateWithExistUser(Emp employee, String userScreenName,
			long oldTitlesId, Map<Address, Boolean> addressesMap,
			Map<String, Boolean> dependentNameMap,
			Map<EmpBankInfo, Boolean> bankInfoMap, boolean isImportAction,
			ServiceContext serviceContext) {
		try {
			User user = userLocalService.getUserByScreenName(
					serviceContext.getCompanyId(), userScreenName);

			if (super.fetchEmp(employee.getEmpId()) != null) { // call update
				return update(employee, user, oldTitlesId, addressesMap,
						dependentNameMap, bankInfoMap, isImportAction,
						serviceContext);
			} else {
				return addEmp(employee, user, addressesMap, dependentNameMap,
						bankInfoMap, serviceContext);
			}
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Emp createEmployee(String employeeCode, long titlesId,
			long unitGroupId, long unitId, long departmentId, long levelId,
			Date promotedDate, Date joinedDate, Date laborContractSignedDate,
			Date laborContractExpiredDate, String laborContractType,
			int laborContractSignedTime, Date dob, String gender,
			String placeOfBirth, String education, String educationSpecialize,
			long specializedId, long universityId, String maritalStatus,
			String identityCardNo, Date issuedDate, String issuedPlace,
			String contactNumber, String companyEmailAddress, String taxCode,
			int numberOfDependents, String dependentNames,
			String insurranceCode, String healthInsuranceNo) {
		try {
			final long employeeId = CounterLocalServiceUtil.increment();
			final Emp employee = createEmp(employeeId);
			return setInfoToEmp(employee, employeeCode, titlesId, unitGroupId,
					unitId, departmentId, levelId, promotedDate, joinedDate,
					laborContractSignedDate, laborContractExpiredDate,
					laborContractType, laborContractSignedTime, dob, gender,
					placeOfBirth, education, educationSpecialize,
					specializedId, universityId, maritalStatus, identityCardNo,
					issuedDate, issuedPlace, contactNumber,
					companyEmailAddress, taxCode, numberOfDependents,
					dependentNames, insurranceCode, healthInsuranceNo);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;

	}

	private Emp setInfoToEmp(
			// NOSONAR
			Emp employee, String employeeCode, long titlesId, long unitGroupId,
			long unitId, long departmentId, long levelId, Date promotedDate,
			Date joinedDate, Date laborContractSignedDate,
			Date laborContractExpiredDate, String laborContractType,
			int laborContractSignedTime, Date dob, String gender,
			String placeOfBirth, String education, String educationSpecialize,
			long specializedId, long universityId, String maritalStatus,
			String identityCardNo, Date issuedDate, String issuedPlace,
			String contactNumber, String companyEmailAddress, String taxCode,
			int numberOfDependents, String dependentNames,
			String insurranceCode, String healthInsuranceNo) {
		employee.setEmpCode(employeeCode);
		employee.setContactNumber(contactNumber);
		employee.setDepartmentId(departmentId);
		employee.setUnitId(unitId);
		employee.setUnitGroupId(unitGroupId);
		employee.setTitlesId(titlesId);
		employee.setLevelId(levelId);
		employee.setPromotedDate(promotedDate);
		employee.setJoinedDate(joinedDate);
		employee.setLaborContractSignedDate(laborContractSignedDate);
		employee.setLaborContractExpiredDate(laborContractExpiredDate);
		employee.setLaborContractType(laborContractType);
		employee.setLaborContractSignedTime(laborContractSignedTime);
		employee.setBirthday(dob);
		employee.setGender(gender);
		employee.setPlaceOfBirth(placeOfBirth);
		employee.setEducation(education);
		employee.setEducationSpecialize(educationSpecialize);
		employee.setSpecializeId(specializedId);
		employee.setUniversityId(universityId);
		employee.setMaritalStatus(maritalStatus);
		employee.setIdentityCardNo(identityCardNo);
		employee.setIssuedDate(issuedDate);
		employee.setIssuedPlace(issuedPlace);
		employee.setPersonalTaxCode(taxCode);
		employee.setNumberOfDependents(numberOfDependents);
		employee.setDependentNames(dependentNames);
		employee.setSocialInsuranceNo(insurranceCode);
		employee.setHealthInsuranceNo(healthInsuranceNo);
		return employee;
	}

	public String getViFullnameFromUser(User user) {
		return StringUtils.trimToEmpty(user.getLastName()) + " "
				+ StringUtils.trimToEmpty(user.getMiddleName()) + " "
				+ StringUtils.trimToEmpty(user.getFirstName());
	}

	public Emp updateEmpAddresses(String empCode, String address,
			District district, Region region, long countryId,
			boolean isPrimary, ServiceContext serviceContext)
			throws PortalException, SystemException {
		// first remove all current emp's addresses
		Emp emp = findByEmpCode(empCode);
		if (emp != null) {
			final long empId = emp.getEmpId();
			final String street3 = region.getRegionCode() + "_"
					+ district.getName();
			LOGGER.info("Call add " + emp.getEmpCode() + " address service");
			Address obj = AddressLocalServiceUtil
					.createAddress(counterLocalService.increment());
			String street1 = address;
			String street2 = StringUtils.EMPTY;
			if (address.contains(";")) {
				street1 = address.split(";")[0];
				street2 = address.split(";")[1];
			}

			obj.setUserId(serviceContext.getUserId());
			obj.setCompanyId(serviceContext.getCompanyId());
			obj.setCreateDate(new Date());
			obj.setModifiedDate(new Date());

			obj.setClassName(Emp.class.getName());
			obj.setClassPK(empId);
			obj.setStreet1(street1);
			obj.setStreet2(street2);
			obj.setStreet3(street3);
			obj.setRegionId(region.getRegionId());
			obj.setCountryId(countryId);
			obj.setZip(VN_ZIP_CODE);
			AddressLocalServiceUtil.addAddress(obj);

			Emp result = empPersistence.update(emp);
			if (result != null) {
				resourceLocalService.updateResources(result.getCompanyId(),
						result.getGroupId(), Emp.class.getName(),
						result.getEmpId(),
						serviceContext.getGroupPermissions(),
						serviceContext.getGuestPermissions());

				// re-index modified employee
				Indexer indexer = IndexerRegistryUtil
						.nullSafeGetIndexer(Emp.class);
				indexer.reindex(result);
			}
			return result;
		}
		return null;
	}

	public void removeAllExistingEmpAddresses(String empCode, long companyId) {
		Emp emp = findByEmpCode(empCode);
		if (emp != null)
			removeAllExistingEmpAddresses(emp.getEmpId(), companyId);
	}

	public void removeAllExistingEmpAddresses(long empId, long companyId) {
		try {
			List<Address> empAddresses = AddressLocalServiceUtil.getAddresses(
					companyId, Emp.class.getName(), empId);
			for (Address address : empAddresses) {
				AddressLocalServiceUtil.deleteAddress(address.getAddressId());
			}
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
	}

	@Override
	public List<Document> searchAllEmpDocs(SearchContext searchContext,
			List<Query> queries, long companyId) {
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);

		try {
			for (Query query : queries) {
				fullQuery.add(query, BooleanClauseOccur.MUST);
			}

			LogFactoryUtil.getLog(fullQuery.toString());

			return SearchEngineUtil.search(
					SearchEngineUtil.getDefaultSearchEngineId(), companyId,
					fullQuery, new Sort("empId", false), QueryUtil.ALL_POS,
					QueryUtil.ALL_POS).toList();
		} catch (SearchException e) {
			LOGGER.info(e);
		} catch (ParseException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public Document getIndexedEmp(String employeeIdString,
			SearchContext searchContext) {
		return getIndexedEmp(Long.valueOf(employeeIdString), searchContext);
	}

	@Override
	public Document getIndexedEmp(long employeeId, SearchContext searchContext) {
		searchContext.setPortletIds(new String[] { EMInfo.PORTLET_ID });
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				Emp.class.getName());
		booleanQuery.addExactTerm(EmpField.EMP_ID, employeeId);

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

	@Override
	public Emp markDeletedEmp(Emp employee) {
		try {
			employee.setDeleted(true);

			employee = empPersistence.update(employee); // NOSONAR

			// re-index modified employee
			Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Emp.class
					.getName());
			indexer.reindex(employee);
			return employee;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (SearchException e) {
			LOGGER.info(e);
		}
		return null;

	}

	@Override
	public Emp markDeletedEmp(long employeeId) {
		try {
			return markDeletedEmp(empPersistence.fetchByPrimaryKey(employeeId));
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	/*
	 * =================== OTHER FUNCTIONALITIES ===================
	 */
	@Override
	public void indexAllEmps() {
		final Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(Emp.class.getName());
		final List<Emp> allEmps = findAll();
		for (Emp employee : allEmps) {
			// index employee
			try {
				indexer.reindex(employee);
			} catch (SearchException e) {
				LOGGER.info(e);
			}
		}

	}

	@Override
	public void indexSomeEmps() {
		final Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(Emp.class.getName());
		final List<Emp> emps = findAll(1, 10);
		for (Emp employee : emps) {
			// index employee
			try {
				indexer.reindex(employee);
			} catch (SearchException e) {
				LOGGER.info(e);
			}
		}

	}

	@Override
	public void removeAllEmpIndexes(SearchContext searchContext, long companyId) {
		final BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		booleanQuery.addExactTerm(Field.ENTRY_CLASS_NAME, Emp.class.getName());
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

	@Override
	public void completelyRemoveAllEmp(long companyId) {
		List<Emp> allEmps = findAll();
		try {
			for (Emp employee : allEmps) {
				// delete user first
				long userId = employee.getEmpUserId();
				final User user = userLocalService.deleteUser(userId);
				if (user != null) {
					final List<Address> employeeAddresses = AddressLocalServiceUtil
							.getAddresses(companyId, Emp.class.getName(),
									employee.getEmpId());
					for (Address address : employeeAddresses) {
						AddressLocalServiceUtil.deleteAddress(address
								.getAddressId());
					}

					Indexer indexer = IndexerRegistryUtil
							.nullSafeGetIndexer(Emp.class.getName());
					indexer.delete(employee);

					// delete promoted info of employee
					for (PromotedHistory p : promotedHistoryLocalService
							.findByEmployee(employee.getEmpId())) {
						promotedHistoryLocalService.deletePromotedHistory(p
								.getPromotedHistoryId());
					}

					// delete resignation info of employee
					for (ResignationHistory r : resignationHistoryLocalService
							.findByEmployee(employee.getEmpId())) {
						resignationHistoryLocalService
								.deleteResignationHistory(r
										.getResignationHistoryId());
					}

					LOGGER.debug("On Deleting Employee: " + employee.getEmpId());
					empLocalService.deleteEmp(employee.getEmpId());

				}
			}
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
	}

	@Override
	public void completelyRemoveAllEmpFromDB(long companyId) {
		List<Emp> allEmps = findAll();
		try {
			for (Emp employee : allEmps) {
				// delete user first
				long userId = employee.getEmpUserId();
				final User user = userLocalService.deleteUser(userId);
				if (user != null) {
					final List<Address> employeeAddresses = AddressLocalServiceUtil
							.getAddresses(companyId, Emp.class.getName(),
									employee.getEmpId());
					for (Address address : employeeAddresses) {
						AddressLocalServiceUtil.deleteAddress(address
								.getAddressId());
					}

					// delete promoted info of employee
					for (PromotedHistory p : promotedHistoryLocalService
							.findByEmployee(employee.getEmpId())) {
						promotedHistoryLocalService.deletePromotedHistory(p
								.getPromotedHistoryId());
					}

					// delete resignation info of employee
					for (ResignationHistory r : resignationHistoryLocalService
							.findByEmployee(employee.getEmpId())) {
						resignationHistoryLocalService
								.deleteResignationHistory(r
										.getResignationHistoryId());
					}

					LOGGER.debug("On Deleting Employee: " + employee.getEmpId());
					empLocalService.deleteEmp(employee.getEmpId());

				}
			}
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
	}

	// FOR USER
	public String getUserEmployeeCodeValue(long userId, long companyId) {
		long userClassNameId = ClassNameLocalServiceUtil
				.getClassNameId(User.class.getName());
		ExpandoTable table;
		try {
			table = ExpandoTableLocalServiceUtil.getDefaultTable(companyId,
					userClassNameId);
			ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(
					table.getTableId(), "Employeeid");

			ExpandoValue expandoValue = ExpandoValueLocalServiceUtil.getValue(
					table.getTableId(), column.getColumnId(), userId);
			return expandoValue != null ? StringUtils.trimToEmpty(expandoValue
					.getString()) : "0";
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return "0";
	}

	public void addOrUpdateUserEmployeeCodeValue(String employeeCode,
			long userId, long companyId) {
		long userClassNameId = ClassNameLocalServiceUtil
				.getClassNameId(User.class.getName());
		ExpandoTable table;
		try {
			table = ExpandoTableLocalServiceUtil.getDefaultTable(companyId,
					userClassNameId);
			ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(
					table.getTableId(), "Employeeid");

			ExpandoValueLocalServiceUtil.addValue(userClassNameId,
					table.getTableId(), column.getColumnId(), userId,
					employeeCode);
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}

	public boolean isUserExisted(String generatedScreenName,
			String employeeCode, Date empDoB, long companyId) {
		try {
			User existedUser = userLocalService.fetchUserByScreenName(
					companyId, generatedScreenName);
			if (existedUser != null) {
				String userEmployeeCode = getUserEmployeeCodeValue(
						existedUser.getUserId(), companyId);
				if (userEmployeeCode.length() == 4) { // means need to add "9"
					userEmployeeCode = MISSING_EMPLOYEE_CODE_CHAR
							+ userEmployeeCode;
				}
				if (userEmployeeCode.equalsIgnoreCase(employeeCode)) {
					return true;
				}

				// if not check to birthday
				return isSameOrWrongOrderDoB(empDoB, existedUser.getBirthday());
			}

		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return false;
	}

	public boolean isSameOrWrongOrderDoB(Date empDob, Date userEmpDob) {
		if (empDob == null || userEmpDob == null)
			return false;

		if (empDob.equals(userEmpDob))
			return true;

		// Next, check if user enter wrong format because of locale's setting
		// example: 12/02/2015 means Dec 02 2015 but the user think that it was
		// 12 Feb 2015

		boolean isReverseMonthEqual = false;
		boolean isReverseDayEqual = false;

		final Calendar calendar = Calendar.getInstance();

		calendar.setTime(empDob);
		int empDobDay = calendar.get(Calendar.DAY_OF_MONTH);
		int empDobMonth = calendar.get(Calendar.MONTH) + 1;
		int empDobYear = calendar.get(Calendar.YEAR);

		calendar.setTime(userEmpDob);
		int userEmpDobDay = calendar.get(Calendar.DAY_OF_MONTH);
		int userEmpDobMonth = calendar.get(Calendar.MONTH) + 1;
		int userEmpDobYear = calendar.get(Calendar.YEAR);

		if (empDobYear != userEmpDobYear)
			return false;

		isReverseMonthEqual = empDobMonth == userEmpDobDay;

		isReverseDayEqual = empDobDay == userEmpDobMonth;

		return isReverseMonthEqual && isReverseDayEqual;
	}

	public String regenerateDuplicateEmailAddress(String emailAddress,
			int number, long companyId) throws SystemException {
		String prefixEmailAddress = emailAddress.split("@")[0];
		prefixEmailAddress = prefixEmailAddress + number;
		String email = prefixEmailAddress + "@ecopharma.com.vn";
		if (userLocalService.fetchUserByEmailAddress(companyId, email) == null) {
			return email;
		}
		number = number + 1;
		return regenerateDuplicateEmailAddress(prefixEmailAddress, number,
				companyId);
	}

	public List<Address> findAllEmpAddress(long companyId, long employeeId) {
		try {
			return AddressLocalServiceUtil.getAddresses(companyId,
					Emp.class.getName(), employeeId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public Address getPresentAddress(long companyId, long employeeId) {
		List<Address> empAddresses = findAllEmpAddress(companyId, employeeId);
		if (empAddresses.isEmpty())
			return null;
		return empAddresses.get(0);
	}

	public List<Emp> getEmpsFromEmpNotifyEmails(
			List<EmpNotifyEmail> empNotifyEmails) throws SystemException {
		final List<Emp> emps = new ArrayList<>();
		for (EmpNotifyEmail item : empNotifyEmails)
			emps.add(fetchEmp(item.getEmpId()));
		return emps;
	}

	public Set<Department> getUniqueDepartmentsFromEmps(List<Emp> emps)
			throws SystemException {
		Set<Department> departments = new HashSet<>();
		for (Emp item : emps)
			departments.add(departmentLocalService.fetchDepartment(item
					.getDepartmentId()));
		return departments;
	}

	public Set<String> getAllManagerEmailsFromDepartments(
			Collection<Department> departments) throws SystemException {
		final List<EmpOrgRelationship> empManagers = new ArrayList<>();
		for (Department department : departments) {
			EmpOrgRelationship obj = empOrgRelationshipLocalService
					.fetchByClassNameClassPKHeadOfOrg(
							Department.class.getName(),
							department.getDepartmentId(), true);
			if (obj != null)
				empManagers.add(obj);
		}

		Set<Emp> uniqueManagers = getEmpsByEmpOrgRelationships(empManagers);
		Set<User> uniqueManagerUsers = getUsersByEmps(uniqueManagers);
		return getEmailsFromUsers(uniqueManagerUsers);
	}

	public Set<User> getUsersByEmps(Collection<Emp> emps)
			throws SystemException {
		Set<User> users = new HashSet<>();

		for (Emp emp : emps) {
			users.add(userLocalService.fetchUser(emp.getEmpUserId()));
		}
		return users;
	}

	public Set<String> getEmailsFromUsers(Collection<User> users) {
		Set<String> emails = new HashSet<>();
		for (User u : users)
			emails.add(u.getEmailAddress());
		return emails;
	}

	public Set<String> getEmailsFromEmps(Collection<Emp> emps)
			throws SystemException {
		Set<User> users = getUsersByEmps(emps);
		return getEmailsFromUsers(users);
	}

	public Set<Emp> getEmpsByEmpOrgRelationships(
			List<EmpOrgRelationship> empManagers) throws SystemException {
		Set<Emp> managers = new HashSet<>();
		for (EmpOrgRelationship item : empManagers)
			managers.add(fetchEmp(item.getEmpId()));
		return managers;
	}

	public Set<String> getManagerEmailsForNewEmpsNotification(List<Emp> emps)
			throws SystemException {
		Set<Department> departmentsByEmps = getUniqueDepartmentsFromEmps(emps);
		return getAllManagerEmailsFromDepartments(departmentsByEmps);
	}

	public String getNewEmployeesHtmlTable(List<Emp> emps) {
		StringBuilder builder = new StringBuilder();
		builder.append("<table border='1' cellpadding='0' cellspacing='0' width='1200px' style='border-collapse:collapse; font-family: arial; font-size: 14px;'>");
		builder.append("	<tr style='height: 50px; text-align: center; color: #0027C2; font-weight: bold; background-color: yellow;'>");
		builder.append("		<td>Stt</td>");
		builder.append("		<td>MSNV</td>");
		builder.append("		<td>Họ và tên</td>");
		builder.append("		<td>Phòng ban</td>");
		builder.append("		<td>Chức danh</td>");
		builder.append("		<td>Ngày nhận việc</td>");
		builder.append("		<td>Email</td>");
		builder.append("	</tr>");
		int count = 0;
		String empCode = StringUtils.EMPTY;
		String fullName = StringUtils.EMPTY;
		String titles = StringUtils.EMPTY;
		String dept = StringUtils.EMPTY;
		String joinedDate = StringUtils.EMPTY;
		// String workingPlace = StringUtils.EMPTY;
		String email = StringUtils.EMPTY;
		SimpleDateFormat sdf = new SimpleDateFormat(COMMON_DATE_FORMAT);
		for (Emp emp : emps) {
			try {
				User userByEmp = userLocalService.fetchUser(emp.getEmpUserId());
				count++;
				empCode = emp.getEmpCode();
				fullName = getViFullnameFromUser(userByEmp);
				titles = titlesLocalService.fetchTitles(emp.getTitlesId())
						.getName();
				dept = departmentLocalService.fetchDepartment(
						emp.getDepartmentId()).getName();
				joinedDate = sdf.format(emp.getJoinedDate());
				email = userByEmp.getEmailAddress();
				builder.append("	<tr style='height: 40px; text-align: center;'>");
				builder.append("		<td>" + count + "</td>");
				builder.append("		<td>" + empCode + "</td>");
				builder.append("		<td>" + fullName + "</td>");
				builder.append("		<td>" + dept + "</td>");
				builder.append("		<td>" + titles + "</td>");
				builder.append("		<td>" + joinedDate + "</td>");
				builder.append("		<td>" + email + "</td>");
				builder.append("	</tr>");
			} catch (SystemException e) {
				LOGGER.info(e);
			}
		}

		builder.append("</table>");

		return builder.toString();
	}

	public String getEntireNewEmployeesHtmlMailContent(List<Emp> emps) {
		StringBuilder builder = new StringBuilder();
		builder.append("<body style='font-family: arial; font-size: 14px;'>");
		builder.append("<p>Phòng HCNS trân trọng thông báo thông tin nhân sự sắp nhận việc đến các Đơn vị/Bộ phận có liên quan như sau:</p>");
		builder.append(getNewEmployeesHtmlTable(emps));
		builder.append("<p>Đề nghị các đơn vị có liên quan thực hiện công tác chuẩn bị thật chu đáo và hoàn tất trước ngày nhân sự nhận việc ít nhất 3 ngày ");
		builder.append("(trừ trường hợp nhận việc ngay) để thể hiện sự chuyên nghiệp, thân thiện của Công ty và sự tôn trọng đối với nhân sự mới.</p>");
		builder.append("Trân trọng,<br />");
		builder.append("Phòng HCNS");
		builder.append("</body>");
		return builder.toString();
	}

	public boolean sendNewEmpsNotificationEmail(List<Emp> emps) {

		try {
			Set<String> managerEmails = getManagerEmailsForNewEmpsNotification(emps);
			LOGGER.info("Managers : " + managerEmails);
			List<String> receivers = new ArrayList<>();

			receivers.addAll(Arrays.asList("tvphuc@ecopharma.com.vn",
					"htanh@ecopharma.com.vn", "vttinh@ecopharma.com.vn",
					"dtkthu@ecopharma.com.vn", "nty@ecopharma.com.vn",
					"ltmtrang@ecopharma.com.vn", "htnhoa@ecopharma.com.vn",
					"ntthuy@ecopharma.com.vn", "nvanchung@ecopharma.com.vn"));
			receivers.addAll(managerEmails);

			InternetAddress[] to = new InternetAddress[receivers.size()];
			int i = 0;
			for (String s : receivers) {
				to[i] = new InternetAddress(s);
				i++;
			}
			// if (LOGGER.isDebugEnabled())
			LOGGER.info(to);

			InternetAddress[] cc = new InternetAddress[] {
					new InternetAddress("pcnhan@ecopharma.com.vn"),
					new InternetAddress("hvvinh@ecopharma.com.vn"),
					new InternetAddress("vtvtan@ecopharma.com.vn"),
					new InternetAddress("ntttien@ecopharma.com.vn"),
					new InternetAddress("ltovy@ecopharma.com.vn"),
					new InternetAddress("tvtao@ecopharma.com.vn") };

			InternetAddress from = new InternetAddress("admin@ecopharma.com.vn");

			String emailContent = getEntireNewEmployeesHtmlMailContent(emps);

			MailEngine.send(from, to, cc, "Thông tin nhân sự sắp nhận việc",
					emailContent, true);

			LOGGER.info("TO: " + to.toString());
			LOGGER.info("CC: " + cc.toString());
			LOGGER.info("CONTENT: " + emailContent);

			return true;

		} catch (AddressException e) {
			LOGGER.info(e);
		} catch (MailEngineException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return false;
	}

	public boolean testSendNewEmpsNotificationEmail(List<Emp> emps) {

		try {
			Set<String> managerEmails = getManagerEmailsForNewEmpsNotification(emps);
			LOGGER.info("Managers : " + managerEmails);
			List<String> receivers = new ArrayList<>();

			receivers.addAll(Arrays.asList("tvtao@ecopharma.com.vn"));
			// receivers.addAll(managerEmails);

			InternetAddress[] to = new InternetAddress[receivers.size()];
			int i = 0;
			for (String s : receivers) {
				to[i] = new InternetAddress(s);
				i++;
			}
			// if (LOGGER.isDebugEnabled())
			LOGGER.info(to);

			InternetAddress[] cc = new InternetAddress[] { new InternetAddress(
					"tvtao@ecopharma.com.vn") };

			InternetAddress from = new InternetAddress("tvtao@ecopharma.com.vn");

			String emailContent = getEntireNewEmployeesHtmlMailContent(emps);

			MailEngine.send(from, to, cc, "Thông tin nhân sự sắp nhận việc",
					emailContent, true);

			LOGGER.info("TO: " + to.toString());
			LOGGER.info("CC: " + cc.toString());
			LOGGER.info("CONTENT: " + emailContent);

			return true;

		} catch (AddressException e) {
			LOGGER.info(e);
		} catch (MailEngineException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return false;
	}

	public void fixLaborContractSignedDate() throws java.text.ParseException,
			SystemException {
		List<Emp> emps = findAll();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date createdDateCheck = sdf.parse("01/08/2016");
		Calendar calendar = Calendar.getInstance();
		for (Emp emp : emps) {
			Date createdDate = emp.getCreateDate();
			Date laborContractSignedDate = emp.getLaborContractSignedDate();
			if (createdDate.compareTo(createdDateCheck) < 0
					&& !emp.getLaborContractType().equalsIgnoreCase(
							LaborContractType.PROBATION_CONTRACT.toString())
					&& laborContractSignedDate != null) {
				calendar.setTime(laborContractSignedDate);
				boolean isLastDay = calendar.get(Calendar.DATE) == calendar
						.getActualMaximum(Calendar.DATE);

				if (isLastDay) {
					User user = UserLocalServiceUtil.fetchUser(emp
							.getEmpUserId());
					LOGGER.info(emp.getEmpCode() + "  " + user.getFullName()
							+ "   Signed Date "
							+ sdf.format(calendar.getTime()));

					calendar.set(Calendar.DATE, 1);
					calendar.add(Calendar.MONTH, 1);

					LOGGER.info("Will be Changed to: "
							+ sdf.format(calendar.getTime()));

					emp.setLaborContractSignedDate(calendar.getTime());
					updateEmp(emp);

				}

			}
		}
	}

	/* Util Functions */

	public String generateOriginalUsername(String fullname) {
		if (StringUtils.trimToNull(fullname) == null)
			return StringUtils.EMPTY;
		fullname = StringUtils.stripAccents(fullname); // NOSONAR
		LOGGER.info("FULL NAME AFTER STRIPPING ACCENTS: " + fullname);

		StringBuilder resultBuilder = new StringBuilder();
		char firstChar = getLastName(fullname).toCharArray()[0];

		String[] middleNameArr = getMiddleName(fullname).split(" ");
		char[] middleNameChars;
		if (middleNameArr.length > 0 && middleNameArr[0] != StringUtils.EMPTY) {
			middleNameChars = new char[middleNameArr.length];
			for (int i = 0; i < middleNameChars.length; i++) {
				middleNameChars[i] = middleNameArr[i].charAt(0);
			}
		} else {
			middleNameChars = null;
		}

		resultBuilder.append(firstChar);
		if (middleNameChars != null) {
			resultBuilder.append(middleNameChars);
		}
		resultBuilder.append(getFirstName(fullname));
		String resultString = resultBuilder.toString().toLowerCase();
		resultString = resultString.replaceAll("đ", "d");
		LOGGER.info("USERNAME AFTER STRIPPING ACCENTS: " + fullname);
		return resultString;
	}

	/**
	 * recursive generate username in case of duplicating
	 * 
	 * @param currentUsername
	 * @param increment
	 * @param serviceContext
	 * @return
	 */
	public String regenerateUsername(String currentUsername, int increment,
			ServiceContext serviceContext) {

		try {
			if (UserLocalServiceUtil.fetchUserByScreenName(
					serviceContext.getCompanyId(), currentUsername) == null) {
				return currentUsername;
			}

			if (increment > 1) {
				currentUsername = currentUsername.substring(0, // NOSONAR
						currentUsername.length() - 1) + increment;
			} else {
				currentUsername = currentUsername + increment; // NOSONAR
			}

			increment += 1; // NOSONAR
			return regenerateUsername(currentUsername, increment,
					serviceContext);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return currentUsername;
	}

	public String checkAndGenerateUsernameByFullname(String fullName,
			ServiceContext serviceContext) {
		String uncheckedUsername = generateOriginalUsername(fullName);
		return regenerateUsername(uncheckedUsername, 1, serviceContext);
	}

	public String generateEmailByUsername(String username, String emailSufix) {
		return username + emailSufix;
	}

	/**
	 * @param fullname
	 * @return
	 */
	public String getLastName(String fullname) {
		return StringUtils.trimToNull(fullname) == null ? StringUtils.EMPTY
				: fullname.split(" ")[0];
	}

	/**
	 * @param fullname
	 * @return
	 */
	public String getMiddleName(String fullname) {
		if (StringUtils.trimToNull(fullname) == null)
			return StringUtils.EMPTY;

		String[] fullnameArr = fullname.split(" ");
		int length = fullnameArr.length;
		// check if employee just have first and last name only
		if (length == 2) {
			return StringUtils.EMPTY;
		}
		String middleName = StringUtils.EMPTY;
		for (int i = 1; i < length - 1; i++) {
			middleName += fullnameArr[i] + " ";
		}
		return middleName;
	}

	/**
	 * @param fullname
	 * @return
	 */
	public String getFirstName(String fullname) {
		if (StringUtils.trimToNull(fullname) == null)
			return StringUtils.EMPTY;
		String[] fullnameArr = fullname.split(" ");
		return fullnameArr[fullnameArr.length - 1];
	}

}