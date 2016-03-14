package vn.com.ecopharma.hrm.rc.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vn.com.ecopharma.hrm.rc.enumeration.CandidateStatus;
import vn.com.ecopharma.hrm.rc.enumeration.VacancyCandidateType;
import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.model.Certificate;
import vn.com.ecopharma.hrm.rc.model.Experience;
import vn.com.ecopharma.hrm.rc.model.VacancyCandidate;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.CertificateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.ExperienceLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Country;

public class CandidateItem extends AbstractDocumentableBaseModelItem<Candidate> {

	private static final long serialVersionUID = 1L;

	private VacancyIndexItem vacancyIndexItem;

	private VacancyItem vacancyItem;

	private List<VacancyIndexItem> desiredVacancies;

	private List<ExperienceObjectItem> experiences;

	private List<CertificateObjectItem> certificates;

	private Country nationality;

	public CandidateItem() {
		super();
		this.getObject().setStatus(
				CandidateStatus.APPLICATION_INITIATED.toString());
		this.getObject().setApplicationDate(
				new Date(System.currentTimeMillis()));
		this.vacancyIndexItem = null;
		this.experiences = new ArrayList<>();
		this.certificates = new ArrayList<>();
		this.desiredVacancies = new ArrayList<>();
		this.nationality = RCUtils.getDefaultCountry();
		this.getObject().setGender("Male");
	}

	public CandidateItem(Candidate candidate) {
		super(candidate);
		this.vacancyIndexItem = getIndexVacancy(candidate.getCandidateId());
		this.experiences = getExperienceList(candidate.getCandidateId());
		this.certificates = getCertificateList(candidate.getCandidateId());
		this.desiredVacancies = getDesireVacanciesList(candidate
				.getCandidateId());
		this.nationality = RCUtils.getCountryById(candidate.getNationalityId());
	}

	public CandidateItem(long candidateId) throws SystemException {
		this(CandidateLocalServiceUtil.fetchCandidate(candidateId));
	}

	private VacancyIndexItem getIndexVacancy(long candidateId) {
		VacancyCandidate vacancyCandidate = VacancyCandidateLocalServiceUtil
				.findMAINVacancyCandidate(candidateId);
		if (vacancyCandidate != null)
			return new VacancyIndexItem(
					VacancyLocalServiceUtil.getIndexVacancyDocument(
							vacancyCandidate.getVacancyId(),
							RCUtils.getCurrentSearchContext()));
		return null;
	}

	private List<ExperienceObjectItem> getExperienceList(long candidateId) {
		final List<ExperienceObjectItem> experienceObjectItems = new ArrayList<>();
		for (Experience experience : ExperienceLocalServiceUtil
				.findByClassNameAndClassPK(Candidate.class.getName(),
						candidateId)) {
			experienceObjectItems.add(new ExperienceObjectItem(experience));
		}
		return experienceObjectItems;
	}

	private List<VacancyIndexItem> getDesireVacanciesList(long candidateId) {
		final List<VacancyIndexItem> vacancyIndexItems = new ArrayList<>();
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
		final List<CertificateObjectItem> items = new ArrayList<>();
		for (Certificate o : CertificateLocalServiceUtil
				.findByClassNameAndClassPK(Candidate.class.getName(),
						candidateId)) {
			items.add(new CertificateObjectItem(o));
		}
		return items;
	}

	public VacancyIndexItem getVacancyIndexItem() {
		return vacancyIndexItem;
	}

	public void setVacancyIndexItem(VacancyIndexItem vacancyIndexItem) {
		this.vacancyIndexItem = vacancyIndexItem;
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

	public VacancyItem getVacancyItem() {
		return vacancyItem;
	}

	public void setVacancyItem(VacancyItem vacancyItem) {
		this.vacancyItem = vacancyItem;
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

	@Override
	public Candidate createPrepersistedEntity() {
		return CandidateLocalServiceUtil.createPrePersistCandidate();
	}

	public Country getNationality() {
		return nationality;
	}

	public void setNationality(Country nationality) {
		this.nationality = nationality;
	}
}
