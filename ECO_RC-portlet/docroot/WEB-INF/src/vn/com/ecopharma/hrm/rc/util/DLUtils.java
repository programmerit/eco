package vn.com.ecopharma.hrm.rc.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.UploadedFile;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryType;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryTypeServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.portlet.documentlibrary.util.ImageProcessorUtil;

public class DLUtils {

	/**
	 * @param name
	 * @param description
	 * @param folderId
	 * @param parentId
	 * @param groupId
	 * @param companyId
	 * @param userId
	 * @param createDate
	 * @param modifiedDate
	 * @return
	 */
	public static DLFolder createFolder(String name, String description,
			long parentId, long groupId, long companyId, long userId,
			Date createDate, Date modifiedDate) {
		try {
			final long folderId = CounterLocalServiceUtil.increment();
			final DLFolder folder = DLFolderLocalServiceUtil
					.createDLFolder(folderId);
			folder.setName(name);
			folder.setDescription(description);
			folder.setParentFolderId(parentId);
			folder.setGroupId(groupId);
			folder.setCompanyId(companyId);
			folder.setUserId(userId);
			folder.setCreateDate(createDate);
			folder.setModifiedDate(modifiedDate);
			return DLFolderLocalServiceUtil.addDLFolder(folder);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param request
	 * @param file
	 * @param title
	 * @param description
	 * @param changeLog
	 * @param folderId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	public static DLFileEntry uploadFile(PortletRequest request, File file,
			String title, String description, String changeLog, long folderId,
			ServiceContext serviceContext) throws PortalException,
			SystemException, IOException {
		final ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long repositoryId = themeDisplay.getScopeGroupId();
		DLFileEntry fileEntry = null;

		// List<DLFileEntryType> tip =
		// DLFileEntryTypeServiceUtil.getFileEntryTypes(DLUtil.get)

		byte[] fileBytes = FileUtil.getBytes(file);

		InputStream is = new ByteArrayInputStream(fileBytes);
		DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(folderId);

		fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(
				themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
				themeDisplay.getScopeGroupId(), dlFolder.getFolderId(), title,
				MimeTypesUtil.getContentType(file), title, description,
				changeLog, 0, null, file, is, file.length(), serviceContext);

		fileEntry = DLFileEntryLocalServiceUtil.updateFileEntry(
				themeDisplay.getUserId(), fileEntry.getFileEntryId(), title,
				MimeTypesUtil.getContentType(file), title, description,
				changeLog, true, 0, null, file, is, file.length(),
				serviceContext);
		return fileEntry;
	}

	/**
	 * @param dlFileEntry
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static FileEntry getUploadFileEntry(DLFileEntry dlFileEntry)
			throws PortalException, SystemException {
		return DLAppServiceUtil.getFileEntry(dlFileEntry.getGroupId(),
				dlFileEntry.getFolderId(), dlFileEntry.getTitle());
	}

	/**
	 * @param uploadedFile
	 * @param folderName
	 * @return
	 */
	public static FileEntry handleFileUpload(UploadedFile uploadedFile,
			String folderName) {
		try {
			final ServiceContext serviceContext = LiferayFacesContext
					.getInstance().getServiceContext();
			final InputStream is = uploadedFile.getInputstream();
			File file = FileUtil.createTempFile(is);
			DLFolder folder = DLFolderLocalServiceUtil.fetchFolder(
					serviceContext.getScopeGroupId(), 0, folderName);
			if (folder == null) {
				folder = DLUtils.createFolder(folderName, "", 0,
						serviceContext.getScopeGroupId(),
						serviceContext.getCompanyId(),
						serviceContext.getUserId(),
						new Date(System.currentTimeMillis()),
						new Date(System.currentTimeMillis()));
			}

			PortletRequest pRequest = (PortletRequest) LiferayFacesContext
					.getCurrentInstance().getExternalContext().getRequest();
			String fileName = StringUtils.EMPTY;
			if (DLFileEntryLocalServiceUtil.fetchFileEntryByName(
					serviceContext.getScopeGroupId(), folder.getFolderId(),
					uploadedFile.getFileName()) == null) {
				fileName = uploadedFile.getFileName();
			} else {
				fileName = uploadedFile.getFileName()
						+ System.currentTimeMillis();
			}
			final DLFileEntry dlFileEntry = DLUtils.uploadFile(pRequest, file,
					fileName, "", "", folder.getFolderId(), serviceContext);
			file.delete();

			final FileEntry fe = DLUtils.getUploadFileEntry(dlFileEntry);

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
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
