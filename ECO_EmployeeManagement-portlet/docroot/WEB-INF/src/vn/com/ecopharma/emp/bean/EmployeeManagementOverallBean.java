package vn.com.ecopharma.emp.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

@ManagedBean(name = "overallBean")
@ViewScoped
public class EmployeeManagementOverallBean {

	public long getEmpId() {
		long currentUser = EmployeeUtils.getServiceContext().getUserId();
		Emp empByUser = EmpLocalServiceUtil.findByUser(currentUser);
		return empByUser != null ? empByUser.getEmpId() : 0L;
	}
}
