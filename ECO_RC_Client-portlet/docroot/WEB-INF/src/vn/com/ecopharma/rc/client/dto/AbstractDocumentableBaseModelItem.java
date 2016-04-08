package vn.com.ecopharma.rc.client.dto;

import java.util.ArrayList;
import java.util.List;

import vn.com.ecopharma.emp.model.Document;
import vn.com.ecopharma.emp.service.DocumentLocalServiceUtil;

import com.liferay.portal.model.BaseModel;

public abstract class AbstractDocumentableBaseModelItem<T extends BaseModel<T>>
		extends AbstractBaseModelItem<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<DocumentItem> documents;

	public AbstractDocumentableBaseModelItem() {
		super();
		this.documents = new ArrayList<>();
	}

	public AbstractDocumentableBaseModelItem(T object) {
		super(object);
		this.documents = getDocumentList(object);

	}

	protected List<DocumentItem> getDocumentList(T object) {
		final long id = Long.valueOf(object.getPrimaryKeyObj().toString());
		List<Document> documents = DocumentLocalServiceUtil
				.findByClassNameAndClassPK(object.getModelClassName(), id);
		final List<DocumentItem> docItems = new ArrayList<>();
		for (Document doc : documents) {
			docItems.add(new DocumentItem(doc));
		}
		return docItems;
	}

	public List<DocumentItem> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentItem> documents) {
		this.documents = documents;
	}

	public boolean isEmptyDocuments() {
		return documents.isEmpty();
	}
}
