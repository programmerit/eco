/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package vn.com.ecopharma.hrm.rc.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import vn.com.ecopharma.hrm.rc.model.Certificate;
import vn.com.ecopharma.hrm.rc.service.CertificateService;
import vn.com.ecopharma.hrm.rc.service.persistence.CandidateActionHistoryPersistence;
import vn.com.ecopharma.hrm.rc.service.persistence.CandidateEvaluationPersistence;
import vn.com.ecopharma.hrm.rc.service.persistence.CandidatePersistence;
import vn.com.ecopharma.hrm.rc.service.persistence.CertificatePersistence;
import vn.com.ecopharma.hrm.rc.service.persistence.DocumentPersistence;
import vn.com.ecopharma.hrm.rc.service.persistence.EmployeeInterviewSchedulePersistence;
import vn.com.ecopharma.hrm.rc.service.persistence.EvaluationCriteriaKeyValuePersistence;
import vn.com.ecopharma.hrm.rc.service.persistence.EvaluationCriteriaPersistence;
import vn.com.ecopharma.hrm.rc.service.persistence.ExperiencePersistence;
import vn.com.ecopharma.hrm.rc.service.persistence.InterviewPersistence;
import vn.com.ecopharma.hrm.rc.service.persistence.InterviewSchedulePersistence;
import vn.com.ecopharma.hrm.rc.service.persistence.SkillPersistence;
import vn.com.ecopharma.hrm.rc.service.persistence.VacancyCandidatePersistence;
import vn.com.ecopharma.hrm.rc.service.persistence.VacancyEvaluationCriteriaPersistence;
import vn.com.ecopharma.hrm.rc.service.persistence.VacancyPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the certificate remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link vn.com.ecopharma.hrm.rc.service.impl.CertificateServiceImpl}.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.impl.CertificateServiceImpl
 * @see vn.com.ecopharma.hrm.rc.service.CertificateServiceUtil
 * @generated
 */
public abstract class CertificateServiceBaseImpl extends BaseServiceImpl
	implements CertificateService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link vn.com.ecopharma.hrm.rc.service.CertificateServiceUtil} to access the certificate remote service.
	 */

	/**
	 * Returns the candidate local service.
	 *
	 * @return the candidate local service
	 */
	public vn.com.ecopharma.hrm.rc.service.CandidateLocalService getCandidateLocalService() {
		return candidateLocalService;
	}

	/**
	 * Sets the candidate local service.
	 *
	 * @param candidateLocalService the candidate local service
	 */
	public void setCandidateLocalService(
		vn.com.ecopharma.hrm.rc.service.CandidateLocalService candidateLocalService) {
		this.candidateLocalService = candidateLocalService;
	}

	/**
	 * Returns the candidate remote service.
	 *
	 * @return the candidate remote service
	 */
	public vn.com.ecopharma.hrm.rc.service.CandidateService getCandidateService() {
		return candidateService;
	}

	/**
	 * Sets the candidate remote service.
	 *
	 * @param candidateService the candidate remote service
	 */
	public void setCandidateService(
		vn.com.ecopharma.hrm.rc.service.CandidateService candidateService) {
		this.candidateService = candidateService;
	}

	/**
	 * Returns the candidate persistence.
	 *
	 * @return the candidate persistence
	 */
	public CandidatePersistence getCandidatePersistence() {
		return candidatePersistence;
	}

	/**
	 * Sets the candidate persistence.
	 *
	 * @param candidatePersistence the candidate persistence
	 */
	public void setCandidatePersistence(
		CandidatePersistence candidatePersistence) {
		this.candidatePersistence = candidatePersistence;
	}

	/**
	 * Returns the candidate action history local service.
	 *
	 * @return the candidate action history local service
	 */
	public vn.com.ecopharma.hrm.rc.service.CandidateActionHistoryLocalService getCandidateActionHistoryLocalService() {
		return candidateActionHistoryLocalService;
	}

	/**
	 * Sets the candidate action history local service.
	 *
	 * @param candidateActionHistoryLocalService the candidate action history local service
	 */
	public void setCandidateActionHistoryLocalService(
		vn.com.ecopharma.hrm.rc.service.CandidateActionHistoryLocalService candidateActionHistoryLocalService) {
		this.candidateActionHistoryLocalService = candidateActionHistoryLocalService;
	}

	/**
	 * Returns the candidate action history remote service.
	 *
	 * @return the candidate action history remote service
	 */
	public vn.com.ecopharma.hrm.rc.service.CandidateActionHistoryService getCandidateActionHistoryService() {
		return candidateActionHistoryService;
	}

	/**
	 * Sets the candidate action history remote service.
	 *
	 * @param candidateActionHistoryService the candidate action history remote service
	 */
	public void setCandidateActionHistoryService(
		vn.com.ecopharma.hrm.rc.service.CandidateActionHistoryService candidateActionHistoryService) {
		this.candidateActionHistoryService = candidateActionHistoryService;
	}

	/**
	 * Returns the candidate action history persistence.
	 *
	 * @return the candidate action history persistence
	 */
	public CandidateActionHistoryPersistence getCandidateActionHistoryPersistence() {
		return candidateActionHistoryPersistence;
	}

	/**
	 * Sets the candidate action history persistence.
	 *
	 * @param candidateActionHistoryPersistence the candidate action history persistence
	 */
	public void setCandidateActionHistoryPersistence(
		CandidateActionHistoryPersistence candidateActionHistoryPersistence) {
		this.candidateActionHistoryPersistence = candidateActionHistoryPersistence;
	}

	/**
	 * Returns the candidate evaluation local service.
	 *
	 * @return the candidate evaluation local service
	 */
	public vn.com.ecopharma.hrm.rc.service.CandidateEvaluationLocalService getCandidateEvaluationLocalService() {
		return candidateEvaluationLocalService;
	}

	/**
	 * Sets the candidate evaluation local service.
	 *
	 * @param candidateEvaluationLocalService the candidate evaluation local service
	 */
	public void setCandidateEvaluationLocalService(
		vn.com.ecopharma.hrm.rc.service.CandidateEvaluationLocalService candidateEvaluationLocalService) {
		this.candidateEvaluationLocalService = candidateEvaluationLocalService;
	}

	/**
	 * Returns the candidate evaluation remote service.
	 *
	 * @return the candidate evaluation remote service
	 */
	public vn.com.ecopharma.hrm.rc.service.CandidateEvaluationService getCandidateEvaluationService() {
		return candidateEvaluationService;
	}

	/**
	 * Sets the candidate evaluation remote service.
	 *
	 * @param candidateEvaluationService the candidate evaluation remote service
	 */
	public void setCandidateEvaluationService(
		vn.com.ecopharma.hrm.rc.service.CandidateEvaluationService candidateEvaluationService) {
		this.candidateEvaluationService = candidateEvaluationService;
	}

	/**
	 * Returns the candidate evaluation persistence.
	 *
	 * @return the candidate evaluation persistence
	 */
	public CandidateEvaluationPersistence getCandidateEvaluationPersistence() {
		return candidateEvaluationPersistence;
	}

	/**
	 * Sets the candidate evaluation persistence.
	 *
	 * @param candidateEvaluationPersistence the candidate evaluation persistence
	 */
	public void setCandidateEvaluationPersistence(
		CandidateEvaluationPersistence candidateEvaluationPersistence) {
		this.candidateEvaluationPersistence = candidateEvaluationPersistence;
	}

	/**
	 * Returns the certificate local service.
	 *
	 * @return the certificate local service
	 */
	public vn.com.ecopharma.hrm.rc.service.CertificateLocalService getCertificateLocalService() {
		return certificateLocalService;
	}

	/**
	 * Sets the certificate local service.
	 *
	 * @param certificateLocalService the certificate local service
	 */
	public void setCertificateLocalService(
		vn.com.ecopharma.hrm.rc.service.CertificateLocalService certificateLocalService) {
		this.certificateLocalService = certificateLocalService;
	}

	/**
	 * Returns the certificate remote service.
	 *
	 * @return the certificate remote service
	 */
	public vn.com.ecopharma.hrm.rc.service.CertificateService getCertificateService() {
		return certificateService;
	}

	/**
	 * Sets the certificate remote service.
	 *
	 * @param certificateService the certificate remote service
	 */
	public void setCertificateService(
		vn.com.ecopharma.hrm.rc.service.CertificateService certificateService) {
		this.certificateService = certificateService;
	}

	/**
	 * Returns the certificate persistence.
	 *
	 * @return the certificate persistence
	 */
	public CertificatePersistence getCertificatePersistence() {
		return certificatePersistence;
	}

	/**
	 * Sets the certificate persistence.
	 *
	 * @param certificatePersistence the certificate persistence
	 */
	public void setCertificatePersistence(
		CertificatePersistence certificatePersistence) {
		this.certificatePersistence = certificatePersistence;
	}

	/**
	 * Returns the document local service.
	 *
	 * @return the document local service
	 */
	public vn.com.ecopharma.hrm.rc.service.DocumentLocalService getDocumentLocalService() {
		return documentLocalService;
	}

	/**
	 * Sets the document local service.
	 *
	 * @param documentLocalService the document local service
	 */
	public void setDocumentLocalService(
		vn.com.ecopharma.hrm.rc.service.DocumentLocalService documentLocalService) {
		this.documentLocalService = documentLocalService;
	}

	/**
	 * Returns the document remote service.
	 *
	 * @return the document remote service
	 */
	public vn.com.ecopharma.hrm.rc.service.DocumentService getDocumentService() {
		return documentService;
	}

	/**
	 * Sets the document remote service.
	 *
	 * @param documentService the document remote service
	 */
	public void setDocumentService(
		vn.com.ecopharma.hrm.rc.service.DocumentService documentService) {
		this.documentService = documentService;
	}

	/**
	 * Returns the document persistence.
	 *
	 * @return the document persistence
	 */
	public DocumentPersistence getDocumentPersistence() {
		return documentPersistence;
	}

	/**
	 * Sets the document persistence.
	 *
	 * @param documentPersistence the document persistence
	 */
	public void setDocumentPersistence(DocumentPersistence documentPersistence) {
		this.documentPersistence = documentPersistence;
	}

	/**
	 * Returns the employee interview schedule local service.
	 *
	 * @return the employee interview schedule local service
	 */
	public vn.com.ecopharma.hrm.rc.service.EmployeeInterviewScheduleLocalService getEmployeeInterviewScheduleLocalService() {
		return employeeInterviewScheduleLocalService;
	}

	/**
	 * Sets the employee interview schedule local service.
	 *
	 * @param employeeInterviewScheduleLocalService the employee interview schedule local service
	 */
	public void setEmployeeInterviewScheduleLocalService(
		vn.com.ecopharma.hrm.rc.service.EmployeeInterviewScheduleLocalService employeeInterviewScheduleLocalService) {
		this.employeeInterviewScheduleLocalService = employeeInterviewScheduleLocalService;
	}

	/**
	 * Returns the employee interview schedule remote service.
	 *
	 * @return the employee interview schedule remote service
	 */
	public vn.com.ecopharma.hrm.rc.service.EmployeeInterviewScheduleService getEmployeeInterviewScheduleService() {
		return employeeInterviewScheduleService;
	}

	/**
	 * Sets the employee interview schedule remote service.
	 *
	 * @param employeeInterviewScheduleService the employee interview schedule remote service
	 */
	public void setEmployeeInterviewScheduleService(
		vn.com.ecopharma.hrm.rc.service.EmployeeInterviewScheduleService employeeInterviewScheduleService) {
		this.employeeInterviewScheduleService = employeeInterviewScheduleService;
	}

	/**
	 * Returns the employee interview schedule persistence.
	 *
	 * @return the employee interview schedule persistence
	 */
	public EmployeeInterviewSchedulePersistence getEmployeeInterviewSchedulePersistence() {
		return employeeInterviewSchedulePersistence;
	}

	/**
	 * Sets the employee interview schedule persistence.
	 *
	 * @param employeeInterviewSchedulePersistence the employee interview schedule persistence
	 */
	public void setEmployeeInterviewSchedulePersistence(
		EmployeeInterviewSchedulePersistence employeeInterviewSchedulePersistence) {
		this.employeeInterviewSchedulePersistence = employeeInterviewSchedulePersistence;
	}

	/**
	 * Returns the evaluation criteria local service.
	 *
	 * @return the evaluation criteria local service
	 */
	public vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaLocalService getEvaluationCriteriaLocalService() {
		return evaluationCriteriaLocalService;
	}

	/**
	 * Sets the evaluation criteria local service.
	 *
	 * @param evaluationCriteriaLocalService the evaluation criteria local service
	 */
	public void setEvaluationCriteriaLocalService(
		vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaLocalService evaluationCriteriaLocalService) {
		this.evaluationCriteriaLocalService = evaluationCriteriaLocalService;
	}

	/**
	 * Returns the evaluation criteria remote service.
	 *
	 * @return the evaluation criteria remote service
	 */
	public vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaService getEvaluationCriteriaService() {
		return evaluationCriteriaService;
	}

	/**
	 * Sets the evaluation criteria remote service.
	 *
	 * @param evaluationCriteriaService the evaluation criteria remote service
	 */
	public void setEvaluationCriteriaService(
		vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaService evaluationCriteriaService) {
		this.evaluationCriteriaService = evaluationCriteriaService;
	}

	/**
	 * Returns the evaluation criteria persistence.
	 *
	 * @return the evaluation criteria persistence
	 */
	public EvaluationCriteriaPersistence getEvaluationCriteriaPersistence() {
		return evaluationCriteriaPersistence;
	}

	/**
	 * Sets the evaluation criteria persistence.
	 *
	 * @param evaluationCriteriaPersistence the evaluation criteria persistence
	 */
	public void setEvaluationCriteriaPersistence(
		EvaluationCriteriaPersistence evaluationCriteriaPersistence) {
		this.evaluationCriteriaPersistence = evaluationCriteriaPersistence;
	}

	/**
	 * Returns the evaluation criteria key value local service.
	 *
	 * @return the evaluation criteria key value local service
	 */
	public vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaKeyValueLocalService getEvaluationCriteriaKeyValueLocalService() {
		return evaluationCriteriaKeyValueLocalService;
	}

	/**
	 * Sets the evaluation criteria key value local service.
	 *
	 * @param evaluationCriteriaKeyValueLocalService the evaluation criteria key value local service
	 */
	public void setEvaluationCriteriaKeyValueLocalService(
		vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaKeyValueLocalService evaluationCriteriaKeyValueLocalService) {
		this.evaluationCriteriaKeyValueLocalService = evaluationCriteriaKeyValueLocalService;
	}

	/**
	 * Returns the evaluation criteria key value remote service.
	 *
	 * @return the evaluation criteria key value remote service
	 */
	public vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaKeyValueService getEvaluationCriteriaKeyValueService() {
		return evaluationCriteriaKeyValueService;
	}

	/**
	 * Sets the evaluation criteria key value remote service.
	 *
	 * @param evaluationCriteriaKeyValueService the evaluation criteria key value remote service
	 */
	public void setEvaluationCriteriaKeyValueService(
		vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaKeyValueService evaluationCriteriaKeyValueService) {
		this.evaluationCriteriaKeyValueService = evaluationCriteriaKeyValueService;
	}

	/**
	 * Returns the evaluation criteria key value persistence.
	 *
	 * @return the evaluation criteria key value persistence
	 */
	public EvaluationCriteriaKeyValuePersistence getEvaluationCriteriaKeyValuePersistence() {
		return evaluationCriteriaKeyValuePersistence;
	}

	/**
	 * Sets the evaluation criteria key value persistence.
	 *
	 * @param evaluationCriteriaKeyValuePersistence the evaluation criteria key value persistence
	 */
	public void setEvaluationCriteriaKeyValuePersistence(
		EvaluationCriteriaKeyValuePersistence evaluationCriteriaKeyValuePersistence) {
		this.evaluationCriteriaKeyValuePersistence = evaluationCriteriaKeyValuePersistence;
	}

	/**
	 * Returns the experience local service.
	 *
	 * @return the experience local service
	 */
	public vn.com.ecopharma.hrm.rc.service.ExperienceLocalService getExperienceLocalService() {
		return experienceLocalService;
	}

	/**
	 * Sets the experience local service.
	 *
	 * @param experienceLocalService the experience local service
	 */
	public void setExperienceLocalService(
		vn.com.ecopharma.hrm.rc.service.ExperienceLocalService experienceLocalService) {
		this.experienceLocalService = experienceLocalService;
	}

	/**
	 * Returns the experience remote service.
	 *
	 * @return the experience remote service
	 */
	public vn.com.ecopharma.hrm.rc.service.ExperienceService getExperienceService() {
		return experienceService;
	}

	/**
	 * Sets the experience remote service.
	 *
	 * @param experienceService the experience remote service
	 */
	public void setExperienceService(
		vn.com.ecopharma.hrm.rc.service.ExperienceService experienceService) {
		this.experienceService = experienceService;
	}

	/**
	 * Returns the experience persistence.
	 *
	 * @return the experience persistence
	 */
	public ExperiencePersistence getExperiencePersistence() {
		return experiencePersistence;
	}

	/**
	 * Sets the experience persistence.
	 *
	 * @param experiencePersistence the experience persistence
	 */
	public void setExperiencePersistence(
		ExperiencePersistence experiencePersistence) {
		this.experiencePersistence = experiencePersistence;
	}

	/**
	 * Returns the interview local service.
	 *
	 * @return the interview local service
	 */
	public vn.com.ecopharma.hrm.rc.service.InterviewLocalService getInterviewLocalService() {
		return interviewLocalService;
	}

	/**
	 * Sets the interview local service.
	 *
	 * @param interviewLocalService the interview local service
	 */
	public void setInterviewLocalService(
		vn.com.ecopharma.hrm.rc.service.InterviewLocalService interviewLocalService) {
		this.interviewLocalService = interviewLocalService;
	}

	/**
	 * Returns the interview remote service.
	 *
	 * @return the interview remote service
	 */
	public vn.com.ecopharma.hrm.rc.service.InterviewService getInterviewService() {
		return interviewService;
	}

	/**
	 * Sets the interview remote service.
	 *
	 * @param interviewService the interview remote service
	 */
	public void setInterviewService(
		vn.com.ecopharma.hrm.rc.service.InterviewService interviewService) {
		this.interviewService = interviewService;
	}

	/**
	 * Returns the interview persistence.
	 *
	 * @return the interview persistence
	 */
	public InterviewPersistence getInterviewPersistence() {
		return interviewPersistence;
	}

	/**
	 * Sets the interview persistence.
	 *
	 * @param interviewPersistence the interview persistence
	 */
	public void setInterviewPersistence(
		InterviewPersistence interviewPersistence) {
		this.interviewPersistence = interviewPersistence;
	}

	/**
	 * Returns the interview schedule local service.
	 *
	 * @return the interview schedule local service
	 */
	public vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalService getInterviewScheduleLocalService() {
		return interviewScheduleLocalService;
	}

	/**
	 * Sets the interview schedule local service.
	 *
	 * @param interviewScheduleLocalService the interview schedule local service
	 */
	public void setInterviewScheduleLocalService(
		vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalService interviewScheduleLocalService) {
		this.interviewScheduleLocalService = interviewScheduleLocalService;
	}

	/**
	 * Returns the interview schedule remote service.
	 *
	 * @return the interview schedule remote service
	 */
	public vn.com.ecopharma.hrm.rc.service.InterviewScheduleService getInterviewScheduleService() {
		return interviewScheduleService;
	}

	/**
	 * Sets the interview schedule remote service.
	 *
	 * @param interviewScheduleService the interview schedule remote service
	 */
	public void setInterviewScheduleService(
		vn.com.ecopharma.hrm.rc.service.InterviewScheduleService interviewScheduleService) {
		this.interviewScheduleService = interviewScheduleService;
	}

	/**
	 * Returns the interview schedule persistence.
	 *
	 * @return the interview schedule persistence
	 */
	public InterviewSchedulePersistence getInterviewSchedulePersistence() {
		return interviewSchedulePersistence;
	}

	/**
	 * Sets the interview schedule persistence.
	 *
	 * @param interviewSchedulePersistence the interview schedule persistence
	 */
	public void setInterviewSchedulePersistence(
		InterviewSchedulePersistence interviewSchedulePersistence) {
		this.interviewSchedulePersistence = interviewSchedulePersistence;
	}

	/**
	 * Returns the skill remote service.
	 *
	 * @return the skill remote service
	 */
	public vn.com.ecopharma.hrm.rc.service.SkillService getSkillService() {
		return skillService;
	}

	/**
	 * Sets the skill remote service.
	 *
	 * @param skillService the skill remote service
	 */
	public void setSkillService(
		vn.com.ecopharma.hrm.rc.service.SkillService skillService) {
		this.skillService = skillService;
	}

	/**
	 * Returns the skill persistence.
	 *
	 * @return the skill persistence
	 */
	public SkillPersistence getSkillPersistence() {
		return skillPersistence;
	}

	/**
	 * Sets the skill persistence.
	 *
	 * @param skillPersistence the skill persistence
	 */
	public void setSkillPersistence(SkillPersistence skillPersistence) {
		this.skillPersistence = skillPersistence;
	}

	/**
	 * Returns the vacancy local service.
	 *
	 * @return the vacancy local service
	 */
	public vn.com.ecopharma.hrm.rc.service.VacancyLocalService getVacancyLocalService() {
		return vacancyLocalService;
	}

	/**
	 * Sets the vacancy local service.
	 *
	 * @param vacancyLocalService the vacancy local service
	 */
	public void setVacancyLocalService(
		vn.com.ecopharma.hrm.rc.service.VacancyLocalService vacancyLocalService) {
		this.vacancyLocalService = vacancyLocalService;
	}

	/**
	 * Returns the vacancy remote service.
	 *
	 * @return the vacancy remote service
	 */
	public vn.com.ecopharma.hrm.rc.service.VacancyService getVacancyService() {
		return vacancyService;
	}

	/**
	 * Sets the vacancy remote service.
	 *
	 * @param vacancyService the vacancy remote service
	 */
	public void setVacancyService(
		vn.com.ecopharma.hrm.rc.service.VacancyService vacancyService) {
		this.vacancyService = vacancyService;
	}

	/**
	 * Returns the vacancy persistence.
	 *
	 * @return the vacancy persistence
	 */
	public VacancyPersistence getVacancyPersistence() {
		return vacancyPersistence;
	}

	/**
	 * Sets the vacancy persistence.
	 *
	 * @param vacancyPersistence the vacancy persistence
	 */
	public void setVacancyPersistence(VacancyPersistence vacancyPersistence) {
		this.vacancyPersistence = vacancyPersistence;
	}

	/**
	 * Returns the vacancy candidate local service.
	 *
	 * @return the vacancy candidate local service
	 */
	public vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalService getVacancyCandidateLocalService() {
		return vacancyCandidateLocalService;
	}

	/**
	 * Sets the vacancy candidate local service.
	 *
	 * @param vacancyCandidateLocalService the vacancy candidate local service
	 */
	public void setVacancyCandidateLocalService(
		vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalService vacancyCandidateLocalService) {
		this.vacancyCandidateLocalService = vacancyCandidateLocalService;
	}

	/**
	 * Returns the vacancy candidate remote service.
	 *
	 * @return the vacancy candidate remote service
	 */
	public vn.com.ecopharma.hrm.rc.service.VacancyCandidateService getVacancyCandidateService() {
		return vacancyCandidateService;
	}

	/**
	 * Sets the vacancy candidate remote service.
	 *
	 * @param vacancyCandidateService the vacancy candidate remote service
	 */
	public void setVacancyCandidateService(
		vn.com.ecopharma.hrm.rc.service.VacancyCandidateService vacancyCandidateService) {
		this.vacancyCandidateService = vacancyCandidateService;
	}

	/**
	 * Returns the vacancy candidate persistence.
	 *
	 * @return the vacancy candidate persistence
	 */
	public VacancyCandidatePersistence getVacancyCandidatePersistence() {
		return vacancyCandidatePersistence;
	}

	/**
	 * Sets the vacancy candidate persistence.
	 *
	 * @param vacancyCandidatePersistence the vacancy candidate persistence
	 */
	public void setVacancyCandidatePersistence(
		VacancyCandidatePersistence vacancyCandidatePersistence) {
		this.vacancyCandidatePersistence = vacancyCandidatePersistence;
	}

	/**
	 * Returns the vacancy evaluation criteria local service.
	 *
	 * @return the vacancy evaluation criteria local service
	 */
	public vn.com.ecopharma.hrm.rc.service.VacancyEvaluationCriteriaLocalService getVacancyEvaluationCriteriaLocalService() {
		return vacancyEvaluationCriteriaLocalService;
	}

	/**
	 * Sets the vacancy evaluation criteria local service.
	 *
	 * @param vacancyEvaluationCriteriaLocalService the vacancy evaluation criteria local service
	 */
	public void setVacancyEvaluationCriteriaLocalService(
		vn.com.ecopharma.hrm.rc.service.VacancyEvaluationCriteriaLocalService vacancyEvaluationCriteriaLocalService) {
		this.vacancyEvaluationCriteriaLocalService = vacancyEvaluationCriteriaLocalService;
	}

	/**
	 * Returns the vacancy evaluation criteria remote service.
	 *
	 * @return the vacancy evaluation criteria remote service
	 */
	public vn.com.ecopharma.hrm.rc.service.VacancyEvaluationCriteriaService getVacancyEvaluationCriteriaService() {
		return vacancyEvaluationCriteriaService;
	}

	/**
	 * Sets the vacancy evaluation criteria remote service.
	 *
	 * @param vacancyEvaluationCriteriaService the vacancy evaluation criteria remote service
	 */
	public void setVacancyEvaluationCriteriaService(
		vn.com.ecopharma.hrm.rc.service.VacancyEvaluationCriteriaService vacancyEvaluationCriteriaService) {
		this.vacancyEvaluationCriteriaService = vacancyEvaluationCriteriaService;
	}

	/**
	 * Returns the vacancy evaluation criteria persistence.
	 *
	 * @return the vacancy evaluation criteria persistence
	 */
	public VacancyEvaluationCriteriaPersistence getVacancyEvaluationCriteriaPersistence() {
		return vacancyEvaluationCriteriaPersistence;
	}

	/**
	 * Sets the vacancy evaluation criteria persistence.
	 *
	 * @param vacancyEvaluationCriteriaPersistence the vacancy evaluation criteria persistence
	 */
	public void setVacancyEvaluationCriteriaPersistence(
		VacancyEvaluationCriteriaPersistence vacancyEvaluationCriteriaPersistence) {
		this.vacancyEvaluationCriteriaPersistence = vacancyEvaluationCriteriaPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Certificate.class;
	}

	protected String getModelClassName() {
		return Certificate.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = certificatePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.CandidateLocalService.class)
	protected vn.com.ecopharma.hrm.rc.service.CandidateLocalService candidateLocalService;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.CandidateService.class)
	protected vn.com.ecopharma.hrm.rc.service.CandidateService candidateService;
	@BeanReference(type = CandidatePersistence.class)
	protected CandidatePersistence candidatePersistence;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.CandidateActionHistoryLocalService.class)
	protected vn.com.ecopharma.hrm.rc.service.CandidateActionHistoryLocalService candidateActionHistoryLocalService;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.CandidateActionHistoryService.class)
	protected vn.com.ecopharma.hrm.rc.service.CandidateActionHistoryService candidateActionHistoryService;
	@BeanReference(type = CandidateActionHistoryPersistence.class)
	protected CandidateActionHistoryPersistence candidateActionHistoryPersistence;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.CandidateEvaluationLocalService.class)
	protected vn.com.ecopharma.hrm.rc.service.CandidateEvaluationLocalService candidateEvaluationLocalService;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.CandidateEvaluationService.class)
	protected vn.com.ecopharma.hrm.rc.service.CandidateEvaluationService candidateEvaluationService;
	@BeanReference(type = CandidateEvaluationPersistence.class)
	protected CandidateEvaluationPersistence candidateEvaluationPersistence;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.CertificateLocalService.class)
	protected vn.com.ecopharma.hrm.rc.service.CertificateLocalService certificateLocalService;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.CertificateService.class)
	protected vn.com.ecopharma.hrm.rc.service.CertificateService certificateService;
	@BeanReference(type = CertificatePersistence.class)
	protected CertificatePersistence certificatePersistence;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.DocumentLocalService.class)
	protected vn.com.ecopharma.hrm.rc.service.DocumentLocalService documentLocalService;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.DocumentService.class)
	protected vn.com.ecopharma.hrm.rc.service.DocumentService documentService;
	@BeanReference(type = DocumentPersistence.class)
	protected DocumentPersistence documentPersistence;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.EmployeeInterviewScheduleLocalService.class)
	protected vn.com.ecopharma.hrm.rc.service.EmployeeInterviewScheduleLocalService employeeInterviewScheduleLocalService;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.EmployeeInterviewScheduleService.class)
	protected vn.com.ecopharma.hrm.rc.service.EmployeeInterviewScheduleService employeeInterviewScheduleService;
	@BeanReference(type = EmployeeInterviewSchedulePersistence.class)
	protected EmployeeInterviewSchedulePersistence employeeInterviewSchedulePersistence;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaLocalService.class)
	protected vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaLocalService evaluationCriteriaLocalService;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaService.class)
	protected vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaService evaluationCriteriaService;
	@BeanReference(type = EvaluationCriteriaPersistence.class)
	protected EvaluationCriteriaPersistence evaluationCriteriaPersistence;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaKeyValueLocalService.class)
	protected vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaKeyValueLocalService evaluationCriteriaKeyValueLocalService;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaKeyValueService.class)
	protected vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaKeyValueService evaluationCriteriaKeyValueService;
	@BeanReference(type = EvaluationCriteriaKeyValuePersistence.class)
	protected EvaluationCriteriaKeyValuePersistence evaluationCriteriaKeyValuePersistence;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.ExperienceLocalService.class)
	protected vn.com.ecopharma.hrm.rc.service.ExperienceLocalService experienceLocalService;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.ExperienceService.class)
	protected vn.com.ecopharma.hrm.rc.service.ExperienceService experienceService;
	@BeanReference(type = ExperiencePersistence.class)
	protected ExperiencePersistence experiencePersistence;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.InterviewLocalService.class)
	protected vn.com.ecopharma.hrm.rc.service.InterviewLocalService interviewLocalService;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.InterviewService.class)
	protected vn.com.ecopharma.hrm.rc.service.InterviewService interviewService;
	@BeanReference(type = InterviewPersistence.class)
	protected InterviewPersistence interviewPersistence;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalService.class)
	protected vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalService interviewScheduleLocalService;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.InterviewScheduleService.class)
	protected vn.com.ecopharma.hrm.rc.service.InterviewScheduleService interviewScheduleService;
	@BeanReference(type = InterviewSchedulePersistence.class)
	protected InterviewSchedulePersistence interviewSchedulePersistence;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.SkillService.class)
	protected vn.com.ecopharma.hrm.rc.service.SkillService skillService;
	@BeanReference(type = SkillPersistence.class)
	protected SkillPersistence skillPersistence;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.VacancyLocalService.class)
	protected vn.com.ecopharma.hrm.rc.service.VacancyLocalService vacancyLocalService;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.VacancyService.class)
	protected vn.com.ecopharma.hrm.rc.service.VacancyService vacancyService;
	@BeanReference(type = VacancyPersistence.class)
	protected VacancyPersistence vacancyPersistence;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalService.class)
	protected vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalService vacancyCandidateLocalService;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.VacancyCandidateService.class)
	protected vn.com.ecopharma.hrm.rc.service.VacancyCandidateService vacancyCandidateService;
	@BeanReference(type = VacancyCandidatePersistence.class)
	protected VacancyCandidatePersistence vacancyCandidatePersistence;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.VacancyEvaluationCriteriaLocalService.class)
	protected vn.com.ecopharma.hrm.rc.service.VacancyEvaluationCriteriaLocalService vacancyEvaluationCriteriaLocalService;
	@BeanReference(type = vn.com.ecopharma.hrm.rc.service.VacancyEvaluationCriteriaService.class)
	protected vn.com.ecopharma.hrm.rc.service.VacancyEvaluationCriteriaService vacancyEvaluationCriteriaService;
	@BeanReference(type = VacancyEvaluationCriteriaPersistence.class)
	protected VacancyEvaluationCriteriaPersistence vacancyEvaluationCriteriaPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private CertificateServiceClpInvoker _clpInvoker = new CertificateServiceClpInvoker();
}