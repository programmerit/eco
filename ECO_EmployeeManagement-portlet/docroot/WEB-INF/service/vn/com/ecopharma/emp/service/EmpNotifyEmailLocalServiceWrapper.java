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
 * Provides a wrapper for {@link EmpNotifyEmailLocalService}.
 *
 * @author tvt
 * @see EmpNotifyEmailLocalService
 * @generated
 */
public class EmpNotifyEmailLocalServiceWrapper
	implements EmpNotifyEmailLocalService,
		ServiceWrapper<EmpNotifyEmailLocalService> {
	public EmpNotifyEmailLocalServiceWrapper(
		EmpNotifyEmailLocalService empNotifyEmailLocalService) {
		_empNotifyEmailLocalService = empNotifyEmailLocalService;
	}

	/**
	* Adds the emp notify email to the database. Also notifies the appropriate model listeners.
	*
	* @param empNotifyEmail the emp notify email
	* @return the emp notify email that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpNotifyEmail addEmpNotifyEmail(
		vn.com.ecopharma.emp.model.EmpNotifyEmail empNotifyEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empNotifyEmailLocalService.addEmpNotifyEmail(empNotifyEmail);
	}

	/**
	* Creates a new emp notify email with the primary key. Does not add the emp notify email to the database.
	*
	* @param empNotifyEmailId the primary key for the new emp notify email
	* @return the new emp notify email
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpNotifyEmail createEmpNotifyEmail(
		long empNotifyEmailId) {
		return _empNotifyEmailLocalService.createEmpNotifyEmail(empNotifyEmailId);
	}

	/**
	* Deletes the emp notify email with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empNotifyEmailId the primary key of the emp notify email
	* @return the emp notify email that was removed
	* @throws PortalException if a emp notify email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpNotifyEmail deleteEmpNotifyEmail(
		long empNotifyEmailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empNotifyEmailLocalService.deleteEmpNotifyEmail(empNotifyEmailId);
	}

	/**
	* Deletes the emp notify email from the database. Also notifies the appropriate model listeners.
	*
	* @param empNotifyEmail the emp notify email
	* @return the emp notify email that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpNotifyEmail deleteEmpNotifyEmail(
		vn.com.ecopharma.emp.model.EmpNotifyEmail empNotifyEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empNotifyEmailLocalService.deleteEmpNotifyEmail(empNotifyEmail);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empNotifyEmailLocalService.dynamicQuery();
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
		return _empNotifyEmailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpNotifyEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empNotifyEmailLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpNotifyEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empNotifyEmailLocalService.dynamicQuery(dynamicQuery, start,
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
		return _empNotifyEmailLocalService.dynamicQueryCount(dynamicQuery);
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
		return _empNotifyEmailLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpNotifyEmail fetchEmpNotifyEmail(
		long empNotifyEmailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empNotifyEmailLocalService.fetchEmpNotifyEmail(empNotifyEmailId);
	}

	/**
	* Returns the emp notify email with the primary key.
	*
	* @param empNotifyEmailId the primary key of the emp notify email
	* @return the emp notify email
	* @throws PortalException if a emp notify email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpNotifyEmail getEmpNotifyEmail(
		long empNotifyEmailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empNotifyEmailLocalService.getEmpNotifyEmail(empNotifyEmailId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empNotifyEmailLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the emp notify emails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpNotifyEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp notify emails
	* @param end the upper bound of the range of emp notify emails (not inclusive)
	* @return the range of emp notify emails
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail> getEmpNotifyEmails(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empNotifyEmailLocalService.getEmpNotifyEmails(start, end);
	}

	/**
	* Returns the number of emp notify emails.
	*
	* @return the number of emp notify emails
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmpNotifyEmailsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empNotifyEmailLocalService.getEmpNotifyEmailsCount();
	}

	/**
	* Updates the emp notify email in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empNotifyEmail the emp notify email
	* @return the emp notify email that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpNotifyEmail updateEmpNotifyEmail(
		vn.com.ecopharma.emp.model.EmpNotifyEmail empNotifyEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empNotifyEmailLocalService.updateEmpNotifyEmail(empNotifyEmail);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empNotifyEmailLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empNotifyEmailLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empNotifyEmailLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail> findAll() {
		return _empNotifyEmailLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail> findAll(
		int start, int end) {
		return _empNotifyEmailLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _empNotifyEmailLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail> findByStatus(
		java.lang.String status) {
		return _empNotifyEmailLocalService.findByStatus(status);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpNotifyEmail createPreperistedEntity()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empNotifyEmailLocalService.createPreperistedEntity();
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpNotifyEmail createEmpNotifyEmail(
		long empId, java.lang.String type, java.lang.String status) {
		return _empNotifyEmailLocalService.createEmpNotifyEmail(empId, type,
			status);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpNotifyEmail updateEmpNotifyEmail(
		long empNotifyEmailId, java.lang.String status) {
		return _empNotifyEmailLocalService.updateEmpNotifyEmail(empNotifyEmailId,
			status);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpNotifyEmail updateSentMailNotify(
		long empNotifyEmailId) {
		return _empNotifyEmailLocalService.updateSentMailNotify(empNotifyEmailId);
	}

	@Override
	public void updateSentMailNotifications(
		java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail> items) {
		_empNotifyEmailLocalService.updateSentMailNotifications(items);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpNotifyEmail removeEmpNotifyEmail(
		long id) {
		return _empNotifyEmailLocalService.removeEmpNotifyEmail(id);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpNotifyEmailLocalService getWrappedEmpNotifyEmailLocalService() {
		return _empNotifyEmailLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpNotifyEmailLocalService(
		EmpNotifyEmailLocalService empNotifyEmailLocalService) {
		_empNotifyEmailLocalService = empNotifyEmailLocalService;
	}

	@Override
	public EmpNotifyEmailLocalService getWrappedService() {
		return _empNotifyEmailLocalService;
	}

	@Override
	public void setWrappedService(
		EmpNotifyEmailLocalService empNotifyEmailLocalService) {
		_empNotifyEmailLocalService = empNotifyEmailLocalService;
	}

	private EmpNotifyEmailLocalService _empNotifyEmailLocalService;
}