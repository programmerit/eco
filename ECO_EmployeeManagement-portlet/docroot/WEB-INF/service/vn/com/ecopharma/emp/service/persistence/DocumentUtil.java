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

package vn.com.ecopharma.emp.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import vn.com.ecopharma.emp.model.Document;

import java.util.List;

/**
 * The persistence utility for the document service. This utility wraps {@link DocumentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see DocumentPersistence
 * @see DocumentPersistenceImpl
 * @generated
 */
public class DocumentUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Document document) {
		getPersistence().clearCache(document);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Document> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Document> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Document> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Document update(Document document) throws SystemException {
		return getPersistence().update(document);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Document update(Document document,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(document, serviceContext);
	}

	/**
	* Returns all the documents where className = &#63; and classPK = &#63; and documentType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param documentType the document type
	* @return the matching documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Document> findByClassNameClassPKAndType(
		java.lang.String className, long classPK, java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByClassNameClassPKAndType(className, classPK,
			documentType);
	}

	/**
	* Returns a range of all the documents where className = &#63; and classPK = &#63; and documentType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param documentType the document type
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @return the range of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Document> findByClassNameClassPKAndType(
		java.lang.String className, long classPK,
		java.lang.String documentType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByClassNameClassPKAndType(className, classPK,
			documentType, start, end);
	}

	/**
	* Returns an ordered range of all the documents where className = &#63; and classPK = &#63; and documentType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param documentType the document type
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Document> findByClassNameClassPKAndType(
		java.lang.String className, long classPK,
		java.lang.String documentType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByClassNameClassPKAndType(className, classPK,
			documentType, start, end, orderByComparator);
	}

	/**
	* Returns the first document in the ordered set where className = &#63; and classPK = &#63; and documentType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document
	* @throws vn.com.ecopharma.emp.NoSuchDocumentException if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document findByClassNameClassPKAndType_First(
		java.lang.String className, long classPK,
		java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDocumentException {
		return getPersistence()
				   .findByClassNameClassPKAndType_First(className, classPK,
			documentType, orderByComparator);
	}

	/**
	* Returns the first document in the ordered set where className = &#63; and classPK = &#63; and documentType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document, or <code>null</code> if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document fetchByClassNameClassPKAndType_First(
		java.lang.String className, long classPK,
		java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClassNameClassPKAndType_First(className, classPK,
			documentType, orderByComparator);
	}

	/**
	* Returns the last document in the ordered set where className = &#63; and classPK = &#63; and documentType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document
	* @throws vn.com.ecopharma.emp.NoSuchDocumentException if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document findByClassNameClassPKAndType_Last(
		java.lang.String className, long classPK,
		java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDocumentException {
		return getPersistence()
				   .findByClassNameClassPKAndType_Last(className, classPK,
			documentType, orderByComparator);
	}

	/**
	* Returns the last document in the ordered set where className = &#63; and classPK = &#63; and documentType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document, or <code>null</code> if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document fetchByClassNameClassPKAndType_Last(
		java.lang.String className, long classPK,
		java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClassNameClassPKAndType_Last(className, classPK,
			documentType, orderByComparator);
	}

	/**
	* Returns the documents before and after the current document in the ordered set where className = &#63; and classPK = &#63; and documentType = &#63;.
	*
	* @param documentId the primary key of the current document
	* @param className the class name
	* @param classPK the class p k
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document
	* @throws vn.com.ecopharma.emp.NoSuchDocumentException if a document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document[] findByClassNameClassPKAndType_PrevAndNext(
		long documentId, java.lang.String className, long classPK,
		java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDocumentException {
		return getPersistence()
				   .findByClassNameClassPKAndType_PrevAndNext(documentId,
			className, classPK, documentType, orderByComparator);
	}

	/**
	* Removes all the documents where className = &#63; and classPK = &#63; and documentType = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param documentType the document type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByClassNameClassPKAndType(
		java.lang.String className, long classPK, java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByClassNameClassPKAndType(className, classPK, documentType);
	}

	/**
	* Returns the number of documents where className = &#63; and classPK = &#63; and documentType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param documentType the document type
	* @return the number of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByClassNameClassPKAndType(
		java.lang.String className, long classPK, java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByClassNameClassPKAndType(className, classPK,
			documentType);
	}

	/**
	* Returns all the documents where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Document> findByClassNameAndClassPK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByClassNameAndClassPK(className, classPK);
	}

	/**
	* Returns a range of all the documents where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @return the range of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Document> findByClassNameAndClassPK(
		java.lang.String className, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByClassNameAndClassPK(className, classPK, start, end);
	}

	/**
	* Returns an ordered range of all the documents where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public static java.util.List<vn.com.ecopharma.emp.model.Document> findByClassNameAndClassPK(
		java.lang.String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByClassNameAndClassPK(className, classPK, start, end,
			orderByComparator);
	}

	/**
	* Returns the first document in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document
	* @throws vn.com.ecopharma.emp.NoSuchDocumentException if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document findByClassNameAndClassPK_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDocumentException {
		return getPersistence()
				   .findByClassNameAndClassPK_First(className, classPK,
			orderByComparator);
	}

	/**
	* Returns the first document in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document, or <code>null</code> if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document fetchByClassNameAndClassPK_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClassNameAndClassPK_First(className, classPK,
			orderByComparator);
	}

	/**
	* Returns the last document in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document
	* @throws vn.com.ecopharma.emp.NoSuchDocumentException if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document findByClassNameAndClassPK_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDocumentException {
		return getPersistence()
				   .findByClassNameAndClassPK_Last(className, classPK,
			orderByComparator);
	}

	/**
	* Returns the last document in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document, or <code>null</code> if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document fetchByClassNameAndClassPK_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClassNameAndClassPK_Last(className, classPK,
			orderByComparator);
	}

	/**
	* Returns the documents before and after the current document in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param documentId the primary key of the current document
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document
	* @throws vn.com.ecopharma.emp.NoSuchDocumentException if a document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document[] findByClassNameAndClassPK_PrevAndNext(
		long documentId, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDocumentException {
		return getPersistence()
				   .findByClassNameAndClassPK_PrevAndNext(documentId,
			className, classPK, orderByComparator);
	}

	/**
	* Removes all the documents where className = &#63; and classPK = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByClassNameAndClassPK(java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByClassNameAndClassPK(className, classPK);
	}

	/**
	* Returns the number of documents where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByClassNameAndClassPK(java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByClassNameAndClassPK(className, classPK);
	}

	/**
	* Returns all the documents where documentType = &#63;.
	*
	* @param documentType the document type
	* @return the matching documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Document> findByType(
		java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(documentType);
	}

	/**
	* Returns a range of all the documents where documentType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param documentType the document type
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @return the range of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Document> findByType(
		java.lang.String documentType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(documentType, start, end);
	}

	/**
	* Returns an ordered range of all the documents where documentType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param documentType the document type
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Document> findByType(
		java.lang.String documentType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByType(documentType, start, end, orderByComparator);
	}

	/**
	* Returns the first document in the ordered set where documentType = &#63;.
	*
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document
	* @throws vn.com.ecopharma.emp.NoSuchDocumentException if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document findByType_First(
		java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDocumentException {
		return getPersistence().findByType_First(documentType, orderByComparator);
	}

	/**
	* Returns the first document in the ordered set where documentType = &#63;.
	*
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document, or <code>null</code> if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document fetchByType_First(
		java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByType_First(documentType, orderByComparator);
	}

	/**
	* Returns the last document in the ordered set where documentType = &#63;.
	*
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document
	* @throws vn.com.ecopharma.emp.NoSuchDocumentException if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document findByType_Last(
		java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDocumentException {
		return getPersistence().findByType_Last(documentType, orderByComparator);
	}

	/**
	* Returns the last document in the ordered set where documentType = &#63;.
	*
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document, or <code>null</code> if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document fetchByType_Last(
		java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_Last(documentType, orderByComparator);
	}

	/**
	* Returns the documents before and after the current document in the ordered set where documentType = &#63;.
	*
	* @param documentId the primary key of the current document
	* @param documentType the document type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document
	* @throws vn.com.ecopharma.emp.NoSuchDocumentException if a document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document[] findByType_PrevAndNext(
		long documentId, java.lang.String documentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDocumentException {
		return getPersistence()
				   .findByType_PrevAndNext(documentId, documentType,
			orderByComparator);
	}

	/**
	* Removes all the documents where documentType = &#63; from the database.
	*
	* @param documentType the document type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByType(java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByType(documentType);
	}

	/**
	* Returns the number of documents where documentType = &#63;.
	*
	* @param documentType the document type
	* @return the number of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByType(java.lang.String documentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByType(documentType);
	}

	/**
	* Returns all the documents where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the matching documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Document> findByFileEntry(
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFileEntry(fileEntryId);
	}

	/**
	* Returns a range of all the documents where fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @return the range of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Document> findByFileEntry(
		long fileEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFileEntry(fileEntryId, start, end);
	}

	/**
	* Returns an ordered range of all the documents where fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Document> findByFileEntry(
		long fileEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFileEntry(fileEntryId, start, end, orderByComparator);
	}

	/**
	* Returns the first document in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document
	* @throws vn.com.ecopharma.emp.NoSuchDocumentException if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document findByFileEntry_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDocumentException {
		return getPersistence()
				   .findByFileEntry_First(fileEntryId, orderByComparator);
	}

	/**
	* Returns the first document in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document, or <code>null</code> if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document fetchByFileEntry_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFileEntry_First(fileEntryId, orderByComparator);
	}

	/**
	* Returns the last document in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document
	* @throws vn.com.ecopharma.emp.NoSuchDocumentException if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document findByFileEntry_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDocumentException {
		return getPersistence()
				   .findByFileEntry_Last(fileEntryId, orderByComparator);
	}

	/**
	* Returns the last document in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document, or <code>null</code> if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document fetchByFileEntry_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFileEntry_Last(fileEntryId, orderByComparator);
	}

	/**
	* Returns the documents before and after the current document in the ordered set where fileEntryId = &#63;.
	*
	* @param documentId the primary key of the current document
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document
	* @throws vn.com.ecopharma.emp.NoSuchDocumentException if a document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document[] findByFileEntry_PrevAndNext(
		long documentId, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDocumentException {
		return getPersistence()
				   .findByFileEntry_PrevAndNext(documentId, fileEntryId,
			orderByComparator);
	}

	/**
	* Removes all the documents where fileEntryId = &#63; from the database.
	*
	* @param fileEntryId the file entry ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFileEntry(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFileEntry(fileEntryId);
	}

	/**
	* Returns the number of documents where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the number of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFileEntry(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFileEntry(fileEntryId);
	}

	/**
	* Returns the document where className = &#63; and classPK = &#63; and fileEntryId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchDocumentException} if it could not be found.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param fileEntryId the file entry ID
	* @return the matching document
	* @throws vn.com.ecopharma.emp.NoSuchDocumentException if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document findByClassNameClassPKAndFileEntry(
		java.lang.String className, long classPK, long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDocumentException {
		return getPersistence()
				   .findByClassNameClassPKAndFileEntry(className, classPK,
			fileEntryId);
	}

	/**
	* Returns the document where className = &#63; and classPK = &#63; and fileEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param fileEntryId the file entry ID
	* @return the matching document, or <code>null</code> if a matching document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document fetchByClassNameClassPKAndFileEntry(
		java.lang.String className, long classPK, long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClassNameClassPKAndFileEntry(className, classPK,
			fileEntryId);
	}

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
	public static vn.com.ecopharma.emp.model.Document fetchByClassNameClassPKAndFileEntry(
		java.lang.String className, long classPK, long fileEntryId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClassNameClassPKAndFileEntry(className, classPK,
			fileEntryId, retrieveFromCache);
	}

	/**
	* Removes the document where className = &#63; and classPK = &#63; and fileEntryId = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param fileEntryId the file entry ID
	* @return the document that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document removeByClassNameClassPKAndFileEntry(
		java.lang.String className, long classPK, long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDocumentException {
		return getPersistence()
				   .removeByClassNameClassPKAndFileEntry(className, classPK,
			fileEntryId);
	}

	/**
	* Returns the number of documents where className = &#63; and classPK = &#63; and fileEntryId = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param fileEntryId the file entry ID
	* @return the number of matching documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByClassNameClassPKAndFileEntry(
		java.lang.String className, long classPK, long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByClassNameClassPKAndFileEntry(className, classPK,
			fileEntryId);
	}

	/**
	* Caches the document in the entity cache if it is enabled.
	*
	* @param document the document
	*/
	public static void cacheResult(vn.com.ecopharma.emp.model.Document document) {
		getPersistence().cacheResult(document);
	}

	/**
	* Caches the documents in the entity cache if it is enabled.
	*
	* @param documents the documents
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.Document> documents) {
		getPersistence().cacheResult(documents);
	}

	/**
	* Creates a new document with the primary key. Does not add the document to the database.
	*
	* @param documentId the primary key for the new document
	* @return the new document
	*/
	public static vn.com.ecopharma.emp.model.Document create(long documentId) {
		return getPersistence().create(documentId);
	}

	/**
	* Removes the document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param documentId the primary key of the document
	* @return the document that was removed
	* @throws vn.com.ecopharma.emp.NoSuchDocumentException if a document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document remove(long documentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDocumentException {
		return getPersistence().remove(documentId);
	}

	public static vn.com.ecopharma.emp.model.Document updateImpl(
		vn.com.ecopharma.emp.model.Document document)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(document);
	}

	/**
	* Returns the document with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchDocumentException} if it could not be found.
	*
	* @param documentId the primary key of the document
	* @return the document
	* @throws vn.com.ecopharma.emp.NoSuchDocumentException if a document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document findByPrimaryKey(
		long documentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchDocumentException {
		return getPersistence().findByPrimaryKey(documentId);
	}

	/**
	* Returns the document with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param documentId the primary key of the document
	* @return the document, or <code>null</code> if a document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Document fetchByPrimaryKey(
		long documentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(documentId);
	}

	/**
	* Returns all the documents.
	*
	* @return the documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Document> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<vn.com.ecopharma.emp.model.Document> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of documents
	* @param end the upper bound of the range of documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Document> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the documents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of documents.
	*
	* @return the number of documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DocumentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DocumentPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					DocumentPersistence.class.getName());

			ReferenceRegistry.registerReference(DocumentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DocumentPersistence persistence) {
	}

	private static DocumentPersistence _persistence;
}