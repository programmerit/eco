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
 * Provides a wrapper for {@link ResignationHistoryLocalService}.
 *
 * @author tvt
 * @see ResignationHistoryLocalService
 * @generated
 */
public class ResignationHistoryLocalServiceWrapper
	implements ResignationHistoryLocalService,
		ServiceWrapper<ResignationHistoryLocalService> {
	public ResignationHistoryLocalServiceWrapper(
		ResignationHistoryLocalService resignationHistoryLocalService) {
		_resignationHistoryLocalService = resignationHistoryLocalService;
	}

	/**
	* Adds the resignation history to the database. Also notifies the appropriate model listeners.
	*
	* @param resignationHistory the resignation history
	* @return the resignation history that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.ResignationHistory addResignationHistory(
		vn.com.ecopharma.emp.model.ResignationHistory resignationHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resignationHistoryLocalService.addResignationHistory(resignationHistory);
	}

	/**
	* Creates a new resignation history with the primary key. Does not add the resignation history to the database.
	*
	* @param resignationHistoryId the primary key for the new resignation history
	* @return the new resignation history
	*/
	@Override
	public vn.com.ecopharma.emp.model.ResignationHistory createResignationHistory(
		long resignationHistoryId) {
		return _resignationHistoryLocalService.createResignationHistory(resignationHistoryId);
	}

	/**
	* Deletes the resignation history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param resignationHistoryId the primary key of the resignation history
	* @return the resignation history that was removed
	* @throws PortalException if a resignation history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.ResignationHistory deleteResignationHistory(
		long resignationHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _resignationHistoryLocalService.deleteResignationHistory(resignationHistoryId);
	}

	/**
	* Deletes the resignation history from the database. Also notifies the appropriate model listeners.
	*
	* @param resignationHistory the resignation history
	* @return the resignation history that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.ResignationHistory deleteResignationHistory(
		vn.com.ecopharma.emp.model.ResignationHistory resignationHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resignationHistoryLocalService.deleteResignationHistory(resignationHistory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _resignationHistoryLocalService.dynamicQuery();
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
		return _resignationHistoryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _resignationHistoryLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resignationHistoryLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _resignationHistoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _resignationHistoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.ResignationHistory fetchResignationHistory(
		long resignationHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resignationHistoryLocalService.fetchResignationHistory(resignationHistoryId);
	}

	/**
	* Returns the resignation history with the primary key.
	*
	* @param resignationHistoryId the primary key of the resignation history
	* @return the resignation history
	* @throws PortalException if a resignation history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.ResignationHistory getResignationHistory(
		long resignationHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _resignationHistoryLocalService.getResignationHistory(resignationHistoryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _resignationHistoryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.ResignationHistory> getResignationHistories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resignationHistoryLocalService.getResignationHistories(start,
			end);
	}

	/**
	* Returns the number of resignation histories.
	*
	* @return the number of resignation histories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getResignationHistoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resignationHistoryLocalService.getResignationHistoriesCount();
	}

	/**
	* Updates the resignation history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param resignationHistory the resignation history
	* @return the resignation history that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.ResignationHistory updateResignationHistory(
		vn.com.ecopharma.emp.model.ResignationHistory resignationHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resignationHistoryLocalService.updateResignationHistory(resignationHistory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _resignationHistoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_resignationHistoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _resignationHistoryLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.ResignationHistory> findAll() {
		return _resignationHistoryLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.ResignationHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resignationHistoryLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.ResignationHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resignationHistoryLocalService.findAll(start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.ResignationHistory> findByEmployee(
		long employeeId) {
		return _resignationHistoryLocalService.findByEmployee(employeeId);
	}

	@Override
	public vn.com.ecopharma.emp.model.ResignationHistory createPrePersisted() {
		return _resignationHistoryLocalService.createPrePersisted();
	}

	@Override
	public vn.com.ecopharma.emp.model.ResignationHistory createPrePersisted(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _resignationHistoryLocalService.createPrePersisted(serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.ResignationHistory addResignationHistory(
		vn.com.ecopharma.emp.model.ResignationHistory resignationHistory,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _resignationHistoryLocalService.addResignationHistory(resignationHistory,
			serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.ResignationHistory addResignationHistory(
		long empId, java.util.Date resignedDate, java.lang.String reason,
		java.lang.String comment,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _resignationHistoryLocalService.addResignationHistory(empId,
			resignedDate, reason, comment, serviceContext);
	}

	@Override
	public void addEmpsResignationHistory(java.util.List<java.lang.Long> emps,
		java.util.Date resignedDate, java.lang.String reason,
		java.lang.String comment,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_resignationHistoryLocalService.addEmpsResignationHistory(emps,
			resignedDate, reason, comment, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.ResignationHistory updateResignationHistory(
		long resignationHistoryId, java.util.Date resignedDate,
		java.lang.String resignedType, java.lang.String comment) {
		return _resignationHistoryLocalService.updateResignationHistory(resignationHistoryId,
			resignedDate, resignedType, comment);
	}

	@Override
	public vn.com.ecopharma.emp.model.ResignationHistory markDeleted(
		vn.com.ecopharma.emp.model.ResignationHistory resignationHistory) {
		return _resignationHistoryLocalService.markDeleted(resignationHistory);
	}

	@Override
	public int countSearchAllDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return _resignationHistoryLocalService.countSearchAllDocuments(searchContext,
			filterQueries, companyId, sort);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return _resignationHistoryLocalService.searchAllDocuments(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> filterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId, int start,
		int end) throws com.liferay.portal.kernel.search.ParseException {
		return _resignationHistoryLocalService.filterByFields(searchContext,
			filters, sort, companyId, start, end);
	}

	@Override
	public int countFilterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId)
		throws com.liferay.portal.kernel.search.ParseException {
		return _resignationHistoryLocalService.countFilterByFields(searchContext,
			filters, sort, companyId);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedDocument(
		java.lang.String id,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _resignationHistoryLocalService.getIndexedDocument(id,
			searchContext);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedDocument(
		long id, com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _resignationHistoryLocalService.getIndexedDocument(id,
			searchContext);
	}

	@Override
	public void indexAll() {
		_resignationHistoryLocalService.indexAll();
	}

	@Override
	public void removeAllIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		_resignationHistoryLocalService.removeAllIndexes(searchContext,
			companyId);
	}

	@Override
	public void addMissingResignedEmployee(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_resignationHistoryLocalService.addMissingResignedEmployee(serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ResignationHistoryLocalService getWrappedResignationHistoryLocalService() {
		return _resignationHistoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedResignationHistoryLocalService(
		ResignationHistoryLocalService resignationHistoryLocalService) {
		_resignationHistoryLocalService = resignationHistoryLocalService;
	}

	@Override
	public ResignationHistoryLocalService getWrappedService() {
		return _resignationHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		ResignationHistoryLocalService resignationHistoryLocalService) {
		_resignationHistoryLocalService = resignationHistoryLocalService;
	}

	private ResignationHistoryLocalService _resignationHistoryLocalService;
}