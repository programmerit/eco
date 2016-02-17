package vn.com.ecopharma.emp.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.EmpOrgRelationship;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpOrgRelationshipLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.portal.service.ServiceContext;

@ManagedBean
@ViewScoped
public class SetManagerBean {

	private static final String NOT_AT_ALL = "N/A";

	private Department department;

	private EmpIndexedItem currentSelectedManager;

	public void init() {

	}

	public void onSaveSetManager() {
		if (currentSelectedManager == null)
			return;

		final ServiceContext serviceContext = EmployeeUtils.getServiceContext();
		FacesMessage message = null;

		EmpOrgRelationship currentManagerRelationship = getCurrentManagerRelationship();
		if (currentManagerRelationship != null) {
			// ignore in case of setting the same employee as previous one
			if (currentManagerRelationship.getEmpId() == currentSelectedManager
					.getId())
				return;

			EmpOrgRelationshipLocalServiceUtil.updateEmpOrgRelationship(
					currentManagerRelationship.getEmpOrgRelationshipId(),
					currentSelectedManager.getEmpId(), serviceContext);

		} else {
			EmpOrgRelationshipLocalServiceUtil.addEmpOrgRelationship(
					currentSelectedManager.getEmpId(),
					Department.class.getName(), department.getDepartmentId(),
					true, false, serviceContext);
		}
		message = new FacesMessage("Information",
				"Successfully set manager for " + department.getName());

		FacesContext.getCurrentInstance().addMessage(null, message);
		// reset selected value
		currentSelectedManager = null;
	}

	public Department getDepartment() {
		return department;
	}

	public List<EmpIndexedItem> onCompleteEmps(String query) {
		return EmployeeUtils.searchEmpByName(query);
	}

	public String getFormattedEmpString(EmpIndexedItem empIndexedItem) {
		return empIndexedItem != null ? empIndexedItem.getFullNameVi() + " ("
				+ empIndexedItem.getEmployeeCode() + ") " : "";
	}

	public String getCurrentManagerFormattedString() {
		return getCurrentManager() != null ? getFormattedEmpString(getCurrentManager())
				: NOT_AT_ALL;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public EmpIndexedItem getCurrentManager() {
		EmpOrgRelationship currentManagerRelationship = getCurrentManagerRelationship();
		if (currentManagerRelationship == null)
			return null;
		return currentManagerRelationship.getEmpId() != 0 ? new EmpIndexedItem(
				EmpLocalServiceUtil.getIndexedEmp(
						currentManagerRelationship.getEmpId(),
						EmployeeUtils.getCurrentSearchContext())) : null;
	}

	private EmpOrgRelationship getCurrentManagerRelationship() {
		if (department == null)
			return null;

		return EmpOrgRelationshipLocalServiceUtil
				.fetchByClassNameClassPKHeadOfOrg(Department.class.getName(),
						department.getDepartmentId(), Boolean.TRUE);
	}

	public String getShortenEmpName(String fullName) {
		return EmployeeUtils.getShortenDisplayFullName(fullName);
	}

	public EmpIndexedItem getCurrentSelectedManager() {
		return currentSelectedManager;
	}

	public void setCurrentSelectedManager(EmpIndexedItem currentSelectedManager) {
		this.currentSelectedManager = currentSelectedManager;
	}
}
