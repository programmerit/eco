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
 * Provides a wrapper for {@link UnitLocalService}.
 *
 * @author tvt
 * @see UnitLocalService
 * @generated
 */
public class UnitLocalServiceWrapper implements UnitLocalService,
	ServiceWrapper<UnitLocalService> {
	public UnitLocalServiceWrapper(UnitLocalService unitLocalService) {
		_unitLocalService = unitLocalService;
	}

	/**
	* Adds the unit to the database. Also notifies the appropriate model listeners.
	*
	* @param unit the unit
	* @return the unit that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Unit addUnit(
		vn.com.ecopharma.emp.model.Unit unit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitLocalService.addUnit(unit);
	}

	/**
	* Creates a new unit with the primary key. Does not add the unit to the database.
	*
	* @param unitId the primary key for the new unit
	* @return the new unit
	*/
	@Override
	public vn.com.ecopharma.emp.model.Unit createUnit(long unitId) {
		return _unitLocalService.createUnit(unitId);
	}

	/**
	* Deletes the unit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param unitId the primary key of the unit
	* @return the unit that was removed
	* @throws PortalException if a unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Unit deleteUnit(long unitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _unitLocalService.deleteUnit(unitId);
	}

	/**
	* Deletes the unit from the database. Also notifies the appropriate model listeners.
	*
	* @param unit the unit
	* @return the unit that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Unit deleteUnit(
		vn.com.ecopharma.emp.model.Unit unit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitLocalService.deleteUnit(unit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _unitLocalService.dynamicQuery();
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
		return _unitLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _unitLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _unitLocalService.dynamicQueryCount(dynamicQuery);
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
		return _unitLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.Unit fetchUnit(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitLocalService.fetchUnit(unitId);
	}

	/**
	* Returns the unit with the primary key.
	*
	* @param unitId the primary key of the unit
	* @return the unit
	* @throws PortalException if a unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Unit getUnit(long unitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _unitLocalService.getUnit(unitId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _unitLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Unit> getUnits(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _unitLocalService.getUnits(start, end);
	}

	/**
	* Returns the number of units.
	*
	* @return the number of units
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUnitsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitLocalService.getUnitsCount();
	}

	/**
	* Updates the unit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param unit the unit
	* @return the unit that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Unit updateUnit(
		vn.com.ecopharma.emp.model.Unit unit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitLocalService.updateUnit(unit);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _unitLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_unitLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _unitLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Unit> findAll() {
		return _unitLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Unit> findAll(int start,
		int end) {
		return _unitLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Unit> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _unitLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public vn.com.ecopharma.emp.model.Unit findByNameAndDepartment(
		java.lang.String name, long departmentId) {
		return _unitLocalService.findByNameAndDepartment(name, departmentId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Unit> findByDepartment(
		long departmentId) {
		return _unitLocalService.findByDepartment(departmentId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Unit> findByDepartments(
		java.util.List<vn.com.ecopharma.emp.model.Department> departments) {
		return _unitLocalService.findByDepartments(departments);
	}

	@Override
	public vn.com.ecopharma.emp.model.Unit createPrePersistedUnit(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _unitLocalService.createPrePersistedUnit(serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Unit addUnit(java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _unitLocalService.addUnit(name, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Unit addUnit(java.lang.String name,
		long departmentId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _unitLocalService.addUnit(name, departmentId, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Unit addUnit(
		vn.com.ecopharma.emp.model.Unit unit,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _unitLocalService.addUnit(unit, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Unit updateUnit(
		vn.com.ecopharma.emp.model.Unit unit,
		com.liferay.portal.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _unitLocalService.updateUnit(unit, serviceContext, searchContext);
	}

	@Override
	public void completelyRemoveAll() {
		_unitLocalService.completelyRemoveAll();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UnitLocalService getWrappedUnitLocalService() {
		return _unitLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUnitLocalService(UnitLocalService unitLocalService) {
		_unitLocalService = unitLocalService;
	}

	@Override
	public UnitLocalService getWrappedService() {
		return _unitLocalService;
	}

	@Override
	public void setWrappedService(UnitLocalService unitLocalService) {
		_unitLocalService = unitLocalService;
	}

	private UnitLocalService _unitLocalService;
}