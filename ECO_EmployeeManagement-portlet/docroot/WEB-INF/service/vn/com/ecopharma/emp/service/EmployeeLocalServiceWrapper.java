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
 * Provides a wrapper for {@link EmployeeLocalService}.
 *
 * @author tvt
 * @see EmployeeLocalService
 * @generated
 */
public class EmployeeLocalServiceWrapper implements EmployeeLocalService,
	ServiceWrapper<EmployeeLocalService> {
	public EmployeeLocalServiceWrapper(
		EmployeeLocalService employeeLocalService) {
		_employeeLocalService = employeeLocalService;
	}

	/**
	* Adds the employee to the database. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Employee addEmployee(
		vn.com.ecopharma.emp.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.addEmployee(employee);
	}

	/**
	* Creates a new employee with the primary key. Does not add the employee to the database.
	*
	* @param employeeId the primary key for the new employee
	* @return the new employee
	*/
	@Override
	public vn.com.ecopharma.emp.model.Employee createEmployee(long employeeId) {
		return _employeeLocalService.createEmployee(employeeId);
	}

	/**
	* Deletes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employeeId the primary key of the employee
	* @return the employee that was removed
	* @throws PortalException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Employee deleteEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.deleteEmployee(employeeId);
	}

	/**
	* Deletes the employee from the database. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Employee deleteEmployee(
		vn.com.ecopharma.emp.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.deleteEmployee(employee);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeLocalService.dynamicQuery();
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
		return _employeeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _employeeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _employeeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _employeeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _employeeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.Employee fetchEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.fetchEmployee(employeeId);
	}

	/**
	* Returns the employee with the primary key.
	*
	* @param employeeId the primary key of the employee
	* @return the employee
	* @throws PortalException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Employee getEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployee(employeeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @return the range of employees
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Employee> getEmployees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployees(start, end);
	}

	/**
	* Returns the number of employees.
	*
	* @return the number of employees
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmployeesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployeesCount();
	}

	/**
	* Updates the employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Employee updateEmployee(
		vn.com.ecopharma.emp.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.updateEmployee(employee);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _employeeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_employeeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _employeeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void indexAllEmployees() {
		_employeeLocalService.indexAllEmployees();
	}

	@Override
	public void indexSomeEmployees() {
		_employeeLocalService.indexSomeEmployees();
	}

	@Override
	public void removeAllEmployeeIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		_employeeLocalService.removeAllEmployeeIndexes(searchContext, companyId);
	}

	@Override
	public void completelyRemoveAllEmployee(long companyId) {
		_employeeLocalService.completelyRemoveAllEmployee(companyId);
	}

	@Override
	public int countAllIndexedEmployeeDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		return _employeeLocalService.countAllIndexedEmployeeDocuments(searchContext,
			companyId);
	}

	@Override
	public int countAllUnDeletedIndexedEmployeeDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return _employeeLocalService.countAllUnDeletedIndexedEmployeeDocuments(searchContext,
			filterQueries, companyId, sort);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedEmployeeIndexedDocument(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return _employeeLocalService.searchAllUnDeletedEmployeeIndexedDocument(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedEmployeeIndexedDocument1(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return _employeeLocalService.searchAllUnDeletedEmployeeIndexedDocument1(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedEmployeeIndexedDocumentWithConditionEmployeeList(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, java.util.List<java.lang.Long> employeeIds,
		boolean isExcluded, com.liferay.portal.kernel.search.Sort sort,
		int start, int end) {
		return _employeeLocalService.searchAllUnDeletedEmployeeIndexedDocumentWithConditionEmployeeList(searchContext,
			filterQueries, companyId, employeeIds, isExcluded, sort, start, end);
	}

	@Override
	public int countAllUnDeletedIndexedEmployeeDocumentWithConditionEmployeeList(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, java.util.List<java.lang.Long> employeeIds,
		boolean isExcluded, com.liferay.portal.kernel.search.Sort sort) {
		return _employeeLocalService.countAllUnDeletedIndexedEmployeeDocumentWithConditionEmployeeList(searchContext,
			filterQueries, companyId, employeeIds, isExcluded, sort);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedEmployeeIndexedDocumentByName(
		java.lang.String name,
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		return _employeeLocalService.searchAllUnDeletedEmployeeIndexedDocumentByName(name,
			searchContext, companyId);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllEmployeeIndexedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		return _employeeLocalService.searchAllEmployeeIndexedDocuments(searchContext,
			companyId);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllEmployeeIndexedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, int start, int end) {
		return _employeeLocalService.searchAllEmployeeIndexedDocuments(searchContext,
			filterQueries, companyId, start, end);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllEmployeeIndexedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return _employeeLocalService.searchAllEmployeeIndexedDocuments(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Employee> findAll() {
		return _employeeLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Employee> findAll(
		int start, int end) {
		return _employeeLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Employee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _employeeLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Employee> filterEmployees(
		java.lang.String globStr, java.lang.String fullName,
		java.lang.String emp_code, java.lang.String gender,
		java.lang.String contact_number, java.lang.String joined_date_from,
		java.lang.String joined_date_to,
		java.util.List<java.lang.String> jobTitles, java.lang.Long subUnitId,
		java.lang.String promoted_date_from, java.lang.String promoted_date_to,
		int start, int end, boolean isDeleted, java.lang.String sortField,
		java.lang.String sortOrder) {
		return _employeeLocalService.filterEmployees(globStr, fullName,
			emp_code, gender, contact_number, joined_date_from, joined_date_to,
			jobTitles, subUnitId, promoted_date_from, promoted_date_to, start,
			end, isDeleted, sortField, sortOrder);
	}

	@Override
	public vn.com.ecopharma.emp.model.Employee addEmployee1(
		long employeeUserId, vn.com.ecopharma.emp.model.Employee e,
		boolean autoPassword, java.lang.String password1,
		java.lang.String password2, boolean autoScreenName,
		java.lang.String screenName, java.lang.String emailAddress,
		long facebookId, java.lang.String openId, java.util.Locale locale,
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, int prefixId, int suffixId, boolean male,
		int birthdayMonth, int birthdayDay, int birthdayYear, long[] groupIds,
		long[] organizationIds, long[] roleIds, long[] userGroupIds,
		boolean sendEmail, long emp_userId,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addresses,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.addEmployee1(employeeUserId, e,
			autoPassword, password1, password2, autoScreenName, screenName,
			emailAddress, facebookId, openId, locale, firstName, middleName,
			lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay,
			birthdayYear, groupIds, organizationIds, roleIds, userGroupIds,
			sendEmail, emp_userId, addresses, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Employee addEmployee(
		vn.com.ecopharma.emp.model.Employee e, boolean autoPassword,
		java.lang.String password1, java.lang.String password2,
		boolean autoScreenName, java.lang.String screenName,
		java.lang.String emailAddress, long facebookId,
		java.lang.String openId, java.util.Locale locale,
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, int prefixId, int suffixId, boolean male,
		int birthdayMonth, int birthdayDay, int birthdayYear, long[] groupIds,
		long[] organizationIds, long[] roleIds, long[] userGroupIds,
		boolean sendEmail, long emp_userId,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addresses,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.addEmployee(e, autoPassword, password1,
			password2, autoScreenName, screenName, emailAddress, facebookId,
			openId, locale, firstName, middleName, lastName, prefixId,
			suffixId, male, birthdayMonth, birthdayDay, birthdayYear, groupIds,
			organizationIds, roleIds, userGroupIds, sendEmail, emp_userId,
			addresses, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Employee update(
		vn.com.ecopharma.emp.model.Employee employee,
		com.liferay.portal.model.User user,
		vn.com.ecopharma.emp.model.Titles titles,
		vn.com.ecopharma.emp.model.Level level,
		vn.com.ecopharma.emp.model.University university,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _employeeLocalService.update(employee, user, titles, level,
			university, addressesMap, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Employee createEmployee(
		java.lang.String employeeCode, long titlesId, long levelId,
		java.util.Date promotedDate, long subUnitId, java.util.Date joinedDate,
		java.util.Date laborContractSignedDate,
		java.util.Date laborContractExpiredDate,
		java.lang.String laborContractType, java.util.Date dob,
		java.lang.String gender, java.lang.String placeOfBirth,
		java.lang.String education, java.lang.String educationSpecialize,
		long universityId, java.lang.String maritalStatus,
		java.lang.String identityCardNo, java.util.Date issuedDate,
		java.lang.String issuedPlace, java.lang.String contactNumber,
		java.lang.String companyEmailAddress, java.lang.String taxCode,
		int numberOfDependents, java.lang.String dependentNames,
		java.lang.String insurranceCode, java.lang.String bankNo,
		java.lang.String bankBranchName) {
		return _employeeLocalService.createEmployee(employeeCode, titlesId,
			levelId, promotedDate, subUnitId, joinedDate,
			laborContractSignedDate, laborContractExpiredDate,
			laborContractType, dob, gender, placeOfBirth, education,
			educationSpecialize, universityId, maritalStatus, identityCardNo,
			issuedDate, issuedPlace, contactNumber, companyEmailAddress,
			taxCode, numberOfDependents, dependentNames, insurranceCode,
			bankNo, bankBranchName);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedEmployee(
		java.lang.String employeeIdString,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _employeeLocalService.getIndexedEmployee(employeeIdString,
			searchContext);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedEmployee(
		long employeeId,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _employeeLocalService.getIndexedEmployee(employeeId,
			searchContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Employee markDeletedEmployee(
		vn.com.ecopharma.emp.model.Employee employee) {
		return _employeeLocalService.markDeletedEmployee(employee);
	}

	@Override
	public vn.com.ecopharma.emp.model.Employee markDeletedEmployee(
		long employeeId) {
		return _employeeLocalService.markDeletedEmployee(employeeId);
	}

	@Override
	public int countAll() {
		return _employeeLocalService.countAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Employee> findByName(
		java.lang.String name) {
		return _employeeLocalService.findByName(name);
	}

	@Override
	public java.util.List<java.lang.Object[]> findEmployeeObjectsByName(
		java.lang.String name) {
		return _employeeLocalService.findEmployeeObjectsByName(name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmployeeLocalService getWrappedEmployeeLocalService() {
		return _employeeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmployeeLocalService(
		EmployeeLocalService employeeLocalService) {
		_employeeLocalService = employeeLocalService;
	}

	@Override
	public EmployeeLocalService getWrappedService() {
		return _employeeLocalService;
	}

	@Override
	public void setWrappedService(EmployeeLocalService employeeLocalService) {
		_employeeLocalService = employeeLocalService;
	}

	private EmployeeLocalService _employeeLocalService;
}