package vn.com.ecopharma.emp.dm;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.bean.filter.BaseEmpFilterBean;
import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.dto.AbstractIndexedItem;

public abstract class AbstractEmpBaseLazyDataModel<T extends AbstractIndexedItem, S extends BaseEmpFilterBean>
		extends AbstractBaseOrganizationLazyDataModel<T, S> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
