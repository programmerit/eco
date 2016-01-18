package vn.com.ecopharma.emp.bean.ie;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import vn.com.ecopharma.emp.exception.AddressTypeNotFoundException;
import vn.com.ecopharma.emp.model.District;
import vn.com.ecopharma.emp.service.DistrictLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;
import vn.com.ecopharma.emp.util.ImportExportUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.ServiceContext;

@ManagedBean(name = "updateEmpAddressBean")
@ViewScoped
public class UpdateEmployeeAddressIEBean {

	private static final int START_ROW_NUM = 5;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(UpdateEmployeeAddressIEBean.class);

	@PostConstruct
	public void init() {

	}

	/**
	 * @param fileUploadEvent
	 */
	public void handleFileImport(FileUploadEvent fileUploadEvent) {
		InputStream is = null;
		try {
			final UploadedFile uploadedFile = fileUploadEvent.getFile();
			final ServiceContext serviceContext = EmployeeUtils
					.getServiceContext();
			is = uploadedFile.getInputstream();

			XSSFWorkbook wb = new XSSFWorkbook(is);
			final XSSFSheet sheet = wb.getSheetAt(0);

			final List<UpdateEmpAddressItem> updateItems = new ArrayList<>();

			for (int i = START_ROW_NUM; i <= sheet.getLastRowNum(); i++) {
				if (sheet.getRow(i) != null) {
					final XSSFRow r = sheet.getRow(i);
					updateItems.add(new UpdateEmpAddressItem(r,
							UpdateEmpAddressItem.PRESENT));
					updateItems.add(new UpdateEmpAddressItem(r,
							UpdateEmpAddressItem.TEMP));
				}
			}

			final List<Region> allVNRegions = ImportExportUtils
					.getAllVNRegions();

			String prevEmpCode = StringUtils.EMPTY;
			for (UpdateEmpAddressItem item : updateItems) {
				if (item.isValidAddress()) {
					if (!prevEmpCode.equalsIgnoreCase(item.getEmpCode())) {
						// flush old addresses before update new ones
						prevEmpCode = item.getEmpCode();
						LOGGER.info("Flush " + prevEmpCode + " addresses");
						EmpLocalServiceUtil.removeAllExistingEmpAddresses(
								item.getEmpCode(),
								serviceContext.getCompanyId());
					}
					Region region = ImportExportUtils.getRegionFromListByName(
							allVNRegions, item.getCity());
					District district = DistrictLocalServiceUtil
							.findByRegionCodeAndName(region.getRegionCode(),
									item.getDistrict());

					LOGGER.info("Call update " + prevEmpCode + " addresses");
					EmpLocalServiceUtil.updateEmpAddresses(
							item.getEmpCode(),
							item.getAddress(),
							district,
							region,
							17L,
							item.getAddressType().equals(
									UpdateEmpAddressItem.PRESENT),
							serviceContext);

				}
			}
		} catch (IOException e) {
			LOGGER.info(e);
		} catch (AddressTypeNotFoundException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				LOGGER.info(e);
			}
		}
	}

	public final class UpdateEmpAddressItem implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public static final String PRESENT = "present";
		public static final String TEMP = "temp";

		private static final int EMP_CODE_CELL = 1;
		private static final int PRESENT_ADDR_CELL = 2;
		private static final int PRESENT_DISTRICT_CELL = 3;
		private static final int PRESENT_CITY_CELL = 4;
		private static final int TEMP_ADDR_CELL = 5;
		private static final int TEMP_DISTRICT_CELL = 6;
		private static final int TEMP_CITY_CELL = 7;

		private String empCode;
		private String address;
		private String district;
		private String city;

		private String addressType;

		public UpdateEmpAddressItem(String empCode, String address,
				String district, String city, String addressType) {
			super();
			this.empCode = empCode;
			this.address = address;
			this.district = district;
			this.city = city;
			this.addressType = addressType;
		}

		public UpdateEmpAddressItem(Row row, String addressType)
				throws AddressTypeNotFoundException {
			this.bindFieldsFromRow(row, addressType);
		}

		public void bindFieldsFromRow(Row row, String addressType)
				throws AddressTypeNotFoundException {
			this.empCode = row.getCell(EMP_CODE_CELL).getStringCellValue();
			this.addressType = addressType;
			if (addressType.equals(PRESENT)) {
				this.address = ImportExportUtils
						.getReturnValueFromStringCell(row
								.getCell(PRESENT_ADDR_CELL));
				this.district = ImportExportUtils
						.getReturnValueFromStringCell(row
								.getCell(PRESENT_DISTRICT_CELL));
				this.city = ImportExportUtils.getReturnValueFromStringCell(row
						.getCell(PRESENT_CITY_CELL));
			} else if (addressType.equals(TEMP)) {
				this.address = ImportExportUtils
						.getReturnValueFromStringCell(row
								.getCell(TEMP_ADDR_CELL));
				this.district = ImportExportUtils
						.getReturnValueFromStringCell(row
								.getCell(TEMP_DISTRICT_CELL));
				this.city = ImportExportUtils.getReturnValueFromStringCell(row
						.getCell(TEMP_CITY_CELL));
			} else {
				throw new AddressTypeNotFoundException();
			}
		}

		public boolean isValidAddress() {
			return StringUtils.trimToNull(district) != null
					&& StringUtils.trimToNull(city) != null;
		}

		public String getEmpCode() {
			return empCode;
		}

		public void setEmpCode(String empCode) {
			this.empCode = empCode;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getDistrict() {
			return district;
		}

		public void setDistrict(String district) {
			this.district = district;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getAddressType() {
			return addressType;
		}

		public void setAddressType(String addressType) {
			this.addressType = addressType;
		}

	}

}
