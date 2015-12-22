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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
public class UnitGroupBean extends AbstractOrganizationBean {

	private static final long serialVersionUID = 1L;

	private UnitGroup unitGroup;

	@PostConstruct
	public void init() {
		try {
			unitGroup = UnitGroupLocalServiceUtil
					.createUnitGroup(CounterLocalServiceUtil.increment());
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onSave(ActionEvent event) {
		try {
			final EmployeeBean employeeViewBean = BeanUtils
					.getEmployeeViewBean();
			final Unit unit = employeeViewBean.getModifyEmployeeInfoItem()
					.getUnit();
			if (unit != null) {
				unitGroup.setUnitId(unit.getUnitId());
				UnitGroup result = UnitGroupLocalServiceUtil
						.addUnitGroup(unitGroup);
				if (result != null) {
					FacesMessage msg = new FacesMessage(
							FacesMessage.SEVERITY_INFO,
							"Create Unit Group successfully", "Devision "
									+ result.getName() + " has been created");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public UnitGroup getUnitGroup() {
		return unitGroup;
	}

	public void setUnitGroup(UnitGroup unitGroup) {
		this.unitGroup = unitGroup;
	}
}
