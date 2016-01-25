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
 * Provides a wrapper for {@link SpecializedLocalService}.
 *
 * @author tvt
 * @see SpecializedLocalService
 * @generated
 */
public class SpecializedLocalServiceWrapper implements SpecializedLocalService,
	ServiceWrapper<SpecializedLocalService> {
	public SpecializedLocalServiceWrapper(
		SpecializedLocalService specializedLocalService) {
		_specializedLocalService = specializedLocalService;
	}

	/**
	* Adds the specialized to the database. Also notifies the appropriate model listeners.
	*
	* @param specialized the specialized
	* @return the specialized that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Specialized addSpecialized(
		vn.com.ecopharma.emp.model.Specialized specialized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _specializedLocalService.addSpecialized(specialized);
	}

	/**
	* Creates a new specialized with the primary key. Does not add the specialized to the database.
	*
	* @param specializedId the primary key for the new specialized
	* @return the new specialized
	*/
	@Override
	public vn.com.ecopharma.emp.model.Specialized createSpecialized(
		long specializedId) {
		return _specializedLocalService.createSpecialized(specializedId);
	}

	/**
	* Deletes the specialized with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param specializedId the primary key of the specialized
	* @return the specialized that was removed
	* @throws PortalException if a specialized with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Specialized deleteSpecialized(
		long specializedId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _specializedLocalService.deleteSpecialized(specializedId);
	}

	/**
	* Deletes the specialized from the database. Also notifies the appropriate model listeners.
	*
	* @param specialized the specialized
	* @return the specialized that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Specialized deleteSpecialized(
		vn.com.ecopharma.emp.model.Specialized specialized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _specializedLocalService.deleteSpecialized(specialized);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _specializedLocalService.dynamicQuery();
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
		return _specializedLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _specializedLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _specializedLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _specializedLocalService.dynamicQueryCount(dynamicQuery);
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
		return _specializedLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.Specialized fetchSpecialized(
		long specializedId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _specializedLocalService.fetchSpecialized(specializedId);
	}

	/**
	* Returns the specialized with the primary key.
	*
	* @param specializedId the primary key of the specialized
	* @return the specialized
	* @throws PortalException if a specialized with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Specialized getSpecialized(
		long specializedId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _specializedLocalService.getSpecialized(specializedId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _specializedLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the specializeds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of specializeds
	* @param end the upper bound of the range of specializeds (not inclusive)
	* @return the range of specializeds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> getSpecializeds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _specializedLocalService.getSpecializeds(start, end);
	}

	/**
	* Returns the number of specializeds.
	*
	* @return the number of specializeds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSpecializedsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _specializedLocalService.getSpecializedsCount();
	}

	/**
	* Updates the specialized in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param specialized the specialized
	* @return the specialized that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Specialized updateSpecialized(
		vn.com.ecopharma.emp.model.Specialized specialized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _specializedLocalService.updateSpecialized(specialized);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _specializedLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_specializedLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _specializedLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _specializedLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> findAll(
		int start, int end) {
		return _specializedLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> findAll() {
		return _specializedLocalService.findAll();
	}

	@Override
	public vn.com.ecopharma.emp.model.Specialized findByName(
		java.lang.String name) {
		return _specializedLocalService.findByName(name);
	}

	@Override
	public vn.com.ecopharma.emp.model.Specialized createPreperistedEntity(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _specializedLocalService.createPreperistedEntity(serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Specialized createSpecialized(
		vn.com.ecopharma.emp.model.Specialized preObj, java.lang.String code,
		java.lang.String name, int level, long parentId, boolean isUniversity,
		boolean isCollege, boolean isVocationalCollege, boolean isVocational) {
		return _specializedLocalService.createSpecialized(preObj, code, name,
			level, parentId, isUniversity, isCollege, isVocationalCollege,
			isVocational);
	}

	@Override
	public vn.com.ecopharma.emp.model.Specialized createSpecialized(
		java.lang.String code, java.lang.String name, int level, long parentId,
		boolean isUniversity, boolean isCollege, boolean isVocationalCollege,
		boolean isVocational,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _specializedLocalService.createSpecialized(code, name, level,
			parentId, isUniversity, isCollege, isVocationalCollege,
			isVocational, serviceContext);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> findByLevel(
		int level) {
		return _specializedLocalService.findByLevel(level);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> findFirstLevelList() {
		return _specializedLocalService.findFirstLevelList();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> findByLevelAndParent(
		int level, long parentId) {
		return _specializedLocalService.findByLevelAndParent(level, parentId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> findSecondLevelList(
		long parentId) {
		return _specializedLocalService.findSecondLevelList(parentId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> findThirdLevelList(
		long parentId) {
		return _specializedLocalService.findThirdLevelList(parentId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SpecializedLocalService getWrappedSpecializedLocalService() {
		return _specializedLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSpecializedLocalService(
		SpecializedLocalService specializedLocalService) {
		_specializedLocalService = specializedLocalService;
	}

	@Override
	public SpecializedLocalService getWrappedService() {
		return _specializedLocalService;
	}

	@Override
	public void setWrappedService(
		SpecializedLocalService specializedLocalService) {
		_specializedLocalService = specializedLocalService;
	}

	private SpecializedLocalService _specializedLocalService;
}