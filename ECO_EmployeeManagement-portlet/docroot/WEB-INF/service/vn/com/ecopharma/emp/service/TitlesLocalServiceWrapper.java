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
 * Provides a wrapper for {@link TitlesLocalService}.
 *
 * @author tvt
 * @see TitlesLocalService
 * @generated
 */
public class TitlesLocalServiceWrapper implements TitlesLocalService,
	ServiceWrapper<TitlesLocalService> {
	public TitlesLocalServiceWrapper(TitlesLocalService titlesLocalService) {
		_titlesLocalService = titlesLocalService;
	}

	/**
	* Adds the titles to the database. Also notifies the appropriate model listeners.
	*
	* @param titles the titles
	* @return the titles that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Titles addTitles(
		vn.com.ecopharma.emp.model.Titles titles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _titlesLocalService.addTitles(titles);
	}

	/**
	* Creates a new titles with the primary key. Does not add the titles to the database.
	*
	* @param titlesId the primary key for the new titles
	* @return the new titles
	*/
	@Override
	public vn.com.ecopharma.emp.model.Titles createTitles(long titlesId) {
		return _titlesLocalService.createTitles(titlesId);
	}

	/**
	* Deletes the titles with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param titlesId the primary key of the titles
	* @return the titles that was removed
	* @throws PortalException if a titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Titles deleteTitles(long titlesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _titlesLocalService.deleteTitles(titlesId);
	}

	/**
	* Deletes the titles from the database. Also notifies the appropriate model listeners.
	*
	* @param titles the titles
	* @return the titles that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Titles deleteTitles(
		vn.com.ecopharma.emp.model.Titles titles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _titlesLocalService.deleteTitles(titles);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _titlesLocalService.dynamicQuery();
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
		return _titlesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _titlesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _titlesLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _titlesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _titlesLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.Titles fetchTitles(long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _titlesLocalService.fetchTitles(titlesId);
	}

	/**
	* Returns the titles with the primary key.
	*
	* @param titlesId the primary key of the titles
	* @return the titles
	* @throws PortalException if a titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Titles getTitles(long titlesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _titlesLocalService.getTitles(titlesId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _titlesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the titleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of titleses
	* @param end the upper bound of the range of titleses (not inclusive)
	* @return the range of titleses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Titles> getTitleses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _titlesLocalService.getTitleses(start, end);
	}

	/**
	* Returns the number of titleses.
	*
	* @return the number of titleses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTitlesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _titlesLocalService.getTitlesesCount();
	}

	/**
	* Updates the titles in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param titles the titles
	* @return the titles that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Titles updateTitles(
		vn.com.ecopharma.emp.model.Titles titles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _titlesLocalService.updateTitles(titles);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _titlesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_titlesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _titlesLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Titles> findAll() {
		return _titlesLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Titles> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _titlesLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Titles> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _titlesLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public vn.com.ecopharma.emp.model.Titles createTitles(
		java.lang.String name, long unitGroupId, long unitId,
		long departmentId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _titlesLocalService.createTitles(name, unitGroupId, unitId,
			departmentId, serviceContext);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Titles> findByUnit(
		long unitId) {
		return _titlesLocalService.findByUnit(unitId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Titles> findByUnitAndNullUnitGroup(
		long unitId) {
		return _titlesLocalService.findByUnitAndNullUnitGroup(unitId);
	}

	@Override
	public vn.com.ecopharma.emp.model.Titles findByNameAndUnit(
		java.lang.String name, long unitId) {
		return _titlesLocalService.findByNameAndUnit(name, unitId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Titles> findByUnitGroup(
		long unitGroupId) {
		return _titlesLocalService.findByUnitGroup(unitGroupId);
	}

	@Override
	public vn.com.ecopharma.emp.model.Titles findByNameAndUnitGroup(
		java.lang.String name, long unitGroupId) {
		return _titlesLocalService.findByNameAndUnitGroup(name, unitGroupId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Titles> findByDepartment(
		long departmentId) {
		return _titlesLocalService.findByDepartment(departmentId);
	}

	@Override
	public vn.com.ecopharma.emp.model.Titles findByNameAndDepartment(
		java.lang.String name, long departmentId) {
		return _titlesLocalService.findByNameAndDepartment(name, departmentId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Titles> findByNameAndRelatedEntities(
		vn.com.ecopharma.emp.model.Department department,
		vn.com.ecopharma.emp.model.Unit unit,
		vn.com.ecopharma.emp.model.UnitGroup unitGroup) {
		return _titlesLocalService.findByNameAndRelatedEntities(department,
			unit, unitGroup);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Titles> findFilterTitlesByRelatedEntities(
		vn.com.ecopharma.emp.model.Department department,
		vn.com.ecopharma.emp.model.Unit unit,
		vn.com.ecopharma.emp.model.UnitGroup unitGroup) {
		return _titlesLocalService.findFilterTitlesByRelatedEntities(department,
			unit, unitGroup);
	}

	@Override
	public vn.com.ecopharma.emp.model.Titles findByName(java.lang.String name) {
		return _titlesLocalService.findByName(name);
	}

	@Override
	public vn.com.ecopharma.emp.model.Titles findByNameAndRelatedFields(
		java.lang.String name, long unitGroupId, long unitId, long departmentId) {
		return _titlesLocalService.findByNameAndRelatedFields(name,
			unitGroupId, unitId, departmentId);
	}

	@Override
	public vn.com.ecopharma.emp.model.Titles createPrePersistedTitles() {
		return _titlesLocalService.createPrePersistedTitles();
	}

	@Override
	public vn.com.ecopharma.emp.model.Titles updateTitles(
		vn.com.ecopharma.emp.model.Titles titles, long unitGroupId,
		long unitId, long departmentId) {
		return _titlesLocalService.updateTitles(titles, unitGroupId, unitId,
			departmentId);
	}

	@Override
	public void completelyRemoveAll() {
		_titlesLocalService.completelyRemoveAll();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TitlesLocalService getWrappedTitlesLocalService() {
		return _titlesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTitlesLocalService(
		TitlesLocalService titlesLocalService) {
		_titlesLocalService = titlesLocalService;
	}

	@Override
	public TitlesLocalService getWrappedService() {
		return _titlesLocalService;
	}

	@Override
	public void setWrappedService(TitlesLocalService titlesLocalService) {
		_titlesLocalService = titlesLocalService;
	}

	private TitlesLocalService _titlesLocalService;
}