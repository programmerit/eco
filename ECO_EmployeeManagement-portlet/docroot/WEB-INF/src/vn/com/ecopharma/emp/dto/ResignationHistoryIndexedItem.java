package vn.com.ecopharma.emp.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import vn.com.ecopharma.emp.constant.ResignationHistoryField;

import com.liferay.portal.kernel.search.Document;

public class ResignationHistoryIndexedItem extends BaseEmpInfoIndexedItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DATETIME_FORMAT = "dd/MM/yyyy";

	private Date resignedDate;
	private String comment;
	private String resignedType;

	public ResignationHistoryIndexedItem(Document document) {
		super(document);
		this.resignedType = checkNullFieldAndReturnEmptyString(ResignationHistoryField.RESIGNED_TYPE);
		this.comment = checkNullFieldAndReturnEmptyString(ResignationHistoryField.COMMENT);
		this.resignedDate = checkNullFieldAndReturnNullDate(ResignationHistoryField.RESIGNED_DATE);
	}

	public Date getResignedDate() {
		return resignedDate;
	}

	public String getResignedDateString() {
		final SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
		return resignedDate != null ? sdf.format(resignedDate)
				: StringUtils.EMPTY;
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
		return "true".equalsIgnoreCase(getDocument().getField(
				ResignationHistoryField.IS_DELETED).getValue());
	}

	@Override
	protected String getIdFieldName() {
		return ResignationHistoryField.ID;
	}

}
