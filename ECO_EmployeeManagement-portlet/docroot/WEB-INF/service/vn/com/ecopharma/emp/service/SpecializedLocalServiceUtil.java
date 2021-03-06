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

package vn.com.ecopharma.emp.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Specialized. This utility wraps
 * {@link vn.com.ecopharma.emp.service.impl.SpecializedLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see SpecializedLocalService
 * @see vn.com.ecopharma.emp.service.base.SpecializedLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.impl.SpecializedLocalServiceImpl
 * @generated
 */
public class SpecializedLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.emp.service.impl.SpecializedLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the specialized to the database. Also notifies the appropriate model listeners.
	*
	* @param specialized the specialized
	* @return the specialized that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized addSpecialized(
		vn.com.ecopharma.emp.model.Specialized specialized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSpecialized(specialized);
	}

	/**
	* Creates a new specialized with the primary key. Does not add the specialized to the database.
	*
	* @param specializedId the primary key for the new specialized
	* @return the new specialized
	*/
	public static vn.com.ecopharma.emp.model.Specialized createSpecialized(
		long specializedId) {
		return getService().createSpecialized(specializedId);
	}

	/**
	* Deletes the specialized with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param specializedId the primary key of the specialized
	* @return the specialized that was removed
	* @throws PortalException if a specialized with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized deleteSpecialized(
		long specializedId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSpecialized(specializedId);
	}

	/**
	* Deletes the specialized from the database. Also notifies the appropriate model listeners.
	*
	* @param specialized the specialized
	* @return the specialized that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized deleteSpecialized(
		vn.com.ecopharma.emp.model.Specialized specialized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSpecialized(specialized);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static vn.com.ecopharma.emp.model.Specialized fetchSpecialized(
		long specializedId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSpecialized(specializedId);
	}

	/**
	* Returns the specialized with the primary key.
	*
	* @param specializedId the primary key of the specialized
	* @return the specialized
	* @throws PortalException if a specialized with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized getSpecialized(
		long specializedId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSpecialized(specializedId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the specializeds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of specializeds
	* @param end the upper bound of the range of specializeds (not inclusive)
	* @return the range of specializeds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> getSpecializeds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSpecializeds(start, end);
	}

	/**
	* Returns the number of specializeds.
	*
	* @return the number of specializeds
	* @throws SystemException if a system exception occurred
	*/
	public static int getSpecializedsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSpecializedsCount();
	}

	/**
	* Updates the specialized in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param specialized the specialized
	* @return the specialized that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized updateSpecialized(
		vn.com.ecopharma.emp.model.Specialized specialized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSpecialized(specialized);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> findAll() {
		return getService().findAll();
	}

	public static vn.com.ecopharma.emp.model.Specialized findByName(
		java.lang.String name) {
		return getService().findByName(name);
	}

	public static vn.com.ecopharma.emp.model.Specialized createPreperistedEntity(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().createPreperistedEntity(serviceContext);
	}

	public static vn.com.ecopharma.emp.model.Specialized createSpecialized(
		vn.com.ecopharma.emp.model.Specialized preObj, java.lang.String code,
		java.lang.String name, int level, long parentId, boolean isUniversity,
		boolean isCollege, boolean isVocationalCollege, boolean isVocational) {
		return getService()
				   .createSpecialized(preObj, code, name, level, parentId,
			isUniversity, isCollege, isVocationalCollege, isVocational);
	}

	public static vn.com.ecopharma.emp.model.Specialized createSpecialized(
		java.lang.String code, java.lang.String name, int level, long parentId,
		boolean isUniversity, boolean isCollege, boolean isVocationalCollege,
		boolean isVocational,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .createSpecialized(code, name, level, parentId,
			isUniversity, isCollege, isVocationalCollege, isVocational,
			serviceContext);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> findByLevel(
		int level) {
		return getService().findByLevel(level);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> findFirstLevelList() {
		return getService().findFirstLevelList();
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> findByLevelAndParent(
		int level, long parentId) {
		return getService().findByLevelAndParent(level, parentId);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> findSecondLevelList(
		long parentId) {
		return getService().findSecondLevelList(parentId);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> findThirdLevelList(
		long parentId) {
		return getService().findThirdLevelList(parentId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SpecializedLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SpecializedLocalService.class.getName());

			if (invokableLocalService instanceof SpecializedLocalService) {
				_service = (SpecializedLocalService)invokableLocalService;
			}
			else {
				_service = new SpecializedLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SpecializedLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SpecializedLocalService service) {
	}

	private static SpecializedLocalService _service;
}