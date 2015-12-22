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
 * Provides a wrapper for {@link SubUnitLocalService}.
 *
 * @author tvt
 * @see SubUnitLocalService
 * @generated
 */
public class SubUnitLocalServiceWrapper implements SubUnitLocalService,
	ServiceWrapper<SubUnitLocalService> {
	public SubUnitLocalServiceWrapper(SubUnitLocalService subUnitLocalService) {
		_subUnitLocalService = subUnitLocalService;
	}

	/**
	* Adds the sub unit to the database. Also notifies the appropriate model listeners.
	*
	* @param subUnit the sub unit
	* @return the sub unit that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.SubUnit addSubUnit(
		vn.com.ecopharma.emp.model.SubUnit subUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subUnitLocalService.addSubUnit(subUnit);
	}

	/**
	* Creates a new sub unit with the primary key. Does not add the sub unit to the database.
	*
	* @param subUnitId the primary key for the new sub unit
	* @return the new sub unit
	*/
	@Override
	public vn.com.ecopharma.emp.model.SubUnit createSubUnit(long subUnitId) {
		return _subUnitLocalService.createSubUnit(subUnitId);
	}

	/**
	* Deletes the sub unit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subUnitId the primary key of the sub unit
	* @return the sub unit that was removed
	* @throws PortalException if a sub unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.SubUnit deleteSubUnit(long subUnitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subUnitLocalService.deleteSubUnit(subUnitId);
	}

	/**
	* Deletes the sub unit from the database. Also notifies the appropriate model listeners.
	*
	* @param subUnit the sub unit
	* @return the sub unit that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.SubUnit deleteSubUnit(
		vn.com.ecopharma.emp.model.SubUnit subUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subUnitLocalService.deleteSubUnit(subUnit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _subUnitLocalService.dynamicQuery();
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
		return _subUnitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SubUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _subUnitLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SubUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _subUnitLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _subUnitLocalService.dynamicQueryCount(dynamicQuery);
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
		return _subUnitLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.SubUnit fetchSubUnit(long subUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subUnitLocalService.fetchSubUnit(subUnitId);
	}

	/**
	* Returns the sub unit with the primary key.
	*
	* @param subUnitId the primary key of the sub unit
	* @return the sub unit
	* @throws PortalException if a sub unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.SubUnit getSubUnit(long subUnitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subUnitLocalService.getSubUnit(subUnitId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subUnitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the sub units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SubUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sub units
	* @param end the upper bound of the range of sub units (not inclusive)
	* @return the range of sub units
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.SubUnit> getSubUnits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subUnitLocalService.getSubUnits(start, end);
	}

	/**
	* Returns the number of sub units.
	*
	* @return the number of sub units
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSubUnitsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subUnitLocalService.getSubUnitsCount();
	}

	/**
	* Updates the sub unit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param subUnit the sub unit
	* @return the sub unit that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.SubUnit updateSubUnit(
		vn.com.ecopharma.emp.model.SubUnit subUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subUnitLocalService.updateSubUnit(subUnit);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _subUnitLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_subUnitLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _subUnitLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.SubUnit> findAll() {
		return _subUnitLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.SubUnit> findAll(
		int start, int end) {
		return _subUnitLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.SubUnit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _subUnitLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public vn.com.ecopharma.emp.model.SubUnit create(java.lang.String name,
		long userId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subUnitLocalService.create(name, userId, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.SubUnit findByName(java.lang.String name) {
		return _subUnitLocalService.findByName(name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SubUnitLocalService getWrappedSubUnitLocalService() {
		return _subUnitLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSubUnitLocalService(
		SubUnitLocalService subUnitLocalService) {
		_subUnitLocalService = subUnitLocalService;
	}

	@Override
	public SubUnitLocalService getWrappedService() {
		return _subUnitLocalService;
	}

	@Override
	public void setWrappedService(SubUnitLocalService subUnitLocalService) {
		_subUnitLocalService = subUnitLocalService;
	}

	private SubUnitLocalService _subUnitLocalService;
}