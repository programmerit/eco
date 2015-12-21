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

import vn.com.ecopharma.hrm.rc.model.Skill;

/**
 * The persistence interface for the skill service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see SkillPersistenceImpl
 * @see SkillUtil
 * @generated
 */
public interface SkillPersistence extends BasePersistence<Skill> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SkillUtil} to access the skill persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the skill in the entity cache if it is enabled.
	*
	* @param skill the skill
	*/
	public void cacheResult(vn.com.ecopharma.hrm.rc.model.Skill skill);

	/**
	* Caches the skills in the entity cache if it is enabled.
	*
	* @param skills the skills
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.hrm.rc.model.Skill> skills);

	/**
	* Creates a new skill with the primary key. Does not add the skill to the database.
	*
	* @param skillId the primary key for the new skill
	* @return the new skill
	*/
	public vn.com.ecopharma.hrm.rc.model.Skill create(long skillId);

	/**
	* Removes the skill with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param skillId the primary key of the skill
	* @return the skill that was removed
	* @throws vn.com.ecopharma.hrm.rc.NoSuchSkillException if a skill with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Skill remove(long skillId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchSkillException;

	public vn.com.ecopharma.hrm.rc.model.Skill updateImpl(
		vn.com.ecopharma.hrm.rc.model.Skill skill)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the skill with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchSkillException} if it could not be found.
	*
	* @param skillId the primary key of the skill
	* @return the skill
	* @throws vn.com.ecopharma.hrm.rc.NoSuchSkillException if a skill with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Skill findByPrimaryKey(long skillId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchSkillException;

	/**
	* Returns the skill with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param skillId the primary key of the skill
	* @return the skill, or <code>null</code> if a skill with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Skill fetchByPrimaryKey(long skillId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the skills.
	*
	* @return the skills
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Skill> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the skills.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.SkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of skills
	* @param end the upper bound of the range of skills (not inclusive)
	* @return the range of skills
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Skill> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the skills.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.SkillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of skills
	* @param end the upper bound of the range of skills (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of skills
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Skill> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the skills from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of skills.
	*
	* @return the number of skills
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}