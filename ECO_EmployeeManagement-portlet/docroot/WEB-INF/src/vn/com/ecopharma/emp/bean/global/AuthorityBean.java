package vn.com.ecopharma.emp.bean.global;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpOrgRelationship;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpOrgRelationshipLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;

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

	private List<Long> searchableDevisionIds;
	private List<Long> searchableDepartmentIds;
	private List<Long> searchableUnitIds;

	@PostConstruct
	public void init() {
		long userId = LiferayFacesContext.getInstance().getUserId();

		if (BeanUtils.getEmpModelPermission().isHrPermission()) {
			searchableDevisions = allDevisions();
		}

		Emp empByUser = EmpLocalServiceUtil.findByUser(userId);
		if (empByUser != null) {
			List<EmpOrgRelationship> empOrgRelationships = EmpOrgRelationshipLocalServiceUtil
					.findByEmp(empByUser.getEmpId());
			for (EmpOrgRelationship empOrgRelationship : empOrgRelationships) {
				if (isDepartmentManagerAuthorized(empOrgRelationship))
					searchableDepartmentIds.add(empOrgRelationship
							.getOrgClassPK());
				else if (isUnitManagerAuthorized(empOrgRelationship))
					searchableUnitIds.add(empOrgRelationship.getOrgClassPK());
			}
		}
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

	public List<String> getSearchableDevisions() {
		return searchableDevisions;
	}

	public List<String> getSearchableDepartments() {
		return searchableDepartments;
	}

	public List<String> getSearchableUnits() {
		return searchableUnits;
	}

	public List<Long> getSearchableDevisionIds() {
		return searchableDevisionIds;
	}

	public List<Long> getSearchableDepartmentIds() {
		return searchableDepartmentIds;
	}

	public List<Long> getSearchableUnitIds() {
		return searchableUnitIds;
	}

	private List<String> allDevisions() {
		List<String> result = new ArrayList<>();
		for (Devision dev : DevisionLocalServiceUtil.findAll()) {
			result.add(dev.getName());
		}
		return result;
	}

}
