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
 * Provides a wrapper for {@link EmpActionHistoryLocalService}.
 *
 * @author tvt
 * @see EmpActionHistoryLocalService
 * @generated
 */
public class EmpActionHistoryLocalServiceWrapper
	implements EmpActionHistoryLocalService,
		ServiceWrapper<EmpActionHistoryLocalService> {
	public EmpActionHistoryLocalServiceWrapper(
		EmpActionHistoryLocalService empActionHistoryLocalService) {
		_empActionHistoryLocalService = empActionHistoryLocalService;
	}

	/**
	* Adds the emp action history to the database. Also notifies the appropriate model listeners.
	*
	* @param empActionHistory the emp action history
	* @return the emp action history that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpActionHistory addEmpActionHistory(
		vn.com.ecopharma.emp.model.EmpActionHistory empActionHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empActionHistoryLocalService.addEmpActionHistory(empActionHistory);
	}

	/**
	* Creates a new emp action history with the primary key. Does not add the emp action history to the database.
	*
	* @param empActionHistoryId the primary key for the new emp action history
	* @return the new emp action history
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpActionHistory createEmpActionHistory(
		long empActionHistoryId) {
		return _empActionHistoryLocalService.createEmpActionHistory(empActionHistoryId);
	}

	/**
	* Deletes the emp action history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empActionHistoryId the primary key of the emp action history
	* @return the emp action history that was removed
	* @throws PortalException if a emp action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpActionHistory deleteEmpActionHistory(
		long empActionHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empActionHistoryLocalService.deleteEmpActionHistory(empActionHistoryId);
	}

	/**
	* Deletes the emp action history from the database. Also notifies the appropriate model listeners.
	*
	* @param empActionHistory the emp action history
	* @return the emp action history that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpActionHistory deleteEmpActionHistory(
		vn.com.ecopharma.emp.model.EmpActionHistory empActionHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empActionHistoryLocalService.deleteEmpActionHistory(empActionHistory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empActionHistoryLocalService.dynamicQuery();
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
		return _empActionHistoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empActionHistoryLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empActionHistoryLocalService.dynamicQuery(dynamicQuery, start,
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
		return _empActionHistoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _empActionHistoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpActionHistory fetchEmpActionHistory(
		long empActionHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empActionHistoryLocalService.fetchEmpActionHistory(empActionHistoryId);
	}

	/**
	* Returns the emp action history with the primary key.
	*
	* @param empActionHistoryId the primary key of the emp action history
	* @return the emp action history
	* @throws PortalException if a emp action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpActionHistory getEmpActionHistory(
		long empActionHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empActionHistoryLocalService.getEmpActionHistory(empActionHistoryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empActionHistoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the emp action histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp action histories
	* @param end the upper bound of the range of emp action histories (not inclusive)
	* @return the range of emp action histories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpActionHistory> getEmpActionHistories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empActionHistoryLocalService.getEmpActionHistories(start, end);
	}

	/**
	* Returns the number of emp action histories.
	*
	* @return the number of emp action histories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmpActionHistoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empActionHistoryLocalService.getEmpActionHistoriesCount();
	}

	/**
	* Updates the emp action history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empActionHistory the emp action history
	* @return the emp action history that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpActionHistory updateEmpActionHistory(
		vn.com.ecopharma.emp.model.EmpActionHistory empActionHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empActionHistoryLocalService.updateEmpActionHistory(empActionHistory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empActionHistoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empActionHistoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empActionHistoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpActionHistory> findAll() {
		return _empActionHistoryLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpActionHistory> findAll(
		int start, int end) {
		return _empActionHistoryLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpActionHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _empActionHistoryLocalService.findAll(start, end,
			orderByComparator);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpActionHistory createPrePersistedEntity(
		long empId, java.lang.String action, long performedBy,
		java.lang.String description, java.lang.String status, long refId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _empActionHistoryLocalService.createPrePersistedEntity(empId,
			action, performedBy, description, status, refId, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpActionHistory addEmpActionHistory(
		vn.com.ecopharma.emp.model.EmpActionHistory actionHistory,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _empActionHistoryLocalService.addEmpActionHistory(actionHistory,
			serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpActionHistory addEmpActionHistory(
		long empId, java.lang.String action, long performedBy,
		java.lang.String description, java.lang.String status, long refId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _empActionHistoryLocalService.addEmpActionHistory(empId, action,
			performedBy, description, status, refId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpActionHistoryLocalService getWrappedEmpActionHistoryLocalService() {
		return _empActionHistoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpActionHistoryLocalService(
		EmpActionHistoryLocalService empActionHistoryLocalService) {
		_empActionHistoryLocalService = empActionHistoryLocalService;
	}

	@Override
	public EmpActionHistoryLocalService getWrappedService() {
		return _empActionHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		EmpActionHistoryLocalService empActionHistoryLocalService) {
		_empActionHistoryLocalService = empActionHistoryLocalService;
	}

	private EmpActionHistoryLocalService _empActionHistoryLocalService;
}