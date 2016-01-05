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
 * Provides the local service utility for TitlesUnitUnitGroup. This utility wraps
 * {@link vn.com.ecopharma.emp.service.impl.TitlesUnitUnitGroupLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see TitlesUnitUnitGroupLocalService
 * @see vn.com.ecopharma.emp.service.base.TitlesUnitUnitGroupLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.impl.TitlesUnitUnitGroupLocalServiceImpl
 * @generated
 */
public class TitlesUnitUnitGroupLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.emp.service.impl.TitlesUnitUnitGroupLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the titles unit unit group to the database. Also notifies the appropriate model listeners.
	*
	* @param titlesUnitUnitGroup the titles unit unit group
	* @return the titles unit unit group that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup addTitlesUnitUnitGroup(
		vn.com.ecopharma.emp.model.TitlesUnitUnitGroup titlesUnitUnitGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTitlesUnitUnitGroup(titlesUnitUnitGroup);
	}

	/**
	* Creates a new titles unit unit group with the primary key. Does not add the titles unit unit group to the database.
	*
	* @param titlesUnitUnitGroupId the primary key for the new titles unit unit group
	* @return the new titles unit unit group
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup createTitlesUnitUnitGroup(
		long titlesUnitUnitGroupId) {
		return getService().createTitlesUnitUnitGroup(titlesUnitUnitGroupId);
	}

	/**
	* Deletes the titles unit unit group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param titlesUnitUnitGroupId the primary key of the titles unit unit group
	* @return the titles unit unit group that was removed
	* @throws PortalException if a titles unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup deleteTitlesUnitUnitGroup(
		long titlesUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTitlesUnitUnitGroup(titlesUnitUnitGroupId);
	}

	/**
	* Deletes the titles unit unit group from the database. Also notifies the appropriate model listeners.
	*
	* @param titlesUnitUnitGroup the titles unit unit group
	* @return the titles unit unit group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup deleteTitlesUnitUnitGroup(
		vn.com.ecopharma.emp.model.TitlesUnitUnitGroup titlesUnitUnitGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTitlesUnitUnitGroup(titlesUnitUnitGroup);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchTitlesUnitUnitGroup(
		long titlesUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTitlesUnitUnitGroup(titlesUnitUnitGroupId);
	}

	/**
	* Returns the titles unit unit group with the primary key.
	*
	* @param titlesUnitUnitGroupId the primary key of the titles unit unit group
	* @return the titles unit unit group
	* @throws PortalException if a titles unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup getTitlesUnitUnitGroup(
		long titlesUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTitlesUnitUnitGroup(titlesUnitUnitGroupId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the titles unit unit groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of titles unit unit groups
	* @param end the upper bound of the range of titles unit unit groups (not inclusive)
	* @return the range of titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> getTitlesUnitUnitGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTitlesUnitUnitGroups(start, end);
	}

	/**
	* Returns the number of titles unit unit groups.
	*
	* @return the number of titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int getTitlesUnitUnitGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTitlesUnitUnitGroupsCount();
	}

	/**
	* Updates the titles unit unit group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param titlesUnitUnitGroup the titles unit unit group
	* @return the titles unit unit group that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup updateTitlesUnitUnitGroup(
		vn.com.ecopharma.emp.model.TitlesUnitUnitGroup titlesUnitUnitGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTitlesUnitUnitGroup(titlesUnitUnitGroup);
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

	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByTitlesUnitUnitGroup(
		long titlesId, long unitId, long unitGroupId) {
		return getService()
				   .findByTitlesUnitUnitGroup(titlesId, unitId, unitGroupId);
	}

	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByTitlesUnitUnitGroup(
		vn.com.ecopharma.emp.model.Titles titles,
		vn.com.ecopharma.emp.model.Unit unit,
		vn.com.ecopharma.emp.model.UnitGroup unitGroup) {
		return getService().findByTitlesUnitUnitGroup(titles, unit, unitGroup);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByTitles(
		long titlesId) {
		return getService().findByTitles(titlesId);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByTitles(
		vn.com.ecopharma.emp.model.Titles titles) {
		return getService().findByTitles(titles);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnitAndNoneUnitGroup(
		long unitId) {
		return getService().findByUnitAndNoneUnitGroup(unitId);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnitAndNoneUnitGroup(
		vn.com.ecopharma.emp.model.Unit unit) {
		return getService().findByUnitAndNoneUnitGroup(unit);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnitGroup(
		vn.com.ecopharma.emp.model.UnitGroup unitGroup) {
		return getService().findByUnitGroup(unitGroup);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnitGroup(
		long unitGroupId) {
		return getService().findByUnitGroup(unitGroupId);
	}

	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup addTitlesUnitUnitGroup(
		long titlesId, long unitGroupId, long unitId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addTitlesUnitUnitGroup(titlesId, unitGroupId, unitId,
			serviceContext);
	}

	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup addTitlesUnitUnitGroup(
		vn.com.ecopharma.emp.model.Titles titles,
		vn.com.ecopharma.emp.model.Unit unit,
		vn.com.ecopharma.emp.model.UnitGroup unitGroup,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addTitlesUnitUnitGroup(titles, unit, unitGroup,
			serviceContext);
	}

	public static void completelyRemoveAll() {
		getService().completelyRemoveAll();
	}

	public static void clearService() {
		_service = null;
	}

	public static TitlesUnitUnitGroupLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TitlesUnitUnitGroupLocalService.class.getName());

			if (invokableLocalService instanceof TitlesUnitUnitGroupLocalService) {
				_service = (TitlesUnitUnitGroupLocalService)invokableLocalService;
			}
			else {
				_service = new TitlesUnitUnitGroupLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TitlesUnitUnitGroupLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TitlesUnitUnitGroupLocalService service) {
	}

	private static TitlesUnitUnitGroupLocalService _service;
}