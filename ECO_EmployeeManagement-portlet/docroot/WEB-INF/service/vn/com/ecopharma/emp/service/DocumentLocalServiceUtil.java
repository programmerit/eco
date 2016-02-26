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
 * Provides the local service utility for Document. This utility wraps
 * {@link vn.com.ecopharma.emp.service.impl.DocumentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see DocumentLocalService
 * @see vn.com.ecopharma.emp.service.base.DocumentLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.impl.DocumentLocalServiceImpl
 * @generated
 */
public class DocumentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.emp.service.impl.DocumentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the document to the database. Also notifies the appropriate model listeners.
	*
	* @param document the document
	* @return the document that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document addDocument(
		vn.com.ecopharma.emp.model.Document document)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDocument(document);
	}

	/**
	* Creates a new document with the primary key. Does not add the document to the database.
	*
	* @param documentId the primary key for the new document
	* @return the new document
	*/
	public static vn.com.ecopharma.emp.model.Document createDocument(
		long documentId) {
		return getService().createDocument(documentId);
	}

	/**
	* Deletes the document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param documentId the primary key of the document
	* @return the document that was removed
	* @throws PortalException if a document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document deleteDocument(
		long documentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDocument(documentId);
	}

	/**
	* Deletes the document from the database. Also notifies the appropriate model listeners.
	*
	* @param document the document
	* @return the document that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document deleteDocument(
		vn.com.ecopharma.emp.model.Document document)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDocument(document);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.emp.model.Document fetchDocument(
		long documentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDocument(documentId);
	}

	/**
	* Returns the document with the primary key.
	*
	* @param documentId the primary key of the document
	* @return the document
	* @throws PortalException if a document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document getDocument(
		long documentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDocument(documentId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @return the range of documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Document> getDocuments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDocuments(start, end);
	}

	/**
	* Returns the number of documents.
	*
	* @return the number of documents
	* @throws SystemException if a system exception occurred
	*/
	public static int getDocumentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDocumentsCount();
	}

	/**
	* Updates the document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param document the document
	* @return the document that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document updateDocument(
		vn.com.ecopharma.emp.model.Document document)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDocument(document);
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

	public static java.util.List<vn.com.ecopharma.emp.model.Document> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Document> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Document> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Document> findByClassNameAndClassPK(
		java.lang.String className, long classPK) {
		return getService().findByClassNameAndClassPK(className, classPK);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Document> findByClassNameClassPKAndType(
		java.lang.String className, long classPK, java.lang.String type) {
		return getService()
				   .findByClassNameClassPKAndType(className, classPK, type);
	}

	public static java.util.List<vn.com.ecopharma.emp.model.Document> findByFileEntry(
		long fileEntryId) {
		return getService().findByFileEntry(fileEntryId);
	}

	public static vn.com.ecopharma.emp.model.Document fetchByClassNameClassPKAndFileEntry(
		java.lang.String className, long classPK, long fileEntryId) {
		return getService()
				   .fetchByClassNameClassPKAndFileEntry(className, classPK,
			fileEntryId);
	}

	public static vn.com.ecopharma.emp.model.Document createPrePersistedEntity(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().createPrePersistedEntity(serviceContext);
	}

	public static vn.com.ecopharma.emp.model.Document addDocument(
		vn.com.ecopharma.emp.model.Document prePersistedEntity,
		java.lang.String className, long classPK, long fileEntryId,
		java.lang.String documentType) {
		return getService()
				   .addDocument(prePersistedEntity, className, classPK,
			fileEntryId, documentType);
	}

	public static vn.com.ecopharma.emp.model.Document addDocument(
		java.lang.String className, long classPK, long fileEntryId,
		java.lang.String documentType,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addDocument(className, classPK, fileEntryId, documentType,
			serviceContext);
	}

	public static void completelyDeleteDocuments(long fileEntryId) {
		getService().completelyDeleteDocuments(fileEntryId);
	}

	public static vn.com.ecopharma.emp.model.Document uploadAndLinkEntity(
		com.liferay.portal.model.BaseModel<?> entity,
		javax.portlet.PortletRequest request, java.io.InputStream is,
		java.lang.String fileName, java.lang.String folderName,
		java.lang.String documentType, boolean isAutoCreateFolder,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .uploadAndLinkEntity(entity, request, is, fileName,
			folderName, documentType, isAutoCreateFolder, serviceContext);
	}

	public static com.liferay.portlet.documentlibrary.model.DLFileEntry getDLFileEntry(
		vn.com.ecopharma.emp.model.Document document)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDLFileEntry(document);
	}

	public static com.liferay.portal.kernel.repository.model.FileEntry getUploadFileEntry(
		com.liferay.portlet.documentlibrary.model.DLFileEntry dlFileEntry)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUploadFileEntry(dlFileEntry);
	}

	public static com.liferay.portal.kernel.repository.model.FileEntry getFileEntry(
		vn.com.ecopharma.emp.model.Document document) {
		return getService().getFileEntry(document);
	}

	public static java.lang.String getFilePath(
		javax.portlet.PortletRequest request,
		com.liferay.portal.kernel.repository.model.FileEntry fileEntry) {
		return getService().getFilePath(request, fileEntry);
	}

	public static com.liferay.portal.kernel.repository.model.FileEntry uploadFile(
		javax.portlet.PortletRequest request, java.io.InputStream is,
		java.lang.String fileName, java.lang.String folderName,
		boolean isAutoCreateFolder,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .uploadFile(request, is, fileName, folderName,
			isAutoCreateFolder, serviceContext);
	}

	public static com.liferay.portlet.documentlibrary.model.DLFileEntry uploadFile(
		javax.portlet.PortletRequest request, java.io.File file,
		java.lang.String title, java.lang.String description,
		java.lang.String changeLog, long folderId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService()
				   .uploadFile(request, file, title, description, changeLog,
			folderId, serviceContext);
	}

	public static com.liferay.portlet.documentlibrary.model.DLFolder createFolder(
		java.lang.String name, java.lang.String description, long parentId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .createFolder(name, description, parentId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static DocumentLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DocumentLocalService.class.getName());

			if (invokableLocalService instanceof DocumentLocalService) {
				_service = (DocumentLocalService)invokableLocalService;
			}
			else {
				_service = new DocumentLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(DocumentLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(DocumentLocalService service) {
	}

	private static DocumentLocalService _service;
}