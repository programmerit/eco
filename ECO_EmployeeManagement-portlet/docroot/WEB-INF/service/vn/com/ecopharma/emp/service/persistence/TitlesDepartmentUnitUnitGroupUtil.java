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

import vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup;

import java.util.List;

/**
 * The persistence utility for the titles department unit unit group service. This utility wraps {@link TitlesDepartmentUnitUnitGroupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see TitlesDepartmentUnitUnitGroupPersistence
 * @see TitlesDepartmentUnitUnitGroupPersistenceImpl
 * @generated
 */
public class TitlesDepartmentUnitUnitGroupUtil {
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
	public static void clearCache(
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup) {
		getPersistence().clearCache(titlesDepartmentUnitUnitGroup);
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
	public static List<TitlesDepartmentUnitUnitGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TitlesDepartmentUnitUnitGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TitlesDepartmentUnitUnitGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TitlesDepartmentUnitUnitGroup update(
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup)
		throws SystemException {
		return getPersistence().update(titlesDepartmentUnitUnitGroup);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TitlesDepartmentUnitUnitGroup update(
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(titlesDepartmentUnitUnitGroup, serviceContext);
	}

	/**
	* Returns all the titles department unit unit groups where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDepartment(departmentId);
	}

	/**
	* Returns a range of all the titles department unit unit groups where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @return the range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByDepartment(
		long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDepartment(departmentId, start, end);
	}

	/**
	* Returns an ordered range of all the titles department unit unit groups where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByDepartment(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartment(departmentId, start, end, orderByComparator);
	}

	/**
	* Returns the first titles department unit unit group in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByDepartment_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByDepartment_First(departmentId, orderByComparator);
	}

	/**
	* Returns the first titles department unit unit group in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByDepartment_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartment_First(departmentId, orderByComparator);
	}

	/**
	* Returns the last titles department unit unit group in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByDepartment_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByDepartment_Last(departmentId, orderByComparator);
	}

	/**
	* Returns the last titles department unit unit group in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByDepartment_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartment_Last(departmentId, orderByComparator);
	}

	/**
	* Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where departmentId = &#63;.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup[] findByDepartment_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByDepartment_PrevAndNext(titlesDepartmentUnitUnitGroupId,
			departmentId, orderByComparator);
	}

	/**
	* Removes all the titles department unit unit groups where departmentId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDepartment(departmentId);
	}

	/**
	* Returns the number of titles department unit unit groups where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the number of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDepartment(departmentId);
	}

	/**
	* Returns all the titles department unit unit groups where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @return the matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnit(
		long unitId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnit(unitId);
	}

	/**
	* Returns a range of all the titles department unit unit groups where unitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @return the range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnit(
		long unitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnit(unitId, start, end);
	}

	/**
	* Returns an ordered range of all the titles department unit unit groups where unitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnit(
		long unitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnit(unitId, start, end, orderByComparator);
	}

	/**
	* Returns the first titles department unit unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByUnit_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence().findByUnit_First(unitId, orderByComparator);
	}

	/**
	* Returns the first titles department unit unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByUnit_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUnit_First(unitId, orderByComparator);
	}

	/**
	* Returns the last titles department unit unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByUnit_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence().findByUnit_Last(unitId, orderByComparator);
	}

	/**
	* Returns the last titles department unit unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByUnit_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUnit_Last(unitId, orderByComparator);
	}

	/**
	* Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where unitId = &#63;.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup[] findByUnit_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByUnit_PrevAndNext(titlesDepartmentUnitUnitGroupId,
			unitId, orderByComparator);
	}

	/**
	* Removes all the titles department unit unit groups where unitId = &#63; from the database.
	*
	* @param unitId the unit ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUnit(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUnit(unitId);
	}

	/**
	* Returns the number of titles department unit unit groups where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @return the number of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUnit(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUnit(unitId);
	}

	/**
	* Returns all the titles department unit unit groups where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @return the matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnitGroup(
		long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnitGroup(unitGroupId);
	}

	/**
	* Returns a range of all the titles department unit unit groups where unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @return the range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnitGroup(
		long unitGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnitGroup(unitGroupId, start, end);
	}

	/**
	* Returns an ordered range of all the titles department unit unit groups where unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnitGroup(
		long unitGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUnitGroup(unitGroupId, start, end, orderByComparator);
	}

	/**
	* Returns the first titles department unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByUnitGroup_First(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByUnitGroup_First(unitGroupId, orderByComparator);
	}

	/**
	* Returns the first titles department unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByUnitGroup_First(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUnitGroup_First(unitGroupId, orderByComparator);
	}

	/**
	* Returns the last titles department unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByUnitGroup_Last(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByUnitGroup_Last(unitGroupId, orderByComparator);
	}

	/**
	* Returns the last titles department unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByUnitGroup_Last(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUnitGroup_Last(unitGroupId, orderByComparator);
	}

	/**
	* Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup[] findByUnitGroup_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByUnitGroup_PrevAndNext(titlesDepartmentUnitUnitGroupId,
			unitGroupId, orderByComparator);
	}

	/**
	* Removes all the titles department unit unit groups where unitGroupId = &#63; from the database.
	*
	* @param unitGroupId the unit group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUnitGroup(long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUnitGroup(unitGroupId);
	}

	/**
	* Returns the number of titles department unit unit groups where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @return the number of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUnitGroup(long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUnitGroup(unitGroupId);
	}

	/**
	* Returns all the titles department unit unit groups where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @return the matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByTitles(
		long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitles(titlesId);
	}

	/**
	* Returns a range of all the titles department unit unit groups where titlesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titlesId the titles ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @return the range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByTitles(
		long titlesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitles(titlesId, start, end);
	}

	/**
	* Returns an ordered range of all the titles department unit unit groups where titlesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titlesId the titles ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByTitles(
		long titlesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTitles(titlesId, start, end, orderByComparator);
	}

	/**
	* Returns the first titles department unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByTitles_First(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence().findByTitles_First(titlesId, orderByComparator);
	}

	/**
	* Returns the first titles department unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByTitles_First(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitles_First(titlesId, orderByComparator);
	}

	/**
	* Returns the last titles department unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByTitles_Last(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence().findByTitles_Last(titlesId, orderByComparator);
	}

	/**
	* Returns the last titles department unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByTitles_Last(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitles_Last(titlesId, orderByComparator);
	}

	/**
	* Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup[] findByTitles_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByTitles_PrevAndNext(titlesDepartmentUnitUnitGroupId,
			titlesId, orderByComparator);
	}

	/**
	* Removes all the titles department unit unit groups where titlesId = &#63; from the database.
	*
	* @param titlesId the titles ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTitles(long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTitles(titlesId);
	}

	/**
	* Returns the number of titles department unit unit groups where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @return the number of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTitles(long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTitles(titlesId);
	}

	/**
	* Returns all the titles department unit unit groups where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByDepartmentUnitUnitGroup(
		long departmentId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentUnitUnitGroup(departmentId, unitId,
			unitGroupId);
	}

	/**
	* Returns a range of all the titles department unit unit groups where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @return the range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByDepartmentUnitUnitGroup(
		long departmentId, long unitId, long unitGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentUnitUnitGroup(departmentId, unitId,
			unitGroupId, start, end);
	}

	/**
	* Returns an ordered range of all the titles department unit unit groups where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByDepartmentUnitUnitGroup(
		long departmentId, long unitId, long unitGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentUnitUnitGroup(departmentId, unitId,
			unitGroupId, start, end, orderByComparator);
	}

	/**
	* Returns the first titles department unit unit group in the ordered set where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByDepartmentUnitUnitGroup_First(
		long departmentId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByDepartmentUnitUnitGroup_First(departmentId, unitId,
			unitGroupId, orderByComparator);
	}

	/**
	* Returns the first titles department unit unit group in the ordered set where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByDepartmentUnitUnitGroup_First(
		long departmentId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentUnitUnitGroup_First(departmentId, unitId,
			unitGroupId, orderByComparator);
	}

	/**
	* Returns the last titles department unit unit group in the ordered set where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByDepartmentUnitUnitGroup_Last(
		long departmentId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByDepartmentUnitUnitGroup_Last(departmentId, unitId,
			unitGroupId, orderByComparator);
	}

	/**
	* Returns the last titles department unit unit group in the ordered set where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByDepartmentUnitUnitGroup_Last(
		long departmentId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentUnitUnitGroup_Last(departmentId, unitId,
			unitGroupId, orderByComparator);
	}

	/**
	* Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup[] findByDepartmentUnitUnitGroup_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long departmentId, long unitId,
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByDepartmentUnitUnitGroup_PrevAndNext(titlesDepartmentUnitUnitGroupId,
			departmentId, unitId, unitGroupId, orderByComparator);
	}

	/**
	* Removes all the titles department unit unit groups where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDepartmentUnitUnitGroup(long departmentId,
		long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByDepartmentUnitUnitGroup(departmentId, unitId, unitGroupId);
	}

	/**
	* Returns the number of titles department unit unit groups where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the number of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartmentUnitUnitGroup(long departmentId,
		long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByDepartmentUnitUnitGroup(departmentId, unitId,
			unitGroupId);
	}

	/**
	* Returns the titles department unit unit group where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException} if it could not be found.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByTitlesDepartmentUnitUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByTitlesDepartmentUnitUnitGroup(titlesId, departmentId,
			unitId, unitGroupId);
	}

	/**
	* Returns the titles department unit unit group where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByTitlesDepartmentUnitUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTitlesDepartmentUnitUnitGroup(titlesId,
			departmentId, unitId, unitGroupId);
	}

	/**
	* Returns the titles department unit unit group where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByTitlesDepartmentUnitUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTitlesDepartmentUnitUnitGroup(titlesId,
			departmentId, unitId, unitGroupId, retrieveFromCache);
	}

	/**
	* Removes the titles department unit unit group where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; from the database.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the titles department unit unit group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup removeByTitlesDepartmentUnitUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .removeByTitlesDepartmentUnitUnitGroup(titlesId,
			departmentId, unitId, unitGroupId);
	}

	/**
	* Returns the number of titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the number of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTitlesDepartmentUnitUnitGroup(long titlesId,
		long departmentId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTitlesDepartmentUnitUnitGroup(titlesId,
			departmentId, unitId, unitGroupId);
	}

	/**
	* Returns all the titles department unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnitAndUnitGroup(
		long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnitAndUnitGroup(unitId, unitGroupId);
	}

	/**
	* Returns a range of all the titles department unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @return the range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnitAndUnitGroup(
		long unitId, long unitGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUnitAndUnitGroup(unitId, unitGroupId, start, end);
	}

	/**
	* Returns an ordered range of all the titles department unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnitAndUnitGroup(
		long unitId, long unitGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUnitAndUnitGroup(unitId, unitGroupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first titles department unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByUnitAndUnitGroup_First(
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByUnitAndUnitGroup_First(unitId, unitGroupId,
			orderByComparator);
	}

	/**
	* Returns the first titles department unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByUnitAndUnitGroup_First(
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUnitAndUnitGroup_First(unitId, unitGroupId,
			orderByComparator);
	}

	/**
	* Returns the last titles department unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByUnitAndUnitGroup_Last(
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByUnitAndUnitGroup_Last(unitId, unitGroupId,
			orderByComparator);
	}

	/**
	* Returns the last titles department unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByUnitAndUnitGroup_Last(
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUnitAndUnitGroup_Last(unitId, unitGroupId,
			orderByComparator);
	}

	/**
	* Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup[] findByUnitAndUnitGroup_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByUnitAndUnitGroup_PrevAndNext(titlesDepartmentUnitUnitGroupId,
			unitId, unitGroupId, orderByComparator);
	}

	/**
	* Removes all the titles department unit unit groups where unitId = &#63; and unitGroupId = &#63; from the database.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUnitAndUnitGroup(long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUnitAndUnitGroup(unitId, unitGroupId);
	}

	/**
	* Returns the number of titles department unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the number of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUnitAndUnitGroup(long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUnitAndUnitGroup(unitId, unitGroupId);
	}

	/**
	* Returns all the titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByTitlesDepartmentUnitNoneUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTitlesDepartmentUnitNoneUnitGroup(titlesId,
			departmentId, unitId, unitGroupId);
	}

	/**
	* Returns a range of all the titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @return the range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByTitlesDepartmentUnitNoneUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTitlesDepartmentUnitNoneUnitGroup(titlesId,
			departmentId, unitId, unitGroupId, start, end);
	}

	/**
	* Returns an ordered range of all the titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByTitlesDepartmentUnitNoneUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTitlesDepartmentUnitNoneUnitGroup(titlesId,
			departmentId, unitId, unitGroupId, start, end, orderByComparator);
	}

	/**
	* Returns the first titles department unit unit group in the ordered set where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByTitlesDepartmentUnitNoneUnitGroup_First(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByTitlesDepartmentUnitNoneUnitGroup_First(titlesId,
			departmentId, unitId, unitGroupId, orderByComparator);
	}

	/**
	* Returns the first titles department unit unit group in the ordered set where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByTitlesDepartmentUnitNoneUnitGroup_First(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTitlesDepartmentUnitNoneUnitGroup_First(titlesId,
			departmentId, unitId, unitGroupId, orderByComparator);
	}

	/**
	* Returns the last titles department unit unit group in the ordered set where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByTitlesDepartmentUnitNoneUnitGroup_Last(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByTitlesDepartmentUnitNoneUnitGroup_Last(titlesId,
			departmentId, unitId, unitGroupId, orderByComparator);
	}

	/**
	* Returns the last titles department unit unit group in the ordered set where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByTitlesDepartmentUnitNoneUnitGroup_Last(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTitlesDepartmentUnitNoneUnitGroup_Last(titlesId,
			departmentId, unitId, unitGroupId, orderByComparator);
	}

	/**
	* Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup[] findByTitlesDepartmentUnitNoneUnitGroup_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long titlesId, long departmentId,
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence()
				   .findByTitlesDepartmentUnitNoneUnitGroup_PrevAndNext(titlesDepartmentUnitUnitGroupId,
			titlesId, departmentId, unitId, unitGroupId, orderByComparator);
	}

	/**
	* Removes all the titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; from the database.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTitlesDepartmentUnitNoneUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByTitlesDepartmentUnitNoneUnitGroup(titlesId, departmentId,
			unitId, unitGroupId);
	}

	/**
	* Returns the number of titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the number of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTitlesDepartmentUnitNoneUnitGroup(long titlesId,
		long departmentId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTitlesDepartmentUnitNoneUnitGroup(titlesId,
			departmentId, unitId, unitGroupId);
	}

	/**
	* Caches the titles department unit unit group in the entity cache if it is enabled.
	*
	* @param titlesDepartmentUnitUnitGroup the titles department unit unit group
	*/
	public static void cacheResult(
		vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup) {
		getPersistence().cacheResult(titlesDepartmentUnitUnitGroup);
	}

	/**
	* Caches the titles department unit unit groups in the entity cache if it is enabled.
	*
	* @param titlesDepartmentUnitUnitGroups the titles department unit unit groups
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> titlesDepartmentUnitUnitGroups) {
		getPersistence().cacheResult(titlesDepartmentUnitUnitGroups);
	}

	/**
	* Creates a new titles department unit unit group with the primary key. Does not add the titles department unit unit group to the database.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key for the new titles department unit unit group
	* @return the new titles department unit unit group
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup create(
		long titlesDepartmentUnitUnitGroupId) {
		return getPersistence().create(titlesDepartmentUnitUnitGroupId);
	}

	/**
	* Removes the titles department unit unit group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the titles department unit unit group
	* @return the titles department unit unit group that was removed
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup remove(
		long titlesDepartmentUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence().remove(titlesDepartmentUnitUnitGroupId);
	}

	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup updateImpl(
		vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(titlesDepartmentUnitUnitGroup);
	}

	/**
	* Returns the titles department unit unit group with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException} if it could not be found.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the titles department unit unit group
	* @return the titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByPrimaryKey(
		long titlesDepartmentUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException {
		return getPersistence().findByPrimaryKey(titlesDepartmentUnitUnitGroupId);
	}

	/**
	* Returns the titles department unit unit group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the titles department unit unit group
	* @return the titles department unit unit group, or <code>null</code> if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByPrimaryKey(
		long titlesDepartmentUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPrimaryKey(titlesDepartmentUnitUnitGroupId);
	}

	/**
	* Returns all the titles department unit unit groups.
	*
	* @return the titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the titles department unit unit groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @return the range of titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the titles department unit unit groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the titles department unit unit groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of titles department unit unit groups.
	*
	* @return the number of titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TitlesDepartmentUnitUnitGroupPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TitlesDepartmentUnitUnitGroupPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					TitlesDepartmentUnitUnitGroupPersistence.class.getName());

			ReferenceRegistry.registerReference(TitlesDepartmentUnitUnitGroupUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		TitlesDepartmentUnitUnitGroupPersistence persistence) {
	}

	private static TitlesDepartmentUnitUnitGroupPersistence _persistence;
}