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

import vn.com.ecopharma.emp.model.EmpDiscipline;

/**
 * The persistence interface for the emp discipline service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpDisciplinePersistenceImpl
 * @see EmpDisciplineUtil
 * @generated
 */
public interface EmpDisciplinePersistence extends BasePersistence<EmpDiscipline> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmpDisciplineUtil} to access the emp discipline persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the emp discipline in the entity cache if it is enabled.
	*
	* @param empDiscipline the emp discipline
	*/
	public void cacheResult(
		vn.com.ecopharma.emp.model.EmpDiscipline empDiscipline);

	/**
	* Caches the emp disciplines in the entity cache if it is enabled.
	*
	* @param empDisciplines the emp disciplines
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.EmpDiscipline> empDisciplines);

	/**
	* Creates a new emp discipline with the primary key. Does not add the emp discipline to the database.
	*
	* @param empDisciplineId the primary key for the new emp discipline
	* @return the new emp discipline
	*/
	public vn.com.ecopharma.emp.model.EmpDiscipline create(long empDisciplineId);

	/**
	* Removes the emp discipline with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empDisciplineId the primary key of the emp discipline
	* @return the emp discipline that was removed
	* @throws vn.com.ecopharma.emp.NoSuchEmpDisciplineException if a emp discipline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.EmpDiscipline remove(long empDisciplineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpDisciplineException;

	public vn.com.ecopharma.emp.model.EmpDiscipline updateImpl(
		vn.com.ecopharma.emp.model.EmpDiscipline empDiscipline)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the emp discipline with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpDisciplineException} if it could not be found.
	*
	* @param empDisciplineId the primary key of the emp discipline
	* @return the emp discipline
	* @throws vn.com.ecopharma.emp.NoSuchEmpDisciplineException if a emp discipline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.EmpDiscipline findByPrimaryKey(
		long empDisciplineId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpDisciplineException;

	/**
	* Returns the emp discipline with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empDisciplineId the primary key of the emp discipline
	* @return the emp discipline, or <code>null</code> if a emp discipline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.EmpDiscipline fetchByPrimaryKey(
		long empDisciplineId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the emp disciplines.
	*
	* @return the emp disciplines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.EmpDiscipline> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the emp disciplines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpDisciplineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp disciplines
	* @param end the upper bound of the range of emp disciplines (not inclusive)
	* @return the range of emp disciplines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.EmpDiscipline> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the emp disciplines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpDisciplineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp disciplines
	* @param end the upper bound of the range of emp disciplines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of emp disciplines
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.EmpDiscipline> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the emp disciplines from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of emp disciplines.
	*
	* @return the number of emp disciplines
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}