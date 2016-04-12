package vn.com.ecopharma.emp.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.portlet.PortletRequest;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;

import vn.com.ecopharma.emp.bean.DisciplineBean.EmpDisciplineItem;
import vn.com.ecopharma.emp.bean.VacationLeaveBean.VacationItem;
import vn.com.ecopharma.emp.bean.organization.OrganizationPanelBean;
import vn.com.ecopharma.emp.dto.AddressObjectItem;
import vn.com.ecopharma.emp.dto.BankInfoObject;
import vn.com.ecopharma.emp.dto.DependentName;
import vn.com.ecopharma.emp.dto.DocumentItem;
import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.dto.EmpInfoItem;
import vn.com.ecopharma.emp.dto.LaborContractItem;
import vn.com.ecopharma.emp.dto.RegionItem;
import vn.com.ecopharma.emp.enumeration.DocumentType;
import vn.com.ecopharma.emp.enumeration.EducationType;
import vn.com.ecopharma.emp.enumeration.EmpDialog;
import vn.com.ecopharma.emp.enumeration.EmployeeStatus;
import vn.com.ecopharma.emp.enumeration.LaborContractType;
import vn.com.ecopharma.emp.model.Document;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpBankInfo;
import vn.com.ecopharma.emp.model.EmpLaborContract;
import vn.com.ecopharma.emp.model.Level;
import vn.com.ecopharma.emp.model.Specialized;
import vn.com.ecopharma.emp.model.University;
import vn.com.ecopharma.emp.permission.EmpPermission;
import vn.com.ecopharma.emp.service.DistrictLocalServiceUtil;
import vn.com.ecopharma.emp.service.DocumentLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpAnnualLeaveLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpConcurrentTitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLaborContractLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpOrgRelationshipLocalServiceUtil;
import vn.com.ecopharma.emp.service.LevelLocalServiceUtil;
import vn.com.ecopharma.emp.service.PromotedHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.service.ResignationHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.service.SpecializedLocalServiceUtil;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;

@ManagedBean(name = "empView")
@ViewScoped
public class EmployeeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil.getLog(EmployeeBean.class);

	private static final boolean IS_TEST_ENV = false;

	private static final String EMPLOYEE_VIEW_PAGE = "/views/employees.xhtml";

	private static final String EMPLOYEE_MODIFY_PAGE = "/views/employeeForm.xhtml";

	private static final String IMPORT_EXPORT_PAGE = "/views/import_export.xhtml";

	private static final String MALE = "male";

	private static final String EMAIL_SUFFIX = "@ecopharma.com.vn";

	private EmpInfoItem modifyEmployeeInfoItem;

	private EmpInfoItem selectedEmployeeInfoItem;

	private List<Country> countries;

	private boolean isEdit = false;

	private boolean autoPassword = true;

	private String filterPanelIncluded = StringUtils.EMPTY;

	private String deletedEmployeeId;

	private String selectedStatus;

	private String updateString = StringUtils.EMPTY;

	private String currentNav = StringUtils.EMPTY;

	private String includedDialog = StringUtils.EMPTY;

	private String includedDialogOutputPanel = StringUtils.EMPTY;

	// DOCUMENT PART
	private int deletedDocumentIndex = -1;
	private String selectedDocumentType = DocumentType.LABOR_CONTRACT
			.toString(); // default

	/**
	 * 1: Employees View; 2: Create new; 3: Edit
	 */
	private int currentPage = 1;

	@ManagedProperty(value = "#{employeeIndexedBean}")
	private EmployeeIndexedBean indexedBean;

	@ManagedProperty(value = "#{organizationPanelBean}")
	private OrganizationPanelBean organizationPanelBean;

	@PostConstruct
	public void init() {

		try {
			currentNav = "/views/employees.xhtml";
			countries = CountryServiceUtil.getCountries(true);

		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}

	/**
	 * @param employeeInfoItem
	 */
	public void editEmployee(String employeeId) {
		try {
			modifyEmployeeInfoItem = new EmpInfoItem(Long.valueOf(employeeId));
			organizationPanelBean
					.setSelectedValuesFromEmp(modifyEmployeeInfoItem.getEmp());
			organizationPanelBean
					.setConcurrentTitles(EmpConcurrentTitlesLocalServiceUtil
							.findByEmp(Long.valueOf(employeeId)));
			isEdit = false;
			updateString = StringUtils.EMPTY;

			ThemeDisplay themeDisplay = (ThemeDisplay) FacesContext
					.getCurrentInstance().getExternalContext().getRequestMap()
					.get(WebKeys.THEME_DISPLAY);

			String url = modifyEmployeeInfoItem.getUser().getPortraitURL(
					themeDisplay);
			modifyEmployeeInfoItem.setUserImgURL(url);
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		switchPage(3);
	}

	/**
	 * on Adding New Employee
	 */
	public void addNewEmployee() {
		isEdit = true;
		modifyEmployeeInfoItem = new EmpInfoItem();
		BeanUtils.getOrganizationPanelBean().afterSetOrganizationToEntity();
		updateString = StringUtils.EMPTY;
		switchPage(2);
	}

	/**
	 * @param employeeId
	 */
	public void importExportEmployee() {
		switchPage(4);
	}

	public void save() {
		LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();
		final ServiceContext serviceContext = liferayFacesContext
				.getServiceContext();
		FacesMessage msg = null;
		boolean isSuccessfulModified = false;
		try {
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

			final Map<EmpLaborContract, Boolean> contractInfoMap = EmployeeUtils
					.transferEmpLaborContractInfoListToEmpLaborContractMap(modifyEmployeeInfoItem
							.getLaborContracts());

			generatedUser.setFirstName(EmpLocalServiceUtil
					.getFirstName(modifyEmployeeInfoItem.getFullName()));
			generatedUser.setMiddleName(EmpLocalServiceUtil
					.getMiddleName(modifyEmployeeInfoItem.getFullName()));
			generatedUser.setLastName(EmpLocalServiceUtil
					.getLastName(modifyEmployeeInfoItem.getFullName()));
			long specializedId = EmployeeUtils
					.getBaseModelPrimaryKey(modifyEmployeeInfoItem
							.getSpecialized());
			long workingPlaceId = EmployeeUtils
					.getBaseModelItemPrimaryKey(modifyEmployeeInfoItem
							.getWorkingPlace());
			modifyEmployeeInfoItem.getEmp().setSpecializeId(specializedId);
			modifyEmployeeInfoItem.getEmp().setWorkingPlaceId(workingPlaceId);

			long oldTitlesId = employee.getTitlesId();
			organizationPanelBean.setSelectedValuesToEmp(modifyEmployeeInfoItem
					.getEmp());

			if (isEdit) {
				final boolean sendEmail = true;
				Emp result = EmpLocalServiceUtil.addEmp(employee,
						generatedUser, autoPassword, modifyEmployeeInfoItem
								.getUserPassword1(), modifyEmployeeInfoItem
								.getUserPassword2(), false,
						modifyEmployeeInfoItem.getUserName(), employee
								.getGender().equalsIgnoreCase(MALE) ? true
								: false, sendEmail, addressMap, dependentMap,
						bankInfoMap, contractInfoMap, false, serviceContext);

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

				isSuccessfulModified = true;
			} else {
				EmpLocalServiceUtil.update(employee,
						modifyEmployeeInfoItem.getUser(), oldTitlesId,
						addressMap, dependentMap, bankInfoMap, contractInfoMap,
						Boolean.FALSE, serviceContext);

				msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Update employee successfully", "Employee "
								+ modifyEmployeeInfoItem.getUser()
										.getFullName() + " has been updated");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				isSuccessfulModified = true;
			}
			organizationPanelBean.afterSetOrganizationToEntity();
		} catch (Exception e) {
			isSuccessfulModified = false;
			LOGGER.info(e);
		}

		if (isSuccessfulModified) {// NOSONAR
			modifyEmployeeInfoItem = null;
			updateString = "refreshEmployees();";
			this.includedDialog = isEdit ? "/views/dialogs/notifyDialog.xhtml"
					: StringUtils.EMPTY;
			switchPage(1);
			if (isEdit)
				RequestContext.getCurrentInstance().execute(
						"PF('wNotifyDialog').show();");
		}

	}

	/**
	 * Cancel modification and switch back to Employee List
	 */
	public void cancelModification() {
		modifyEmployeeInfoItem = null;
		organizationPanelBean.afterSetOrganizationToEntity();
		switchPage(1);
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

	public void removeBank(BankInfoObject bank) {
		bank.setUIDeleted(true);
	}

	public void onTempSaveBankInfo(ActionEvent event) {

	}

	public void addOneContractInfo() {
		modifyEmployeeInfoItem.getLaborContracts().add(new LaborContractItem());
	}

	public void removeContract(LaborContractItem item) {
		item.setUIDeleted(true);
	}

	public void onTempSaveContractInfo() {
		Collections.sort(modifyEmployeeInfoItem.getLaborContracts());
		modifyEmployeeInfoItem.getLaborContracts()
				.get(modifyEmployeeInfoItem.getLaborContracts().size() - 1)
				.getObject().setLatest(true);
	}

	/**
	 * @param pageNo
	 */
	public void switchPage(int pageNo) {
		this.currentPage = pageNo;
		switch (currentPage) {
		case 1:
			currentNav = EMPLOYEE_VIEW_PAGE;
			break;
		case 2:
			currentNav = EMPLOYEE_MODIFY_PAGE;
			break;
		case 3:
			currentNav = EMPLOYEE_MODIFY_PAGE;
			break;
		case 4:
			currentNav = IMPORT_EXPORT_PAGE;
			break;
		default:
			break;
		}
	}

	public void onTestAddAnnualLeaveDays() {
		EmpAnnualLeaveLocalServiceUtil
				.scanAndAutoAddVacationLeave(EmployeeUtils.getServiceContext());
	}

	public void onPrimaryChanged(AjaxBehaviorEvent event) {
	}

	public void onRowDblSelect(SelectEvent event) {
		EmpIndexedItem emp = (EmpIndexedItem) event.getObject();
		boolean hasViewAuthorized = false;
		EmpPermission permission = BeanUtils.getEmpPermissionBean();

		if (permission.checkPermission(emp.getEmpId(), "VIEW")) {
			hasViewAuthorized = true;
		} else {
			// current viewing user
			long userId = EmployeeUtils.getServiceContext().getUserId();
			Emp viewerEmp = EmpLocalServiceUtil.findByUser(userId);
			if (viewerEmp != null) {
				// check if current user is manager of emp's department
				long departmentId = emp.getDepartmentId();
				hasViewAuthorized = EmpOrgRelationshipLocalServiceUtil
						.isHeadOfDepartment(viewerEmp.getEmpId(), departmentId);
			}
		}
		if (hasViewAuthorized) {
			editEmployee(String.valueOf(emp.getId()));
		}
	}

	public void onCallNotifyDialog() {
		RequestContext.getCurrentInstance().execute(
				"PF('wNotifyDialog').show();");
	}

	/**
	 * usage : Set delete flag for employee
	 * 
	 * @param employeeInfoItem
	 */
	public void setDeleteEmployee() {
		EmpLocalServiceUtil.markDeletedEmp(Long.valueOf(deletedEmployeeId));
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
		String emailAddress = EmpLocalServiceUtil.generateEmailByUsername(
				username, EMAIL_SUFFIX);
		modifyEmployeeInfoItem.getUser().setEmailAddress(emailAddress);
	}

	public void onLastNameBlur() {
		if (isEdit) {
			String username = generateUsername();
			String emailAddress = EmpLocalServiceUtil.generateEmailByUsername(
					username, EMAIL_SUFFIX);
			modifyEmployeeInfoItem.setUserName(username);
			modifyEmployeeInfoItem.getUser().setEmailAddress(emailAddress);
		}
	}

	public void onFullNameBlur() {
		if (isEdit) {
			String username = generateUsername();
			String emailAddress = EmpLocalServiceUtil.generateEmailByUsername(
					username, EMAIL_SUFFIX);
			modifyEmployeeInfoItem.setUserName(username);
			modifyEmployeeInfoItem.getUser().setEmailAddress(emailAddress);
		}

	}

	private String generateUsername() {
		final String defaultUsername = "user" + System.currentTimeMillis();

		final String generatedUsername = EmpLocalServiceUtil
				.checkAndGenerateUsernameByFullname(
						modifyEmployeeInfoItem.getFullName(),
						EmployeeUtils.getServiceContext());
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

	public void onStatusChange(long employeeId) {
		final EmployeeStatus status = EmployeeStatus.valueOf(selectedStatus);

		if (status.equals(EmployeeStatus.RESIGNED)) {
			// ResignationBean resignationBean = (ResignationBean) BeanUtils
			// .getBackingBeanByName("resignationBean");
			// resignationBean.setEmployeeId(employeeId);
			// RequestContext.getCurrentInstance().execute(
			// "PF('wResignationDialog').show()");
		}
		selectedStatus = null;
	}

	public void onPromotionNewPosition() {
		long id = ((EmployeeIndexedBean) BeanUtils
				.getBackingBeanByName("employeeIndexedBean"))
				.getSelectedEmployeeIndexItems().get(0).getId();
		PromotionBean promotionBean = (PromotionBean) BeanUtils
				.getBackingBeanByName("promotionBean");
		promotionBean.setPromotedHistory(PromotedHistoryLocalServiceUtil
				.createPrePersisted());
		promotionBean.setEmployeeId(id);
		organizationPanelBean.afterSetOrganizationToEntity();
		setDialog(EmpDialog.PROMOTION);
	}

	public void onResignedEmployee() {
		ResignationBean resignationBean = (ResignationBean) BeanUtils
				.getBackingBeanByName("resignationBean");
		List<EmpIndexedItem> empIndexedItems = BeanUtils
				.getEmployeeIndexedBean().getSelectedEmployeeIndexItems();
		if (resignationBean.getResignedItem() == null)
			resignationBean
					.setResignedItem(new ResignationBean.EmpResignedItem());
		resignationBean.getEmps().addAll(empIndexedItems);
		setDialog(EmpDialog.RESIGNATION);
	}

	public void onAddingDiscipline() {
		DisciplineBean disciplineBean = (DisciplineBean) BeanUtils
				.getBackingBeanByName("disciplineBean");
		List<EmpIndexedItem> empIndexedItems = BeanUtils
				.getEmployeeIndexedBean().getSelectedEmployeeIndexItems();
		if (disciplineBean.getEmpDisciplineItem() == null)
			disciplineBean.setEmpDisciplineItem(new EmpDisciplineItem());
		disciplineBean.getEmps().addAll(empIndexedItems);
		setDialog(EmpDialog.DISCIPLINE);
	}

	public void onSetMaternityLeave() {
		VacationLeaveBean vacationLeaveBean = (VacationLeaveBean) BeanUtils
				.getBackingBeanByName("leaveBean");
		List<EmpIndexedItem> empIndexedItems = indexedBean
				.getSelectedEmployeeIndexItems();
		vacationLeaveBean.setLeave(new VacationItem(empIndexedItems.get(0)));

		this.includedDialog = "/views/dialogs/vacationLeaveDialog.xhtml";
		this.includedDialogOutputPanel = ":leaveForm:leaveOutputPanel";
	}

	public void onSetConcurrentTitles() {
		List<EmpIndexedItem> empIndexedItems = indexedBean
				.getSelectedEmployeeIndexItems();
		if (!empIndexedItems.isEmpty() || empIndexedItems.size() > 1) {
			EmpIndexedItem item = empIndexedItems.get(0);
			BeanUtils.getConcurrentTitlesBean().setEmpIndexedItem(item);
			setDialog(EmpDialog.CONCURRENT_TITLES);
		}

	}

	public void onTransferEmpContract() {
		EmpLaborContractLocalServiceUtil.transferContractFromEmps(EmployeeUtils
				.getServiceContext());
	}

	public void setDialog(EmpDialog empDialog) {
		this.includedDialog = empDialog.getPath();
		this.includedDialogOutputPanel = empDialog.getDialogOutputPanel();
	}

	public List<String> getAvailableStatuses(String status) {
		return EmployeeStatus.getAvailableStatus_(status);
	}

	public EmpInfoItem getModifyEmployeeInfoItem() {
		return modifyEmployeeInfoItem;
	}

	public void setModifyEmployeeInfoItem(EmpInfoItem modifyEmployeeInfoItem) {
		this.modifyEmployeeInfoItem = modifyEmployeeInfoItem;
	}

	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public EmpInfoItem getSelectedEmployeeInfoItem() {
		return selectedEmployeeInfoItem;
	}

	public void setSelectedEmployeeInfoItem(EmpInfoItem selectedEmployeeInfoItem) {
		this.selectedEmployeeInfoItem = selectedEmployeeInfoItem;
	}

	public String getDeletedEmployeeId() {
		return deletedEmployeeId;
	}

	public void setDeletedEmployeeId(String deletedEmployeeId) {
		this.deletedEmployeeId = deletedEmployeeId;
	}

	public boolean isAutoPassword() {
		return autoPassword;
	}

	public void setAutoPassword(boolean autoPassword) {
		this.autoPassword = autoPassword;
	}

	public String getFilterPanelIncluded() {
		return filterPanelIncluded;
	}

	public void setFilterPanelIncluded(String filterPanelIncluded) {
		this.filterPanelIncluded = filterPanelIncluded;
	}

	public String getSelectedStatus() {
		return selectedStatus;
	}

	public void setSelectedStatus(String selectedStatus) {
		this.selectedStatus = selectedStatus;
	}

	public String getStatusLocalized(String status) {
		return EmployeeStatus.valueOf(status).getLocalizedString();
	}

	public boolean isResigned(long employeeId) {
		return ResignationHistoryLocalServiceUtil.getIndexedDocument(
				employeeId, EmployeeUtils.getCurrentSearchContext()) != null;
	}

	public String getUpdateString() {
		return updateString;
	}

	public void setUpdateString(String updateString) {
		this.updateString = updateString;
	}

	public String getCurrentNav() {
		return currentNav;
	}

	public void setCurrentNav(String currentNav) {
		this.currentNav = currentNav;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getIncludedDialog() {
		return includedDialog;
	}

	public void setIncludedDialog(String includedDialog) {
		this.includedDialog = includedDialog;
	}

	public String getIncludedDialogOutputPanel() {
		return includedDialogOutputPanel;
	}

	public void setIncludedDialogOutputPanel(String includedDialogOutputPanel) {
		this.includedDialogOutputPanel = includedDialogOutputPanel;
	}

	public int getDeletedDocumentIndex() {
		return deletedDocumentIndex;
	}

	public void setDeletedDocumentIndex(int deletedDocumentIndex) {
		this.deletedDocumentIndex = deletedDocumentIndex;
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

	public EmployeeIndexedBean getIndexedBean() {
		return indexedBean;
	}

	public void setIndexedBean(EmployeeIndexedBean indexedBean) {
		this.indexedBean = indexedBean;
	}

	public OrganizationPanelBean getOrganizationPanelBean() {
		return organizationPanelBean;
	}

	public void setOrganizationPanelBean(
			OrganizationPanelBean organizationPanelBean) {
		this.organizationPanelBean = organizationPanelBean;
	}

	public boolean isTestEnabled() {
		return IS_TEST_ENV;
	}

	public void onExecuteFirstAprilQuartzTask() {
		EmpAnnualLeaveLocalServiceUtil.executeFirstAprilQuartzTask();
	}

}