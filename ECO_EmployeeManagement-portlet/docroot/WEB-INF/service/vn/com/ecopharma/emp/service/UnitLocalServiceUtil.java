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
 * Provides the local service utility for Unit. This utility wraps
 * {@link vn.com.ecopharma.emp.service.impl.UnitLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see UnitLocalService
 * @see vn.com.ecopharma.emp.service.base.UnitLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.impl.UnitLocalServiceImpl
 * @generated
 */
public class UnitLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.emp.service.impl.UnitLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the unit to the database. Also notifies the appropriate model listeners.
	*
	* @param unit the unit
	* @return the unit that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Unit addUnit(
		vn.com.ecopharma.emp.model.Unit unit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUnit(unit);
	}

	/**
	* Creates a new unit with the primary key. Does not add the unit to the database.
	*
	* @param unitId the primary key for the new unit
	* @return the new unit
	*/
	public static vn.com.ecopharma.emp.model.Unit createUnit(long unitId) {
		return getService().createUnit(unitId);
	}

	/**
	* Deletes the unit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param unitId the primary key of the unit
	* @return the unit that was removed
	* @throws PortalException if a unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Unit deleteUnit(long unitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUnit(unitId);
	}

	/**
	* Deletes the unit from the database. Also notifies the appropriate model listeners.
	*
	* @param unit the unit
	* @return the unit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Unit deleteUnit(
		vn.com.ecopharma.emp.model.Unit unit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUnit(unit);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.emp.model.Unit fetchUnit(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUnit(unitId);
	}

	/**
	* Returns the unit with the primary key.
	*
	* @param unitId the primary key of the unit
	* @return the unit
	* @throws PortalException if a unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Unit getUnit(long unitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUnit(unitId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of units
	* @param end the upper bound of the range of units (not inclusive)
	* @return the range of units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Unit> getUnits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUnits(start, end);
	}

	/**
	* Returns the number of units.
	*
	* @return the number of units
	* @throws SystemException if a system exception occurred
	*/
	public static int getUnitsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUnitsCount();
	}

	/**
	* Updates the unit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param unit the unit
	* @return the unit that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Unit updateUnit(
		vn.com.ecopharma.emp.model.Unit unit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUnit(unit);
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

	public static java.util.List<vn.com.ecopharma.emp.model.Unit> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Unit> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Unit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static vn.com.ecopharma.emp.model.Unit findByNameAndDepartment(
		java.lang.String name, long departmentId) {
		return getService().findByNameAndDepartment(name, departmentId);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Unit> findByDepartment(
		long departmentId) {
		return getService().findByDepartment(departmentId);
	}

	public static vn.com.ecopharma.emp.model.Unit addUnit(
		java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().addUnit(name, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.Unit addUnit(
		java.lang.String name, long departmentId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().addUnit(name, departmentId, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.Unit addUnit(
		vn.com.ecopharma.emp.model.Unit unit,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().addUnit(unit, serviceContext);
	}

	public static void completelyRemoveAll() {
		getService().completelyRemoveAll();
	}

	public static void clearService() {
		_service = null;
	}

	public static UnitLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UnitLocalService.class.getName());

			if (invokableLocalService instanceof UnitLocalService) {
				_service = (UnitLocalService)invokableLocalService;
			}
			else {
				_service = new UnitLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UnitLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(UnitLocalService service) {
	}

	private static UnitLocalService _service;
}