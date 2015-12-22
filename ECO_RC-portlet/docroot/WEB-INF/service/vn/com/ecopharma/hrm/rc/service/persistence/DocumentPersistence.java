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

package vn.com.ecopharma.hrm.rc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import vn.com.ecopharma.hrm.rc.model.Document;

/**
 * The persistence interface for the document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see DocumentPersistenceImpl
 * @see DocumentUtil
 * @generated
 */
public interface DocumentPersistence extends BasePersistence<Document> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentUtil} to access the document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the documents where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Document> findByClassNameIdAndClassNamePK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the documents where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @return the range of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Document> findByClassNameIdAndClassNamePK(
		java.lang.String className, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the documents where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Document> findByClassNameIdAndClassNamePK(
		java.lang.String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first document in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document
	* @throws vn.com.ecopharma.hrm.rc.NoSuchDocumentException if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Document findByClassNameIdAndClassNamePK_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchDocumentException;

	/**
	* Returns the first document in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document, or <code>null</code> if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Document fetchByClassNameIdAndClassNamePK_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last document in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document
	* @throws vn.com.ecopharma.hrm.rc.NoSuchDocumentException if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Document findByClassNameIdAndClassNamePK_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchDocumentException;

	/**
	* Returns the last document in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document, or <code>null</code> if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Document fetchByClassNameIdAndClassNamePK_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the documents before and after the current document in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param documentId the primary key of the current document
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document
	* @throws vn.com.ecopharma.hrm.rc.NoSuchDocumentException if a document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Document[] findByClassNameIdAndClassNamePK_PrevAndNext(
		long documentId, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchDocumentException;

	/**
	* Removes all the documents where className = &#63; and classPK = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByClassNameIdAndClassNamePK(java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of documents where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByClassNameIdAndClassNamePK(java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the document where className = &#63; and classPK = &#63; and fileEntryId = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchDocumentException} if it could not be found.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param fileEntryId the file entry ID
	* @return the matching document
	* @throws vn.com.ecopharma.hrm.rc.NoSuchDocumentException if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Document findByClassNameAndClassPKAndFileEntryId(
		java.lang.String className, long classPK, long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchDocumentException;

	/**
	* Returns the document where className = &#63; and classPK = &#63; and fileEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param fileEntryId the file entry ID
	* @return the matching document, or <code>null</code> if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Document fetchByClassNameAndClassPKAndFileEntryId(
		java.lang.String className, long classPK, long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the document where className = &#63; and classPK = &#63; and fileEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param fileEntryId the file entry ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching document, or <code>null</code> if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Document fetchByClassNameAndClassPKAndFileEntryId(
		java.lang.String className, long classPK, long fileEntryId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the document where className = &#63; and classPK = &#63; and fileEntryId = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param fileEntryId the file entry ID
	* @return the document that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Document removeByClassNameAndClassPKAndFileEntryId(
		java.lang.String className, long classPK, long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchDocumentException;

	/**
	* Returns the number of documents where className = &#63; and classPK = &#63; and fileEntryId = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param fileEntryId the file entry ID
	* @return the number of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByClassNameAndClassPKAndFileEntryId(
		java.lang.String className, long classPK, long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the documents where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the matching documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Document> findByFileEntryId(
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the documents where fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @return the range of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Document> findByFileEntryId(
		long fileEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the documents where fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Document> findByFileEntryId(
		long fileEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first document in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document
	* @throws vn.com.ecopharma.hrm.rc.NoSuchDocumentException if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Document findByFileEntryId_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchDocumentException;

	/**
	* Returns the first document in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document, or <code>null</code> if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Document fetchByFileEntryId_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last document in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document
	* @throws vn.com.ecopharma.hrm.rc.NoSuchDocumentException if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Document findByFileEntryId_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchDocumentException;

	/**
	* Returns the last document in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document, or <code>null</code> if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Document fetchByFileEntryId_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the documents before and after the current document in the ordered set where fileEntryId = &#63;.
	*
	* @param documentId the primary key of the current document
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document
	* @throws vn.com.ecopharma.hrm.rc.NoSuchDocumentException if a document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Document[] findByFileEntryId_PrevAndNext(
		long documentId, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchDocumentException;

	/**
	* Removes all the documents where fileEntryId = &#63; from the database.
	*
	* @param fileEntryId the file entry ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFileEntryId(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of documents where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the number of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByFileEntryId(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the document in the entity cache if it is enabled.
	*
	* @param document the document
	*/
	public void cacheResult(vn.com.ecopharma.hrm.rc.model.Document document);

	/**
	* Caches the documents in the entity cache if it is enabled.
	*
	* @param documents the documents
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.hrm.rc.model.Document> documents);

	/**
	* Creates a new document with the primary key. Does not add the document to the database.
	*
	* @param documentId the primary key for the new document
	* @return the new document
	*/
	public vn.com.ecopharma.hrm.rc.model.Document create(long documentId);

	/**
	* Removes the document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param documentId the primary key of the document
	* @return the document that was removed
	* @throws vn.com.ecopharma.hrm.rc.NoSuchDocumentException if a document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Document remove(long documentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchDocumentException;

	public vn.com.ecopharma.hrm.rc.model.Document updateImpl(
		vn.com.ecopharma.hrm.rc.model.Document document)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the document with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchDocumentException} if it could not be found.
	*
	* @param documentId the primary key of the document
	* @return the document
	* @throws vn.com.ecopharma.hrm.rc.NoSuchDocumentException if a document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Document findByPrimaryKey(
		long documentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.rc.NoSuchDocumentException;

	/**
	* Returns the document with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param documentId the primary key of the document
	* @return the document, or <code>null</code> if a document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.hrm.rc.model.Document fetchByPrimaryKey(
		long documentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the documents.
	*
	* @return the documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Document> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @return the range of documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Document> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Document> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the documents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of documents.
	*
	* @return the number of documents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}