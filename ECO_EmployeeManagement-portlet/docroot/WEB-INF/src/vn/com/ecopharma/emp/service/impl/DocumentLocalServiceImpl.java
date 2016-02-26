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

package vn.com.ecopharma.emp.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.model.Document;
import vn.com.ecopharma.emp.service.base.DocumentLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.portlet.documentlibrary.util.ImageProcessorUtil;

/**
 * The implementation of the document local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.DocumentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.DocumentLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.DocumentLocalServiceUtil
 */
public class DocumentLocalServiceImpl extends DocumentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.DocumentLocalServiceUtil} to access the
	 * document local service.
	 */

	private static final Log LOGGER = LogFactoryUtil
			.getLog(DocumentLocalServiceImpl.class);

	public List<Document> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<Document> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<Document> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return documentPersistence.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<Document> findByClassNameAndClassPK(String className,
			long classPK) {
		try {
			return documentPersistence.findByClassNameAndClassPK(className,
					classPK);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<Document> findByClassNameClassPKAndType(String className,
			long classPK, String type) {
		try {
			return documentPersistence.findByClassNameClassPKAndType(className,
					classPK, type);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<Document> findByFileEntry(long fileEntryId) {
		try {
			return documentPersistence.findByFileEntry(fileEntryId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<Document>();
	}

	public Document fetchByClassNameClassPKAndFileEntry(String className,
			long classPK, long fileEntryId) {
		try {
			return documentPersistence.fetchByClassNameClassPKAndFileEntry(
					className, classPK, fileEntryId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Document createPrePersistedEntity(ServiceContext serviceContext) {
		try {
			long id = counterLocalService.increment();
			Document document = documentPersistence.create(id);

			document.setCreateDate(new Date());
			document.setUserId(serviceContext.getUserId());
			document.setGroupId(serviceContext.getScopeGroupId());
			document.setCompanyId(serviceContext.getCompanyId());

			return document;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Document addDocument(Document prePersistedEntity, String className,
			long classPK, long fileEntryId, String documentType) {
		prePersistedEntity.setClassName(className);
		prePersistedEntity.setClassPK(classPK);
		prePersistedEntity.setFileEntryId(fileEntryId);
		prePersistedEntity.setDocumentType(documentType);
		try {
			Document result = super.addDocument(prePersistedEntity);
			resourceLocalService.addResources(result.getCompanyId(),
					result.getGroupId(), result.getUserId(),
					Document.class.getName(), result.getDocumentId(), false,
					true, true);
			return result;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Document addDocument(String className, long classPK,
			long fileEntryId, String documentType, ServiceContext serviceContext) {
		return addDocument(createPrePersistedEntity(serviceContext), className,
				classPK, fileEntryId, documentType);
	}

	public void completelyDeleteDocuments(long fileEntryId) {
		try {
			final List<Document> docsByFileEntry = findByFileEntry(fileEntryId);
			for (Document doc : docsByFileEntry)
				deleteDocument(doc);
			DLFileEntryLocalServiceUtil.deleteDLFileEntry(fileEntryId);
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
	}

	public Document uploadAndLinkEntity(BaseModel<?> entity,
			PortletRequest request, InputStream is, String fileName,
			String folderName, String documentType, boolean isAutoCreateFolder,
			ServiceContext serviceContext) {
		String className = entity.getModelClassName();
		long classPK = Long.valueOf(entity.getPrimaryKeyObj().toString());
		FileEntry fileEntry = uploadFile(request, is, fileName, folderName,
				isAutoCreateFolder, serviceContext);
		if (fileEntry == null)
			return null;

		return addDocument(className, classPK, fileEntry.getFileEntryId(),
				documentType, serviceContext);
	}

	public DLFileEntry getDLFileEntry(Document document)
			throws PortalException, SystemException {
		if (document.getFileEntryId() == 0)
			return null;
		return DLFileEntryLocalServiceUtil.getFileEntry(document
				.getFileEntryId());
	}

	public FileEntry getUploadFileEntry(DLFileEntry dlFileEntry)
			throws PortalException, SystemException {
		return DLAppServiceUtil.getFileEntry(dlFileEntry.getGroupId(),
				dlFileEntry.getFolderId(), dlFileEntry.getTitle());
	}

	public FileEntry getFileEntry(Document document) {
		try {
			return getUploadFileEntry(getDLFileEntry(document));
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public String getFilePath(PortletRequest request, FileEntry fileEntry) {
		try {
			String fileURL = DLUtil.getPreviewURL(fileEntry,
					fileEntry.getFileVersion(),
					(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY),
					"", false, true);
			return fileURL;
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return StringUtils.EMPTY;
	}

	public FileEntry uploadFile(PortletRequest request, InputStream is,
			String fileName, String folderName, boolean isAutoCreateFolder,
			ServiceContext serviceContext) {
		try {
			File file = FileUtil.createTempFile(is);
			DLFolder folder = DLFolderLocalServiceUtil.fetchFolder(
					serviceContext.getScopeGroupId(), 0, folderName);
			if (folder == null) {
				if (!isAutoCreateFolder) {
					LOGGER.info("Folder not found");
					return null;
				}
				folder = createFolder(folderName, StringUtils.EMPTY, 0,
						serviceContext);
				LOGGER.info("Folder " + folder.getName() + " was created.");
			}

			// PortletRequest pRequest = (PortletRequest) LiferayFacesContext
			// .getCurrentInstance().getExternalContext().getRequest();

			// check if a file with same name has already existed
			if (DLFileEntryLocalServiceUtil.fetchFileEntryByName(
					serviceContext.getScopeGroupId(), folder.getFolderId(),
					fileName) != null) {
				fileName = fileName + System.currentTimeMillis();
			}
			final DLFileEntry dlFileEntry = uploadFile(request, file, fileName,
					StringUtils.EMPTY, StringUtils.EMPTY, folder.getFolderId(),
					serviceContext);
			file.delete();

			final FileEntry fe = getUploadFileEntry(dlFileEntry);

			// get file version & generate preview

			ImageProcessorUtil.generateImages(fe.getLatestFileVersion(),
					fe.getLatestFileVersion());

			/*
			 * String fileURL = DLUtil .getPreviewURL(fe, fe.getFileVersion(),
			 * (ThemeDisplay) pRequest .getAttribute(WebKeys.THEME_DISPLAY), "",
			 * false, true); System.out.println(fileURL);
			 */
			return fe;
		} catch (IOException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (Exception e) {
			LOGGER.info(e);
		}
		return null;
	}

	public DLFileEntry uploadFile(PortletRequest request, File file,
			String title, String description, String changeLog, long folderId,
			ServiceContext serviceContext) throws PortalException,
			SystemException, IOException {
		try {
			final ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);
			DLFileEntry fileEntry = null;

			byte[] fileBytes = FileUtil.getBytes(file);

			InputStream is = new ByteArrayInputStream(fileBytes);
			DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(folderId);

			fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(
					themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
					themeDisplay.getScopeGroupId(), dlFolder.getFolderId(),
					title, MimeTypesUtil.getContentType(file), title,
					description, changeLog, 0, null, file, is, file.length(),
					serviceContext);

			fileEntry = DLFileEntryLocalServiceUtil.updateFileEntry(
					themeDisplay.getUserId(), fileEntry.getFileEntryId(),
					title, MimeTypesUtil.getContentType(file), title,
					description, changeLog, true, 0, null, file, is,
					file.length(), serviceContext);
			return fileEntry;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (Exception e) {
			LOGGER.info(e);
		}
		return null;
	}

	public DLFolder createFolder(String name, String description,
			long parentId, ServiceContext serviceContext)
			throws SystemException {
		final long folderId = counterLocalService.increment();
		final DLFolder folder = DLFolderLocalServiceUtil
				.createDLFolder(folderId);
		folder.setName(name);
		folder.setDescription(description);
		folder.setParentFolderId(parentId);
		folder.setGroupId(serviceContext.getScopeGroupId());
		folder.setCompanyId(serviceContext.getCompanyId());
		folder.setUserId(serviceContext.getUserId());
		folder.setCreateDate(new Date());
		return DLFolderLocalServiceUtil.addDLFolder(folder);
	}

}