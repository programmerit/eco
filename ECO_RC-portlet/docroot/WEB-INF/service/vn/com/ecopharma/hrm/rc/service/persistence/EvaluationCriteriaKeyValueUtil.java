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

import vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue;

import java.util.List;

/**
 * The persistence utility for the evaluation criteria key value service. This utility wraps {@link EvaluationCriteriaKeyValuePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EvaluationCriteriaKeyValuePersistence
 * @see EvaluationCriteriaKeyValuePersistenceImpl
 * @generated
 */
public class EvaluationCriteriaKeyValueUtil {
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
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue) {
		getPersistence().clearCache(evaluationCriteriaKeyValue);
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
	public static List<EvaluationCriteriaKeyValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EvaluationCriteriaKeyValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EvaluationCriteriaKeyValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EvaluationCriteriaKeyValue update(
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue)
		throws SystemException {
		return getPersistence().update(evaluationCriteriaKeyValue);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EvaluationCriteriaKeyValue update(
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(evaluationCriteriaKeyValue, serviceContext);
	}

	/**
	* Returns all the evaluation criteria key values where evaluationCriteriaId = &#63;.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @return the matching evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> findByEvaluationCriteria(
		long evaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEvaluationCriteria(evaluationCriteriaId);
	}

	/**
	* Returns a range of all the evaluation criteria key values where evaluationCriteriaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaKeyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param start the lower bound of the range of evaluation criteria key values
	* @param end the upper bound of the range of evaluation criteria key values (not inclusive)
	* @return the range of matching evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> findByEvaluationCriteria(
		long evaluationCriteriaId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEvaluationCriteria(evaluationCriteriaId, start, end);
	}

	/**
	* Returns an ordered range of all the evaluation criteria key values where evaluationCriteriaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaKeyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param start the lower bound of the range of evaluation criteria key values
	* @param end the upper bound of the range of evaluation criteria key values (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> findByEvaluationCriteria(
		long evaluationCriteriaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEvaluationCriteria(evaluationCriteriaId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first evaluation criteria key value in the ordered set where evaluationCriteriaId = &#63;.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evaluation criteria key value
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a matching evaluation criteria key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue findByEvaluationCriteria_First(
		long evaluationCriteriaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException {
		return getPersistence()
				   .findByEvaluationCriteria_First(evaluationCriteriaId,
			orderByComparator);
	}

	/**
	* Returns the first evaluation criteria key value in the ordered set where evaluationCriteriaId = &#63;.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evaluation criteria key value, or <code>null</code> if a matching evaluation criteria key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue fetchByEvaluationCriteria_First(
		long evaluationCriteriaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEvaluationCriteria_First(evaluationCriteriaId,
			orderByComparator);
	}

	/**
	* Returns the last evaluation criteria key value in the ordered set where evaluationCriteriaId = &#63;.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evaluation criteria key value
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a matching evaluation criteria key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue findByEvaluationCriteria_Last(
		long evaluationCriteriaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException {
		return getPersistence()
				   .findByEvaluationCriteria_Last(evaluationCriteriaId,
			orderByComparator);
	}

	/**
	* Returns the last evaluation criteria key value in the ordered set where evaluationCriteriaId = &#63;.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evaluation criteria key value, or <code>null</code> if a matching evaluation criteria key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue fetchByEvaluationCriteria_Last(
		long evaluationCriteriaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEvaluationCriteria_Last(evaluationCriteriaId,
			orderByComparator);
	}

	/**
	* Returns the evaluation criteria key values before and after the current evaluation criteria key value in the ordered set where evaluationCriteriaId = &#63;.
	*
	* @param evaluationCriteriaKeyValueId the primary key of the current evaluation criteria key value
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next evaluation criteria key value
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a evaluation criteria key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue[] findByEvaluationCriteria_PrevAndNext(
		long evaluationCriteriaKeyValueId, long evaluationCriteriaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException {
		return getPersistence()
				   .findByEvaluationCriteria_PrevAndNext(evaluationCriteriaKeyValueId,
			evaluationCriteriaId, orderByComparator);
	}

	/**
	* Removes all the evaluation criteria key values where evaluationCriteriaId = &#63; from the database.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEvaluationCriteria(long evaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEvaluationCriteria(evaluationCriteriaId);
	}

	/**
	* Returns the number of evaluation criteria key values where evaluationCriteriaId = &#63;.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @return the number of matching evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEvaluationCriteria(long evaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEvaluationCriteria(evaluationCriteriaId);
	}

	/**
	* Returns the evaluation criteria key value where evaluationCriteriaId = &#63; and key = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException} if it could not be found.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param key the key
	* @return the matching evaluation criteria key value
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a matching evaluation criteria key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue findByEvaluationCriteriaAndKey(
		long evaluationCriteriaId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException {
		return getPersistence()
				   .findByEvaluationCriteriaAndKey(evaluationCriteriaId, key);
	}

	/**
	* Returns the evaluation criteria key value where evaluationCriteriaId = &#63; and key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param key the key
	* @return the matching evaluation criteria key value, or <code>null</code> if a matching evaluation criteria key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue fetchByEvaluationCriteriaAndKey(
		long evaluationCriteriaId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEvaluationCriteriaAndKey(evaluationCriteriaId, key);
	}

	/**
	* Returns the evaluation criteria key value where evaluationCriteriaId = &#63; and key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param key the key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching evaluation criteria key value, or <code>null</code> if a matching evaluation criteria key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue fetchByEvaluationCriteriaAndKey(
		long evaluationCriteriaId, java.lang.String key,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEvaluationCriteriaAndKey(evaluationCriteriaId, key,
			retrieveFromCache);
	}

	/**
	* Removes the evaluation criteria key value where evaluationCriteriaId = &#63; and key = &#63; from the database.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param key the key
	* @return the evaluation criteria key value that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue removeByEvaluationCriteriaAndKey(
		long evaluationCriteriaId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException {
		return getPersistence()
				   .removeByEvaluationCriteriaAndKey(evaluationCriteriaId, key);
	}

	/**
	* Returns the number of evaluation criteria key values where evaluationCriteriaId = &#63; and key = &#63;.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param key the key
	* @return the number of matching evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEvaluationCriteriaAndKey(
		long evaluationCriteriaId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByEvaluationCriteriaAndKey(evaluationCriteriaId, key);
	}

	/**
	* Caches the evaluation criteria key value in the entity cache if it is enabled.
	*
	* @param evaluationCriteriaKeyValue the evaluation criteria key value
	*/
	public static void cacheResult(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue evaluationCriteriaKeyValue) {
		getPersistence().cacheResult(evaluationCriteriaKeyValue);
	}

	/**
	* Caches the evaluation criteria key values in the entity cache if it is enabled.
	*
	* @param evaluationCriteriaKeyValues the evaluation criteria key values
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> evaluationCriteriaKeyValues) {
		getPersistence().cacheResult(evaluationCriteriaKeyValues);
	}

	/**
	* Creates a new evaluation criteria key value with the primary key. Does not add the evaluation criteria key value to the database.
	*
	* @param evaluationCriteriaKeyValueId the primary key for the new evaluation criteria key value
	* @return the new evaluation criteria key value
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue create(
		long evaluationCriteriaKeyValueId) {
		return getPersistence().create(evaluationCriteriaKeyValueId);
	}

	/**
	* Removes the evaluation criteria key value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationCriteriaKeyValueId the primary key of the evaluation criteria key value
	* @return the evaluation criteria key value that was removed
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a evaluation criteria key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue remove(
		long evaluationCriteriaKeyValueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException {
		return getPersistence().remove(evaluationCriteriaKeyValueId);
	}

	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue updateImpl(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue evaluationCriteriaKeyValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(evaluationCriteriaKeyValue);
	}

	/**
	* Returns the evaluation criteria key value with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException} if it could not be found.
	*
	* @param evaluationCriteriaKeyValueId the primary key of the evaluation criteria key value
	* @return the evaluation criteria key value
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a evaluation criteria key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue findByPrimaryKey(
		long evaluationCriteriaKeyValueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException {
		return getPersistence().findByPrimaryKey(evaluationCriteriaKeyValueId);
	}

	/**
	* Returns the evaluation criteria key value with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param evaluationCriteriaKeyValueId the primary key of the evaluation criteria key value
	* @return the evaluation criteria key value, or <code>null</code> if a evaluation criteria key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue fetchByPrimaryKey(
		long evaluationCriteriaKeyValueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(evaluationCriteriaKeyValueId);
	}

	/**
	* Returns all the evaluation criteria key values.
	*
	* @return the evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the evaluation criteria key values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaKeyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of evaluation criteria key values
	* @param end the upper bound of the range of evaluation criteria key values (not inclusive)
	* @return the range of evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the evaluation criteria key values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaKeyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of evaluation criteria key values
	* @param end the upper bound of the range of evaluation criteria key values (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the evaluation criteria key values from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of evaluation criteria key values.
	*
	* @return the number of evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EvaluationCriteriaKeyValuePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EvaluationCriteriaKeyValuePersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.hrm.rc.service.ClpSerializer.getServletContextName(),
					EvaluationCriteriaKeyValuePersistence.class.getName());

			ReferenceRegistry.registerReference(EvaluationCriteriaKeyValueUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		EvaluationCriteriaKeyValuePersistence persistence) {
	}

	private static EvaluationCriteriaKeyValuePersistence _persistence;
}