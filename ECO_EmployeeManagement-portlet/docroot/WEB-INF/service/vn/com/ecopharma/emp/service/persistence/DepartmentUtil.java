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

import vn.com.ecopharma.emp.model.Department;

import java.util.List;

/**
 * The persistence utility for the department service. This utility wraps {@link DepartmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see DepartmentPersistence
 * @see DepartmentPersistenceImpl
 * @generated
 */
public class DepartmentUtil {
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
	public static void clearCache(Department department) {
		getPersistence().clearCache(department);
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
	public static List<Department> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Department> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Department> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Department update(Department department)
		throws SystemException {
		return getPersistence().update(department);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Department update(Department department,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(department, serviceContext);
	}

	/**
	* Returns the department where name = &#63; and devisionId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchDepartmentException} if it could not be found.
	*
	* @param name the name
	* @param devisionId the devision ID
	* @return the matching department
	* @throws vn.com.ecopharma.emp.NoSuchDepartmentException if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Department findByNameAndDevision(
		java.lang.String name, long devisionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDepartmentException {
		return getPersistence().findByNameAndDevision(name, devisionId);
	}

	/**
	* Returns the department where name = &#63; and devisionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @param devisionId the devision ID
	* @return the matching department, or <code>null</code> if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Department fetchByNameAndDevision(
		java.lang.String name, long devisionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNameAndDevision(name, devisionId);
	}

	/**
	* Returns the department where name = &#63; and devisionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param devisionId the devision ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching department, or <code>null</code> if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Department fetchByNameAndDevision(
		java.lang.String name, long devisionId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameAndDevision(name, devisionId, retrieveFromCache);
	}

	/**
	* Removes the department where name = &#63; and devisionId = &#63; from the database.
	*
	* @param name the name
	* @param devisionId the devision ID
	* @return the department that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Department removeByNameAndDevision(
		java.lang.String name, long devisionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDepartmentException {
		return getPersistence().removeByNameAndDevision(name, devisionId);
	}

	/**
	* Returns the number of departments where name = &#63; and devisionId = &#63;.
	*
	* @param name the name
	* @param devisionId the devision ID
	* @return the number of matching departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNameAndDevision(java.lang.String name,
		long devisionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNameAndDevision(name, devisionId);
	}

	/**
	* Returns all the departments where devisionId = &#63;.
	*
	* @param devisionId the devision ID
	* @return the matching departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Department> findByDevision(
		long devisionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDevision(devisionId);
	}

	/**
	* Returns a range of all the departments where devisionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param devisionId the devision ID
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @return the range of matching departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Department> findByDevision(
		long devisionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDevision(devisionId, start, end);
	}

	/**
	* Returns an ordered range of all the departments where devisionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param devisionId the devision ID
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Department> findByDevision(
		long devisionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDevision(devisionId, start, end, orderByComparator);
	}

	/**
	* Returns the first department in the ordered set where devisionId = &#63;.
	*
	* @param devisionId the devision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department
	* @throws vn.com.ecopharma.emp.NoSuchDepartmentException if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Department findByDevision_First(
		long devisionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDepartmentException {
		return getPersistence()
				   .findByDevision_First(devisionId, orderByComparator);
	}

	/**
	* Returns the first department in the ordered set where devisionId = &#63;.
	*
	* @param devisionId the devision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department, or <code>null</code> if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Department fetchByDevision_First(
		long devisionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDevision_First(devisionId, orderByComparator);
	}

	/**
	* Returns the last department in the ordered set where devisionId = &#63;.
	*
	* @param devisionId the devision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department
	* @throws vn.com.ecopharma.emp.NoSuchDepartmentException if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Department findByDevision_Last(
		long devisionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDepartmentException {
		return getPersistence()
				   .findByDevision_Last(devisionId, orderByComparator);
	}

	/**
	* Returns the last department in the ordered set where devisionId = &#63;.
	*
	* @param devisionId the devision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department, or <code>null</code> if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Department fetchByDevision_Last(
		long devisionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDevision_Last(devisionId, orderByComparator);
	}

	/**
	* Returns the departments before and after the current department in the ordered set where devisionId = &#63;.
	*
	* @param departmentId the primary key of the current department
	* @param devisionId the devision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next department
	* @throws vn.com.ecopharma.emp.NoSuchDepartmentException if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Department[] findByDevision_PrevAndNext(
		long departmentId, long devisionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDepartmentException {
		return getPersistence()
				   .findByDevision_PrevAndNext(departmentId, devisionId,
			orderByComparator);
	}

	/**
	* Removes all the departments where devisionId = &#63; from the database.
	*
	* @param devisionId the devision ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDevision(long devisionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDevision(devisionId);
	}

	/**
	* Returns the number of departments where devisionId = &#63;.
	*
	* @param devisionId the devision ID
	* @return the number of matching departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDevision(long devisionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDevision(devisionId);
	}

	/**
	* Caches the department in the entity cache if it is enabled.
	*
	* @param department the department
	*/
	public static void cacheResult(
		vn.com.ecopharma.emp.model.Department department) {
		getPersistence().cacheResult(department);
	}

	/**
	* Caches the departments in the entity cache if it is enabled.
	*
	* @param departments the departments
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.Department> departments) {
		getPersistence().cacheResult(departments);
	}

	/**
	* Creates a new department with the primary key. Does not add the department to the database.
	*
	* @param departmentId the primary key for the new department
	* @return the new department
	*/
	public static vn.com.ecopharma.emp.model.Department create(
		long departmentId) {
		return getPersistence().create(departmentId);
	}

	/**
	* Removes the department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param departmentId the primary key of the department
	* @return the department that was removed
	* @throws vn.com.ecopharma.emp.NoSuchDepartmentException if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Department remove(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDepartmentException {
		return getPersistence().remove(departmentId);
	}

	public static vn.com.ecopharma.emp.model.Department updateImpl(
		vn.com.ecopharma.emp.model.Department department)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(department);
	}

	/**
	* Returns the department with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchDepartmentException} if it could not be found.
	*
	* @param departmentId the primary key of the department
	* @return the department
	* @throws vn.com.ecopharma.emp.NoSuchDepartmentException if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Department findByPrimaryKey(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDepartmentException {
		return getPersistence().findByPrimaryKey(departmentId);
	}

	/**
	* Returns the department with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param departmentId the primary key of the department
	* @return the department, or <code>null</code> if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Department fetchByPrimaryKey(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(departmentId);
	}

	/**
	* Returns all the departments.
	*
	* @return the departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Department> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @return the range of departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Department> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Department> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the departments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of departments.
	*
	* @return the number of departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DepartmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DepartmentPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					DepartmentPersistence.class.getName());

			ReferenceRegistry.registerReference(DepartmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DepartmentPersistence persistence) {
	}

	private static DepartmentPersistence _persistence;
}