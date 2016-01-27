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

import vn.com.ecopharma.emp.model.EmpDiscipline;

import java.util.List;

/**
 * The persistence utility for the emp discipline service. This utility wraps {@link EmpDisciplinePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpDisciplinePersistence
 * @see EmpDisciplinePersistenceImpl
 * @generated
 */
public class EmpDisciplineUtil {
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
	public static void clearCache(EmpDiscipline empDiscipline) {
		getPersistence().clearCache(empDiscipline);
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
	public static List<EmpDiscipline> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmpDiscipline> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmpDiscipline> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EmpDiscipline update(EmpDiscipline empDiscipline)
		throws SystemException {
		return getPersistence().update(empDiscipline);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EmpDiscipline update(EmpDiscipline empDiscipline,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(empDiscipline, serviceContext);
	}

	/**
	* Caches the emp discipline in the entity cache if it is enabled.
	*
	* @param empDiscipline the emp discipline
	*/
	public static void cacheResult(
		vn.com.ecopharma.emp.model.EmpDiscipline empDiscipline) {
		getPersistence().cacheResult(empDiscipline);
	}

	/**
	* Caches the emp disciplines in the entity cache if it is enabled.
	*
	* @param empDisciplines the emp disciplines
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.EmpDiscipline> empDisciplines) {
		getPersistence().cacheResult(empDisciplines);
	}

	/**
	* Creates a new emp discipline with the primary key. Does not add the emp discipline to the database.
	*
	* @param empDisciplineId the primary key for the new emp discipline
	* @return the new emp discipline
	*/
	public static vn.com.ecopharma.emp.model.EmpDiscipline create(
		long empDisciplineId) {
		return getPersistence().create(empDisciplineId);
	}

	/**
	* Removes the emp discipline with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empDisciplineId the primary key of the emp discipline
	* @return the emp discipline that was removed
	* @throws vn.com.ecopharma.emp.NoSuchEmpDisciplineException if a emp discipline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpDiscipline remove(
		long empDisciplineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpDisciplineException {
		return getPersistence().remove(empDisciplineId);
	}

	public static vn.com.ecopharma.emp.model.EmpDiscipline updateImpl(
		vn.com.ecopharma.emp.model.EmpDiscipline empDiscipline)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(empDiscipline);
	}

	/**
	* Returns the emp discipline with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpDisciplineException} if it could not be found.
	*
	* @param empDisciplineId the primary key of the emp discipline
	* @return the emp discipline
	* @throws vn.com.ecopharma.emp.NoSuchEmpDisciplineException if a emp discipline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpDiscipline findByPrimaryKey(
		long empDisciplineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpDisciplineException {
		return getPersistence().findByPrimaryKey(empDisciplineId);
	}

	/**
	* Returns the emp discipline with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empDisciplineId the primary key of the emp discipline
	* @return the emp discipline, or <code>null</code> if a emp discipline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpDiscipline fetchByPrimaryKey(
		long empDisciplineId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(empDisciplineId);
	}

	/**
	* Returns all the emp disciplines.
	*
	* @return the emp disciplines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpDiscipline> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the emp disciplines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpDisciplineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp disciplines
	* @param end the upper bound of the range of emp disciplines (not inclusive)
	* @return the range of emp disciplines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpDiscipline> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the emp disciplines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpDisciplineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp disciplines
	* @param end the upper bound of the range of emp disciplines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of emp disciplines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpDiscipline> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the emp disciplines from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of emp disciplines.
	*
	* @return the number of emp disciplines
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmpDisciplinePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmpDisciplinePersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					EmpDisciplinePersistence.class.getName());

			ReferenceRegistry.registerReference(EmpDisciplineUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EmpDisciplinePersistence persistence) {
	}

	private static EmpDisciplinePersistence _persistence;
}