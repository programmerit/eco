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
 * Provides the local service utility for EcoEmployee. This utility wraps
 * {@link vn.com.ecopharma.emp.service.impl.EcoEmployeeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see EcoEmployeeLocalService
 * @see vn.com.ecopharma.emp.service.base.EcoEmployeeLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.impl.EcoEmployeeLocalServiceImpl
 * @generated
 */
public class EcoEmployeeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.emp.service.impl.EcoEmployeeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the eco employee to the database. Also notifies the appropriate model listeners.
	*
	* @param ecoEmployee the eco employee
	* @return the eco employee that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EcoEmployee addEcoEmployee(
		vn.com.ecopharma.emp.model.EcoEmployee ecoEmployee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEcoEmployee(ecoEmployee);
	}

	/**
	* Creates a new eco employee with the primary key. Does not add the eco employee to the database.
	*
	* @param ecoEmployeeId the primary key for the new eco employee
	* @return the new eco employee
	*/
	public static vn.com.ecopharma.emp.model.EcoEmployee createEcoEmployee(
		long ecoEmployeeId) {
		return getService().createEcoEmployee(ecoEmployeeId);
	}

	/**
	* Deletes the eco employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ecoEmployeeId the primary key of the eco employee
	* @return the eco employee that was removed
	* @throws PortalException if a eco employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EcoEmployee deleteEcoEmployee(
		long ecoEmployeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEcoEmployee(ecoEmployeeId);
	}

	/**
	* Deletes the eco employee from the database. Also notifies the appropriate model listeners.
	*
	* @param ecoEmployee the eco employee
	* @return the eco employee that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EcoEmployee deleteEcoEmployee(
		vn.com.ecopharma.emp.model.EcoEmployee ecoEmployee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEcoEmployee(ecoEmployee);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EcoEmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EcoEmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.emp.model.EcoEmployee fetchEcoEmployee(
		long ecoEmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEcoEmployee(ecoEmployeeId);
	}

	/**
	* Returns the eco employee with the primary key.
	*
	* @param ecoEmployeeId the primary key of the eco employee
	* @return the eco employee
	* @throws PortalException if a eco employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EcoEmployee getEcoEmployee(
		long ecoEmployeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEcoEmployee(ecoEmployeeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the eco employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EcoEmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eco employees
	* @param end the upper bound of the range of eco employees (not inclusive)
	* @return the range of eco employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EcoEmployee> getEcoEmployees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEcoEmployees(start, end);
	}

	/**
	* Returns the number of eco employees.
	*
	* @return the number of eco employees
	* @throws SystemException if a system exception occurred
	*/
	public static int getEcoEmployeesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEcoEmployeesCount();
	}

	/**
	* Updates the eco employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ecoEmployee the eco employee
	* @return the eco employee that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EcoEmployee updateEcoEmployee(
		vn.com.ecopharma.emp.model.EcoEmployee ecoEmployee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEcoEmployee(ecoEmployee);
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

	public static void indexAllEmployees() {
		getService().indexAllEmployees();
	}

	public static void removeAllEmployeeIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		getService().removeAllEmployeeIndexes(searchContext, companyId);
	}

	public static int countAllIndexedEmployeeDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		return getService()
				   .countAllIndexedEmployeeDocuments(searchContext, companyId);
	}

	public static int countAllUnDeletedIndexedEmployeeDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return getService()
				   .countAllUnDeletedIndexedEmployeeDocuments(searchContext,
			filterQueries, companyId, sort);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedEmployeeIndexedDocument(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return getService()
				   .searchAllUnDeletedEmployeeIndexedDocument(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedEmployeeIndexedDocumentWithConditionEmployeeList(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, java.util.List<java.lang.Long> employeeIds,
		boolean isExcluded, com.liferay.portal.kernel.search.Sort sort,
		int start, int end) {
		return getService()
				   .searchAllUnDeletedEmployeeIndexedDocumentWithConditionEmployeeList(searchContext,
			filterQueries, companyId, employeeIds, isExcluded, sort, start, end);
	}

	public static int countAllUnDeletedIndexedEmployeeDocumentWithConditionEmployeeList(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, java.util.List<java.lang.Long> employeeIds,
		boolean isExcluded, com.liferay.portal.kernel.search.Sort sort) {
		return getService()
				   .countAllUnDeletedIndexedEmployeeDocumentWithConditionEmployeeList(searchContext,
			filterQueries, companyId, employeeIds, isExcluded, sort);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedEmployeeIndexedDocumentByName(
		java.lang.String name,
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		return getService()
				   .searchAllUnDeletedEmployeeIndexedDocumentByName(name,
			searchContext, companyId);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllEmployeeIndexedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		return getService()
				   .searchAllEmployeeIndexedDocuments(searchContext, companyId);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllEmployeeIndexedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, int start, int end) {
		return getService()
				   .searchAllEmployeeIndexedDocuments(searchContext,
			filterQueries, companyId, start, end);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllEmployeeIndexedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return getService()
				   .searchAllEmployeeIndexedDocuments(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EcoEmployee> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EcoEmployee> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EcoEmployee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EcoEmployee> filterEmployees(
		java.lang.String globStr, java.lang.String fullName,
		java.lang.String emp_code, java.lang.String gender,
		java.lang.String contact_number, java.lang.String joined_date_from,
		java.lang.String joined_date_to,
		java.util.List<java.lang.String> jobTitles, java.lang.Long subUnitId,
		java.lang.String promoted_date_from, java.lang.String promoted_date_to,
		int start, int end, boolean isDeleted, java.lang.String sortField,
		java.lang.String sortOrder) {
		return getService()
				   .filterEmployees(globStr, fullName, emp_code, gender,
			contact_number, joined_date_from, joined_date_to, jobTitles,
			subUnitId, promoted_date_from, promoted_date_to, start, end,
			isDeleted, sortField, sortOrder);
	}

	public static vn.com.ecopharma.emp.model.EcoEmployee addEmployee(
		vn.com.ecopharma.emp.model.EcoEmployee e, boolean autoPassword,
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
		return getService()
				   .addEmployee(e, autoPassword, password1, password2,
			autoScreenName, screenName, emailAddress, facebookId, openId,
			locale, firstName, middleName, lastName, prefixId, suffixId, male,
			birthdayMonth, birthdayDay, birthdayYear, groupIds,
			organizationIds, roleIds, userGroupIds, sendEmail, emp_userId,
			addresses, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.EcoEmployee update(
		vn.com.ecopharma.emp.model.EcoEmployee EcoEmployee,
		com.liferay.portal.model.User user,
		vn.com.ecopharma.emp.model.SubUnit subUnit,
		vn.com.ecopharma.emp.model.Titles titles,
		vn.com.ecopharma.emp.model.Level level,
		vn.com.ecopharma.emp.model.University university,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .update(EcoEmployee, user, subUnit, titles, level,
			university, addressesMap, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.EcoEmployee createEcoEmployee(
		java.lang.String emp_code, long jTitlesId, long titlesId, long levelId,
		java.util.Date promoted_date, long subUnitId,
		java.util.Date joined_date, java.util.Date laborContractSignedDate,
		java.util.Date laborContractExpiredDate,
		java.lang.String laborContractType, java.util.Date dob,
		java.lang.String gender, java.lang.String placeOfBirth,
		java.lang.String education, java.lang.String education_specialize,
		long universityId, java.lang.String marrital_status,
		java.lang.String identityCard_no, java.util.Date issued_date,
		java.lang.String issued_place, java.lang.String contactNumber,
		java.lang.String companyEmailAddress, java.lang.String taxCode,
		java.lang.String insurranceCode, java.lang.String bankNo,
		java.lang.String bankBranchName) {
		return getService()
				   .createEcoEmployee(emp_code, jTitlesId, titlesId, levelId,
			promoted_date, subUnitId, joined_date, laborContractSignedDate,
			laborContractExpiredDate, laborContractType, dob, gender,
			placeOfBirth, education, education_specialize, universityId,
			marrital_status, identityCard_no, issued_date, issued_place,
			contactNumber, companyEmailAddress, taxCode, insurranceCode,
			bankNo, bankBranchName);
	}

	public static com.liferay.portal.kernel.search.Document getIndexedEmployee(
		java.lang.String employeeIdString,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getIndexedEmployee(employeeIdString, searchContext);
	}

	public static com.liferay.portal.kernel.search.Document getIndexedEmployee(
		long ecoEmployeeId,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getIndexedEmployee(ecoEmployeeId, searchContext);
	}

	public static vn.com.ecopharma.emp.model.EcoEmployee markDeletedEmployee(
		vn.com.ecopharma.emp.model.EcoEmployee EcoEmployee) {
		return getService().markDeletedEmployee(EcoEmployee);
	}

	public static vn.com.ecopharma.emp.model.EcoEmployee markDeletedEmployee(
		long ecoEmployeeId) {
		return getService().markDeletedEmployee(ecoEmployeeId);
	}

	public static int countAll() {
		return getService().countAll();
	}

	public static void clearService() {
		_service = null;
	}

	public static EcoEmployeeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EcoEmployeeLocalService.class.getName());

			if (invokableLocalService instanceof EcoEmployeeLocalService) {
				_service = (EcoEmployeeLocalService)invokableLocalService;
			}
			else {
				_service = new EcoEmployeeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EcoEmployeeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EcoEmployeeLocalService service) {
	}

	private static EcoEmployeeLocalService _service;
}