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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PromotedHistoryLocalService}.
 *
 * @author tvt
 * @see PromotedHistoryLocalService
 * @generated
 */
public class PromotedHistoryLocalServiceWrapper
	implements PromotedHistoryLocalService,
		ServiceWrapper<PromotedHistoryLocalService> {
	public PromotedHistoryLocalServiceWrapper(
		PromotedHistoryLocalService promotedHistoryLocalService) {
		_promotedHistoryLocalService = promotedHistoryLocalService;
	}

	/**
	* Adds the promoted history to the database. Also notifies the appropriate model listeners.
	*
	* @param promotedHistory the promoted history
	* @return the promoted history that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.PromotedHistory addPromotedHistory(
		vn.com.ecopharma.emp.model.PromotedHistory promotedHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _promotedHistoryLocalService.addPromotedHistory(promotedHistory);
	}

	/**
	* Creates a new promoted history with the primary key. Does not add the promoted history to the database.
	*
	* @param promotedHistoryId the primary key for the new promoted history
	* @return the new promoted history
	*/
	@Override
	public vn.com.ecopharma.emp.model.PromotedHistory createPromotedHistory(
		long promotedHistoryId) {
		return _promotedHistoryLocalService.createPromotedHistory(promotedHistoryId);
	}

	/**
	* Deletes the promoted history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param promotedHistoryId the primary key of the promoted history
	* @return the promoted history that was removed
	* @throws PortalException if a promoted history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.PromotedHistory deletePromotedHistory(
		long promotedHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _promotedHistoryLocalService.deletePromotedHistory(promotedHistoryId);
	}

	/**
	* Deletes the promoted history from the database. Also notifies the appropriate model listeners.
	*
	* @param promotedHistory the promoted history
	* @return the promoted history that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.PromotedHistory deletePromotedHistory(
		vn.com.ecopharma.emp.model.PromotedHistory promotedHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _promotedHistoryLocalService.deletePromotedHistory(promotedHistory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _promotedHistoryLocalService.dynamicQuery();
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
		return _promotedHistoryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _promotedHistoryLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _promotedHistoryLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _promotedHistoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _promotedHistoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.PromotedHistory fetchPromotedHistory(
		long promotedHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _promotedHistoryLocalService.fetchPromotedHistory(promotedHistoryId);
	}

	/**
	* Returns the promoted history with the primary key.
	*
	* @param promotedHistoryId the primary key of the promoted history
	* @return the promoted history
	* @throws PortalException if a promoted history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.PromotedHistory getPromotedHistory(
		long promotedHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _promotedHistoryLocalService.getPromotedHistory(promotedHistoryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _promotedHistoryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> getPromotedHistories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _promotedHistoryLocalService.getPromotedHistories(start, end);
	}

	/**
	* Returns the number of promoted histories.
	*
	* @return the number of promoted histories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPromotedHistoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _promotedHistoryLocalService.getPromotedHistoriesCount();
	}

	/**
	* Updates the promoted history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param promotedHistory the promoted history
	* @return the promoted history that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.PromotedHistory updatePromotedHistory(
		vn.com.ecopharma.emp.model.PromotedHistory promotedHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _promotedHistoryLocalService.updatePromotedHistory(promotedHistory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _promotedHistoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_promotedHistoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _promotedHistoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findAll() {
		return _promotedHistoryLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findAll(
		int start, int end) {
		return _promotedHistoryLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _promotedHistoryLocalService.findAll(start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findByEmployee(
		long employeeId) {
		return _promotedHistoryLocalService.findByEmployee(employeeId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findByOldTitles(
		long oldTitlesId) {
		return _promotedHistoryLocalService.findByOldTitles(oldTitlesId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.PromotedHistory> findByNewTitles(
		long newTitlesId) {
		return _promotedHistoryLocalService.findByNewTitles(newTitlesId);
	}

	@Override
	public vn.com.ecopharma.emp.model.PromotedHistory createPrePersisted() {
		return _promotedHistoryLocalService.createPrePersisted();
	}

	@Override
	public vn.com.ecopharma.emp.model.PromotedHistory addPromotedHistory(
		vn.com.ecopharma.emp.model.PromotedHistory promotedHistory,
		long unitGroupId, long unitId, long departmentId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _promotedHistoryLocalService.addPromotedHistory(promotedHistory,
			unitGroupId, unitId, departmentId, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.PromotedHistory updatePromotedHistory(
		long id, java.util.Date promotedDate, java.lang.String comment,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _promotedHistoryLocalService.updatePromotedHistory(id,
			promotedDate, comment, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.PromotedHistory markDeleted(
		vn.com.ecopharma.emp.model.PromotedHistory promotedHistory) {
		return _promotedHistoryLocalService.markDeleted(promotedHistory);
	}

	@Override
	public int countAllDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return _promotedHistoryLocalService.countAllDocuments(searchContext,
			filterQueries, companyId, sort);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return _promotedHistoryLocalService.searchAllDocuments(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> filterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId, int start,
		int end) throws com.liferay.portal.kernel.search.ParseException {
		return _promotedHistoryLocalService.filterByFields(searchContext,
			filters, sort, companyId, start, end);
	}

	@Override
	public int countFilterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId)
		throws com.liferay.portal.kernel.search.ParseException {
		return _promotedHistoryLocalService.countFilterByFields(searchContext,
			filters, sort, companyId);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedDocument(
		java.lang.String id,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _promotedHistoryLocalService.getIndexedDocument(id, searchContext);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedDocument(
		long id, com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _promotedHistoryLocalService.getIndexedDocument(id, searchContext);
	}

	@Override
	public void indexAll() {
		_promotedHistoryLocalService.indexAll();
	}

	@Override
	public void removeAllIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		_promotedHistoryLocalService.removeAllIndexes(searchContext, companyId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PromotedHistoryLocalService getWrappedPromotedHistoryLocalService() {
		return _promotedHistoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPromotedHistoryLocalService(
		PromotedHistoryLocalService promotedHistoryLocalService) {
		_promotedHistoryLocalService = promotedHistoryLocalService;
	}

	@Override
	public PromotedHistoryLocalService getWrappedService() {
		return _promotedHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		PromotedHistoryLocalService promotedHistoryLocalService) {
		_promotedHistoryLocalService = promotedHistoryLocalService;
	}

	private PromotedHistoryLocalService _promotedHistoryLocalService;
}