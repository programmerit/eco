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
 * Provides the local service utility for VacationLeave. This utility wraps
 * {@link vn.com.ecopharma.emp.service.impl.VacationLeaveLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see VacationLeaveLocalService
 * @see vn.com.ecopharma.emp.service.base.VacationLeaveLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.impl.VacationLeaveLocalServiceImpl
 * @generated
 */
public class VacationLeaveLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.emp.service.impl.VacationLeaveLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the vacation leave to the database. Also notifies the appropriate model listeners.
	*
	* @param vacationLeave the vacation leave
	* @return the vacation leave that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.VacationLeave addVacationLeave(
		vn.com.ecopharma.emp.model.VacationLeave vacationLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVacationLeave(vacationLeave);
	}

	/**
	* Creates a new vacation leave with the primary key. Does not add the vacation leave to the database.
	*
	* @param vacationLeaveId the primary key for the new vacation leave
	* @return the new vacation leave
	*/
	public static vn.com.ecopharma.emp.model.VacationLeave createVacationLeave(
		long vacationLeaveId) {
		return getService().createVacationLeave(vacationLeaveId);
	}

	/**
	* Deletes the vacation leave with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vacationLeaveId the primary key of the vacation leave
	* @return the vacation leave that was removed
	* @throws PortalException if a vacation leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.VacationLeave deleteVacationLeave(
		long vacationLeaveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVacationLeave(vacationLeaveId);
	}

	/**
	* Deletes the vacation leave from the database. Also notifies the appropriate model listeners.
	*
	* @param vacationLeave the vacation leave
	* @return the vacation leave that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.VacationLeave deleteVacationLeave(
		vn.com.ecopharma.emp.model.VacationLeave vacationLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVacationLeave(vacationLeave);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.emp.model.VacationLeave fetchVacationLeave(
		long vacationLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVacationLeave(vacationLeaveId);
	}

	/**
	* Returns the vacation leave with the primary key.
	*
	* @param vacationLeaveId the primary key of the vacation leave
	* @return the vacation leave
	* @throws PortalException if a vacation leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.VacationLeave getVacationLeave(
		long vacationLeaveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVacationLeave(vacationLeaveId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vacation leaves.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vacation leaves
	* @param end the upper bound of the range of vacation leaves (not inclusive)
	* @return the range of vacation leaves
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.VacationLeave> getVacationLeaves(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVacationLeaves(start, end);
	}

	/**
	* Returns the number of vacation leaves.
	*
	* @return the number of vacation leaves
	* @throws SystemException if a system exception occurred
	*/
	public static int getVacationLeavesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVacationLeavesCount();
	}

	/**
	* Updates the vacation leave in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vacationLeave the vacation leave
	* @return the vacation leave that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.VacationLeave updateVacationLeave(
		vn.com.ecopharma.emp.model.VacationLeave vacationLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVacationLeave(vacationLeave);
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

	public static java.util.List<vn.com.ecopharma.emp.model.VacationLeave> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.emp.model.VacationLeave> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.VacationLeave> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static vn.com.ecopharma.emp.model.VacationLeave createPrePersistedEntity(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().createPrePersistedEntity(serviceContext);
	}

	public static vn.com.ecopharma.emp.model.VacationLeave addVacationLeave(
		vn.com.ecopharma.emp.model.VacationLeave prePersistedEntity,
		long empId, java.lang.String leaveType, java.util.Date leaveFrom,
		java.util.Date leaveTo, java.util.Date actualTo, int numberOfHours,
		java.lang.String reason, java.lang.String description) {
		return getService()
				   .addVacationLeave(prePersistedEntity, empId, leaveType,
			leaveFrom, leaveTo, actualTo, numberOfHours, reason, description);
	}

	public static vn.com.ecopharma.emp.model.VacationLeave addVacationLeave(
		long empId, java.lang.String leaveType, java.util.Date leaveFrom,
		java.util.Date leaveTo, java.util.Date actualTo, int numberOfHours,
		java.lang.String reason, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addVacationLeave(empId, leaveType, leaveFrom, leaveTo,
			actualTo, numberOfHours, reason, description, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.VacationLeave addVacationLeave(
		long empId, vn.com.ecopharma.emp.model.VacationLeave leave) {
		return getService().addVacationLeave(empId, leave);
	}

	public static vn.com.ecopharma.emp.model.VacationLeave updateVacationLeave(
		long id, java.lang.String leaveType, java.lang.String sign,
		java.util.Date leaveFrom, java.util.Date leaveTo,
		java.util.Date actualLeaveTo, java.lang.String reason,
		java.lang.String description, java.lang.String status) {
		return getService()
				   .updateVacationLeave(id, leaveType, sign, leaveFrom,
			leaveTo, actualLeaveTo, reason, description, status);
	}

	public static vn.com.ecopharma.emp.model.VacationLeave setManagerApproval(
		long leaveId, com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().setManagerApproval(leaveId, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.VacationLeave setManagerApproval(
		vn.com.ecopharma.emp.model.VacationLeave vacationLeave,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().setManagerApproval(vacationLeave, serviceContext);
	}

	public static int countAllUnDeletedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return getService()
				   .countAllUnDeletedDocuments(searchContext, filterQueries,
			companyId, sort);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return getService()
				   .searchAllUnDeletedDocuments(searchContext, filterQueries,
			companyId, sort, start, end);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> filterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId, int start,
		int end) throws com.liferay.portal.kernel.search.ParseException {
		return getService()
				   .filterByFields(searchContext, filters, sort, companyId,
			start, end);
	}

	public static int countFilterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId)
		throws com.liferay.portal.kernel.search.ParseException {
		return getService()
				   .countFilterByFields(searchContext, filters, sort, companyId);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchPendingRequestsOfManager(
		long managerId,
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		return getService()
				   .searchPendingRequestsOfManager(managerId, searchContext,
			companyId);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchByStatuses(
		java.util.List<java.lang.String> statuses,
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		return getService().searchByStatuses(statuses, searchContext, companyId);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchManagerApprovalList(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		return getService().searchManagerApprovalList(searchContext, companyId);
	}

	public static void reindexAll() {
		getService().reindexAll();
	}

	public static void removeAllIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		getService().removeAllIndexes(searchContext, companyId);
	}

	public static com.liferay.portal.kernel.search.Document getIndexedDocument(
		java.lang.String id,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getIndexedDocument(id, searchContext);
	}

	public static com.liferay.portal.kernel.search.Document getIndexedDocument(
		long id, com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getIndexedDocument(id, searchContext);
	}

	public static void indexAll() {
		getService().indexAll();
	}

	public static void clearService() {
		_service = null;
	}

	public static VacationLeaveLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VacationLeaveLocalService.class.getName());

			if (invokableLocalService instanceof VacationLeaveLocalService) {
				_service = (VacationLeaveLocalService)invokableLocalService;
			}
			else {
				_service = new VacationLeaveLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VacationLeaveLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VacationLeaveLocalService service) {
	}

	private static VacationLeaveLocalService _service;
}