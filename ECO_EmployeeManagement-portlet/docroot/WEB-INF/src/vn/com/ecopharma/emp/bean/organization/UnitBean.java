package vn.com.ecopharma.emp.bean.organization;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import vn.com.ecopharma.emp.bean.AbstractOrganizationBean;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;
import vn.com.ecopharma.emp.util.SearchEngineUtils;

/**
 * @author TaoTran
 *
 */
@ManagedBean
@ViewScoped
public class UnitBean extends AbstractOrganizationBean {

	private static final long serialVersionUID = 1L;

	private Unit unit;

	private Department department;

	private String updateComponents;

	private boolean isEdit;

	@PostConstruct
	public void init() {
	}

	public void onSave(ActionEvent event) {
		// Department department = BeanUtils.getEmployeeViewBean()
		// .getModifyEmployeeInfoItem().getDepartment();
		// unit.setDepartmentId(department.getDepartmentId());
		// Unit result = UnitLocalServiceUtil.addUnit(unit,
		// EmployeeUtils.getServiceContext());
		// if (result != null) {
		// FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
		// "Create Unit successfully", "Unit " + unit.getName()
		// + " has been created");
		// FacesContext.getCurrentInstance().addMessage(null, msg);
		// }
		if (!isEdit) {
			unit.setDepartmentId(department.getDepartmentId());
			UnitLocalServiceUtil.addUnit(unit,
					EmployeeUtils.getServiceContext());
		} else {
			UnitLocalServiceUtil.updateUnit(unit,
					EmployeeUtils.getServiceContext(),
					EmployeeUtils.getCurrentSearchContext());
		}
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getUpdateComponents() {
		return updateComponents;
	}

	public void setUpdateComponents(String updateComponents) {
		this.updateComponents = updateComponents;
	}

	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

}
