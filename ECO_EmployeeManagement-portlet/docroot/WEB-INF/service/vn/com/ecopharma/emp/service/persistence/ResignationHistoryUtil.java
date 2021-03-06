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

import vn.com.ecopharma.emp.model.ResignationHistory;

import java.util.List;

/**
 * The persistence utility for the resignation history service. This utility wraps {@link ResignationHistoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see ResignationHistoryPersistence
 * @see ResignationHistoryPersistenceImpl
 * @generated
 */
public class ResignationHistoryUtil {
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
	public static void clearCache(ResignationHistory resignationHistory) {
		getPersistence().clearCache(resignationHistory);
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
	public static List<ResignationHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ResignationHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ResignationHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ResignationHistory update(
		ResignationHistory resignationHistory) throws SystemException {
		return getPersistence().update(resignationHistory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ResignationHistory update(
		ResignationHistory resignationHistory, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(resignationHistory, serviceContext);
	}

	/**
	* Returns all the resignation histories where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching resignation histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.ResignationHistory> findByEmployee(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmployee(employeeId);
	}

	/**
	* Returns a range of all the resignation histories where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResignationHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of resignation histories
	* @param end the upper bound of the range of resignation histories (not inclusive)
	* @return the range of matching resignation histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.ResignationHistory> findByEmployee(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmployee(employeeId, start, end);
	}

	/**
	* Returns an ordered range of all the resignation histories where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResignationHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of resignation histories
	* @param end the upper bound of the range of resignation histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching resignation histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.ResignationHistory> findByEmployee(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmployee(employeeId, start, end, orderByComparator);
	}

	/**
	* Returns the first resignation history in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching resignation history
	* @throws vn.com.ecopharma.emp.NoSuchResignationHistoryException if a matching resignation history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.ResignationHistory findByEmployee_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchResignationHistoryException {
		return getPersistence()
				   .findByEmployee_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first resignation history in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching resignation history, or <code>null</code> if a matching resignation history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.ResignationHistory fetchByEmployee_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmployee_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last resignation history in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching resignation history
	* @throws vn.com.ecopharma.emp.NoSuchResignationHistoryException if a matching resignation history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.ResignationHistory findByEmployee_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchResignationHistoryException {
		return getPersistence()
				   .findByEmployee_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last resignation history in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching resignation history, or <code>null</code> if a matching resignation history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.ResignationHistory fetchByEmployee_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmployee_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the resignation histories before and after the current resignation history in the ordered set where employeeId = &#63;.
	*
	* @param resignationHistoryId the primary key of the current resignation history
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next resignation history
	* @throws vn.com.ecopharma.emp.NoSuchResignationHistoryException if a resignation history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.ResignationHistory[] findByEmployee_PrevAndNext(
		long resignationHistoryId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchResignationHistoryException {
		return getPersistence()
				   .findByEmployee_PrevAndNext(resignationHistoryId,
			employeeId, orderByComparator);
	}

	/**
	* Removes all the resignation histories where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEmployee(employeeId);
	}

	/**
	* Returns the number of resignation histories where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching resignation histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmployee(employeeId);
	}

	/**
	* Caches the resignation history in the entity cache if it is enabled.
	*
	* @param resignationHistory the resignation history
	*/
	public static void cacheResult(
		vn.com.ecopharma.emp.model.ResignationHistory resignationHistory) {
		getPersistence().cacheResult(resignationHistory);
	}

	/**
	* Caches the resignation histories in the entity cache if it is enabled.
	*
	* @param resignationHistories the resignation histories
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.ResignationHistory> resignationHistories) {
		getPersistence().cacheResult(resignationHistories);
	}

	/**
	* Creates a new resignation history with the primary key. Does not add the resignation history to the database.
	*
	* @param resignationHistoryId the primary key for the new resignation history
	* @return the new resignation history
	*/
	public static vn.com.ecopharma.emp.model.ResignationHistory create(
		long resignationHistoryId) {
		return getPersistence().create(resignationHistoryId);
	}

	/**
	* Removes the resignation history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param resignationHistoryId the primary key of the resignation history
	* @return the resignation history that was removed
	* @throws vn.com.ecopharma.emp.NoSuchResignationHistoryException if a resignation history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.ResignationHistory remove(
		long resignationHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchResignationHistoryException {
		return getPersistence().remove(resignationHistoryId);
	}

	public static vn.com.ecopharma.emp.model.ResignationHistory updateImpl(
		vn.com.ecopharma.emp.model.ResignationHistory resignationHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(resignationHistory);
	}

	/**
	* Returns the resignation history with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchResignationHistoryException} if it could not be found.
	*
	* @param resignationHistoryId the primary key of the resignation history
	* @return the resignation history
	* @throws vn.com.ecopharma.emp.NoSuchResignationHistoryException if a resignation history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.ResignationHistory findByPrimaryKey(
		long resignationHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchResignationHistoryException {
		return getPersistence().findByPrimaryKey(resignationHistoryId);
	}

	/**
	* Returns the resignation history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param resignationHistoryId the primary key of the resignation history
	* @return the resignation history, or <code>null</code> if a resignation history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.ResignationHistory fetchByPrimaryKey(
		long resignationHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(resignationHistoryId);
	}

	/**
	* Returns all the resignation histories.
	*
	* @return the resignation histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.ResignationHistory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the resignation histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResignationHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of resignation histories
	* @param end the upper bound of the range of resignation histories (not inclusive)
	* @return the range of resignation histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.ResignationHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the resignation histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResignationHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of resignation histories
	* @param end the upper bound of the range of resignation histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of resignation histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.ResignationHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the resignation histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of resignation histories.
	*
	* @return the number of resignation histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ResignationHistoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ResignationHistoryPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					ResignationHistoryPersistence.class.getName());

			ReferenceRegistry.registerReference(ResignationHistoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ResignationHistoryPersistence persistence) {
	}

	private static ResignationHistoryPersistence _persistence;
}