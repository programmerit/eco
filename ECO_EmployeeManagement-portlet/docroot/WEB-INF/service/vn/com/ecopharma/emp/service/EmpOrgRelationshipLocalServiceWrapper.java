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
 * Provides a wrapper for {@link EmpOrgRelationshipLocalService}.
 *
 * @author tvt
 * @see EmpOrgRelationshipLocalService
 * @generated
 */
public class EmpOrgRelationshipLocalServiceWrapper
	implements EmpOrgRelationshipLocalService,
		ServiceWrapper<EmpOrgRelationshipLocalService> {
	public EmpOrgRelationshipLocalServiceWrapper(
		EmpOrgRelationshipLocalService empOrgRelationshipLocalService) {
		_empOrgRelationshipLocalService = empOrgRelationshipLocalService;
	}

	/**
	* Adds the emp org relationship to the database. Also notifies the appropriate model listeners.
	*
	* @param empOrgRelationship the emp org relationship
	* @return the emp org relationship that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpOrgRelationship addEmpOrgRelationship(
		vn.com.ecopharma.emp.model.EmpOrgRelationship empOrgRelationship)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empOrgRelationshipLocalService.addEmpOrgRelationship(empOrgRelationship);
	}

	/**
	* Creates a new emp org relationship with the primary key. Does not add the emp org relationship to the database.
	*
	* @param empOrgRelationshipId the primary key for the new emp org relationship
	* @return the new emp org relationship
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpOrgRelationship createEmpOrgRelationship(
		long empOrgRelationshipId) {
		return _empOrgRelationshipLocalService.createEmpOrgRelationship(empOrgRelationshipId);
	}

	/**
	* Deletes the emp org relationship with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empOrgRelationshipId the primary key of the emp org relationship
	* @return the emp org relationship that was removed
	* @throws PortalException if a emp org relationship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpOrgRelationship deleteEmpOrgRelationship(
		long empOrgRelationshipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empOrgRelationshipLocalService.deleteEmpOrgRelationship(empOrgRelationshipId);
	}

	/**
	* Deletes the emp org relationship from the database. Also notifies the appropriate model listeners.
	*
	* @param empOrgRelationship the emp org relationship
	* @return the emp org relationship that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpOrgRelationship deleteEmpOrgRelationship(
		vn.com.ecopharma.emp.model.EmpOrgRelationship empOrgRelationship)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empOrgRelationshipLocalService.deleteEmpOrgRelationship(empOrgRelationship);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empOrgRelationshipLocalService.dynamicQuery();
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
		return _empOrgRelationshipLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _empOrgRelationshipLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empOrgRelationshipLocalService.dynamicQuery(dynamicQuery,
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
		return _empOrgRelationshipLocalService.dynamicQueryCount(dynamicQuery);
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
		return _empOrgRelationshipLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpOrgRelationship fetchEmpOrgRelationship(
		long empOrgRelationshipId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empOrgRelationshipLocalService.fetchEmpOrgRelationship(empOrgRelationshipId);
	}

	/**
	* Returns the emp org relationship with the primary key.
	*
	* @param empOrgRelationshipId the primary key of the emp org relationship
	* @return the emp org relationship
	* @throws PortalException if a emp org relationship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpOrgRelationship getEmpOrgRelationship(
		long empOrgRelationshipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empOrgRelationshipLocalService.getEmpOrgRelationship(empOrgRelationshipId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empOrgRelationshipLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship> getEmpOrgRelationships(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empOrgRelationshipLocalService.getEmpOrgRelationships(start, end);
	}

	/**
	* Returns the number of emp org relationships.
	*
	* @return the number of emp org relationships
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmpOrgRelationshipsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empOrgRelationshipLocalService.getEmpOrgRelationshipsCount();
	}

	/**
	* Updates the emp org relationship in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empOrgRelationship the emp org relationship
	* @return the emp org relationship that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpOrgRelationship updateEmpOrgRelationship(
		vn.com.ecopharma.emp.model.EmpOrgRelationship empOrgRelationship)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empOrgRelationshipLocalService.updateEmpOrgRelationship(empOrgRelationship);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empOrgRelationshipLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empOrgRelationshipLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empOrgRelationshipLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship> findAll() {
		return _empOrgRelationshipLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship> findAll(
		int start, int end) {
		return _empOrgRelationshipLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _empOrgRelationshipLocalService.findAll(start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship> findByEmp(
		long empId) {
		return _empOrgRelationshipLocalService.findByEmp(empId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship> findByClassNameClassPK(
		java.lang.String className, long classPK) {
		return _empOrgRelationshipLocalService.findByClassNameClassPK(className,
			classPK);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpOrgRelationship fetchByClassNameClassPKHeadOfOrg(
		java.lang.String className, long classPK, boolean isHeadOfOrg) {
		return _empOrgRelationshipLocalService.fetchByClassNameClassPKHeadOfOrg(className,
			classPK, isHeadOfOrg);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpOrgRelationship fetchByClassNameClassPKDeputyOfOrg(
		java.lang.String className, long classPK, boolean isDeputyOfOrg) {
		return _empOrgRelationshipLocalService.fetchByClassNameClassPKDeputyOfOrg(className,
			classPK, isDeputyOfOrg);
	}

	@Override
	public boolean isHeadOfDepartment(long empId, long departmentId) {
		return _empOrgRelationshipLocalService.isHeadOfDepartment(empId,
			departmentId);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpOrgRelationship createPrepersistedEntity(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empOrgRelationshipLocalService.createPrepersistedEntity(serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpOrgRelationship addEmpOrgRelationship(
		long empId, java.lang.String className, long classPK,
		boolean isHeadOfOrg, boolean isDeputyOfOrg,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _empOrgRelationshipLocalService.addEmpOrgRelationship(empId,
			className, classPK, isHeadOfOrg, isDeputyOfOrg, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpOrgRelationship updateEmpOrgRelationship(
		long empOrgRelationshipId, long empId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _empOrgRelationshipLocalService.updateEmpOrgRelationship(empOrgRelationshipId,
			empId, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpOrgRelationship updateEmpOrgRelationship(
		vn.com.ecopharma.emp.model.EmpOrgRelationship empOrgRelationship,
		long empId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empOrgRelationshipLocalService.updateEmpOrgRelationship(empOrgRelationship,
			empId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpOrgRelationshipLocalService getWrappedEmpOrgRelationshipLocalService() {
		return _empOrgRelationshipLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpOrgRelationshipLocalService(
		EmpOrgRelationshipLocalService empOrgRelationshipLocalService) {
		_empOrgRelationshipLocalService = empOrgRelationshipLocalService;
	}

	@Override
	public EmpOrgRelationshipLocalService getWrappedService() {
		return _empOrgRelationshipLocalService;
	}

	@Override
	public void setWrappedService(
		EmpOrgRelationshipLocalService empOrgRelationshipLocalService) {
		_empOrgRelationshipLocalService = empOrgRelationshipLocalService;
	}

	private EmpOrgRelationshipLocalService _empOrgRelationshipLocalService;
}