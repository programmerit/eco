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

import vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria;

/**
 * The persistence interface for the vacancy evaluation criteria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see VacancyEvaluationCriteriaPersistenceImpl
 * @see VacancyEvaluationCriteriaUtil
 * @generated
 */
public interface VacancyEvaluationCriteriaPersistence extends BasePersistence<VacancyEvaluationCriteria> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VacancyEvaluationCriteriaUtil} to access the vacancy evaluation criteria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the vacancy evaluation criteria in the entity cache if it is enabled.
	*
	* @param vacancyEvaluationCriteria the vacancy evaluation criteria
	*/
	public void cacheResult(
		vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria vacancyEvaluationCriteria);

	/**
	* Caches the vacancy evaluation criterias in the entity cache if it is enabled.
	*
	* @param vacancyEvaluationCriterias the vacancy evaluation criterias
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria> vacancyEvaluationCriterias);

	/**
	* Creates a new vacancy evaluation criteria with the primary key. Does not add the vacancy evaluation criteria to the database.
	*
	* @param vacancyEvaluationCriteriaId the primary key for the new vacancy evaluation criteria
	* @return the new vacancy evaluation criteria
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria create(
		long vacancyEvaluationCriteriaId);

	/**
	* Removes the vacancy evaluation criteria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vacancyEvaluationCriteriaId the primary key of the vacancy evaluation criteria
	* @return the vacancy evaluation criteria that was removed
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException if a vacancy evaluation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria remove(
		long vacancyEvaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException;

	public vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria updateImpl(
		vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria vacancyEvaluationCriteria)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vacancy evaluation criteria with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException} if it could not be found.
	*
	* @param vacancyEvaluationCriteriaId the primary key of the vacancy evaluation criteria
	* @return the vacancy evaluation criteria
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException if a vacancy evaluation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria findByPrimaryKey(
		long vacancyEvaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException;

	/**
	* Returns the vacancy evaluation criteria with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vacancyEvaluationCriteriaId the primary key of the vacancy evaluation criteria
	* @return the vacancy evaluation criteria, or <code>null</code> if a vacancy evaluation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria fetchByPrimaryKey(
		long vacancyEvaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vacancy evaluation criterias.
	*
	* @return the vacancy evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vacancy evaluation criterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyEvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vacancy evaluation criterias
	* @param end the upper bound of the range of vacancy evaluation criterias (not inclusive)
	* @return the range of vacancy evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vacancy evaluation criterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyEvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vacancy evaluation criterias
	* @param end the upper bound of the range of vacancy evaluation criterias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vacancy evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vacancy evaluation criterias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vacancy evaluation criterias.
	*
	* @return the number of vacancy evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}