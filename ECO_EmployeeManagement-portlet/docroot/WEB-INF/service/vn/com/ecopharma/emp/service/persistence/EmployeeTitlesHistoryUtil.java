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

import vn.com.ecopharma.emp.model.EmployeeTitlesHistory;

import java.util.List;

/**
 * The persistence utility for the employee titles history service. This utility wraps {@link EmployeeTitlesHistoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmployeeTitlesHistoryPersistence
 * @see EmployeeTitlesHistoryPersistenceImpl
 * @generated
 */
public class EmployeeTitlesHistoryUtil {
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
	public static void clearCache(EmployeeTitlesHistory employeeTitlesHistory) {
		getPersistence().clearCache(employeeTitlesHistory);
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
	public static List<EmployeeTitlesHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeTitlesHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeTitlesHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EmployeeTitlesHistory update(
		EmployeeTitlesHistory employeeTitlesHistory) throws SystemException {
		return getPersistence().update(employeeTitlesHistory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EmployeeTitlesHistory update(
		EmployeeTitlesHistory employeeTitlesHistory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(employeeTitlesHistory, serviceContext);
	}

	/**
	* Caches the employee titles history in the entity cache if it is enabled.
	*
	* @param employeeTitlesHistory the employee titles history
	*/
	public static void cacheResult(
		vn.com.ecopharma.emp.model.EmployeeTitlesHistory employeeTitlesHistory) {
		getPersistence().cacheResult(employeeTitlesHistory);
	}

	/**
	* Caches the employee titles histories in the entity cache if it is enabled.
	*
	* @param employeeTitlesHistories the employee titles histories
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.EmployeeTitlesHistory> employeeTitlesHistories) {
		getPersistence().cacheResult(employeeTitlesHistories);
	}

	/**
	* Creates a new employee titles history with the primary key. Does not add the employee titles history to the database.
	*
	* @param employeeTitlesHistoryId the primary key for the new employee titles history
	* @return the new employee titles history
	*/
	public static vn.com.ecopharma.emp.model.EmployeeTitlesHistory create(
		long employeeTitlesHistoryId) {
		return getPersistence().create(employeeTitlesHistoryId);
	}

	/**
	* Removes the employee titles history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employeeTitlesHistoryId the primary key of the employee titles history
	* @return the employee titles history that was removed
	* @throws vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException if a employee titles history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmployeeTitlesHistory remove(
		long employeeTitlesHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException {
		return getPersistence().remove(employeeTitlesHistoryId);
	}

	public static vn.com.ecopharma.emp.model.EmployeeTitlesHistory updateImpl(
		vn.com.ecopharma.emp.model.EmployeeTitlesHistory employeeTitlesHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(employeeTitlesHistory);
	}

	/**
	* Returns the employee titles history with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException} if it could not be found.
	*
	* @param employeeTitlesHistoryId the primary key of the employee titles history
	* @return the employee titles history
	* @throws vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException if a employee titles history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmployeeTitlesHistory findByPrimaryKey(
		long employeeTitlesHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException {
		return getPersistence().findByPrimaryKey(employeeTitlesHistoryId);
	}

	/**
	* Returns the employee titles history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param employeeTitlesHistoryId the primary key of the employee titles history
	* @return the employee titles history, or <code>null</code> if a employee titles history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmployeeTitlesHistory fetchByPrimaryKey(
		long employeeTitlesHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(employeeTitlesHistoryId);
	}

	/**
	* Returns all the employee titles histories.
	*
	* @return the employee titles histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmployeeTitlesHistory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the employee titles histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmployeeTitlesHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee titles histories
	* @param end the upper bound of the range of employee titles histories (not inclusive)
	* @return the range of employee titles histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmployeeTitlesHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the employee titles histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmployeeTitlesHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee titles histories
	* @param end the upper bound of the range of employee titles histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of employee titles histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmployeeTitlesHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the employee titles histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of employee titles histories.
	*
	* @return the number of employee titles histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmployeeTitlesHistoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmployeeTitlesHistoryPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					EmployeeTitlesHistoryPersistence.class.getName());

			ReferenceRegistry.registerReference(EmployeeTitlesHistoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EmployeeTitlesHistoryPersistence persistence) {
	}

	private static EmployeeTitlesHistoryPersistence _persistence;
}