package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.Level;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.model.University;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.LevelLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.dto.AddressObjectItem;
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
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Country;
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

	private EmpInfoItem modifyEmployeeInfoItem;

	private List<Country> countries;

	private Candidate candidate;

	private boolean autoPassword = true;

	@SuppressWarnings("unused")
	private List<Titles> titlesList;

	public void transferCandidateInfo(CandidateItem candidateItem) {
		try {
			modifyEmployeeInfoItem = transferCandidateInfo(candidateItem
					.getCandidate());
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public EmpInfoItem transferCandidateInfo(
			CandidateIndexItem candidateIndexItem) {
		try {
			Candidate candidate = CandidateLocalServiceUtil
					.fetchCandidate(candidateIndexItem.getCandidateId());
			modifyEmployeeInfoItem = transferCandidateInfo(candidate);
		} catch (SystemException e) {
			e.printStackTrace();
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

	/**
	 * @param event
	 */
	public void save(ActionEvent event) {
		LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();
		final ServiceContext serviceContext = liferayFacesContext
				.getServiceContext();
		FacesMessage msg = null;
		try {
			final Emp employee = modifyEmployeeInfoItem.getEmp();

			employee.setUniversityId(modifyEmployeeInfoItem.getUniversityId());
			employee.setTitlesId(modifyEmployeeInfoItem.getTitlesId());
			employee.setLevelId(modifyEmployeeInfoItem.getLevelId());

			employee.setGroupId(serviceContext.getScopeGroupId());
			employee.setCompanyId(serviceContext.getCompanyId());

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

			Emp result = EmpLocalServiceUtil
					.addEmp(employee,
							false,
							!autoPassword ? modifyEmployeeInfoItem
									.getUserPassword1() : DEFAULT_PW,
							!autoPassword ? modifyEmployeeInfoItem
									.getUserPassword2() : DEFAULT_PW,
							false,
							modifyEmployeeInfoItem.getUserName(),
							modifyEmployeeInfoItem.getUser().getEmailAddress(),
							0,
							"",
							LocaleUtil.getDefault(),
							modifyEmployeeInfoItem.getUser().getFirstName(),
							modifyEmployeeInfoItem.getUser().getMiddleName(),
							modifyEmployeeInfoItem.getUser().getLastName(),
							0,
							0,
							employee.getGender().equalsIgnoreCase("male") ? true
									: false,
							month,
							day,
							year,
							groups,
							null,
							roles,
							null,
							false,
							0,
							EmployeeUtils
									.transferAddressObjectListToAddressMap(modifyEmployeeInfoItem
											.getAddresses()),
							EmployeeUtils
									.transferDependentNameObjectListToDependentNameMap(modifyEmployeeInfoItem
											.getDependentNames()),
							serviceContext);

			if (result != null) {
				candidate.setStatus(CandidateStatus.HIRE.toString());
				CandidateLocalServiceUtil.updateCandidate(candidate);

				msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Create employee successfully", "Employee "
								+ modifyEmployeeInfoItem.getUser()
										.getFullName() + " has been created");
				FacesContext.getCurrentInstance().addMessage(null, msg);

				RequestContext.getCurrentInstance().execute(
						"window.location.hash = '#vCandidate';");

				CandidateViewBean candidateViewBean = BeanUtils
						.getCandidateViewBean();
				candidateViewBean.switchMode(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addOneAddress(ActionEvent event) {
		modifyEmployeeInfoItem.getAddresses().add(new AddressObjectItem());
	}

	public void removeOneAddress(int index) {
		modifyEmployeeInfoItem.getAddresses().get(index).setUIDeleted(true);
	}

	// Dependent Names action part
	public void onAddDependence(ActionEvent e) {
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
			e.printStackTrace();
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

	public List<Unit> getUnits() {
		final Department empDepartment = modifyEmployeeInfoItem.getDepartment();
		final List<Unit> units = empDepartment != null ? UnitLocalServiceUtil
				.findByDepartment(empDepartment.getDepartmentId())
				: new ArrayList<Unit>();
		return units;
	}

	public List<Department> getDepartments() {
		List<Department> departments = modifyEmployeeInfoItem.getDevision() != null ? DepartmentLocalServiceUtil
				.findByDevision((modifyEmployeeInfoItem.getDevision()
						.getDevisionId())) : new ArrayList<Department>();
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

	public List<UnitGroup> getUnitGroups() {
		return modifyEmployeeInfoItem.getUnit() != null ? UnitGroupLocalServiceUtil
				.findByUnit(modifyEmployeeInfoItem.getUnit().getUnitId())
				: null;
	}

	public List<Titles> getTitlesList() {
		List<Titles> titlesList = null;
		if (modifyEmployeeInfoItem.getDepartment() != null) {
			if (modifyEmployeeInfoItem.getUnitGroup() != null) {
				titlesList = TitlesLocalServiceUtil
						.findByUnitGroup(modifyEmployeeInfoItem.getUnitGroup()
								.getUnitGroupId());

			} else {
				titlesList = TitlesLocalServiceUtil
						.findByUnit(modifyEmployeeInfoItem.getUnit()
								.getUnitId());
			}
			if (titlesList == null || titlesList.isEmpty()
					|| !titlesList.contains(modifyEmployeeInfoItem.getTitles())) {
				modifyEmployeeInfoItem.setTitles(null);
			}
		}

		return titlesList;
	}

	public List<Level> getLevels() {
		return LevelLocalServiceUtil.findAll();
	}

	public List<University> getUniversities() {
		return UniversityLocalServiceUtil.findAll();
	}

	public List<String> getLaborContractTypes() {
		final List<String> results = new ArrayList<String>();
		for (LaborContractType laborContractType : LaborContractType.values()) {
			results.add(laborContractType.toString());
		}
		return results;
	}

	private void getCountriesList() {
		try {
			countries = CountryServiceUtil.getCountries(true);
		} catch (SystemException e) {
			e.printStackTrace();
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
}
