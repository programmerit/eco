package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.enumeration.ResignationType;
import vn.com.ecopharma.emp.model.ResignationHistory;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.ResignationHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.service.ServiceContext;

/**
 * @author TaoTran
 *
 */
@ManagedBean
@ViewScoped
public class ResignationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ResignationHistory resignationHistory;

	private long employeeId;

	@PostConstruct
	public void init() {
		
	}

	public void save() {
		final ServiceContext serviceContext = LiferayFacesContext.getInstance()
				.getServiceContext();
		EmpIndexedItem employeeIndexedItem = getEmployeeIndexedItem();
		resignationHistory.setEmployeeId(employeeIndexedItem.getEmployeeId());
		final ResignationHistory result = ResignationHistoryLocalServiceUtil
				.addResignationHistory(resignationHistory, serviceContext);
		if (result != null) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Resignation Info", "Employee "
							+ employeeIndexedItem.getFullName()
							+ " has been resigned sucessfully");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public ResignationHistory getResignationHistory() {
		return resignationHistory;
	}

	public EmpIndexedItem getEmployeeIndexedItem() {
		return employeeId != 0 ? new EmpIndexedItem(
				EmpLocalServiceUtil.getIndexedEmp(employeeId,
						EmployeeUtils.getCurrentSearchContext())) : null;
	}

	public void setResignationHistory(ResignationHistory resignationHistory) {
		this.resignationHistory = resignationHistory;
	}

	public List<String> getResignationTypes() {
		return EmployeeUtils.getResignationTypes();
	}

	public String getLocalizedResignationType(String r) {
		return EmployeeUtils.getLocalizedResignationType(r);
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

}
