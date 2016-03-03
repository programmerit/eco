package vn.com.ecopharma.emp.dm;

import org.primefaces.model.LazyDataModel;

import com.liferay.portal.kernel.search.SearchContext;

import vn.com.ecopharma.emp.dto.AbstractIndexedItem;
import vn.com.ecopharma.emp.util.EmployeeUtils;

public class AbstractIndexedLazyDataModel<T extends AbstractIndexedItem>
		extends LazyDataModel<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static final SearchContext searchContext = EmployeeUtils
			.getCurrentSearchContext();

	@Override
	public Object getRowKey(T object) {
		return object.getId();
	}
}
