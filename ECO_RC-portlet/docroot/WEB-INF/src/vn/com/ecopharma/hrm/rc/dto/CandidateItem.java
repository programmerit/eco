package vn.com.ecopharma.hrm.rc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vn.com.ecopharma.hrm.rc.constant.ECO_RCUtils;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateStatus;
import vn.com.ecopharma.hrm.rc.enumeration.VacancyCandidateType;
import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.model.Certificate;
import vn.com.ecopharma.hrm.rc.model.Document;
import vn.com.ecopharma.hrm.rc.model.Experience;
import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.model.VacancyCandidate;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.CertificateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.DocumentLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.ExperienceLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

public class CandidateItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Candidate candidate;

	private VacancyIndexItem vacancyIndexItem;

	private Vacancy vacancy;

	private List<VacancyIndexItem> desiredVacancies;

	private List<DocumentItem> documentItems;

	private List<ExperienceObjectItem> experiences;

	private List<CertificateObjectItem> certificates;

	public CandidateItem() {
		this.candidate = CandidateLocalServiceUtil.createPrePersistCandidate();
		this.candidate.setStatus(CandidateStatus.APPLICATION_INITIATED
				.toString());
		this.candidate.setApplicationDate(new Date(System.currentTimeMillis()));
		this.vacancyIndexItem = null;
		this.documentItems = new ArrayList<DocumentItem>();
		this.experiences = new ArrayList<ExperienceObjectItem>();
		this.certificates = new ArrayList<CertificateObjectItem>();
		this.desiredVacancies = new ArrayList<VacancyIndexItem>();
	}

	public CandidateItem(Candidate candidate) {
		this.candidate = candidate;
		// this.vacancyIndexItem = getIndexVacancy(candidate.getCandidateId());
		this.vacancy = VacancyLocalServiceUtil
				.getVacancyByCandidateId(candidate.getCandidateId());
		this.documentItems = getDocumentList(candidate.getCandidateId());
		this.experiences = getExperienceList(candidate.getCandidateId());
		this.certificates = getCertificateList(candidate.getCandidateId());
		this.desiredVacancies = getDesireVacanciesList(candidate
				.getCandidateId());
	}

	private List<DocumentItem> getDocumentList(long candidateId) {
		List<Document> documents = DocumentLocalServiceUtil
				.findByClassAndClassPK(Candidate.class.getName(), candidateId);
		final List<DocumentItem> docItems = new ArrayList<DocumentItem>();
		for (Document doc : documents) {
			docItems.add(new DocumentItem(doc));
		}
		return docItems;
	}

	private List<ExperienceObjectItem> getExperienceList(long candidateId) {
		final List<ExperienceObjectItem> experienceObjectItems = new ArrayList<ExperienceObjectItem>();
		for (Experience experience : ExperienceLocalServiceUtil
				.findByClassNameAndClassPK(Candidate.class.getName(),
						candidateId)) {
			experienceObjectItems.add(new ExperienceObjectItem(experience));
		}
		return experienceObjectItems;
	}

	private List<VacancyIndexItem> getDesireVacanciesList(long candidateId) {
		final List<VacancyIndexItem> vacancyIndexItems = new ArrayList<VacancyIndexItem>();
		for (VacancyCandidate vacancyCandidate : VacancyCandidateLocalServiceUtil
				.findByCandidateAndType(candidateId,
						VacancyCandidateType.OPTIONAL.toString())) {
			VacancyIndexItem vacancyIndexItem = new VacancyIndexItem(
					VacancyLocalServiceUtil.getIndexVacancyDocument(
							vacancyCandidate.getVacancyId(),
							RCUtils.getCurrentSearchContext()));
			vacancyIndexItems.add(vacancyIndexItem);
		}
		return vacancyIndexItems;
	}

	private List<CertificateObjectItem> getCertificateList(long candidateId) {
		final List<CertificateObjectItem> items = new ArrayList<CertificateObjectItem>();
		for (Certificate o : CertificateLocalServiceUtil
				.findByClassNameAndClassPK(Candidate.class.getName(),
						candidateId)) {
			items.add(new CertificateObjectItem(o));
		}
		return items;
	}

	private VacancyIndexItem getIndexVacancy(long candidateId) {
		// final VacancyCandidate vacancyCandidate =
		// VacancyCandidateLocalServiceUtil
		// .findByCandidateAndActiveStatus(candidateId);

		// get(0) because one Candidate at the same time only have 1 MAIN
		// vacancy
		final VacancyCandidate vacancyCandidate = VacancyCandidateLocalServiceUtil
				.findByCandidateAndType(candidateId,
						VacancyCandidateType.MAIN.toString()).get(0);

		final VacancyIndexItem vacancyIndexItem = new VacancyIndexItem(
				VacancyLocalServiceUtil.getIndexVacancyDocument(
						vacancyCandidate.getVacancyId(),
						ECO_RCUtils.getCurrentSearchContext()));
		return vacancyIndexItem;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public VacancyIndexItem getVacancyIndexItem() {
		return vacancyIndexItem;
	}

	public void setVacancyIndexItem(VacancyIndexItem vacancyIndexItem) {
		this.vacancyIndexItem = vacancyIndexItem;
	}

	public Vacancy getVacancy() {
		return vacancy;
	}

	public void setVacancy(Vacancy vacancy) {
		this.vacancy = vacancy;
	}

	public List<DocumentItem> getDocumentItems() {
		return documentItems;
	}

	public void setDocumentItems(List<DocumentItem> documentItems) {
		this.documentItems = documentItems;
	}

	public List<ExperienceObjectItem> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<ExperienceObjectItem> experiences) {
		this.experiences = experiences;
	}

	public List<CertificateObjectItem> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<CertificateObjectItem> certificates) {
		this.certificates = certificates;
	}

	public List<VacancyIndexItem> getDesiredVacancies() {
		return desiredVacancies;
	}

	public void setDesiredVacancies(List<VacancyIndexItem> desiredVacancies) {
		this.desiredVacancies = desiredVacancies;
	}

	public List<Long> getPossibleDesiredVacancies() {
		return desiredVacancies != null ? RCUtils
				.getIdsFromIndexedItemList(desiredVacancies)
				: new ArrayList<Long>();
	}

}
