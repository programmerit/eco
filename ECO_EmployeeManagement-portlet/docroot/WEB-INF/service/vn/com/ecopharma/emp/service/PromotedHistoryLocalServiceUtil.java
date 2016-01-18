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
 * Provides the local service utility for PromotedHistory. This utility wraps
 * {@link vn.com.ecopharma.emp.service.impl.PromotedHistoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see PromotedHistoryLocalService
 * @see vn.com.ecopharma.emp.service.base.PromotedHistoryLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.impl.PromotedHistoryLocalServiceImpl
 * @generated
 */
public class PromotedHistoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.emp.service.impl.PromotedHistoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the promoted history to the database. Also notifies the appropriate model listeners.
	*
	* @param promotedHistory the promoted history
	* @return the promoted history that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.PromotedHistory addPromotedHistory(
		vn.com.ecopharma.emp.model.PromotedHistory promotedHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPromotedHistory(promotedHistory);
	}

	/**
	* Creates a new promoted history with the primary key. Does not add the promoted history to the database.
	*
	* @param promotedHistoryId the primary key for the new promoted history
	* @return the new promoted history
	*/
	public static vn.com.ecopharma.emp.model.PromotedHistory createPromotedHistory(
		long promotedHistoryId) {
		return getService().createPromotedHistory(promotedHistoryId);
	}

	/**
	* Deletes the promoted history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param promotedHistoryId the primary key of the promoted history
	* @return the promoted history that was removed
	* @throws PortalException if a promoted history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.PromotedHistory deletePromotedHistory(
		long promotedHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePromotedHistory(promotedHistoryId);
	}

	/**
	* Deletes the promoted history from the database. Also notifies the appropriate model listeners.
	*
	* @param promotedHistory the promoted history
	* @return the promoted history that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.PromotedHistory deletePromotedHistory(
		vn.com.ecopharma.emp.model.PromotedHistory promotedHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePromotedHistory(promotedHistory);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.emp.model.PromotedHistory fetchPromotedHistory(
		long promotedHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPromotedHistory(promotedHistoryId);
	}

	/**
	* Returns the promoted history with the primary key.
	*
	* @param promotedHistoryId the primary key of the promoted history
	* @return the promoted history
	* @throws PortalException if a promoted history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.PromotedHistory getPromotedHistory(
		long promotedHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPromotedHistory(promotedHistoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the promoted histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of promoted histories
	* @param end the upper bound of the range of promoted histories (not inclusive)
	* @return the range of promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> getPromotedHistories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPromotedHistories(start, end);
	}

	/**
	* Returns the number of promoted histories.
	*
	* @return the number of promoted histories
	* @throws SystemException if a system exception occurred
	*/
	public static int getPromotedHistoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPromotedHistoriesCount();
	}

	/**
	* Updates the promoted history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param promotedHistory the promoted history
	* @return the promoted history that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.PromotedHistory updatePromotedHistory(
		vn.com.ecopharma.emp.model.PromotedHistory promotedHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePromotedHistory(promotedHistory);
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

	public static java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findByEmployee(
		long employeeId) {
		return getService().findByEmployee(employeeId);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findByOldTitles(
		long oldTitlesId) {
		return getService().findByOldTitles(oldTitlesId);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findByNewTitles(
		long newTitlesId) {
		return getService().findByNewTitles(newTitlesId);
	}

	public static vn.com.ecopharma.emp.model.PromotedHistory createPrePersisted() {
		return getService().createPrePersisted();
	}

	public static vn.com.ecopharma.emp.model.PromotedHistory addPromotedHistory(
		vn.com.ecopharma.emp.model.PromotedHistory promotedHistory,
		long unitGroupId, long unitId, long departmentId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addPromotedHistory(promotedHistory, unitGroupId, unitId,
			departmentId, serviceContext);
	}

	public static vn.com.ecopharma.emp.model.PromotedHistory markDeleted(
		vn.com.ecopharma.emp.model.PromotedHistory promotedHistory) {
		return getService().markDeleted(promotedHistory);
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

	public static void clearService() {
		_service = null;
	}

	public static PromotedHistoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PromotedHistoryLocalService.class.getName());

			if (invokableLocalService instanceof PromotedHistoryLocalService) {
				_service = (PromotedHistoryLocalService)invokableLocalService;
			}
			else {
				_service = new PromotedHistoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PromotedHistoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PromotedHistoryLocalService service) {
	}

	private static PromotedHistoryLocalService _service;
}