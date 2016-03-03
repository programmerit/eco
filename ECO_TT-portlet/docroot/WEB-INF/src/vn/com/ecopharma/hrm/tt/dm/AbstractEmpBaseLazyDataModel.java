package vn.com.ecopharma.hrm.tt.dm;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.hrm.tt.bean.filter.BaseEmpFilterBean;
import vn.com.ecopharma.hrm.tt.constant.EmpField;
import vn.com.ecopharma.hrm.tt.dto.AbstractIndexedItem;

public abstract class AbstractEmpBaseLazyDataModel<T extends AbstractIndexedItem, S extends BaseEmpFilterBean>
		extends AbstractBaseOrganizationLazyDataModel<T, S> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public abstract List<T> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters);

	@Override
	public abstract T getRowData(String rowKey);

	@Override
	protected void bindOrganizationFilterFields(Map<String, Object> filters,
			S bean) {
		if (!StringUtils.EMPTY.equals(bean.getFullName())) {
			filters.put(EmpField.VN_FULL_NAME, bean.getFullName());
		}

		if (!StringUtils.EMPTY.equals(bean.getEmpCode())) {
			filters.put(EmpField.EMP_CODE, bean.getEmpCode());
		}
		super.bindOrganizationFilterFields(filters, bean);
	}
}
