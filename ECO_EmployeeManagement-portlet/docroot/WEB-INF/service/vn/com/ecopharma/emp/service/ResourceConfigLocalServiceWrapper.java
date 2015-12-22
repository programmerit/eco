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
 * Provides a wrapper for {@link ResourceConfigLocalService}.
 *
 * @author tvt
 * @see ResourceConfigLocalService
 * @generated
 */
public class ResourceConfigLocalServiceWrapper
	implements ResourceConfigLocalService,
		ServiceWrapper<ResourceConfigLocalService> {
	public ResourceConfigLocalServiceWrapper(
		ResourceConfigLocalService resourceConfigLocalService) {
		_resourceConfigLocalService = resourceConfigLocalService;
	}

	/**
	* Adds the resource config to the database. Also notifies the appropriate model listeners.
	*
	* @param resourceConfig the resource config
	* @return the resource config that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.ResourceConfig addResourceConfig(
		vn.com.ecopharma.emp.model.ResourceConfig resourceConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceConfigLocalService.addResourceConfig(resourceConfig);
	}

	/**
	* Creates a new resource config with the primary key. Does not add the resource config to the database.
	*
	* @param resourceConfigId the primary key for the new resource config
	* @return the new resource config
	*/
	@Override
	public vn.com.ecopharma.emp.model.ResourceConfig createResourceConfig(
		long resourceConfigId) {
		return _resourceConfigLocalService.createResourceConfig(resourceConfigId);
	}

	/**
	* Deletes the resource config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param resourceConfigId the primary key of the resource config
	* @return the resource config that was removed
	* @throws PortalException if a resource config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.ResourceConfig deleteResourceConfig(
		long resourceConfigId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _resourceConfigLocalService.deleteResourceConfig(resourceConfigId);
	}

	/**
	* Deletes the resource config from the database. Also notifies the appropriate model listeners.
	*
	* @param resourceConfig the resource config
	* @return the resource config that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.ResourceConfig deleteResourceConfig(
		vn.com.ecopharma.emp.model.ResourceConfig resourceConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceConfigLocalService.deleteResourceConfig(resourceConfig);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _resourceConfigLocalService.dynamicQuery();
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
		return _resourceConfigLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResourceConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _resourceConfigLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResourceConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _resourceConfigLocalService.dynamicQuery(dynamicQuery, start,
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
		return _resourceConfigLocalService.dynamicQueryCount(dynamicQuery);
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
		return _resourceConfigLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.ResourceConfig fetchResourceConfig(
		long resourceConfigId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceConfigLocalService.fetchResourceConfig(resourceConfigId);
	}

	/**
	* Returns the resource config with the primary key.
	*
	* @param resourceConfigId the primary key of the resource config
	* @return the resource config
	* @throws PortalException if a resource config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.ResourceConfig getResourceConfig(
		long resourceConfigId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _resourceConfigLocalService.getResourceConfig(resourceConfigId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _resourceConfigLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the resource configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResourceConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of resource configs
	* @param end the upper bound of the range of resource configs (not inclusive)
	* @return the range of resource configs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.ResourceConfig> getResourceConfigs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceConfigLocalService.getResourceConfigs(start, end);
	}

	/**
	* Returns the number of resource configs.
	*
	* @return the number of resource configs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getResourceConfigsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceConfigLocalService.getResourceConfigsCount();
	}

	/**
	* Updates the resource config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param resourceConfig the resource config
	* @return the resource config that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.ResourceConfig updateResourceConfig(
		vn.com.ecopharma.emp.model.ResourceConfig resourceConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceConfigLocalService.updateResourceConfig(resourceConfig);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _resourceConfigLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_resourceConfigLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _resourceConfigLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.ResourceConfig> findAll() {
		return _resourceConfigLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.ResourceConfig> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceConfigLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.ResourceConfig> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceConfigLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.ResourceConfig> findByType(
		java.lang.String type) {
		return _resourceConfigLocalService.findByType(type);
	}

	@Override
	public vn.com.ecopharma.emp.model.ResourceConfig findByKeyAndType(
		java.lang.String key, java.lang.String type) {
		return _resourceConfigLocalService.findByKeyAndType(key, type);
	}

	@Override
	public vn.com.ecopharma.emp.model.ResourceConfig findByKey(
		java.lang.String key) {
		return _resourceConfigLocalService.findByKey(key);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ResourceConfigLocalService getWrappedResourceConfigLocalService() {
		return _resourceConfigLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedResourceConfigLocalService(
		ResourceConfigLocalService resourceConfigLocalService) {
		_resourceConfigLocalService = resourceConfigLocalService;
	}

	@Override
	public ResourceConfigLocalService getWrappedService() {
		return _resourceConfigLocalService;
	}

	@Override
	public void setWrappedService(
		ResourceConfigLocalService resourceConfigLocalService) {
		_resourceConfigLocalService = resourceConfigLocalService;
	}

	private ResourceConfigLocalService _resourceConfigLocalService;
}