package vn.com.ecopharma.hrm.tt.bean;

import java.io.Serializable;

import org.primefaces.model.LazyDataModel;

import vn.com.ecopharma.hrm.tt.dto.AbstractIndexedItem;

public abstract class AbstractBaseIndexedItemDataTableBean<T extends AbstractIndexedItem>
		implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LazyDataModel<T> lazyDataModel;

	public void init() {
		lazyDataModel = getConcreteLazyDataModel();
	}

	public LazyDataModel<T> getLazyDataModel() {
		return lazyDataModel;
	}

	public void setLazyDataModel(LazyDataModel<T> lazyDataModel) {
		this.lazyDataModel = lazyDataModel;
	}

	protected abstract LazyDataModel<T> getConcreteLazyDataModel();

}
