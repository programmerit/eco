package vn.com.ecopharma.emp.dm;

import org.primefaces.model.LazyDataModel;

import vn.com.ecopharma.emp.dto.AbstractIndexedItem;

public class AbstractIndexedLazyDataModel<T extends AbstractIndexedItem>
		extends LazyDataModel<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object getRowKey(T object) {
		return object.getId();
	}
}
