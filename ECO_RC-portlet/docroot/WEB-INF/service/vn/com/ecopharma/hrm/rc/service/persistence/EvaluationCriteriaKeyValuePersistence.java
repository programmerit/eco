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

import com.liferay.portal.service.persistence.BasePersistence;

import vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue;

/**
 * The persistence interface for the evaluation criteria key value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EvaluationCriteriaKeyValuePersistenceImpl
 * @see EvaluationCriteriaKeyValueUtil
 * @generated
 */
public interface EvaluationCriteriaKeyValuePersistence extends BasePersistence<EvaluationCriteriaKeyValue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EvaluationCriteriaKeyValueUtil} to access the evaluation criteria key value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the evaluation criteria key values where evaluationCriteriaId = &#63;.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @return the matching evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> findByEvaluationCriteria(
		long evaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> findByEvaluationCriteria(
		long evaluationCriteriaId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> findByEvaluationCriteria(
		long evaluationCriteriaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first evaluation criteria key value in the ordered set where evaluationCriteriaId = &#63;.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evaluation criteria key value
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a matching evaluation criteria key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue findByEvaluationCriteria_First(
		long evaluationCriteriaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException;

	/**
	* Returns the first evaluation criteria key value in the ordered set where evaluationCriteriaId = &#63;.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching evaluation criteria key value, or <code>null</code> if a matching evaluation criteria key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue fetchByEvaluationCriteria_First(
		long evaluationCriteriaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last evaluation criteria key value in the ordered set where evaluationCriteriaId = &#63;.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evaluation criteria key value
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a matching evaluation criteria key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue findByEvaluationCriteria_Last(
		long evaluationCriteriaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException;

	/**
	* Returns the last evaluation criteria key value in the ordered set where evaluationCriteriaId = &#63;.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching evaluation criteria key value, or <code>null</code> if a matching evaluation criteria key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue fetchByEvaluationCriteria_Last(
		long evaluationCriteriaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue[] findByEvaluationCriteria_PrevAndNext(
		long evaluationCriteriaKeyValueId, long evaluationCriteriaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException;

	/**
	* Removes all the evaluation criteria key values where evaluationCriteriaId = &#63; from the database.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEvaluationCriteria(long evaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evaluation criteria key values where evaluationCriteriaId = &#63;.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @return the number of matching evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	public int countByEvaluationCriteria(long evaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evaluation criteria key value where evaluationCriteriaId = &#63; and key = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException} if it could not be found.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param key the key
	* @return the matching evaluation criteria key value
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a matching evaluation criteria key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue findByEvaluationCriteriaAndKey(
		long evaluationCriteriaId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException;

	/**
	* Returns the evaluation criteria key value where evaluationCriteriaId = &#63; and key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param key the key
	* @return the matching evaluation criteria key value, or <code>null</code> if a matching evaluation criteria key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue fetchByEvaluationCriteriaAndKey(
		long evaluationCriteriaId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evaluation criteria key value where evaluationCriteriaId = &#63; and key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param key the key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching evaluation criteria key value, or <code>null</code> if a matching evaluation criteria key value could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue fetchByEvaluationCriteriaAndKey(
		long evaluationCriteriaId, java.lang.String key,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the evaluation criteria key value where evaluationCriteriaId = &#63; and key = &#63; from the database.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param key the key
	* @return the evaluation criteria key value that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue removeByEvaluationCriteriaAndKey(
		long evaluationCriteriaId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException;

	/**
	* Returns the number of evaluation criteria key values where evaluationCriteriaId = &#63; and key = &#63;.
	*
	* @param evaluationCriteriaId the evaluation criteria ID
	* @param key the key
	* @return the number of matching evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	public int countByEvaluationCriteriaAndKey(long evaluationCriteriaId,
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the evaluation criteria key value in the entity cache if it is enabled.
	*
	* @param evaluationCriteriaKeyValue the evaluation criteria key value
	*/
	public void cacheResult(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue evaluationCriteriaKeyValue);

	/**
	* Caches the evaluation criteria key values in the entity cache if it is enabled.
	*
	* @param evaluationCriteriaKeyValues the evaluation criteria key values
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> evaluationCriteriaKeyValues);

	/**
	* Creates a new evaluation criteria key value with the primary key. Does not add the evaluation criteria key value to the database.
	*
	* @param evaluationCriteriaKeyValueId the primary key for the new evaluation criteria key value
	* @return the new evaluation criteria key value
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue create(
		long evaluationCriteriaKeyValueId);

	/**
	* Removes the evaluation criteria key value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationCriteriaKeyValueId the primary key of the evaluation criteria key value
	* @return the evaluation criteria key value that was removed
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a evaluation criteria key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue remove(
		long evaluationCriteriaKeyValueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException;

	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue updateImpl(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue evaluationCriteriaKeyValue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evaluation criteria key value with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException} if it could not be found.
	*
	* @param evaluationCriteriaKeyValueId the primary key of the evaluation criteria key value
	* @return the evaluation criteria key value
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a evaluation criteria key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue findByPrimaryKey(
		long evaluationCriteriaKeyValueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException;

	/**
	* Returns the evaluation criteria key value with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param evaluationCriteriaKeyValueId the primary key of the evaluation criteria key value
	* @return the evaluation criteria key value, or <code>null</code> if a evaluation criteria key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue fetchByPrimaryKey(
		long evaluationCriteriaKeyValueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the evaluation criteria key values.
	*
	* @return the evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evaluation criteria key values from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evaluation criteria key values.
	*
	* @return the number of evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}