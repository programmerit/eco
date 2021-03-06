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

package vn.com.ecopharma.emp.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Emp. This utility wraps
 * {@link vn.com.ecopharma.emp.service.impl.EmpLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see EmpLocalService
 * @see vn.com.ecopharma.emp.service.base.EmpLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.impl.EmpLocalServiceImpl
 * @generated
 */
public class EmpLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.emp.service.impl.EmpLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the emp to the database. Also notifies the appropriate model listeners.
	*
	* @param emp the emp
	* @return the emp that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp addEmp(
		vn.com.ecopharma.emp.model.Emp emp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEmp(emp);
	}

	/**
	* Creates a new emp with the primary key. Does not add the emp to the database.
	*
	* @param empId the primary key for the new emp
	* @return the new emp
	*/
	public static vn.com.ecopharma.emp.model.Emp createEmp(long empId) {
		return getService().createEmp(empId);
	}

	/**
	* Deletes the emp with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empId the primary key of the emp
	* @return the emp that was removed
	* @throws PortalException if a emp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp deleteEmp(long empId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmp(empId);
	}

	/**
	* Deletes the emp from the database. Also notifies the appropriate model listeners.
	*
	* @param emp the emp
	* @return the emp that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp deleteEmp(
		vn.com.ecopharma.emp.model.Emp emp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmp(emp);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static vn.com.ecopharma.emp.model.Emp fetchEmp(long empId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEmp(empId);
	}

	/**
	* Returns the emp with the primary key.
	*
	* @param empId the primary key of the emp
	* @return the emp
	* @throws PortalException if a emp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp getEmp(long empId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmp(empId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the emps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emps
	* @param end the upper bound of the range of emps (not inclusive)
	* @return the range of emps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Emp> getEmps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmps(start, end);
	}

	/**
	* Returns the number of emps.
	*
	* @return the number of emps
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmpsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpsCount();
	}

	/**
	* Updates the emp in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param emp the emp
	* @return the emp that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp updateEmp(
		vn.com.ecopharma.emp.model.Emp emp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEmp(emp);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Emp> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Emp> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Emp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static vn.com.ecopharma.emp.model.Emp findByEmpCode(
		java.lang.String empCode) {
		return getService().findByEmpCode(empCode);
	}

	public static vn.com.ecopharma.emp.model.Emp findByUser(long empUserId) {
		return getService().findByUser(empUserId);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Emp> findByTitles(
		long titlesId) {
		return getService().findByTitles(titlesId);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Emp> findResignedEmp() {
		return getService().findResignedEmp();
	}

	public static boolean isOnAddingNewWithSameEmployeeCode(
		long prePersistedEmpId, java.lang.String empCode) {
		return getService()
				   .isOnAddingNewWithSameEmployeeCode(prePersistedEmpId, empCode);
	}

	public static int countAllUnDeletedIndexedEmpDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return getService()
				   .countAllUnDeletedIndexedEmpDocuments(searchContext,
			filterQueries, companyId, sort);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedEmpIndexedDocument(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return getService()
				   .searchAllUnDeletedEmpIndexedDocument(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	public static int countFilterEmployeeByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId)
		throws com.liferay.portal.kernel.search.ParseException {
		return getService()
				   .countFilterEmployeeByFields(searchContext, filters, sort,
			companyId);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> filterEmployeeByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId, int start,
		int end) throws com.liferay.portal.kernel.search.ParseException {
		return getService()
				   .filterEmployeeByFields(searchContext, filters, sort,
			companyId, start, end);
	}

	/**
	* @param query
	* @param searchContext
	* @param start
	* @param end
	* @return
	* @throws ParseException
	*/
	public static java.util.List<com.liferay.portal.kernel.search.Document> filterEmployeeByAutocompleteQuery(
		java.lang.String query,
		com.liferay.portal.kernel.search.SearchContext searchContext,
		int start, int end)
		throws com.liferay.portal.kernel.search.ParseException {
		return getService()
				   .filterEmployeeByAutocompleteQuery(query, searchContext,
			start, end);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> filterEmployeeByAutocompleteQuery(
		java.lang.String query,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.SearchContext searchContext,
		int start, int end)
		throws com.liferay.portal.kernel.search.ParseException {
		return getService()
				   .filterEmployeeByAutocompleteQuery(query, filters,
			searchContext, start, end);
	}

	public static boolean isOrganizationFilter(java.lang.String filterProperty) {
		return getService().isOrganizationFilter(filterProperty);
	}

	public static void createDateTermRangeQuery(java.lang.String field,
		java.util.List<com.liferay.portal.kernel.search.Query> queries,
		java.util.Date dateFrom, java.util.Date dateTo,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		getService()
			.createDateTermRangeQuery(field, queries, dateFrom, dateTo,
			searchContext);
	}

	public static com.liferay.portal.kernel.search.Query createDateTermRangeQuery(
		java.lang.String field, java.util.Date dateFrom, java.util.Date dateTo,
		boolean includesLower, boolean includesUpper,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService()
				   .createDateTermRangeQuery(field, dateFrom, dateTo,
			includesLower, includesUpper, searchContext);
	}

	public static com.liferay.portal.kernel.search.Query createStringListQuery(
		java.lang.String property, java.util.List<java.lang.String> values,
		com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.ParseException {
		return getService()
				   .createStringListQuery(property, values, searchContext);
	}

	public static java.lang.String[] getGlobalSearchFields() {
		return getService().getGlobalSearchFields();
	}

	public static java.lang.String[] getAutocompleteSearchFields() {
		return getService().getAutocompleteSearchFields();
	}

	public static java.lang.String removeDashChar(java.lang.String s) {
		return getService().removeDashChar(s);
	}

	public static java.util.Date getCurrentDateNextYear() {
		return getService().getCurrentDateNextYear();
	}

	public static vn.com.ecopharma.emp.model.Emp createPrePersistedEntity(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().createPrePersistedEntity(serviceContext);
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
	use to determine wherether emp is imported or create. (For
	notify)
	* @param serviceContext
	* @return
	* @throws SystemException
	* @throws PortalException
	*/
	public static vn.com.ecopharma.emp.model.Emp addEmp(
		vn.com.ecopharma.emp.model.Emp employee,
		com.liferay.portal.model.User generatedUser, boolean autoPassword,
		java.lang.String password1, java.lang.String password2,
		boolean autoScreenName, java.lang.String screenName, boolean male,
		boolean sendEmail,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addresses,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpLaborContract, java.lang.Boolean> contractInfoMap,
		boolean isImportAction,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEmp(employee, generatedUser, autoPassword, password1,
			password2, autoScreenName, screenName, male, sendEmail, addresses,
			dependentNameMap, bankInfoMap, contractInfoMap, isImportAction,
			serviceContext);
	}

	public static vn.com.ecopharma.emp.model.Emp addEmp(
		vn.com.ecopharma.emp.model.Emp employee,
		com.liferay.portal.model.User user,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEmp(employee, user, addressesMap, dependentNameMap,
			bankInfoMap, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.Emp addEmp(
		vn.com.ecopharma.emp.model.Emp employee, boolean autoPassword,
		java.lang.String password1, java.lang.String password2,
		boolean autoScreenName, java.lang.String screenName,
		java.lang.String emailAddress, long facebookId,
		java.lang.String openId, java.util.Locale locale,
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, int prefixId, int suffixId, boolean male,
		int birthdayMonth, int birthdayDay, int birthdayYear, long[] groupIds,
		long[] organizationIds, long[] roleIds, long[] userGroupIds,
		boolean sendEmail,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addresses,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		boolean isImportAction,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEmp(employee, autoPassword, password1, password2,
			autoScreenName, screenName, emailAddress, facebookId, openId,
			locale, firstName, middleName, lastName, prefixId, suffixId, male,
			birthdayMonth, birthdayDay, birthdayYear, groupIds,
			organizationIds, roleIds, userGroupIds, sendEmail, addresses,
			dependentNameMap, bankInfoMap, isImportAction, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.Emp update(
		vn.com.ecopharma.emp.model.Emp employee, long userId, long oldTitlesId,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpLaborContract, java.lang.Boolean> contractInfoMap,
		boolean isImportAction,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .update(employee, userId, oldTitlesId, addressesMap,
			dependentNameMap, bankInfoMap, contractInfoMap, isImportAction,
			serviceContext);
	}

	public static vn.com.ecopharma.emp.model.Emp update(
		vn.com.ecopharma.emp.model.Emp employee,
		com.liferay.portal.model.User user, long oldTitlesId,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpLaborContract, java.lang.Boolean> contractInfoMap,
		boolean isImportAction,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .update(employee, user, oldTitlesId, addressesMap,
			dependentNameMap, bankInfoMap, contractInfoMap, isImportAction,
			serviceContext);
	}

	public static vn.com.ecopharma.emp.model.Emp updateExistedEmployee(
		vn.com.ecopharma.emp.model.Emp employee, java.lang.String employeeCode,
		long titlesId, long unitGroupId, long unitId, long departmentId,
		long levelId, java.util.Date promotedDate, java.util.Date joinedDate,
		java.util.Date laborContractSignedDate,
		java.util.Date laborContractExpiredDate,
		java.lang.String laborContractType, int laborContractSignedTime,
		java.util.Date dob, java.lang.String gender,
		java.lang.String placeOfBirth, java.lang.String education,
		java.lang.String educationSpecialize, long specializedId,
		long universityId, java.lang.String maritalStatus,
		java.lang.String identityCardNo, java.util.Date issuedDate,
		java.lang.String issuedPlace, java.lang.String contactNumber,
		java.lang.String companyEmailAddress, java.lang.String taxCode,
		int numberOfDependents, java.lang.String dependentNames,
		java.lang.String insurranceCode, java.lang.String healthInsuranceNo) {
		return getService()
				   .updateExistedEmployee(employee, employeeCode, titlesId,
			unitGroupId, unitId, departmentId, levelId, promotedDate,
			joinedDate, laborContractSignedDate, laborContractExpiredDate,
			laborContractType, laborContractSignedTime, dob, gender,
			placeOfBirth, education, educationSpecialize, specializedId,
			universityId, maritalStatus, identityCardNo, issuedDate,
			issuedPlace, contactNumber, companyEmailAddress, taxCode,
			numberOfDependents, dependentNames, insurranceCode,
			healthInsuranceNo);
	}

	public static vn.com.ecopharma.emp.model.Emp addOrUpdateWithExistUser(
		vn.com.ecopharma.emp.model.Emp employee,
		com.liferay.portal.model.User user, long oldTitlesId,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpLaborContract, java.lang.Boolean> contractInfoMap,
		boolean isImportAction,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addOrUpdateWithExistUser(employee, user, oldTitlesId,
			addressesMap, dependentNameMap, bankInfoMap, contractInfoMap,
			isImportAction, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.Emp addOrUpdateWithExistUser(
		vn.com.ecopharma.emp.model.Emp employee,
		java.lang.String userScreenName, long oldTitlesId,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpLaborContract, java.lang.Boolean> contractInfoMap,
		boolean isImportAction,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addOrUpdateWithExistUser(employee, userScreenName,
			oldTitlesId, addressesMap, dependentNameMap, bankInfoMap,
			contractInfoMap, isImportAction, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.Emp createEmployee(
		java.lang.String employeeCode, long titlesId, long unitGroupId,
		long unitId, long departmentId, long levelId,
		java.util.Date promotedDate, java.util.Date joinedDate,
		java.util.Date laborContractSignedDate,
		java.util.Date laborContractExpiredDate,
		java.lang.String laborContractType, int laborContractSignedTime,
		java.util.Date dob, java.lang.String gender,
		java.lang.String placeOfBirth, java.lang.String education,
		java.lang.String educationSpecialize, long specializedId,
		long universityId, java.lang.String maritalStatus,
		java.lang.String identityCardNo, java.util.Date issuedDate,
		java.lang.String issuedPlace, java.lang.String contactNumber,
		java.lang.String companyEmailAddress, java.lang.String taxCode,
		int numberOfDependents, java.lang.String dependentNames,
		java.lang.String insurranceCode, java.lang.String healthInsuranceNo) {
		return getService()
				   .createEmployee(employeeCode, titlesId, unitGroupId, unitId,
			departmentId, levelId, promotedDate, joinedDate,
			laborContractSignedDate, laborContractExpiredDate,
			laborContractType, laborContractSignedTime, dob, gender,
			placeOfBirth, education, educationSpecialize, specializedId,
			universityId, maritalStatus, identityCardNo, issuedDate,
			issuedPlace, contactNumber, companyEmailAddress, taxCode,
			numberOfDependents, dependentNames, insurranceCode,
			healthInsuranceNo);
	}

	public static java.lang.String getViFullnameFromUser(
		com.liferay.portal.model.User user) {
		return getService().getViFullnameFromUser(user);
	}

	public static vn.com.ecopharma.emp.model.Emp updateEmpAddresses(
		java.lang.String empCode, java.lang.String address,
		vn.com.ecopharma.emp.model.District district,
		com.liferay.portal.model.Region region, long countryId,
		boolean isPrimary,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateEmpAddresses(empCode, address, district, region,
			countryId, isPrimary, serviceContext);
	}

	public static void removeAllExistingEmpAddresses(java.lang.String empCode,
		long companyId) {
		getService().removeAllExistingEmpAddresses(empCode, companyId);
	}

	public static void removeAllExistingEmpAddresses(long empId, long companyId) {
		getService().removeAllExistingEmpAddresses(empId, companyId);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllEmpDocs(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> queries,
		long companyId) {
		return getService().searchAllEmpDocs(searchContext, queries, companyId);
	}

	public static com.liferay.portal.kernel.search.Document getIndexedEmp(
		java.lang.String employeeIdString,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getIndexedEmp(employeeIdString, searchContext);
	}

	public static com.liferay.portal.kernel.search.Document getIndexedEmp(
		long employeeId,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getIndexedEmp(employeeId, searchContext);
	}

	public static vn.com.ecopharma.emp.model.Emp markDeletedEmp(
		vn.com.ecopharma.emp.model.Emp employee) {
		return getService().markDeletedEmp(employee);
	}

	public static vn.com.ecopharma.emp.model.Emp markDeletedEmp(long employeeId) {
		return getService().markDeletedEmp(employeeId);
	}

	public static void indexAllEmps() {
		getService().indexAllEmps();
	}

	public static void indexSomeEmps() {
		getService().indexSomeEmps();
	}

	public static void removeAllEmpIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		getService().removeAllEmpIndexes(searchContext, companyId);
	}

	public static void completelyRemoveAllEmp(long companyId) {
		getService().completelyRemoveAllEmp(companyId);
	}

	public static void completelyRemoveAllEmpFromDB(long companyId) {
		getService().completelyRemoveAllEmpFromDB(companyId);
	}

	public static java.lang.String getUserEmployeeCodeValue(long userId,
		long companyId) {
		return getService().getUserEmployeeCodeValue(userId, companyId);
	}

	public static void addOrUpdateUserEmployeeCodeValue(
		java.lang.String employeeCode, long userId, long companyId) {
		getService()
			.addOrUpdateUserEmployeeCodeValue(employeeCode, userId, companyId);
	}

	public static boolean isUserExisted(java.lang.String generatedScreenName,
		java.lang.String employeeCode, java.util.Date empDoB, long companyId) {
		return getService()
				   .isUserExisted(generatedScreenName, employeeCode, empDoB,
			companyId);
	}

	public static boolean isSameOrWrongOrderDoB(java.util.Date empDob,
		java.util.Date userEmpDob) {
		return getService().isSameOrWrongOrderDoB(empDob, userEmpDob);
	}

	public static java.lang.String regenerateDuplicateEmailAddress(
		java.lang.String emailAddress, int number, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .regenerateDuplicateEmailAddress(emailAddress, number,
			companyId);
	}

	public static java.util.List<com.liferay.portal.model.Address> findAllEmpAddress(
		long companyId, long employeeId) {
		return getService().findAllEmpAddress(companyId, employeeId);
	}

	public static com.liferay.portal.model.Address getPresentAddress(
		long companyId, long employeeId) {
		return getService().getPresentAddress(companyId, employeeId);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Emp> getEmpsFromEmpNotifyEmails(
		java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail> empNotifyEmails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpsFromEmpNotifyEmails(empNotifyEmails);
	}

	public static java.util.Set<vn.com.ecopharma.emp.model.Department> getUniqueDepartmentsFromEmps(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUniqueDepartmentsFromEmps(emps);
	}

	public static java.util.Set<java.lang.String> getAllManagerEmailsFromDepartments(
		java.util.Collection<vn.com.ecopharma.emp.model.Department> departments)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllManagerEmailsFromDepartments(departments);
	}

	public static java.util.Set<com.liferay.portal.model.User> getUsersByEmps(
		java.util.Collection<vn.com.ecopharma.emp.model.Emp> emps)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUsersByEmps(emps);
	}

	public static java.util.Set<java.lang.String> getEmailsFromUsers(
		java.util.Collection<com.liferay.portal.model.User> users) {
		return getService().getEmailsFromUsers(users);
	}

	public static java.util.Set<java.lang.String> getEmailsFromEmps(
		java.util.Collection<vn.com.ecopharma.emp.model.Emp> emps)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmailsFromEmps(emps);
	}

	public static java.util.Set<vn.com.ecopharma.emp.model.Emp> getEmpsByEmpOrgRelationships(
		java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship> empManagers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpsByEmpOrgRelationships(empManagers);
	}

	public static java.util.Set<java.lang.String> getManagerEmailsForNewEmpsNotification(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getManagerEmailsForNewEmpsNotification(emps);
	}

	public static java.lang.String getNewEmployeesHtmlTable(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps) {
		return getService().getNewEmployeesHtmlTable(emps);
	}

	public static java.lang.String getEntireNewEmployeesHtmlMailContent(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps) {
		return getService().getEntireNewEmployeesHtmlMailContent(emps);
	}

	public static boolean sendNewEmpsNotificationEmail(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps) {
		return getService().sendNewEmpsNotificationEmail(emps);
	}

	public static boolean testSendNewEmpsNotificationEmail(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps) {
		return getService().testSendNewEmpsNotificationEmail(emps);
	}

	public static void fixLaborContractSignedDate()
		throws com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		getService().fixLaborContractSignedDate();
	}

	public static java.lang.String generateOriginalUsername(
		java.lang.String fullname) {
		return getService().generateOriginalUsername(fullname);
	}

	/**
	* recursive generate username in case of duplicating
	*
	* @param currentUsername
	* @param increment
	* @param serviceContext
	* @return
	*/
	public static java.lang.String regenerateUsername(
		java.lang.String currentUsername, int increment,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .regenerateUsername(currentUsername, increment,
			serviceContext);
	}

	public static java.lang.String checkAndGenerateUsernameByFullname(
		java.lang.String fullName,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .checkAndGenerateUsernameByFullname(fullName, serviceContext);
	}

	public static java.lang.String generateEmailByUsername(
		java.lang.String username, java.lang.String emailSufix) {
		return getService().generateEmailByUsername(username, emailSufix);
	}

	/**
	* @param fullname
	* @return
	*/
	public static java.lang.String getLastName(java.lang.String fullname) {
		return getService().getLastName(fullname);
	}

	/**
	* @param fullname
	* @return
	*/
	public static java.lang.String getMiddleName(java.lang.String fullname) {
		return getService().getMiddleName(fullname);
	}

	/**
	* @param fullname
	* @return
	*/
	public static java.lang.String getFirstName(java.lang.String fullname) {
		return getService().getFirstName(fullname);
	}

	public static void clearService() {
		_service = null;
	}

	public static EmpLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EmpLocalService.class.getName());

			if (invokableLocalService instanceof EmpLocalService) {
				_service = (EmpLocalService)invokableLocalService;
			}
			else {
				_service = new EmpLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EmpLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EmpLocalService service) {
	}

	private static EmpLocalService _service;
}