package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.PromotedHistory;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.PromotedHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@ManagedBean
@ViewScoped
public class PromotionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long employeeId;

	private PromotedHistory promotedHistory;

	private Titles titles;
	private Devision devision;
	private Department department;
	private Unit unit;
	private UnitGroup unitGroup;

	@PostConstruct
	public void init() {
		promotedHistory = PromotedHistoryLocalServiceUtil.createPrePersisted();
	}

	public void onSave() {
		FacesMessage msg = null;
		EmpIndexedItem employeeIndexedItem = getEmployeeIndexedItem();
		if (titles.getTitlesId() != employeeIndexedItem.getTitlesId()) {
			long titlesId = titles.getTitlesId();
			long unitGroupId = EmployeeUtils.getBaseModelPrimaryKey(unitGroup);
			long unitId = EmployeeUtils.getBaseModelPrimaryKey(unit);
			long departmentId = EmployeeUtils
					.getBaseModelPrimaryKey(department);

			promotedHistory.setOldTitlesId(employeeIndexedItem.getTitlesId());
			promotedHistory.setNewTitlesId(titlesId);
			promotedHistory.setEmployeeId(employeeIndexedItem.getId());
			PromotedHistory result = PromotedHistoryLocalServiceUtil
					.addPromotedHistory(promotedHistory, unitGroupId, unitId,
							departmentId, LiferayFacesContext.getInstance()
									.getServiceContext());
			if (result != null) {
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Promotion Info", "Employee "
								+ employeeIndexedItem.getFullName()
								+ " has been promoted to position ['"
								+ titles.getName() + "'] sucessfully");
			}
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Duplicate titles", "Fail to promote "
							+ employeeIndexedItem.getFullName());
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCancelEdit() {
		devision = null;
		department = null;
		unit = null;
		unitGroup = null;
		titles = null;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public PromotedHistory getPromotedHistory() {
		return promotedHistory;
	}

	public void setPromotedHistory(PromotedHistory promotedHistory) {
		this.promotedHistory = promotedHistory;
	}

	public EmpIndexedItem getEmployeeIndexedItem() {
		if (employeeId != 0) {
			return new EmpIndexedItem(EmpLocalServiceUtil.getIndexedEmp(
					employeeId, EmployeeUtils.getCurrentSearchContext()));
		}
		return null;
	}

	public Titles getOldTitles() {
		try {
			return getEmployeeIndexedItem() != null ? TitlesLocalServiceUtil
					.getTitles(getEmployeeIndexedItem().getTitlesId()) : null;
		} catch (PortalException e) {
			LogFactoryUtil.getLog(PromotionBean.class).info(e);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(PromotionBean.class).info(e);
		}
		return null;
	}

	public List<Titles> getTitlesList() {
		if (unit == null) {
			return department != null ? TitlesLocalServiceUtil
					.findByDepartmentOnly(department.getDepartmentId())
					: new ArrayList<Titles>();
		} else {
			if (unitGroup != null) {
				return TitlesLocalServiceUtil.findByUnitGroupOnly(unitGroup
						.getUnitGroupId());
			} else {
				return TitlesLocalServiceUtil.findByUnitOnly(unit.getUnitId());
			}
		}
	}

	public List<UnitGroup> getUnitGroups() {
		return unit != null ? UnitGroupLocalServiceUtil.findByUnit(unit
				.getUnitId()) : null;
	}

	public List<Unit> getUnits() {
		final Department empDepartment = department;
		return empDepartment != null ? UnitLocalServiceUtil
				.findByDepartment(empDepartment.getDepartmentId())
				: new ArrayList<Unit>();
	}

	public List<Department> getDepartments() {
		List<Department> departments = devision != null ? DepartmentLocalServiceUtil
				.findByDevision(devision.getDevisionId())
				: new ArrayList<Department>();
		if (departments.isEmpty() || !departments.contains(department)) {
			department = null;
		}
		return departments;
	}

	public List<Devision> getDevisions() {
		return DevisionLocalServiceUtil.findAll();
	}

	public void onDevisionChanged() {
		department = null;
		unit = null;
		unitGroup = null;
		titles = null;
	}

	public void onDepartmentChanged() {
		unit = null;
		unitGroup = null;
		titles = null;
	}

	public void onUnitChanged() {
		unitGroup = null;
		titles = null;
	}

	public void onUnitGroupChanged() {
		titles = null;
	}

	public Titles getTitles() {
		return titles;
	}

	public void setTitles(Titles titles) {
		this.titles = titles;
	}

	public Devision getDevision() {
		return devision;
	}

	public void setDevision(Devision devision) {
		this.devision = devision;
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
}
