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

package vn.com.ecopharma.emp.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import vn.com.ecopharma.emp.model.EmpLaborContract;

import java.util.List;

/**
 * The persistence utility for the emp labor contract service. This utility wraps {@link EmpLaborContractPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpLaborContractPersistence
 * @see EmpLaborContractPersistenceImpl
 * @generated
 */
public class EmpLaborContractUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(EmpLaborContract empLaborContract) {
		getPersistence().clearCache(empLaborContract);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmpLaborContract> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmpLaborContract> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmpLaborContract> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EmpLaborContract update(EmpLaborContract empLaborContract)
		throws SystemException {
		return getPersistence().update(empLaborContract);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EmpLaborContract update(EmpLaborContract empLaborContract,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(empLaborContract, serviceContext);
	}

	/**
	* Returns all the emp labor contracts where empId = &#63;.
	*
	* @param empId the emp ID
	* @return the matching emp labor contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpLaborContract> findByEmp(
		long empId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmp(empId);
	}

	/**
	* Returns a range of all the emp labor contracts where empId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpLaborContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empId the emp ID
	* @param start the lower bound of the range of emp labor contracts
	* @param end the upper bound of the range of emp labor contracts (not inclusive)
	* @return the range of matching emp labor contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpLaborContract> findByEmp(
		long empId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmp(empId, start, end);
	}

	/**
	* Returns an ordered range of all the emp labor contracts where empId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpLaborContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empId the emp ID
	* @param start the lower bound of the range of emp labor contracts
	* @param end the upper bound of the range of emp labor contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching emp labor contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpLaborContract> findByEmp(
		long empId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmp(empId, start, end, orderByComparator);
	}

	/**
	* Returns the first emp labor contract in the ordered set where empId = &#63;.
	*
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp labor contract
	* @throws vn.com.ecopharma.emp.NoSuchEmpLaborContractException if a matching emp labor contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpLaborContract findByEmp_First(
		long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpLaborContractException {
		return getPersistence().findByEmp_First(empId, orderByComparator);
	}

	/**
	* Returns the first emp labor contract in the ordered set where empId = &#63;.
	*
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp labor contract, or <code>null</code> if a matching emp labor contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpLaborContract fetchByEmp_First(
		long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmp_First(empId, orderByComparator);
	}

	/**
	* Returns the last emp labor contract in the ordered set where empId = &#63;.
	*
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp labor contract
	* @throws vn.com.ecopharma.emp.NoSuchEmpLaborContractException if a matching emp labor contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpLaborContract findByEmp_Last(
		long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpLaborContractException {
		return getPersistence().findByEmp_Last(empId, orderByComparator);
	}

	/**
	* Returns the last emp labor contract in the ordered set where empId = &#63;.
	*
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp labor contract, or <code>null</code> if a matching emp labor contract could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpLaborContract fetchByEmp_Last(
		long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmp_Last(empId, orderByComparator);
	}

	/**
	* Returns the emp labor contracts before and after the current emp labor contract in the ordered set where empId = &#63;.
	*
	* @param empLaborContractId the primary key of the current emp labor contract
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next emp labor contract
	* @throws vn.com.ecopharma.emp.NoSuchEmpLaborContractException if a emp labor contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpLaborContract[] findByEmp_PrevAndNext(
		long empLaborContractId, long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpLaborContractException {
		return getPersistence()
				   .findByEmp_PrevAndNext(empLaborContractId, empId,
			orderByComparator);
	}

	/**
	* Removes all the emp labor contracts where empId = &#63; from the database.
	*
	* @param empId the emp ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEmp(long empId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEmp(empId);
	}

	/**
	* Returns the number of emp labor contracts where empId = &#63;.
	*
	* @param empId the emp ID
	* @return the number of matching emp labor contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmp(long empId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmp(empId);
	}

	/**
	* Caches the emp labor contract in the entity cache if it is enabled.
	*
	* @param empLaborContract the emp labor contract
	*/
	public static void cacheResult(
		vn.com.ecopharma.emp.model.EmpLaborContract empLaborContract) {
		getPersistence().cacheResult(empLaborContract);
	}

	/**
	* Caches the emp labor contracts in the entity cache if it is enabled.
	*
	* @param empLaborContracts the emp labor contracts
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.EmpLaborContract> empLaborContracts) {
		getPersistence().cacheResult(empLaborContracts);
	}

	/**
	* Creates a new emp labor contract with the primary key. Does not add the emp labor contract to the database.
	*
	* @param empLaborContractId the primary key for the new emp labor contract
	* @return the new emp labor contract
	*/
	public static vn.com.ecopharma.emp.model.EmpLaborContract create(
		long empLaborContractId) {
		return getPersistence().create(empLaborContractId);
	}

	/**
	* Removes the emp labor contract with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empLaborContractId the primary key of the emp labor contract
	* @return the emp labor contract that was removed
	* @throws vn.com.ecopharma.emp.NoSuchEmpLaborContractException if a emp labor contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpLaborContract remove(
		long empLaborContractId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpLaborContractException {
		return getPersistence().remove(empLaborContractId);
	}

	public static vn.com.ecopharma.emp.model.EmpLaborContract updateImpl(
		vn.com.ecopharma.emp.model.EmpLaborContract empLaborContract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(empLaborContract);
	}

	/**
	* Returns the emp labor contract with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpLaborContractException} if it could not be found.
	*
	* @param empLaborContractId the primary key of the emp labor contract
	* @return the emp labor contract
	* @throws vn.com.ecopharma.emp.NoSuchEmpLaborContractException if a emp labor contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpLaborContract findByPrimaryKey(
		long empLaborContractId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpLaborContractException {
		return getPersistence().findByPrimaryKey(empLaborContractId);
	}

	/**
	* Returns the emp labor contract with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empLaborContractId the primary key of the emp labor contract
	* @return the emp labor contract, or <code>null</code> if a emp labor contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpLaborContract fetchByPrimaryKey(
		long empLaborContractId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(empLaborContractId);
	}

	/**
	* Returns all the emp labor contracts.
	*
	* @return the emp labor contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpLaborContract> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<vn.com.ecopharma.emp.model.EmpLaborContract> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the emp labor contracts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpLaborContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp labor contracts
	* @param end the upper bound of the range of emp labor contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of emp labor contracts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpLaborContract> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the emp labor contracts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of emp labor contracts.
	*
	* @return the number of emp labor contracts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmpLaborContractPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmpLaborContractPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					EmpLaborContractPersistence.class.getName());

			ReferenceRegistry.registerReference(EmpLaborContractUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EmpLaborContractPersistence persistence) {
	}

	private static EmpLaborContractPersistence _persistence;
}