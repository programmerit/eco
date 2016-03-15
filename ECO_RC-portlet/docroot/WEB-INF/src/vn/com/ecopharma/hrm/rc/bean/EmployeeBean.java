package vn.com.ecopharma.hrm.rc.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.portlet.PortletRequest;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.FileUploadEvent;

import vn.com.ecopharma.emp.model.Document;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpBankInfo;
import vn.com.ecopharma.emp.model.Level;
import vn.com.ecopharma.emp.model.Specialized;
import vn.com.ecopharma.emp.model.University;
import vn.com.ecopharma.emp.service.DistrictLocalServiceUtil;
import vn.com.ecopharma.emp.service.DocumentLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.LevelLocalServiceUtil;
import vn.com.ecopharma.emp.service.SpecializedLocalServiceUtil;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.constant.CandidateNavigation;
import vn.com.ecopharma.hrm.rc.dto.AddressObjectItem;
import vn.com.ecopharma.hrm.rc.dto.BankInfoObject;
import vn.com.ecopharma.hrm.rc.dto.CandidateIndexItem;
import vn.com.ecopharma.hrm.rc.dto.CandidateItem;
import vn.com.ecopharma.hrm.rc.dto.DependentName;
import vn.com.ecopharma.hrm.rc.dto.DocumentItem;
import vn.com.ecopharma.hrm.rc.dto.EmpInfoItem;
import vn.com.ecopharma.hrm.rc.dto.RegionItem;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateStatus;
import vn.com.ecopharma.hrm.rc.enumeration.DocumentType;
import vn.com.ecopharma.hrm.rc.enumeration.EducationType;
import vn.com.ecopharma.hrm.rc.enumeration.LaborContractType;
import vn.com.ecopharma.hrm.rc.enumeration.VacancyCandidateType;
import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.model.VacancyCandidate;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.BeanUtils;
import vn.com.ecopharma.hrm.rc.util.EmployeeUtils;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.ServiceContext;

@ManagedBean
@ViewScoped
public class EmployeeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil.getLog(EmployeeBean.class);

	private static final String MALE = "male";

	private EmpInfoItem modifyEmployeeInfoItem;

	private Candidate transferCandidate;

	private List<Country> countries;

	private boolean autoPassword = true;

	// DOCUMENT PART
	private int deletedDocumentIndex = -1;
	private String selectedDocumentType = DocumentType.LABOR_CONTRACT
			.toString(); // default

	@PostConstruct
	public void init() {
		try {
			countries = CountryServiceUtil.getCountries(true);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}

	public void save() {
		final ServiceContext serviceContext = RCUtils.getServiceContext();

		final Emp employee = modifyEmployeeInfoItem.getEmp();

		final User generatedUser = modifyEmployeeInfoItem.getUser();

		final Map<Address, Boolean> addressMap = EmployeeUtils
				.transferAddressObjectListToAddressMap(modifyEmployeeInfoItem
						.getAddresses());
		final Map<String, Boolean> dependentMap = EmployeeUtils
				.transferDependentNameObjectListToDependentNameMap(modifyEmployeeInfoItem
						.getDependentNames());

		final Map<EmpBankInfo, Boolean> bankInfoMap = EmployeeUtils
				.transferBankInfoObjectListToBankInfoMap(modifyEmployeeInfoItem
						.getBankInfos());

		generatedUser.setFirstName(EmpLocalServiceUtil
				.getFirstName(modifyEmployeeInfoItem.getFullName()));
		generatedUser.setMiddleName(EmpLocalServiceUtil
				.getMiddleName(modifyEmployeeInfoItem.getFullName()));
		generatedUser.setLastName(EmpLocalServiceUtil
				.getLastName(modifyEmployeeInfoItem.getFullName()));
		long specializedId = EmployeeUtils
				.getBaseModelPrimaryKey(modifyEmployeeInfoItem.getSpecialized());
		modifyEmployeeInfoItem.getEmp().setSpecializeId(specializedId);

		long workingPlaceId = modifyEmployeeInfoItem.getWorkingPlace() != null ? modifyEmployeeInfoItem
				.getWorkingPlace().getId() : 0L;
		modifyEmployeeInfoItem.getEmp().setWorkingPlaceId(workingPlaceId);

		BeanUtils.getOrganizationPanelBean().setSelectedValuesToEmp(
				modifyEmployeeInfoItem.getEmp());

		try {
			Emp result = EmpLocalServiceUtil.addEmp(employee, generatedUser,
					autoPassword, modifyEmployeeInfoItem.getUserPassword1(),
					modifyEmployeeInfoItem.getUserPassword2(), false,
					modifyEmployeeInfoItem.getUserName(), employee.getGender()
							.equalsIgnoreCase(MALE) ? true : false, true,
					addressMap, dependentMap,
					new HashMap<EmpBankInfo, Boolean>(), false, serviceContext);

			if (result != null) {
				CandidateLocalServiceUtil.changeCandidateStatus(
						transferCandidate, CandidateStatus.HIRE.toString(),
						serviceContext);
				FacesMessage message = new FacesMessage(
						"Action's taken successfully",
						"Candidate has successfully set as Employee!");
				FacesContext.getCurrentInstance().addMessage(null, message);

				BeanUtils.getCandidateViewBean().switchMode(
						CandidateNavigation.VIEW);

			}
		} catch (PortalException e) {
			LOGGER.info(e);
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

	public void onPrimaryChanged(AjaxBehaviorEvent event) {
	}

	public void addOneBankInfo() {
		if (modifyEmployeeInfoItem.getBankInfos().size() < 3)
			modifyEmployeeInfoItem.getBankInfos().add(new BankInfoObject());
	}

	public void removeOneBankInfo(int index) {
		modifyEmployeeInfoItem.getBankInfos().get(index).setUIDeleted(true);
	}

	public void cancelModification() {
		final CandidateViewBean candidateViewBean = BeanUtils
				.getCandidateViewBean();
		candidateViewBean.switchMode(1);
	}

	public void transferCandidateInfo(CandidateItem candidateItem) {
		try {
			modifyEmployeeInfoItem = transferCandidateInfo(candidateItem
					.getObject());
		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmployeeBean.class).info(e);
		}
	}

	public EmpInfoItem transferCandidateInfo(
			CandidateIndexItem candidateIndexItem) {
		try {
			Candidate c = CandidateLocalServiceUtil
					.fetchCandidate(candidateIndexItem.getId());
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
		final String generatedUsername = EmpLocalServiceUtil
				.checkAndGenerateUsernameByFullname(fullName,
						RCUtils.getServiceContext());
		this.transferCandidate = candidate;
		employeeInfoItem.setFullName(fullName);
		employeeInfoItem.getEmp().setPersonalEmail(candidate.getEmailAddress());

		employeeInfoItem.getEmp().setIdentityCardNo(
				candidate.getIdentityCardNo());
		employeeInfoItem.getEmp()
				.setContactNumber(candidate.getContactNumber());
		employeeInfoItem.getEmp().setBirthday(candidate.getDateOfBirth());
		employeeInfoItem.setUserName(generatedUsername);

		employeeInfoItem.getUser().setEmailAddress(
				EmpLocalServiceUtil.generateEmailByUsername(generatedUsername,
						"@ecopharma.com.vn"));

		employeeInfoItem.getEmp().setIdentityCardNo(
				candidate.getIdentityCardNo());

		employeeInfoItem.getEmp().setEthnic(candidate.getEthnic());

		employeeInfoItem.getEmp().setReligion(candidate.getReligion());

		final List<VacancyCandidate> vacancyCandidates = VacancyCandidateLocalServiceUtil
				.findByCandidateAndType(candidate.getCandidateId(),
						VacancyCandidateType.MAIN.toString());
		VacancyCandidate vacancyCandidate = vacancyCandidates != null
				&& !vacancyCandidates.isEmpty() ? vacancyCandidates.get(0)
				: null;

		Vacancy vacancy = vacancyCandidate != null ? VacancyLocalServiceUtil
				.fetchVacancy(vacancyCandidate.getVacancyId()) : null;

		BeanUtils.getOrganizationPanelBean().setSelectedValuesFromVacancy(
				vacancy);
		return employeeInfoItem;
	}

	public void handleDocumentUpload(FileUploadEvent event) {
		try {
			PortletRequest request = (PortletRequest) FacesContext
					.getCurrentInstance().getExternalContext().getRequest();
			final Document uploadDocument = DocumentLocalServiceUtil
					.uploadAndLinkEntity(modifyEmployeeInfoItem.getEmp(),
							request, event.getFile().getInputstream(), event
									.getFile().getFileName(),
							"EmployeeDocuments", DocumentType.LABOR_CONTRACT
									.toString(), true, EmployeeUtils
									.getServiceContext());
			if (uploadDocument != null)
				modifyEmployeeInfoItem.getDocuments().add(
						new DocumentItem(uploadDocument));
		} catch (IOException e) {
			LOGGER.info(e);
		}
	}

	public void deleteDocument() {
		if (deletedDocumentIndex != -1) {
			DocumentItem item = modifyEmployeeInfoItem.getDocuments().get(
					deletedDocumentIndex);
			DocumentLocalServiceUtil.completelyDeleteDocuments(item
					.getFileEntry().getFileEntryId());
			modifyEmployeeInfoItem.getDocuments().remove(deletedDocumentIndex);
		}
	}

	public List<String> getAllDocumentType() {
		return DocumentType.getAll();
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
		String username = generateUsername();
		String emailAddress = EmployeeUtils.generateEmailByUsername(username);
		modifyEmployeeInfoItem.setUserName(username);
		modifyEmployeeInfoItem.getUser().setEmailAddress(emailAddress);
	}

	public void onFullNameBlur() {
		String username = generateUsername();
		String emailAddress = EmployeeUtils.generateEmailByUsername(username);
		modifyEmployeeInfoItem.setUserName(username);
		modifyEmployeeInfoItem.getUser().setEmailAddress(emailAddress);
	}

	private String generateUsername() {
		final String defaultUsername = "user" + System.currentTimeMillis();

		final String generatedUsername = EmpLocalServiceUtil
				.checkAndGenerateUsernameByFullname(
						modifyEmployeeInfoItem.getFullName(),
						RCUtils.getServiceContext());
		return StringUtils.trimToNull(generatedUsername) != null ? generatedUsername
				: defaultUsername;

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
	public void onAddDependence(ActionEvent event) {
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

	public List<Specialized> getSpecializeds() {
		return SpecializedLocalServiceUtil.findAll();
	}

	/**
	 * Default working place in VN
	 * 
	 * @return all regions of VN
	 */
	public List<RegionItem> getWorkingPlaces() {
		try {
			final List<Region> vnRegions = RegionServiceUtil.getRegions(17L);
			final List<RegionItem> regionItems = new ArrayList<>();
			for (Region region : vnRegions) {
				regionItems.add(new RegionItem(region));
			}
			Collections.sort(regionItems);
			return regionItems;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public String getSelectedDocumentType() {
		return selectedDocumentType;
	}

	public void setSelectedDocumentType(String selectedDocumentType) {
		this.selectedDocumentType = selectedDocumentType;
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

	public EmpInfoItem getModifyEmployeeInfoItem() {
		return modifyEmployeeInfoItem;
	}

	public void setModifyEmployeeInfoItem(EmpInfoItem modifyEmployeeInfoItem) {
		this.modifyEmployeeInfoItem = modifyEmployeeInfoItem;
	}
}
