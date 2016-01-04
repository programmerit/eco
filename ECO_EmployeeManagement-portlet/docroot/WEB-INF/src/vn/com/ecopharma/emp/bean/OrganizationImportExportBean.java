package vn.com.ecopharma.emp.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import vn.com.ecopharma.emp.dto.OrganizationItem;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;

@ManagedBean(name = "orgIEBean")
@ViewScoped
public class OrganizationImportExportBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(OrganizationImportExportBean.class);

	public void handleFileImport(FileUploadEvent fileUploadEvent) {
		final ServiceContext serviceContext = LiferayFacesContext.getInstance()
				.getServiceContext();
		final UploadedFile uploadedFile = fileUploadEvent.getFile();
		try {
			final XSSFWorkbook wb = new XSSFWorkbook(
					uploadedFile.getInputstream());
			final XSSFSheet sheet = wb.getSheetAt(3);
			List<OrganizationItem> items = new ArrayList<>();
			for (int i = 4; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row.getCell(1) != null
						&& !StringUtils.EMPTY.equalsIgnoreCase(row.getCell(1)
								.getStringCellValue()))
					items.add(new OrganizationItem(sheet.getRow(i)));
			}
			Devision devision = null;
			String devisionName = StringUtils.EMPTY;

			Department department = null;
			String departmentName = StringUtils.EMPTY;

			String unitName = StringUtils.EMPTY;
			for (OrganizationItem item : items) {
				// check if previous devision existed or not
				if (!item.getDevision().equalsIgnoreCase(devisionName)) { // not
					Devision checkDevision = DevisionLocalServiceUtil
							.findByName(item.getDevision()); // existed
					devision = checkDevision == null ? DevisionLocalServiceUtil
							.addDevision(item.getDevision(), serviceContext)
							: checkDevision;
					devisionName = devision.getName();
				}

				// check if previous department existed or not
				if (!item.getDepartment().equalsIgnoreCase(departmentName)) { // not
																				// existed
					Department checkDepartment = DepartmentLocalServiceUtil
							.findByNameAndDevision(item.getDepartment(),
									devision.getDevisionId());
					department = checkDepartment == null ? DepartmentLocalServiceUtil
							.addDepartment(item.getDepartment(),
									devision.getDevisionId(), serviceContext)
							: checkDepartment;
				}

				// check if previous unit existed or not
				if (item.getUnit() != null
						&& !item.getUnit().equalsIgnoreCase(unitName)) {
					Unit checkUnit = UnitLocalServiceUtil
							.findByNameAndDepartment(item.getUnit(),
									department.getDepartmentId());

					Unit unit = checkUnit == null ? UnitLocalServiceUtil
							.addUnit(item.getUnit(),
									department.getDepartmentId(),
									serviceContext) : checkUnit;
					unitName = unit.getName();
				}

				TitlesLocalServiceUtil.addTitles(item.getViTitles(),
						department.getDepartmentId(), item.getEnTitles(),
						item.getTitlesCode(), serviceContext);

			}
			FacesMessage message = new FacesMessage("Notice",
					"Sucessfully Imported");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (IOException e) {
			LOGGER.info(e);
		} catch (Exception e) {
			LOGGER.info(e);
		}
	}
}
