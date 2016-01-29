package vn.com.ecopharma.emp.dto;

import java.util.Date;

import vn.com.ecopharma.emp.constant.EmpDisciplineField;

import com.liferay.portal.kernel.search.Document;

public class EmpDisciplineIndexedItem extends BaseEmpInfoIndexedItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String content;
	private String type;
	private Date effectiveDate;
	private String additionalType;
	private String desc;

	public EmpDisciplineIndexedItem(Document document) {
		super(document);
		this.content = checkNullFieldAndReturnEmptyString(EmpDisciplineField.CONTENT);
		this.type = checkNullFieldAndReturnEmptyString(EmpDisciplineField.TYPE);
		this.effectiveDate = checkNullFieldAndReturnNullDate(EmpDisciplineField.EFFECTIVE_DATE);
		this.additionalType = checkNullFieldAndReturnEmptyString(EmpDisciplineField.ADDITIONAL_DISCIPLINE);
		this.desc = checkNullFieldAndReturnEmptyString(EmpDisciplineField.DESC);
	}

	@Override
	protected String getIdFieldName() {
		return EmpDisciplineField.ID;
	}

	public String getContent() {
		return content;
	}

	public String getType() {
		return type;
	}

	public String getEffectiveDateString() {
		return getParseDateString(effectiveDate);
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public String getAdditionalType() {
		return additionalType;
	}

	public String getDesc() {
		return desc;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public void setAdditionalType(String additionalType) {
		this.additionalType = additionalType;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
