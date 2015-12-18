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
 * Provides a wrapper for {@link DevisionGroupLocalService}.
 *
 * @author tvt
 * @see DevisionGroupLocalService
 * @generated
 */
public class DevisionGroupLocalServiceWrapper
	implements DevisionGroupLocalService,
		ServiceWrapper<DevisionGroupLocalService> {
	public DevisionGroupLocalServiceWrapper(
		DevisionGroupLocalService devisionGroupLocalService) {
		_devisionGroupLocalService = devisionGroupLocalService;
	}

	/**
	* Adds the devision group to the database. Also notifies the appropriate model listeners.
	*
	* @param devisionGroup the devision group
	* @return the devision group that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.DevisionGroup addDevisionGroup(
		vn.com.ecopharma.emp.model.DevisionGroup devisionGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _devisionGroupLocalService.addDevisionGroup(devisionGroup);
	}

	/**
	* Creates a new devision group with the primary key. Does not add the devision group to the database.
	*
	* @param devisionGroupId the primary key for the new devision group
	* @return the new devision group
	*/
	@Override
	public vn.com.ecopharma.emp.model.DevisionGroup createDevisionGroup(
		long devisionGroupId) {
		return _devisionGroupLocalService.createDevisionGroup(devisionGroupId);
	}

	/**
	* Deletes the devision group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param devisionGroupId the primary key of the devision group
	* @return the devision group that was removed
	* @throws PortalException if a devision group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.DevisionGroup deleteDevisionGroup(
		long devisionGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _devisionGroupLocalService.deleteDevisionGroup(devisionGroupId);
	}

	/**
	* Deletes the devision group from the database. Also notifies the appropriate model listeners.
	*
	* @param devisionGroup the devision group
	* @return the devision group that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.DevisionGroup deleteDevisionGroup(
		vn.com.ecopharma.emp.model.DevisionGroup devisionGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _devisionGroupLocalService.deleteDevisionGroup(devisionGroup);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _devisionGroupLocalService.dynamicQuery();
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
		return _devisionGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DevisionGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _devisionGroupLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DevisionGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _devisionGroupLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _devisionGroupLocalService.dynamicQueryCount(dynamicQuery);
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
		return _devisionGroupLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.DevisionGroup fetchDevisionGroup(
		long devisionGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _devisionGroupLocalService.fetchDevisionGroup(devisionGroupId);
	}

	/**
	* Returns the devision group with the primary key.
	*
	* @param devisionGroupId the primary key of the devision group
	* @return the devision group
	* @throws PortalException if a devision group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.DevisionGroup getDevisionGroup(
		long devisionGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _devisionGroupLocalService.getDevisionGroup(devisionGroupId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _devisionGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the devision groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DevisionGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of devision groups
	* @param end the upper bound of the range of devision groups (not inclusive)
	* @return the range of devision groups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.DevisionGroup> getDevisionGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _devisionGroupLocalService.getDevisionGroups(start, end);
	}

	/**
	* Returns the number of devision groups.
	*
	* @return the number of devision groups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDevisionGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _devisionGroupLocalService.getDevisionGroupsCount();
	}

	/**
	* Updates the devision group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param devisionGroup the devision group
	* @return the devision group that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.DevisionGroup updateDevisionGroup(
		vn.com.ecopharma.emp.model.DevisionGroup devisionGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _devisionGroupLocalService.updateDevisionGroup(devisionGroup);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _devisionGroupLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_devisionGroupLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _devisionGroupLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.DevisionGroup> findAll() {
		return _devisionGroupLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.DevisionGroup> findAll(
		int start, int end) {
		return _devisionGroupLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.DevisionGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _devisionGroupLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.DevisionGroup> findByDevision(
		long devisionId) {
		return _devisionGroupLocalService.findByDevision(devisionId);
	}

	@Override
	public vn.com.ecopharma.emp.model.DevisionGroup findByNameAndDevision(
		java.lang.String name, long devisionId) {
		return _devisionGroupLocalService.findByNameAndDevision(name, devisionId);
	}

	@Override
	public vn.com.ecopharma.emp.model.DevisionGroup addDevisionGroup(
		java.lang.String name, long devisionId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _devisionGroupLocalService.addDevisionGroup(name, devisionId,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DevisionGroupLocalService getWrappedDevisionGroupLocalService() {
		return _devisionGroupLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDevisionGroupLocalService(
		DevisionGroupLocalService devisionGroupLocalService) {
		_devisionGroupLocalService = devisionGroupLocalService;
	}

	@Override
	public DevisionGroupLocalService getWrappedService() {
		return _devisionGroupLocalService;
	}

	@Override
	public void setWrappedService(
		DevisionGroupLocalService devisionGroupLocalService) {
		_devisionGroupLocalService = devisionGroupLocalService;
	}

	private DevisionGroupLocalService _devisionGroupLocalService;
}