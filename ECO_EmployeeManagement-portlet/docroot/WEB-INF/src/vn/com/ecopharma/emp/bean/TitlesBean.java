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
import vn.com.ecopharma.emp.service.TitlesDepartmentUnitUnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@ManagedBean
@ViewScoped
public class TitlesBean extends AbstractOrganizationBean {
	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactoryUtil.getLog(TitlesBean.class);

	private Titles titles;

	private Department department;

	private Unit unit;

	private UnitGroup unitGroup;

	private boolean updateTree;

	@PostConstruct
	public void init() {
		titles = titles != null ? titles : TitlesLocalServiceUtil
				.createPrePersistedTitles();
	}

	@Override
	public void onSave(ActionEvent event) {
		try {
			FacesMessage msg;
			Titles result;
			boolean isEdit = false;
			if (TitlesLocalServiceUtil.fetchTitles(titles.getTitlesId()) == null) {
				result = TitlesLocalServiceUtil.addTitles(titles,
						EmployeeUtils.getServiceContext());
				TitlesDepartmentUnitUnitGroupLocalServiceUtil
						.addTitlesDepartmentUnitUnitGroup(result, department,
								unit, unitGroup,
								EmployeeUtils.getServiceContext());
				msg = getResultMessage(result, "Create Titles successfully",
						"Titles " + titles.getName() + " has been created");

			} else {
				isEdit = true;
				result = TitlesLocalServiceUtil.updateTitles(titles);
				msg = getResultMessage(result, "Update Titles successfully",
						"Titles " + titles.getName() + " has been updated");
			}
			if (updateTree) {
				if (isEdit) {
					BeanUtils.getOrganizationTreeViewBean()
							.updateTreeOnTitlesEdited(result);
				} else {
					BeanUtils.getOrganizationTreeViewBean()
							.updateTreeOnTitlesAdded(result);
				}
			}

			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}

	private static FacesMessage getResultMessage(Titles notNullObj,
			String successMsgTitle, String successMsgContent) {
		if (notNullObj == null)
			return new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Action on Titles Failed",
					"Failed on taking action on Titles");
		else
			return new FacesMessage(FacesMessage.SEVERITY_INFO,
					successMsgTitle, successMsgContent);
	}

	public Titles getTitles() {
		return titles;
	}

	public void setTitles(Titles titles) {
		this.titles = titles;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public UnitGroup getUnitGroup() {
		return unitGroup;
	}

	public void setUnitGroup(UnitGroup unitGroup) {
		this.unitGroup = unitGroup;
	}

	public boolean isUpdateTree() {
		return updateTree;
	}

	public void setUpdateTree(boolean updateTree) {
		this.updateTree = updateTree;
	}
}