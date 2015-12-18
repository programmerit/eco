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

import vn.com.ecopharma.emp.model.University;

import java.util.List;

/**
 * The persistence utility for the university service. This utility wraps {@link UniversityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see UniversityPersistence
 * @see UniversityPersistenceImpl
 * @generated
 */
public class UniversityUtil {
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
	public static void clearCache(University university) {
		getPersistence().clearCache(university);
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
	public static List<University> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<University> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<University> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static University update(University university)
		throws SystemException {
		return getPersistence().update(university);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static University update(University university,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(university, serviceContext);
	}

	/**
	* Returns the university where name = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchUniversityException} if it could not be found.
	*
	* @param name the name
	* @return the matching university
	* @throws vn.com.ecopharma.emp.NoSuchUniversityException if a matching university could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.University findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUniversityException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns the university where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching university, or <code>null</code> if a matching university could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.University fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Returns the university where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching university, or <code>null</code> if a matching university could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.University fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Removes the university where name = &#63; from the database.
	*
	* @param name the name
	* @return the university that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.University removeByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUniversityException {
		return getPersistence().removeByName(name);
	}

	/**
	* Returns the number of universities where name = &#63;.
	*
	* @param name the name
	* @return the number of matching universities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns the university where code = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchUniversityException} if it could not be found.
	*
	* @param code the code
	* @return the matching university
	* @throws vn.com.ecopharma.emp.NoSuchUniversityException if a matching university could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.University findByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUniversityException {
		return getPersistence().findByCode(code);
	}

	/**
	* Returns the university where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching university, or <code>null</code> if a matching university could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.University fetchByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(code);
	}

	/**
	* Returns the university where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching university, or <code>null</code> if a matching university could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.University fetchByCode(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(code, retrieveFromCache);
	}

	/**
	* Removes the university where code = &#63; from the database.
	*
	* @param code the code
	* @return the university that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.University removeByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUniversityException {
		return getPersistence().removeByCode(code);
	}

	/**
	* Returns the number of universities where code = &#63;.
	*
	* @param code the code
	* @return the number of matching universities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCode(code);
	}

	/**
	* Caches the university in the entity cache if it is enabled.
	*
	* @param university the university
	*/
	public static void cacheResult(
		vn.com.ecopharma.emp.model.University university) {
		getPersistence().cacheResult(university);
	}

	/**
	* Caches the universities in the entity cache if it is enabled.
	*
	* @param universities the universities
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.University> universities) {
		getPersistence().cacheResult(universities);
	}

	/**
	* Creates a new university with the primary key. Does not add the university to the database.
	*
	* @param universityId the primary key for the new university
	* @return the new university
	*/
	public static vn.com.ecopharma.emp.model.University create(
		long universityId) {
		return getPersistence().create(universityId);
	}

	/**
	* Removes the university with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param universityId the primary key of the university
	* @return the university that was removed
	* @throws vn.com.ecopharma.emp.NoSuchUniversityException if a university with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.University remove(
		long universityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUniversityException {
		return getPersistence().remove(universityId);
	}

	public static vn.com.ecopharma.emp.model.University updateImpl(
		vn.com.ecopharma.emp.model.University university)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(university);
	}

	/**
	* Returns the university with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchUniversityException} if it could not be found.
	*
	* @param universityId the primary key of the university
	* @return the university
	* @throws vn.com.ecopharma.emp.NoSuchUniversityException if a university with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.University findByPrimaryKey(
		long universityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUniversityException {
		return getPersistence().findByPrimaryKey(universityId);
	}

	/**
	* Returns the university with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param universityId the primary key of the university
	* @return the university, or <code>null</code> if a university with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.University fetchByPrimaryKey(
		long universityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(universityId);
	}

	/**
	* Returns all the universities.
	*
	* @return the universities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.University> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the universities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UniversityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of universities
	* @param end the upper bound of the range of universities (not inclusive)
	* @return the range of universities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.University> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the universities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UniversityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of universities
	* @param end the upper bound of the range of universities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of universities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.University> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the universities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of universities.
	*
	* @return the number of universities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UniversityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UniversityPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					UniversityPersistence.class.getName());

			ReferenceRegistry.registerReference(UniversityUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UniversityPersistence persistence) {
	}

	private static UniversityPersistence _persistence;
}