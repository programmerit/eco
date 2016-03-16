create index IX_91CEB4BE on eco_rcp_Candidate (contactNumber);
create index IX_8433A947 on eco_rcp_Candidate (emailAddress);
create index IX_DA9BF2DE on eco_rcp_Candidate (identityCardNo);

create index IX_5731E75F on eco_rcp_CandidateActionHistory (candidateId);
create index IX_ACD495E3 on eco_rcp_CandidateActionHistory (candidateId, actionType);
create index IX_BD0B6F0D on eco_rcp_CandidateActionHistory (candidateId, actionType, action);

create index IX_8EE33E17 on eco_rcp_CandidateEvaluation (candidateId);

create index IX_6A8A4944 on eco_rcp_Certificate (className);
create index IX_9FD2B71F on eco_rcp_Certificate (className, classPK);

create index IX_E663793F on eco_rcp_Document (className, classPK);
create index IX_33EC8122 on eco_rcp_Document (className, classPK, fileEntryId);
create index IX_669957D2 on eco_rcp_Document (fileEntryId);

create index IX_D36F4E61 on eco_rcp_EmployeeInterviewSchedule (interviewScheduleId);

create index IX_5720EB04 on eco_rcp_EvaluationCriteria (className);
create index IX_E3360D5F on eco_rcp_EvaluationCriteria (className, classPK);
create index IX_6737C9D4 on eco_rcp_EvaluationCriteria (className, classPK, optionalClassName);
create index IX_BD1F2F0F on eco_rcp_EvaluationCriteria (className, classPK, optionalClassName, optionalClassPK);
create index IX_86CF80F on eco_rcp_EvaluationCriteria (className, optionalClassName);
create index IX_D51C20E7 on eco_rcp_EvaluationCriteria (name, type_);
create index IX_BFFFAE46 on eco_rcp_EvaluationCriteria (type_);

create index IX_C0C66E8B on eco_rcp_EvaluationCriteriaKeyValue (evaluationCriteriaId);
create index IX_9A779C1F on eco_rcp_EvaluationCriteriaKeyValue (evaluationCriteriaId, key_);

create index IX_F3F766B5 on eco_rcp_Experience (className);
create index IX_874128CE on eco_rcp_Experience (className, classPK);

create index IX_6523C87 on eco_rcp_InterviewSchedule (vacancyCandidateId);
create index IX_E9BB6685 on eco_rcp_InterviewSchedule (vacancyCandidateId, interviewId);
create index IX_56AB046D on eco_rcp_InterviewSchedule (vacancyCandidateId, status);

create index IX_96C58D16 on eco_rcp_Vacancy (deleted);
create index IX_C48242D2 on eco_rcp_Vacancy (name);
create index IX_877B1AC7 on eco_rcp_Vacancy (name, subUnitId, titlesId);
create index IX_75144BAD on eco_rcp_Vacancy (subUnitId, deleted);

create index IX_6D262AB2 on eco_rcp_VacancyCandidate (candidateId);
create index IX_C12F9798 on eco_rcp_VacancyCandidate (candidateId, status);
create index IX_5D3C32E3 on eco_rcp_VacancyCandidate (candidateId, type_);
create index IX_1DF6E2A on eco_rcp_VacancyCandidate (vacancyId);
create index IX_9F8C28C4 on eco_rcp_VacancyCandidate (vacancyId, candidateId);