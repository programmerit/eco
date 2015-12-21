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

import vn.com.ecopharma.hrm.rc.model.CandidateEvaluation;

import java.util.List;

/**
 * The persistence utility for the candidate evaluation service. This utility wraps {@link CandidateEvaluationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see CandidateEvaluationPersistence
 * @see CandidateEvaluationPersistenceImpl
 * @generated
 */
public class CandidateEvaluationUtil {
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
	public static void clearCache(CandidateEvaluation candidateEvaluation) {
		getPersistence().clearCache(candidateEvaluation);
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
	public static List<CandidateEvaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CandidateEvaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CandidateEvaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CandidateEvaluation update(
		CandidateEvaluation candidateEvaluation) throws SystemException {
		return getPersistence().update(candidateEvaluation);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CandidateEvaluation update(
		CandidateEvaluation candidateEvaluation, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(candidateEvaluation, serviceContext);
	}

	/**
	* Returns all the candidate evaluations where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @return the matching candidate evaluations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> findByCandidate(
		long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCandidate(candidateId);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> findByCandidate(
		long candidateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCandidate(candidateId, start, end);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> findByCandidate(
		long candidateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCandidate(candidateId, start, end, orderByComparator);
	}

	/**
	* Returns the first candidate evaluation in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate evaluation
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException if a matching candidate evaluation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateEvaluation findByCandidate_First(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException {
		return getPersistence()
				   .findByCandidate_First(candidateId, orderByComparator);
	}

	/**
	* Returns the first candidate evaluation in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate evaluation, or <code>null</code> if a matching candidate evaluation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateEvaluation fetchByCandidate_First(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCandidate_First(candidateId, orderByComparator);
	}

	/**
	* Returns the last candidate evaluation in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate evaluation
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException if a matching candidate evaluation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateEvaluation findByCandidate_Last(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException {
		return getPersistence()
				   .findByCandidate_Last(candidateId, orderByComparator);
	}

	/**
	* Returns the last candidate evaluation in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate evaluation, or <code>null</code> if a matching candidate evaluation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateEvaluation fetchByCandidate_Last(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCandidate_Last(candidateId, orderByComparator);
	}

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
	public static vn.com.ecopharma.hrm.rc.model.CandidateEvaluation[] findByCandidate_PrevAndNext(
		long candidateEvaluationId, long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException {
		return getPersistence()
				   .findByCandidate_PrevAndNext(candidateEvaluationId,
			candidateId, orderByComparator);
	}

	/**
	* Removes all the candidate evaluations where candidateId = &#63; from the database.
	*
	* @param candidateId the candidate ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCandidate(long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCandidate(candidateId);
	}

	/**
	* Returns the number of candidate evaluations where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @return the number of matching candidate evaluations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCandidate(long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCandidate(candidateId);
	}

	/**
	* Caches the candidate evaluation in the entity cache if it is enabled.
	*
	* @param candidateEvaluation the candidate evaluation
	*/
	public static void cacheResult(
		vn.com.ecopharma.hrm.rc.model.CandidateEvaluation candidateEvaluation) {
		getPersistence().cacheResult(candidateEvaluation);
	}

	/**
	* Caches the candidate evaluations in the entity cache if it is enabled.
	*
	* @param candidateEvaluations the candidate evaluations
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> candidateEvaluations) {
		getPersistence().cacheResult(candidateEvaluations);
	}

	/**
	* Creates a new candidate evaluation with the primary key. Does not add the candidate evaluation to the database.
	*
	* @param candidateEvaluationId the primary key for the new candidate evaluation
	* @return the new candidate evaluation
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateEvaluation create(
		long candidateEvaluationId) {
		return getPersistence().create(candidateEvaluationId);
	}

	/**
	* Removes the candidate evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateEvaluationId the primary key of the candidate evaluation
	* @return the candidate evaluation that was removed
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateEvaluation remove(
		long candidateEvaluationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException {
		return getPersistence().remove(candidateEvaluationId);
	}

	public static vn.com.ecopharma.hrm.rc.model.CandidateEvaluation updateImpl(
		vn.com.ecopharma.hrm.rc.model.CandidateEvaluation candidateEvaluation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(candidateEvaluation);
	}

	/**
	* Returns the candidate evaluation with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException} if it could not be found.
	*
	* @param candidateEvaluationId the primary key of the candidate evaluation
	* @return the candidate evaluation
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateEvaluation findByPrimaryKey(
		long candidateEvaluationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException {
		return getPersistence().findByPrimaryKey(candidateEvaluationId);
	}

	/**
	* Returns the candidate evaluation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param candidateEvaluationId the primary key of the candidate evaluation
	* @return the candidate evaluation, or <code>null</code> if a candidate evaluation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateEvaluation fetchByPrimaryKey(
		long candidateEvaluationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(candidateEvaluationId);
	}

	/**
	* Returns all the candidate evaluations.
	*
	* @return the candidate evaluations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the candidate evaluations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of candidate evaluations.
	*
	* @return the number of candidate evaluations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CandidateEvaluationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CandidateEvaluationPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.hrm.rc.service.ClpSerializer.getServletContextName(),
					CandidateEvaluationPersistence.class.getName());

			ReferenceRegistry.registerReference(CandidateEvaluationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CandidateEvaluationPersistence persistence) {
	}

	private static CandidateEvaluationPersistence _persistence;
}