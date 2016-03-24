package vn.com.ecopharma.hrm.tt.dm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.service.EmpAnnualLeaveLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.bean.filter.AnnualLeaveFilterBean;
import vn.com.ecopharma.hrm.tt.dto.AnnualLeaveIndexedItem;
import vn.com.ecopharma.hrm.tt.utils.BeanUtils;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.ParseException;

public class AnnualLeaveLazyDataModel
		extends
		AbstractEmpBaseLazyDataModel<AnnualLeaveIndexedItem, AnnualLeaveFilterBean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(AnnualLeaveLazyDataModel.class);

	@Override
	public List<AnnualLeaveIndexedItem> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		AnnualLeaveFilterBean filterBean = (AnnualLeaveFilterBean) BeanUtils
				.getBackingBeanByName("annualLeaveFilterBean");
		super.bindEmpFilterFields(filters, filterBean);
		try {

			final List<AnnualLeaveIndexedItem> result = TTUtils
					.getAnnualLeaveItems(EmpAnnualLeaveLocalServiceUtil
							.filterByFields(TTUtils.getCurrentSearchContext(),
									filters, null, companyId, first, first
											+ pageSize));
			int count = EmpAnnualLeaveLocalServiceUtil.countFilterByFields(
					TTUtils.getCurrentSearchContext(), filters, null, companyId);
			setRowCount(count);

			return result;
		} catch (ParseException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public AnnualLeaveIndexedItem getRowData(String rowKey) {
		return new AnnualLeaveIndexedItem(rowKey);
	}
}
