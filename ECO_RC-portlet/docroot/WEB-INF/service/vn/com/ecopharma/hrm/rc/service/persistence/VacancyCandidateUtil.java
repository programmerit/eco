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

import vn.com.ecopharma.hrm.rc.model.VacancyCandidate;

import java.util.List;

/**
 * The persistence utility for the vacancy candidate service. This utility wraps {@link VacancyCandidatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see VacancyCandidatePersistence
 * @see VacancyCandidatePersistenceImpl
 * @generated
 */
public class VacancyCandidateUtil {
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
	public static void clearCache(VacancyCandidate vacancyCandidate) {
		getPersistence().clearCache(vacancyCandidate);
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
	public static List<VacancyCandidate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VacancyCandidate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VacancyCandidate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VacancyCandidate update(VacancyCandidate vacancyCandidate)
		throws SystemException {
		return getPersistence().update(vacancyCandidate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VacancyCandidate update(VacancyCandidate vacancyCandidate,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vacancyCandidate, serviceContext);
	}

	/**
	* Returns the vacancy candidate where vacancyId = &#63; and candidateId = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException} if it could not be found.
	*
	* @param vacancyId the vacancy ID
	* @param candidateId the candidate ID
	* @return the matching vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByVacancyAndCandidate(
		long vacancyId, long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException {
		return getPersistence().findByVacancyAndCandidate(vacancyId, candidateId);
	}

	/**
	* Returns the vacancy candidate where vacancyId = &#63; and candidateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param vacancyId the vacancy ID
	* @param candidateId the candidate ID
	* @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByVacancyAndCandidate(
		long vacancyId, long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVacancyAndCandidate(vacancyId, candidateId);
	}

	/**
	* Returns the vacancy candidate where vacancyId = &#63; and candidateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param vacancyId the vacancy ID
	* @param candidateId the candidate ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByVacancyAndCandidate(
		long vacancyId, long candidateId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVacancyAndCandidate(vacancyId, candidateId,
			retrieveFromCache);
	}

	/**
	* Removes the vacancy candidate where vacancyId = &#63; and candidateId = &#63; from the database.
	*
	* @param vacancyId the vacancy ID
	* @param candidateId the candidate ID
	* @return the vacancy candidate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate removeByVacancyAndCandidate(
		long vacancyId, long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException {
		return getPersistence()
				   .removeByVacancyAndCandidate(vacancyId, candidateId);
	}

	/**
	* Returns the number of vacancy candidates where vacancyId = &#63; and candidateId = &#63;.
	*
	* @param vacancyId the vacancy ID
	* @param candidateId the candidate ID
	* @return the number of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVacancyAndCandidate(long vacancyId,
		long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByVacancyAndCandidate(vacancyId, candidateId);
	}

	/**
	* Returns all the vacancy candidates where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @return the matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByCandidate(
		long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCandidate(candidateId);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByCandidate(
		long candidateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCandidate(candidateId, start, end);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByCandidate(
		long candidateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCandidate(candidateId, start, end, orderByComparator);
	}

	/**
	* Returns the first vacancy candidate in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByCandidate_First(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException {
		return getPersistence()
				   .findByCandidate_First(candidateId, orderByComparator);
	}

	/**
	* Returns the first vacancy candidate in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByCandidate_First(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCandidate_First(candidateId, orderByComparator);
	}

	/**
	* Returns the last vacancy candidate in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByCandidate_Last(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException {
		return getPersistence()
				   .findByCandidate_Last(candidateId, orderByComparator);
	}

	/**
	* Returns the last vacancy candidate in the ordered set where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByCandidate_Last(
		long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCandidate_Last(candidateId, orderByComparator);
	}

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
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate[] findByCandidate_PrevAndNext(
		long vacancyCandidateId, long candidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException {
		return getPersistence()
				   .findByCandidate_PrevAndNext(vacancyCandidateId,
			candidateId, orderByComparator);
	}

	/**
	* Removes all the vacancy candidates where candidateId = &#63; from the database.
	*
	* @param candidateId the candidate ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCandidate(long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCandidate(candidateId);
	}

	/**
	* Returns the number of vacancy candidates where candidateId = &#63;.
	*
	* @param candidateId the candidate ID
	* @return the number of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCandidate(long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCandidate(candidateId);
	}

	/**
	* Returns all the vacancy candidates where vacancyId = &#63;.
	*
	* @param vacancyId the vacancy ID
	* @return the matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByVacancy(
		long vacancyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVacancy(vacancyId);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByVacancy(
		long vacancyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVacancy(vacancyId, start, end);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByVacancy(
		long vacancyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVacancy(vacancyId, start, end, orderByComparator);
	}

	/**
	* Returns the first vacancy candidate in the ordered set where vacancyId = &#63;.
	*
	* @param vacancyId the vacancy ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByVacancy_First(
		long vacancyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException {
		return getPersistence().findByVacancy_First(vacancyId, orderByComparator);
	}

	/**
	* Returns the first vacancy candidate in the ordered set where vacancyId = &#63;.
	*
	* @param vacancyId the vacancy ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByVacancy_First(
		long vacancyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVacancy_First(vacancyId, orderByComparator);
	}

	/**
	* Returns the last vacancy candidate in the ordered set where vacancyId = &#63;.
	*
	* @param vacancyId the vacancy ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByVacancy_Last(
		long vacancyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException {
		return getPersistence().findByVacancy_Last(vacancyId, orderByComparator);
	}

	/**
	* Returns the last vacancy candidate in the ordered set where vacancyId = &#63;.
	*
	* @param vacancyId the vacancy ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByVacancy_Last(
		long vacancyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVacancy_Last(vacancyId, orderByComparator);
	}

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
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate[] findByVacancy_PrevAndNext(
		long vacancyCandidateId, long vacancyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException {
		return getPersistence()
				   .findByVacancy_PrevAndNext(vacancyCandidateId, vacancyId,
			orderByComparator);
	}

	/**
	* Removes all the vacancy candidates where vacancyId = &#63; from the database.
	*
	* @param vacancyId the vacancy ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVacancy(long vacancyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVacancy(vacancyId);
	}

	/**
	* Returns the number of vacancy candidates where vacancyId = &#63;.
	*
	* @param vacancyId the vacancy ID
	* @return the number of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVacancy(long vacancyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVacancy(vacancyId);
	}

	/**
	* Returns the vacancy candidate where candidateId = &#63; and status = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException} if it could not be found.
	*
	* @param candidateId the candidate ID
	* @param status the status
	* @return the matching vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByCandidateAndActiveStatus(
		long candidateId, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException {
		return getPersistence()
				   .findByCandidateAndActiveStatus(candidateId, status);
	}

	/**
	* Returns the vacancy candidate where candidateId = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param candidateId the candidate ID
	* @param status the status
	* @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByCandidateAndActiveStatus(
		long candidateId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCandidateAndActiveStatus(candidateId, status);
	}

	/**
	* Returns the vacancy candidate where candidateId = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param candidateId the candidate ID
	* @param status the status
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByCandidateAndActiveStatus(
		long candidateId, int status, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCandidateAndActiveStatus(candidateId, status,
			retrieveFromCache);
	}

	/**
	* Removes the vacancy candidate where candidateId = &#63; and status = &#63; from the database.
	*
	* @param candidateId the candidate ID
	* @param status the status
	* @return the vacancy candidate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate removeByCandidateAndActiveStatus(
		long candidateId, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException {
		return getPersistence()
				   .removeByCandidateAndActiveStatus(candidateId, status);
	}

	/**
	* Returns the number of vacancy candidates where candidateId = &#63; and status = &#63;.
	*
	* @param candidateId the candidate ID
	* @param status the status
	* @return the number of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCandidateAndActiveStatus(long candidateId,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCandidateAndActiveStatus(candidateId, status);
	}

	/**
	* Returns all the vacancy candidates where candidateId = &#63; and type = &#63;.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @return the matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByCandidateAndType(
		long candidateId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCandidateAndType(candidateId, type);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByCandidateAndType(
		long candidateId, java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCandidateAndType(candidateId, type, start, end);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByCandidateAndType(
		long candidateId, java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCandidateAndType(candidateId, type, start, end,
			orderByComparator);
	}

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
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByCandidateAndType_First(
		long candidateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException {
		return getPersistence()
				   .findByCandidateAndType_First(candidateId, type,
			orderByComparator);
	}

	/**
	* Returns the first vacancy candidate in the ordered set where candidateId = &#63; and type = &#63;.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByCandidateAndType_First(
		long candidateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCandidateAndType_First(candidateId, type,
			orderByComparator);
	}

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
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByCandidateAndType_Last(
		long candidateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException {
		return getPersistence()
				   .findByCandidateAndType_Last(candidateId, type,
			orderByComparator);
	}

	/**
	* Returns the last vacancy candidate in the ordered set where candidateId = &#63; and type = &#63;.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByCandidateAndType_Last(
		long candidateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCandidateAndType_Last(candidateId, type,
			orderByComparator);
	}

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
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate[] findByCandidateAndType_PrevAndNext(
		long vacancyCandidateId, long candidateId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException {
		return getPersistence()
				   .findByCandidateAndType_PrevAndNext(vacancyCandidateId,
			candidateId, type, orderByComparator);
	}

	/**
	* Removes all the vacancy candidates where candidateId = &#63; and type = &#63; from the database.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCandidateAndType(long candidateId,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCandidateAndType(candidateId, type);
	}

	/**
	* Returns the number of vacancy candidates where candidateId = &#63; and type = &#63;.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @return the number of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCandidateAndType(long candidateId,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCandidateAndType(candidateId, type);
	}

	/**
	* Returns the vacancy candidate where candidateId = &#63; and type = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException} if it could not be found.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @return the matching vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByCandidateAndMAINType(
		long candidateId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException {
		return getPersistence().findByCandidateAndMAINType(candidateId, type);
	}

	/**
	* Returns the vacancy candidate where candidateId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByCandidateAndMAINType(
		long candidateId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCandidateAndMAINType(candidateId, type);
	}

	/**
	* Returns the vacancy candidate where candidateId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByCandidateAndMAINType(
		long candidateId, java.lang.String type, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCandidateAndMAINType(candidateId, type,
			retrieveFromCache);
	}

	/**
	* Removes the vacancy candidate where candidateId = &#63; and type = &#63; from the database.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @return the vacancy candidate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate removeByCandidateAndMAINType(
		long candidateId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException {
		return getPersistence().removeByCandidateAndMAINType(candidateId, type);
	}

	/**
	* Returns the number of vacancy candidates where candidateId = &#63; and type = &#63;.
	*
	* @param candidateId the candidate ID
	* @param type the type
	* @return the number of matching vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCandidateAndMAINType(long candidateId,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCandidateAndMAINType(candidateId, type);
	}

	/**
	* Caches the vacancy candidate in the entity cache if it is enabled.
	*
	* @param vacancyCandidate the vacancy candidate
	*/
	public static void cacheResult(
		vn.com.ecopharma.hrm.rc.model.VacancyCandidate vacancyCandidate) {
		getPersistence().cacheResult(vacancyCandidate);
	}

	/**
	* Caches the vacancy candidates in the entity cache if it is enabled.
	*
	* @param vacancyCandidates the vacancy candidates
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> vacancyCandidates) {
		getPersistence().cacheResult(vacancyCandidates);
	}

	/**
	* Creates a new vacancy candidate with the primary key. Does not add the vacancy candidate to the database.
	*
	* @param vacancyCandidateId the primary key for the new vacancy candidate
	* @return the new vacancy candidate
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate create(
		long vacancyCandidateId) {
		return getPersistence().create(vacancyCandidateId);
	}

	/**
	* Removes the vacancy candidate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vacancyCandidateId the primary key of the vacancy candidate
	* @return the vacancy candidate that was removed
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a vacancy candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate remove(
		long vacancyCandidateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException {
		return getPersistence().remove(vacancyCandidateId);
	}

	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate updateImpl(
		vn.com.ecopharma.hrm.rc.model.VacancyCandidate vacancyCandidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vacancyCandidate);
	}

	/**
	* Returns the vacancy candidate with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException} if it could not be found.
	*
	* @param vacancyCandidateId the primary key of the vacancy candidate
	* @return the vacancy candidate
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a vacancy candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByPrimaryKey(
		long vacancyCandidateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException {
		return getPersistence().findByPrimaryKey(vacancyCandidateId);
	}

	/**
	* Returns the vacancy candidate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vacancyCandidateId the primary key of the vacancy candidate
	* @return the vacancy candidate, or <code>null</code> if a vacancy candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchByPrimaryKey(
		long vacancyCandidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(vacancyCandidateId);
	}

	/**
	* Returns all the vacancy candidates.
	*
	* @return the vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vacancy candidates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vacancy candidates.
	*
	* @return the number of vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VacancyCandidatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VacancyCandidatePersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.hrm.rc.service.ClpSerializer.getServletContextName(),
					VacancyCandidatePersistence.class.getName());

			ReferenceRegistry.registerReference(VacancyCandidateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VacancyCandidatePersistence persistence) {
	}

	private static VacancyCandidatePersistence _persistence;
}