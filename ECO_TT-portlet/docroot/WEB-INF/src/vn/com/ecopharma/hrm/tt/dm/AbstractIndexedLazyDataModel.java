package vn.com.ecopharma.hrm.tt.dm;

import org.primefaces.model.LazyDataModel;

import vn.com.ecopharma.hrm.tt.dto.AbstractIndexedItem;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

import com.liferay.portal.kernel.search.SearchContext;

public class AbstractIndexedLazyDataModel<T extends AbstractIndexedItem>
		extends LazyDataModel<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static final SearchContext searchContext = TTUtils
			.getCurrentSearchContext();

	@Override
	public Object getRowKey(T object) {
		return object.getId();
	}
}
