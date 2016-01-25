package vn.com.ecopharma.hrm.tt.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.hrm.tt.constant.EmpField;

import com.liferay.portal.kernel.search.Document;

public class EmpTimeTrackingIndexedItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String EMPTY_TIME = "--:--";

	private static final String HOUR_MIN_FORMAT = "HH:mm";

	private Document employeeDocument;

	private Map<String, Date> minInMap;

	private Map<String, Date> maxOutMap;

	private Date grandTotalMinInTime;

	private Date grandTotalMaxOutTime;

	public EmpTimeTrackingIndexedItem(Document employeeDocument) {
		this.employeeDocument = employeeDocument;
	}

	public Document getEmployeeDocument() {
		return employeeDocument;
	}

	public void setEmployeeDocument(Document employeeDocument) {
		this.employeeDocument = employeeDocument;
	}

	/** GETTER & SETTER **/

	public long getEmployeeId() {
		return Long.valueOf(this.employeeDocument.getField(EmpField.EMP_ID)
				.getValue());
	}

	public String getEmployeeCode() {
		return employeeDocument.getField(EmpField.EMP_CODE) != null ? employeeDocument
				.getField(EmpField.EMP_CODE).getValue() : StringUtils.EMPTY;
	}

	public String getFullName() {
		return employeeDocument.getField(EmpField.VN_FULLNAME).getValue();
	}

	public long getDevisionId() {
		return Long.valueOf(employeeDocument.getField(EmpField.DEVISION_ID)
				.getValue());
	}

	public long getTitlesId() {
		return Long.valueOf(employeeDocument.getField(EmpField.TITLES_ID)
				.getValue());
	}

	public String getUnit() {
		return employeeDocument.getField(EmpField.UNIT) != null ? employeeDocument
				.getField(EmpField.UNIT).getValue() : StringUtils.EMPTY;
	}

	public String getDepartment() {
		return employeeDocument.getField(EmpField.DEPARTMENT) != null ? employeeDocument
				.getField(EmpField.DEPARTMENT).getValue() : StringUtils.EMPTY;
	}

	public String getDevision() {
		return employeeDocument.getField(EmpField.DEVISION) != null ? employeeDocument
				.getField(EmpField.DEVISION).getValue() : StringUtils.EMPTY;
	}

	public String getUnitGroup() {
		return employeeDocument.getField(EmpField.UNIT_GROUP) != null ? employeeDocument
				.getField(EmpField.UNIT_GROUP).getValue() : StringUtils.EMPTY;
	}

	public String getTitles() {
		return employeeDocument.getField(EmpField.TITLES).getValue();
	}

	public String getUnitName() {
		return employeeDocument.getField(EmpField.UNIT) != null ? employeeDocument
				.getField(EmpField.UNIT).getValue() : StringUtils.EMPTY;
	}

	public Map<String, Date> getMinInMap() {
		return minInMap;
	}

	public Map<String, Date> getMaxOutMap() {
		return maxOutMap;
	}

	public String getMinIn(String date) {
		return minInMap.get(date) != null ? new SimpleDateFormat(
				HOUR_MIN_FORMAT).format(getMinInMap().get(date)) : EMPTY_TIME;
	}

	public String getMaxOut(String date) {
		return maxOutMap.get(date) != null ? new SimpleDateFormat(
				HOUR_MIN_FORMAT).format(getMaxOutMap().get(date)) : EMPTY_TIME;
	}

	public void setMaxOutMap(Map<String, Date> maxOutMap) {
		this.maxOutMap = maxOutMap;
	}

	public void setMinInMap(Map<String, Date> minInMap) {
		this.minInMap = minInMap;
	}

	public String getGrandTotalMinIn() {
		return grandTotalMinInTime != null ? new SimpleDateFormat(
				HOUR_MIN_FORMAT).format(grandTotalMinInTime) : EMPTY_TIME;
	}

	public String getGrandTotalMaxOut() {
		return grandTotalMaxOutTime != null ? new SimpleDateFormat(
				HOUR_MIN_FORMAT).format(grandTotalMaxOutTime) : EMPTY_TIME;
	}

	public Date getGrandTotalMinInTime() {
		return grandTotalMinInTime;
	}

	public void setGrandTotalMinInTime(Date grandTotalMinInTime) {
		this.grandTotalMinInTime = grandTotalMinInTime;
	}

	public Date getGrandTotalMaxOutTime() {
		return grandTotalMaxOutTime;
	}

	public void setGrandTotalMaxOutTime(Date grandTotalMaxOutTime) {
		this.grandTotalMaxOutTime = grandTotalMaxOutTime;
	}
}
