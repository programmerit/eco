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
 * Provides a wrapper for {@link EmpLaborContractLocalService}.
 *
 * @author tvt
 * @see EmpLaborContractLocalService
 * @generated
 */
public class EmpLaborContractLocalServiceWrapper
	implements EmpLaborContractLocalService,
		ServiceWrapper<EmpLaborContractLocalService> {
	public EmpLaborContractLocalServiceWrapper(
		EmpLaborContractLocalService empLaborContractLocalService) {
		_empLaborContractLocalService = empLaborContractLocalService;
	}

	/**
	* Adds the emp labor contract to the database. Also notifies the appropriate model listeners.
	*
	* @param empLaborContract the emp labor contract
	* @return the emp labor contract that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpLaborContract addEmpLaborContract(
		vn.com.ecopharma.emp.model.EmpLaborContract empLaborContract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLaborContractLocalService.addEmpLaborContract(empLaborContract);
	}

	/**
	* Creates a new emp labor contract with the primary key. Does not add the emp labor contract to the database.
	*
	* @param empLaborContractId the primary key for the new emp labor contract
	* @return the new emp labor contract
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpLaborContract createEmpLaborContract(
		long empLaborContractId) {
		return _empLaborContractLocalService.createEmpLaborContract(empLaborContractId);
	}

	/**
	* Deletes the emp labor contract with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empLaborContractId the primary key of the emp labor contract
	* @return the emp labor contract that was removed
	* @throws PortalException if a emp labor contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpLaborContract deleteEmpLaborContract(
		long empLaborContractId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empLaborContractLocalService.deleteEmpLaborContract(empLaborContractId);
	}

	/**
	* Deletes the emp labor contract from the database. Also notifies the appropriate model listeners.
	*
	* @param empLaborContract the emp labor contract
	* @return the emp labor contract that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpLaborContract deleteEmpLaborContract(
		vn.com.ecopharma.emp.model.EmpLaborContract empLaborContract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLaborContractLocalService.deleteEmpLaborContract(empLaborContract);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empLaborContractLocalService.dynamicQuery();
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
		return _empLaborContractLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpLaborContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empLaborContractLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpLaborContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empLaborContractLocalService.dynamicQuery(dynamicQuery, start,
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
		return _empLaborContractLocalService.dynamicQueryCount(dynamicQuery);
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
		return _empLaborContractLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpLaborContract fetchEmpLaborContract(
		long empLaborContractId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLaborContractLocalService.fetchEmpLaborContract(empLaborContractId);
	}

	/**
	* Returns the emp labor contract with the primary key.
	*
	* @param empLaborContractId the primary key of the emp labor contract
	* @return the emp labor contract
	* @throws PortalException if a emp labor contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpLaborContract getEmpLaborContract(
		long empLaborContractId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empLaborContractLocalService.getEmpLaborContract(empLaborContractId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empLaborContractLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the emp labor contracts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpLaborContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp labor contracts
	* @param end the upper bound of the range of emp labor contracts (not inclusive)
	* @return the range of emp labor contracts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpLaborContract> getEmpLaborContracts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLaborContractLocalService.getEmpLaborContracts(start, end);
	}

	/**
	* Returns the number of emp labor contracts.
	*
	* @return the number of emp labor contracts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmpLaborContractsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLaborContractLocalService.getEmpLaborContractsCount();
	}

	/**
	* Updates the emp labor contract in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empLaborContract the emp labor contract
	* @return the emp labor contract that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpLaborContract updateEmpLaborContract(
		vn.com.ecopharma.emp.model.EmpLaborContract empLaborContract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLaborContractLocalService.updateEmpLaborContract(empLaborContract);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empLaborContractLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empLaborContractLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empLaborContractLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpLaborContract> findByEmp(
		long empId) {
		return _empLaborContractLocalService.findByEmp(empId);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpLaborContract createPrePersistedEntity(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _empLaborContractLocalService.createPrePersistedEntity(serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpLaborContract addEmpLaborContract(
		vn.com.ecopharma.emp.model.EmpLaborContract empLaborContract,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _empLaborContractLocalService.addEmpLaborContract(empLaborContract,
			serviceContext);
	}

	/**
	* transfer info from emp
	*/
	@Override
	public void transferContractFromEmps(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empLaborContractLocalService.transferContractFromEmps(serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpLaborContractLocalService getWrappedEmpLaborContractLocalService() {
		return _empLaborContractLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpLaborContractLocalService(
		EmpLaborContractLocalService empLaborContractLocalService) {
		_empLaborContractLocalService = empLaborContractLocalService;
	}

	@Override
	public EmpLaborContractLocalService getWrappedService() {
		return _empLaborContractLocalService;
	}

	@Override
	public void setWrappedService(
		EmpLaborContractLocalService empLaborContractLocalService) {
		_empLaborContractLocalService = empLaborContractLocalService;
	}

	private EmpLaborContractLocalService _empLaborContractLocalService;
}