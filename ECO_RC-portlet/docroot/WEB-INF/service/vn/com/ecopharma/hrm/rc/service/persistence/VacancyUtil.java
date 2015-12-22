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

package vn.com.ecopharma.hrm.rc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import vn.com.ecopharma.hrm.rc.model.Vacancy;

import java.util.List;

/**
 * The persistence utility for the vacancy service. This utility wraps {@link VacancyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see VacancyPersistence
 * @see VacancyPersistenceImpl
 * @generated
 */
public class VacancyUtil {
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
	public static void clearCache(Vacancy vacancy) {
		getPersistence().clearCache(vacancy);
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
	public static List<Vacancy> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Vacancy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Vacancy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Vacancy update(Vacancy vacancy) throws SystemException {
		return getPersistence().update(vacancy);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Vacancy update(Vacancy vacancy, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(vacancy, serviceContext);
	}

	/**
	* Returns the vacancy where name = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchVacancyException} if it could not be found.
	*
	* @param name the name
	* @return the matching vacancy
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyException if a matching vacancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns the vacancy where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching vacancy, or <code>null</code> if a matching vacancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Returns the vacancy where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vacancy, or <code>null</code> if a matching vacancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Removes the vacancy where name = &#63; from the database.
	*
	* @param name the name
	* @return the vacancy that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy removeByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyException {
		return getPersistence().removeByName(name);
	}

	/**
	* Returns the number of vacancies where name = &#63;.
	*
	* @param name the name
	* @return the number of matching vacancies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns all the vacancies where deleted = &#63;.
	*
	* @param deleted the deleted
	* @return the matching vacancies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Vacancy> findByUnDeleted(
		boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnDeleted(deleted);
	}

	/**
	* Returns a range of all the vacancies where deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param deleted the deleted
	* @param start the lower bound of the range of vacancies
	* @param end the upper bound of the range of vacancies (not inclusive)
	* @return the range of matching vacancies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Vacancy> findByUnDeleted(
		boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnDeleted(deleted, start, end);
	}

	/**
	* Returns an ordered range of all the vacancies where deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param deleted the deleted
	* @param start the lower bound of the range of vacancies
	* @param end the upper bound of the range of vacancies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vacancies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Vacancy> findByUnDeleted(
		boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUnDeleted(deleted, start, end, orderByComparator);
	}

	/**
	* Returns the first vacancy in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vacancy
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyException if a matching vacancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy findByUnDeleted_First(
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyException {
		return getPersistence().findByUnDeleted_First(deleted, orderByComparator);
	}

	/**
	* Returns the first vacancy in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vacancy, or <code>null</code> if a matching vacancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy fetchByUnDeleted_First(
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUnDeleted_First(deleted, orderByComparator);
	}

	/**
	* Returns the last vacancy in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vacancy
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyException if a matching vacancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy findByUnDeleted_Last(
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyException {
		return getPersistence().findByUnDeleted_Last(deleted, orderByComparator);
	}

	/**
	* Returns the last vacancy in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vacancy, or <code>null</code> if a matching vacancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy fetchByUnDeleted_Last(
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUnDeleted_Last(deleted, orderByComparator);
	}

	/**
	* Returns the vacancies before and after the current vacancy in the ordered set where deleted = &#63;.
	*
	* @param vacancyId the primary key of the current vacancy
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vacancy
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyException if a vacancy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy[] findByUnDeleted_PrevAndNext(
		long vacancyId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyException {
		return getPersistence()
				   .findByUnDeleted_PrevAndNext(vacancyId, deleted,
			orderByComparator);
	}

	/**
	* Removes all the vacancies where deleted = &#63; from the database.
	*
	* @param deleted the deleted
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUnDeleted(boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUnDeleted(deleted);
	}

	/**
	* Returns the number of vacancies where deleted = &#63;.
	*
	* @param deleted the deleted
	* @return the number of matching vacancies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUnDeleted(boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUnDeleted(deleted);
	}

	/**
	* Caches the vacancy in the entity cache if it is enabled.
	*
	* @param vacancy the vacancy
	*/
	public static void cacheResult(
		vn.com.ecopharma.hrm.rc.model.Vacancy vacancy) {
		getPersistence().cacheResult(vacancy);
	}

	/**
	* Caches the vacancies in the entity cache if it is enabled.
	*
	* @param vacancies the vacancies
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.hrm.rc.model.Vacancy> vacancies) {
		getPersistence().cacheResult(vacancies);
	}

	/**
	* Creates a new vacancy with the primary key. Does not add the vacancy to the database.
	*
	* @param vacancyId the primary key for the new vacancy
	* @return the new vacancy
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy create(long vacancyId) {
		return getPersistence().create(vacancyId);
	}

	/**
	* Removes the vacancy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vacancyId the primary key of the vacancy
	* @return the vacancy that was removed
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyException if a vacancy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy remove(long vacancyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyException {
		return getPersistence().remove(vacancyId);
	}

	public static vn.com.ecopharma.hrm.rc.model.Vacancy updateImpl(
		vn.com.ecopharma.hrm.rc.model.Vacancy vacancy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vacancy);
	}

	/**
	* Returns the vacancy with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchVacancyException} if it could not be found.
	*
	* @param vacancyId the primary key of the vacancy
	* @return the vacancy
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyException if a vacancy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy findByPrimaryKey(
		long vacancyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyException {
		return getPersistence().findByPrimaryKey(vacancyId);
	}

	/**
	* Returns the vacancy with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vacancyId the primary key of the vacancy
	* @return the vacancy, or <code>null</code> if a vacancy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy fetchByPrimaryKey(
		long vacancyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(vacancyId);
	}

	/**
	* Returns all the vacancies.
	*
	* @return the vacancies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Vacancy> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the vacancies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vacancies
	* @param end the upper bound of the range of vacancies (not inclusive)
	* @return the range of vacancies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Vacancy> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the vacancies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vacancies
	* @param end the upper bound of the range of vacancies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vacancies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Vacancy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vacancies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vacancies.
	*
	* @return the number of vacancies
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VacancyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VacancyPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.hrm.rc.service.ClpSerializer.getServletContextName(),
					VacancyPersistence.class.getName());

			ReferenceRegistry.registerReference(VacancyUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VacancyPersistence persistence) {
	}

	private static VacancyPersistence _persistence;
}