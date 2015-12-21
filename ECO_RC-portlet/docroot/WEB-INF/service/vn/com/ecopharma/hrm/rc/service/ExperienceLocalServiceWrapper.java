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

package vn.com.ecopharma.hrm.rc.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ExperienceLocalService}.
 *
 * @author tvt
 * @see ExperienceLocalService
 * @generated
 */
public class ExperienceLocalServiceWrapper implements ExperienceLocalService,
	ServiceWrapper<ExperienceLocalService> {
	public ExperienceLocalServiceWrapper(
		ExperienceLocalService experienceLocalService) {
		_experienceLocalService = experienceLocalService;
	}

	/**
	* Adds the experience to the database. Also notifies the appropriate model listeners.
	*
	* @param experience the experience
	* @return the experience that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Experience addExperience(
		vn.com.ecopharma.hrm.rc.model.Experience experience)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _experienceLocalService.addExperience(experience);
	}

	/**
	* Creates a new experience with the primary key. Does not add the experience to the database.
	*
	* @param experienceId the primary key for the new experience
	* @return the new experience
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Experience createExperience(
		long experienceId) {
		return _experienceLocalService.createExperience(experienceId);
	}

	/**
	* Deletes the experience with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param experienceId the primary key of the experience
	* @return the experience that was removed
	* @throws PortalException if a experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Experience deleteExperience(
		long experienceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _experienceLocalService.deleteExperience(experienceId);
	}

	/**
	* Deletes the experience from the database. Also notifies the appropriate model listeners.
	*
	* @param experience the experience
	* @return the experience that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Experience deleteExperience(
		vn.com.ecopharma.hrm.rc.model.Experience experience)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _experienceLocalService.deleteExperience(experience);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _experienceLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _experienceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.ExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _experienceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.ExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _experienceLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _experienceLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _experienceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Experience fetchExperience(
		long experienceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _experienceLocalService.fetchExperience(experienceId);
	}

	/**
	* Returns the experience with the primary key.
	*
	* @param experienceId the primary key of the experience
	* @return the experience
	* @throws PortalException if a experience with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Experience getExperience(
		long experienceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _experienceLocalService.getExperience(experienceId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _experienceLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Experience> getExperiences(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _experienceLocalService.getExperiences(start, end);
	}

	/**
	* Returns the number of experiences.
	*
	* @return the number of experiences
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getExperiencesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _experienceLocalService.getExperiencesCount();
	}

	/**
	* Updates the experience in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param experience the experience
	* @return the experience that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Experience updateExperience(
		vn.com.ecopharma.hrm.rc.model.Experience experience)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _experienceLocalService.updateExperience(experience);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _experienceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_experienceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _experienceLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Experience> findAll() {
		return _experienceLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Experience> findAll(
		int start, int end) {
		return _experienceLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Experience> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _experienceLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Experience> findByClassNameAndClassPK(
		java.lang.String className, long classPK) {
		return _experienceLocalService.findByClassNameAndClassPK(className,
			classPK);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Experience> findByClassName(
		java.lang.String className) {
		return _experienceLocalService.findByClassName(className);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Experience createPrePersitedExperience(
		java.lang.String className, long classPK) {
		return _experienceLocalService.createPrePersitedExperience(className,
			classPK);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Experience addExperience(
		vn.com.ecopharma.hrm.rc.model.Experience experience,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _experienceLocalService.addExperience(experience, serviceContext);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Experience addExperience(
		java.lang.String className, long classPK,
		java.lang.String workingPlace, double yearsExperience,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _experienceLocalService.addExperience(className, classPK,
			workingPlace, yearsExperience, description, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ExperienceLocalService getWrappedExperienceLocalService() {
		return _experienceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedExperienceLocalService(
		ExperienceLocalService experienceLocalService) {
		_experienceLocalService = experienceLocalService;
	}

	@Override
	public ExperienceLocalService getWrappedService() {
		return _experienceLocalService;
	}

	@Override
	public void setWrappedService(ExperienceLocalService experienceLocalService) {
		_experienceLocalService = experienceLocalService;
	}

	private ExperienceLocalService _experienceLocalService;
}