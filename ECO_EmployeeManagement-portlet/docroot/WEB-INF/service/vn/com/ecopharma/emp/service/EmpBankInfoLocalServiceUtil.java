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
 * Provides the local service utility for EmpBankInfo. This utility wraps
 * {@link vn.com.ecopharma.emp.service.impl.EmpBankInfoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see EmpBankInfoLocalService
 * @see vn.com.ecopharma.emp.service.base.EmpBankInfoLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.impl.EmpBankInfoLocalServiceImpl
 * @generated
 */
public class EmpBankInfoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.emp.service.impl.EmpBankInfoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the emp bank info to the database. Also notifies the appropriate model listeners.
	*
	* @param empBankInfo the emp bank info
	* @return the emp bank info that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpBankInfo addEmpBankInfo(
		vn.com.ecopharma.emp.model.EmpBankInfo empBankInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEmpBankInfo(empBankInfo);
	}

	/**
	* Creates a new emp bank info with the primary key. Does not add the emp bank info to the database.
	*
	* @param empBankInfoId the primary key for the new emp bank info
	* @return the new emp bank info
	*/
	public static vn.com.ecopharma.emp.model.EmpBankInfo createEmpBankInfo(
		long empBankInfoId) {
		return getService().createEmpBankInfo(empBankInfoId);
	}

	/**
	* Deletes the emp bank info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empBankInfoId the primary key of the emp bank info
	* @return the emp bank info that was removed
	* @throws PortalException if a emp bank info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpBankInfo deleteEmpBankInfo(
		long empBankInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmpBankInfo(empBankInfoId);
	}

	/**
	* Deletes the emp bank info from the database. Also notifies the appropriate model listeners.
	*
	* @param empBankInfo the emp bank info
	* @return the emp bank info that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpBankInfo deleteEmpBankInfo(
		vn.com.ecopharma.emp.model.EmpBankInfo empBankInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmpBankInfo(empBankInfo);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpBankInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpBankInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.emp.model.EmpBankInfo fetchEmpBankInfo(
		long empBankInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEmpBankInfo(empBankInfoId);
	}

	/**
	* Returns the emp bank info with the primary key.
	*
	* @param empBankInfoId the primary key of the emp bank info
	* @return the emp bank info
	* @throws PortalException if a emp bank info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpBankInfo getEmpBankInfo(
		long empBankInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpBankInfo(empBankInfoId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the emp bank infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpBankInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp bank infos
	* @param end the upper bound of the range of emp bank infos (not inclusive)
	* @return the range of emp bank infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpBankInfo> getEmpBankInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpBankInfos(start, end);
	}

	/**
	* Returns the number of emp bank infos.
	*
	* @return the number of emp bank infos
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmpBankInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpBankInfosCount();
	}

	/**
	* Updates the emp bank info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empBankInfo the emp bank info
	* @return the emp bank info that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpBankInfo updateEmpBankInfo(
		vn.com.ecopharma.emp.model.EmpBankInfo empBankInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEmpBankInfo(empBankInfo);
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

	public static java.util.List<vn.com.ecopharma.emp.model.EmpBankInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EmpBankInfo> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EmpBankInfo> findAll() {
		return getService().findAll();
	}

	public static vn.com.ecopharma.emp.model.EmpBankInfo createPrePersistedEntity(
		long empId, java.lang.String bankAccountNo, java.lang.String bankName,
		java.lang.String branchName) {
		return getService()
				   .createPrePersistedEntity(empId, bankAccountNo, bankName,
			branchName);
	}

	public static vn.com.ecopharma.emp.model.EmpBankInfo addEmpBankInfo(
		vn.com.ecopharma.emp.model.EmpBankInfo empBankInfo,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().addEmpBankInfo(empBankInfo, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static EmpBankInfoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EmpBankInfoLocalService.class.getName());

			if (invokableLocalService instanceof EmpBankInfoLocalService) {
				_service = (EmpBankInfoLocalService)invokableLocalService;
			}
			else {
				_service = new EmpBankInfoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EmpBankInfoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EmpBankInfoLocalService service) {
	}

	private static EmpBankInfoLocalService _service;
}