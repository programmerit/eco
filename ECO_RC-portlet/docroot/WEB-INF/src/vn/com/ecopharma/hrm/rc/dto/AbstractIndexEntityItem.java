package vn.com.ecopharma.hrm.rc.dto;

import java.io.Serializable;

import com.liferay.portal.kernel.search.Document;

public abstract class AbstractIndexEntityItem implements
		IndexedEntity<Document>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Document document;

	private long id;

	public AbstractIndexEntityItem(Document document) {
		this.document = document;
		this.id = Long.valueOf(document.getField(idFieldName()).getValue());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractIndexEntityItem) {
			AbstractIndexEntityItem that = (AbstractIndexEntityItem) obj;
			return this.getId() == that.getId();
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime
				* result
				* (this.getId() == 0 ? 0 : Long.valueOf(this.getId())
						.hashCode());
		return result;
	}

	protected abstract String idFieldName();
}
