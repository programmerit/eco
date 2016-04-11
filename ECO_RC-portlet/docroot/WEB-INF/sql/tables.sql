create table eco_rcp_Candidate (
	candidateId LONG not null primary key,
	candidateCode VARCHAR(75) null,
	fullName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	contactNumber VARCHAR(75) null,
	dateOfBirth DATE null,
	placeOfBirth VARCHAR(75) null,
	gender VARCHAR(75) null,
	identityCardNo VARCHAR(75) null,
	issuedDate DATE null,
	issuedPlace VARCHAR(75) null,
	maritalStatus VARCHAR(75) null,
	numberOfChild INTEGER,
	nationalityId LONG,
	ethnic VARCHAR(75) null,
	religion VARCHAR(75) null,
	applicationDate DATE null,
	status VARCHAR(75) null,
	deleted BOOLEAN,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null
);

create table eco_rcp_CandidateActionHistory (
	candidateActionHistoryId LONG not null primary key,
	candidateId LONG,
	action VARCHAR(75) null,
	actionType VARCHAR(75) null,
	executedBy LONG,
	date_ DATE null,
	description VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_rcp_CandidateEvaluation (
	candidateEvaluationId LONG not null primary key,
	candidateId LONG,
	interviewId LONG,
	evaluationCriteriaKeyValueId LONG,
	ratingPoint INTEGER,
	note VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_rcp_Certificate (
	certificateId LONG not null primary key,
	className VARCHAR(75) null,
	classPK LONG,
	name VARCHAR(75) null,
	certificateType VARCHAR(75) null,
	universityId LONG,
	graduationYear INTEGER,
	grade VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	courseTimeFrom DATE null,
	courseTimeTo DATE null
);

create table eco_rcp_Document (
	documentId LONG not null primary key,
	className VARCHAR(75) null,
	classPK LONG,
	type_ VARCHAR(75) null,
	fileEntryId LONG,
	deleted BOOLEAN,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_rcp_EmployeeInterviewSchedule (
	employeeInterviewScheduleId LONG not null primary key,
	employeeId LONG,
	interviewScheduleId LONG,
	note VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_rcp_EvaluationCriteria (
	evaluationCriteriaId LONG not null primary key,
	type_ VARCHAR(75) null,
	name VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_rcp_EvaluationCriteriaKeyValue (
	evaluationCriteriaKeyValueId LONG not null primary key,
	evaluationCriteriaId LONG,
	key_ VARCHAR(75) null,
	value INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_rcp_Experience (
	experienceId LONG not null primary key,
	className VARCHAR(75) null,
	classPK LONG,
	companyName VARCHAR(75) null,
	workingPlace VARCHAR(75) null,
	yearsExperience DOUBLE,
	tel VARCHAR(75) null,
	workingFrom DATE null,
	workingTo DATE null,
	initialTitles VARCHAR(75) null,
	finalTitles VARCHAR(75) null,
	initialSalary DOUBLE,
	finalSalary DOUBLE,
	field VARCHAR(75) null,
	manager VARCHAR(75) null,
	responsibility VARCHAR(75) null,
	resignedReason VARCHAR(75) null,
	description VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_rcp_Interview (
	interviewId LONG not null primary key,
	name VARCHAR(75) null,
	titlesId LONG,
	deleted BOOLEAN,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_rcp_InterviewSchedule (
	interviewScheduleId LONG not null primary key,
	vacancyCandidateId LONG,
	interviewId LONG,
	interviewDate DATE null,
	interviewTime VARCHAR(75) null,
	status VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_rcp_Skill (
	skillId LONG not null primary key,
	candidateId LONG,
	grade VARCHAR(75) null,
	type_ VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_rcp_Vacancy (
	vacancyId LONG not null primary key,
	approvedNumberOfPosition INTEGER,
	currentNumberOfEmployee INTEGER,
	titlesId LONG,
	unitGroupId LONG,
	unitId LONG,
	departmentId LONG,
	numberOfNewRecruitment INTEGER,
	numberOfReplacedRecruitment INTEGER,
	expectedSalary DOUBLE,
	expectedJoinedDate DATE null,
	workPlaceId LONG,
	generalRequirements TEXT null,
	description TEXT null,
	requiredGender VARCHAR(75) null,
	certificateType VARCHAR(75) null,
	specialized VARCHAR(75) null,
	experiences DOUBLE,
	foreignLanguages VARCHAR(75) null,
	skills VARCHAR(75) null,
	officeSkills VARCHAR(75) null,
	awayToBusinessType VARCHAR(75) null,
	workingTimeType VARCHAR(75) null,
	jobType VARCHAR(75) null,
	code_ VARCHAR(75) null,
	status VARCHAR(75) null,
	postedDate DATE null,
	expiredDate DATE null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	deleted BOOLEAN
);

create table eco_rcp_VacancyCandidate (
	vacancyCandidateId LONG not null primary key,
	vacancyId LONG,
	candidateId LONG,
	status INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	type_ VARCHAR(75) null
);

create table eco_rcp_VacancyEvaluationCriteria (
	vacancyEvaluationCriteriaId LONG not null primary key,
	vacancyId LONG,
	evaluationCriteriaId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);