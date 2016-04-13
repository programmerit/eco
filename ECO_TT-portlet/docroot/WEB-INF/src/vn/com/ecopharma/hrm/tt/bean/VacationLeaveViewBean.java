package vn.com.ecopharma.hrm.tt.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import vn.com.ecopharma.emp.model.VacationLeave;
import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.dm.VacationLeaveIndexLazyDataModel;
import vn.com.ecopharma.hrm.tt.dto.VacationLeaveIndexedItem;
import vn.com.ecopharma.hrm.tt.enumeration.VacationLeaveStatus;
import vn.com.ecopharma.hrm.tt.enumeration.VacationLeaveType;
import vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

@ManagedBean(name = "leaveViewBean")
@ViewScoped
public class VacationLeaveViewBean
		extends
		AbstractEditableBaseEmpIndexedItemDataTableBean<VacationLeaveIndexedItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(VacationLeaveViewBean.class);

	@PostConstruct
	public void init() {
		super.init();
	}

	@Override
	protected LazyDataModel<VacationLeaveIndexedItem> getConcreteLazyDataModel() {
		return new VacationLeaveIndexLazyDataModel();
	}

	public void onRowEdit(RowEditEvent event) {
		final VacationLeaveIndexedItem obj = (VacationLeaveIndexedItem) event
				.getObject();
		try {
			VacationLeave oldVacationLeave = VacationLeaveLocalServiceUtil
					.fetchVacationLeave(obj.getId());

			VacationLeave updatedVacationLeave = VacationLeaveLocalServiceUtil
					.updateVacationLeave(obj.getId(), obj.getType(),
							obj.getSign(), obj.getLeaveFrom(),
							obj.getLeaveTo(), obj.getActualTo(),
							obj.getReason(), obj.getDescription(),
							obj.getStatus());

			TimeTrackingLocalServiceUtil
					.updateTimeTrackingsByUpdatedVacationLeave(
							oldVacationLeave, updatedVacationLeave);

		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}

	public void onRowEditCancel(RowEditEvent event) {

	}

	public void onIndexAll() {
		VacationLeaveLocalServiceUtil.indexAll();
	}

	public void onRemoveAllIndex() {
		VacationLeaveLocalServiceUtil.removeAllIndexes(TTUtils
				.getCurrentSearchContext(), TTUtils.getCurrentSearchContext()
				.getCompanyId());
	}

	public void onAddMissingTimeTrackingData() {
		TimeTrackingLocalServiceUtil
				.scanAndAddMissingDataByLeaveRequests(VacationLeaveLocalServiceUtil
						.findAll());
	}

	public List<String> getLeaveTypes() {
		return VacationLeaveType.getAll();
	}

	public List<String> getStatuses() {
		return VacationLeaveStatus.getAll();
	}

	public List<String> getLeaveSignsByType(String type) {
		final List<String> result = new ArrayList<>();
		if (StringUtils.EMPTY.equalsIgnoreCase(type))
			return result;

		VacationLeaveType typeEnum = VacationLeaveType.valueOf(type);
		return typeEnum.getSigns();
	}
}
