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

import vn.com.ecopharma.emp.model.EmpActionHistory;

import java.util.List;

/**
 * The persistence utility for the emp action history service. This utility wraps {@link EmpActionHistoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpActionHistoryPersistence
 * @see EmpActionHistoryPersistenceImpl
 * @generated
 */
public class EmpActionHistoryUtil {
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
	public static void clearCache(EmpActionHistory empActionHistory) {
		getPersistence().clearCache(empActionHistory);
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
	public static List<EmpActionHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmpActionHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmpActionHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EmpActionHistory update(EmpActionHistory empActionHistory)
		throws SystemException {
		return getPersistence().update(empActionHistory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EmpActionHistory update(EmpActionHistory empActionHistory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(empActionHistory, serviceContext);
	}

	/**
	* Caches the emp action history in the entity cache if it is enabled.
	*
	* @param empActionHistory the emp action history
	*/
	public static void cacheResult(
		vn.com.ecopharma.emp.model.EmpActionHistory empActionHistory) {
		getPersistence().cacheResult(empActionHistory);
	}

	/**
	* Caches the emp action histories in the entity cache if it is enabled.
	*
	* @param empActionHistories the emp action histories
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.EmpActionHistory> empActionHistories) {
		getPersistence().cacheResult(empActionHistories);
	}

	/**
	* Creates a new emp action history with the primary key. Does not add the emp action history to the database.
	*
	* @param empActionHistoryId the primary key for the new emp action history
	* @return the new emp action history
	*/
	public static vn.com.ecopharma.emp.model.EmpActionHistory create(
		long empActionHistoryId) {
		return getPersistence().create(empActionHistoryId);
	}

	/**
	* Removes the emp action history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empActionHistoryId the primary key of the emp action history
	* @return the emp action history that was removed
	* @throws vn.com.ecopharma.emp.NoSuchEmpActionHistoryException if a emp action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpActionHistory remove(
		long empActionHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpActionHistoryException {
		return getPersistence().remove(empActionHistoryId);
	}

	public static vn.com.ecopharma.emp.model.EmpActionHistory updateImpl(
		vn.com.ecopharma.emp.model.EmpActionHistory empActionHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(empActionHistory);
	}

	/**
	* Returns the emp action history with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpActionHistoryException} if it could not be found.
	*
	* @param empActionHistoryId the primary key of the emp action history
	* @return the emp action history
	* @throws vn.com.ecopharma.emp.NoSuchEmpActionHistoryException if a emp action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpActionHistory findByPrimaryKey(
		long empActionHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpActionHistoryException {
		return getPersistence().findByPrimaryKey(empActionHistoryId);
	}

	/**
	* Returns the emp action history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empActionHistoryId the primary key of the emp action history
	* @return the emp action history, or <code>null</code> if a emp action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpActionHistory fetchByPrimaryKey(
		long empActionHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(empActionHistoryId);
	}

	/**
	* Returns all the emp action histories.
	*
	* @return the emp action histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpActionHistory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the emp action histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp action histories
	* @param end the upper bound of the range of emp action histories (not inclusive)
	* @return the range of emp action histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpActionHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the emp action histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp action histories
	* @param end the upper bound of the range of emp action histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of emp action histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpActionHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the emp action histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of emp action histories.
	*
	* @return the number of emp action histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmpActionHistoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmpActionHistoryPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					EmpActionHistoryPersistence.class.getName());

			ReferenceRegistry.registerReference(EmpActionHistoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EmpActionHistoryPersistence persistence) {
	}

	private static EmpActionHistoryPersistence _persistence;
}