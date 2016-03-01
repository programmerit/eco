package vn.com.ecopharma.hrm.tt.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import vn.com.ecopharma.hrm.tt.constant.TimeTrackingField;
import vn.com.ecopharma.hrm.tt.constant.VacationLeaveField;

import com.liferay.portal.kernel.search.Document;

/**
 * @author TaoTran
 *
 */
public class TimeTrackingIndexItem extends BaseEmpInfoIndexedItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TIME_FORMAT = "HH:mm";
	private static final String DAY_FORMAT = "EEE";

	private Date in1;
	private Date out1;
	private Date in2;
	private Date out2;
	private Date in3;
	private Date out3;

	private Document document;

	public TimeTrackingIndexItem(Document document) {
		super(document);
		this.in1 = checkNullFieldAndReturnNullDate(TimeTrackingField.IN_1);
		this.out1 = checkNullFieldAndReturnNullDate(TimeTrackingField.OUT_1);
		this.in2 = checkNullFieldAndReturnNullDate(TimeTrackingField.IN_2);
		this.out2 = checkNullFieldAndReturnNullDate(TimeTrackingField.OUT_2);
		this.in3 = checkNullFieldAndReturnNullDate(TimeTrackingField.IN_3);
		this.out3 = checkNullFieldAndReturnNullDate(TimeTrackingField.OUT_3);

	}

	public long getVacationLeaveId() {
		return checkNullFieldAndReturnLongValue(VacationLeaveField.ID);
	}

	public boolean isVacationLeaveApplied() {
		return getVacationLeaveId() != 0;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Date getTrackingDate() {
		return checkNullFieldAndReturnNullDate(TimeTrackingField.DATE);
	}

	public String getDateFormatted() {
		return getParseDateString(getTrackingDate());

	}

	public String getDay() {
		return new SimpleDateFormat(DAY_FORMAT).format(getTrackingDate());
	}

	public Date getIn1() {
		return in1;
	}

	public void setIn1(Date in1) {
		this.in1 = in1;
	}

	public Date getOut1() {
		return out1;
	}

	public void setOut1(Date out1) {
		this.out1 = out1;
	}

	public Date getIn2() {
		return in2;
	}

	public void setIn2(Date in2) {
		this.in2 = in2;
	}

	public Date getOut2() {
		return out2;
	}

	public void setOut2(Date out2) {
		this.out2 = out2;
	}

	public Date getIn3() {
		return in3;
	}

	public void setIn3(Date in3) {
		this.in3 = in3;
	}

	public Date getOut3() {
		return out3;
	}

	public void setOut3(Date out3) {
		this.out3 = out3;
	}

	public String getIn1Formatted() {
		return isVacationLeaveApplied() ? "Leave" : formattedTime(getIn1());
	}

	public String getIn2Formatted() {
		return formattedTime(getIn2());
	}

	public String getIn3Formatted() {
		return formattedTime(getIn3());
	}

	public String getOut1Formatted() {
		return formattedTime(getOut1());
	}

	public String getOut2Formatted() {
		return formattedTime(getOut2());
	}

	public String getOut3Formatted() {
		return formattedTime(getOut3());
	}

	// public String getEmptyIn() {
	// return document.get(TimeTrackingField.IS_EMPTY_IN);
	// }
	//
	// public String getEmptyOut() {
	// return document.get(TimeTrackingField.IS_EMPTY_OUT);
	// }

	public String getEmpCode() {
		return super.getEmployeeCode();
	}

	private static String formattedTime(Date date) {
		return date == null ? "--:--" : new SimpleDateFormat(TIME_FORMAT)
				.format(date);
	}

	@Override
	public String toString() {
		return getFullName() + " " + getDateFormatted() + "  "
				+ getIn1Formatted() + "  " + getOut2Formatted();
	}

	@Override
	protected String getIdFieldName() {
		return TimeTrackingField.ID;
	}

}
