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
 * Provides the local service utility for WorkingLocation. This utility wraps
 * {@link vn.com.ecopharma.emp.service.impl.WorkingLocationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see WorkingLocationLocalService
 * @see vn.com.ecopharma.emp.service.base.WorkingLocationLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.impl.WorkingLocationLocalServiceImpl
 * @generated
 */
public class WorkingLocationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.emp.service.impl.WorkingLocationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the working location to the database. Also notifies the appropriate model listeners.
	*
	* @param workingLocation the working location
	* @return the working location that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.WorkingLocation addWorkingLocation(
		vn.com.ecopharma.emp.model.WorkingLocation workingLocation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addWorkingLocation(workingLocation);
	}

	/**
	* Creates a new working location with the primary key. Does not add the working location to the database.
	*
	* @param workingLocationId the primary key for the new working location
	* @return the new working location
	*/
	public static vn.com.ecopharma.emp.model.WorkingLocation createWorkingLocation(
		long workingLocationId) {
		return getService().createWorkingLocation(workingLocationId);
	}

	/**
	* Deletes the working location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workingLocationId the primary key of the working location
	* @return the working location that was removed
	* @throws PortalException if a working location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.WorkingLocation deleteWorkingLocation(
		long workingLocationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWorkingLocation(workingLocationId);
	}

	/**
	* Deletes the working location from the database. Also notifies the appropriate model listeners.
	*
	* @param workingLocation the working location
	* @return the working location that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.WorkingLocation deleteWorkingLocation(
		vn.com.ecopharma.emp.model.WorkingLocation workingLocation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWorkingLocation(workingLocation);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.WorkingLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.WorkingLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.emp.model.WorkingLocation fetchWorkingLocation(
		long workingLocationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchWorkingLocation(workingLocationId);
	}

	/**
	* Returns the working location with the primary key.
	*
	* @param workingLocationId the primary key of the working location
	* @return the working location
	* @throws PortalException if a working location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.WorkingLocation getWorkingLocation(
		long workingLocationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkingLocation(workingLocationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the working locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.WorkingLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of working locations
	* @param end the upper bound of the range of working locations (not inclusive)
	* @return the range of working locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.WorkingLocation> getWorkingLocations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkingLocations(start, end);
	}

	/**
	* Returns the number of working locations.
	*
	* @return the number of working locations
	* @throws SystemException if a system exception occurred
	*/
	public static int getWorkingLocationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkingLocationsCount();
	}

	/**
	* Updates the working location in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param workingLocation the working location
	* @return the working location that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.WorkingLocation updateWorkingLocation(
		vn.com.ecopharma.emp.model.WorkingLocation workingLocation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWorkingLocation(workingLocation);
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

	public static java.util.List<vn.com.ecopharma.emp.model.WorkingLocation> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.emp.model.WorkingLocation> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.WorkingLocation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static void clearService() {
		_service = null;
	}

	public static WorkingLocationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WorkingLocationLocalService.class.getName());

			if (invokableLocalService instanceof WorkingLocationLocalService) {
				_service = (WorkingLocationLocalService)invokableLocalService;
			}
			else {
				_service = new WorkingLocationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(WorkingLocationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(WorkingLocationLocalService service) {
	}

	private static WorkingLocationLocalService _service;
}