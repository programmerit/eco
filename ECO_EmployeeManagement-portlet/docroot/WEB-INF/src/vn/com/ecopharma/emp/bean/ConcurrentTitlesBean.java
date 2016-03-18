package vn.com.ecopharma.emp.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.model.EmpConcurrentTitles;
import vn.com.ecopharma.emp.service.EmpConcurrentTitlesLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

@ManagedBean(name = "concurrentBean")
@ViewScoped
public class ConcurrentTitlesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{organizationPanelBean}")
	private OrganizationPanelBean organizationPanelBean;

	private EmpIndexedItem empIndexedItem;

	public void onSave(ActionEvent event) {
		long titlesId = organizationPanelBean.getSelectedTitlesId();
		long departmentId = organizationPanelBean.getSelectedDepartmentId();
		long unitId = organizationPanelBean.getSelectedUnitId();
		long unitGroupId = organizationPanelBean.getSelectedUnitGroupId();

		if (titlesId == 0 || departmentId == 0) {
			return;
		}

		EmpConcurrentTitles result = EmpConcurrentTitlesLocalServiceUtil
				.addConcurrentTitles(empIndexedItem.getEmpId(), titlesId,
						departmentId, unitGroupId, unitId,
						EmployeeUtils.getServiceContext());
		if (result != null) {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									"Successful",
									empIndexedItem.getFullNameVi()
											+ " has been assigned concurrent titles successfully!"));
		}
		organizationPanelBean.afterSetOrganizationToEntity();
	}

	public OrganizationPanelBean getOrganizationPanelBean() {
		return organizationPanelBean;
	}

	public void setOrganizationPanelBean(
			OrganizationPanelBean organizationPanelBean) {
		this.organizationPanelBean = organizationPanelBean;
	}

	public EmpIndexedItem getEmpIndexedItem() {
		return empIndexedItem;
	}

	public void setEmpIndexedItem(EmpIndexedItem empIndexedItem) {
		this.empIndexedItem = empIndexedItem;
	}

}
