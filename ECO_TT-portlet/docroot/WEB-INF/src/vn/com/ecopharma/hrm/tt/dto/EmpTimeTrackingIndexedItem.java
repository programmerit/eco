package vn.com.ecopharma.hrm.tt.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import vn.com.ecopharma.hrm.tt.constant.EmpField;

import com.liferay.portal.kernel.search.Document;

public class EmpTimeTrackingIndexedItem extends BaseEmpInfoIndexedItem {

	private static final long serialVersionUID = 1L;

	private static final String EMPTY_TIME = "--:--";

	private static final String HOUR_MIN_FORMAT = "HH:mm";

	private Map<String, ReportTimeItem> reportTimeMap;

	private Date grandTotalMinInTime;

	private Date grandTotalMaxOutTime;

	public EmpTimeTrackingIndexedItem(Document document) {
		super(document);
	}

	/** GETTER & SETTER **/

	public Map<String, ReportTimeItem> getReportTimeMap() {
		return reportTimeMap;
	}

	public void setReportTimeMap(Map<String, ReportTimeItem> reportTimeMap) {
		this.reportTimeMap = reportTimeMap;
	}

	public ReportTimeItem getReportTimeItem(String date) {
		return reportTimeMap.get(date);
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

	@Override
	protected String getIdFieldName() {
		return EmpField.EMP_ID;
	}
}
