package vn.com.ecopharma.emp.dto;

import vn.com.ecopharma.emp.model.Document;
import vn.com.ecopharma.emp.service.DocumentLocalServiceUtil;

import com.liferay.portal.kernel.repository.model.FileEntry;

public class DocumentItem extends AbstractUIBaseModelItem<Document> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FileEntry fileEntry;

	private String fileURL;

	public DocumentItem() {
		super();
	}

	public DocumentItem(Document document) {
		super(document);
		this.fileEntry = DocumentLocalServiceUtil.getFileEntry(getObject());
		this.fileURL = DocumentLocalServiceUtil.getFilePath(fileEntry);
	}

	@Override
	protected Document createPrePersistedBaseModel() {
		return DocumentLocalServiceUtil
				.createPrePersistedEntity(getServiceContext());
	}

	public FileEntry getFileEntry() {
		return fileEntry;
	}

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	public void setFileEntry(FileEntry fileEntry) {
		this.fileEntry = fileEntry;
	}

}
