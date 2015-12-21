package vn.com.ecopharma.hrm.rc.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFRow;

import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;

public class VacancyImportExportDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String vacancyCode;
	private String name;
	private int numberOfPosition;
	private String subUnit;
	private String titles;
	private String description;
	private Date postedDate;
	private Date expiredDate;
	private String status;

	/* */
	private long subUnitId;
	private long titlesId;

	public VacancyImportExportDTO() {

	}

	public VacancyImportExportDTO(XSSFRow r) {
		this.bindFieldsFromExcelRow(r);
	}

	private void bindFieldsFromExcelRow(XSSFRow r) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			vacancyCode = r.getCell(1).getStringCellValue();
			name = r.getCell(2).getStringCellValue();
			numberOfPosition = (int) r.getCell(3).getNumericCellValue();
			subUnit = r.getCell(4).getStringCellValue();
			titles = r.getCell(5).getStringCellValue();
			description = r.getCell(6).getStringCellValue();

			postedDate = sdf.parse(r.getCell(7).getStringCellValue());

			expiredDate = sdf.parse(r.getCell(8).getStringCellValue());
			status = r.getCell(9).getStringCellValue();

			/* */
			this.titlesId = TitlesLocalServiceUtil.findByName(titles)
					.getTitlesId();
			// this.subUnitId = SubUnitLocalServiceUtil.findByName(subUnit)
			// .getSubUnitId();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Vacancy createPrePersistedCandidate() {
		Vacancy vacancy = VacancyLocalServiceUtil.createPrePersistedVacancy(
				vacancyCode, name, numberOfPosition, titlesId, description,
				postedDate, expiredDate, status);
		return vacancy;
	}

	public boolean isExistedVacancy() {
		// return
		// VacancyLocalServiceUtil.findByNameAndSubUnitAndTitles(this.name,
		// this.subUnitId, this.titlesId) != null;
		return false;
	}

	public String getVacancyCode() {
		return vacancyCode;
	}

	public void setVacancyCode(String vacancyCode) {
		this.vacancyCode = vacancyCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfPosition() {
		return numberOfPosition;
	}

	public void setNumberOfPosition(int numberOfPosition) {
		this.numberOfPosition = numberOfPosition;
	}

	public String getSubUnit() {
		return subUnit;
	}

	public void setSubUnit(String subUnit) {
		this.subUnit = subUnit;
	}

	public String getTitles() {
		return titles;
	}

	public void setTitles(String titles) {
		this.titles = titles;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getSubUnitId() {
		return subUnitId;
	}

	public void setSubUnitId(long subUnitId) {
		this.subUnitId = subUnitId;
	}

	public long getTitlesId() {
		return titlesId;
	}

	public void setTitlesId(long titlesId) {
		this.titlesId = titlesId;
	}

}
