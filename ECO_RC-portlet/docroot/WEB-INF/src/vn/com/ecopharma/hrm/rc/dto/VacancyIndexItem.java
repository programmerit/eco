package vn.com.ecopharma.hrm.rc.dto;

import vn.com.ecopharma.hrm.rc.constant.VacancyField;

import com.liferay.portal.kernel.search.Document;

public class VacancyIndexItem extends AbstractIndexEntityItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titles;

	public VacancyIndexItem(Document document) {
		super(document);
		this.titles = getDocument().getField(VacancyField.TITLES).getValue();
	}

	public int getNumberOfPosition() {
		return getDocument().getField(VacancyField.NUMBER_OF_POSITION) != null ? Integer
				.valueOf(getDocument()
						.getField(VacancyField.NUMBER_OF_POSITION).getValue())
				: 0;
	}

	public String getTitles() {
		return titles;
	}

	public String getDescription() {
		return getDocument().getField(VacancyField.DESCRIPTION).getValue();
	}

	public long getTitlesId() {
		return Long.valueOf(getDocument().getField(VacancyField.TITLES_ID)
				.getValue());
	}

	public String getStatus() {
		return getDocument().getField(VacancyField.STATUS).getValue();
	}

	@Override
	protected String idFieldName() {
		return VacancyField.VACANCY_ID;
	}

}
