package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpBankInfo;
import vn.com.ecopharma.emp.model.Level;
import vn.com.ecopharma.emp.model.University;
import vn.com.ecopharma.emp.service.LevelLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.dto.AddressObjectItem;
import vn.com.ecopharma.hrm.rc.dto.BankInfoObject;
import vn.com.ecopharma.hrm.rc.dto.CandidateIndexItem;
import vn.com.ecopharma.hrm.rc.dto.CandidateItem;
import vn.com.ecopharma.hrm.rc.dto.DependentName;
import vn.com.ecopharma.hrm.rc.dto.EmpInfoItem;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateStatus;
import vn.com.ecopharma.hrm.rc.enumeration.LaborContractType;
import vn.com.ecopharma.hrm.rc.enumeration.VacancyCandidateType;
import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.model.VacancyCandidate;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.BeanUtils;
import vn.com.ecopharma.hrm.rc.util.CandidateUtils;
import vn.com.ecopharma.hrm.rc.util.EmployeeUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;

@ManagedBean
@ViewScoped
public class EmployeeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_PW = "123";

	private static final String MALE = "male";

	private EmpInfoItem modifyEmployeeInfoItem;

	private List<Country> countries;

	private Candidate candidate;

	private boolean autoPassword = true;

	public void transferCandidateInfo(CandidateItem candidateItem) {
		try {
			modifyEmployeeInfoItem = transferCandidateInfo(candidateItem
					.getCandidate());
		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmployeeBean.class).info(e);
		}
	}

	public EmpInfoItem transferCandidateInfo(
			CandidateIndexItem candidateIndexItem) {
		try {
			Candidate c = CandidateLocalServiceUtil
					.fetchCandidate(candidateIndexItem.getCandidateId());
			modifyEmployeeInfoItem = transferCandidateInfo(c);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmployeeBean.class).info(e);
		}
		return modifyEmployeeInfoItem;
	}

	private EmpInfoItem transferCandidateInfo(Candidate candidate)
			throws SystemException {
		final EmpInfoItem employeeInfoItem = new EmpInfoItem();
		final String fullName = candidate.getFullName();
		this.candidate = candidate;
		employeeInfoItem.getUser()
				.setFirstName(
						CandidateUtils.getFirstNameFromFullname(candidate
								.getFullName()));
		employeeInfoItem.getUser().setMiddleName(
				CandidateUtils.getMiddleNameFromFullname(candidate
						.getFullName()));
		employeeInfoItem.getUser()
				.setLastName(
						CandidateUtils.getLastNameFromFullname(candidate
								.getFullName()));
		employeeInfoItem.getUser().setEmailAddress(candidate.getEmailAddress());
		employeeInfoItem.getEmp().setIdentityCardNo(
				candidate.getIdentityCardNo());
		employeeInfoItem.getEmp()
				.setContactNumber(candidate.getContactNumber());
		employeeInfoItem.getEmp().setBirthday(candidate.getDateOfBirth());
		employeeInfoItem.getEmp().setJoinedDate(
				new Date(System.currentTimeMillis()));
		employeeInfoItem.setUserName(EmployeeUtils.generateUsername(fullName));

		final List<VacancyCandidate> vacancyCandidates = VacancyCandidateLocalServiceUtil
				.findByCandidateAndType(candidate.getCandidateId(),
						VacancyCandidateType.MAIN.toString());
		VacancyCandidate vacancyCandidate = vacancyCandidates != null
				&& !vacancyCandidates.isEmpty() ? vacancyCandidates.get(0)
				: null;

		Vacancy vacancy = vacancyCandidate != null ? VacancyLocalServiceUtil
				.fetchVacancy(vacancyCandidate.getVacancyId()) : null;

		employeeInfoItem.setTitles(vacancy != null ? TitlesLocalServiceUtil
				.fetchTitles(vacancy.getTitlesId()) : null);
		getCountriesList();
		return employeeInfoItem;
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

	/**
	 * @param event
	 */
	public void save() {
		LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();
		final ServiceContext serviceContext = liferayFacesContext
				.getServiceContext();
		FacesMessage msg = null;
		try {
			final Emp employee = modifyEmployeeInfoItem.getEmp();

			User empUser = modifyEmployeeInfoItem.getUser();

			final Map<Address, Boolean> addressMap = EmployeeUtils
					.transferAddressObjectListToAddressMap(modifyEmployeeInfoItem
							.getAddresses());
			final Map<String, Boolean> dependentMap = EmployeeUtils
					.transferDependentNameObjectListToDependentNameMap(modifyEmployeeInfoItem
							.getDependentNames());

			final Map<EmpBankInfo, Boolean> bankInfoMap = EmployeeUtils
					.transferBankInfoObjectListToBankInfoMap(modifyEmployeeInfoItem
							.getBankInfos());

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

			// Emp result = EmpLocalServiceUtil.addEmp(employee, false,
			// !autoPassword ? modifyEmployeeInfoItem.getUserPassword1()
			// : DEFAULT_PW,
			// !autoPassword ? modifyEmployeeInfoItem.getUserPassword2()
			// : DEFAULT_PW, false, modifyEmployeeInfoItem
			// .getUserName(), empUser.getEmailAddress(),
			// facebookId, StringUtils.EMPTY, LocaleUtil.getDefault(),
			// empUser.getFirstName(), empUser.getMiddleName(), empUser
			// .getLastName(), prefixId, suffixId, employee
			// .getGender().equalsIgnoreCase(MALE) ? true : false,
			// month, day, year, groups, organizationIds, roles,
			// userGroupIds, sendEmail, addressMap, dependentMap,
			// bankInfoMap, serviceContext);

			// if (result != null) {
			candidate.setStatus(CandidateStatus.HIRE.toString());
			CandidateLocalServiceUtil.updateCandidate(candidate);

			msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Create employee successfully", "Employee "
							+ modifyEmployeeInfoItem.getUser().getFullName()
							+ " has been created");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute(
					"window.location.hash = '#vCandidate';");

			CandidateViewBean candidateViewBean = BeanUtils
					.getCandidateViewBean();
			candidateViewBean.switchMode(1);
			// }

		} catch (Exception e) {
			LogFactoryUtil.getLog(EmployeeBean.class).info(e);
		}
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
		String username = generateUsername();
		String emailAddress = EmployeeUtils.generateEmailByUsername(username);
		modifyEmployeeInfoItem.setUserName(username);
		modifyEmployeeInfoItem.getUser().setEmailAddress(emailAddress);
	}

	// Dependent Names action part
	public void onAddDependence() {
		modifyEmployeeInfoItem.getDependentNames().add(
				new DependentName("", false));
	}

	public void onRemoveDependence(int index) {
		modifyEmployeeInfoItem.getDependentNames().get(index)
				.setUIDeleted(true);
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
			LogFactoryUtil.getLog(EmployeeBean.class).info(e);
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

	public void cancelModification() {
		final CandidateViewBean candidateViewBean = BeanUtils
				.getCandidateViewBean();
		candidateViewBean.switchMode(1);
	}

	public EmpInfoItem getModifyEmployeeInfoItem() {
		return modifyEmployeeInfoItem;
	}

	public void setModifyEmployeeInfoItem(EmpInfoItem modifyEmployeeInfoItem) {
		this.modifyEmployeeInfoItem = modifyEmployeeInfoItem;
	}

	public List<Level> getLevels() {
		return LevelLocalServiceUtil.findAll();
	}

	public List<University> getUniversities() {
		return UniversityLocalServiceUtil.findAll();
	}

	public List<String> getLaborContractTypes() {
		final List<String> results = new ArrayList<>();
		for (LaborContractType laborContractType : LaborContractType.values()) {
			results.add(laborContractType.toString());
		}
		return results;
	}

	private void getCountriesList() {
		try {
			countries = CountryServiceUtil.getCountries(true);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmployeeBean.class).info(e);
		}
	}

	public Date getMaxBirthdayDate() {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.YEAR, -18);
		return now.getTime();
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

	private String generateUsername() {
		final String defaultUsername = "user" + System.currentTimeMillis();
		if (modifyEmployeeInfoItem != null
				&& modifyEmployeeInfoItem.getUser().getFirstName() != null
				&& modifyEmployeeInfoItem.getUser().getMiddleName() != null
				&& modifyEmployeeInfoItem.getUser().getLastName() != null) {
			final String generatedUsername = EmployeeUtils
					.generateUsername(EmployeeUtils
							.getFullnameFromUser(modifyEmployeeInfoItem
									.getUser()));
			return StringUtils.trimToNull(generatedUsername) != null ? generatedUsername
					: defaultUsername;

		}
		return defaultUsername;
	}

}
