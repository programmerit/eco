package vn.com.ecopharma.emp.bean.ie;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.dto.ColumnItem;
import vn.com.ecopharma.emp.dto.FilterDTO;
import vn.com.ecopharma.emp.dto.ImportExportEmployeeDTO;
import vn.com.ecopharma.emp.enumeration.EmployeeExportType;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpLaborContract;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;
import vn.com.ecopharma.emp.util.EmployeeUtils;
import vn.com.ecopharma.emp.util.ImportExportUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

@ManagedBean
@ViewScoped
public class EmployeeImportExportBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_EXPORT_FILE_NAME = "employeeExport";
	private static final String DEFAULT_PWD = "123";
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

	private String sheetNameOrIndex = "1";

	private boolean isExportedFail;

	public List<ImportExportEmployeeDTO> totalList;

	private List<ImportExportEmployeeDTO> importList;

	private List<ImportExportEmployeeDTO> possiblyDuplicationList;

	private List<ImportExportEmployeeDTO> failedImportList;

	private transient List<?> exportList;

	private List<ColumnItem> columns;

	private List<String> columnStrings;

	private List<ColumnItem> selectedColumns;

	private List<String> selectedColumnStrings;

	private boolean isFinishedImport;

	private int first;

	private int pageSize;

	@PostConstruct
	public void init() {
		totalList = new ArrayList<>();
		importList = new ArrayList<>();
		possiblyDuplicationList = new ArrayList<>();
		failedImportList = new ArrayList<>();
		columns = ImportExportUtils.createDefaultColumnItems();
		columnStrings = new ArrayList<>();
		for (ColumnItem item : columns) {
			columnStrings.add(item.getPropertyName());
		}
		selectedColumnStrings = new ArrayList<>(EmpField.defaultExportFields());
	}

	public List<ColumnItem> getSelectedColumnItems() {
		selectedColumns = new ArrayList<>();
		for (String column : selectedColumnStrings) {
			for (ColumnItem item : columns) {
				if (item.getPropertyName().equalsIgnoreCase(column)) {
					selectedColumns.add(item);
					break;
				}
			}
		}
		return selectedColumns;
	}

	public List<String> completeColumns(String query) {
		final List<String> result = new ArrayList<>();
		for (String item : columnStrings) {
			if (item.contains(query)) {
				result.add(item);
			}
		}
		return result;
	}

	public void generateExportList() {
		FilterDTO filterDTO = BeanUtils.getEmpFilterHolderBean()
				.getEmpFilterDTO();
		final SearchContext searchContext = EmployeeUtils
				.getCurrentSearchContext();
		Sort searchSort = null;
		if (filterDTO.getSortField() != null) {
			searchSort = new Sort(filterDTO.getSortField(), filterDTO
					.getSortOrder().equals(SortOrder.ASCENDING) ? false : true);
		}
		try {
			if ("all".equalsIgnoreCase(exportRange)) {
				exportList = EmployeeUtils
						.getEmployeeIndexedItemsFromIndexedDocuments(EmpLocalServiceUtil
								.filterEmployeeByFields(searchContext,
										new HashMap<String, Object>(), null,
										searchContext.getCompanyId(),
										QueryUtil.ALL_POS, QueryUtil.ALL_POS));
			} else if ("allFilterRange".equalsIgnoreCase(exportRange)) {
				exportList = EmployeeUtils
						.getEmployeeIndexedItemsFromIndexedDocuments(EmpLocalServiceUtil
								.filterEmployeeByFields(searchContext,
										filterDTO.getFilters(), searchSort,
										searchContext.getCompanyId(),
										QueryUtil.ALL_POS, QueryUtil.ALL_POS));
			} else if ("currentPage".equalsIgnoreCase(exportRange)) {
				exportList = EmployeeUtils
						.getEmployeeIndexedItemsFromIndexedDocuments(EmpLocalServiceUtil
								.filterEmployeeByFields(searchContext,
										filterDTO.getFilters(), searchSort,
										searchContext.getCompanyId(),
										filterDTO.getStart(),
										filterDTO.getEnd()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public StreamedContent getGeneratedDownloadFile() {
		final EmployeeExportType exportType = EmployeeExportType
				.valueOf(presetType.toUpperCase());
		Workbook wb = ImportExportUtils.generateAndGetExportExcelWorkbook(
				exportType, exportList, getSelectedColumnItems());

		try {
			final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			wb.write(outputStream);

			final PipedInputStream pipedInputStream = new PipedInputStream();

			final PipedOutputStream pipedOutputStream = new PipedOutputStream(
					pipedInputStream);

			new Thread(new Runnable() {
				@Override
				public void run() {
					EmployeeUtils.writeOutputStreamToPipedOutputStream(
							outputStream, pipedOutputStream);
				}
			}).start();

			return new DefaultStreamedContent(pipedInputStream,
					exportType.getMimeType(), DEFAULT_EXPORT_FILE_NAME
							+ exportType.getExension());
		} catch (IOException e) {
			LogFactoryUtil.getLog(EmployeeImportExportBean.class).info(e);
		}
		return null;
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
			String originGeneratedUserScreenName = EmpLocalServiceUtil
					.generateOriginalUsername(dto.getFullname());

			final Map<Address, Boolean> addressMap = EmployeeUtils
					.transferAddressObjectListToAddressMap(dto.getAddresses());
			final Map<String, Boolean> dependentNameMap = EmployeeUtils
					.transferDependentNameObjectListToDependentNameMap(EmployeeUtils
							.getDependentNamesFromString(dto
									.getDependentNames()));
			// final Map<EmpLaborContract, Boolean> contractInfoMap =
			// EmployeeUtils.transferEmpLaborContractInfoListToEmpLaborContractMap(dto.get)

			Emp checkExistEmp = EmpLocalServiceUtil.findByEmpCode(dto
					.getEmployeeCode());
			if (checkExistEmp == null) {
				Emp employee = dto.createPrePersistedEmployee();
				try {
					if (!EmpLocalServiceUtil.isUserExisted(
							originGeneratedUserScreenName,
							dto.getEmployeeCode(), dto.getDob(),
							EmployeeUtils.getCompanyId())) {
						originGeneratedUserScreenName = EmpLocalServiceUtil
								.generateOriginalUsername(dto.getFullname());

						LogFactoryUtil
								.getLog(EmployeeImportExportBean.class)
								.info("ON IMPORTING EMPLOYEE WITH GENERATED USERNAME: "
										+ originGeneratedUserScreenName);

						// set fields before saving
						employee.setTitlesId(dto.getTitlesId());
						employee.setUnitGroupId(dto.getUnitGroupId());
						employee.setUnitId(dto.getUnitId());
						employee.setLevelId(dto.getLevelId());
						employee.setBirthday(dto.getDob());
						dto.setEmailAddress(StringUtils.trimToNull(dto
								.getEmailAddress()) == null ? originGeneratedUserScreenName
								+ EMAIL_SUFFIX
								: dto.getEmailAddress());
						EmpLocalServiceUtil
								.addEmp(employee,
										false,
										DEFAULT_PWD,
										DEFAULT_PWD,
										false,
										originGeneratedUserScreenName,
										dto.getEmailAddress(),
										0, // facebook Id
										StringUtils.EMPTY, // openId
										LocaleUtil.getDefault(),
										dto.getFirstName(),
										dto.getMiddleName(),
										dto.getLastName(),
										0, // prefix Id
										0, // suffix Id
										employee.getGender().equalsIgnoreCase(
												MALE) ? true : false,
										dto.getBirthdayMonth(),
										dto.getBirthdayDay(),
										dto.getBirthdayYear(),
										groups,
										null, // organization Ids
										roles,
										null, // userGroup Ids
										false, // send email?
										addressMap, dependentNameMap,
										dto.getBankInfoMap(), Boolean.FALSE,
										serviceContext);

					} else {
						LogFactoryUtil
								.getLog(EmployeeImportExportBean.class)
								.info("ON IMPORTING EMPLOYEE WITH GENERATED USERNAME: "
										+ originGeneratedUserScreenName);

						// set fields before saving
						employee.setTitlesId(dto.getTitlesId());
						employee.setUnitGroupId(dto.getUnitGroupId());
						employee.setUnitId(dto.getUnitId());
						employee.setLevelId(dto.getLevelId());
						employee.setBirthday(dto.getDob());

						// TODO: labor contract!!!!
						EmpLocalServiceUtil.addOrUpdateWithExistUser(employee,
								originGeneratedUserScreenName,
								employee.getTitlesId(), addressMap,
								dependentNameMap, dto.getBankInfoMap(),
								new HashMap<EmpLaborContract, Boolean>(), true,
								serviceContext);
					}

				} catch (Exception e) {
					dto.setImportFailedException(e.getMessage());
					failedImportList.add(dto);
					LogFactoryUtil.getLog(EmployeeImportExportBean.class).info(
							e);
				}
				isFinishedImport = true;
			} else {
				User user = UserLocalServiceUtil.fetchUser(checkExistEmp
						.getEmpUserId());
				user.setFirstName(dto.getFirstName());
				user.setMiddleName(dto.getMiddleName());
				user.setLastName(dto.getLastName());
				// TODO: labor contract!!!
				EmpLocalServiceUtil.update(checkExistEmp, user,
						checkExistEmp.getTitlesId(), addressMap,
						dependentNameMap, dto.getBankInfoMap(),
						new HashMap<EmpLaborContract, Boolean>(), true,
						serviceContext);
			}
		}
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

	public List<ColumnItem> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnItem> columns) {
		this.columns = columns;
	}

	public List<ColumnItem> getSelectedColumns() {
		return selectedColumns;
	}

	public void setSelectedColumns(List<ColumnItem> selectedColumns) {
		this.selectedColumns = selectedColumns;
	}

	public List<String> getColumnStrings() {
		return columnStrings;
	}

	public void setColumnStrings(List<String> columnStrings) {
		this.columnStrings = columnStrings;
	}

	public List<String> getSelectedColumnStrings() {
		return selectedColumnStrings;
	}

	public void setSelectedColumnStrings(List<String> selectedColumnStrings) {
		this.selectedColumnStrings = selectedColumnStrings;
	}

}
