package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.portlet.PortletRequest;

import org.primefaces.context.RequestContext;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.portlet.documentlibrary.util.PDFProcessorUtil;

@ManagedBean
@ViewScoped
public class PreviewBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String PREVIEW_FILE_INDEX = "&previewFileIndex=";

	private int previewFileCount = 0;

	private String previewFileURL;

	private String docURL;

	private List<String> thumbnailImageLinks;

	private int currentPage = 1;

	public void getFilePreviewInfo(long fileEntryId) {
		try {
			PortletRequest request = (PortletRequest) LiferayFacesContext
					.getInstance().getExternalContext().getRequest();
			final ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);
			final DLFileEntry fileEntry = DLFileEntryLocalServiceUtil
					.getDLFileEntry(fileEntryId);
			final FileEntry fe = DLAppServiceUtil.getFileEntry(fileEntry
					.getFileEntryId());
			final FileVersion version = fe.getFileVersion();
			docURL = DLUtil.getPreviewURL(fe, version, themeDisplay, "");
			previewFileCount = PDFProcessorUtil.getPreviewFileCount(version);
			previewFileURL = docURL + PREVIEW_FILE_INDEX + currentPage;
			thumbnailImageLinks = new ArrayList<String>();
			for (int i = 1; i < previewFileCount; i++) {
				final String thumbLink = docURL + PREVIEW_FILE_INDEX + i;
				thumbnailImageLinks.add(thumbLink);
			}
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public void onChangePreviewImage(int index) {
		this.currentPage = index + 1;
		previewFileURL = this.docURL + PREVIEW_FILE_INDEX + currentPage;
	}

	public void onNext(ActionEvent event) {
		if (this.currentPage == previewFileCount) {
			currentPage = 1;
		} else {
			currentPage++;
		}
		previewFileURL = this.docURL + PREVIEW_FILE_INDEX + currentPage;
	}

	public void onPrev(ActionEvent event) {
		if (this.currentPage == 1) {
			currentPage = previewFileCount;
		} else {
			currentPage--;
		}
		previewFileURL = this.docURL + PREVIEW_FILE_INDEX + currentPage;
	}

	public void onEnLargeViewMode(ActionEvent event) {
		previewFileURL = this.docURL + PREVIEW_FILE_INDEX + currentPage;
		RequestContext.getCurrentInstance().update(
				":previewForm:largePreviewOutputPanel");
		RequestContext.getCurrentInstance().execute(
				"PF('wLargePreviewDialog').show()");
	}

	public void onCloseLargePreview(ActionEvent event) {
		RequestContext.getCurrentInstance().update(
				":previewForm:previewFileContainer");
	}

	public int getPreviewFileCount() {
		return previewFileCount;
	}

	public void setPreviewFileCount(int previewFileCount) {
		this.previewFileCount = previewFileCount;
	}

	public String getPreviewFileURL() {
		return previewFileURL;
	}

	public void setPreviewFileURL(String previewFileURL) {
		this.previewFileURL = previewFileURL;
	}

	public String getDocURL() {
		return docURL;
	}

	public void setDocURL(String docURL) {
		this.docURL = docURL;
	}

	public List<String> getThumbnailImageLinks() {
		return thumbnailImageLinks;
	}

	public void setThumbnailImageLinks(List<String> thumbnailImageLinks) {
		this.thumbnailImageLinks = thumbnailImageLinks;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
