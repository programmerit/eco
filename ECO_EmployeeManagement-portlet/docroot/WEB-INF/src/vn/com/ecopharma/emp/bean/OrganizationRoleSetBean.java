package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.EmpOrgRelationship;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpOrgRelationshipLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

@ManagedBean
@ViewScoped
public class OrganizationRoleSetBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String NOT_AT_ALL = "N/A";

	public enum Level {
		DEPT_MANAGER, DEPT_DEPUTY, UNIT_MANAGER, UNIT_DEPUTY;
	}

	private BaseModel<?> organization;

	private EmpIndexedItem currentSelectedEmpRole;

	private Level level;

	private boolean allEmpSearchable = false;

	@PostConstruct
	public void init() {

	}

	public String getTitles() {
		switch (level) {
		case DEPT_MANAGER:
			return "Set Manager Department";
		case DEPT_DEPUTY:
			return "Set Deputy of Department";
		case UNIT_MANAGER:
			return "Set Manager of Unit";
		case UNIT_DEPUTY:
			return "Set Deputy of Unit";
		default:
			return StringUtils.EMPTY;
		}
	}

	public void onSaveSetManager() {
		if (currentSelectedEmpRole == null)
			return;

		final ServiceContext serviceContext = EmployeeUtils.getServiceContext();
		FacesMessage message = null;

		EmpOrgRelationship currentEmpRoleSet = getCurrentEmpRoleSet();
		if (currentEmpRoleSet != null) {
			// ignore in case of setting the same employee as previous one
			if (currentEmpRoleSet.getEmpId() == currentSelectedEmpRole.getId())
				return;

			EmpOrgRelationshipLocalServiceUtil.updateEmpOrgRelationship(
					currentEmpRoleSet.getEmpOrgRelationshipId(),
					currentSelectedEmpRole.getEmpId(), serviceContext);

		} else {
			boolean isHeadOfOrganization = !(level == Level.DEPT_DEPUTY || level == Level.UNIT_DEPUTY);
			boolean isDeputyOfOrganization = !isHeadOfOrganization;

			EmpOrgRelationshipLocalServiceUtil.addEmpOrgRelationship(
					currentSelectedEmpRole.getEmpId(), getClassName(),
					getOrganizationId(), isHeadOfOrganization,
					isDeputyOfOrganization, serviceContext);
		}
		message = new FacesMessage("Information",
				"Successfully set manager for " + getClassName());

		FacesContext.getCurrentInstance().addMessage(null, message);
		// reset selected value
		currentSelectedEmpRole = null;
	}

	public List<EmpIndexedItem> onCompleteEmps(String query) {
		Map<String, Object> additionFilterMap = new HashMap<>();
		if (!isAllEmpSearchable()) {
			String filterByOrganizationField = isDepartment() ? EmpField.DEPARTMENT
					: EmpField.UNIT;

			String name = isDepartment() ? ((Department) organization)
					.getName() : ((Unit) organization).getName();

			additionFilterMap.put(filterByOrganizationField,
					Arrays.asList(EmpLocalServiceUtil.removeDashChar(name)));
		}
		return EmployeeUtils.searchEmpByName(query, additionFilterMap);
	}

	public String getFormattedEmpString(EmpIndexedItem empIndexedItem) {
		return empIndexedItem != null ? empIndexedItem.getFullNameVi() + " ("
				+ empIndexedItem.getEmployeeCode() + ") " : "";
	}

	public String getCurrentResponsibleEmpFormattedString() {
		return getCurrentResponsibleEmp() != null ? getFormattedEmpString(getCurrentResponsibleEmp())
				: NOT_AT_ALL;
	}

	public EmpIndexedItem getCurrentResponsibleEmp() {
		EmpOrgRelationship currentManagerRelationship = getCurrentEmpRoleSet();
		if (currentManagerRelationship == null)
			return null;
		return currentManagerRelationship.getEmpId() != 0 ? new EmpIndexedItem(
				EmpLocalServiceUtil.getIndexedEmp(
						currentManagerRelationship.getEmpId(),
						EmployeeUtils.getCurrentSearchContext())) : null;
	}

	private EmpOrgRelationship getCurrentEmpRoleSet() {
		if (organization == null)
			return null;

		switch (level) {
		case DEPT_MANAGER:
			return EmpOrgRelationshipLocalServiceUtil
					.fetchByClassNameClassPKHeadOfOrg(
							Department.class.getName(), getOrganizationId(),
							Boolean.TRUE);
		case DEPT_DEPUTY:
			return EmpOrgRelationshipLocalServiceUtil
					.fetchByClassNameClassPKDeputyOfOrg(
							Department.class.getName(), getOrganizationId(),
							Boolean.TRUE);
		case UNIT_MANAGER:
			return EmpOrgRelationshipLocalServiceUtil
					.fetchByClassNameClassPKHeadOfOrg(Unit.class.getName(),
							getOrganizationId(), Boolean.TRUE);
		case UNIT_DEPUTY:
			return EmpOrgRelationshipLocalServiceUtil
					.fetchByClassNameClassPKDeputyOfOrg(Unit.class.getName(),
							getOrganizationId(), Boolean.TRUE);
		default:
			return null;
		}
	}

	public String getShortenEmpName(String fullName) {
		return EmployeeUtils.getShortenDisplayFullName(fullName);
	}

	public EmpIndexedItem getCurrentSelectedEmpRole() {
		return currentSelectedEmpRole;
	}

	public void setCurrentSelectedEmpRole(EmpIndexedItem currentSelectedEmpRole) {
		this.currentSelectedEmpRole = currentSelectedEmpRole;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	private long getOrganizationId() {
		return organization != null ? Long.valueOf(organization
				.getPrimaryKeyObj().toString()) : 0L;
	}

	private boolean isDepartment() {
		return organization != null && organization instanceof Department;
	}

	private String getClassName() {
		return isDepartment() ? Department.class.getName() : Unit.class
				.getName();
	}

	public BaseModel<?> getOrganization() {
		return organization;
	}

	public void setOrganization(BaseModel<?> organization) {
		this.organization = organization;
	}

	public boolean isAllEmpSearchable() {
		return allEmpSearchable;
	}

	public void setAllEmpSearchable(boolean allEmpSearchable) {
		this.allEmpSearchable = allEmpSearchable;
	}

}
