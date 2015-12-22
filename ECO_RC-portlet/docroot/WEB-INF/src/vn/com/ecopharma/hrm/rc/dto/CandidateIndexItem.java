package vn.com.ecopharma.hrm.rc.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.hrm.rc.constant.CandidateField;
import vn.com.ecopharma.hrm.rc.dto.EvaluationItem.EvaluationKeyValueItem;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateStatus;
import vn.com.ecopharma.hrm.rc.enumeration.CertificateType;
import vn.com.ecopharma.hrm.rc.enumeration.VacancyCandidateType;
import vn.com.ecopharma.hrm.rc.model.CandidateEvaluation;
import vn.com.ecopharma.hrm.rc.model.Certificate;
import vn.com.ecopharma.hrm.rc.model.Experience;
import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.model.VacancyCandidate;
import vn.com.ecopharma.hrm.rc.service.CandidateEvaluationLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.EvaluationUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;

public class CandidateIndexItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SOURCE_DATETIME_FORMAT = "yyyyMMddhhmmss";
	private static final String DESTINATION_DATETIME_FORMAT = "dd/MM/yyyy";
	private Document candidateDocument;

	private List<Experience> experiences;

	private List<Certificate> certificates;

	public CandidateIndexItem(Document candidateDocument) {
		this.candidateDocument = candidateDocument;
	}

	public long getCandidateId() {
		return Long.valueOf(candidateDocument.getField(
				CandidateField.CANDIDATE_ID).getValue());
	}

	public String getEmailAddress() {
		return candidateDocument.getField(CandidateField.EMAIL).getValue();
	}

	public String getContactNumber() {
		return candidateDocument.getField(CandidateField.CONTACT_NUMBER)
				.getValue();
	}

	public String getVacancy() {
		return candidateDocument.getField(CandidateField.VACANCY) != null ? candidateDocument
				.getField(CandidateField.VACANCY).getValue()
				: StringUtils.EMPTY;
	}

	public long getVacancyId() {
		return candidateDocument.getField(CandidateField.VACANCY_ID) != null ? Long
				.valueOf(candidateDocument.getField(CandidateField.VACANCY_ID)
						.getValue()) : 0L;
	}

	public long getVacancyCandidateId() {
		return Long.valueOf(candidateDocument.getField(
				CandidateField.VACANCY_CANDIDATE_ID).getValue());
	}

	public String getLocation() {
		return candidateDocument.getField(CandidateField.LOCATION).getValue();
	}

	public String getFullName() {
		return candidateDocument.getField(CandidateField.FULLNAME).getValue();
	}

	public String getStatus() {
		return candidateDocument.getField(CandidateField.STATUS).getValue();
	}

	public String isDeleted() {
		return candidateDocument.getField(CandidateField.IS_DELETED).getValue();
	}

	public java.util.Date getApplicationDate() {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				SOURCE_DATETIME_FORMAT);
		try {
			return sdf.parse(candidateDocument.getField(
					CandidateField.APPLICATION_DATE).getValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getFormattedApplicationDate() {
		try {
			SimpleDateFormat srcSdf = new SimpleDateFormat(
					SOURCE_DATETIME_FORMAT);
			SimpleDateFormat desSdf = new SimpleDateFormat(
					DESTINATION_DATETIME_FORMAT);

			return candidateDocument.getField(CandidateField.APPLICATION_DATE) != null ? desSdf
					.format(srcSdf.parse(candidateDocument.getField(
							CandidateField.APPLICATION_DATE).getValue()))
					: StringUtils.EMPTY;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return StringUtils.EMPTY;
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
		try {
			if (getVacancyId() != 0) {
				Vacancy vacancy = VacancyLocalServiceUtil
						.fetchVacancy(getVacancyId());
				double requiredYearsExperience = vacancy.getExperiences();
				CertificateType requiredCertificateType = CertificateType
						.valueOf(vacancy.getCertificateType());
				return EvaluationUtils
						.calculateFinalEvaluationPointOfCandidate(
								getCandidateId(), requiredYearsExperience,
								requiredCertificateType);
			}
			return 0;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<EvaluationItem> getEvaluationItems() {
		final List<EvaluationItem> result = new ArrayList<EvaluationItem>();
		if (this.getStatus().equals(CandidateStatus.JOB_OFFERED.toString())) {
			final List<CandidateEvaluation> candidateEvaluations = CandidateEvaluationLocalServiceUtil
					.findByCandidate(this.getCandidateId());
			if (candidateEvaluations == null || candidateEvaluations.isEmpty()) {
				return result;
			}
			final List<Long> evaluationCriteriaIds = new ArrayList<Long>();
			for (CandidateEvaluation item : candidateEvaluations) {
				try {
					final EvaluationItem evaluationItem = new EvaluationItem(
							EvaluationCriteriaLocalServiceUtil
									.fetchEvaluationCriteria(item
											.getEvaluationCriteriaId()));
					if (!evaluationCriteriaIds.contains(item
							.getEvaluationCriteriaId())) {
						result.add(evaluationItem);
						evaluationCriteriaIds.add(item
								.getEvaluationCriteriaId());
					}

					for (EvaluationKeyValueItem item1 : evaluationItem
							.getEvaluationKeyValueItems()) {
//						if (item1.getEvaluationCriteriaKeyValue()
//								.getEvaluationCriteriaKeyValueId() == item
//								.getEvaluationCriteriaKeyValueId()) {
							item1.setValue(item.getRatingPoint());
//						}
					}

				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	public String getDesiredPositions() {
		try {
			final List<VacancyCandidate> desiredPositions = VacancyCandidateLocalServiceUtil
					.findByCandidateAndType(getCandidateId(),
							VacancyCandidateType.OPTIONAL.toString());
			String result = StringUtils.EMPTY;
			int count = 0;
			for (VacancyCandidate vc : desiredPositions) {
				Vacancy v = VacancyLocalServiceUtil.getVacancy(vc
						.getVacancyId());

				result += count < desiredPositions.size() - 1 ? v.getName()
						+ ";  " : v.getName() + ".";
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
		return CandidateStatus.valueOf(getStatus()).getLocalizedName();
	}
}
