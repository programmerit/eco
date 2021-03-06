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

import vn.com.ecopharma.hrm.rc.model.CandidateActionHistory;

import java.util.List;

/**
 * The persistence utility for the candidate action history service. This utility wraps {@link CandidateActionHistoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see CandidateActionHistoryPersistence
 * @see CandidateActionHistoryPersistenceImpl
 * @generated
 */
public class CandidateActionHistoryUtil {
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
	public static void clearCache(CandidateActionHistory candidateActionHistory) {
		getPersistence().clearCache(candidateActionHistory);
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
	public static List<CandidateActionHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CandidateActionHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CandidateActionHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CandidateActionHistory update(
		CandidateActionHistory candidateActionHistory)
		throws SystemException {
		return getPersistence().update(candidateActionHistory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CandidateActionHistory update(
		CandidateActionHistory candidateActionHistory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(candidateActionHistory, serviceContext);
	}

	/**
	* Returns all the candidate action histories where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @return the matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidate(
		long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCandidate(candidateId);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidate(
		long candidateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCandidate(candidateId, start, end);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidate(
		long candidateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCandidate(candidateId, start, end, orderByComparator);
	}

	/**
	* Returns the first candidate action history in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate action history
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory findByCandidate_First(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException {
		return getPersistence()
				   .findByCandidate_First(candidateId, orderByComparator);
	}

	/**
	* Returns the first candidate action history in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate action history, or <code>null</code> if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory fetchByCandidate_First(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCandidate_First(candidateId, orderByComparator);
	}

	/**
	* Returns the last candidate action history in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate action history
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory findByCandidate_Last(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException {
		return getPersistence()
				   .findByCandidate_Last(candidateId, orderByComparator);
	}

	/**
	* Returns the last candidate action history in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate action history, or <code>null</code> if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory fetchByCandidate_Last(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCandidate_Last(candidateId, orderByComparator);
	}

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
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory[] findByCandidate_PrevAndNext(
		long candidateActionHistoryId, long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException {
		return getPersistence()
				   .findByCandidate_PrevAndNext(candidateActionHistoryId,
			candidateId, orderByComparator);
	}

	/**
	* Removes all the candidate action histories where candidateId = &#63; from the database.
	*
	* @param candidateId the candidate ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCandidate(long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCandidate(candidateId);
	}

	/**
	* Returns the number of candidate action histories where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @return the number of matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCandidate(long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCandidate(candidateId);
	}

	/**
	* Returns all the candidate action histories where candidateId = &#63; and actionType = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @return the matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidateAndActionType(
		long candidateId, java.lang.String actionType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCandidateAndActionType(candidateId, actionType);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidateAndActionType(
		long candidateId, java.lang.String actionType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCandidateAndActionType(candidateId, actionType,
			start, end);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidateAndActionType(
		long candidateId, java.lang.String actionType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCandidateAndActionType(candidateId, actionType,
			start, end, orderByComparator);
	}

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
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory findByCandidateAndActionType_First(
		long candidateId, java.lang.String actionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException {
		return getPersistence()
				   .findByCandidateAndActionType_First(candidateId, actionType,
			orderByComparator);
	}

	/**
	* Returns the first candidate action history in the ordered set where candidateId = &#63; and actionType = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate action history, or <code>null</code> if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory fetchByCandidateAndActionType_First(
		long candidateId, java.lang.String actionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCandidateAndActionType_First(candidateId,
			actionType, orderByComparator);
	}

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
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory findByCandidateAndActionType_Last(
		long candidateId, java.lang.String actionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException {
		return getPersistence()
				   .findByCandidateAndActionType_Last(candidateId, actionType,
			orderByComparator);
	}

	/**
	* Returns the last candidate action history in the ordered set where candidateId = &#63; and actionType = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate action history, or <code>null</code> if a matching candidate action history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory fetchByCandidateAndActionType_Last(
		long candidateId, java.lang.String actionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCandidateAndActionType_Last(candidateId, actionType,
			orderByComparator);
	}

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
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory[] findByCandidateAndActionType_PrevAndNext(
		long candidateActionHistoryId, long candidateId,
		java.lang.String actionType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException {
		return getPersistence()
				   .findByCandidateAndActionType_PrevAndNext(candidateActionHistoryId,
			candidateId, actionType, orderByComparator);
	}

	/**
	* Removes all the candidate action histories where candidateId = &#63; and actionType = &#63; from the database.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCandidateAndActionType(long candidateId,
		java.lang.String actionType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCandidateAndActionType(candidateId, actionType);
	}

	/**
	* Returns the number of candidate action histories where candidateId = &#63; and actionType = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @return the number of matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCandidateAndActionType(long candidateId,
		java.lang.String actionType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCandidateAndActionType(candidateId, actionType);
	}

	/**
	* Returns all the candidate action histories where candidateId = &#63; and actionType = &#63; and action = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param action the action
	* @return the matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidateAndActionTypeAndAction(
		long candidateId, java.lang.String actionType, java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCandidateAndActionTypeAndAction(candidateId,
			actionType, action);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidateAndActionTypeAndAction(
		long candidateId, java.lang.String actionType, java.lang.String action,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCandidateAndActionTypeAndAction(candidateId,
			actionType, action, start, end);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidateAndActionTypeAndAction(
		long candidateId, java.lang.String actionType, java.lang.String action,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCandidateAndActionTypeAndAction(candidateId,
			actionType, action, start, end, orderByComparator);
	}

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
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory findByCandidateAndActionTypeAndAction_First(
		long candidateId, java.lang.String actionType, java.lang.String action,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException {
		return getPersistence()
				   .findByCandidateAndActionTypeAndAction_First(candidateId,
			actionType, action, orderByComparator);
	}

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
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory fetchByCandidateAndActionTypeAndAction_First(
		long candidateId, java.lang.String actionType, java.lang.String action,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCandidateAndActionTypeAndAction_First(candidateId,
			actionType, action, orderByComparator);
	}

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
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory findByCandidateAndActionTypeAndAction_Last(
		long candidateId, java.lang.String actionType, java.lang.String action,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException {
		return getPersistence()
				   .findByCandidateAndActionTypeAndAction_Last(candidateId,
			actionType, action, orderByComparator);
	}

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
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory fetchByCandidateAndActionTypeAndAction_Last(
		long candidateId, java.lang.String actionType, java.lang.String action,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCandidateAndActionTypeAndAction_Last(candidateId,
			actionType, action, orderByComparator);
	}

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
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory[] findByCandidateAndActionTypeAndAction_PrevAndNext(
		long candidateActionHistoryId, long candidateId,
		java.lang.String actionType, java.lang.String action,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException {
		return getPersistence()
				   .findByCandidateAndActionTypeAndAction_PrevAndNext(candidateActionHistoryId,
			candidateId, actionType, action, orderByComparator);
	}

	/**
	* Removes all the candidate action histories where candidateId = &#63; and actionType = &#63; and action = &#63; from the database.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param action the action
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCandidateAndActionTypeAndAction(
		long candidateId, java.lang.String actionType, java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCandidateAndActionTypeAndAction(candidateId, actionType,
			action);
	}

	/**
	* Returns the number of candidate action histories where candidateId = &#63; and actionType = &#63; and action = &#63;.
	*
	* @param candidateId the candidate ID
	* @param actionType the action type
	* @param action the action
	* @return the number of matching candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCandidateAndActionTypeAndAction(long candidateId,
		java.lang.String actionType, java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCandidateAndActionTypeAndAction(candidateId,
			actionType, action);
	}

	/**
	* Caches the candidate action history in the entity cache if it is enabled.
	*
	* @param candidateActionHistory the candidate action history
	*/
	public static void cacheResult(
		vn.com.ecopharma.hrm.rc.model.CandidateActionHistory candidateActionHistory) {
		getPersistence().cacheResult(candidateActionHistory);
	}

	/**
	* Caches the candidate action histories in the entity cache if it is enabled.
	*
	* @param candidateActionHistories the candidate action histories
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> candidateActionHistories) {
		getPersistence().cacheResult(candidateActionHistories);
	}

	/**
	* Creates a new candidate action history with the primary key. Does not add the candidate action history to the database.
	*
	* @param candidateActionHistoryId the primary key for the new candidate action history
	* @return the new candidate action history
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory create(
		long candidateActionHistoryId) {
		return getPersistence().create(candidateActionHistoryId);
	}

	/**
	* Removes the candidate action history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateActionHistoryId the primary key of the candidate action history
	* @return the candidate action history that was removed
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a candidate action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory remove(
		long candidateActionHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException {
		return getPersistence().remove(candidateActionHistoryId);
	}

	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory updateImpl(
		vn.com.ecopharma.hrm.rc.model.CandidateActionHistory candidateActionHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(candidateActionHistory);
	}

	/**
	* Returns the candidate action history with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException} if it could not be found.
	*
	* @param candidateActionHistoryId the primary key of the candidate action history
	* @return the candidate action history
	* @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a candidate action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory findByPrimaryKey(
		long candidateActionHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException {
		return getPersistence().findByPrimaryKey(candidateActionHistoryId);
	}

	/**
	* Returns the candidate action history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param candidateActionHistoryId the primary key of the candidate action history
	* @return the candidate action history, or <code>null</code> if a candidate action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.CandidateActionHistory fetchByPrimaryKey(
		long candidateActionHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(candidateActionHistoryId);
	}

	/**
	* Returns all the candidate action histories.
	*
	* @return the candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the candidate action histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of candidate action histories.
	*
	* @return the number of candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CandidateActionHistoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CandidateActionHistoryPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.hrm.rc.service.ClpSerializer.getServletContextName(),
					CandidateActionHistoryPersistence.class.getName());

			ReferenceRegistry.registerReference(CandidateActionHistoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CandidateActionHistoryPersistence persistence) {
	}

	private static CandidateActionHistoryPersistence _persistence;
}