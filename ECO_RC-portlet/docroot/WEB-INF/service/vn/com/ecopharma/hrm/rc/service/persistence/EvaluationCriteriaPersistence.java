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

import vn.com.ecopharma.hrm.rc.model.EvaluationCriteria;

/**
 * The persistence interface for the evaluation criteria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EvaluationCriteriaPersistenceImpl
 * @see EvaluationCriteriaUtil
 * @generated
 */
public interface EvaluationCriteriaPersistence extends BasePersistence<EvaluationCriteria> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EvaluationCriteriaUtil} to access the evaluation criteria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the evaluation criteria where type = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException} if it could not be found.
	*
	* @param type the type
	* @return the matching evaluation criteria
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException if a matching evaluation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria findByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException;

	/**
	* Returns the evaluation criteria where type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param type the type
	* @return the matching evaluation criteria, or <code>null</code> if a matching evaluation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria fetchByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evaluation criteria where type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param type the type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching evaluation criteria, or <code>null</code> if a matching evaluation criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria fetchByType(
		java.lang.String type, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the evaluation criteria where type = &#63; from the database.
	*
	* @param type the type
	* @return the evaluation criteria that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria removeByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException;

	/**
	* Returns the number of evaluation criterias where type = &#63;.
	*
	* @param type the type
	* @return the number of matching evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public int countByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the evaluation criteria in the entity cache if it is enabled.
	*
	* @param evaluationCriteria the evaluation criteria
	*/
	public void cacheResult(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteria evaluationCriteria);

	/**
	* Caches the evaluation criterias in the entity cache if it is enabled.
	*
	* @param evaluationCriterias the evaluation criterias
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteria> evaluationCriterias);

	/**
	* Creates a new evaluation criteria with the primary key. Does not add the evaluation criteria to the database.
	*
	* @param evaluationCriteriaId the primary key for the new evaluation criteria
	* @return the new evaluation criteria
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria create(
		long evaluationCriteriaId);

	/**
	* Removes the evaluation criteria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationCriteriaId the primary key of the evaluation criteria
	* @return the evaluation criteria that was removed
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException if a evaluation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria remove(
		long evaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException;

	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria updateImpl(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteria evaluationCriteria)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the evaluation criteria with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException} if it could not be found.
	*
	* @param evaluationCriteriaId the primary key of the evaluation criteria
	* @return the evaluation criteria
	* @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException if a evaluation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria findByPrimaryKey(
		long evaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException;

	/**
	* Returns the evaluation criteria with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param evaluationCriteriaId the primary key of the evaluation criteria
	* @return the evaluation criteria, or <code>null</code> if a evaluation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria fetchByPrimaryKey(
		long evaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the evaluation criterias.
	*
	* @return the evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteria> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteria> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the evaluation criterias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of evaluation criterias.
	*
	* @return the number of evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}