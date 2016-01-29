package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.dto.AddressObjectItem;
import vn.com.ecopharma.emp.dto.BankInfoObject;
import vn.com.ecopharma.emp.dto.DependentName;
import vn.com.ecopharma.emp.dto.EmpInfoItem;
import vn.com.ecopharma.emp.enumeration.EducationType;
import vn.com.ecopharma.emp.enumeration.EmployeeStatus;
import vn.com.ecopharma.emp.enumeration.LaborContractType;
import vn.com.ecopharma.emp.enumeration.LocationType;
import vn.com.ecopharma.emp.enumeration.ResignationType;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpBankInfo;
import vn.com.ecopharma.emp.model.Level;
import vn.com.ecopharma.emp.model.Location;
import vn.com.ecopharma.emp.model.ResignationHistory;
import vn.com.ecopharma.emp.model.Specialized;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.model.University;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.DistrictLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.LevelLocalServiceUtil;
import vn.com.ecopharma.emp.service.LocationLocalServiceUtil;
import vn.com.ecopharma.emp.service.ResignationHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.service.SpecializedLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;

@ManagedBean
@ViewScoped
public class EmployeeInfoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil.getLog(EmployeeBean.class);

	private static final String DEFAULT_PW = "123";

	private static final String MALE = "male";

	private EmpInfoItem modifyEmployeeInfoItem;

	private List<Country> countries;

	private Location location;

	private boolean showUserTab = false;

	private boolean autoPassword = true;

	@PostConstruct
	public void init() {
		try {
			countries = CountryServiceUtil.getCountries(true);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}

	public void addOneAddress() {
		modifyEmployeeInfoItem.getAddresses().add(new AddressObjectItem());
	}

	public void removeOneAddress(int index) {
		modifyEmployeeInfoItem.getAddresses().get(index).setUIDeleted(true);
	}

	public void addOneBankInfo() {
		if (modifyEmployeeInfoItem.getBankInfos().size() < 3)
			modifyEmployeeInfoItem.getBankInfos().add(new BankInfoObject());
	}

	public void removeOneBankInfo(int index) {
		modifyEmployeeInfoItem.getBankInfos().get(index).setUIDeleted(true);
	}

	public void save() {

		LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();
		final ServiceContext serviceContext = liferayFacesContext
				.getServiceContext();
		FacesMessage msg = null;
		try {
			final Map<Address, Boolean> addressMap = EmployeeUtils
					.transferAddressObjectListToAddressMap(modifyEmployeeInfoItem
							.getAddresses());
			final Map<String, Boolean> dependentMap = EmployeeUtils
					.transferDependentNameObjectListToDependentNameMap(modifyEmployeeInfoItem
							.getDependentNames());

			final Map<EmpBankInfo, Boolean> bankInfoMap = EmployeeUtils
					.transferBankInfoObjectListToBankInfoMap(modifyEmployeeInfoItem
							.getBankInfos());

			modifyEmployeeInfoItem.getUser().setFirstName(
					EmployeeUtils.getFirstName(modifyEmployeeInfoItem
							.getFullName()));
			modifyEmployeeInfoItem.getUser().setMiddleName(
					EmployeeUtils.getMiddleName(modifyEmployeeInfoItem
							.getFullName()));
			modifyEmployeeInfoItem.getUser().setLastName(
					EmployeeUtils.getLastName(modifyEmployeeInfoItem
							.getFullName()));
			long specializedId = modifyEmployeeInfoItem.getSpecialized() != null ? modifyEmployeeInfoItem
					.getSpecialized().getSpecializedId() : 0L;
			modifyEmployeeInfoItem.getEmp().setSpecializeId(specializedId);

			long workingPlaceId = modifyEmployeeInfoItem.getWorkingPlace() != null ? modifyEmployeeInfoItem
					.getWorkingPlace().getRegionId() : 0L;
			modifyEmployeeInfoItem.getEmp().setWorkingPlaceId(workingPlaceId);

			if (showUserTab) {
				final Emp employee = modifyEmployeeInfoItem.getEmp();

				User empUser = modifyEmployeeInfoItem.getUser();

				EmployeeUtils.setAttributesToEmpFromEditItem(employee,
						modifyEmployeeInfoItem);

				final Calendar cal = Calendar.getInstance();
				cal.setTime(employee.getBirthday());
				int day = cal.get(Calendar.DAY_OF_MONTH);
				int month = cal.get(Calendar.MONTH);
				int year = cal.get(Calendar.YEAR);

				// group id: User Personal Site
				long[] groups = new long[] { GroupLocalServiceUtil.getGroup(
						serviceContext.getCompanyId(), "User Personal Site")
						.getGroupId() };
				// role id: User
				long[] roles = new long[] { RoleLocalServiceUtil.getRole(
						serviceContext.getCompanyId(), "User").getRoleId() };

				final long facebookId = 0L;
				final int prefixId = 0;
				final int suffixId = 0;

				final long[] organizationIds = null;
				final long[] userGroupIds = null;

				final boolean sendEmail = false;

				Emp result = EmpLocalServiceUtil.addEmp(
						employee,
						false,
						!autoPassword ? modifyEmployeeInfoItem
								.getUserPassword1() : DEFAULT_PW,
						!autoPassword ? modifyEmployeeInfoItem
								.getUserPassword2() : DEFAULT_PW, false,
						modifyEmployeeInfoItem.getUserName(), empUser
								.getEmailAddress(), facebookId,
						StringUtils.EMPTY, LocaleUtil.getDefault(), empUser
								.getFirstName(), empUser.getMiddleName(),
						empUser.getLastName(), prefixId, suffixId, employee
								.getGender().equalsIgnoreCase(MALE) ? true
								: false, month, day, year, groups,
						organizationIds, roles, userGroupIds, sendEmail,
						addressMap, dependentMap, bankInfoMap, serviceContext);

				if (result != null) {
					msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Create employee successfully", "Employee "
									+ modifyEmployeeInfoItem.getUser()
											.getFullName()
									+ " has been created");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				} else {
					msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Error", "Error on create new employee");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}

			} else {
				Emp employee = modifyEmployeeInfoItem.getEmp();
				long oldTitlesId = employee.getTitlesId();
				EmployeeUtils.setAttributesToEmpFromEditItem(employee,
						modifyEmployeeInfoItem);
				EmpLocalServiceUtil.update(employee,
						modifyEmployeeInfoItem.getUser(), oldTitlesId,
						addressMap, dependentMap, bankInfoMap, Boolean.FALSE,
						serviceContext);

				msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Update employee successfully", "Employee "
								+ modifyEmployeeInfoItem.getUser()
										.getFullName() + " has been updated");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		} catch (Exception e) {
			LOGGER.info(e);
		}
	}

	public void onDevisionChanged() {
		modifyEmployeeInfoItem.setDepartment(null);
		modifyEmployeeInfoItem.setUnit(null);
		modifyEmployeeInfoItem.setUnitGroup(null);
		modifyEmployeeInfoItem.setTitles(null);
	}

	public void onDepartmentChanged() {
		modifyEmployeeInfoItem.setUnit(null);
		modifyEmployeeInfoItem.setUnitGroup(null);
		modifyEmployeeInfoItem.setTitles(null);
	}

	public void onUnitChanged() {
		modifyEmployeeInfoItem.setUnitGroup(null);
		modifyEmployeeInfoItem.setTitles(null);
	}

	public void onUnitGroupChanged() {
		modifyEmployeeInfoItem.setTitles(null);
	}

	public void onPromotionNewPosition() {
		// long id = ((EmployeeIndexedBean) BeanUtils
		// .getBackingBeanByName("employeeIndexedBean"))
		// .getSelectedEmployeeIndexItem().getEmployeeId();
		// PromotionBean promotionBean = (PromotionBean) BeanUtils
		// .getBackingBeanByName("promotionBean");
		// promotionBean.setEmployeeId(id);
	}

	public void onResignedEmployee() {
		// long id = ((EmployeeIndexedBean) BeanUtils
		// .getBackingBeanByName("employeeIndexedBean"))
		// .getSelectedEmployeeIndexItem().getEmployeeId();
		// ResignationBean resignationBean = (ResignationBean) BeanUtils
		// .getBackingBeanByName("resignationBean");
		// ResignationHistory resignationHistory =
		// ResignationHistoryLocalServiceUtil
		// .createPrePersisted();
		// resignationHistory.setResignedType(ResignationType.NONE.toString());
		// resignationBean.setEmployeeId(id);
		// resignationBean.setResignationHistory(resignationHistory);
	}

	public List<String> getAvailableStatuses(String status) {
		return EmployeeStatus.getAvailableStatus_(status);
	}

	public void onCountryChange(int index) {
		try {
			modifyEmployeeInfoItem
					.getAddresses()
					.get(index)
					.setRegions(
							RegionServiceUtil.getRegions(modifyEmployeeInfoItem
									.getAddresses().get(index).getCountry()
									.getCountryId()));
		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}

	public void onRegionChange(int index) {
		modifyEmployeeInfoItem
				.getAddresses()
				.get(index)
				.setDistricts(
						DistrictLocalServiceUtil
								.findByRegionCode(modifyEmployeeInfoItem
										.getAddresses().get(index).getRegion()
										.getRegionCode()));
	}

	/**
	 * @param event
	 */
	public void onGenerateUserName() {
		String username = generateUsername();
		modifyEmployeeInfoItem.setUserName(username);
	}

	public void onGenerateEmail() {
		String username = generateUsername();
		String emailAddress = EmployeeUtils.generateEmailByUsername(username);
		modifyEmployeeInfoItem.getUser().setEmailAddress(emailAddress);
	}

	public void onLastNameBlur() {
		if (showUserTab) {
			String username = generateUsername();
			String emailAddress = EmployeeUtils
					.generateEmailByUsername(username);
			modifyEmployeeInfoItem.setUserName(username);
			modifyEmployeeInfoItem.getUser().setEmailAddress(emailAddress);
		}
	}

	public void onFullNameBlur() {
		if (showUserTab) {
			String username = generateUsername();
			String emailAddress = EmployeeUtils
					.generateEmailByUsername(username);
			modifyEmployeeInfoItem.setUserName(username);
			modifyEmployeeInfoItem.getUser().setEmailAddress(emailAddress);
		}

	}

	private String generateUsername() {
		final String defaultUsername = "user" + System.currentTimeMillis();

		final String generatedUsername = EmployeeUtils
				.generateUsername(modifyEmployeeInfoItem.getFullName());
		return StringUtils.trimToNull(generatedUsername) != null ? generatedUsername
				: defaultUsername;

	}

	public List<Titles> getTitlesList() {
		if (modifyEmployeeInfoItem.getDepartment() != null) {
			return TitlesLocalServiceUtil
					.findAllByDepartment(modifyEmployeeInfoItem.getDepartment()
							.getDepartmentId());
		}
		return new ArrayList<>();
	}

	public List<UnitGroup> getUnitGroups() {
		return modifyEmployeeInfoItem.getUnit() != null ? UnitGroupLocalServiceUtil
				.findByUnit(modifyEmployeeInfoItem.getUnit().getUnitId())
				: null;
	}

	public List<Unit> getUnits() {
		final Department empDepartment = modifyEmployeeInfoItem.getDepartment();
		return empDepartment != null ? UnitLocalServiceUtil
				.findByDepartment(empDepartment.getDepartmentId())
				: new ArrayList<Unit>();
	}

	public List<Department> getDepartments() {
		List<Department> departments = modifyEmployeeInfoItem.getDevision() != null ? DepartmentLocalServiceUtil
				.findByDevision(modifyEmployeeInfoItem.getDevision()
						.getDevisionId()) : new ArrayList<Department>();
		if (departments.isEmpty()
				|| !departments
						.contains(modifyEmployeeInfoItem.getDepartment())) {
			modifyEmployeeInfoItem.setDepartment(null);
		}
		return departments;
	}

	public List<Devision> getDevisions() {
		return DevisionLocalServiceUtil.findAll();
	}

	public List<String> getLaborContractTypes() {
		final List<String> results = new ArrayList<>();
		for (LaborContractType laborContractType : LaborContractType.values()) {
			results.add(laborContractType.toString());
		}
		return results;
	}

	public List<String> getEducationTypes() {
		return EducationType.getAllVi();
	}

	public Date getMaxBirthdayDate() {
		Calendar now = Calendar.getInstance();
		// backward 18 years
		now.add(Calendar.YEAR, -18);
		return now.getTime();
	}

	// Dependent Names action part
	public void onAddDependence() {
		modifyEmployeeInfoItem.getDependentNames().add(
				new DependentName(StringUtils.EMPTY, false));
	}

	public void onRemoveDependence(int index) {
		modifyEmployeeInfoItem.getDependentNames().get(index)
				.setUIDeleted(true);
	}

	public List<Level> getLevels() {
		return LevelLocalServiceUtil.findAll();
	}

	public List<University> getUniversities() {
		return UniversityLocalServiceUtil.findAll();
	}

	public List<Location> getLocations() {
		return LocationLocalServiceUtil
				.findByType(LocationType.WORKING_LOCATION.toString());
	}

	public List<Specialized> getSpecializeds() {
		return SpecializedLocalServiceUtil.findAll();
	}

	public List<Region> getWorkingPlaces() {
		try {
			return RegionServiceUtil.getRegions(17L);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public EmpInfoItem getModifyEmployeeInfoItem() {
		return modifyEmployeeInfoItem;
	}

	public void setModifyEmployeeInfoItem(EmpInfoItem modifyEmployeeInfoItem) {
		this.modifyEmployeeInfoItem = modifyEmployeeInfoItem;
	}

	public boolean isShowUserTab() {
		return showUserTab;
	}

	public void setShowUserTab(boolean showUserTab) {
		this.showUserTab = showUserTab;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public boolean isAutoPassword() {
		return autoPassword;
	}

	public void setAutoPassword(boolean autoPassword) {
		this.autoPassword = autoPassword;
	}

	public String getStatusLocalized(String status) {
		return EmployeeStatus.valueOf(status).getLocalizedString();
	}

	public boolean isResigned(long employeeId) {
		return ResignationHistoryLocalServiceUtil.getIndexedDocument(
				employeeId, EmployeeUtils.getCurrentSearchContext()) != null;
	}
}
