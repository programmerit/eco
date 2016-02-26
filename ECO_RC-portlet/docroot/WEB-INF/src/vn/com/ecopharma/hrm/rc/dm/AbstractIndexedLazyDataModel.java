package vn.com.ecopharma.hrm.rc.dm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.hrm.rc.constant.ECO_RCUtils;
import vn.com.ecopharma.hrm.rc.dto.AbstractIndexedItem;

import com.liferay.portal.kernel.search.SearchContext;

public abstract class AbstractIndexedLazyDataModel<T extends AbstractIndexedItem>
		extends LazyDataModel<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public abstract T getRowData(String rowKey);

	@Override
	public Object getRowKey(T object) {
		return object.getId();
	}

	@Override
	public List<T> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		return new ArrayList<>();
	}

	protected SearchContext getSearchContext() {
		return ECO_RCUtils.getCurrentSearchContext();
	}

	protected long getCompanyId() {
		return getSearchContext().getCompanyId();
	}

}
