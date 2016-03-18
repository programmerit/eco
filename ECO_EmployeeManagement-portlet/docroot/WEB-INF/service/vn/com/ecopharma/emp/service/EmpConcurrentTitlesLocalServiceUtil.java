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
 * Provides the local service utility for EmpConcurrentTitles. This utility wraps
 * {@link vn.com.ecopharma.emp.service.impl.EmpConcurrentTitlesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see EmpConcurrentTitlesLocalService
 * @see vn.com.ecopharma.emp.service.base.EmpConcurrentTitlesLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.impl.EmpConcurrentTitlesLocalServiceImpl
 * @generated
 */
public class EmpConcurrentTitlesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.emp.service.impl.EmpConcurrentTitlesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the emp concurrent titles to the database. Also notifies the appropriate model listeners.
	*
	* @param empConcurrentTitles the emp concurrent titles
	* @return the emp concurrent titles that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles addEmpConcurrentTitles(
		vn.com.ecopharma.emp.model.EmpConcurrentTitles empConcurrentTitles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEmpConcurrentTitles(empConcurrentTitles);
	}

	/**
	* Creates a new emp concurrent titles with the primary key. Does not add the emp concurrent titles to the database.
	*
	* @param empConcurrentTitlesId the primary key for the new emp concurrent titles
	* @return the new emp concurrent titles
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles createEmpConcurrentTitles(
		long empConcurrentTitlesId) {
		return getService().createEmpConcurrentTitles(empConcurrentTitlesId);
	}

	/**
	* Deletes the emp concurrent titles with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empConcurrentTitlesId the primary key of the emp concurrent titles
	* @return the emp concurrent titles that was removed
	* @throws PortalException if a emp concurrent titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles deleteEmpConcurrentTitles(
		long empConcurrentTitlesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmpConcurrentTitles(empConcurrentTitlesId);
	}

	/**
	* Deletes the emp concurrent titles from the database. Also notifies the appropriate model listeners.
	*
	* @param empConcurrentTitles the emp concurrent titles
	* @return the emp concurrent titles that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles deleteEmpConcurrentTitles(
		vn.com.ecopharma.emp.model.EmpConcurrentTitles empConcurrentTitles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmpConcurrentTitles(empConcurrentTitles);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles fetchEmpConcurrentTitles(
		long empConcurrentTitlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEmpConcurrentTitles(empConcurrentTitlesId);
	}

	/**
	* Returns the emp concurrent titles with the primary key.
	*
	* @param empConcurrentTitlesId the primary key of the emp concurrent titles
	* @return the emp concurrent titles
	* @throws PortalException if a emp concurrent titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles getEmpConcurrentTitles(
		long empConcurrentTitlesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpConcurrentTitles(empConcurrentTitlesId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the emp concurrent titleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp concurrent titleses
	* @param end the upper bound of the range of emp concurrent titleses (not inclusive)
	* @return the range of emp concurrent titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpConcurrentTitles> getEmpConcurrentTitleses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpConcurrentTitleses(start, end);
	}

	/**
	* Returns the number of emp concurrent titleses.
	*
	* @return the number of emp concurrent titleses
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmpConcurrentTitlesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpConcurrentTitlesesCount();
	}

	/**
	* Updates the emp concurrent titles in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empConcurrentTitles the emp concurrent titles
	* @return the emp concurrent titles that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles updateEmpConcurrentTitles(
		vn.com.ecopharma.emp.model.EmpConcurrentTitles empConcurrentTitles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEmpConcurrentTitles(empConcurrentTitles);
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

	public static java.util.List<vn.com.ecopharma.emp.model.EmpConcurrentTitles> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EmpConcurrentTitles> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EmpConcurrentTitles> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles createPrePersistedEntity(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().createPrePersistedEntity(serviceContext);
	}

	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles addConcurrentTitles(
		long empId, long titlesId, long departmentId, long unitGroupId,
		long unitId, com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addConcurrentTitles(empId, titlesId, departmentId,
			unitGroupId, unitId, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles fetchByEmpAndTitles(
		long empId, long titlesId) {
		return getService().fetchByEmpAndTitles(empId, titlesId);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EmpConcurrentTitles> findByEmp(
		long empId) {
		return getService().findByEmp(empId);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EmpConcurrentTitles> findByTitles(
		long titlesId) {
		return getService().findByTitles(titlesId);
	}

	public static void clearService() {
		_service = null;
	}

	public static EmpConcurrentTitlesLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EmpConcurrentTitlesLocalService.class.getName());

			if (invokableLocalService instanceof EmpConcurrentTitlesLocalService) {
				_service = (EmpConcurrentTitlesLocalService)invokableLocalService;
			}
			else {
				_service = new EmpConcurrentTitlesLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EmpConcurrentTitlesLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EmpConcurrentTitlesLocalService service) {
	}

	private static EmpConcurrentTitlesLocalService _service;
}