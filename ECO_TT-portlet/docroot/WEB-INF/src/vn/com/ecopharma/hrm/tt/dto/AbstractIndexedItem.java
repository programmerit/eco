package vn.com.ecopharma.hrm.tt.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;

public abstract class AbstractIndexedItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String SOURCE_DATETIME_FORMAT = "yyyyMMddhhmmss";
	private static final String DESTINATION_DATETIME_FORMAT = "dd/MM/yyyy";

	protected static final Log LOGGER = LogFactoryUtil
			.getLog(AbstractIndexedItem.class);

	private Document document;

	public AbstractIndexedItem() {
		throw new IllegalStateException();
	}

	public AbstractIndexedItem(Document document) {
		this.document = document;
	}

	public long getId() {
		return Long.valueOf(document.getField(getIdFieldName()).getValue());
	}

	public String getIdAsString() {
		return String.valueOf(getId());
	}

	protected abstract String getIdFieldName();

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	protected String checkNullFieldAndReturnEmptyString(String stringField) {
		return document.getField(stringField) != null ? document.getField(
				stringField).getValue() : StringUtils.EMPTY;
	}

	protected Date checkNullFieldAndReturnNullDate(String dateField) {
		try {
			return document.getField(dateField) != null ? document
					.getDate(dateField) : null;
		} catch (ParseException e) {
			LOGGER.info(e);
		}
		return null;
	}

	protected Long checkNullFieldAndReturnLongValue(String longField) {
		return document.getField(longField) != null ? Long.valueOf(document
				.getField(longField).getValue()) : 0L;
	}

	protected Double checkNullFieldAndReturnDoubleValue(String doubleField) {
		return document.getField(doubleField) != null ? Double.valueOf(document
				.getField(doubleField).getValue()) : 0D;
	}

	protected Integer checkNullFieldAndReturnIntegerValue(String intValue) {
		return document.getField(intValue) != null ? Integer.valueOf(document
				.getField(intValue).getValue()) : 0;
	}

	public String getParseDateString(String dateField) {
		try {
			SimpleDateFormat srcSdf = new SimpleDateFormat(
					SOURCE_DATETIME_FORMAT);
			SimpleDateFormat desSdf = new SimpleDateFormat(
					DESTINATION_DATETIME_FORMAT);

			return document.getField(dateField) != null ? desSdf.format(srcSdf
					.parse(getDocument().getField(dateField).getValue()))
					: StringUtils.EMPTY;
		} catch (ParseException e) {
			LogFactoryUtil.getLog(AbstractIndexedItem.class).info(e);
		}
		return StringUtils.EMPTY;
	}

	public String getParseDateString(Date date) {
		if (date == null)
			return StringUtils.EMPTY;
		SimpleDateFormat desSdf = new SimpleDateFormat(
				DESTINATION_DATETIME_FORMAT);
		return desSdf.format(date);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractIndexedItem) {
			AbstractIndexedItem that = (AbstractIndexedItem) obj;
			return this.getId() == that.getId();
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime
				* result
				* (this.getId() == 0 ? 0 : Long.valueOf(this.getId())
						.hashCode());
		return result;
	}
}
