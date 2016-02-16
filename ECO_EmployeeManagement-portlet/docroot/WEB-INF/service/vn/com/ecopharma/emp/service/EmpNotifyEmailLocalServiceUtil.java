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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for EmpNotifyEmail. This utility wraps
 * {@link vn.com.ecopharma.emp.service.impl.EmpNotifyEmailLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see EmpNotifyEmailLocalService
 * @see vn.com.ecopharma.emp.service.base.EmpNotifyEmailLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.impl.EmpNotifyEmailLocalServiceImpl
 * @generated
 */
public class EmpNotifyEmailLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.emp.service.impl.EmpNotifyEmailLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the emp notify email to the database. Also notifies the appropriate model listeners.
	*
	* @param empNotifyEmail the emp notify email
	* @return the emp notify email that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpNotifyEmail addEmpNotifyEmail(
		vn.com.ecopharma.emp.model.EmpNotifyEmail empNotifyEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEmpNotifyEmail(empNotifyEmail);
	}

	/**
	* Creates a new emp notify email with the primary key. Does not add the emp notify email to the database.
	*
	* @param empNotifyEmailId the primary key for the new emp notify email
	* @return the new emp notify email
	*/
	public static vn.com.ecopharma.emp.model.EmpNotifyEmail createEmpNotifyEmail(
		long empNotifyEmailId) {
		return getService().createEmpNotifyEmail(empNotifyEmailId);
	}

	/**
	* Deletes the emp notify email with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empNotifyEmailId the primary key of the emp notify email
	* @return the emp notify email that was removed
	* @throws PortalException if a emp notify email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpNotifyEmail deleteEmpNotifyEmail(
		long empNotifyEmailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmpNotifyEmail(empNotifyEmailId);
	}

	/**
	* Deletes the emp notify email from the database. Also notifies the appropriate model listeners.
	*
	* @param empNotifyEmail the emp notify email
	* @return the emp notify email that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpNotifyEmail deleteEmpNotifyEmail(
		vn.com.ecopharma.emp.model.EmpNotifyEmail empNotifyEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmpNotifyEmail(empNotifyEmail);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static vn.com.ecopharma.emp.model.EmpNotifyEmail fetchEmpNotifyEmail(
		long empNotifyEmailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEmpNotifyEmail(empNotifyEmailId);
	}

	/**
	* Returns the emp notify email with the primary key.
	*
	* @param empNotifyEmailId the primary key of the emp notify email
	* @return the emp notify email
	* @throws PortalException if a emp notify email with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpNotifyEmail getEmpNotifyEmail(
		long empNotifyEmailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpNotifyEmail(empNotifyEmailId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail> getEmpNotifyEmails(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpNotifyEmails(start, end);
	}

	/**
	* Returns the number of emp notify emails.
	*
	* @return the number of emp notify emails
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmpNotifyEmailsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpNotifyEmailsCount();
	}

	/**
	* Updates the emp notify email in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empNotifyEmail the emp notify email
	* @return the emp notify email that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpNotifyEmail updateEmpNotifyEmail(
		vn.com.ecopharma.emp.model.EmpNotifyEmail empNotifyEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEmpNotifyEmail(empNotifyEmail);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail> findByStatus(
		java.lang.String status) {
		return getService().findByStatus(status);
	}

	public static vn.com.ecopharma.emp.model.EmpNotifyEmail createPreperistedEntity()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createPreperistedEntity();
	}

	public static vn.com.ecopharma.emp.model.EmpNotifyEmail createEmpNotifyEmail(
		long empId, java.lang.String type, java.lang.String status) {
		return getService().createEmpNotifyEmail(empId, type, status);
	}

	public static vn.com.ecopharma.emp.model.EmpNotifyEmail removeEmpNotifyEmail(
		long id) {
		return getService().removeEmpNotifyEmail(id);
	}

	public static void clearService() {
		_service = null;
	}

	public static EmpNotifyEmailLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EmpNotifyEmailLocalService.class.getName());

			if (invokableLocalService instanceof EmpNotifyEmailLocalService) {
				_service = (EmpNotifyEmailLocalService)invokableLocalService;
			}
			else {
				_service = new EmpNotifyEmailLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EmpNotifyEmailLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EmpNotifyEmailLocalService service) {
	}

	private static EmpNotifyEmailLocalService _service;
}