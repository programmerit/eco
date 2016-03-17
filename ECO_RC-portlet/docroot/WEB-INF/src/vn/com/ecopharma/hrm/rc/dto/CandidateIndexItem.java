package vn.com.ecopharma.hrm.rc.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.constant.CandidateField;
import vn.com.ecopharma.hrm.rc.dto.evaluate.EvaluationItem;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateStatus;
import vn.com.ecopharma.hrm.rc.enumeration.VacancyCandidateType;
import vn.com.ecopharma.hrm.rc.model.CandidateEvaluation;
import vn.com.ecopharma.hrm.rc.model.Certificate;
import vn.com.ecopharma.hrm.rc.model.Experience;
import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.model.VacancyCandidate;
import vn.com.ecopharma.hrm.rc.service.CandidateEvaluationLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;

public class CandidateIndexItem extends AbstractIndexedItem {

	private static final long serialVersionUID = 1L;

	private List<Experience> experiences;

	private List<Certificate> certificates;

	public CandidateIndexItem(Document document) {
		super(document);
	}

	@Override
	protected String getIdFieldName() {
		return CandidateField.CANDIDATE_ID;
	}

	public String getEmailAddress() {
		return checkNullFieldAndReturnEmptyString(CandidateField.EMAIL);
	}

	public String getContactNumber() {
		return checkNullFieldAndReturnEmptyString(CandidateField.CONTACT_NUMBER);
	}

	public String getVacancy() {
		return checkNullFieldAndReturnEmptyString(CandidateField.VACANCY);
	}

	public long getVacancyId() {
		return checkNullFieldAndReturnLongValue(CandidateField.VACANCY_ID);
	}

	public long getVacancyCandidateId() {
		return checkNullFieldAndReturnLongValue(CandidateField.VACANCY_CANDIDATE_ID);
	}

	public String getLocation() {
		return checkNullFieldAndReturnEmptyString(CandidateField.LOCATION);
	}

	public String getFullName() {
		return checkNullFieldAndReturnEmptyString(CandidateField.FULLNAME);
	}

	public String getStatus() {
		String status = checkNullFieldAndReturnEmptyString(CandidateField.STATUS);
		return status.replaceAll(" ", "_");
	}

	public String isDeleted() {
		return checkNullFieldAndReturnEmptyString(CandidateField.IS_DELETED);
	}

	public java.util.Date getApplicationDate() {
		return checkNullFieldAndReturnNullDate(CandidateField.APPLICATION_DATE);
	}

	public String getFormattedApplicationDate() {
		return getParseDateString(getApplicationDate());
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

	public int getEvaluationPoint() {
		// try {
		// if (getVacancyId() != 0) {
		// Vacancy vacancy = VacancyLocalServiceUtil
		// .fetchVacancy(getVacancyId());
		// double requiredYearsExperience = vacancy.getExperiences();
		// CandidateCertificateType requiredCertificateType =
		// CandidateCertificateType
		// .valueOf(vacancy.getCertificateType());
		// return EvaluationUtils
		// .calculateFinalEvaluationPointOfCandidate(
		// getCandidateId(), requiredYearsExperience,
		// requiredCertificateType);
		// }
		// return 0;
		// } catch (SystemException e) {
		// e.printStackTrace();
		// }
		return 0;
	}

	public List<EvaluationItem> getEvaluationItems() {
		final List<EvaluationItem> result = new ArrayList<EvaluationItem>();
		if (this.getStatus().equals(CandidateStatus.JOB_OFFERED.toString())) {
			final List<CandidateEvaluation> candidateEvaluations = CandidateEvaluationLocalServiceUtil
					.findByCandidate(this.getId());
			if (candidateEvaluations == null || candidateEvaluations.isEmpty()) {
				return result;
			}
			final List<Long> evaluationCriteriaIds = new ArrayList<Long>();
			// for (CandidateEvaluation item : candidateEvaluations) {
			// try {
			// final EvaluationItem evaluationItem = new EvaluationItem(
			// EvaluationCriteriaLocalServiceUtil
			// .fetchEvaluationCriteria(item
			// .getEvaluationCriteriaId()));
			// if (!evaluationCriteriaIds.contains(item
			// .getEvaluationCriteriaId())) {
			// result.add(evaluationItem);
			// evaluationCriteriaIds.add(item
			// .getEvaluationCriteriaId());
			// }

			// for (EvaluationKeyValueItem item1 : evaluationItem
			// .getEvaluationKeyValueItems()) {
			// if (item1.getEvaluationCriteriaKeyValue()
			// .getEvaluationCriteriaKeyValueId() == item
			// .getEvaluationCriteriaKeyValueId()) {
			// item1.setValue(item.getRatingPoint());
			// }
			// }

			// } catch (SystemException e) {
			// e.printStackTrace();
			// }
			// }
		}

		return result;
	}

	public String getDesiredPositions() {
		try {
			final List<VacancyCandidate> desiredPositions = VacancyCandidateLocalServiceUtil
					.findByCandidateAndType(getId(),
							VacancyCandidateType.OPTIONAL.toString());
			String result = StringUtils.EMPTY;
			int count = 0;
			for (VacancyCandidate vc : desiredPositions) {
				Vacancy v = VacancyLocalServiceUtil.getVacancy(vc
						.getVacancyId());
				String titlesName = TitlesLocalServiceUtil.fetchTitles(
						v.getTitlesId()).getName();
				result += count < desiredPositions.size() - 1 ? titlesName
						+ ";  " : titlesName + ".";
				count++;
			}
			return desiredPositions.size() > 0 ? result : "N/A";
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return "N/A";
	}

	public String getLocalizedStatus() {
		return CandidateStatus.valueOf(getStatus()).getLocalizedString();
	}
}
