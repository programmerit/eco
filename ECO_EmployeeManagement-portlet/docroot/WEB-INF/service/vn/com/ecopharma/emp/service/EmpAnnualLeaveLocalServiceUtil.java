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
 * Provides the local service utility for EmpAnnualLeave. This utility wraps
 * {@link vn.com.ecopharma.emp.service.impl.EmpAnnualLeaveLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see EmpAnnualLeaveLocalService
 * @see vn.com.ecopharma.emp.service.base.EmpAnnualLeaveLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.impl.EmpAnnualLeaveLocalServiceImpl
 * @generated
 */
public class EmpAnnualLeaveLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.emp.service.impl.EmpAnnualLeaveLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the emp annual leave to the database. Also notifies the appropriate model listeners.
	*
	* @param empAnnualLeave the emp annual leave
	* @return the emp annual leave that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpAnnualLeave addEmpAnnualLeave(
		vn.com.ecopharma.emp.model.EmpAnnualLeave empAnnualLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEmpAnnualLeave(empAnnualLeave);
	}

	/**
	* Creates a new emp annual leave with the primary key. Does not add the emp annual leave to the database.
	*
	* @param empAnnualLeaveId the primary key for the new emp annual leave
	* @return the new emp annual leave
	*/
	public static vn.com.ecopharma.emp.model.EmpAnnualLeave createEmpAnnualLeave(
		long empAnnualLeaveId) {
		return getService().createEmpAnnualLeave(empAnnualLeaveId);
	}

	/**
	* Deletes the emp annual leave with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empAnnualLeaveId the primary key of the emp annual leave
	* @return the emp annual leave that was removed
	* @throws PortalException if a emp annual leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpAnnualLeave deleteEmpAnnualLeave(
		long empAnnualLeaveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmpAnnualLeave(empAnnualLeaveId);
	}

	/**
	* Deletes the emp annual leave from the database. Also notifies the appropriate model listeners.
	*
	* @param empAnnualLeave the emp annual leave
	* @return the emp annual leave that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpAnnualLeave deleteEmpAnnualLeave(
		vn.com.ecopharma.emp.model.EmpAnnualLeave empAnnualLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmpAnnualLeave(empAnnualLeave);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpAnnualLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpAnnualLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.emp.model.EmpAnnualLeave fetchEmpAnnualLeave(
		long empAnnualLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEmpAnnualLeave(empAnnualLeaveId);
	}

	/**
	* Returns the emp annual leave with the primary key.
	*
	* @param empAnnualLeaveId the primary key of the emp annual leave
	* @return the emp annual leave
	* @throws PortalException if a emp annual leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpAnnualLeave getEmpAnnualLeave(
		long empAnnualLeaveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpAnnualLeave(empAnnualLeaveId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the emp annual leaves.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpAnnualLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp annual leaves
	* @param end the upper bound of the range of emp annual leaves (not inclusive)
	* @return the range of emp annual leaves
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpAnnualLeave> getEmpAnnualLeaves(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpAnnualLeaves(start, end);
	}

	/**
	* Returns the number of emp annual leaves.
	*
	* @return the number of emp annual leaves
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmpAnnualLeavesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpAnnualLeavesCount();
	}

	/**
	* Updates the emp annual leave in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empAnnualLeave the emp annual leave
	* @return the emp annual leave that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpAnnualLeave updateEmpAnnualLeave(
		vn.com.ecopharma.emp.model.EmpAnnualLeave empAnnualLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEmpAnnualLeave(empAnnualLeave);
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

	public static java.util.List<vn.com.ecopharma.emp.model.EmpAnnualLeave> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EmpAnnualLeave> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EmpAnnualLeave> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static vn.com.ecopharma.emp.model.EmpAnnualLeave createPrePersistedEntity(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().createPrePersistedEntity(serviceContext);
	}

	public static vn.com.ecopharma.emp.model.EmpAnnualLeave addEmpAnnualLeave(
		vn.com.ecopharma.emp.model.EmpAnnualLeave prePersistedEntity,
		long empId, double totalLeave, double totalLeaveLeft,
		double totalOldLeavesLeft) {
		return getService()
				   .addEmpAnnualLeave(prePersistedEntity, empId, totalLeave,
			totalLeaveLeft, totalOldLeavesLeft);
	}

	public static vn.com.ecopharma.emp.model.EmpAnnualLeave addEmpAnnualLeave(
		long empId, double totalLeave, double totalLeaveLeft,
		double totalOldLeavesLeft,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addEmpAnnualLeave(empId, totalLeave, totalLeaveLeft,
			totalOldLeavesLeft, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.EmpAnnualLeave updateEmpAnnualLeave(
		vn.com.ecopharma.emp.model.EmpAnnualLeave empAnnualLeave,
		double totalLeave, double totalLeaveLeft, double totalOldLeavesLeft) {
		return getService()
				   .updateEmpAnnualLeave(empAnnualLeave, totalLeave,
			totalLeaveLeft, totalOldLeavesLeft);
	}

	public static void executeFirstAprilQuartzTask() {
		getService().executeFirstAprilQuartzTask();
	}

	public static vn.com.ecopharma.emp.model.EmpAnnualLeave fetchByEmp(
		long empId) {
		return getService().fetchByEmp(empId);
	}

	public static java.util.List<java.util.Date> getDatesBetweenTwoDates(
		java.util.Date date1, java.util.Date date2, boolean includedHolidays,
		boolean includedLowerTerm) {
		return getService()
				   .getDatesBetweenTwoDates(date1, date2, includedHolidays,
			includedLowerTerm);
	}

	public static int countAllDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return getService()
				   .countAllDocuments(searchContext, filterQueries, companyId,
			sort);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return getService()
				   .searchAllDocuments(searchContext, filterQueries, companyId,
			sort, start, end);
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

	public static void removeAllIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		getService().removeAllIndexes(searchContext, companyId);
	}

	public static vn.com.ecopharma.emp.model.EmpAnnualLeave applyLeaveForEmp(
		long empId, double numberOfLeaves,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .applyLeaveForEmp(empId, numberOfLeaves, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.EmpAnnualLeave applyLeaveForEmp1(
		long empId, double numberOfLeaves,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .applyLeaveForEmp1(empId, numberOfLeaves, serviceContext);
	}

	public static void scanAndAutoAddVacationLeave(
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().scanAndAutoAddVacationLeave(serviceContext);
	}

	public static int calculateTotalAnnualLeaveByJoinedDate(
		java.util.Date joinedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().calculateTotalAnnualLeaveByJoinedDate(joinedDate);
	}

	public static int getMonthsBetweenTwoDate(java.util.Date startDate,
		java.util.Date endDate) {
		return getService().getMonthsBetweenTwoDate(startDate, endDate);
	}

	public static void addOneDayForEachEmp() {
		getService().addOneDayForEachEmp();
	}

	public static void clearService() {
		_service = null;
	}

	public static EmpAnnualLeaveLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EmpAnnualLeaveLocalService.class.getName());

			if (invokableLocalService instanceof EmpAnnualLeaveLocalService) {
				_service = (EmpAnnualLeaveLocalService)invokableLocalService;
			}
			else {
				_service = new EmpAnnualLeaveLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EmpAnnualLeaveLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EmpAnnualLeaveLocalService service) {
	}

	private static EmpAnnualLeaveLocalService _service;
}