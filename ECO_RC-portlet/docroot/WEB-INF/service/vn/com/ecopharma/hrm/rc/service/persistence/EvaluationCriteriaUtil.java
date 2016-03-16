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

import vn.com.ecopharma.hrm.rc.model.EvaluationCriteria;

import java.util.List;

/**
 * The persistence utility for the evaluation criteria service. This utility wraps {@link EvaluationCriteriaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EvaluationCriteriaPersistence
 * @see EvaluationCriteriaPersistenceImpl
 * @generated
 */
public class EvaluationCriteriaUtil {
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
	public static void clearCache(EvaluationCriteria evaluationCriteria) {
		getPersistence().clearCache(evaluationCriteria);
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
	public static List<EvaluationCriteria> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EvaluationCriteria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EvaluationCriteria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EvaluationCriteria update(
		EvaluationCriteria evaluationCriteria) throws SystemException {
		return getPersistence().update(evaluationCriteria);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EvaluationCriteria update(
		EvaluationCriteria evaluationCriteria, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(evaluationCriteria, serviceContext);
	}

	/**
	* Returns all the evaluation criterias where type = &#63;.
	*
	* @param type the type
	* @return the matching evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteria> findByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type);
	}

	/**
	* Returns a range of all the evaluation criterias where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of evaluation criterias
	* @param end the upper bound of the range of evaluation criterias (not inclusive)
	* @return the range of matching evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteria> findByType(
		java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type, start, end);
	}

	/**
	* Returns an ordered range of all the evaluation criterias where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of evaluation criterias
	* @param end the upper bound of the range of evaluation criterias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteria> findByType(
		java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type, start, end, orderByComparator);
	}

	/**
	* Returns the first evaluation criteria in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evaluation criteria
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException if a matching evaluation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteria findByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException {
		return getPersistence().findByType_First(type, orderByComparator);
	}

	/**
	* Returns the first evaluation criteria in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evaluation criteria, or <code>null</code> if a matching evaluation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteria fetchByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_First(type, orderByComparator);
	}

	/**
	* Returns the last evaluation criteria in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evaluation criteria
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException if a matching evaluation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteria findByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException {
		return getPersistence().findByType_Last(type, orderByComparator);
	}

	/**
	* Returns the last evaluation criteria in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evaluation criteria, or <code>null</code> if a matching evaluation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteria fetchByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_Last(type, orderByComparator);
	}

	/**
	* Returns the evaluation criterias before and after the current evaluation criteria in the ordered set where type = &#63;.
	*
	* @param evaluationCriteriaId the primary key of the current evaluation criteria
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evaluation criteria
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException if a evaluation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteria[] findByType_PrevAndNext(
		long evaluationCriteriaId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException {
		return getPersistence()
				   .findByType_PrevAndNext(evaluationCriteriaId, type,
			orderByComparator);
	}

	/**
	* Removes all the evaluation criterias where type = &#63; from the database.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByType(type);
	}

	/**
	* Returns the number of evaluation criterias where type = &#63;.
	*
	* @param type the type
	* @return the number of matching evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public static int countByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByType(type);
	}

	/**
	* Returns the evaluation criteria where name = &#63; and type = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException} if it could not be found.
	*
	* @param name the name
	* @param type the type
	* @return the matching evaluation criteria
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException if a matching evaluation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteria findByNameAndType(
		java.lang.String name, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException {
		return getPersistence().findByNameAndType(name, type);
	}

	/**
	* Returns the evaluation criteria where name = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @param type the type
	* @return the matching evaluation criteria, or <code>null</code> if a matching evaluation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteria fetchByNameAndType(
		java.lang.String name, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNameAndType(name, type);
	}

	/**
	* Returns the evaluation criteria where name = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param type the type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching evaluation criteria, or <code>null</code> if a matching evaluation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteria fetchByNameAndType(
		java.lang.String name, java.lang.String type, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNameAndType(name, type, retrieveFromCache);
	}

	/**
	* Removes the evaluation criteria where name = &#63; and type = &#63; from the database.
	*
	* @param name the name
	* @param type the type
	* @return the evaluation criteria that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteria removeByNameAndType(
		java.lang.String name, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException {
		return getPersistence().removeByNameAndType(name, type);
	}

	/**
	* Returns the number of evaluation criterias where name = &#63; and type = &#63;.
	*
	* @param name the name
	* @param type the type
	* @return the number of matching evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNameAndType(java.lang.String name,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNameAndType(name, type);
	}

	/**
	* Caches the evaluation criteria in the entity cache if it is enabled.
	*
	* @param evaluationCriteria the evaluation criteria
	*/
	public static void cacheResult(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteria evaluationCriteria) {
		getPersistence().cacheResult(evaluationCriteria);
	}

	/**
	* Caches the evaluation criterias in the entity cache if it is enabled.
	*
	* @param evaluationCriterias the evaluation criterias
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteria> evaluationCriterias) {
		getPersistence().cacheResult(evaluationCriterias);
	}

	/**
	* Creates a new evaluation criteria with the primary key. Does not add the evaluation criteria to the database.
	*
	* @param evaluationCriteriaId the primary key for the new evaluation criteria
	* @return the new evaluation criteria
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteria create(
		long evaluationCriteriaId) {
		return getPersistence().create(evaluationCriteriaId);
	}

	/**
	* Removes the evaluation criteria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationCriteriaId the primary key of the evaluation criteria
	* @return the evaluation criteria that was removed
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException if a evaluation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteria remove(
		long evaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException {
		return getPersistence().remove(evaluationCriteriaId);
	}

	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteria updateImpl(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteria evaluationCriteria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(evaluationCriteria);
	}

	/**
	* Returns the evaluation criteria with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException} if it could not be found.
	*
	* @param evaluationCriteriaId the primary key of the evaluation criteria
	* @return the evaluation criteria
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException if a evaluation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteria findByPrimaryKey(
		long evaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException {
		return getPersistence().findByPrimaryKey(evaluationCriteriaId);
	}

	/**
	* Returns the evaluation criteria with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param evaluationCriteriaId the primary key of the evaluation criteria
	* @return the evaluation criteria, or <code>null</code> if a evaluation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteria fetchByPrimaryKey(
		long evaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(evaluationCriteriaId);
	}

	/**
	* Returns all the evaluation criterias.
	*
	* @return the evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteria> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the evaluation criterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of evaluation criterias
	* @param end the upper bound of the range of evaluation criterias (not inclusive)
	* @return the range of evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteria> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the evaluation criterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of evaluation criterias
	* @param end the upper bound of the range of evaluation criterias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the evaluation criterias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of evaluation criterias.
	*
	* @return the number of evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EvaluationCriteriaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EvaluationCriteriaPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.hrm.rc.service.ClpSerializer.getServletContextName(),
					EvaluationCriteriaPersistence.class.getName());

			ReferenceRegistry.registerReference(EvaluationCriteriaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EvaluationCriteriaPersistence persistence) {
	}

	private static EvaluationCriteriaPersistence _persistence;
}