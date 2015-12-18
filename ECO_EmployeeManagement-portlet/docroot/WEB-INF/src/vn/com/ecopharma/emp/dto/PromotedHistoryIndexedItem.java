package vn.com.ecopharma.emp.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import vn.com.ecopharma.emp.constant.PromotedHistoryField;

import com.liferay.portal.kernel.search.Document;

public class PromotedHistoryIndexedItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Document document;

	public PromotedHistoryIndexedItem(Document document) {
		this.document = document;
	}

	public long getPromotedHistoryId() {
		return Long.valueOf(document.getField(PromotedHistoryField.ID)
				.getValue());
	}

	public long getEmployeeId() {
		return Long.valueOf(document.getField(PromotedHistoryField.EMPLOYEE_ID)
				.getValue());
	}

	public String getFullName() {
		return document.getField(PromotedHistoryField.FULLNAME).getValue();
	}

	public Date getPromotedDate() {
		try {
			return document.getDate(PromotedHistoryField.PROMOTED_DATE);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getOldTitles() {
		return document.getField(PromotedHistoryField.OLD_TITLES).getValue();
	}

	public String getNewTitles() {
		return document.getField(PromotedHistoryField.NEW_TITLES).getValue();
	}

	public String getComment() {
		return document.getField(PromotedHistoryField.COMMENT) != null ? document
				.getField(PromotedHistoryField.COMMENT).getValue() : "N/A";
	}

	public boolean isDeleted() {
		return document.getField(PromotedHistoryField.IS_DELETED).getValue()
				.equalsIgnoreCase("true");
	}

}
