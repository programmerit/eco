package vn.com.ecopharma.hrm.rc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vn.com.ecopharma.emp.model.Certificate;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.Level;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.model.University;
import vn.com.ecopharma.emp.service.CertificateLocalServiceUtil;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.enumeration.CertificateType;
import vn.com.ecopharma.hrm.rc.enumeration.LaborContractType;
import vn.com.ecopharma.hrm.rc.util.EmployeeUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * @author TaoTran
 *
 */
public class EmpInfoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String MALE = "Male";
	private Emp employee;
	private User user;
	private University university;
	private Titles titles;
	private Level level;
	private Devision devision;
	private Department department;
	private Unit unit;
	private UnitGroup unitGroup;

	private List<Certificate> majorCertificates;

	private List<Certificate> vocationalCertificates;

	/* Fields for creating employee's user */
	private String userName;
	private String userPassword1;
	private String userPassword2;

	private List<AddressObjectItem> addresses;

	private List<DependentName> dependentNames;

	private List<BankInfoObject> bankInfos;

	public EmpInfoItem(Emp employee) {

		this.employee = employee;
		LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();
		final ServiceContext serviceContext = liferayFacesContext
				.getServiceContext();

		dependentNames = EmployeeUtils.getDependentNamesFromString(employee
				.getDependentNames());
		addresses = EmployeeUtils.getAddressObjectItemsFromClassNameAndPK(
				Emp.class.getName(), employee.getEmpId(),
				serviceContext.getCompanyId());

		dependentNames = EmployeeUtils.getDependentNamesFromString(employee
				.getDependentNames());

		majorCertificates = CertificateLocalServiceUtil
				.findByClassNameClassPKAndType(Emp.class.getName(),
						employee.getEmpId(), CertificateType.MAJOR.toString());
		vocationalCertificates = CertificateLocalServiceUtil
				.findByClassNameClassPKAndType(Emp.class.getName(),
						employee.getEmpId(),
						CertificateType.VOCATIONAL.toString());
		bankInfos = EmployeeUtils
				.getBankInfoObjectsFromEmp(employee.getEmpId());

		try {
			user = UserLocalServiceUtil.fetchUser(employee.getEmpUserId());
			titles = TitlesLocalServiceUtil.getTitles(employee.getTitlesId());
			unitGroup = titles != null && titles.getUnitGroupId() != 0 ? UnitGroupLocalServiceUtil
					.getUnitGroup(titles.getUnitGroupId()) : null;
			unit = titles != null && titles.getUnitId() != 0 ? UnitLocalServiceUtil
					.getUnit(titles.getUnitId()) : null;
			department = devision != null ? DepartmentLocalServiceUtil
					.getDepartment(unit.getDepartmentId())
					: (titles != null ? DepartmentLocalServiceUtil
							.getDepartment(titles.getDepartmentId()) : null);
			devision = department != null ? DevisionLocalServiceUtil
					.getDevision(department.getDevisionId()) : null;

		} catch (PortalException e) {
			LogFactoryUtil.getLog(EmpInfoItem.class).info(e);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmpInfoItem.class).info(e);
		}

	}

	public EmpInfoItem(long employeeId) {
		this(EmployeeUtils.getEmpById(employeeId));
	}

	public EmpInfoItem(String employeeIdString) {
		this(Long.valueOf(employeeIdString));
	}

	public EmpInfoItem() {
		this.user = createNewUser();
		this.employee = createNewEmp();
	}

	private Emp createNewEmp() {
		try {
			this.employee = EmpLocalServiceUtil
					.createEmp(CounterLocalServiceUtil.increment());
			// set default "Male" for employee
			employee.setGender(MALE);
			employee.setLaborContractType(LaborContractType.INDEFINITE_TERMS
					.toString());
			this.addresses = new ArrayList<>();
			this.dependentNames = new ArrayList<>();
			this.majorCertificates = new ArrayList<>();
			this.vocationalCertificates = new ArrayList<>();
			this.bankInfos = new ArrayList<>(
					Arrays.asList(new BankInfoObject()));

		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmpInfoItem.class).info(e);
		}
		return employee;
	}

	private User createNewUser() {
		try {
			return UserLocalServiceUtil.createUser(CounterLocalServiceUtil
					.increment());
		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmpInfoItem.class).info(e);
		}
		return null;
	}

	public Emp getEmp() {
		return employee;
	}

	public User getUser() {
		return user;
	}

	public University getUniversity() {
		try {
			if (university == null) {
				return employee.getUniversityId() != 0 ? UniversityLocalServiceUtil
						.getUniversity(employee.getUniversityId()) : null;
			}
			return university;
		} catch (PortalException e) {
			LogFactoryUtil.getLog(EmpInfoItem.class).info(e);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmpInfoItem.class).info(e);
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

	public boolean isEmptyOrAllDeletedDependentNames() {
		if (dependentNames.isEmpty())
			return true;
		for (DependentName name : dependentNames) {
			// return false if there is any none UIDeleted item
			if (!name.isUIDeleted()) {
				return false;
			}
		}
		return false;
	}

	public void setEmp(Emp employee) {
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

	public List<DependentName> getDependentNames() {
		return dependentNames;
	}

	public void setDependentNames(List<DependentName> dependentNames) {
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

	public List<Certificate> getMajorCertificates() {
		return majorCertificates;
	}

	public void setMajorCertificates(List<Certificate> majorCertificates) {
		this.majorCertificates = majorCertificates;
	}

	public List<Certificate> getVocationalCertificates() {
		return vocationalCertificates;
	}

	public void setVocationalCertificates(
			List<Certificate> vocationalCertificates) {
		this.vocationalCertificates = vocationalCertificates;
	}

	public Certificate getTopMajorCertificate() {
		if (getMajorCertificates().isEmpty()) {
			return null;
		}
		return majorCertificates.get(0);
	}

	public List<BankInfoObject> getBankInfos() {
		return bankInfos;
	}

	public void setBankInfos(List<BankInfoObject> bankInfos) {
		this.bankInfos = bankInfos;
	}

	public String getLocalizedLaborContractType(String laborContractType) {
		return LaborContractType.valueOf(laborContractType)
				.getLocalizedString();
	}
}
