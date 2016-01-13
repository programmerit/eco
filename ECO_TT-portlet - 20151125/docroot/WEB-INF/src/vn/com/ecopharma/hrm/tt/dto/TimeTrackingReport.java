package vn.com.ecopharma.hrm.tt.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class TimeTrackingReport {
	private long empId;
	private String fullName;
	private String empCode;
	private static final String TIME_FORMAT = "HH:mm";

	private Map<String, SourceTimeItem> sourceTimeMap;

	public TimeTrackingReport(long empId, String fullName, String empCode,
			Map<String, SourceTimeItem> sourceTimeMap) {
		this.empId = empId;
		this.fullName = fullName;
		this.empCode = empCode;
		this.sourceTimeMap = sourceTimeMap;
	}

	/**
	 * @param date
	 * @return
	 */
	public String getMinIn(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
		Date in = sourceTimeMap.get(date) != null ? sourceTimeMap.get(date)
				.getIn1() : null;
		return in != null ? sdf.format(in) : "--:--";
	}

	/**
	 * @param date
	 * @return
	 */
	public String getMaxOut(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
		SourceTimeItem sourceTimeItem = sourceTimeMap.get(date);
		Date maxOut = null;
		if (sourceTimeItem != null)

			if (sourceTimeItem.getOut3() != null) {
				maxOut = sourceTimeItem.getOut3();
			} else if (sourceTimeItem.getOut2() != null) {
				maxOut = sourceTimeItem.getOut2();
			} else if (sourceTimeItem.getIn2() != null
					&& sourceTimeItem.getOut2() == null) {
				maxOut = sourceTimeItem.getIn2();
			} else if (sourceTimeItem.getOut1() != null) {
				maxOut = sourceTimeItem.getOut1();
			}

		return maxOut != null ? sdf.format(maxOut) : "--:--";
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public Map<String, SourceTimeItem> getSourceTimeMap() {
		return sourceTimeMap;
	}

	public void setSourceTimeMap(Map<String, SourceTimeItem> sourceTimeMap) {
		this.sourceTimeMap = sourceTimeMap;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}
}
