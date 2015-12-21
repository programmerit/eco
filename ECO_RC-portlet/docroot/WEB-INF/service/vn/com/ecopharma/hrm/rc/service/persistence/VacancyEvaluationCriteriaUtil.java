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

import vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria;

import java.util.List;

/**
 * The persistence utility for the vacancy evaluation criteria service. This utility wraps {@link VacancyEvaluationCriteriaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see VacancyEvaluationCriteriaPersistence
 * @see VacancyEvaluationCriteriaPersistenceImpl
 * @generated
 */
public class VacancyEvaluationCriteriaUtil {
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
	public static void clearCache(
		VacancyEvaluationCriteria vacancyEvaluationCriteria) {
		getPersistence().clearCache(vacancyEvaluationCriteria);
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
	public static List<VacancyEvaluationCriteria> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VacancyEvaluationCriteria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VacancyEvaluationCriteria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VacancyEvaluationCriteria update(
		VacancyEvaluationCriteria vacancyEvaluationCriteria)
		throws SystemException {
		return getPersistence().update(vacancyEvaluationCriteria);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VacancyEvaluationCriteria update(
		VacancyEvaluationCriteria vacancyEvaluationCriteria,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vacancyEvaluationCriteria, serviceContext);
	}

	/**
	* Caches the vacancy evaluation criteria in the entity cache if it is enabled.
	*
	* @param vacancyEvaluationCriteria the vacancy evaluation criteria
	*/
	public static void cacheResult(
		vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria vacancyEvaluationCriteria) {
		getPersistence().cacheResult(vacancyEvaluationCriteria);
	}

	/**
	* Caches the vacancy evaluation criterias in the entity cache if it is enabled.
	*
	* @param vacancyEvaluationCriterias the vacancy evaluation criterias
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria> vacancyEvaluationCriterias) {
		getPersistence().cacheResult(vacancyEvaluationCriterias);
	}

	/**
	* Creates a new vacancy evaluation criteria with the primary key. Does not add the vacancy evaluation criteria to the database.
	*
	* @param vacancyEvaluationCriteriaId the primary key for the new vacancy evaluation criteria
	* @return the new vacancy evaluation criteria
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria create(
		long vacancyEvaluationCriteriaId) {
		return getPersistence().create(vacancyEvaluationCriteriaId);
	}

	/**
	* Removes the vacancy evaluation criteria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vacancyEvaluationCriteriaId the primary key of the vacancy evaluation criteria
	* @return the vacancy evaluation criteria that was removed
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException if a vacancy evaluation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria remove(
		long vacancyEvaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException {
		return getPersistence().remove(vacancyEvaluationCriteriaId);
	}

	public static vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria updateImpl(
		vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria vacancyEvaluationCriteria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vacancyEvaluationCriteria);
	}

	/**
	* Returns the vacancy evaluation criteria with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException} if it could not be found.
	*
	* @param vacancyEvaluationCriteriaId the primary key of the vacancy evaluation criteria
	* @return the vacancy evaluation criteria
	* @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException if a vacancy evaluation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria findByPrimaryKey(
		long vacancyEvaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException {
		return getPersistence().findByPrimaryKey(vacancyEvaluationCriteriaId);
	}

	/**
	* Returns the vacancy evaluation criteria with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vacancyEvaluationCriteriaId the primary key of the vacancy evaluation criteria
	* @return the vacancy evaluation criteria, or <code>null</code> if a vacancy evaluation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria fetchByPrimaryKey(
		long vacancyEvaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(vacancyEvaluationCriteriaId);
	}

	/**
	* Returns all the vacancy evaluation criterias.
	*
	* @return the vacancy evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vacancy evaluation criterias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vacancy evaluation criterias.
	*
	* @return the number of vacancy evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VacancyEvaluationCriteriaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VacancyEvaluationCriteriaPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.hrm.rc.service.ClpSerializer.getServletContextName(),
					VacancyEvaluationCriteriaPersistence.class.getName());

			ReferenceRegistry.registerReference(VacancyEvaluationCriteriaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VacancyEvaluationCriteriaPersistence persistence) {
	}

	private static VacancyEvaluationCriteriaPersistence _persistence;
}