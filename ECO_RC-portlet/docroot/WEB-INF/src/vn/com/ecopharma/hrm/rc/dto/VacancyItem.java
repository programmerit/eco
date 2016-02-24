package vn.com.ecopharma.hrm.rc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vn.com.ecopharma.emp.model.Document;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.service.DocumentLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.enumeration.VacancyStatus;
import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class VacancyItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil.getLog(VacancyItem.class);

	private Titles titles;

	private Vacancy vacancy;

	private List<DocumentItem> documents;

	public VacancyItem() {
		vacancy = VacancyLocalServiceUtil.createPrePersistedVacancy();
		vacancy.setPostedDate(new Date(System.currentTimeMillis()));
		vacancy.setStatus(VacancyStatus.NEW.toString());
		documents = new ArrayList<>();
	}

	public VacancyItem(Vacancy vacancy) {
		this.vacancy = vacancy;
		List<Document> docs = DocumentLocalServiceUtil
				.findByClassNameAndClassPK(Vacancy.class.getName(),
						vacancy.getVacancyId());
		this.documents = new ArrayList<>();
		for (Document doc : docs) {
			documents.add(new DocumentItem(doc));
		}
	}

	public Vacancy getVacancy() {
		return vacancy;
	}

	public void setVacancy(Vacancy vacancy) {
		this.vacancy = vacancy;
	}

	public Titles getTitles() {
		try {
			if (titles == null)
				return titles = vacancy.getTitlesId() != 0 ? TitlesLocalServiceUtil
						.fetchTitles(vacancy.getTitlesId()) : null;
			return titles;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return titles;
	}

	public void setTitles(Titles titles) {
		this.titles = titles;
	}

	public List<DocumentItem> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentItem> documentItems) {
		this.documents = documentItems;
	}
}
