package vn.com.ecopharma.emp.bean.global;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpOrgRelationship;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpOrgRelationshipLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@SessionScoped
public class AuthorityBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> searchableDevisions;
	private List<String> searchableDepartments;
	private List<String> searchableUnits;

	private Set<Long> searchableDevisionIds;
	private Set<Long> searchableDepartmentIds;
	private Set<Long> searchableUnitIds;

	private boolean isDepartmentManager;

	private boolean isUnitManager;

	@PostConstruct
	public void init() {
		searchableDevisionIds = new HashSet<>();
		searchableDepartmentIds = new HashSet<>();
		searchableUnitIds = new HashSet<>();
		long userId = LiferayFacesContext.getInstance().getUserId();

		if (BeanUtils.getEmpModelPermission().isHrPermission()) {
			searchableDevisions = allDevisions();
		}

		final Set<Long> devisionSet = new HashSet<>();
		final Set<Long> departmentSet = new HashSet<>();
		final Set<Long> unitSet = new HashSet<>();

		Emp empByUser = EmpLocalServiceUtil.findByUser(userId);
		if (empByUser != null) {
			final List<EmpOrgRelationship> empOrgRelationships = EmpOrgRelationshipLocalServiceUtil
					.findByEmp(empByUser.getEmpId());
			for (EmpOrgRelationship empOrgRelationship : empOrgRelationships) {
				if (isDepartmentManagerAuthorized(empOrgRelationship)) {
					long departmentId = empOrgRelationship.getOrgClassPK();
					long devisionId = getDevisionIdFromDepartment(departmentId);

					departmentSet.add(empOrgRelationship.getOrgClassPK());
					devisionSet.add(devisionId);
					isDepartmentManager = true;
				} else if (isUnitManagerAuthorized(empOrgRelationship)) {
					long unitId = empOrgRelationship.getOrgClassPK();
					long departmentId = getDepartmentIdFromUnit(unitId);
					long devisionId = getDevisionIdFromDepartment(departmentId);

					unitSet.add(unitId);
					departmentSet.add(departmentId);
					devisionSet.add(devisionId);
					isUnitManager = true;
				}
			}
		}

		System.out.println("Devisions: " + devisionSet);

		System.out.println("Departments: " + departmentSet);

		System.out.println("Units: " + unitSet);

		searchableDevisionIds.addAll(devisionSet);
		searchableDepartmentIds.addAll(departmentSet);
		searchableUnitIds.addAll(unitSet);

	}

	public boolean isTickableDevision(long id) {
		return searchableDevisionIds.contains(id);
	}

	private boolean isDepartmentManagerAuthorized(
			EmpOrgRelationship empOrgRelationship) {
		if (!empOrgRelationship.getOrgClassName().equalsIgnoreCase(
				Department.class.getName()))
			return false;
		return empOrgRelationship.getHeadOfOrg();
	}

	private boolean isUnitManagerAuthorized(
			EmpOrgRelationship empOrgRelationship) {
		if (!empOrgRelationship.getOrgClassName().equalsIgnoreCase(
				Unit.class.getName()))
			return false;
		return empOrgRelationship.getHeadOfOrg();
	}

	public boolean isDevisionSelectable() {
		return BeanUtils.getEmpModelPermission().isHrPermission();
	}

	private long getDevisionIdFromDepartment(long departmentId) {
		try {
			return DepartmentLocalServiceUtil.fetchDepartment(departmentId)
					.getDevisionId();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private long getDepartmentIdFromUnit(long unitId) {
		try {
			return UnitLocalServiceUtil.fetchUnit(unitId).getDepartmentId();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<String> getSearchableDevisions() {
		return searchableDevisions;
	}

	public List<String> getSearchableDepartments() {
		return searchableDepartments;
	}

	public List<String> getSearchableUnits() {
		return searchableUnits;
	}

	public Set<Long> getSearchableDevisionIds() {
		return searchableDevisionIds;
	}

	public Set<Long> getSearchableDepartmentIds() {
		return searchableDepartmentIds;
	}

	public Set<Long> getSearchableUnitIds() {
		return searchableUnitIds;
	}

	public void setSearchableUnitIds(Set<Long> searchableUnitIds) {
		this.searchableUnitIds = searchableUnitIds;
	}

	public void setSearchableUnits(List<String> searchableUnits) {
		this.searchableUnits = searchableUnits;
	}

	public boolean isDepartmentManager() {
		return isDepartmentManager;
	}

	public void setDepartmentManager(boolean isDepartmentManager) {
		this.isDepartmentManager = isDepartmentManager;
	}

	public boolean isUnitManager() {
		return isUnitManager;
	}

	public void setUnitManager(boolean isUnitManager) {
		this.isUnitManager = isUnitManager;
	}

	private List<String> allDevisions() {
		List<String> result = new ArrayList<>();
		for (Devision dev : DevisionLocalServiceUtil.findAll()) {
			result.add(dev.getName());
		}
		return result;
	}

}
