package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;

import org.primefaces.event.FileUploadEvent;

public interface DocumentBean extends Serializable {

	public void handleDocumentUpload(FileUploadEvent event);

	public void deleteDocument();
}
