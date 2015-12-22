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

import com.liferay.portal.service.persistence.BasePersistence;

import vn.com.ecopharma.emp.model.PromotedHistory;

/**
 * The persistence interface for the promoted history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see PromotedHistoryPersistenceImpl
 * @see PromotedHistoryUtil
 * @generated
 */
public interface PromotedHistoryPersistence extends BasePersistence<PromotedHistory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PromotedHistoryUtil} to access the promoted history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the promoted histories where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findByEmployee(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the promoted histories where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of promoted histories
	* @param end the upper bound of the range of promoted histories (not inclusive)
	* @return the range of matching promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findByEmployee(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the promoted histories where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of promoted histories
	* @param end the upper bound of the range of promoted histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findByEmployee(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first promoted history in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching promoted history
	* @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a matching promoted history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory findByEmployee_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchPromotedHistoryException;

	/**
	* Returns the first promoted history in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching promoted history, or <code>null</code> if a matching promoted history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory fetchByEmployee_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last promoted history in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching promoted history
	* @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a matching promoted history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory findByEmployee_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchPromotedHistoryException;

	/**
	* Returns the last promoted history in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching promoted history, or <code>null</code> if a matching promoted history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory fetchByEmployee_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the promoted histories before and after the current promoted history in the ordered set where employeeId = &#63;.
	*
	* @param promotedHistoryId the primary key of the current promoted history
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next promoted history
	* @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a promoted history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory[] findByEmployee_PrevAndNext(
		long promotedHistoryId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchPromotedHistoryException;

	/**
	* Removes all the promoted histories where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of promoted histories where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the promoted histories where oldTitlesId = &#63;.
	*
	* @param oldTitlesId the old titles ID
	* @return the matching promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findByOldTitlesId(
		long oldTitlesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the promoted histories where oldTitlesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param oldTitlesId the old titles ID
	* @param start the lower bound of the range of promoted histories
	* @param end the upper bound of the range of promoted histories (not inclusive)
	* @return the range of matching promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findByOldTitlesId(
		long oldTitlesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the promoted histories where oldTitlesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param oldTitlesId the old titles ID
	* @param start the lower bound of the range of promoted histories
	* @param end the upper bound of the range of promoted histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findByOldTitlesId(
		long oldTitlesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first promoted history in the ordered set where oldTitlesId = &#63;.
	*
	* @param oldTitlesId the old titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching promoted history
	* @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a matching promoted history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory findByOldTitlesId_First(
		long oldTitlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchPromotedHistoryException;

	/**
	* Returns the first promoted history in the ordered set where oldTitlesId = &#63;.
	*
	* @param oldTitlesId the old titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching promoted history, or <code>null</code> if a matching promoted history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory fetchByOldTitlesId_First(
		long oldTitlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last promoted history in the ordered set where oldTitlesId = &#63;.
	*
	* @param oldTitlesId the old titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching promoted history
	* @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a matching promoted history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory findByOldTitlesId_Last(
		long oldTitlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchPromotedHistoryException;

	/**
	* Returns the last promoted history in the ordered set where oldTitlesId = &#63;.
	*
	* @param oldTitlesId the old titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching promoted history, or <code>null</code> if a matching promoted history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory fetchByOldTitlesId_Last(
		long oldTitlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the promoted histories before and after the current promoted history in the ordered set where oldTitlesId = &#63;.
	*
	* @param promotedHistoryId the primary key of the current promoted history
	* @param oldTitlesId the old titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next promoted history
	* @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a promoted history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory[] findByOldTitlesId_PrevAndNext(
		long promotedHistoryId, long oldTitlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchPromotedHistoryException;

	/**
	* Removes all the promoted histories where oldTitlesId = &#63; from the database.
	*
	* @param oldTitlesId the old titles ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOldTitlesId(long oldTitlesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of promoted histories where oldTitlesId = &#63;.
	*
	* @param oldTitlesId the old titles ID
	* @return the number of matching promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByOldTitlesId(long oldTitlesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the promoted histories where newTitlesId = &#63;.
	*
	* @param newTitlesId the new titles ID
	* @return the matching promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findByNewTitlesId(
		long newTitlesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the promoted histories where newTitlesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param newTitlesId the new titles ID
	* @param start the lower bound of the range of promoted histories
	* @param end the upper bound of the range of promoted histories (not inclusive)
	* @return the range of matching promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findByNewTitlesId(
		long newTitlesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the promoted histories where newTitlesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param newTitlesId the new titles ID
	* @param start the lower bound of the range of promoted histories
	* @param end the upper bound of the range of promoted histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findByNewTitlesId(
		long newTitlesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first promoted history in the ordered set where newTitlesId = &#63;.
	*
	* @param newTitlesId the new titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching promoted history
	* @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a matching promoted history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory findByNewTitlesId_First(
		long newTitlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchPromotedHistoryException;

	/**
	* Returns the first promoted history in the ordered set where newTitlesId = &#63;.
	*
	* @param newTitlesId the new titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching promoted history, or <code>null</code> if a matching promoted history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory fetchByNewTitlesId_First(
		long newTitlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last promoted history in the ordered set where newTitlesId = &#63;.
	*
	* @param newTitlesId the new titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching promoted history
	* @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a matching promoted history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory findByNewTitlesId_Last(
		long newTitlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchPromotedHistoryException;

	/**
	* Returns the last promoted history in the ordered set where newTitlesId = &#63;.
	*
	* @param newTitlesId the new titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching promoted history, or <code>null</code> if a matching promoted history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory fetchByNewTitlesId_Last(
		long newTitlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the promoted histories before and after the current promoted history in the ordered set where newTitlesId = &#63;.
	*
	* @param promotedHistoryId the primary key of the current promoted history
	* @param newTitlesId the new titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next promoted history
	* @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a promoted history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory[] findByNewTitlesId_PrevAndNext(
		long promotedHistoryId, long newTitlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchPromotedHistoryException;

	/**
	* Removes all the promoted histories where newTitlesId = &#63; from the database.
	*
	* @param newTitlesId the new titles ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNewTitlesId(long newTitlesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of promoted histories where newTitlesId = &#63;.
	*
	* @param newTitlesId the new titles ID
	* @return the number of matching promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByNewTitlesId(long newTitlesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the promoted history in the entity cache if it is enabled.
	*
	* @param promotedHistory the promoted history
	*/
	public void cacheResult(
		vn.com.ecopharma.emp.model.PromotedHistory promotedHistory);

	/**
	* Caches the promoted histories in the entity cache if it is enabled.
	*
	* @param promotedHistories the promoted histories
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> promotedHistories);

	/**
	* Creates a new promoted history with the primary key. Does not add the promoted history to the database.
	*
	* @param promotedHistoryId the primary key for the new promoted history
	* @return the new promoted history
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory create(
		long promotedHistoryId);

	/**
	* Removes the promoted history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param promotedHistoryId the primary key of the promoted history
	* @return the promoted history that was removed
	* @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a promoted history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory remove(
		long promotedHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchPromotedHistoryException;

	public vn.com.ecopharma.emp.model.PromotedHistory updateImpl(
		vn.com.ecopharma.emp.model.PromotedHistory promotedHistory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the promoted history with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchPromotedHistoryException} if it could not be found.
	*
	* @param promotedHistoryId the primary key of the promoted history
	* @return the promoted history
	* @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a promoted history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory findByPrimaryKey(
		long promotedHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchPromotedHistoryException;

	/**
	* Returns the promoted history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param promotedHistoryId the primary key of the promoted history
	* @return the promoted history, or <code>null</code> if a promoted history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.PromotedHistory fetchByPrimaryKey(
		long promotedHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the promoted histories.
	*
	* @return the promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the promoted histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of promoted histories
	* @param end the upper bound of the range of promoted histories (not inclusive)
	* @return the range of promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the promoted histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of promoted histories
	* @param end the upper bound of the range of promoted histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the promoted histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of promoted histories.
	*
	* @return the number of promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}