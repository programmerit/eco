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

import vn.com.ecopharma.emp.model.SubUnit;

import java.util.List;

/**
 * The persistence utility for the sub unit service. This utility wraps {@link SubUnitPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see SubUnitPersistence
 * @see SubUnitPersistenceImpl
 * @generated
 */
public class SubUnitUtil {
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
	public static void clearCache(SubUnit subUnit) {
		getPersistence().clearCache(subUnit);
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
	public static List<SubUnit> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SubUnit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SubUnit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SubUnit update(SubUnit subUnit) throws SystemException {
		return getPersistence().update(subUnit);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SubUnit update(SubUnit subUnit, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(subUnit, serviceContext);
	}

	/**
	* Returns the sub unit where name = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchSubUnitException} if it could not be found.
	*
	* @param name the name
	* @return the matching sub unit
	* @throws vn.com.ecopharma.emp.NoSuchSubUnitException if a matching sub unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.SubUnit findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSubUnitException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns the sub unit where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching sub unit, or <code>null</code> if a matching sub unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.SubUnit fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Returns the sub unit where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching sub unit, or <code>null</code> if a matching sub unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.SubUnit fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Removes the sub unit where name = &#63; from the database.
	*
	* @param name the name
	* @return the sub unit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.SubUnit removeByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSubUnitException {
		return getPersistence().removeByName(name);
	}

	/**
	* Returns the number of sub units where name = &#63;.
	*
	* @param name the name
	* @return the number of matching sub units
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Caches the sub unit in the entity cache if it is enabled.
	*
	* @param subUnit the sub unit
	*/
	public static void cacheResult(vn.com.ecopharma.emp.model.SubUnit subUnit) {
		getPersistence().cacheResult(subUnit);
	}

	/**
	* Caches the sub units in the entity cache if it is enabled.
	*
	* @param subUnits the sub units
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.SubUnit> subUnits) {
		getPersistence().cacheResult(subUnits);
	}

	/**
	* Creates a new sub unit with the primary key. Does not add the sub unit to the database.
	*
	* @param subUnitId the primary key for the new sub unit
	* @return the new sub unit
	*/
	public static vn.com.ecopharma.emp.model.SubUnit create(long subUnitId) {
		return getPersistence().create(subUnitId);
	}

	/**
	* Removes the sub unit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subUnitId the primary key of the sub unit
	* @return the sub unit that was removed
	* @throws vn.com.ecopharma.emp.NoSuchSubUnitException if a sub unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.SubUnit remove(long subUnitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSubUnitException {
		return getPersistence().remove(subUnitId);
	}

	public static vn.com.ecopharma.emp.model.SubUnit updateImpl(
		vn.com.ecopharma.emp.model.SubUnit subUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(subUnit);
	}

	/**
	* Returns the sub unit with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchSubUnitException} if it could not be found.
	*
	* @param subUnitId the primary key of the sub unit
	* @return the sub unit
	* @throws vn.com.ecopharma.emp.NoSuchSubUnitException if a sub unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.SubUnit findByPrimaryKey(
		long subUnitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSubUnitException {
		return getPersistence().findByPrimaryKey(subUnitId);
	}

	/**
	* Returns the sub unit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param subUnitId the primary key of the sub unit
	* @return the sub unit, or <code>null</code> if a sub unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.SubUnit fetchByPrimaryKey(
		long subUnitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(subUnitId);
	}

	/**
	* Returns all the sub units.
	*
	* @return the sub units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.SubUnit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the sub units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SubUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sub units
	* @param end the upper bound of the range of sub units (not inclusive)
	* @return the range of sub units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.SubUnit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the sub units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SubUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sub units
	* @param end the upper bound of the range of sub units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sub units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.SubUnit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the sub units from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sub units.
	*
	* @return the number of sub units
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SubUnitPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SubUnitPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					SubUnitPersistence.class.getName());

			ReferenceRegistry.registerReference(SubUnitUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SubUnitPersistence persistence) {
	}

	private static SubUnitPersistence _persistence;
}