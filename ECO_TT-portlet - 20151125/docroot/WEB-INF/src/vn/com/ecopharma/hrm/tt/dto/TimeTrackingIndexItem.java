package vn.com.ecopharma.hrm.tt.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.hrm.tt.constant.TimeTrackingField;

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
	private static final String SOURCE_DATETIME_FORMAT = "yyyyMMddhhmmss";
	private static final String OUTPUT_DATE_FORMAT = "dd/MM/yyyy";
	private static final String TIME_FORMAT = "HH:mm";

	private Document document;

	private SimpleDateFormat sourceSdf = null;

	public TimeTrackingIndexItem() {

	}

	public TimeTrackingIndexItem(Document document) {
		this.document = document;
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
		return document.getField(TimeTrackingField.EMP_CODE).getValue();
	}

	public String getUnit() {
		return document.getField(TimeTrackingField.UNIT).getValue();
	}

	public String getTitles() {
		return document.getField(TimeTrackingField.TITLES).getValue();
	}

	public Date getDate() {
		return parseDate(document.getField(TimeTrackingField.DATE));
	}

	public String getDateFormatted() {
		return new SimpleDateFormat(OUTPUT_DATE_FORMAT).format(getDate());
	}

	public String getDay() {
		return new SimpleDateFormat("EEEE").format(getDate());
	}

	public Date getIn1() {
		return parseDate(document.getField(TimeTrackingField.IN_1));
	}

	public String getIn1Formatted() {
		return formattedTime(getIn1());
	}

	public Date getIn2() {
		return parseDate(document.getField(TimeTrackingField.IN_2));
	}

	public String getIn2Formatted() {
		return formattedTime(getIn2());
	}

	public Date getIn3() {
		return parseDate(document.getField(TimeTrackingField.IN_3));
	}

	public String getIn3Formatted() {
		return formattedTime(getIn3());
	}

	public Date getOut1() {
		return parseDate(document.getField(TimeTrackingField.OUT_1));
	}

	public String getOut1Formatted() {
		return formattedTime(getOut1());
	}

	public Date getOut2() {
		return parseDate(document.getField(TimeTrackingField.OUT_2));
	}

	public String getOut2Formatted() {
		return formattedTime(getOut2());
	}

	public Date getOut3() {
		return parseDate(document.getField(TimeTrackingField.OUT_3));
	}

	public String getOut3Formatted() {
		return formattedTime(getOut3());
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
			e.printStackTrace();
		}
		return null;
	}

	private String formattedTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
		return date == null ? StringUtils.EMPTY : sdf.format(date);
	}

}
