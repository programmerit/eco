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

package vn.com.ecopharma.hrm.rc.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

import vn.com.ecopharma.hrm.rc.NoSuchDocumentException;
import vn.com.ecopharma.hrm.rc.model.Document;
import vn.com.ecopharma.hrm.rc.service.base.DocumentLocalServiceBaseImpl;

/**
 * The implementation of the document local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.hrm.rc.service.DocumentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.base.DocumentLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.DocumentLocalServiceUtil
 */
public class DocumentLocalServiceImpl extends DocumentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.hrm.rc.service.DocumentLocalServiceUtil} to access the
	 * document local service.
	 */

	public List<Document> findByClassAndClassPK(String className, long classPK) {
		try {
			return documentPersistence.findByClassNameIdAndClassNamePK(
					className, classPK);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Document findByClassAndClassPKAndFileEntryId(String className,
			long classPK, long fileEntryId) {
		try {
			return documentPersistence
					.fetchByClassNameAndClassPKAndFileEntryId(className,
							classPK, fileEntryId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Document addDocument(String className, long classPK,
			long fileEntryId, ServiceContext serviceContext) {

		try {
			Document document = documentPersistence.create(counterLocalService
					.increment());
			document.setClassName(className != null ? className
					: org.apache.commons.lang3.StringUtils.EMPTY);
			document.setClassPK(classPK);
			document.setFileEntryId(fileEntryId);

			document.setCompanyId(serviceContext.getCompanyId());
			document.setGroupId(serviceContext.getScopeGroupId());
			document.setUserId(serviceContext.getUserId());
			document.setCreateDate(new Date(System.currentTimeMillis()));
			document.setModifiedDate(new Date(System.currentTimeMillis()));
			return documentPersistence.update(document);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Document> findByFileEntry(long fileEntryId) {
		try {
			return documentPersistence.findByFileEntryId(fileEntryId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteByFileEntry(long fileEntryId) {
		for (Document doc : findByFileEntry(fileEntryId)) {
			try {
				documentPersistence.remove(doc.getDocumentId());
				DLFileEntryLocalServiceUtil.deleteDLFileEntry(fileEntryId);
			} catch (NoSuchDocumentException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
	}

}