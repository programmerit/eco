package vn.com.ecopharma.emp.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.portlet.PortletRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

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
		System.out.println("REPOSITORY ID: " + themeDisplay.getScopeGroupId());
		DLFileEntry fileEntry = null;
		String ext = FileUtil.getExtension(file.getName());

		title = title + "-" + System.currentTimeMillis() + "." + ext;

		byte[] fileBytes = FileUtil.getBytes(file);

		InputStream is = new ByteArrayInputStream(fileBytes);
		DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(folderId);

		/*
		 * ServiceContext serviceContext = ServiceContextFactory.getInstance(
		 * DLFileEntry.class.getName(), request);
		 */

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
}
