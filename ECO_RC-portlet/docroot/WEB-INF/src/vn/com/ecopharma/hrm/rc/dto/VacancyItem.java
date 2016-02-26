package vn.com.ecopharma.hrm.rc.dto;

import java.util.Date;

import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.enumeration.VacancyStatus;
import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class VacancyItem extends AbstractDocumentableBaseModelItem<Vacancy> {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil.getLog(VacancyItem.class);

	private Titles titles;

	public VacancyItem() {
		super();
		this.getObject().setPostedDate(new Date(System.currentTimeMillis()));
		this.getObject().setStatus(VacancyStatus.NEW.toString());
	}

	public VacancyItem(Vacancy vacancy) {
		super(vacancy);
	}

	public Titles getTitles() {
		try {
			if (titles == null)
				return titles = getObject().getTitlesId() != 0 ? TitlesLocalServiceUtil
						.fetchTitles(getObject().getTitlesId()) : null;
			return titles;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return titles;
	}

	public void setTitles(Titles titles) {
		this.titles = titles;
	}

	@Override
	public Vacancy createPrepersistedEntity() {
		return VacancyLocalServiceUtil.createPrePersistedVacancy();
	}
}
