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
 * Provides a wrapper for {@link DevisionLocalService}.
 *
 * @author tvt
 * @see DevisionLocalService
 * @generated
 */
public class DevisionLocalServiceWrapper implements DevisionLocalService,
	ServiceWrapper<DevisionLocalService> {
	public DevisionLocalServiceWrapper(
		DevisionLocalService devisionLocalService) {
		_devisionLocalService = devisionLocalService;
	}

	/**
	* Adds the devision to the database. Also notifies the appropriate model listeners.
	*
	* @param devision the devision
	* @return the devision that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Devision addDevision(
		vn.com.ecopharma.emp.model.Devision devision)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _devisionLocalService.addDevision(devision);
	}

	/**
	* Creates a new devision with the primary key. Does not add the devision to the database.
	*
	* @param devisionId the primary key for the new devision
	* @return the new devision
	*/
	@Override
	public vn.com.ecopharma.emp.model.Devision createDevision(long devisionId) {
		return _devisionLocalService.createDevision(devisionId);
	}

	/**
	* Deletes the devision with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param devisionId the primary key of the devision
	* @return the devision that was removed
	* @throws PortalException if a devision with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Devision deleteDevision(long devisionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _devisionLocalService.deleteDevision(devisionId);
	}

	/**
	* Deletes the devision from the database. Also notifies the appropriate model listeners.
	*
	* @param devision the devision
	* @return the devision that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Devision deleteDevision(
		vn.com.ecopharma.emp.model.Devision devision)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _devisionLocalService.deleteDevision(devision);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _devisionLocalService.dynamicQuery();
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
		return _devisionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DevisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _devisionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DevisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _devisionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _devisionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _devisionLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.Devision fetchDevision(long devisionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _devisionLocalService.fetchDevision(devisionId);
	}

	/**
	* Returns the devision with the primary key.
	*
	* @param devisionId the primary key of the devision
	* @return the devision
	* @throws PortalException if a devision with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Devision getDevision(long devisionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _devisionLocalService.getDevision(devisionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _devisionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the devisions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DevisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of devisions
	* @param end the upper bound of the range of devisions (not inclusive)
	* @return the range of devisions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Devision> getDevisions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _devisionLocalService.getDevisions(start, end);
	}

	/**
	* Returns the number of devisions.
	*
	* @return the number of devisions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDevisionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _devisionLocalService.getDevisionsCount();
	}

	/**
	* Updates the devision in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param devision the devision
	* @return the devision that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Devision updateDevision(
		vn.com.ecopharma.emp.model.Devision devision)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _devisionLocalService.updateDevision(devision);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _devisionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_devisionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _devisionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Devision> findAll() {
		return _devisionLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Devision> findAll(
		int start, int end) {
		return _devisionLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Devision> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _devisionLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public vn.com.ecopharma.emp.model.Devision addDevision(
		java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _devisionLocalService.addDevision(name, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Devision addDevision(
		vn.com.ecopharma.emp.model.Devision devision,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _devisionLocalService.addDevision(devision, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Devision findByName(java.lang.String name) {
		return _devisionLocalService.findByName(name);
	}

	@Override
	public void completelyDeleteAll() {
		_devisionLocalService.completelyDeleteAll();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DevisionLocalService getWrappedDevisionLocalService() {
		return _devisionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDevisionLocalService(
		DevisionLocalService devisionLocalService) {
		_devisionLocalService = devisionLocalService;
	}

	@Override
	public DevisionLocalService getWrappedService() {
		return _devisionLocalService;
	}

	@Override
	public void setWrappedService(DevisionLocalService devisionLocalService) {
		_devisionLocalService = devisionLocalService;
	}

	private DevisionLocalService _devisionLocalService;
}