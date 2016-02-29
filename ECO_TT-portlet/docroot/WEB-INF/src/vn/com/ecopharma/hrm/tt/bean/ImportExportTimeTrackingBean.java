package vn.com.ecopharma.hrm.tt.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import vn.com.ecopharma.hrm.tt.dto.SourceTimeItem;
import vn.com.ecopharma.hrm.tt.dto.TimeTrackingSource;
import vn.com.ecopharma.hrm.tt.model.TimeTracking;
import vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@ManagedBean
@ViewScoped
public class ImportExportTimeTrackingBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int START_ROW_NUM = 5;
	private static final int START_CELL_NUM = 0;

	private String sheetNameOrIndex = "1";

	public void handleFileImport(FileUploadEvent event) {
		try {
			final UploadedFile uploadedFile = event.getFile();
			final InputStream is = uploadedFile.getInputstream();

			final XSSFWorkbook wb = new XSSFWorkbook(is);
			final XSSFSheet sheet = wb.getSheetAt(0);
			final List<TimeTrackingSource> timeTrackingSources = new LinkedList<>();
			for (int i = START_ROW_NUM; i <= sheet.getLastRowNum(); i++) {
				final Row row = sheet.getRow(i);
				if (row != null && row.getCell(START_CELL_NUM) != null) {
					// format employee code cell as String
					row.getCell(2).setCellType(1);
					final String empCode = TTUtils.getActualEmpCode(row
							.getCell(2).toString());

					final TimeTrackingSource lastTrackingSource = !timeTrackingSources
							.isEmpty() ? timeTrackingSources
							.get(timeTrackingSources.size() - 1) : null;
					if (lastTrackingSource != null
							&& isExistedTimeTrackingSource(lastTrackingSource,
									empCode)) {
						lastTrackingSource.getTimeItems().add(
								new SourceTimeItem(row));
					} else {
						final TimeTrackingSource trackingSourceObject = new TimeTrackingSource(
								sheet.getRow(i));
						LogFactoryUtil.getLog(
								ImportExportTimeTrackingBean.class).info(
								trackingSourceObject.toString());
						trackingSourceObject.getTimeItems().add(
								new SourceTimeItem(row));
						timeTrackingSources.add(trackingSourceObject);
					}
				}
			}

			for (TimeTrackingSource timeTrackingSource : timeTrackingSources) {
				LogFactoryUtil.getLog(ImportExportTimeTrackingBean.class).info(
						timeTrackingSource);
				if (timeTrackingSource.getEmp() != null) {
					for (SourceTimeItem item : timeTrackingSource
							.getTimeItems()) {
						LogFactoryUtil.getLog(
								ImportExportTimeTrackingBean.class).info(item);
						final TimeTracking checkedTimeTracking = TimeTrackingLocalServiceUtil
								.findByEmpAndDate(timeTrackingSource.getEmp()
										.getEmpId(), item.getDate());
						if (checkedTimeTracking == null) {
							TimeTrackingLocalServiceUtil.addTimeTracking(
									timeTrackingSource.getEmp().getEmpId(),
									item.getDate(), item.getIn1(), item
											.getOut1(), item.getIn2(), item
											.getOut2(), item.getIn3(), item
											.getOut3(), 0L, LiferayFacesContext
											.getInstance().getServiceContext());
						} else {
							TimeTrackingLocalServiceUtil.updateTimeTracking(
									checkedTimeTracking.getTimeTrackingId(),
									item.getIn1(), item.getOut1(),
									item.getIn2(), item.getOut2(),
									item.getIn3(), item.getOut3());
						}
					}
				}
			}

		} catch (IOException e) {
			LogFactoryUtil.getLog(ImportExportTimeTrackingBean.class).info(
					"Error while executing import data", e);
		}

	}

	public void completelyRemoveAllTimeTrackings() {
		TimeTrackingLocalServiceUtil.completelyRemoveAllTimeTrackings();
	}

	private static boolean isExistedTimeTrackingSource(
			TimeTrackingSource timeTrackingSource, String empCode) {
		return timeTrackingSource.getEmpCode().equalsIgnoreCase(empCode);
	}

	public String getSheetNameOrIndex() {
		return sheetNameOrIndex;
	}

	public void setSheetNameOrIndex(String sheetNameOrIndex) {
		this.sheetNameOrIndex = sheetNameOrIndex;
	}
}
