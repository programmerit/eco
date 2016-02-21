package vn.com.ecopharma.emp.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@ManagedBean
public class UnitGroupBean extends AbstractOrganizationBean {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(UnitGroupBean.class);

	private UnitGroup unitGroup;

	@PostConstruct
	public void init() {
		try {
			unitGroup = UnitGroupLocalServiceUtil
					.createUnitGroup(CounterLocalServiceUtil.increment());
		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}

	@Override
	public void onSave(ActionEvent event) {
		final EmployeeBean employeeViewBean = BeanUtils.getEmployeeViewBean();
		final Unit unit = employeeViewBean.getModifyEmployeeInfoItem()
				.getUnit();
		if (unit != null) {
			unitGroup.setUnitId(unit.getUnitId());
			UnitGroup result = UnitGroupLocalServiceUtil.addUnitGroup(
					unitGroup, EmployeeUtils.getServiceContext());
			if (result != null) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Create Unit Group successfully", "Unit group "
								+ result.getName() + " has been created");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
	}

	public UnitGroup getUnitGroup() {
		return unitGroup;
	}

	public void setUnitGroup(UnitGroup unitGroup) {
		this.unitGroup = unitGroup;
	}
}
