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

import vn.com.ecopharma.emp.model.EmpBankInfo;

import java.util.List;

/**
 * The persistence utility for the emp bank info service. This utility wraps {@link EmpBankInfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpBankInfoPersistence
 * @see EmpBankInfoPersistenceImpl
 * @generated
 */
public class EmpBankInfoUtil {
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
	public static void clearCache(EmpBankInfo empBankInfo) {
		getPersistence().clearCache(empBankInfo);
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
	public static List<EmpBankInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmpBankInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmpBankInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EmpBankInfo update(EmpBankInfo empBankInfo)
		throws SystemException {
		return getPersistence().update(empBankInfo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EmpBankInfo update(EmpBankInfo empBankInfo,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(empBankInfo, serviceContext);
	}

	/**
	* Caches the emp bank info in the entity cache if it is enabled.
	*
	* @param empBankInfo the emp bank info
	*/
	public static void cacheResult(
		vn.com.ecopharma.emp.model.EmpBankInfo empBankInfo) {
		getPersistence().cacheResult(empBankInfo);
	}

	/**
	* Caches the emp bank infos in the entity cache if it is enabled.
	*
	* @param empBankInfos the emp bank infos
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.EmpBankInfo> empBankInfos) {
		getPersistence().cacheResult(empBankInfos);
	}

	/**
	* Creates a new emp bank info with the primary key. Does not add the emp bank info to the database.
	*
	* @param empBankInfoId the primary key for the new emp bank info
	* @return the new emp bank info
	*/
	public static vn.com.ecopharma.emp.model.EmpBankInfo create(
		long empBankInfoId) {
		return getPersistence().create(empBankInfoId);
	}

	/**
	* Removes the emp bank info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empBankInfoId the primary key of the emp bank info
	* @return the emp bank info that was removed
	* @throws vn.com.ecopharma.emp.NoSuchEmpBankInfoException if a emp bank info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpBankInfo remove(
		long empBankInfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpBankInfoException {
		return getPersistence().remove(empBankInfoId);
	}

	public static vn.com.ecopharma.emp.model.EmpBankInfo updateImpl(
		vn.com.ecopharma.emp.model.EmpBankInfo empBankInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(empBankInfo);
	}

	/**
	* Returns the emp bank info with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpBankInfoException} if it could not be found.
	*
	* @param empBankInfoId the primary key of the emp bank info
	* @return the emp bank info
	* @throws vn.com.ecopharma.emp.NoSuchEmpBankInfoException if a emp bank info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpBankInfo findByPrimaryKey(
		long empBankInfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpBankInfoException {
		return getPersistence().findByPrimaryKey(empBankInfoId);
	}

	/**
	* Returns the emp bank info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empBankInfoId the primary key of the emp bank info
	* @return the emp bank info, or <code>null</code> if a emp bank info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpBankInfo fetchByPrimaryKey(
		long empBankInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(empBankInfoId);
	}

	/**
	* Returns all the emp bank infos.
	*
	* @return the emp bank infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpBankInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<vn.com.ecopharma.emp.model.EmpBankInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the emp bank infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpBankInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp bank infos
	* @param end the upper bound of the range of emp bank infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of emp bank infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpBankInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the emp bank infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of emp bank infos.
	*
	* @return the number of emp bank infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmpBankInfoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmpBankInfoPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					EmpBankInfoPersistence.class.getName());

			ReferenceRegistry.registerReference(EmpBankInfoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EmpBankInfoPersistence persistence) {
	}

	private static EmpBankInfoPersistence _persistence;
}