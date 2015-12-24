package vn.com.ecopharma.emp.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.dto.ImportExportEmployeeDTO;
import vn.com.ecopharma.emp.enumeration.EmployeeExportType;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;
import vn.com.ecopharma.emp.util.DLUtils;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

@ManagedBean
@ViewScoped
public class EmployeeImportExportBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_PWD = "123";
	private static final String DATE_FORMAT = "yyyyMMdd";
	private static final String MALE = "male";
	private static final int START_ROW_NUM = 5;
	private static final int START_CELL_NUM = 2;

	private static final String USER_PERSONAL_SITE_GROUP = "User Personal Site";
	private static final String USER_ROLE = "User";

	private static final String EMAIL_SUFFIX = "@ecopharma.com.vn";

	private String filename;

	private String presetType = EmployeeExportType.XLSX.name().toLowerCase();
	private String exportRange = "all";
	private String exportColumn = "all";

	private StreamedContent file;

	private String sheetNameOrIndex = "1";

	private String fileURL = "#";

	private boolean isExportedFail;

	public List<ImportExportEmployeeDTO> totalList;

	private List<ImportExportEmployeeDTO> importList;

	private List<ImportExportEmployeeDTO> possiblyDuplicationList;

	private List<ImportExportEmployeeDTO> failedImportList;

	private boolean isFinishedImport;

	private int first;

	private int pageSize;

	@PostConstruct
	public void init() {
		totalList = new ArrayList<>();
		importList = new ArrayList<>();
		possiblyDuplicationList = new ArrayList<>();
		failedImportList = new ArrayList<>();
	}

	public void exportEmployees() {
		ServiceContext serviceContext = LiferayFacesContext.getInstance()
				.getServiceContext();

		final EmployeeIndexedBean employeeIndexedBean = (EmployeeIndexedBean) BeanUtils
				.getBackingBeanByName("employeeIndexedBean");
		try {
			DLFolder folder = DLFolderLocalServiceUtil.fetchFolder(
					serviceContext.getScopeGroupId(), 0, "temp");
			if (folder == null) {
				folder = DLUtils.createFolder("temp", "", 0,
						serviceContext.getScopeGroupId(),
						serviceContext.getCompanyId(),
						serviceContext.getUserId(),
						new Date(System.currentTimeMillis()),
						new Date(System.currentTimeMillis()));
			}
			List<?> exportList = new ArrayList<>();
			final SortOrder sortOrder = employeeIndexedBean.getSortOder();
			final String sortField = employeeIndexedBean.getSortField();
			final SearchContext searchContext = EmployeeUtils
					.getCurrentSearchContext();
			Sort searchSort = null;
			if (sortField != null) {
				searchSort = new Sort(sortField,
						sortOrder.equals(SortOrder.ASCENDING) ? false : true);
			} else {
				searchSort = new Sort(EmpField.EMP_ID, false);
			}

			if ("all".equalsIgnoreCase(exportRange)) {
				exportList = EmployeeUtils
						.getEmployeeIndexedItemsFromIndexedDocuments(EmpLocalServiceUtil
								.searchAllUnDeletedEmpIndexedDocument(
										searchContext, new ArrayList<Query>(),
										searchContext.getCompanyId(),
										searchSort, QueryUtil.ALL_POS,
										QueryUtil.ALL_POS));
			} else if ("allFilterRange".equalsIgnoreCase(exportRange)) {
				exportList = EmployeeUtils
						.getEmployeeIndexedItemsFromIndexedDocuments(EmpLocalServiceUtil
								.searchAllUnDeletedEmpIndexedDocument(
										searchContext,
										employeeIndexedBean.getQueries(),
										searchContext.getCompanyId(),
										searchSort, QueryUtil.ALL_POS,
										QueryUtil.ALL_POS));
			} else if ("currentPage".equalsIgnoreCase(exportRange)) {
				exportList = employeeIndexedBean.getEmpIndexedItems();
			}

			final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

			String exportFilenameSuffix = sdf.format(new Date(System
					.currentTimeMillis()));
			String filename = this.filename != null
					&& !this.filename.equals(StringUtils.EMPTY) ? this.filename
					+ exportFilenameSuffix : "employeeExport"
					+ exportFilenameSuffix;

			fileURL = EmployeeUtils.generateAndGetExportExcelFileURL(
					folder.getFolderId(),
					filename + System.currentTimeMillis(),
					EmployeeExportType.valueOf(presetType.toUpperCase()),
					exportList, serviceContext);

		} catch (Exception e) {
			LogFactoryUtil.getLog(EmployeeImportExportBean.class).info(e);
		}
		isExportedFail = "#".equals(fileURL);
	}

	/**
	 * @param fileUploadEvent
	 */
	public void handleFileImport(FileUploadEvent fileUploadEvent) {
		try {
			totalList = new ArrayList<>();
			importList = new ArrayList<>();
			final UploadedFile uploadedFile = fileUploadEvent.getFile();
			final InputStream is = uploadedFile.getInputstream();

			final XSSFWorkbook wb = new XSSFWorkbook(is);
			final XSSFSheet sheet = wb.getSheetAt(0);

			for (int i = START_ROW_NUM; i <= sheet.getLastRowNum(); i++) {
				if (sheet.getRow(i) != null) {
					final XSSFRow r = sheet.getRow(i);
					if (r.getCell(START_CELL_NUM) != null
							&& !r.getCell(START_CELL_NUM).getStringCellValue()
									.equals(StringUtils.EMPTY)) {

						final ImportExportEmployeeDTO importExportEmployeeDTO = new ImportExportEmployeeDTO(
								r);

						totalList.add(importExportEmployeeDTO);
					}
				}
			}
		} catch (IOException e) {
			LogFactoryUtil.getLog(EmployeeImportExportBean.class).info(e);
		}
	}

	public void executeImport(ActionEvent event) throws PortalException,
			SystemException {

		final ServiceContext serviceContext = LiferayFacesContext.getInstance()
				.getServiceContext();
		// group id: User Personal Site
		final long[] groups = new long[] { GroupLocalServiceUtil.getGroup(
				serviceContext.getCompanyId(), USER_PERSONAL_SITE_GROUP)
				.getGroupId() };
		// role id: User
		final long[] roles = new long[] { RoleLocalServiceUtil.getRole(
				serviceContext.getCompanyId(), USER_ROLE).getRoleId() };

		for (ImportExportEmployeeDTO dto : totalList) {
			String generatedUserScreenName = EmployeeUtils.generateUsername(dto
					.getFullname());

			final Map<Address, Boolean> addressMap = EmployeeUtils
					.transferAddressObjectListToAddressMap(dto.getAddresses());
			final Map<String, Boolean> dependentNameMap = EmployeeUtils
					.transferDependentNameObjectListToDependentNameMap(EmployeeUtils
							.getDependentNamesFromString(dto
									.getDependentNames()));

			long checkEmp = dto.checkExistedEmpEmpUser(generatedUserScreenName,
					dto.getEmployeeCode(), dto.getDob());
			Emp employee = null;
			User user = dto.getExistedUser();
			try {
				if (checkEmp == 0 || checkEmp == 1 || checkEmp == -1) {
					// generatedUserScreenName = checkEmp == 1 || checkEmp == -1
					// ? EmployeeUtils
					// .regenerateUsername(generatedUserScreenName, 1)
					// : generatedUserScreenName;
					LogFactoryUtil.getLog(EmployeeImportExportBean.class).info(
							"CHECK RESULT: " + checkEmp);
					// create pre-persisted ready to set fields & import
					employee = dto.createPrePersistedEmployee();
					LogFactoryUtil.getLog(EmployeeImportExportBean.class).info(
							"ON IMPORTING EMPLOYEE WITH GENERATED USERNAME: "
									+ generatedUserScreenName);

					// set fields before saving
					employee.setTitlesId(dto.getTitlesId());
					employee.setLevelId(dto.getLevelId());
					employee.setBirthday(dto.getDob());
					dto.setEmailAddress(generatedUserScreenName + EMAIL_SUFFIX);
					EmpLocalServiceUtil.addEmp(employee, false, DEFAULT_PWD,
							DEFAULT_PWD, false, generatedUserScreenName, dto
									.getEmailAddress(),
							0, // facebook Id
							StringUtils.EMPTY, // openId
							LocaleUtil.getDefault(), dto.getFirstName(), dto
									.getMiddleName(), dto.getLastName(),
							0, // prefix Id
							0, // suffix Id
							employee.getGender().equalsIgnoreCase(MALE) ? true
									: false, dto.getBirthdayMonth(), dto
									.getBirthdayDay(), dto.getBirthdayYear(),
							groups, null, // organization Ids
							roles, null, // userGroup Ids
							false, // send email?
							0, addressMap, dependentNameMap, dto
									.getBankInfoMap(), serviceContext);

				} else if (checkEmp == 2) {
					// create pre-persisted ready to set fields & import
					employee = dto.createPrePersistedEmployee();
					LogFactoryUtil.getLog(EmployeeImportExportBean.class).info(
							"ON IMPORTING EMPLOYEE WITH GENERATED USERNAME: "
									+ generatedUserScreenName);

					// set fields before saving
					employee.setTitlesId(dto.getTitlesId());
					employee.setLevelId(dto.getLevelId());
					employee.setBirthday(dto.getDob());
					try {
						EmpLocalServiceUtil.addEmp(employee, user, addressMap,
								dependentNameMap, serviceContext);
					} catch (Exception e) {
						dto.setImportFailedException(e.getMessage());
						failedImportList.add(dto);
						LogFactoryUtil.getLog(EmployeeImportExportBean.class)
								.info(e);
					}

				} else {
					employee = EmpLocalServiceUtil.fetchEmp(checkEmp);
					// call UPDATE
					Emp emp = dto.updateExistedEmployee(employee);
					EmpLocalServiceUtil.update(emp, user,
							employee.getTitlesId(), addressMap,
							dependentNameMap, dto.getBankInfoMap(),
							Boolean.TRUE, serviceContext);
				}
			} catch (Exception e) {
				dto.setImportFailedException(e.getMessage());
				failedImportList.add(dto);
				LogFactoryUtil.getLog(EmployeeImportExportBean.class).info(e);
			}
			isFinishedImport = true;
		}
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	public String getPresetType() {
		return presetType;
	}

	public void setPresetType(String presetType) {
		this.presetType = presetType;
	}

	public String getExportRange() {
		return exportRange;
	}

	public void setExportRange(String exportRange) {
		this.exportRange = exportRange;
	}

	public String getExportColumn() {
		return exportColumn;
	}

	public void setExportColumn(String exportColumn) {
		this.exportColumn = exportColumn;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getSheetNameOrIndex() {
		return sheetNameOrIndex;
	}

	public void setSheetNameOrIndex(String sheetNameOrIndex) {
		this.sheetNameOrIndex = sheetNameOrIndex;
	}

	public boolean isExportedFail() {
		return isExportedFail;
	}

	public List<ImportExportEmployeeDTO> getImportList() {
		return importList;
	}

	public void setImportList(List<ImportExportEmployeeDTO> importList) {
		this.importList = importList;
	}

	public List<ImportExportEmployeeDTO> getPossiblyDuplicationList() {
		return possiblyDuplicationList;
	}

	public void setPossiblyDuplicationList(
			List<ImportExportEmployeeDTO> possiblyDuplicationList) {
		this.possiblyDuplicationList = possiblyDuplicationList;
	}

	public List<ImportExportEmployeeDTO> getFailedImportList() {
		return failedImportList;
	}

	public void setFailedImportList(
			List<ImportExportEmployeeDTO> failedImportList) {
		this.failedImportList = failedImportList;
	}

	public int getDuplicationListSize() {
		return possiblyDuplicationList.size();
	}

	public int getFailedListSize() {
		return failedImportList.size();
	}

	public int getImportListSize() {
		return importList.size();
	}

	public int getTotalListSize() {
		return totalList.size();
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isFinishedImport() {
		return isFinishedImport;
	}

	public void setFinishedImport(boolean isFinishedImport) {
		this.isFinishedImport = isFinishedImport;
	}
}
