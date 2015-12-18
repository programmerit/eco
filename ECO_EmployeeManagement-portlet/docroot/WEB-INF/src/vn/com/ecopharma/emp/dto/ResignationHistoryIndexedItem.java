package vn.com.ecopharma.emp.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import vn.com.ecopharma.emp.constant.ResignationHistoryField;

import com.liferay.portal.kernel.search.Document;

public class ResignationHistoryIndexedItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Document document;

	public ResignationHistoryIndexedItem(Document document) {
		this.document = document;
	}

	public long getResignationHistoryId() {
		return Long.valueOf(document.getField(ResignationHistoryField.ID)
				.getValue());
	}

	public long getEmployeeId() {
		return Long.valueOf(document.getField(
				ResignationHistoryField.EMPLOYEE_ID).getValue());
	}

	public String getFullName() {
		return document.getField(ResignationHistoryField.FULLNAME).getValue();
	}

	public String getTitles() {
		return document.getField(ResignationHistoryField.TITLES).getValue();
	}

	public Date getResignedDate() {
		try {
			return document.getDate(ResignationHistoryField.RESIGNED_DATE);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getResignedReason() {
		return document.getField(ResignationHistoryField.RESIGNED_TYPE)
				.getValue();
	}

	public String getComment() {
		return document.getField(ResignationHistoryField.COMMENT) != null ? document
				.getField(ResignationHistoryField.COMMENT).getValue() : "N/A";
	}

	public boolean isDeleted() {
		return document.getField(ResignationHistoryField.IS_DELETED).getValue()
				.equalsIgnoreCase("true");
	}

}
