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

import vn.com.ecopharma.hrm.rc.model.CandidateActionHistory;

/**
 * The persistence interface for the candidate action history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see CandidateActionHistoryPersistenceImpl
 * @see CandidateActionHistoryUtil
 * @generated
 */
public interface CandidateActionHistoryPersistence extends BasePersistence<CandidateActionHistory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CandidateActionHistoryUtil} to access the candidate action history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the candidate action histories where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @return the matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidate(
		long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the candidate action histories where candidateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateId the candidate ID
	* @param start the lower bound of the range of candidate action histories
	* @param end the upper bound of the range of candidate action histories (not inclusive)
	* @return the range of matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidate(
		long candidateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the candidate action histories where candidateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateId the candidate ID
	* @param start the lower bound of the range of candidate action histories
	* @param end the upper bound of the range of candidate action histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidate(
		long candidateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first candidate action history in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate action history
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory findByCandidate_First(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException;

	/**
	* Returns the first candidate action history in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate action history, or <code>null</code> if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory fetchByCandidate_First(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last candidate action history in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate action history
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory findByCandidate_Last(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException;

	/**
	* Returns the last candidate action history in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate action history, or <code>null</code> if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory fetchByCandidate_Last(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the candidate action histories before and after the current candidate action history in the ordered set where candidateId = &#63;.
	*
	* @param candidateActionHistoryId the primary key of the current candidate action history
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate action history
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a candidate action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory[] findByCandidate_PrevAndNext(
		long candidateActionHistoryId, long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException;

	/**
	* Removes all the candidate action histories where candidateId = &#63; from the database.
	*
	* @param candidateId the candidate ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCandidate(long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of candidate action histories where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @return the number of matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCandidate(long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the candidate action histories where candidateId = &#63; and actionType = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @return the matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidateAndActionType(
		long candidateId, java.lang.String actionType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the candidate action histories where candidateId = &#63; and actionType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param start the lower bound of the range of candidate action histories
	* @param end the upper bound of the range of candidate action histories (not inclusive)
	* @return the range of matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidateAndActionType(
		long candidateId, java.lang.String actionType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the candidate action histories where candidateId = &#63; and actionType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param start the lower bound of the range of candidate action histories
	* @param end the upper bound of the range of candidate action histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidateAndActionType(
		long candidateId, java.lang.String actionType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first candidate action history in the ordered set where candidateId = &#63; and actionType = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate action history
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory findByCandidateAndActionType_First(
		long candidateId, java.lang.String actionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException;

	/**
	* Returns the first candidate action history in the ordered set where candidateId = &#63; and actionType = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate action history, or <code>null</code> if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory fetchByCandidateAndActionType_First(
		long candidateId, java.lang.String actionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last candidate action history in the ordered set where candidateId = &#63; and actionType = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate action history
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory findByCandidateAndActionType_Last(
		long candidateId, java.lang.String actionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException;

	/**
	* Returns the last candidate action history in the ordered set where candidateId = &#63; and actionType = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate action history, or <code>null</code> if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory fetchByCandidateAndActionType_Last(
		long candidateId, java.lang.String actionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the candidate action histories before and after the current candidate action history in the ordered set where candidateId = &#63; and actionType = &#63;.
	*
	* @param candidateActionHistoryId the primary key of the current candidate action history
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate action history
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a candidate action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory[] findByCandidateAndActionType_PrevAndNext(
		long candidateActionHistoryId, long candidateId,
		java.lang.String actionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException;

	/**
	* Removes all the candidate action histories where candidateId = &#63; and actionType = &#63; from the database.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCandidateAndActionType(long candidateId,
		java.lang.String actionType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of candidate action histories where candidateId = &#63; and actionType = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @return the number of matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCandidateAndActionType(long candidateId,
		java.lang.String actionType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the candidate action histories where candidateId = &#63; and actionType = &#63; and action = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param action the action
	* @return the matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidateAndActionTypeAndAction(
		long candidateId, java.lang.String actionType, java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the candidate action histories where candidateId = &#63; and actionType = &#63; and action = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param action the action
	* @param start the lower bound of the range of candidate action histories
	* @param end the upper bound of the range of candidate action histories (not inclusive)
	* @return the range of matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidateAndActionTypeAndAction(
		long candidateId, java.lang.String actionType, java.lang.String action,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the candidate action histories where candidateId = &#63; and actionType = &#63; and action = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param action the action
	* @param start the lower bound of the range of candidate action histories
	* @param end the upper bound of the range of candidate action histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidateAndActionTypeAndAction(
		long candidateId, java.lang.String actionType, java.lang.String action,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first candidate action history in the ordered set where candidateId = &#63; and actionType = &#63; and action = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param action the action
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate action history
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory findByCandidateAndActionTypeAndAction_First(
		long candidateId, java.lang.String actionType, java.lang.String action,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException;

	/**
	* Returns the first candidate action history in the ordered set where candidateId = &#63; and actionType = &#63; and action = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param action the action
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate action history, or <code>null</code> if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory fetchByCandidateAndActionTypeAndAction_First(
		long candidateId, java.lang.String actionType, java.lang.String action,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last candidate action history in the ordered set where candidateId = &#63; and actionType = &#63; and action = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param action the action
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate action history
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory findByCandidateAndActionTypeAndAction_Last(
		long candidateId, java.lang.String actionType, java.lang.String action,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException;

	/**
	* Returns the last candidate action history in the ordered set where candidateId = &#63; and actionType = &#63; and action = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param action the action
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate action history, or <code>null</code> if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory fetchByCandidateAndActionTypeAndAction_Last(
		long candidateId, java.lang.String actionType, java.lang.String action,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the candidate action histories before and after the current candidate action history in the ordered set where candidateId = &#63; and actionType = &#63; and action = &#63;.
	*
	* @param candidateActionHistoryId the primary key of the current candidate action history
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param action the action
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate action history
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a candidate action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory[] findByCandidateAndActionTypeAndAction_PrevAndNext(
		long candidateActionHistoryId, long candidateId,
		java.lang.String actionType, java.lang.String action,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException;

	/**
	* Removes all the candidate action histories where candidateId = &#63; and actionType = &#63; and action = &#63; from the database.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param action the action
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCandidateAndActionTypeAndAction(long candidateId,
		java.lang.String actionType, java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of candidate action histories where candidateId = &#63; and actionType = &#63; and action = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param action the action
	* @return the number of matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCandidateAndActionTypeAndAction(long candidateId,
		java.lang.String actionType, java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the candidate action history in the entity cache if it is enabled.
	*
	* @param candidateActionHistory the candidate action history
	*/
	public void cacheResult(
		vn.com.ecopharma.hrm.rc.model.CandidateActionHistory candidateActionHistory);

	/**
	* Caches the candidate action histories in the entity cache if it is enabled.
	*
	* @param candidateActionHistories the candidate action histories
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> candidateActionHistories);

	/**
	* Creates a new candidate action history with the primary key. Does not add the candidate action history to the database.
	*
	* @param candidateActionHistoryId the primary key for the new candidate action history
	* @return the new candidate action history
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory create(
		long candidateActionHistoryId);

	/**
	* Removes the candidate action history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateActionHistoryId the primary key of the candidate action history
	* @return the candidate action history that was removed
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a candidate action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory remove(
		long candidateActionHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException;

	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory updateImpl(
		vn.com.ecopharma.hrm.rc.model.CandidateActionHistory candidateActionHistory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the candidate action history with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException} if it could not be found.
	*
	* @param candidateActionHistoryId the primary key of the candidate action history
	* @return the candidate action history
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a candidate action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory findByPrimaryKey(
		long candidateActionHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException;

	/**
	* Returns the candidate action history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param candidateActionHistoryId the primary key of the candidate action history
	* @return the candidate action history, or <code>null</code> if a candidate action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory fetchByPrimaryKey(
		long candidateActionHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the candidate action histories.
	*
	* @return the candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the candidate action histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate action histories
	* @param end the upper bound of the range of candidate action histories (not inclusive)
	* @return the range of candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the candidate action histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate action histories
	* @param end the upper bound of the range of candidate action histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the candidate action histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of candidate action histories.
	*
	* @return the number of candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}