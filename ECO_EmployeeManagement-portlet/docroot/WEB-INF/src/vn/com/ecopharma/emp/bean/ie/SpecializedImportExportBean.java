package vn.com.ecopharma.emp.bean.ie;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import vn.com.ecopharma.emp.model.Specialized;
import vn.com.ecopharma.emp.service.SpecializedLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;
import vn.com.ecopharma.emp.util.ImportExportUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;

@ManagedBean(name = "specializedIEBean")
@ViewScoped
public class SpecializedImportExportBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final int START_ROW_NUM = 5;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(SpecializedImportExportBean.class);

	private static final int CODE_CELL = 1;
	private static final int NAME_CELL = 2;
	private static final int VOCATIONAL_CELL = 3;
	private static final int VOCATIONAL_COLLEGE_CELL = 4;
	private static final int COLLEGE_CELL = 5;
	private static final int UNIVERSITY_CELL = 6;
	private static final int LEVEL_CELL = 7;

	private static final String TICK_SIGN = "x";

	public void handleFileImport(FileUploadEvent fileUploadEvent) {
		InputStream is = null;
		try {
			final UploadedFile uploadedFile = fileUploadEvent.getFile();
			final ServiceContext serviceContext = EmployeeUtils
					.getServiceContext();
			is = uploadedFile.getInputstream();

			XSSFWorkbook wb = new XSSFWorkbook(is);
			final XSSFSheet sheet = wb.getSheetAt(0);

			Specialized rootLevel = null;
			Specialized secondLevel = null;
			for (int i = START_ROW_NUM; i <= sheet.getLastRowNum(); i++) {
				Row r = sheet.getRow(i);
				String code = ImportExportUtils.getReturnValueFromStringCell(r
						.getCell(CODE_CELL));
				String name = ImportExportUtils.getReturnValueFromStringCell(r
						.getCell(NAME_CELL));
				boolean isVocational = ImportExportUtils
						.getReturnValueFromStringCell(
								r.getCell(VOCATIONAL_CELL)).equalsIgnoreCase(
								TICK_SIGN) ? true : false;
				boolean isVocationalCollege = ImportExportUtils
						.getReturnValueFromStringCell(
								r.getCell(VOCATIONAL_COLLEGE_CELL))
						.equalsIgnoreCase(TICK_SIGN) ? true : false;
				boolean isCollege = ImportExportUtils
						.getReturnValueFromStringCell(r.getCell(COLLEGE_CELL))
						.equalsIgnoreCase(TICK_SIGN) ? true : false;
				boolean isUniversity = ImportExportUtils
						.getReturnValueFromStringCell(
								r.getCell(UNIVERSITY_CELL)).equalsIgnoreCase(
								TICK_SIGN) ? true : false;
				int level = ((Double) r.getCell(LEVEL_CELL)
						.getNumericCellValue()).intValue();
				if (level == 1) {
					rootLevel = SpecializedLocalServiceUtil.createSpecialized(
							code, name, level, 0L, isUniversity, isCollege,
							isVocationalCollege, isVocational, serviceContext);
					secondLevel = null;
				} else if (level == 2) {
					secondLevel = SpecializedLocalServiceUtil
							.createSpecialized(code, name, level,
									rootLevel.getSpecializedId(), isUniversity,
									isCollege, isVocationalCollege,
									isVocational, serviceContext);
				} else { // equals 3
					long parentId = secondLevel != null ? secondLevel
							.getSpecializedId() : rootLevel.getSpecializedId();
					SpecializedLocalServiceUtil.createSpecialized(code, name,
							level, parentId, isUniversity, isCollege,
							isVocationalCollege, isVocational, serviceContext);
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
}
