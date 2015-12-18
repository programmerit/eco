package vn.com.ecopharma.emp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import vn.com.ecopharma.emp.enumeration.EmployeeStatus;
import vn.com.ecopharma.emp.enumeration.LaborContractType;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Employee;
import vn.com.ecopharma.emp.model.Level;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.model.University;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmployeeLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * @author TaoTran
 *
 */
public class EmployeeInfoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String MALE = "Male";
	private Employee employee;
	private User user;
	private University university;
	private Titles titles;
	private Level level;
	private Devision devision;
	public Department department;
	public Unit unit;
	public UnitGroup unitGroup;

	/* Fields for creating employee's user */
	private String userName;
	private String userPassword1;
	private String userPassword2;

	private List<AddressObjectItem> addresses;

	private List<String> dependentNames;

	public EmployeeInfoItem(Employee employee) {
		this.employee = employee;
		LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();
		final ServiceContext serviceContext = liferayFacesContext
				.getServiceContext();

		this.dependentNames = new ArrayList<String>();
		addresses = EmployeeUtils.getAddressObjectItemsFromClassNameAndPK(
				Employee.class.getName(), employee.getEmployeeId(),
				serviceContext.getCompanyId());

		try {
			titles = TitlesLocalServiceUtil.getTitles(employee.getTitlesId());
			unitGroup = titles != null && titles.getUnitGroupId() != 0 ? UnitGroupLocalServiceUtil
					.getUnitGroup(titles.getUnitGroupId()) : null;
			unit = titles != null ? UnitLocalServiceUtil.getUnit(titles
					.getUnitId()) : null;
			department = devision != null ? DepartmentLocalServiceUtil
					.getDepartment(unit.getDepartmentId())
					: (titles != null ? DepartmentLocalServiceUtil
							.getDepartment(titles.getDepartmentId()) : null);
			devision = department != null ? DevisionLocalServiceUtil
					.getDevision(department.getDevisionId()) : null;
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}

	}

	public EmployeeInfoItem(long employeeId) {
		// this(EmployeeUtils.getEmployeeById(employeeId));
	}

	public EmployeeInfoItem(String employeeIdString) {
		this(Long.valueOf(employeeIdString));
	}

	public EmployeeInfoItem() {
		this.user = createNewUser();
		this.employee = createNewEmployee();
	}

	private Employee createNewEmployee() {
		try {
			this.employee = EmployeeLocalServiceUtil
					.createEmployee(CounterLocalServiceUtil.increment());
			// set default "Male" for employee
			employee.setGender(MALE);
			employee.setLaborContractType(LaborContractType.INDEFINITE_TERMS
					.toString());
			this.addresses = new ArrayList<AddressObjectItem>();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return employee;
	}

	private User createNewUser() {
		try {
			return UserLocalServiceUtil.createUser(CounterLocalServiceUtil
					.increment());
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee getEmployee() {
		return employee;
	}

	public User getUser() {
		try {
			if (user == null) {
				return user = employee.getEmployeeUserId() != 0 ? UserLocalServiceUtil
						.getUser(employee.getEmployeeUserId()) : null;
			}
			return user;
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return user;
	}

	public University getUniversity() {
		try {
			if (university == null) {
				return university = employee.getUniversityId() != 0 ? UniversityLocalServiceUtil
						.getUniversity(employee.getUniversityId()) : null;
			}
			return university;
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return university;
	}

	public Devision getDevision() {
		return devision;
	}

	public Titles getTitles() {
		return titles;
	}

	public Level getLevel() {
		return level;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setTitles(Titles titles) {
		this.titles = titles;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public long getTitlesId() {
		return titles != null ? titles.getTitlesId() : 0;
	}

	public long getLevelId() {
		return level != null ? level.getLevelId() : 0;
	}

	public long getUniversityId() {
		return university != null ? university.getUniversityId() : 0;
	}

	public List<AddressObjectItem> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressObjectItem> addresses) {
		this.addresses = addresses;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword1() {
		return userPassword1;
	}

	public void setUserPassword1(String userPassword1) {
		this.userPassword1 = userPassword1;
	}

	public String getUserPassword2() {
		return userPassword2;
	}

	public void setUserPassword2(String userPassword2) {
		this.userPassword2 = userPassword2;
	}

	public List<String> getDependentNames() {
		return dependentNames;
	}

	public void setDependentNames(List<String> dependentNames) {
		this.dependentNames = dependentNames;
	}

	public void setDevision(Devision devision) {
		this.devision = devision;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getLocalizedLaborContractType(String laborContractType) {
		return LaborContractType.valueOf(laborContractType)
				.getLocalizedString();
	}

	public String getStatusCss() {
		return EmployeeStatus.getCssClass(EmployeeStatus.valueOf(employee
				.getStatus()));
	}
}
