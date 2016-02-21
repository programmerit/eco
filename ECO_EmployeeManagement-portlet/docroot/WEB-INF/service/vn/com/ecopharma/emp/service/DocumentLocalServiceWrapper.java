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
 * Provides a wrapper for {@link DocumentLocalService}.
 *
 * @author tvt
 * @see DocumentLocalService
 * @generated
 */
public class DocumentLocalServiceWrapper implements DocumentLocalService,
	ServiceWrapper<DocumentLocalService> {
	public DocumentLocalServiceWrapper(
		DocumentLocalService documentLocalService) {
		_documentLocalService = documentLocalService;
	}

	/**
	* Adds the document to the database. Also notifies the appropriate model listeners.
	*
	* @param document the document
	* @return the document that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Document addDocument(
		vn.com.ecopharma.emp.model.Document document)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.addDocument(document);
	}

	/**
	* Creates a new document with the primary key. Does not add the document to the database.
	*
	* @param documentId the primary key for the new document
	* @return the new document
	*/
	@Override
	public vn.com.ecopharma.emp.model.Document createDocument(long documentId) {
		return _documentLocalService.createDocument(documentId);
	}

	/**
	* Deletes the document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param documentId the primary key of the document
	* @return the document that was removed
	* @throws PortalException if a document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Document deleteDocument(long documentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.deleteDocument(documentId);
	}

	/**
	* Deletes the document from the database. Also notifies the appropriate model listeners.
	*
	* @param document the document
	* @return the document that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Document deleteDocument(
		vn.com.ecopharma.emp.model.Document document)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.deleteDocument(document);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _documentLocalService.dynamicQuery();
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
		return _documentLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _documentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _documentLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.Document fetchDocument(long documentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.fetchDocument(documentId);
	}

	/**
	* Returns the document with the primary key.
	*
	* @param documentId the primary key of the document
	* @return the document
	* @throws PortalException if a document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Document getDocument(long documentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.getDocument(documentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Document> getDocuments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.getDocuments(start, end);
	}

	/**
	* Returns the number of documents.
	*
	* @return the number of documents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDocumentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.getDocumentsCount();
	}

	/**
	* Updates the document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param document the document
	* @return the document that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.Document updateDocument(
		vn.com.ecopharma.emp.model.Document document)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.updateDocument(document);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _documentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_documentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _documentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Document> findAll() {
		return _documentLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Document> findAll(
		int start, int end) {
		return _documentLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Document> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _documentLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Document> findByClassNameAndClassPK(
		java.lang.String className, long classPK) {
		return _documentLocalService.findByClassNameAndClassPK(className,
			classPK);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Document> findByClassNameClassPKAndType(
		java.lang.String className, long classPK, java.lang.String type) {
		return _documentLocalService.findByClassNameClassPKAndType(className,
			classPK, type);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Document> findByFileEntry(
		long fileEntryId) {
		return _documentLocalService.findByFileEntry(fileEntryId);
	}

	@Override
	public vn.com.ecopharma.emp.model.Document createPrePersistedEntity(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _documentLocalService.createPrePersistedEntity(serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.Document addDocument(
		vn.com.ecopharma.emp.model.Document prePersistedEntity,
		java.lang.String className, long classPK, long fileEntryId,
		java.lang.String documentType) {
		return _documentLocalService.addDocument(prePersistedEntity, className,
			classPK, fileEntryId, documentType);
	}

	@Override
	public vn.com.ecopharma.emp.model.Document addDocument(
		java.lang.String className, long classPK, long fileEntryId,
		java.lang.String documentType,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _documentLocalService.addDocument(className, classPK,
			fileEntryId, documentType, serviceContext);
	}

	@Override
	public void completelyDeleteDocuments(long fileEntryId) {
		_documentLocalService.completelyDeleteDocuments(fileEntryId);
	}

	@Override
	public vn.com.ecopharma.emp.model.Document uploadAndLinkEntity(
		com.liferay.portal.model.BaseModel<?> entity,
		org.primefaces.model.UploadedFile uploadedFile,
		java.lang.String folderName, java.lang.String documentType,
		boolean isAutoCreateFolder,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _documentLocalService.uploadAndLinkEntity(entity, uploadedFile,
			folderName, documentType, isAutoCreateFolder, serviceContext);
	}

	@Override
	public com.liferay.portlet.documentlibrary.model.DLFileEntry getDLFileEntry(
		vn.com.ecopharma.emp.model.Document document)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.getDLFileEntry(document);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getUploadFileEntry(
		com.liferay.portlet.documentlibrary.model.DLFileEntry dlFileEntry)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.getUploadFileEntry(dlFileEntry);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getFileEntry(
		vn.com.ecopharma.emp.model.Document document) {
		return _documentLocalService.getFileEntry(document);
	}

	@Override
	public java.lang.String getFilePath(
		com.liferay.portal.kernel.repository.model.FileEntry fileEntry) {
		return _documentLocalService.getFilePath(fileEntry);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry uploadFile(
		org.primefaces.model.UploadedFile uploadedFile,
		java.lang.String folderName, boolean isAutoCreateFolder,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _documentLocalService.uploadFile(uploadedFile, folderName,
			isAutoCreateFolder, serviceContext);
	}

	@Override
	public com.liferay.portlet.documentlibrary.model.DLFileEntry uploadFile(
		javax.portlet.PortletRequest request, java.io.File file,
		java.lang.String title, java.lang.String description,
		java.lang.String changeLog, long folderId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _documentLocalService.uploadFile(request, file, title,
			description, changeLog, folderId, serviceContext);
	}

	@Override
	public com.liferay.portlet.documentlibrary.model.DLFolder createFolder(
		java.lang.String name, java.lang.String description, long parentId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _documentLocalService.createFolder(name, description, parentId,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DocumentLocalService getWrappedDocumentLocalService() {
		return _documentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDocumentLocalService(
		DocumentLocalService documentLocalService) {
		_documentLocalService = documentLocalService;
	}

	@Override
	public DocumentLocalService getWrappedService() {
		return _documentLocalService;
	}

	@Override
	public void setWrappedService(DocumentLocalService documentLocalService) {
		_documentLocalService = documentLocalService;
	}

	private DocumentLocalService _documentLocalService;
}