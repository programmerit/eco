package vn.com.ecopharma.emp.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@ManagedBean
public class DepartmentBean extends AbstractOrganizationBean {

	private static final long serialVersionUID = 1L;

	private Department department;

	@PostConstruct
	public void init() {
		try {
			department = DepartmentLocalServiceUtil
					.createDepartment(CounterLocalServiceUtil.increment());
		} catch (SystemException e) {
			LogFactoryUtil.getLog(DepartmentBean.class).info(e);
		}
	}

	@Override
	public void onSave(ActionEvent event) {
		final EmployeeBean employeeViewBean = BeanUtils.getEmployeeViewBean();
		final Devision selectedDevision = employeeViewBean
				.getModifyEmployeeInfoItem().getDevision();
		if (selectedDevision != null) {
			department.setDevisionId(selectedDevision.getDevisionId());
			Department result = DepartmentLocalServiceUtil.addDepartment(
					department, EmployeeUtils.getServiceContext());
			if (result != null) {
				employeeViewBean.getModifyEmployeeInfoItem().setDepartment(
						result);
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Create Department successfully", "Department "
								+ result.getName() + " has been created");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
