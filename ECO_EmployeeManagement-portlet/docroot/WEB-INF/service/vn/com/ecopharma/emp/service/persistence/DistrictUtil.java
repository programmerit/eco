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

import vn.com.ecopharma.emp.model.District;

import java.util.List;

/**
 * The persistence utility for the district service. This utility wraps {@link DistrictPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see DistrictPersistence
 * @see DistrictPersistenceImpl
 * @generated
 */
public class DistrictUtil {
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
	public static void clearCache(District district) {
		getPersistence().clearCache(district);
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
	public static List<District> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<District> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<District> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static District update(District district) throws SystemException {
		return getPersistence().update(district);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static District update(District district,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(district, serviceContext);
	}

	/**
	* Returns all the districts where regionCode = &#63;.
	*
	* @param regionCode the region code
	* @return the matching districts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.District> findByRegionCode(
		java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRegionCode(regionCode);
	}

	/**
	* Returns a range of all the districts where regionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param regionCode the region code
	* @param start the lower bound of the range of districts
	* @param end the upper bound of the range of districts (not inclusive)
	* @return the range of matching districts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.District> findByRegionCode(
		java.lang.String regionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRegionCode(regionCode, start, end);
	}

	/**
	* Returns an ordered range of all the districts where regionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param regionCode the region code
	* @param start the lower bound of the range of districts
	* @param end the upper bound of the range of districts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching districts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.District> findByRegionCode(
		java.lang.String regionCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRegionCode(regionCode, start, end, orderByComparator);
	}

	/**
	* Returns the first district in the ordered set where regionCode = &#63;.
	*
	* @param regionCode the region code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching district
	* @throws vn.com.ecopharma.emp.NoSuchDistrictException if a matching district could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.District findByRegionCode_First(
		java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDistrictException {
		return getPersistence()
				   .findByRegionCode_First(regionCode, orderByComparator);
	}

	/**
	* Returns the first district in the ordered set where regionCode = &#63;.
	*
	* @param regionCode the region code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching district, or <code>null</code> if a matching district could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.District fetchByRegionCode_First(
		java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRegionCode_First(regionCode, orderByComparator);
	}

	/**
	* Returns the last district in the ordered set where regionCode = &#63;.
	*
	* @param regionCode the region code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching district
	* @throws vn.com.ecopharma.emp.NoSuchDistrictException if a matching district could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.District findByRegionCode_Last(
		java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDistrictException {
		return getPersistence()
				   .findByRegionCode_Last(regionCode, orderByComparator);
	}

	/**
	* Returns the last district in the ordered set where regionCode = &#63;.
	*
	* @param regionCode the region code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching district, or <code>null</code> if a matching district could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.District fetchByRegionCode_Last(
		java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRegionCode_Last(regionCode, orderByComparator);
	}

	/**
	* Returns the districts before and after the current district in the ordered set where regionCode = &#63;.
	*
	* @param districtId the primary key of the current district
	* @param regionCode the region code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next district
	* @throws vn.com.ecopharma.emp.NoSuchDistrictException if a district with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.District[] findByRegionCode_PrevAndNext(
		long districtId, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDistrictException {
		return getPersistence()
				   .findByRegionCode_PrevAndNext(districtId, regionCode,
			orderByComparator);
	}

	/**
	* Removes all the districts where regionCode = &#63; from the database.
	*
	* @param regionCode the region code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRegionCode(java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRegionCode(regionCode);
	}

	/**
	* Returns the number of districts where regionCode = &#63;.
	*
	* @param regionCode the region code
	* @return the number of matching districts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRegionCode(java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRegionCode(regionCode);
	}

	/**
	* Returns the district where regionCode = &#63; and name = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchDistrictException} if it could not be found.
	*
	* @param regionCode the region code
	* @param name the name
	* @return the matching district
	* @throws vn.com.ecopharma.emp.NoSuchDistrictException if a matching district could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.District findByRegionCodeAndName(
		java.lang.String regionCode, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDistrictException {
		return getPersistence().findByRegionCodeAndName(regionCode, name);
	}

	/**
	* Returns the district where regionCode = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param regionCode the region code
	* @param name the name
	* @return the matching district, or <code>null</code> if a matching district could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.District fetchByRegionCodeAndName(
		java.lang.String regionCode, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRegionCodeAndName(regionCode, name);
	}

	/**
	* Returns the district where regionCode = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param regionCode the region code
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching district, or <code>null</code> if a matching district could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.District fetchByRegionCodeAndName(
		java.lang.String regionCode, java.lang.String name,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRegionCodeAndName(regionCode, name, retrieveFromCache);
	}

	/**
	* Removes the district where regionCode = &#63; and name = &#63; from the database.
	*
	* @param regionCode the region code
	* @param name the name
	* @return the district that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.District removeByRegionCodeAndName(
		java.lang.String regionCode, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDistrictException {
		return getPersistence().removeByRegionCodeAndName(regionCode, name);
	}

	/**
	* Returns the number of districts where regionCode = &#63; and name = &#63;.
	*
	* @param regionCode the region code
	* @param name the name
	* @return the number of matching districts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRegionCodeAndName(java.lang.String regionCode,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRegionCodeAndName(regionCode, name);
	}

	/**
	* Caches the district in the entity cache if it is enabled.
	*
	* @param district the district
	*/
	public static void cacheResult(vn.com.ecopharma.emp.model.District district) {
		getPersistence().cacheResult(district);
	}

	/**
	* Caches the districts in the entity cache if it is enabled.
	*
	* @param districts the districts
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.District> districts) {
		getPersistence().cacheResult(districts);
	}

	/**
	* Creates a new district with the primary key. Does not add the district to the database.
	*
	* @param districtId the primary key for the new district
	* @return the new district
	*/
	public static vn.com.ecopharma.emp.model.District create(long districtId) {
		return getPersistence().create(districtId);
	}

	/**
	* Removes the district with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param districtId the primary key of the district
	* @return the district that was removed
	* @throws vn.com.ecopharma.emp.NoSuchDistrictException if a district with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.District remove(long districtId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDistrictException {
		return getPersistence().remove(districtId);
	}

	public static vn.com.ecopharma.emp.model.District updateImpl(
		vn.com.ecopharma.emp.model.District district)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(district);
	}

	/**
	* Returns the district with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchDistrictException} if it could not be found.
	*
	* @param districtId the primary key of the district
	* @return the district
	* @throws vn.com.ecopharma.emp.NoSuchDistrictException if a district with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.District findByPrimaryKey(
		long districtId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDistrictException {
		return getPersistence().findByPrimaryKey(districtId);
	}

	/**
	* Returns the district with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param districtId the primary key of the district
	* @return the district, or <code>null</code> if a district with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.District fetchByPrimaryKey(
		long districtId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(districtId);
	}

	/**
	* Returns all the districts.
	*
	* @return the districts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.District> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the districts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of districts
	* @param end the upper bound of the range of districts (not inclusive)
	* @return the range of districts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.District> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the districts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of districts
	* @param end the upper bound of the range of districts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of districts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.District> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the districts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of districts.
	*
	* @return the number of districts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DistrictPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DistrictPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					DistrictPersistence.class.getName());

			ReferenceRegistry.registerReference(DistrictUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DistrictPersistence persistence) {
	}

	private static DistrictPersistence _persistence;
}