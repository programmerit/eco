package vn.com.ecopharma.hrm.tt.bean;

import org.primefaces.event.RowEditEvent;

import vn.com.ecopharma.hrm.tt.dto.BaseEmpInfoIndexedItem;

/**
 * @author TaoTran
 *
 * @param <T>
 */
public abstract class AbstractEditableBaseEmpIndexedItemDataTableBean<T extends BaseEmpInfoIndexedItem>
		extends AbstractBaseEmpIndexedItemDataTableBean<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private T selectedItem;

	public T getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(T selectedItem) {
		this.selectedItem = selectedItem;
	}

	public abstract void onRowEdit(RowEditEvent event);

	public abstract void onRowEditCancel(RowEditEvent event);
}
