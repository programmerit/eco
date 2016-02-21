package vn.com.ecopharma.emp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.enumeration.CertificateType;
import vn.com.ecopharma.emp.enumeration.EmployeeStatus;
import vn.com.ecopharma.emp.enumeration.LaborContractType;
import vn.com.ecopharma.emp.model.Certificate;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.Level;
import vn.com.ecopharma.emp.model.Specialized;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.model.University;
import vn.com.ecopharma.emp.permission.EmpPermission;
import vn.com.ecopharma.emp.service.CertificateLocalServiceUtil;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpOrgRelationshipLocalServiceUtil;
import vn.com.ecopharma.emp.service.SpecializedLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * @author TaoTran
 *
 */
public class EmpInfoItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil.getLog(EmpInfoItem.class);

	private static final String MALE = "Male";
	private String fullName = StringUtils.EMPTY;
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

	private List<DocumentItem> documents;

	private Specialized specialized;

	private Region workingPlace;

	private String userImgURL;

	private boolean isManager;

	public EmpInfoItem(Emp employee) {

		this.employee = employee;
		long empId = employee.getEmpId();
		LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();
		final ServiceContext serviceContext = liferayFacesContext
				.getServiceContext();

		this.dependentNames = new ArrayList<>();
		addresses = EmployeeUtils.getAddressObjectItemsFromClassNameAndPK(
				Emp.class.getName(), empId, serviceContext.getCompanyId());

		dependentNames = EmployeeUtils.getDependentNamesFromString(employee
				.getDependentNames());

		majorCertificates = CertificateLocalServiceUtil
				.findByClassNameClassPKAndType(Emp.class.getName(), empId,
						CertificateType.MAJOR.toString());
		vocationalCertificates = CertificateLocalServiceUtil
				.findByClassNameClassPKAndType(Emp.class.getName(), empId,
						CertificateType.VOCATIONAL.toString());
		bankInfos = EmployeeUtils.getBankInfoObjectsFromEmp(empId);

		documents = EmployeeUtils.getDocumentItemsFromEmp(empId);

		try {
			user = UserLocalServiceUtil.fetchUser(employee.getEmpUserId());
			fullName = EmployeeUtils.getViFullnameFromUser(user);
			titles = TitlesLocalServiceUtil.getTitles(employee.getTitlesId());
			unitGroup = employee.getUnitGroupId() != 0 ? UnitGroupLocalServiceUtil
					.getUnitGroup(employee.getUnitGroupId()) : null;
			unit = employee.getUnitId() != 0 ? UnitLocalServiceUtil
					.getUnit(employee.getUnitId()) : null;
			department = employee.getDepartmentId() != 0 ? DepartmentLocalServiceUtil
					.getDepartment(employee.getDepartmentId()) : null;
			devision = department != null ? DevisionLocalServiceUtil
					.getDevision(department.getDevisionId()) : null;
			specialized = employee.getSpecializeId() != 0L ? SpecializedLocalServiceUtil
					.fetchSpecialized(employee.getSpecializeId()) : null;

			isManager = EmpOrgRelationshipLocalServiceUtil.isHeadOfDepartment(
					empId, department.getDepartmentId());

			workingPlace = employee.getWorkingPlaceId() != 0L ? RegionServiceUtil
					.getRegion(employee.getWorkingPlaceId()) : null;

		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
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

	public void setTestDataForEmp() {
		try {
			this.devision = DevisionLocalServiceUtil.fetchDevision(185315L);
			this.department = DepartmentLocalServiceUtil
					.fetchDepartment(185316);
			this.titles = TitlesLocalServiceUtil.fetchTitles(185322);

			this.employee.setJoinedDate(new Date());
			this.employee.setIdentityCardNo("024374362");
			this.user.setFirstName("Tao");
			this.user.setMiddleName("Van");
			this.user.setLastName("Tran");
		} catch (SystemException e) {
			e.printStackTrace();
		}

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
			this.documents = new ArrayList<DocumentItem>();

		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return employee;
	}

	private User createNewUser() {
		try {
			return UserLocalServiceUtil.createUser(CounterLocalServiceUtil
					.increment());
		} catch (SystemException e) {
			LOGGER.info(e);
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
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
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

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
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

	public Specialized getSpecialized() {
		return specialized;
	}

	public void setSpecialized(Specialized specialized) {
		this.specialized = specialized;
	}

	public Region getWorkingPlace() {
		return workingPlace;
	}

	public void setWorkingPlace(Region workingPlace) {
		this.workingPlace = workingPlace;
	}

	public String getLocalizedLaborContractType(String laborContractType) {
		return LaborContractType.valueOf(laborContractType)
				.getLocalizedString();
	}

	public String getStatusCss() {
		return EmployeeStatus.getCssClass(EmployeeStatus.valueOf(employee
				.getStatus()));
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserImgURL() {
		return userImgURL;
	}

	public void setUserImgURL(String userImgURL) {
		this.userImgURL = userImgURL;
	}

	public List<DocumentItem> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentItem> documents) {
		this.documents = documents;
	}

	public boolean isUpdatingAuthorized() {
		final EmpPermission permissionBean = BeanUtils.getEmpPermissionBean();
		return permissionBean.checkPermission(employee.getEmpId(), "UPDATE")
				|| (employee.getLaborContractType().equals(
						LaborContractType.PROBATION_CONTRACT.toString()) && permissionBean
						.checkPermission(employee.getEmpId(),
								"PROBATION_UPDATE"));
	}
}
