package vn.com.ecopharma.emp.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@ManagedBean
@ViewScoped
public class TitlesBean extends AbstractOrganizationBean {
	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactoryUtil.getLog(TitlesBean.class);

	private Titles titles;

	@PostConstruct
	public void init() {
		titles = titles != null ? titles : TitlesLocalServiceUtil
				.createPrePersistedTitles();
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
				FacesMessage msg = null;
				titles.setDepartmentId(department.getDepartmentId());
				titles.setUnitId(unit != null ? unit.getUnitId() : 0L);
				titles.setUnitGroupId(unitGroup != null ? unitGroup
						.getUnitGroupId() : 0L);
				if (TitlesLocalServiceUtil.fetchTitles(titles.getTitlesId()) == null) {
					Titles result = TitlesLocalServiceUtil.addTitles(titles);
					addResultMessage(result, msg, "Create Titles successfully",
							"Titles " + titles.getName() + " has been created");

				} else {
					Titles result = TitlesLocalServiceUtil.updateTitles(titles);
					addResultMessage(result, msg, "Update Titles successfully",
							"Titles " + titles.getName() + " has been updated");
				}
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}

	private static void addResultMessage(Titles notNullObj, FacesMessage msg,
			String successMsgTitle, String successMsgContent) {
		if (notNullObj == null)
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Action on Titles Failed",
					"Failed on taking action on Titles");
		else
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, successMsgTitle,
					successMsgContent);
	}

	public Titles getTitles() {
		return titles;
	}

	public void setTitles(Titles titles) {
		this.titles = titles;
	}
}