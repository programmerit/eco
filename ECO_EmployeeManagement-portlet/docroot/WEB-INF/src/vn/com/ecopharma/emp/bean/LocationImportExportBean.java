package vn.com.ecopharma.emp.bean;

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
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import vn.com.ecopharma.emp.service.DistrictLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;
import vn.com.ecopharma.emp.util.ImportExportUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.ServiceContext;

@ManagedBean(name = "locationIEBean")
@ViewScoped
public class LocationImportExportBean {

	private static final int START_ROW_NUM = 2;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(LocationImportExportBean.class);

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
			final List<Region> allVNRegions = ImportExportUtils
					.getAllVNRegions();
			is = uploadedFile.getInputstream();

			XSSFWorkbook wb = new XSSFWorkbook(is);
			final XSSFSheet sheet = wb.getSheetAt(2);
			List<LocationItem> items = new ArrayList<>();
			for (int i = START_ROW_NUM; i <= sheet.getLastRowNum(); i++) {
				final LocationItem item = new LocationItem(sheet.getRow(i)) {

					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					protected List<Region> getRegionList() {
						return allVNRegions;
					}
				};
				items.add(item);
			}

			for (LocationItem item : items) {
				if (item.isValid()
						&& DistrictLocalServiceUtil.findByRegionCodeAndName(
								item.getRegion().getRegionCode(),
								item.getName()) == null) {
					DistrictLocalServiceUtil.addDistrict(item.getName(), item
							.getRegion().getRegionCode(), serviceContext);
				} else {
					LOGGER.info(item.getName() + "  " + item.getRegionName());
				}

			}

		} catch (IOException e) {
			LOGGER.info(e);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				LOGGER.info(e);
			}
		}
	}

	public abstract class LocationItem implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private static final int NAME_CELL = 1;
		private static final int REGION_NAME_CELL = 2;

		private String name;

		private String regionName;

		public LocationItem(String name, String regionName) {
			this.name = name;
			this.regionName = regionName;
		}

		public LocationItem(Row row) {
			bindFields(row);
		}

		private void bindFields(Row row) {
			this.name = ImportExportUtils.getReturnValueFromStringCell(row
					.getCell(NAME_CELL));
			this.regionName = ImportExportUtils
					.getReturnValueFromStringCell(row.getCell(REGION_NAME_CELL));
		}

		public Region getRegion() {
			return ImportExportUtils.getRegionFromListByName(getRegionList(),
					this.regionName);
		}

		public boolean isValid() {
			return StringUtils.trimToNull(this.name) != null
					&& getRegion() != null;
		}

		protected abstract List<Region> getRegionList();

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getRegionName() {
			return regionName;
		}

		public void setRegionName(String regionName) {
			this.regionName = regionName;
		}
	}
}
