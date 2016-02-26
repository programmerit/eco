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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmpLocalService}.
 *
 * @author tvt
 * @see EmpLocalService
 * @generated
 */
public class EmpLocalServiceWrapper implements EmpLocalService,
	ServiceWrapper<EmpLocalService> {
	public EmpLocalServiceWrapper(EmpLocalService empLocalService) {
		_empLocalService = empLocalService;
	}

	/**
	* Adds the emp to the database. Also notifies the appropriate model listeners.
	*
	* @param emp the emp
	* @return the emp that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Emp addEmp(
		vn.com.ecopharma.emp.model.Emp emp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.addEmp(emp);
	}

	/**
	* Creates a new emp with the primary key. Does not add the emp to the database.
	*
	* @param empId the primary key for the new emp
	* @return the new emp
	*/
	@Override
	public vn.com.ecopharma.emp.model.Emp createEmp(long empId) {
		return _empLocalService.createEmp(empId);
	}

	/**
	* Deletes the emp with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empId the primary key of the emp
	* @return the emp that was removed
	* @throws PortalException if a emp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Emp deleteEmp(long empId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.deleteEmp(empId);
	}

	/**
	* Deletes the emp from the database. Also notifies the appropriate model listeners.
	*
	* @param emp the emp
	* @return the emp that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Emp deleteEmp(
		vn.com.ecopharma.emp.model.Emp emp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.deleteEmp(emp);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp fetchEmp(long empId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.fetchEmp(empId);
	}

	/**
	* Returns the emp with the primary key.
	*
	* @param empId the primary key of the emp
	* @return the emp
	* @throws PortalException if a emp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Emp getEmp(long empId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.getEmp(empId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Emp> getEmps(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.getEmps(start, end);
	}

	/**
	* Returns the number of emps.
	*
	* @return the number of emps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmpsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.getEmpsCount();
	}

	/**
	* Updates the emp in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param emp the emp
	* @return the emp that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Emp updateEmp(
		vn.com.ecopharma.emp.model.Emp emp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.updateEmp(emp);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Emp> findAll() {
		return _empLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Emp> findAll(int start,
		int end) {
		return _empLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Emp> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _empLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp findByEmpCode(
		java.lang.String empCode) {
		return _empLocalService.findByEmpCode(empCode);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp findByUser(long empUserId) {
		return _empLocalService.findByUser(empUserId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Emp> findByTitles(
		long titlesId) {
		return _empLocalService.findByTitles(titlesId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Emp> findResignedEmp() {
		return _empLocalService.findResignedEmp();
	}

	@Override
	public boolean isOnAddingNewWithSameEmployeeCode(long prePersistedEmpId,
		java.lang.String empCode) {
		return _empLocalService.isOnAddingNewWithSameEmployeeCode(prePersistedEmpId,
			empCode);
	}

	@Override
	public int countAllUnDeletedIndexedEmpDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return _empLocalService.countAllUnDeletedIndexedEmpDocuments(searchContext,
			filterQueries, companyId, sort);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedEmpIndexedDocument(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return _empLocalService.searchAllUnDeletedEmpIndexedDocument(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	@Override
	public int countFilterEmployeeByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId)
		throws com.liferay.portal.kernel.search.ParseException {
		return _empLocalService.countFilterEmployeeByFields(searchContext,
			filters, sort, companyId);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> filterEmployeeByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId, int start,
		int end) throws com.liferay.portal.kernel.search.ParseException {
		return _empLocalService.filterEmployeeByFields(searchContext, filters,
			sort, companyId, start, end);
	}

	@Override
	public void createDateTermRangeQuery(java.lang.String field,
		java.util.List<com.liferay.portal.kernel.search.Query> queries,
		java.util.Date dateFrom, java.util.Date dateTo,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		_empLocalService.createDateTermRangeQuery(field, queries, dateFrom,
			dateTo, searchContext);
	}

	@Override
	public com.liferay.portal.kernel.search.Query createStringListQuery(
		java.lang.String property, java.util.List<java.lang.String> values,
		com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.ParseException {
		return _empLocalService.createStringListQuery(property, values,
			searchContext);
	}

	@Override
	public java.lang.String[] getGlobalSearchFields() {
		return _empLocalService.getGlobalSearchFields();
	}

	@Override
	public java.lang.String removeDashChar(java.lang.String s) {
		return _empLocalService.removeDashChar(s);
	}

	@Override
	public java.util.Date getCurrentDateNextYear() {
		return _empLocalService.getCurrentDateNextYear();
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp createPrePersistedEntity(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _empLocalService.createPrePersistedEntity(serviceContext);
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
	@Override
	public vn.com.ecopharma.emp.model.Emp addEmp(
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
		return _empLocalService.addEmp(employee, autoPassword, password1,
			password2, autoScreenName, screenName, emailAddress, facebookId,
			openId, locale, firstName, middleName, lastName, prefixId,
			suffixId, male, birthdayMonth, birthdayDay, birthdayYear, groupIds,
			organizationIds, roleIds, userGroupIds, sendEmail, addresses,
			dependentNameMap, bankInfoMap, isImportAction, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp addEmp(
		vn.com.ecopharma.emp.model.Emp employee,
		com.liferay.portal.model.User user,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.addEmp(employee, user, addressesMap,
			dependentNameMap, bankInfoMap, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp update(
		vn.com.ecopharma.emp.model.Emp employee, long userId, long oldTitlesId,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		boolean isManager, boolean isImportAction,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _empLocalService.update(employee, userId, oldTitlesId,
			addressesMap, dependentNameMap, bankInfoMap, isManager,
			isImportAction, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp update(
		vn.com.ecopharma.emp.model.Emp employee,
		com.liferay.portal.model.User user, long oldTitlesId,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		boolean isManager, boolean isImportAction,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _empLocalService.update(employee, user, oldTitlesId,
			addressesMap, dependentNameMap, bankInfoMap, isManager,
			isImportAction, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp updateExistedEmployee(
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
		return _empLocalService.updateExistedEmployee(employee, employeeCode,
			titlesId, unitGroupId, unitId, departmentId, levelId, promotedDate,
			joinedDate, laborContractSignedDate, laborContractExpiredDate,
			laborContractType, laborContractSignedTime, dob, gender,
			placeOfBirth, education, educationSpecialize, specializedId,
			universityId, maritalStatus, identityCardNo, issuedDate,
			issuedPlace, contactNumber, companyEmailAddress, taxCode,
			numberOfDependents, dependentNames, insurranceCode,
			healthInsuranceNo);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp addOrUpdateWithExistUser(
		vn.com.ecopharma.emp.model.Emp employee,
		com.liferay.portal.model.User user, long oldTitlesId,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		boolean isManager, boolean isImportAction,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _empLocalService.addOrUpdateWithExistUser(employee, user,
			oldTitlesId, addressesMap, dependentNameMap, bankInfoMap,
			isManager, isImportAction, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp addOrUpdateWithExistUser(
		vn.com.ecopharma.emp.model.Emp employee,
		java.lang.String userScreenName, long oldTitlesId,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		boolean isManager, boolean isImportAction,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _empLocalService.addOrUpdateWithExistUser(employee,
			userScreenName, oldTitlesId, addressesMap, dependentNameMap,
			bankInfoMap, isManager, isImportAction, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp createEmployee(
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
		return _empLocalService.createEmployee(employeeCode, titlesId,
			unitGroupId, unitId, departmentId, levelId, promotedDate,
			joinedDate, laborContractSignedDate, laborContractExpiredDate,
			laborContractType, laborContractSignedTime, dob, gender,
			placeOfBirth, education, educationSpecialize, specializedId,
			universityId, maritalStatus, identityCardNo, issuedDate,
			issuedPlace, contactNumber, companyEmailAddress, taxCode,
			numberOfDependents, dependentNames, insurranceCode,
			healthInsuranceNo);
	}

	@Override
	public java.lang.String getViFullnameFromUser(
		com.liferay.portal.model.User user) {
		return _empLocalService.getViFullnameFromUser(user);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp updateEmpAddresses(
		java.lang.String empCode, java.lang.String address,
		vn.com.ecopharma.emp.model.District district,
		com.liferay.portal.model.Region region, long countryId,
		boolean isPrimary,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.updateEmpAddresses(empCode, address, district,
			region, countryId, isPrimary, serviceContext);
	}

	@Override
	public void removeAllExistingEmpAddresses(java.lang.String empCode,
		long companyId) {
		_empLocalService.removeAllExistingEmpAddresses(empCode, companyId);
	}

	@Override
	public void removeAllExistingEmpAddresses(long empId, long companyId) {
		_empLocalService.removeAllExistingEmpAddresses(empId, companyId);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllEmpDocs(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> queries,
		long companyId) {
		return _empLocalService.searchAllEmpDocs(searchContext, queries,
			companyId);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedEmp(
		java.lang.String employeeIdString,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _empLocalService.getIndexedEmp(employeeIdString, searchContext);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedEmp(
		long employeeId,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _empLocalService.getIndexedEmp(employeeId, searchContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp markDeletedEmp(
		vn.com.ecopharma.emp.model.Emp employee) {
		return _empLocalService.markDeletedEmp(employee);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp markDeletedEmp(long employeeId) {
		return _empLocalService.markDeletedEmp(employeeId);
	}

	@Override
	public void indexAllEmps() {
		_empLocalService.indexAllEmps();
	}

	@Override
	public void indexSomeEmps() {
		_empLocalService.indexSomeEmps();
	}

	@Override
	public void removeAllEmpIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		_empLocalService.removeAllEmpIndexes(searchContext, companyId);
	}

	@Override
	public void completelyRemoveAllEmp(long companyId) {
		_empLocalService.completelyRemoveAllEmp(companyId);
	}

	@Override
	public void completelyRemoveAllEmpFromDB(long companyId) {
		_empLocalService.completelyRemoveAllEmpFromDB(companyId);
	}

	@Override
	public java.lang.String getUserEmployeeCodeValue(long userId, long companyId) {
		return _empLocalService.getUserEmployeeCodeValue(userId, companyId);
	}

	@Override
	public void addOrUpdateUserEmployeeCodeValue(
		java.lang.String employeeCode, long userId, long companyId) {
		_empLocalService.addOrUpdateUserEmployeeCodeValue(employeeCode, userId,
			companyId);
	}

	@Override
	public boolean isUserExisted(java.lang.String generatedScreenName,
		java.lang.String employeeCode, java.util.Date empDoB, long companyId) {
		return _empLocalService.isUserExisted(generatedScreenName,
			employeeCode, empDoB, companyId);
	}

	@Override
	public boolean isSameOrWrongOrderDoB(java.util.Date empDob,
		java.util.Date userEmpDob) {
		return _empLocalService.isSameOrWrongOrderDoB(empDob, userEmpDob);
	}

	@Override
	public java.lang.String regenerateDuplicateEmailAddress(
		java.lang.String emailAddress, int number, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.regenerateDuplicateEmailAddress(emailAddress,
			number, companyId);
	}

	@Override
	public java.util.List<com.liferay.portal.model.Address> findAllEmpAddress(
		long companyId, long employeeId) {
		return _empLocalService.findAllEmpAddress(companyId, employeeId);
	}

	@Override
	public com.liferay.portal.model.Address getPresentAddress(long companyId,
		long employeeId) {
		return _empLocalService.getPresentAddress(companyId, employeeId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Emp> getEmpsFromEmpNotifyEmails(
		java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail> empNotifyEmails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.getEmpsFromEmpNotifyEmails(empNotifyEmails);
	}

	@Override
	public java.util.Set<vn.com.ecopharma.emp.model.Department> getUniqueDepartmentsFromEmps(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.getUniqueDepartmentsFromEmps(emps);
	}

	@Override
	public java.util.Set<java.lang.String> getAllManagerEmailsFromDepartments(
		java.util.Collection<vn.com.ecopharma.emp.model.Department> departments)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.getAllManagerEmailsFromDepartments(departments);
	}

	@Override
	public java.util.Set<com.liferay.portal.model.User> getUsersByEmps(
		java.util.Collection<vn.com.ecopharma.emp.model.Emp> emps)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.getUsersByEmps(emps);
	}

	@Override
	public java.util.Set<java.lang.String> getEmailsFromUsers(
		java.util.Collection<com.liferay.portal.model.User> users) {
		return _empLocalService.getEmailsFromUsers(users);
	}

	@Override
	public java.util.Set<java.lang.String> getEmailsFromEmps(
		java.util.Collection<vn.com.ecopharma.emp.model.Emp> emps)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.getEmailsFromEmps(emps);
	}

	@Override
	public java.util.Set<vn.com.ecopharma.emp.model.Emp> getEmpsByEmpOrgRelationships(
		java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship> empManagers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.getEmpsByEmpOrgRelationships(empManagers);
	}

	@Override
	public java.util.Set<java.lang.String> getManagerEmailsForNewEmpsNotification(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLocalService.getManagerEmailsForNewEmpsNotification(emps);
	}

	@Override
	public java.lang.String getNewEmployeesHtmlTable(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps) {
		return _empLocalService.getNewEmployeesHtmlTable(emps);
	}

	@Override
	public java.lang.String getEntireNewEmployeesHtmlMailContent(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps) {
		return _empLocalService.getEntireNewEmployeesHtmlMailContent(emps);
	}

	@Override
	public void sendNewEmpsNotificationEmail(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps) {
		_empLocalService.sendNewEmpsNotificationEmail(emps);
	}

	@Override
	public void getNewEmpsAndSendNotifyEmail() {
		_empLocalService.getNewEmpsAndSendNotifyEmail();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpLocalService getWrappedEmpLocalService() {
		return _empLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpLocalService(EmpLocalService empLocalService) {
		_empLocalService = empLocalService;
	}

	@Override
	public EmpLocalService getWrappedService() {
		return _empLocalService;
	}

	@Override
	public void setWrappedService(EmpLocalService empLocalService) {
		_empLocalService = empLocalService;
	}

	private EmpLocalService _empLocalService;
}