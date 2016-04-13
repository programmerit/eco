package vn.com.ecopharma.emp.bean.global;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpOrgRelationship;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpOrgRelationshipLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author TaoTran
 *
 */
@ManagedBean
@SessionScoped
public class AuthorityBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(AuthorityBean.class);

	private static final String ADMINISTRATOR_ROLE = "Administrator";

	private Set<Long> searchableDevisionIds;
	private Set<Long> searchableDepartmentIds;
	private Set<Long> searchableUnitIds;

	private boolean isDepartmentManager;

	private boolean isUnitManager;

	@PostConstruct
	public void init() {
		LOGGER.info("Calling authority session bean");
		searchableDevisionIds = new HashSet<>();
		searchableDepartmentIds = new HashSet<>();
		searchableUnitIds = new HashSet<>();
		final long userId = LiferayFacesContext.getInstance().getUserId();
		final Set<Long> devisionSet = new HashSet<>();
		final Set<Long> departmentSet = new HashSet<>();
		final Set<Long> unitSet = new HashSet<>();

		final Emp empByUser = EmpLocalServiceUtil.findByUser(userId);
		if (empByUser != null) {
			final List<EmpOrgRelationship> empOrgRelationships = EmpOrgRelationshipLocalServiceUtil
					.findByEmp(empByUser.getEmpId());
			for (EmpOrgRelationship empOrgRelationship : empOrgRelationships) {
				if (isDepartmentManagerAuthorized(empOrgRelationship)) {
					final long departmentId = empOrgRelationship
							.getOrgClassPK();
					final long devisionId = getDevisionIdFromDepartment(departmentId);

					departmentSet.add(empOrgRelationship.getOrgClassPK());
					devisionSet.add(devisionId);
					isDepartmentManager = true;
				} else if (isUnitManagerAuthorized(empOrgRelationship)) {
					final long unitId = empOrgRelationship.getOrgClassPK();
					final long departmentId = getDepartmentIdFromUnit(unitId);
					final long devisionId = getDevisionIdFromDepartment(departmentId);

					unitSet.add(unitId);
					departmentSet.add(departmentId);
					devisionSet.add(devisionId);
					isUnitManager = true;
				}
			}
		}

		LOGGER.info("Devisions: " + devisionSet);

		LOGGER.info("Departments: " + departmentSet);

		LOGGER.info("Units: " + unitSet);

		searchableDevisionIds.addAll(devisionSet);
		searchableDepartmentIds.addAll(departmentSet);
		searchableUnitIds.addAll(unitSet);

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

	private long getDevisionIdFromDepartment(long departmentId) {
		try {
			return DepartmentLocalServiceUtil.fetchDepartment(departmentId)
					.getDevisionId();
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return 0;
	}

	private long getDepartmentIdFromUnit(long unitId) {
		try {
			return UnitLocalServiceUtil.fetchUnit(unitId).getDepartmentId();
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return 0;
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

	public boolean isHr() {
		return BeanUtils.getEmpModelPermission().isHrPermission();
	}

	public boolean isDepartmentManager() {
		return isDepartmentManager;
	}

	public boolean isUnitManager() {
		return isUnitManager;
	}

	public boolean isAdmin() {
		return EmployeeUtils.getPermissionChecker().isOmniadmin();
	}
}
