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

package vn.com.ecopharma.hrm.rc.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for EmployeeInterviewSchedule. This utility wraps
 * {@link vn.com.ecopharma.hrm.rc.service.impl.EmployeeInterviewScheduleLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see EmployeeInterviewScheduleLocalService
 * @see vn.com.ecopharma.hrm.rc.service.base.EmployeeInterviewScheduleLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.impl.EmployeeInterviewScheduleLocalServiceImpl
 * @generated
 */
public class EmployeeInterviewScheduleLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.hrm.rc.service.impl.EmployeeInterviewScheduleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the employee interview schedule to the database. Also notifies the appropriate model listeners.
	*
	* @param employeeInterviewSchedule the employee interview schedule
	* @return the employee interview schedule that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule addEmployeeInterviewSchedule(
		vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule employeeInterviewSchedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEmployeeInterviewSchedule(employeeInterviewSchedule);
	}

	/**
	* Creates a new employee interview schedule with the primary key. Does not add the employee interview schedule to the database.
	*
	* @param employeeInterviewScheduleId the primary key for the new employee interview schedule
	* @return the new employee interview schedule
	*/
	public static vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule createEmployeeInterviewSchedule(
		long employeeInterviewScheduleId) {
		return getService()
				   .createEmployeeInterviewSchedule(employeeInterviewScheduleId);
	}

	/**
	* Deletes the employee interview schedule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employeeInterviewScheduleId the primary key of the employee interview schedule
	* @return the employee interview schedule that was removed
	* @throws PortalException if a employee interview schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule deleteEmployeeInterviewSchedule(
		long employeeInterviewScheduleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteEmployeeInterviewSchedule(employeeInterviewScheduleId);
	}

	/**
	* Deletes the employee interview schedule from the database. Also notifies the appropriate model listeners.
	*
	* @param employeeInterviewSchedule the employee interview schedule
	* @return the employee interview schedule that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule deleteEmployeeInterviewSchedule(
		vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule employeeInterviewSchedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteEmployeeInterviewSchedule(employeeInterviewSchedule);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EmployeeInterviewScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EmployeeInterviewScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule fetchEmployeeInterviewSchedule(
		long employeeInterviewScheduleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchEmployeeInterviewSchedule(employeeInterviewScheduleId);
	}

	/**
	* Returns the employee interview schedule with the primary key.
	*
	* @param employeeInterviewScheduleId the primary key of the employee interview schedule
	* @return the employee interview schedule
	* @throws PortalException if a employee interview schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule getEmployeeInterviewSchedule(
		long employeeInterviewScheduleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEmployeeInterviewSchedule(employeeInterviewScheduleId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the employee interview schedules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EmployeeInterviewScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee interview schedules
	* @param end the upper bound of the range of employee interview schedules (not inclusive)
	* @return the range of employee interview schedules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule> getEmployeeInterviewSchedules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployeeInterviewSchedules(start, end);
	}

	/**
	* Returns the number of employee interview schedules.
	*
	* @return the number of employee interview schedules
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmployeeInterviewSchedulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployeeInterviewSchedulesCount();
	}

	/**
	* Updates the employee interview schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employeeInterviewSchedule the employee interview schedule
	* @return the employee interview schedule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule updateEmployeeInterviewSchedule(
		vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule employeeInterviewSchedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateEmployeeInterviewSchedule(employeeInterviewSchedule);
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

	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule addEmployeeInterviewSchedule(
		vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule employeeInterviewSchedule,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addEmployeeInterviewSchedule(employeeInterviewSchedule,
			serviceContext);
	}

	public static vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule createPrePersitedEntity() {
		return getService().createPrePersitedEntity();
	}

	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule> findByInterviewSchedule(
		long interviewScheduleId) {
		return getService().findByInterviewSchedule(interviewScheduleId);
	}

	public static void clearService() {
		_service = null;
	}

	public static EmployeeInterviewScheduleLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EmployeeInterviewScheduleLocalService.class.getName());

			if (invokableLocalService instanceof EmployeeInterviewScheduleLocalService) {
				_service = (EmployeeInterviewScheduleLocalService)invokableLocalService;
			}
			else {
				_service = new EmployeeInterviewScheduleLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EmployeeInterviewScheduleLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EmployeeInterviewScheduleLocalService service) {
	}

	private static EmployeeInterviewScheduleLocalService _service;
}