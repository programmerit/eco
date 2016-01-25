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
 * Provides a wrapper for {@link TitlesDepartmentUnitUnitGroupLocalService}.
 *
 * @author tvt
 * @see TitlesDepartmentUnitUnitGroupLocalService
 * @generated
 */
public class TitlesDepartmentUnitUnitGroupLocalServiceWrapper
	implements TitlesDepartmentUnitUnitGroupLocalService,
		ServiceWrapper<TitlesDepartmentUnitUnitGroupLocalService> {
	public TitlesDepartmentUnitUnitGroupLocalServiceWrapper(
		TitlesDepartmentUnitUnitGroupLocalService titlesDepartmentUnitUnitGroupLocalService) {
		_titlesDepartmentUnitUnitGroupLocalService = titlesDepartmentUnitUnitGroupLocalService;
	}

	/**
	* Adds the titles department unit unit group to the database. Also notifies the appropriate model listeners.
	*
	* @param titlesDepartmentUnitUnitGroup the titles department unit unit group
	* @return the titles department unit unit group that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup addTitlesDepartmentUnitUnitGroup(
		vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _titlesDepartmentUnitUnitGroupLocalService.addTitlesDepartmentUnitUnitGroup(titlesDepartmentUnitUnitGroup);
	}

	/**
	* Creates a new titles department unit unit group with the primary key. Does not add the titles department unit unit group to the database.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key for the new titles department unit unit group
	* @return the new titles department unit unit group
	*/
	@Override
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup createTitlesDepartmentUnitUnitGroup(
		long titlesDepartmentUnitUnitGroupId) {
		return _titlesDepartmentUnitUnitGroupLocalService.createTitlesDepartmentUnitUnitGroup(titlesDepartmentUnitUnitGroupId);
	}

	/**
	* Deletes the titles department unit unit group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the titles department unit unit group
	* @return the titles department unit unit group that was removed
	* @throws PortalException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup deleteTitlesDepartmentUnitUnitGroup(
		long titlesDepartmentUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _titlesDepartmentUnitUnitGroupLocalService.deleteTitlesDepartmentUnitUnitGroup(titlesDepartmentUnitUnitGroupId);
	}

	/**
	* Deletes the titles department unit unit group from the database. Also notifies the appropriate model listeners.
	*
	* @param titlesDepartmentUnitUnitGroup the titles department unit unit group
	* @return the titles department unit unit group that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup deleteTitlesDepartmentUnitUnitGroup(
		vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _titlesDepartmentUnitUnitGroupLocalService.deleteTitlesDepartmentUnitUnitGroup(titlesDepartmentUnitUnitGroup);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _titlesDepartmentUnitUnitGroupLocalService.dynamicQuery();
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
		return _titlesDepartmentUnitUnitGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _titlesDepartmentUnitUnitGroupLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _titlesDepartmentUnitUnitGroupLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _titlesDepartmentUnitUnitGroupLocalService.dynamicQueryCount(dynamicQuery);
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
		return _titlesDepartmentUnitUnitGroupLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchTitlesDepartmentUnitUnitGroup(
		long titlesDepartmentUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _titlesDepartmentUnitUnitGroupLocalService.fetchTitlesDepartmentUnitUnitGroup(titlesDepartmentUnitUnitGroupId);
	}

	/**
	* Returns the titles department unit unit group with the primary key.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the titles department unit unit group
	* @return the titles department unit unit group
	* @throws PortalException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup getTitlesDepartmentUnitUnitGroup(
		long titlesDepartmentUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _titlesDepartmentUnitUnitGroupLocalService.getTitlesDepartmentUnitUnitGroup(titlesDepartmentUnitUnitGroupId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _titlesDepartmentUnitUnitGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the titles department unit unit groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @return the range of titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> getTitlesDepartmentUnitUnitGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _titlesDepartmentUnitUnitGroupLocalService.getTitlesDepartmentUnitUnitGroups(start,
			end);
	}

	/**
	* Returns the number of titles department unit unit groups.
	*
	* @return the number of titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTitlesDepartmentUnitUnitGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _titlesDepartmentUnitUnitGroupLocalService.getTitlesDepartmentUnitUnitGroupsCount();
	}

	/**
	* Updates the titles department unit unit group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param titlesDepartmentUnitUnitGroup the titles department unit unit group
	* @return the titles department unit unit group that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup updateTitlesDepartmentUnitUnitGroup(
		vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _titlesDepartmentUnitUnitGroupLocalService.updateTitlesDepartmentUnitUnitGroup(titlesDepartmentUnitUnitGroup);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _titlesDepartmentUnitUnitGroupLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_titlesDepartmentUnitUnitGroupLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _titlesDepartmentUnitUnitGroupLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findAll() {
		return _titlesDepartmentUnitUnitGroupLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findAll(
		int start, int end) {
		return _titlesDepartmentUnitUnitGroupLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _titlesDepartmentUnitUnitGroupLocalService.findAll(start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByDepartment(
		long departmentId) {
		return _titlesDepartmentUnitUnitGroupLocalService.findByDepartment(departmentId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnit(
		long unitId) {
		return _titlesDepartmentUnitUnitGroupLocalService.findByUnit(unitId);
	}

	@Override
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup addTitlesDepartmentUnitUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _titlesDepartmentUnitUnitGroupLocalService.addTitlesDepartmentUnitUnitGroup(titlesId,
			departmentId, unitId, unitGroupId, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup addTitlesDepartmentUnitUnitGroup(
		vn.com.ecopharma.emp.model.Titles titles,
		vn.com.ecopharma.emp.model.Department department,
		vn.com.ecopharma.emp.model.Unit unit,
		vn.com.ecopharma.emp.model.UnitGroup unitGroup,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _titlesDepartmentUnitUnitGroupLocalService.addTitlesDepartmentUnitUnitGroup(titles,
			department, unit, unitGroup, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByTitlesDepartmentUnitUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId) {
		return _titlesDepartmentUnitUnitGroupLocalService.findByTitlesDepartmentUnitUnitGroup(titlesId,
			departmentId, unitId, unitGroupId);
	}

	@Override
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByTitlesDepartmentUnitUnitGroup(
		vn.com.ecopharma.emp.model.Titles titles,
		vn.com.ecopharma.emp.model.Department department,
		vn.com.ecopharma.emp.model.Unit unit,
		vn.com.ecopharma.emp.model.UnitGroup unitGroup) {
		return _titlesDepartmentUnitUnitGroupLocalService.findByTitlesDepartmentUnitUnitGroup(titles,
			department, unit, unitGroup);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByDepartmentUnitUnitGroup(
		long departmentId, long unitId, long unitGroupId) {
		return _titlesDepartmentUnitUnitGroupLocalService.findByDepartmentUnitUnitGroup(departmentId,
			unitId, unitGroupId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnitUnitGroup(
		long unitId, long unitGroupId) {
		return _titlesDepartmentUnitUnitGroupLocalService.findByUnitUnitGroup(unitId,
			unitGroupId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnitGroup(
		long unitGroupId) {
		return _titlesDepartmentUnitUnitGroupLocalService.findByUnitGroup(unitGroupId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByTitlesDepartmentUnitNoneUnitGroup(
		long titlesId, long departmentId, long unitId) {
		return _titlesDepartmentUnitUnitGroupLocalService.findByTitlesDepartmentUnitNoneUnitGroup(titlesId,
			departmentId, unitId);
	}

	@Override
	public void completelyRemoveAll() {
		_titlesDepartmentUnitUnitGroupLocalService.completelyRemoveAll();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TitlesDepartmentUnitUnitGroupLocalService getWrappedTitlesDepartmentUnitUnitGroupLocalService() {
		return _titlesDepartmentUnitUnitGroupLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTitlesDepartmentUnitUnitGroupLocalService(
		TitlesDepartmentUnitUnitGroupLocalService titlesDepartmentUnitUnitGroupLocalService) {
		_titlesDepartmentUnitUnitGroupLocalService = titlesDepartmentUnitUnitGroupLocalService;
	}

	@Override
	public TitlesDepartmentUnitUnitGroupLocalService getWrappedService() {
		return _titlesDepartmentUnitUnitGroupLocalService;
	}

	@Override
	public void setWrappedService(
		TitlesDepartmentUnitUnitGroupLocalService titlesDepartmentUnitUnitGroupLocalService) {
		_titlesDepartmentUnitUnitGroupLocalService = titlesDepartmentUnitUnitGroupLocalService;
	}

	private TitlesDepartmentUnitUnitGroupLocalService _titlesDepartmentUnitUnitGroupLocalService;
}