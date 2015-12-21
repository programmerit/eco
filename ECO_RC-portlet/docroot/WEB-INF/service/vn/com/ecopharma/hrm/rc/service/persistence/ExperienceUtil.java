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

import vn.com.ecopharma.hrm.rc.model.Experience;

import java.util.List;

/**
 * The persistence utility for the experience service. This utility wraps {@link ExperiencePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see ExperiencePersistence
 * @see ExperiencePersistenceImpl
 * @generated
 */
public class ExperienceUtil {
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
	public static void clearCache(Experience experience) {
		getPersistence().clearCache(experience);
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
	public static List<Experience> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Experience> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Experience> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Experience update(Experience experience)
		throws SystemException {
		return getPersistence().update(experience);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Experience update(Experience experience,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(experience, serviceContext);
	}

	/**
	* Returns all the experiences where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching experiences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Experience> findByClassNameAndClassPK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByClassNameAndClassPK(className, classPK);
	}

	/**
	* Returns a range of all the experiences where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.ExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of experiences
	* @param end the upper bound of the range of experiences (not inclusive)
	* @return the range of matching experiences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Experience> findByClassNameAndClassPK(
		java.lang.String className, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByClassNameAndClassPK(className, classPK, start, end);
	}

	/**
	* Returns an ordered range of all the experiences where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.ExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of experiences
	* @param end the upper bound of the range of experiences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching experiences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Experience> findByClassNameAndClassPK(
		java.lang.String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByClassNameAndClassPK(className, classPK, start, end,
			orderByComparator);
	}

	/**
	* Returns the first experience in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching experience
	* @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a matching experience could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Experience findByClassNameAndClassPK_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchExperienceException {
		return getPersistence()
				   .findByClassNameAndClassPK_First(className, classPK,
			orderByComparator);
	}

	/**
	* Returns the first experience in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching experience, or <code>null</code> if a matching experience could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Experience fetchByClassNameAndClassPK_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClassNameAndClassPK_First(className, classPK,
			orderByComparator);
	}

	/**
	* Returns the last experience in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching experience
	* @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a matching experience could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Experience findByClassNameAndClassPK_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchExperienceException {
		return getPersistence()
				   .findByClassNameAndClassPK_Last(className, classPK,
			orderByComparator);
	}

	/**
	* Returns the last experience in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching experience, or <code>null</code> if a matching experience could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Experience fetchByClassNameAndClassPK_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClassNameAndClassPK_Last(className, classPK,
			orderByComparator);
	}

	/**
	* Returns the experiences before and after the current experience in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param experienceId the primary key of the current experience
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next experience
	* @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Experience[] findByClassNameAndClassPK_PrevAndNext(
		long experienceId, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchExperienceException {
		return getPersistence()
				   .findByClassNameAndClassPK_PrevAndNext(experienceId,
			className, classPK, orderByComparator);
	}

	/**
	* Removes all the experiences where className = &#63; and classPK = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByClassNameAndClassPK(java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByClassNameAndClassPK(className, classPK);
	}

	/**
	* Returns the number of experiences where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching experiences
	* @throws SystemException if a system exception occurred
	*/
	public static int countByClassNameAndClassPK(java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByClassNameAndClassPK(className, classPK);
	}

	/**
	* Returns all the experiences where className = &#63;.
	*
	* @param className the class name
	* @return the matching experiences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Experience> findByClassName(
		java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByClassName(className);
	}

	/**
	* Returns a range of all the experiences where className = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.ExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param start the lower bound of the range of experiences
	* @param end the upper bound of the range of experiences (not inclusive)
	* @return the range of matching experiences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Experience> findByClassName(
		java.lang.String className, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByClassName(className, start, end);
	}

	/**
	* Returns an ordered range of all the experiences where className = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.ExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param start the lower bound of the range of experiences
	* @param end the upper bound of the range of experiences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching experiences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Experience> findByClassName(
		java.lang.String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByClassName(className, start, end, orderByComparator);
	}

	/**
	* Returns the first experience in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching experience
	* @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a matching experience could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Experience findByClassName_First(
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchExperienceException {
		return getPersistence()
				   .findByClassName_First(className, orderByComparator);
	}

	/**
	* Returns the first experience in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching experience, or <code>null</code> if a matching experience could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Experience fetchByClassName_First(
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClassName_First(className, orderByComparator);
	}

	/**
	* Returns the last experience in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching experience
	* @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a matching experience could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Experience findByClassName_Last(
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchExperienceException {
		return getPersistence()
				   .findByClassName_Last(className, orderByComparator);
	}

	/**
	* Returns the last experience in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching experience, or <code>null</code> if a matching experience could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Experience fetchByClassName_Last(
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClassName_Last(className, orderByComparator);
	}

	/**
	* Returns the experiences before and after the current experience in the ordered set where className = &#63;.
	*
	* @param experienceId the primary key of the current experience
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next experience
	* @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Experience[] findByClassName_PrevAndNext(
		long experienceId, java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchExperienceException {
		return getPersistence()
				   .findByClassName_PrevAndNext(experienceId, className,
			orderByComparator);
	}

	/**
	* Removes all the experiences where className = &#63; from the database.
	*
	* @param className the class name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByClassName(java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByClassName(className);
	}

	/**
	* Returns the number of experiences where className = &#63;.
	*
	* @param className the class name
	* @return the number of matching experiences
	* @throws SystemException if a system exception occurred
	*/
	public static int countByClassName(java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByClassName(className);
	}

	/**
	* Caches the experience in the entity cache if it is enabled.
	*
	* @param experience the experience
	*/
	public static void cacheResult(
		vn.com.ecopharma.hrm.rc.model.Experience experience) {
		getPersistence().cacheResult(experience);
	}

	/**
	* Caches the experiences in the entity cache if it is enabled.
	*
	* @param experiences the experiences
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.hrm.rc.model.Experience> experiences) {
		getPersistence().cacheResult(experiences);
	}

	/**
	* Creates a new experience with the primary key. Does not add the experience to the database.
	*
	* @param experienceId the primary key for the new experience
	* @return the new experience
	*/
	public static vn.com.ecopharma.hrm.rc.model.Experience create(
		long experienceId) {
		return getPersistence().create(experienceId);
	}

	/**
	* Removes the experience with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param experienceId the primary key of the experience
	* @return the experience that was removed
	* @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Experience remove(
		long experienceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchExperienceException {
		return getPersistence().remove(experienceId);
	}

	public static vn.com.ecopharma.hrm.rc.model.Experience updateImpl(
		vn.com.ecopharma.hrm.rc.model.Experience experience)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(experience);
	}

	/**
	* Returns the experience with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchExperienceException} if it could not be found.
	*
	* @param experienceId the primary key of the experience
	* @return the experience
	* @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Experience findByPrimaryKey(
		long experienceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchExperienceException {
		return getPersistence().findByPrimaryKey(experienceId);
	}

	/**
	* Returns the experience with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param experienceId the primary key of the experience
	* @return the experience, or <code>null</code> if a experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Experience fetchByPrimaryKey(
		long experienceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(experienceId);
	}

	/**
	* Returns all the experiences.
	*
	* @return the experiences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Experience> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the experiences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.ExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of experiences
	* @param end the upper bound of the range of experiences (not inclusive)
	* @return the range of experiences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Experience> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the experiences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.ExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of experiences
	* @param end the upper bound of the range of experiences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of experiences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Experience> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the experiences from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of experiences.
	*
	* @return the number of experiences
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ExperiencePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ExperiencePersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.hrm.rc.service.ClpSerializer.getServletContextName(),
					ExperiencePersistence.class.getName());

			ReferenceRegistry.registerReference(ExperienceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ExperiencePersistence persistence) {
	}

	private static ExperiencePersistence _persistence;
}