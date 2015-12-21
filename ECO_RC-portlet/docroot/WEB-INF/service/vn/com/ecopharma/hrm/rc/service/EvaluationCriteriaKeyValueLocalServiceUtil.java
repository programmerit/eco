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
 * Provides the local service utility for EvaluationCriteriaKeyValue. This utility wraps
 * {@link vn.com.ecopharma.hrm.rc.service.impl.EvaluationCriteriaKeyValueLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see EvaluationCriteriaKeyValueLocalService
 * @see vn.com.ecopharma.hrm.rc.service.base.EvaluationCriteriaKeyValueLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.impl.EvaluationCriteriaKeyValueLocalServiceImpl
 * @generated
 */
public class EvaluationCriteriaKeyValueLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.hrm.rc.service.impl.EvaluationCriteriaKeyValueLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the evaluation criteria key value to the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationCriteriaKeyValue the evaluation criteria key value
	* @return the evaluation criteria key value that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue addEvaluationCriteriaKeyValue(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue evaluationCriteriaKeyValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEvaluationCriteriaKeyValue(evaluationCriteriaKeyValue);
	}

	/**
	* Creates a new evaluation criteria key value with the primary key. Does not add the evaluation criteria key value to the database.
	*
	* @param evaluationCriteriaKeyValueId the primary key for the new evaluation criteria key value
	* @return the new evaluation criteria key value
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue createEvaluationCriteriaKeyValue(
		long evaluationCriteriaKeyValueId) {
		return getService()
				   .createEvaluationCriteriaKeyValue(evaluationCriteriaKeyValueId);
	}

	/**
	* Deletes the evaluation criteria key value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationCriteriaKeyValueId the primary key of the evaluation criteria key value
	* @return the evaluation criteria key value that was removed
	* @throws PortalException if a evaluation criteria key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue deleteEvaluationCriteriaKeyValue(
		long evaluationCriteriaKeyValueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteEvaluationCriteriaKeyValue(evaluationCriteriaKeyValueId);
	}

	/**
	* Deletes the evaluation criteria key value from the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationCriteriaKeyValue the evaluation criteria key value
	* @return the evaluation criteria key value that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue deleteEvaluationCriteriaKeyValue(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue evaluationCriteriaKeyValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteEvaluationCriteriaKeyValue(evaluationCriteriaKeyValue);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaKeyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaKeyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue fetchEvaluationCriteriaKeyValue(
		long evaluationCriteriaKeyValueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchEvaluationCriteriaKeyValue(evaluationCriteriaKeyValueId);
	}

	/**
	* Returns the evaluation criteria key value with the primary key.
	*
	* @param evaluationCriteriaKeyValueId the primary key of the evaluation criteria key value
	* @return the evaluation criteria key value
	* @throws PortalException if a evaluation criteria key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue getEvaluationCriteriaKeyValue(
		long evaluationCriteriaKeyValueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getEvaluationCriteriaKeyValue(evaluationCriteriaKeyValueId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the evaluation criteria key values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaKeyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of evaluation criteria key values
	* @param end the upper bound of the range of evaluation criteria key values (not inclusive)
	* @return the range of evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> getEvaluationCriteriaKeyValues(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEvaluationCriteriaKeyValues(start, end);
	}

	/**
	* Returns the number of evaluation criteria key values.
	*
	* @return the number of evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	public static int getEvaluationCriteriaKeyValuesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEvaluationCriteriaKeyValuesCount();
	}

	/**
	* Updates the evaluation criteria key value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param evaluationCriteriaKeyValue the evaluation criteria key value
	* @return the evaluation criteria key value that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue updateEvaluationCriteriaKeyValue(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue evaluationCriteriaKeyValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateEvaluationCriteriaKeyValue(evaluationCriteriaKeyValue);
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

	public static vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue addEvaluationCriteriaKeyValue(
		long evaluationCriteriaId, java.lang.String key, int value,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addEvaluationCriteriaKeyValue(evaluationCriteriaId, key,
			value, serviceContext);
	}

	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> findByEvaluationCriteria(
		long evaluationCriteriaId) {
		return getService().findByEvaluationCriteria(evaluationCriteriaId);
	}

	public static java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> findByEvaluationCriteriaAndKey(
		long evaluationCriteriaId, java.lang.String key) {
		return getService()
				   .findByEvaluationCriteriaAndKey(evaluationCriteriaId, key);
	}

	public static void clearService() {
		_service = null;
	}

	public static EvaluationCriteriaKeyValueLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EvaluationCriteriaKeyValueLocalService.class.getName());

			if (invokableLocalService instanceof EvaluationCriteriaKeyValueLocalService) {
				_service = (EvaluationCriteriaKeyValueLocalService)invokableLocalService;
			}
			else {
				_service = new EvaluationCriteriaKeyValueLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EvaluationCriteriaKeyValueLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EvaluationCriteriaKeyValueLocalService service) {
	}

	private static EvaluationCriteriaKeyValueLocalService _service;
}