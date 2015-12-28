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
 * Provides a wrapper for {@link UnitGroupLocalService}.
 *
 * @author tvt
 * @see UnitGroupLocalService
 * @generated
 */
public class UnitGroupLocalServiceWrapper implements UnitGroupLocalService,
	ServiceWrapper<UnitGroupLocalService> {
	public UnitGroupLocalServiceWrapper(
		UnitGroupLocalService unitGroupLocalService) {
		_unitGroupLocalService = unitGroupLocalService;
	}

	/**
	* Adds the unit group to the database. Also notifies the appropriate model listeners.
	*
	* @param unitGroup the unit group
	* @return the unit group that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.UnitGroup addUnitGroup(
		vn.com.ecopharma.emp.model.UnitGroup unitGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitGroupLocalService.addUnitGroup(unitGroup);
	}

	/**
	* Creates a new unit group with the primary key. Does not add the unit group to the database.
	*
	* @param unitGroupId the primary key for the new unit group
	* @return the new unit group
	*/
	@Override
	public vn.com.ecopharma.emp.model.UnitGroup createUnitGroup(
		long unitGroupId) {
		return _unitGroupLocalService.createUnitGroup(unitGroupId);
	}

	/**
	* Deletes the unit group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param unitGroupId the primary key of the unit group
	* @return the unit group that was removed
	* @throws PortalException if a unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.UnitGroup deleteUnitGroup(
		long unitGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _unitGroupLocalService.deleteUnitGroup(unitGroupId);
	}

	/**
	* Deletes the unit group from the database. Also notifies the appropriate model listeners.
	*
	* @param unitGroup the unit group
	* @return the unit group that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.UnitGroup deleteUnitGroup(
		vn.com.ecopharma.emp.model.UnitGroup unitGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitGroupLocalService.deleteUnitGroup(unitGroup);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _unitGroupLocalService.dynamicQuery();
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
		return _unitGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _unitGroupLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _unitGroupLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _unitGroupLocalService.dynamicQueryCount(dynamicQuery);
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
		return _unitGroupLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.UnitGroup fetchUnitGroup(long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitGroupLocalService.fetchUnitGroup(unitGroupId);
	}

	/**
	* Returns the unit group with the primary key.
	*
	* @param unitGroupId the primary key of the unit group
	* @return the unit group
	* @throws PortalException if a unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.UnitGroup getUnitGroup(long unitGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _unitGroupLocalService.getUnitGroup(unitGroupId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _unitGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the unit groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of unit groups
	* @param end the upper bound of the range of unit groups (not inclusive)
	* @return the range of unit groups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.UnitGroup> getUnitGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitGroupLocalService.getUnitGroups(start, end);
	}

	/**
	* Returns the number of unit groups.
	*
	* @return the number of unit groups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUnitGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitGroupLocalService.getUnitGroupsCount();
	}

	/**
	* Updates the unit group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param unitGroup the unit group
	* @return the unit group that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.UnitGroup updateUnitGroup(
		vn.com.ecopharma.emp.model.UnitGroup unitGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitGroupLocalService.updateUnitGroup(unitGroup);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _unitGroupLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_unitGroupLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _unitGroupLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.UnitGroup> findAll() {
		return _unitGroupLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.UnitGroup> findAll(
		int start, int end) {
		return _unitGroupLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.UnitGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _unitGroupLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.UnitGroup> findByUnit(
		long unitId) {
		return _unitGroupLocalService.findByUnit(unitId);
	}

	@Override
	public vn.com.ecopharma.emp.model.UnitGroup findByNameAndUnit(
		java.lang.String name, long unitId) {
		return _unitGroupLocalService.findByNameAndUnit(name, unitId);
	}

	@Override
	public vn.com.ecopharma.emp.model.UnitGroup createPrePersistedUnitGroup() {
		return _unitGroupLocalService.createPrePersistedUnitGroup();
	}

	@Override
	public vn.com.ecopharma.emp.model.UnitGroup addUnitGroup(
		java.lang.String name, long unitId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _unitGroupLocalService.addUnitGroup(name, unitId, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.UnitGroup addUnitGroup(
		vn.com.ecopharma.emp.model.UnitGroup unitGroup,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _unitGroupLocalService.addUnitGroup(unitGroup, serviceContext);
	}

	@Override
	public void completelyRemoveAll() {
		_unitGroupLocalService.completelyRemoveAll();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UnitGroupLocalService getWrappedUnitGroupLocalService() {
		return _unitGroupLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUnitGroupLocalService(
		UnitGroupLocalService unitGroupLocalService) {
		_unitGroupLocalService = unitGroupLocalService;
	}

	@Override
	public UnitGroupLocalService getWrappedService() {
		return _unitGroupLocalService;
	}

	@Override
	public void setWrappedService(UnitGroupLocalService unitGroupLocalService) {
		_unitGroupLocalService = unitGroupLocalService;
	}

	private UnitGroupLocalService _unitGroupLocalService;
}