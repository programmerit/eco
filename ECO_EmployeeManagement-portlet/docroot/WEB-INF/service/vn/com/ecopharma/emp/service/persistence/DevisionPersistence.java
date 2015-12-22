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

import vn.com.ecopharma.emp.model.Devision;

/**
 * The persistence interface for the devision service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see DevisionPersistenceImpl
 * @see DevisionUtil
 * @generated
 */
public interface DevisionPersistence extends BasePersistence<Devision> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DevisionUtil} to access the devision persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the devision where name = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchDevisionException} if it could not be found.
	*
	* @param name the name
	* @return the matching devision
	* @throws vn.com.ecopharma.emp.NoSuchDevisionException if a matching devision could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Devision findByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDevisionException;

	/**
	* Returns the devision where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching devision, or <code>null</code> if a matching devision could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Devision fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the devision where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching devision, or <code>null</code> if a matching devision could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Devision fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the devision where name = &#63; from the database.
	*
	* @param name the name
	* @return the devision that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Devision removeByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDevisionException;

	/**
	* Returns the number of devisions where name = &#63;.
	*
	* @param name the name
	* @return the number of matching devisions
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the devision in the entity cache if it is enabled.
	*
	* @param devision the devision
	*/
	public void cacheResult(vn.com.ecopharma.emp.model.Devision devision);

	/**
	* Caches the devisions in the entity cache if it is enabled.
	*
	* @param devisions the devisions
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.Devision> devisions);

	/**
	* Creates a new devision with the primary key. Does not add the devision to the database.
	*
	* @param devisionId the primary key for the new devision
	* @return the new devision
	*/
	public vn.com.ecopharma.emp.model.Devision create(long devisionId);

	/**
	* Removes the devision with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param devisionId the primary key of the devision
	* @return the devision that was removed
	* @throws vn.com.ecopharma.emp.NoSuchDevisionException if a devision with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Devision remove(long devisionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDevisionException;

	public vn.com.ecopharma.emp.model.Devision updateImpl(
		vn.com.ecopharma.emp.model.Devision devision)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the devision with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchDevisionException} if it could not be found.
	*
	* @param devisionId the primary key of the devision
	* @return the devision
	* @throws vn.com.ecopharma.emp.NoSuchDevisionException if a devision with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Devision findByPrimaryKey(long devisionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDevisionException;

	/**
	* Returns the devision with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param devisionId the primary key of the devision
	* @return the devision, or <code>null</code> if a devision with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Devision fetchByPrimaryKey(
		long devisionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the devisions.
	*
	* @return the devisions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Devision> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the devisions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DevisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of devisions
	* @param end the upper bound of the range of devisions (not inclusive)
	* @return the range of devisions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Devision> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the devisions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DevisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of devisions
	* @param end the upper bound of the range of devisions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of devisions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Devision> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the devisions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of devisions.
	*
	* @return the number of devisions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}