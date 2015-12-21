package vn.com.ecopharma.hrm.tt.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.hrm.tt.constant.TimeTrackingField;

import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;

/**
 * @author TaoTran
 *
 */
public class TimeTrackingIndexItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String SOURCE_DATETIME_FORMAT = "yyyyMMddHHmmss";
	private static final String OUTPUT_DATE_FORMAT = "dd/MM/yyyy";
	private static final String TIME_FORMAT = "HH:mm";

	private Date in1;
	private Date out1;
	private Date in2;
	private Date out2;
	private Date in3;
	private Date out3;

	private Document document;

	private SimpleDateFormat sourceSdf = null;

	public TimeTrackingIndexItem(Document document) {
		this.document = document;
		this.in1 = parseDate(document.getField(TimeTrackingField.IN_1));
		this.out1 = parseDate(document.getField(TimeTrackingField.OUT_1));
		this.in2 = parseDate(document.getField(TimeTrackingField.IN_2));
		this.out2 = parseDate(document.getField(TimeTrackingField.OUT_2));
		this.in3 = parseDate(document.getField(TimeTrackingField.IN_3));
		this.out3 = parseDate(document.getField(TimeTrackingField.OUT_3));
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public long getId() {
		return Long.valueOf(document.getField(TimeTrackingField.ID).getValue());
	}

	public long getEmpId() {
		return Long.valueOf(document.getField(TimeTrackingField.EMP_ID)
				.getValue());
	}

	public String getFullName() {
		return document.getField(TimeTrackingField.FULLNAME).getValue();
	}

	public String getEmpCode() {
		return getStringFieldValue(TimeTrackingField.EMP_CODE);
	}

	public String getUnit() {
		return getStringFieldValue(TimeTrackingField.UNIT);
	}

	public String getTitles() {
		return getStringFieldValue(TimeTrackingField.TITLES);
	}

	private String getStringFieldValue(String fieldName) {
		return document.getField(fieldName) != null ? document.getField(
				fieldName).getValue() : StringUtils.EMPTY;
	}

	public Date getTrackingDate() {
		return parseDate(document.getField(TimeTrackingField.DATE));
	}

	public String getDateFormatted() {
		return new SimpleDateFormat(OUTPUT_DATE_FORMAT)
				.format(getTrackingDate());
	}

	public String getDay() {
		return new SimpleDateFormat("EEEE").format(getTrackingDate());
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
		return formattedTime(getIn1());
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

	public String getEmptyIn() {
		return document.get(TimeTrackingField.IS_EMPTY_IN);
	}

	public String getEmptyOut() {
		return document.get(TimeTrackingField.IS_EMPTY_OUT);
	}

	private SimpleDateFormat getSourceSdf() {
		if (sourceSdf == null)
			return new SimpleDateFormat(SOURCE_DATETIME_FORMAT);
		return sourceSdf;
	}

	private Date parseDate(Field field) {
		return field != null ? parseDate(field.getValue()) : null;
	}

	private Date parseDate(String value) {
		if (value == null || StringUtils.trimToNull(value) == null)
			return null;
		try {
			return getSourceSdf().parse(value);
		} catch (ParseException e) {
			LogFactoryUtil.getLog(TimeTrackingIndexItem.class).info(e);
		}
		return null;
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

}
