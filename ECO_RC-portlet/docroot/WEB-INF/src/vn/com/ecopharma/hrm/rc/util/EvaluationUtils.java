package vn.com.ecopharma.hrm.rc.util;

import java.util.List;

import vn.com.ecopharma.hrm.rc.enumeration.CandidateCertificateType;
import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.model.Certificate;
import vn.com.ecopharma.hrm.rc.model.Experience;
import vn.com.ecopharma.hrm.rc.service.CertificateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.ExperienceLocalServiceUtil;

public class EvaluationUtils {

	public static int calculateEvaluationPoint(double educationPoint,
			double experiencePoint) {
		final Double result = (educationPoint + experiencePoint) / 2;
		return result.intValue();
	}

	public static double calculateExperiencePoint(double requirement,
			double check) {
		if (check >= requirement) {
			return 5.0;
		}

		return (check / requirement) * 5;
	}

	public static double calculateCandidateCertificatePoint(long candidateId,
			CandidateCertificateType requiredCertificate) {
		final List<Certificate> certificates = CertificateLocalServiceUtil
				.findByClassNameAndClassPK(Candidate.class.getName(),
						candidateId);
		double result = 0.0;
		for (Certificate certificate : certificates) {
			double currentCertificatePoint = CandidateCertificateType
					.getCertificateEvaluationPoint(requiredCertificate,
							CandidateCertificateType.valueOf(certificate
									.getCertificateType()));
			result = currentCertificatePoint > result ? currentCertificatePoint
					: result;
		}
		return result;
	}

	public static double calculateCandidateExperiencesPoint(long candidateId,
			double requiredYearsExperience) {
		final List<Experience> experiences = ExperienceLocalServiceUtil
				.findByClassNameAndClassPK(Candidate.class.getName(),
						candidateId);
		double totalYearsExperience = 0.0;
		for (Experience e : experiences) {
			totalYearsExperience += e.getYearsExperience();
		}

		return calculateExperiencePoint(requiredYearsExperience,
				totalYearsExperience);
	}

	public static int calculateFinalEvaluationPointOfCandidate(
			long candidateId, double requiredYearsExperience,
			CandidateCertificateType requiredCertificate) {
		double certificatePoint = calculateCandidateCertificatePoint(
				candidateId, requiredCertificate);
		double experiencePoint = calculateCandidateExperiencesPoint(
				candidateId, requiredYearsExperience);
		Double result = (certificatePoint + experiencePoint) / 2;
		return result.intValue();
	}

}
