package vn.com.ecopharma.emp.dto;

import java.util.Date;

import vn.com.ecopharma.emp.constant.PromotedHistoryField;

import com.liferay.portal.kernel.search.Document;

public class PromotedHistoryIndexedItem extends BaseEmpInfoIndexedItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date promotedDate;

	private String comment;

	public PromotedHistoryIndexedItem(Document document) {
		super(document);
		promotedDate = checkNullFieldAndReturnNullDate(PromotedHistoryField.PROMOTED_DATE);
		comment = checkNullFieldAndReturnEmptyString(PromotedHistoryField.COMMENT);
	}

	public String getFormattedPromotedDate() {
		return getParseDateString(promotedDate);
	}

	public Date getPromotedDate() {
		return promotedDate;
	}

	public String getOldTitles() {
		return checkNullFieldAndReturnEmptyString(PromotedHistoryField.OLD_TITLES);
	}

	public String getNewTitles() {
		return checkNullFieldAndReturnEmptyString(PromotedHistoryField.NEW_TITLES);
	}

	public String getComment() {
		return comment;
	}

	public boolean isDeleted() {
		return checkNullFieldAndReturnEmptyString(
				PromotedHistoryField.IS_DELETED).equalsIgnoreCase("true");
	}

	public void setPromotedDate(Date promotedDate) {
		this.promotedDate = promotedDate;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	protected String getIdFieldName() {
		return PromotedHistoryField.ID;
	}

}
