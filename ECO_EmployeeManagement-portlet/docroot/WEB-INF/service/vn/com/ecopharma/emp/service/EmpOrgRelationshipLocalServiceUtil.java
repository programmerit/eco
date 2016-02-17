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
 * Provides the local service utility for EmpOrgRelationship. This utility wraps
 * {@link vn.com.ecopharma.emp.service.impl.EmpOrgRelationshipLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see EmpOrgRelationshipLocalService
 * @see vn.com.ecopharma.emp.service.base.EmpOrgRelationshipLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.impl.EmpOrgRelationshipLocalServiceImpl
 * @generated
 */
public class EmpOrgRelationshipLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.emp.service.impl.EmpOrgRelationshipLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the emp org relationship to the database. Also notifies the appropriate model listeners.
	*
	* @param empOrgRelationship the emp org relationship
	* @return the emp org relationship that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpOrgRelationship addEmpOrgRelationship(
		vn.com.ecopharma.emp.model.EmpOrgRelationship empOrgRelationship)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEmpOrgRelationship(empOrgRelationship);
	}

	/**
	* Creates a new emp org relationship with the primary key. Does not add the emp org relationship to the database.
	*
	* @param empOrgRelationshipId the primary key for the new emp org relationship
	* @return the new emp org relationship
	*/
	public static vn.com.ecopharma.emp.model.EmpOrgRelationship createEmpOrgRelationship(
		long empOrgRelationshipId) {
		return getService().createEmpOrgRelationship(empOrgRelationshipId);
	}

	/**
	* Deletes the emp org relationship with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empOrgRelationshipId the primary key of the emp org relationship
	* @return the emp org relationship that was removed
	* @throws PortalException if a emp org relationship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpOrgRelationship deleteEmpOrgRelationship(
		long empOrgRelationshipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmpOrgRelationship(empOrgRelationshipId);
	}

	/**
	* Deletes the emp org relationship from the database. Also notifies the appropriate model listeners.
	*
	* @param empOrgRelationship the emp org relationship
	* @return the emp org relationship that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpOrgRelationship deleteEmpOrgRelationship(
		vn.com.ecopharma.emp.model.EmpOrgRelationship empOrgRelationship)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmpOrgRelationship(empOrgRelationship);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpOrgRelationshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpOrgRelationshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.emp.model.EmpOrgRelationship fetchEmpOrgRelationship(
		long empOrgRelationshipId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEmpOrgRelationship(empOrgRelationshipId);
	}

	/**
	* Returns the emp org relationship with the primary key.
	*
	* @param empOrgRelationshipId the primary key of the emp org relationship
	* @return the emp org relationship
	* @throws PortalException if a emp org relationship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpOrgRelationship getEmpOrgRelationship(
		long empOrgRelationshipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpOrgRelationship(empOrgRelationshipId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the emp org relationships.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpOrgRelationshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp org relationships
	* @param end the upper bound of the range of emp org relationships (not inclusive)
	* @return the range of emp org relationships
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship> getEmpOrgRelationships(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpOrgRelationships(start, end);
	}

	/**
	* Returns the number of emp org relationships.
	*
	* @return the number of emp org relationships
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmpOrgRelationshipsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpOrgRelationshipsCount();
	}

	/**
	* Updates the emp org relationship in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empOrgRelationship the emp org relationship
	* @return the emp org relationship that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpOrgRelationship updateEmpOrgRelationship(
		vn.com.ecopharma.emp.model.EmpOrgRelationship empOrgRelationship)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEmpOrgRelationship(empOrgRelationship);
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

	public static java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship> findByEmp(
		long empId) {
		return getService().findByEmp(empId);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship> findByClassNameClassPK(
		java.lang.String className, long classPK) {
		return getService().findByClassNameClassPK(className, classPK);
	}

	public static vn.com.ecopharma.emp.model.EmpOrgRelationship fetchByClassNameClassPKHeadOfOrg(
		java.lang.String className, long classPK, boolean isHeadOfOrg) {
		return getService()
				   .fetchByClassNameClassPKHeadOfOrg(className, classPK,
			isHeadOfOrg);
	}

	public static vn.com.ecopharma.emp.model.EmpOrgRelationship fetchByEmpClassNameClassPKHeadOfOrg(
		long empId, java.lang.String className, long classPK,
		boolean isHeadOfOrg) {
		return getService()
				   .fetchByEmpClassNameClassPKHeadOfOrg(empId, className,
			classPK, isHeadOfOrg);
	}

	public static vn.com.ecopharma.emp.model.EmpOrgRelationship fetchByClassNameClassPKDeputyOfOrg(
		java.lang.String className, long classPK, boolean isDeputyOfOrg) {
		return getService()
				   .fetchByClassNameClassPKDeputyOfOrg(className, classPK,
			isDeputyOfOrg);
	}

	public static boolean isHeadOfDepartment(long empId, long departmentId) {
		return getService().isHeadOfDepartment(empId, departmentId);
	}

	public static vn.com.ecopharma.emp.model.EmpOrgRelationship createPrepersistedEntity(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createPrepersistedEntity(serviceContext);
	}

	public static vn.com.ecopharma.emp.model.EmpOrgRelationship addEmpOrgRelationship(
		long empId, java.lang.String className, long classPK,
		boolean isHeadOfOrg, boolean isDeputyOfOrg,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addEmpOrgRelationship(empId, className, classPK,
			isHeadOfOrg, isDeputyOfOrg, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.EmpOrgRelationship updateEmpOrgRelationship(
		long empOrgRelationshipId, long empId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateEmpOrgRelationship(empOrgRelationshipId, empId,
			serviceContext);
	}

	public static vn.com.ecopharma.emp.model.EmpOrgRelationship updateEmpOrgRelationship(
		vn.com.ecopharma.emp.model.EmpOrgRelationship empOrgRelationship,
		long empId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateEmpOrgRelationship(empOrgRelationship, empId,
			serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static EmpOrgRelationshipLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EmpOrgRelationshipLocalService.class.getName());

			if (invokableLocalService instanceof EmpOrgRelationshipLocalService) {
				_service = (EmpOrgRelationshipLocalService)invokableLocalService;
			}
			else {
				_service = new EmpOrgRelationshipLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EmpOrgRelationshipLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EmpOrgRelationshipLocalService service) {
	}

	private static EmpOrgRelationshipLocalService _service;
}