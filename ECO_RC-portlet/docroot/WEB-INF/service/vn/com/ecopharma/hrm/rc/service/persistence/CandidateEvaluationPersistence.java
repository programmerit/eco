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

import vn.com.ecopharma.hrm.rc.model.CandidateEvaluation;

/**
 * The persistence interface for the candidate evaluation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see CandidateEvaluationPersistenceImpl
 * @see CandidateEvaluationUtil
 * @generated
 */
public interface CandidateEvaluationPersistence extends BasePersistence<CandidateEvaluation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CandidateEvaluationUtil} to access the candidate evaluation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the candidate evaluations where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @return the matching candidate evaluations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> findByCandidate(
		long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the candidate evaluations where candidateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateId the candidate ID
	* @param start the lower bound of the range of candidate evaluations
	* @param end the upper bound of the range of candidate evaluations (not inclusive)
	* @return the range of matching candidate evaluations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> findByCandidate(
		long candidateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the candidate evaluations where candidateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateId the candidate ID
	* @param start the lower bound of the range of candidate evaluations
	* @param end the upper bound of the range of candidate evaluations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate evaluations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> findByCandidate(
		long candidateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first candidate evaluation in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate evaluation
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException if a matching candidate evaluation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation findByCandidate_First(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException;

	/**
	* Returns the first candidate evaluation in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate evaluation, or <code>null</code> if a matching candidate evaluation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation fetchByCandidate_First(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last candidate evaluation in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate evaluation
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException if a matching candidate evaluation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation findByCandidate_Last(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException;

	/**
	* Returns the last candidate evaluation in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate evaluation, or <code>null</code> if a matching candidate evaluation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation fetchByCandidate_Last(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the candidate evaluations before and after the current candidate evaluation in the ordered set where candidateId = &#63;.
	*
	* @param candidateEvaluationId the primary key of the current candidate evaluation
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate evaluation
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation[] findByCandidate_PrevAndNext(
		long candidateEvaluationId, long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException;

	/**
	* Removes all the candidate evaluations where candidateId = &#63; from the database.
	*
	* @param candidateId the candidate ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCandidate(long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of candidate evaluations where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @return the number of matching candidate evaluations
	* @throws SystemException if a system exception occurred
	*/
	public int countByCandidate(long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the candidate evaluation in the entity cache if it is enabled.
	*
	* @param candidateEvaluation the candidate evaluation
	*/
	public void cacheResult(
		vn.com.ecopharma.hrm.rc.model.CandidateEvaluation candidateEvaluation);

	/**
	* Caches the candidate evaluations in the entity cache if it is enabled.
	*
	* @param candidateEvaluations the candidate evaluations
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> candidateEvaluations);

	/**
	* Creates a new candidate evaluation with the primary key. Does not add the candidate evaluation to the database.
	*
	* @param candidateEvaluationId the primary key for the new candidate evaluation
	* @return the new candidate evaluation
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation create(
		long candidateEvaluationId);

	/**
	* Removes the candidate evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateEvaluationId the primary key of the candidate evaluation
	* @return the candidate evaluation that was removed
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation remove(
		long candidateEvaluationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException;

	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation updateImpl(
		vn.com.ecopharma.hrm.rc.model.CandidateEvaluation candidateEvaluation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the candidate evaluation with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException} if it could not be found.
	*
	* @param candidateEvaluationId the primary key of the candidate evaluation
	* @return the candidate evaluation
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation findByPrimaryKey(
		long candidateEvaluationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException;

	/**
	* Returns the candidate evaluation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param candidateEvaluationId the primary key of the candidate evaluation
	* @return the candidate evaluation, or <code>null</code> if a candidate evaluation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation fetchByPrimaryKey(
		long candidateEvaluationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the candidate evaluations.
	*
	* @return the candidate evaluations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the candidate evaluations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate evaluations
	* @param end the upper bound of the range of candidate evaluations (not inclusive)
	* @return the range of candidate evaluations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the candidate evaluations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate evaluations
	* @param end the upper bound of the range of candidate evaluations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of candidate evaluations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the candidate evaluations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of candidate evaluations.
	*
	* @return the number of candidate evaluations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}