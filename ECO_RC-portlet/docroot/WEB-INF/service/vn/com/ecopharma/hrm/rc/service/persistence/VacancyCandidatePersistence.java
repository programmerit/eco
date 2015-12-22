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

import vn.com.ecopharma.hrm.rc.model.VacancyCandidate;

/**
 * The persistence interface for the vacancy candidate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see VacancyCandidatePersistenceImpl
 * @see VacancyCandidateUtil
 * @generated
 */
public interface VacancyCandidatePersistence extends BasePersistence<VacancyCandidate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VacancyCandidateUtil} to access the vacancy candidate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the vacancy candidate where vacancyId = &#63; and candidateId = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException} if it could not be found.
	*
	* @param vacancyId the vacancy ID
	* @param candidateId the candidate ID
	* @return the matching vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByVacancyAndCandidate(
		long vacancyId, long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;

	/**
	* Returns the vacancy candidate where vacancyId = &#63; and candidateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param vacancyId the vacancy ID
	* @param candidateId the candidate ID
	* @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByVacancyAndCandidate(
		long vacancyId, long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vacancy candidate where vacancyId = &#63; and candidateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param vacancyId the vacancy ID
	* @param candidateId the candidate ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByVacancyAndCandidate(
		long vacancyId, long candidateId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the vacancy candidate where vacancyId = &#63; and candidateId = &#63; from the database.
	*
	* @param vacancyId the vacancy ID
	* @param candidateId the candidate ID
	* @return the vacancy candidate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate removeByVacancyAndCandidate(
		long vacancyId, long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;

	/**
	* Returns the number of vacancy candidates where vacancyId = &#63; and candidateId = &#63;.
	*
	* @param vacancyId the vacancy ID
	* @param candidateId the candidate ID
	* @return the number of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public int countByVacancyAndCandidate(long vacancyId, long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vacancy candidates where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @return the matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByCandidate(
		long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vacancy candidates where candidateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateId the candidate ID
	* @param start the lower bound of the range of vacancy candidates
	* @param end the upper bound of the range of vacancy candidates (not inclusive)
	* @return the range of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByCandidate(
		long candidateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vacancy candidates where candidateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateId the candidate ID
	* @param start the lower bound of the range of vacancy candidates
	* @param end the upper bound of the range of vacancy candidates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByCandidate(
		long candidateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vacancy candidate in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByCandidate_First(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;

	/**
	* Returns the first vacancy candidate in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByCandidate_First(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last vacancy candidate in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByCandidate_Last(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;

	/**
	* Returns the last vacancy candidate in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByCandidate_Last(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vacancy candidates before and after the current vacancy candidate in the ordered set where candidateId = &#63;.
	*
	* @param vacancyCandidateId the primary key of the current vacancy candidate
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a vacancy candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate[] findByCandidate_PrevAndNext(
		long vacancyCandidateId, long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;

	/**
	* Removes all the vacancy candidates where candidateId = &#63; from the database.
	*
	* @param candidateId the candidate ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCandidate(long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vacancy candidates where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @return the number of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public int countByCandidate(long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vacancy candidates where vacancyId = &#63;.
	*
	* @param vacancyId the vacancy ID
	* @return the matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByVacancy(
		long vacancyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vacancy candidates where vacancyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param vacancyId the vacancy ID
	* @param start the lower bound of the range of vacancy candidates
	* @param end the upper bound of the range of vacancy candidates (not inclusive)
	* @return the range of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByVacancy(
		long vacancyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vacancy candidates where vacancyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param vacancyId the vacancy ID
	* @param start the lower bound of the range of vacancy candidates
	* @param end the upper bound of the range of vacancy candidates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByVacancy(
		long vacancyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vacancy candidate in the ordered set where vacancyId = &#63;.
	*
	* @param vacancyId the vacancy ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByVacancy_First(
		long vacancyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;

	/**
	* Returns the first vacancy candidate in the ordered set where vacancyId = &#63;.
	*
	* @param vacancyId the vacancy ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByVacancy_First(
		long vacancyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last vacancy candidate in the ordered set where vacancyId = &#63;.
	*
	* @param vacancyId the vacancy ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByVacancy_Last(
		long vacancyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;

	/**
	* Returns the last vacancy candidate in the ordered set where vacancyId = &#63;.
	*
	* @param vacancyId the vacancy ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByVacancy_Last(
		long vacancyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vacancy candidates before and after the current vacancy candidate in the ordered set where vacancyId = &#63;.
	*
	* @param vacancyCandidateId the primary key of the current vacancy candidate
	* @param vacancyId the vacancy ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a vacancy candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate[] findByVacancy_PrevAndNext(
		long vacancyCandidateId, long vacancyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;

	/**
	* Removes all the vacancy candidates where vacancyId = &#63; from the database.
	*
	* @param vacancyId the vacancy ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVacancy(long vacancyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vacancy candidates where vacancyId = &#63;.
	*
	* @param vacancyId the vacancy ID
	* @return the number of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public int countByVacancy(long vacancyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vacancy candidate where candidateId = &#63; and status = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException} if it could not be found.
	*
	* @param candidateId the candidate ID
	* @param status the status
	* @return the matching vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByCandidateAndActiveStatus(
		long candidateId, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;

	/**
	* Returns the vacancy candidate where candidateId = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param candidateId the candidate ID
	* @param status the status
	* @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByCandidateAndActiveStatus(
		long candidateId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vacancy candidate where candidateId = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param candidateId the candidate ID
	* @param status the status
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByCandidateAndActiveStatus(
		long candidateId, int status, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the vacancy candidate where candidateId = &#63; and status = &#63; from the database.
	*
	* @param candidateId the candidate ID
	* @param status the status
	* @return the vacancy candidate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate removeByCandidateAndActiveStatus(
		long candidateId, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;

	/**
	* Returns the number of vacancy candidates where candidateId = &#63; and status = &#63;.
	*
	* @param candidateId the candidate ID
	* @param status the status
	* @return the number of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public int countByCandidateAndActiveStatus(long candidateId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vacancy candidates where candidateId = &#63; and type = &#63;.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @return the matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByCandidateAndType(
		long candidateId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vacancy candidates where candidateId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @param start the lower bound of the range of vacancy candidates
	* @param end the upper bound of the range of vacancy candidates (not inclusive)
	* @return the range of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByCandidateAndType(
		long candidateId, java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vacancy candidates where candidateId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @param start the lower bound of the range of vacancy candidates
	* @param end the upper bound of the range of vacancy candidates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByCandidateAndType(
		long candidateId, java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vacancy candidate in the ordered set where candidateId = &#63; and type = &#63;.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByCandidateAndType_First(
		long candidateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;

	/**
	* Returns the first vacancy candidate in the ordered set where candidateId = &#63; and type = &#63;.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByCandidateAndType_First(
		long candidateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last vacancy candidate in the ordered set where candidateId = &#63; and type = &#63;.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByCandidateAndType_Last(
		long candidateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;

	/**
	* Returns the last vacancy candidate in the ordered set where candidateId = &#63; and type = &#63;.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByCandidateAndType_Last(
		long candidateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vacancy candidates before and after the current vacancy candidate in the ordered set where candidateId = &#63; and type = &#63;.
	*
	* @param vacancyCandidateId the primary key of the current vacancy candidate
	* @param candidateId the candidate ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a vacancy candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate[] findByCandidateAndType_PrevAndNext(
		long vacancyCandidateId, long candidateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;

	/**
	* Removes all the vacancy candidates where candidateId = &#63; and type = &#63; from the database.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCandidateAndType(long candidateId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vacancy candidates where candidateId = &#63; and type = &#63;.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @return the number of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public int countByCandidateAndType(long candidateId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vacancy candidate where candidateId = &#63; and type = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException} if it could not be found.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @return the matching vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByCandidateAndMAINType(
		long candidateId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;

	/**
	* Returns the vacancy candidate where candidateId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByCandidateAndMAINType(
		long candidateId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vacancy candidate where candidateId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByCandidateAndMAINType(
		long candidateId, java.lang.String type, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the vacancy candidate where candidateId = &#63; and type = &#63; from the database.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @return the vacancy candidate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate removeByCandidateAndMAINType(
		long candidateId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;

	/**
	* Returns the number of vacancy candidates where candidateId = &#63; and type = &#63;.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @return the number of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public int countByCandidateAndMAINType(long candidateId,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the vacancy candidate in the entity cache if it is enabled.
	*
	* @param vacancyCandidate the vacancy candidate
	*/
	public void cacheResult(
		vn.com.ecopharma.hrm.rc.model.VacancyCandidate vacancyCandidate);

	/**
	* Caches the vacancy candidates in the entity cache if it is enabled.
	*
	* @param vacancyCandidates the vacancy candidates
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> vacancyCandidates);

	/**
	* Creates a new vacancy candidate with the primary key. Does not add the vacancy candidate to the database.
	*
	* @param vacancyCandidateId the primary key for the new vacancy candidate
	* @return the new vacancy candidate
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate create(
		long vacancyCandidateId);

	/**
	* Removes the vacancy candidate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vacancyCandidateId the primary key of the vacancy candidate
	* @return the vacancy candidate that was removed
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a vacancy candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate remove(
		long vacancyCandidateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;

	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate updateImpl(
		vn.com.ecopharma.hrm.rc.model.VacancyCandidate vacancyCandidate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vacancy candidate with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException} if it could not be found.
	*
	* @param vacancyCandidateId the primary key of the vacancy candidate
	* @return the vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a vacancy candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByPrimaryKey(
		long vacancyCandidateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;

	/**
	* Returns the vacancy candidate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vacancyCandidateId the primary key of the vacancy candidate
	* @return the vacancy candidate, or <code>null</code> if a vacancy candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByPrimaryKey(
		long vacancyCandidateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vacancy candidates.
	*
	* @return the vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vacancy candidates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vacancy candidates
	* @param end the upper bound of the range of vacancy candidates (not inclusive)
	* @return the range of vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vacancy candidates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vacancy candidates
	* @param end the upper bound of the range of vacancy candidates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vacancy candidates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vacancy candidates.
	*
	* @return the number of vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}