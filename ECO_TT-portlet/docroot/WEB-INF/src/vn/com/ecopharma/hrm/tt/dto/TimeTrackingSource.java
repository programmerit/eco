package vn.com.ecopharma.hrm.tt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;

import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

/**
 * Created by TaoTran on 11/19/2015.
 */
public class TimeTrackingSource implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int no;
	private String unit;
	private String empCode;
	private String fullName;
	private String titles;

	private List<SourceTimeItem> timeItems;

	public TimeTrackingSource(int no, String unit, String empCode,
			String fullName, List<SourceTimeItem> timeItems) {
		this.no = no;
		this.unit = unit;
		this.empCode = empCode;
		this.fullName = fullName;
		this.timeItems = timeItems;
	}

	public TimeTrackingSource(Row row) {
		this.timeItems = new ArrayList<>();
		this.bindRowToObjectFields(row);
	}

	private void bindRowToObjectFields(Row row) {
		this.no = new Double(row.getCell(0).getNumericCellValue()).intValue();
		this.unit = StringUtils.trim(row.getCell(1).toString());
		this.empCode = StringUtils.trim(row.getCell(2).toString());
		row.getCell(2).setCellType(1);
		this.empCode = TTUtils.getActualEmpCode(row.getCell(2).toString());
		this.fullName = StringUtils.trim(row.getCell(3).toString());
		this.titles = StringUtils.trim(row.getCell(4).toString());
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<SourceTimeItem> getTimeItems() {
		return timeItems;
	}

	public void setTimeItems(List<SourceTimeItem> timeItems) {
		this.timeItems = timeItems;
	}

	public Emp getEmp() {
		if (StringUtils.trimToNull(empCode) == null) {
			return null;
		}
		return EmpLocalServiceUtil.findByEmpCode(empCode);
	}

	@Override
	public String toString() {
		return "TimeTrackingSource{" + "no=" + no + ", unit='" + unit + '\''
				+ ", empCode='" + empCode + '\'' + ", fullName='" + fullName
				+ '\'' + ", titles='" + titles + '\'' + ", timeItems="
				+ timeItems + '}';
	}
}
