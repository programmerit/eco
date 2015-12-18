package vn.com.ecopharma.emp.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
public class TitlesBean extends AbstractOrganizationBean {
	private static final long serialVersionUID = 1L;

	private Titles titles;

	@PostConstruct
	public void init() {
		try {
			titles = TitlesLocalServiceUtil
					.createTitles(CounterLocalServiceUtil.increment());
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onSave(ActionEvent event) {
		try {
			final EmployeeBean employeeViewBean = BeanUtils
					.getEmployeeViewBean();
			final Department department = employeeViewBean
					.getModifyEmployeeInfoItem().getDepartment();
			final Unit unit = employeeViewBean.getModifyEmployeeInfoItem()
					.getUnit();
			final UnitGroup unitGroup = employeeViewBean
					.getModifyEmployeeInfoItem().getUnitGroup();
			if (department != null) {
				titles.setDepartmentId(department.getDepartmentId());
				titles.setUnitId(unit != null ? unit.getUnitId() : 0L);
				titles.setUnitGroupId(unitGroup != null ? unitGroup
						.getUnitGroupId() : 0L);
				Titles result = TitlesLocalServiceUtil.addTitles(titles);
				if (result != null) {
					FacesMessage msg = new FacesMessage(
							FacesMessage.SEVERITY_INFO,
							"Create Titles successfully", "Titles "
									+ titles.getName() + " has been created");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public Titles getTitles() {
		return titles;
	}

	public void setTitles(Titles titles) {
		this.titles = titles;
	}
}