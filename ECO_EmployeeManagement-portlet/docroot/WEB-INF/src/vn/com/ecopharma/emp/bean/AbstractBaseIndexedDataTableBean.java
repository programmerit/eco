package vn.com.ecopharma.emp.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.primefaces.model.LazyDataModel;

import vn.com.ecopharma.emp.dto.AbstractIndexedItem;

public abstract class AbstractBaseIndexedDataTableBean<T extends AbstractIndexedItem>
		implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LazyDataModel<T> lazyDataModel;

	private T selectedItem;

	@PostConstruct
	public void init() {
		lazyDataModel = initializeLazyDataModel();
	}

	public LazyDataModel<T> getLazyDataModel() {
		return lazyDataModel;
	}

	public void setLazyDataModel(LazyDataModel<T> lazyDataModel) {
		this.lazyDataModel = lazyDataModel;
	}

	public abstract LazyDataModel<T> initializeLazyDataModel();

	public T getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(T selectedItem) {
		this.selectedItem = selectedItem;
	}
}
