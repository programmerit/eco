package vn.com.ecopharma.emp.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import vn.com.ecopharma.emp.constant.ResignationHistoryField;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;

public class ResignationHistoryIndexedItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactoryUtil
			.getLog(ResignationHistoryIndexedItem.class);

	private Date resignedDate;
	private String comment;
	private String resignedType;

	private Document document;

	public ResignationHistoryIndexedItem(Document document) {
		this.document = document;
		this.resignedType = document
				.getField(ResignationHistoryField.RESIGNED_TYPE) != null ? document
				.getField(ResignationHistoryField.RESIGNED_TYPE).getValue()
				: StringUtils.EMPTY;
		this.comment = document.getField(ResignationHistoryField.COMMENT) != null ? document
				.getField(ResignationHistoryField.COMMENT).getValue() : "N/A";
		try {
			this.resignedDate = document
					.getDate(ResignationHistoryField.RESIGNED_DATE);
		} catch (ParseException e) {
			LOGGER.info(e);
		}
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
		return resignedDate;
	}

	public String getResignedType() {
		return resignedType;
	}

	public String getComment() {
		return comment;
	}

	public void setResignedType(String resignedType) {
		this.resignedType = resignedType;
	}

	public void setResignedDate(Date resignedDate) {
		this.resignedDate = resignedDate;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isDeleted() {
		return "true".equalsIgnoreCase(document.getField(
				ResignationHistoryField.IS_DELETED).getValue());
	}

}
