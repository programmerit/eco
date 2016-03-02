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
 * Provides a wrapper for {@link EmpDisciplineLocalService}.
 *
 * @author tvt
 * @see EmpDisciplineLocalService
 * @generated
 */
public class EmpDisciplineLocalServiceWrapper
	implements EmpDisciplineLocalService,
		ServiceWrapper<EmpDisciplineLocalService> {
	public EmpDisciplineLocalServiceWrapper(
		EmpDisciplineLocalService empDisciplineLocalService) {
		_empDisciplineLocalService = empDisciplineLocalService;
	}

	/**
	* Adds the emp discipline to the database. Also notifies the appropriate model listeners.
	*
	* @param empDiscipline the emp discipline
	* @return the emp discipline that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpDiscipline addEmpDiscipline(
		vn.com.ecopharma.emp.model.EmpDiscipline empDiscipline)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empDisciplineLocalService.addEmpDiscipline(empDiscipline);
	}

	/**
	* Creates a new emp discipline with the primary key. Does not add the emp discipline to the database.
	*
	* @param empDisciplineId the primary key for the new emp discipline
	* @return the new emp discipline
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpDiscipline createEmpDiscipline(
		long empDisciplineId) {
		return _empDisciplineLocalService.createEmpDiscipline(empDisciplineId);
	}

	/**
	* Deletes the emp discipline with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empDisciplineId the primary key of the emp discipline
	* @return the emp discipline that was removed
	* @throws PortalException if a emp discipline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpDiscipline deleteEmpDiscipline(
		long empDisciplineId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empDisciplineLocalService.deleteEmpDiscipline(empDisciplineId);
	}

	/**
	* Deletes the emp discipline from the database. Also notifies the appropriate model listeners.
	*
	* @param empDiscipline the emp discipline
	* @return the emp discipline that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpDiscipline deleteEmpDiscipline(
		vn.com.ecopharma.emp.model.EmpDiscipline empDiscipline)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empDisciplineLocalService.deleteEmpDiscipline(empDiscipline);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empDisciplineLocalService.dynamicQuery();
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
		return _empDisciplineLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpDisciplineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empDisciplineLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpDisciplineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empDisciplineLocalService.dynamicQuery(dynamicQuery, start,
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
		return _empDisciplineLocalService.dynamicQueryCount(dynamicQuery);
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
		return _empDisciplineLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpDiscipline fetchEmpDiscipline(
		long empDisciplineId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empDisciplineLocalService.fetchEmpDiscipline(empDisciplineId);
	}

	/**
	* Returns the emp discipline with the primary key.
	*
	* @param empDisciplineId the primary key of the emp discipline
	* @return the emp discipline
	* @throws PortalException if a emp discipline with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpDiscipline getEmpDiscipline(
		long empDisciplineId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empDisciplineLocalService.getEmpDiscipline(empDisciplineId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empDisciplineLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the emp disciplines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpDisciplineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp disciplines
	* @param end the upper bound of the range of emp disciplines (not inclusive)
	* @return the range of emp disciplines
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpDiscipline> getEmpDisciplines(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empDisciplineLocalService.getEmpDisciplines(start, end);
	}

	/**
	* Returns the number of emp disciplines.
	*
	* @return the number of emp disciplines
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmpDisciplinesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empDisciplineLocalService.getEmpDisciplinesCount();
	}

	/**
	* Updates the emp discipline in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empDiscipline the emp discipline
	* @return the emp discipline that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpDiscipline updateEmpDiscipline(
		vn.com.ecopharma.emp.model.EmpDiscipline empDiscipline)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empDisciplineLocalService.updateEmpDiscipline(empDiscipline);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empDisciplineLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empDisciplineLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empDisciplineLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpDiscipline> findAll() {
		return _empDisciplineLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpDiscipline> findAll(
		int start, int end) {
		return _empDisciplineLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpDiscipline> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _empDisciplineLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public int countAllDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return _empDisciplineLocalService.countAllDocuments(searchContext,
			filterQueries, companyId, sort);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return _empDisciplineLocalService.searchAllDocuments(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> filterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId, int start,
		int end) throws com.liferay.portal.kernel.search.ParseException {
		return _empDisciplineLocalService.filterByFields(searchContext,
			filters, sort, companyId, start, end);
	}

	@Override
	public int countFilterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId)
		throws com.liferay.portal.kernel.search.ParseException {
		return _empDisciplineLocalService.countFilterByFields(searchContext,
			filters, sort, companyId);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedDocument(
		java.lang.String id,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _empDisciplineLocalService.getIndexedDocument(id, searchContext);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedDocument(
		long id, com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _empDisciplineLocalService.getIndexedDocument(id, searchContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpDiscipline createPrePersistedEntity(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _empDisciplineLocalService.createPrePersistedEntity(serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpDiscipline addEmpDiscipline(
		vn.com.ecopharma.emp.model.EmpDiscipline prePersistedObj,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _empDisciplineLocalService.addEmpDiscipline(prePersistedObj,
			serviceContext);
	}

	@Override
	public void addEmpsDiscipline(java.util.List<java.lang.Long> empIds,
		java.lang.String decisionNo, java.lang.String content,
		java.lang.String type, java.util.Date effectiveDate,
		java.lang.String additionalType, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empDisciplineLocalService.addEmpsDiscipline(empIds, decisionNo,
			content, type, effectiveDate, additionalType, description,
			serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpDiscipline updateEmpDiscipline(
		long id, java.lang.String decisionNo, java.lang.String type,
		java.lang.String content, java.util.Date effectiveDate,
		java.lang.String additionType, java.lang.String desc) {
		return _empDisciplineLocalService.updateEmpDiscipline(id, decisionNo,
			type, content, effectiveDate, additionType, desc);
	}

	@Override
	public void indexAll() {
		_empDisciplineLocalService.indexAll();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpDisciplineLocalService getWrappedEmpDisciplineLocalService() {
		return _empDisciplineLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpDisciplineLocalService(
		EmpDisciplineLocalService empDisciplineLocalService) {
		_empDisciplineLocalService = empDisciplineLocalService;
	}

	@Override
	public EmpDisciplineLocalService getWrappedService() {
		return _empDisciplineLocalService;
	}

	@Override
	public void setWrappedService(
		EmpDisciplineLocalService empDisciplineLocalService) {
		_empDisciplineLocalService = empDisciplineLocalService;
	}

	private EmpDisciplineLocalService _empDisciplineLocalService;
}