package vn.com.ecopharma.emp.dto;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class OrganizationItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(OrganizationItem.class);

	private static final int DEVISION_CELL = 1;
	private static final int DEPARTMENT_CELL = 2;
	private static final int UNIT_CELL = 3;
	private static final int UNIT_GROUP_CELL = 4;
	private static final int VI_TITLES_CELL = 5;
	private static final int EN_TITLES_CELL = 6;
	private static final int TITLES_CODE_CELL = 7;

	private String devision;
	private String department;
	private String unit;
	private String unitGroup;
	private String viTitles;
	private String enTitles;
	private String titlesCode;

	public OrganizationItem(String devision, String department, String unit,
			String unitGroup, String viTitles, String enTitles,
			String titlesCode) {
		this.devision = devision;
		this.department = department;
		this.unit = unit;
		this.unitGroup = unitGroup;
		this.viTitles = viTitles;
		this.enTitles = enTitles;
		this.titlesCode = titlesCode;
	}

	public OrganizationItem(Row row) {
		this.bindFieldsFromRow(row);
	}

	private void bindFieldsFromRow(Row row) {
		this.devision = row.getCell(DEVISION_CELL).getStringCellValue();
		this.department = row.getCell(DEPARTMENT_CELL).getStringCellValue();
		this.unit = isValidStringCell(row.getCell(UNIT_CELL)) ? row.getCell(
				UNIT_CELL).getStringCellValue() : null;
		this.unitGroup = isValidStringCell(row.getCell(UNIT_GROUP_CELL)) ? row
				.getCell(UNIT_GROUP_CELL).getStringCellValue() : null;
		this.viTitles = row.getCell(VI_TITLES_CELL).getStringCellValue();
		this.enTitles = row.getCell(EN_TITLES_CELL) != null ? row.getCell(
				EN_TITLES_CELL).getStringCellValue() : StringUtils.EMPTY;
		this.titlesCode = row.getCell(TITLES_CODE_CELL) != null ? row.getCell(
				TITLES_CODE_CELL).getStringCellValue() : StringUtils.EMPTY;

		LOGGER.info("devision: " + this.devision + "department: "
				+ this.department + "unit: " + this.unit + "titles: "
				+ this.enTitles);
	}

	private static boolean isValidStringCell(Cell cell) {
		return cell != null && cell.getCellType() == 1
				&& StringUtils.trimToNull(cell.getStringCellValue()) != null;
	}

	public String getDevision() {
		return devision;
	}

	public void setDevision(String devision) {
		this.devision = devision;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnitGroup() {
		return unitGroup;
	}

	public void setUnitGroup(String unitGroup) {
		this.unitGroup = unitGroup;
	}

	public String getViTitles() {
		return viTitles;
	}

	public void setViTitles(String viTitles) {
		this.viTitles = viTitles;
	}

	public String getEnTitles() {
		return enTitles;
	}

	public void setEnTitles(String enTitles) {
		this.enTitles = enTitles;
	}

	public String getTitlesCode() {
		return titlesCode;
	}

	public void setTitlesCode(String titlesCode) {
		this.titlesCode = titlesCode;
	}
}
