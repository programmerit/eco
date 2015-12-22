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
 * Provides the local service utility for Staff. This utility wraps
 * {@link vn.com.ecopharma.emp.service.impl.StaffLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see StaffLocalService
 * @see vn.com.ecopharma.emp.service.base.StaffLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.impl.StaffLocalServiceImpl
 * @generated
 */
public class StaffLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.emp.service.impl.StaffLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the staff to the database. Also notifies the appropriate model listeners.
	*
	* @param staff the staff
	* @return the staff that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Staff addStaff(
		vn.com.ecopharma.emp.model.Staff staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addStaff(staff);
	}

	/**
	* Creates a new staff with the primary key. Does not add the staff to the database.
	*
	* @param staffId the primary key for the new staff
	* @return the new staff
	*/
	public static vn.com.ecopharma.emp.model.Staff createStaff(long staffId) {
		return getService().createStaff(staffId);
	}

	/**
	* Deletes the staff with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param staffId the primary key of the staff
	* @return the staff that was removed
	* @throws PortalException if a staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Staff deleteStaff(long staffId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStaff(staffId);
	}

	/**
	* Deletes the staff from the database. Also notifies the appropriate model listeners.
	*
	* @param staff the staff
	* @return the staff that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Staff deleteStaff(
		vn.com.ecopharma.emp.model.Staff staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStaff(staff);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.emp.model.Staff fetchStaff(long staffId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchStaff(staffId);
	}

	/**
	* Returns the staff with the primary key.
	*
	* @param staffId the primary key of the staff
	* @return the staff
	* @throws PortalException if a staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Staff getStaff(long staffId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStaff(staffId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the staffs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of staffs
	* @param end the upper bound of the range of staffs (not inclusive)
	* @return the range of staffs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Staff> getStaffs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStaffs(start, end);
	}

	/**
	* Returns the number of staffs.
	*
	* @return the number of staffs
	* @throws SystemException if a system exception occurred
	*/
	public static int getStaffsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStaffsCount();
	}

	/**
	* Updates the staff in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param staff the staff
	* @return the staff that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Staff updateStaff(
		vn.com.ecopharma.emp.model.Staff staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStaff(staff);
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

	public static void indexAllStaffs() {
		getService().indexAllStaffs();
	}

	public static void indexSomeStaffs() {
		getService().indexSomeStaffs();
	}

	public static void removeAllStaffIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		getService().removeAllStaffIndexes(searchContext, companyId);
	}

	public static void completelyRemoveAllStaff(long companyId) {
		getService().completelyRemoveAllStaff(companyId);
	}

	public static int countAllIndexedStaffDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		return getService()
				   .countAllIndexedStaffDocuments(searchContext, companyId);
	}

	public static int countAllUnDeletedIndexedStaffDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return getService()
				   .countAllUnDeletedIndexedStaffDocuments(searchContext,
			filterQueries, companyId, sort);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedStaffIndexedDocument(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return getService()
				   .searchAllUnDeletedStaffIndexedDocument(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedStaffIndexedDocument1(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return getService()
				   .searchAllUnDeletedStaffIndexedDocument1(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedStaffIndexedDocumentWithConditionStaffList(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, java.util.List<java.lang.Long> StaffIds,
		boolean isExcluded, com.liferay.portal.kernel.search.Sort sort,
		int start, int end) {
		return getService()
				   .searchAllUnDeletedStaffIndexedDocumentWithConditionStaffList(searchContext,
			filterQueries, companyId, StaffIds, isExcluded, sort, start, end);
	}

	public static int countAllUnDeletedIndexedStaffDocumentWithConditionStaffList(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, java.util.List<java.lang.Long> StaffIds,
		boolean isExcluded, com.liferay.portal.kernel.search.Sort sort) {
		return getService()
				   .countAllUnDeletedIndexedStaffDocumentWithConditionStaffList(searchContext,
			filterQueries, companyId, StaffIds, isExcluded, sort);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedStaffIndexedDocumentByName(
		java.lang.String name,
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		return getService()
				   .searchAllUnDeletedStaffIndexedDocumentByName(name,
			searchContext, companyId);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllStaffIndexedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		return getService()
				   .searchAllStaffIndexedDocuments(searchContext, companyId);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllStaffIndexedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, int start, int end) {
		return getService()
				   .searchAllStaffIndexedDocuments(searchContext,
			filterQueries, companyId, start, end);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllStaffIndexedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return getService()
				   .searchAllStaffIndexedDocuments(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Staff> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Staff> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Staff> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Staff> filterStaffs(
		java.lang.String globStr, java.lang.String fullName,
		java.lang.String emp_code, java.lang.String gender,
		java.lang.String contact_number, java.lang.String joined_date_from,
		java.lang.String joined_date_to,
		java.util.List<java.lang.String> jobTitles, java.lang.Long subUnitId,
		java.lang.String promoted_date_from, java.lang.String promoted_date_to,
		int start, int end, boolean isDeleted, java.lang.String sortField,
		java.lang.String sortOrder) {
		return getService()
				   .filterStaffs(globStr, fullName, emp_code, gender,
			contact_number, joined_date_from, joined_date_to, jobTitles,
			subUnitId, promoted_date_from, promoted_date_to, start, end,
			isDeleted, sortField, sortOrder);
	}

	public static vn.com.ecopharma.emp.model.Staff addStaff1(
		vn.com.ecopharma.emp.model.Staff staff,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addStaff1(staff, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.Staff addStaff(
		vn.com.ecopharma.emp.model.Staff e, boolean autoPassword,
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
				   .addStaff(e, autoPassword, password1, password2,
			autoScreenName, screenName, emailAddress, facebookId, openId,
			locale, firstName, middleName, lastName, prefixId, suffixId, male,
			birthdayMonth, birthdayDay, birthdayYear, groupIds,
			organizationIds, roleIds, userGroupIds, sendEmail, emp_userId,
			addresses, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.Staff update(
		vn.com.ecopharma.emp.model.Staff Staff,
		com.liferay.portal.model.User user,
		vn.com.ecopharma.emp.model.Titles titles,
		vn.com.ecopharma.emp.model.Level level,
		vn.com.ecopharma.emp.model.University university,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .update(Staff, user, titles, level, university,
			addressesMap, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.Staff createStaff(
		java.lang.String StaffCode, long titlesId, long levelId,
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
		return getService()
				   .createStaff(StaffCode, titlesId, levelId, promotedDate,
			subUnitId, joinedDate, laborContractSignedDate,
			laborContractExpiredDate, laborContractType, dob, gender,
			placeOfBirth, education, educationSpecialize, universityId,
			maritalStatus, identityCardNo, issuedDate, issuedPlace,
			contactNumber, companyEmailAddress, taxCode, numberOfDependents,
			dependentNames, insurranceCode, bankNo, bankBranchName);
	}

	public static com.liferay.portal.kernel.search.Document getIndexedStaff(
		java.lang.String StaffIdString,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getIndexedStaff(StaffIdString, searchContext);
	}

	public static com.liferay.portal.kernel.search.Document getIndexedStaff(
		long StaffId,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getIndexedStaff(StaffId, searchContext);
	}

	public static vn.com.ecopharma.emp.model.Staff markDeletedStaff(
		vn.com.ecopharma.emp.model.Staff Staff) {
		return getService().markDeletedStaff(Staff);
	}

	public static vn.com.ecopharma.emp.model.Staff markDeletedStaff(
		long StaffId) {
		return getService().markDeletedStaff(StaffId);
	}

	public static int countAll() {
		return getService().countAll();
	}

	public static void clearService() {
		_service = null;
	}

	public static StaffLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StaffLocalService.class.getName());

			if (invokableLocalService instanceof StaffLocalService) {
				_service = (StaffLocalService)invokableLocalService;
			}
			else {
				_service = new StaffLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(StaffLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(StaffLocalService service) {
	}

	private static StaffLocalService _service;
}