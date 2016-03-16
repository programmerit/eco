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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Vacancy. This utility wraps
 * {@link vn.com.ecopharma.hrm.rc.service.impl.VacancyLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see VacancyLocalService
 * @see vn.com.ecopharma.hrm.rc.service.base.VacancyLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.impl.VacancyLocalServiceImpl
 * @generated
 */
public class VacancyLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.hrm.rc.service.impl.VacancyLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the vacancy to the database. Also notifies the appropriate model listeners.
	*
	* @param vacancy the vacancy
	* @return the vacancy that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy addVacancy(
		vn.com.ecopharma.hrm.rc.model.Vacancy vacancy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVacancy(vacancy);
	}

	/**
	* Creates a new vacancy with the primary key. Does not add the vacancy to the database.
	*
	* @param vacancyId the primary key for the new vacancy
	* @return the new vacancy
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy createVacancy(
		long vacancyId) {
		return getService().createVacancy(vacancyId);
	}

	/**
	* Deletes the vacancy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vacancyId the primary key of the vacancy
	* @return the vacancy that was removed
	* @throws PortalException if a vacancy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy deleteVacancy(
		long vacancyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVacancy(vacancyId);
	}

	/**
	* Deletes the vacancy from the database. Also notifies the appropriate model listeners.
	*
	* @param vacancy the vacancy
	* @return the vacancy that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy deleteVacancy(
		vn.com.ecopharma.hrm.rc.model.Vacancy vacancy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVacancy(vacancy);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.hrm.rc.model.Vacancy fetchVacancy(
		long vacancyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVacancy(vacancyId);
	}

	/**
	* Returns the vacancy with the primary key.
	*
	* @param vacancyId the primary key of the vacancy
	* @return the vacancy
	* @throws PortalException if a vacancy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy getVacancy(
		long vacancyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVacancy(vacancyId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vacancies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vacancies
	* @param end the upper bound of the range of vacancies (not inclusive)
	* @return the range of vacancies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Vacancy> getVacancies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVacancies(start, end);
	}

	/**
	* Returns the number of vacancies.
	*
	* @return the number of vacancies
	* @throws SystemException if a system exception occurred
	*/
	public static int getVacanciesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVacanciesCount();
	}

	/**
	* Updates the vacancy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vacancy the vacancy
	* @return the vacancy that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Vacancy updateVacancy(
		vn.com.ecopharma.hrm.rc.model.Vacancy vacancy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVacancy(vacancy);
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

	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Vacancy> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Vacancy> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Vacancy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Vacancy> findAllUnDeleted() {
		return getService().findAllUnDeleted();
	}

	public static int countAllUnDeletedIndexedVacancyDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return getService()
				   .countAllUnDeletedIndexedVacancyDocuments(searchContext,
			filterQueries, companyId, sort);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedVacanciesIndexedDocument(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return getService()
				   .searchAllUnDeletedVacanciesIndexedDocument(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	public static int countAllUnDeletedAndPublishedIndexedVacancyDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return getService()
				   .countAllUnDeletedAndPublishedIndexedVacancyDocuments(searchContext,
			filterQueries, companyId, sort);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedAndPublishedVacanciesIndexedDocument(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return getService()
				   .searchAllUnDeletedAndPublishedVacanciesIndexedDocument(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> filterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId, int start,
		int end) throws com.liferay.portal.kernel.search.ParseException {
		return getService()
				   .filterByFields(searchContext, filters, sort, companyId,
			start, end);
	}

	public static int countFilterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId)
		throws com.liferay.portal.kernel.search.ParseException {
		return getService()
				   .countFilterByFields(searchContext, filters, sort, companyId);
	}

	public static vn.com.ecopharma.hrm.rc.model.Vacancy createPrePersistedVacancy() {
		return getService().createPrePersistedVacancy();
	}

	public static vn.com.ecopharma.hrm.rc.model.Vacancy createPrePersistedVacancy(
		java.lang.String vacancyCode, java.lang.String name,
		int numberOfPosition, long titlesId, java.lang.String description,
		java.util.Date postedDate, java.util.Date expiredDate,
		java.lang.String status) {
		return getService()
				   .createPrePersistedVacancy(vacancyCode, name,
			numberOfPosition, titlesId, description, postedDate, expiredDate,
			status);
	}

	public static vn.com.ecopharma.hrm.rc.model.Vacancy addVacancy(
		vn.com.ecopharma.hrm.rc.model.Vacancy vacancy,
		java.util.List<java.lang.Long> fileEntryIds,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().addVacancy(vacancy, fileEntryIds, serviceContext);
	}

	public static vn.com.ecopharma.hrm.rc.model.Vacancy updateVacancy(
		vn.com.ecopharma.hrm.rc.model.Vacancy vacancy,
		java.util.List<java.lang.Long> fileEntryIds,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().updateVacancy(vacancy, fileEntryIds, serviceContext);
	}

	public static vn.com.ecopharma.hrm.rc.model.Vacancy getVacancyByCandidateId(
		long candidateId) {
		return getService().getVacancyByCandidateId(candidateId);
	}

	public static com.liferay.portal.kernel.search.Document getIndexVacancyDocument(
		long id, com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getIndexVacancyDocument(id, searchContext);
	}

	public static com.liferay.portal.kernel.search.Document getIndexVacancyDocument(
		java.lang.String id,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getIndexVacancyDocument(id, searchContext);
	}

	public static com.liferay.portal.kernel.search.Document getUndeletedIndexVacancyDocument(
		long id, com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getUndeletedIndexVacancyDocument(id, searchContext);
	}

	public static vn.com.ecopharma.hrm.rc.model.Vacancy markDeleted(long id) {
		return getService().markDeleted(id);
	}

	public static vn.com.ecopharma.hrm.rc.model.Vacancy markDeleted(
		vn.com.ecopharma.hrm.rc.model.Vacancy vacancy) {
		return getService().markDeleted(vacancy);
	}

	public static void indexAllVacancies() {
		getService().indexAllVacancies();
	}

	public static void removeAllVacanciesIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		getService().removeAllVacanciesIndexes(searchContext, companyId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VacancyLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VacancyLocalService.class.getName());

			if (invokableLocalService instanceof VacancyLocalService) {
				_service = (VacancyLocalService)invokableLocalService;
			}
			else {
				_service = new VacancyLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VacancyLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VacancyLocalService service) {
	}

	private static VacancyLocalService _service;
}