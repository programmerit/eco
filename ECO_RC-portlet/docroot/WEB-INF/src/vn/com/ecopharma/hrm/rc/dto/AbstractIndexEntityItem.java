package vn.com.ecopharma.hrm.rc.dto;

import java.io.Serializable;

import com.liferay.portal.kernel.search.Document;

public abstract class AbstractIndexEntityItem implements IndexedEntity<Document>,
		Serializable {

	private static final long serialVersionUID = 1L;
	private Document document;

	public AbstractIndexEntityItem(Document document) {
		this.document = document;
	}

	public long getId() {
		return Long.valueOf(document.getField(idFieldName()).getValue());
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	protected abstract String idFieldName();
}
