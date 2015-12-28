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
 * Provides the local service utility for ResignationHistory. This utility wraps
 * {@link vn.com.ecopharma.emp.service.impl.ResignationHistoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see ResignationHistoryLocalService
 * @see vn.com.ecopharma.emp.service.base.ResignationHistoryLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.impl.ResignationHistoryLocalServiceImpl
 * @generated
 */
public class ResignationHistoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.emp.service.impl.ResignationHistoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the resignation history to the database. Also notifies the appropriate model listeners.
	*
	* @param resignationHistory the resignation history
	* @return the resignation history that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.ResignationHistory addResignationHistory(
		vn.com.ecopharma.emp.model.ResignationHistory resignationHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addResignationHistory(resignationHistory);
	}

	/**
	* Creates a new resignation history with the primary key. Does not add the resignation history to the database.
	*
	* @param resignationHistoryId the primary key for the new resignation history
	* @return the new resignation history
	*/
	public static vn.com.ecopharma.emp.model.ResignationHistory createResignationHistory(
		long resignationHistoryId) {
		return getService().createResignationHistory(resignationHistoryId);
	}

	/**
	* Deletes the resignation history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param resignationHistoryId the primary key of the resignation history
	* @return the resignation history that was removed
	* @throws PortalException if a resignation history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.ResignationHistory deleteResignationHistory(
		long resignationHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteResignationHistory(resignationHistoryId);
	}

	/**
	* Deletes the resignation history from the database. Also notifies the appropriate model listeners.
	*
	* @param resignationHistory the resignation history
	* @return the resignation history that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.ResignationHistory deleteResignationHistory(
		vn.com.ecopharma.emp.model.ResignationHistory resignationHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteResignationHistory(resignationHistory);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResignationHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResignationHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.emp.model.ResignationHistory fetchResignationHistory(
		long resignationHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchResignationHistory(resignationHistoryId);
	}

	/**
	* Returns the resignation history with the primary key.
	*
	* @param resignationHistoryId the primary key of the resignation history
	* @return the resignation history
	* @throws PortalException if a resignation history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.ResignationHistory getResignationHistory(
		long resignationHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getResignationHistory(resignationHistoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the resignation histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResignationHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of resignation histories
	* @param end the upper bound of the range of resignation histories (not inclusive)
	* @return the range of resignation histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.ResignationHistory> getResignationHistories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getResignationHistories(start, end);
	}

	/**
	* Returns the number of resignation histories.
	*
	* @return the number of resignation histories
	* @throws SystemException if a system exception occurred
	*/
	public static int getResignationHistoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getResignationHistoriesCount();
	}

	/**
	* Updates the resignation history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param resignationHistory the resignation history
	* @return the resignation history that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.ResignationHistory updateResignationHistory(
		vn.com.ecopharma.emp.model.ResignationHistory resignationHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateResignationHistory(resignationHistory);
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

	public static java.util.List<vn.com.ecopharma.emp.model.ResignationHistory> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.emp.model.ResignationHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.ResignationHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll(start, end, orderByComparator);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.ResignationHistory> findByEmployee(
		long employeeId) {
		return getService().findByEmployee(employeeId);
	}

	public static vn.com.ecopharma.emp.model.ResignationHistory createPrePersisted() {
		return getService().createPrePersisted();
	}

	public static vn.com.ecopharma.emp.model.ResignationHistory addResignationHistory(
		vn.com.ecopharma.emp.model.ResignationHistory resignationHistory,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addResignationHistory(resignationHistory, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.ResignationHistory updateResignationHistory(
		long resignationHistoryId, java.util.Date resignedDate,
		java.lang.String resignedType, java.lang.String comment) {
		return getService()
				   .updateResignationHistory(resignationHistoryId,
			resignedDate, resignedType, comment);
	}

	public static vn.com.ecopharma.emp.model.ResignationHistory markDeleted(
		vn.com.ecopharma.emp.model.ResignationHistory resignationHistory) {
		return getService().markDeleted(resignationHistory);
	}

	public static int countAllUnDeletedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return getService()
				   .countAllUnDeletedDocuments(searchContext, filterQueries,
			companyId, sort);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return getService()
				   .searchAllUnDeletedDocuments(searchContext, filterQueries,
			companyId, sort, start, end);
	}

	public static com.liferay.portal.kernel.search.Document getIndexedDocument(
		java.lang.String id,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getIndexedDocument(id, searchContext);
	}

	public static com.liferay.portal.kernel.search.Document getIndexedDocument(
		long id, com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getIndexedDocument(id, searchContext);
	}

	public static void indexAll() {
		getService().indexAll();
	}

	public static void removeAllIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		getService().removeAllIndexes(searchContext, companyId);
	}

	public static void addMissingResignedEmployee(
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().addMissingResignedEmployee(serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ResignationHistoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ResignationHistoryLocalService.class.getName());

			if (invokableLocalService instanceof ResignationHistoryLocalService) {
				_service = (ResignationHistoryLocalService)invokableLocalService;
			}
			else {
				_service = new ResignationHistoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ResignationHistoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ResignationHistoryLocalService service) {
	}

	private static ResignationHistoryLocalService _service;
}