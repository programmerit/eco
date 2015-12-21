package vn.com.ecopharma.hrm.rc.dto;

import java.io.Serializable;

import javax.portlet.PortletRequest;

import vn.com.ecopharma.hrm.rc.model.Document;
import vn.com.ecopharma.hrm.rc.util.DLUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;

public final class DocumentItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private long documentId;
	private String fileURL;
	private String fileName;
	private boolean UIDeleted = false;
	private Document document;

	private long fileEntryId;

	public DocumentItem(Document document) {
		this.document = document;
		this.documentId = document.getDocumentId();
		this.fileURL = getFilePath(getFileEntry());
		this.fileEntryId = getFileEntry().getFileEntryId();
		this.fileName = getFileEntry().getTitle();

	}

	public DocumentItem(FileEntry fileEntry) {
		this.document = null;
		this.documentId = 0;
		this.fileURL = getFilePath(fileEntry);
		this.fileEntryId = fileEntry.getFileEntryId();
		this.fileName = fileEntry.getTitle();
	}

	public long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	public boolean isUIDeleted() {
		return UIDeleted;
	}

	public void setUIDeleted(boolean uIDeleted) {
		UIDeleted = uIDeleted;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileEntryId() {
		return fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}

	private FileEntry getFileEntry() {
		try {
			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil
					.getFileEntry(this.document.getFileEntryId());
			final FileEntry fileEntry = DLUtils.getUploadFileEntry(dlFileEntry);
			return fileEntry;
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getFilePath(FileEntry fileEntry) {
		try {
			PortletRequest pRequest = (PortletRequest) LiferayFacesContext
					.getCurrentInstance().getExternalContext().getRequest();
			String fileURL = DLUtil
					.getPreviewURL(fileEntry, fileEntry.getFileVersion(),
							(ThemeDisplay) pRequest
									.getAttribute(WebKeys.THEME_DISPLAY), "",
							false, true);
			return fileURL;
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

}