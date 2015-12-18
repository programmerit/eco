package vn.com.ecopharma.emp.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
public class UnitBean extends AbstractOrganizationBean {

	private static final long serialVersionUID = 1L;

	private Unit unit;

	@PostConstruct
	public void init() {
		try {
			// unit.setLocationId(location.getLocationId());
			unit = UnitLocalServiceUtil.createUnit(CounterLocalServiceUtil
					.increment());
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public void onSave(ActionEvent event) {
		try {
			Department department = BeanUtils.getEmployeeViewBean()
					.getModifyEmployeeInfoItem().getDepartment();
			unit.setDepartmentId(department.getDepartmentId());
			Unit result = UnitLocalServiceUtil.addUnit(unit);
			if (result != null) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Create Unit successfully", "Unit " + unit.getName()
								+ " has been created");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
