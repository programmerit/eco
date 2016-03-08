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

import vn.com.ecopharma.emp.model.EmpAnnualLeave;

import java.util.List;

/**
 * The persistence utility for the emp annual leave service. This utility wraps {@link EmpAnnualLeavePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpAnnualLeavePersistence
 * @see EmpAnnualLeavePersistenceImpl
 * @generated
 */
public class EmpAnnualLeaveUtil {
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
	public static void clearCache(EmpAnnualLeave empAnnualLeave) {
		getPersistence().clearCache(empAnnualLeave);
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
	public static List<EmpAnnualLeave> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmpAnnualLeave> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmpAnnualLeave> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EmpAnnualLeave update(EmpAnnualLeave empAnnualLeave)
		throws SystemException {
		return getPersistence().update(empAnnualLeave);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EmpAnnualLeave update(EmpAnnualLeave empAnnualLeave,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(empAnnualLeave, serviceContext);
	}

	/**
	* Returns the emp annual leave where empId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException} if it could not be found.
	*
	* @param empId the emp ID
	* @return the matching emp annual leave
	* @throws vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException if a matching emp annual leave could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpAnnualLeave findByemp(
		long empId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException {
		return getPersistence().findByemp(empId);
	}

	/**
	* Returns the emp annual leave where empId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param empId the emp ID
	* @return the matching emp annual leave, or <code>null</code> if a matching emp annual leave could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpAnnualLeave fetchByemp(
		long empId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByemp(empId);
	}

	/**
	* Returns the emp annual leave where empId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param empId the emp ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching emp annual leave, or <code>null</code> if a matching emp annual leave could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpAnnualLeave fetchByemp(
		long empId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByemp(empId, retrieveFromCache);
	}

	/**
	* Removes the emp annual leave where empId = &#63; from the database.
	*
	* @param empId the emp ID
	* @return the emp annual leave that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpAnnualLeave removeByemp(
		long empId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException {
		return getPersistence().removeByemp(empId);
	}

	/**
	* Returns the number of emp annual leaves where empId = &#63;.
	*
	* @param empId the emp ID
	* @return the number of matching emp annual leaves
	* @throws SystemException if a system exception occurred
	*/
	public static int countByemp(long empId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByemp(empId);
	}

	/**
	* Caches the emp annual leave in the entity cache if it is enabled.
	*
	* @param empAnnualLeave the emp annual leave
	*/
	public static void cacheResult(
		vn.com.ecopharma.emp.model.EmpAnnualLeave empAnnualLeave) {
		getPersistence().cacheResult(empAnnualLeave);
	}

	/**
	* Caches the emp annual leaves in the entity cache if it is enabled.
	*
	* @param empAnnualLeaves the emp annual leaves
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.EmpAnnualLeave> empAnnualLeaves) {
		getPersistence().cacheResult(empAnnualLeaves);
	}

	/**
	* Creates a new emp annual leave with the primary key. Does not add the emp annual leave to the database.
	*
	* @param empAnnualLeaveId the primary key for the new emp annual leave
	* @return the new emp annual leave
	*/
	public static vn.com.ecopharma.emp.model.EmpAnnualLeave create(
		long empAnnualLeaveId) {
		return getPersistence().create(empAnnualLeaveId);
	}

	/**
	* Removes the emp annual leave with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empAnnualLeaveId the primary key of the emp annual leave
	* @return the emp annual leave that was removed
	* @throws vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException if a emp annual leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpAnnualLeave remove(
		long empAnnualLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException {
		return getPersistence().remove(empAnnualLeaveId);
	}

	public static vn.com.ecopharma.emp.model.EmpAnnualLeave updateImpl(
		vn.com.ecopharma.emp.model.EmpAnnualLeave empAnnualLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(empAnnualLeave);
	}

	/**
	* Returns the emp annual leave with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException} if it could not be found.
	*
	* @param empAnnualLeaveId the primary key of the emp annual leave
	* @return the emp annual leave
	* @throws vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException if a emp annual leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpAnnualLeave findByPrimaryKey(
		long empAnnualLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException {
		return getPersistence().findByPrimaryKey(empAnnualLeaveId);
	}

	/**
	* Returns the emp annual leave with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empAnnualLeaveId the primary key of the emp annual leave
	* @return the emp annual leave, or <code>null</code> if a emp annual leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpAnnualLeave fetchByPrimaryKey(
		long empAnnualLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(empAnnualLeaveId);
	}

	/**
	* Returns all the emp annual leaves.
	*
	* @return the emp annual leaves
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpAnnualLeave> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the emp annual leaves.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpAnnualLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp annual leaves
	* @param end the upper bound of the range of emp annual leaves (not inclusive)
	* @return the range of emp annual leaves
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpAnnualLeave> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the emp annual leaves.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpAnnualLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp annual leaves
	* @param end the upper bound of the range of emp annual leaves (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of emp annual leaves
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpAnnualLeave> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the emp annual leaves from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of emp annual leaves.
	*
	* @return the number of emp annual leaves
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmpAnnualLeavePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmpAnnualLeavePersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					EmpAnnualLeavePersistence.class.getName());

			ReferenceRegistry.registerReference(EmpAnnualLeaveUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EmpAnnualLeavePersistence persistence) {
	}

	private static EmpAnnualLeavePersistence _persistence;
}