package vn.com.ecopharma.hrm.tt.dto;

import com.liferay.portal.kernel.search.Document;

public interface IndexedItem<E> {

	public E create(Document document);

}
