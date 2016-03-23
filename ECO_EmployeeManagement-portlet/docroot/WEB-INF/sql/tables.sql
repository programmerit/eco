create table eco_em_portlet_Certificate (
	certificateId LONG not null primary key,
	className VARCHAR(75) null,
	classPK LONG,
	education VARCHAR(75) null,
	certificateType VARCHAR(75) null,
	name VARCHAR(75) null,
	specialize VARCHAR(75) null,
	coursePlace LONG,
	graduatedYear DATE null,
	grade VARCHAR(75) null,
	courseType VARCHAR(75) null,
	expiredDate DATE null,
	issuedPlace VARCHAR(75) null,
	note VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_Department (
	departmentId LONG not null primary key,
	name VARCHAR(75) null,
	devisionId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_Devision (
	devisionId LONG not null primary key,
	name VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_DevisionGroup (
	devisionGroupId LONG not null primary key,
	name VARCHAR(75) null,
	devisionId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_District (
	districtId LONG not null primary key,
	regionCode VARCHAR(75) null,
	districtType VARCHAR(75) null,
	name VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_Document (
	documentId LONG not null primary key,
	className VARCHAR(75) null,
	classPK LONG,
	fileEntryId LONG,
	documentType VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_Emp (
	empId LONG not null primary key,
	groupId LONG,
	empCode VARCHAR(75) null,
	contactNumber VARCHAR(75) null,
	internalNumber VARCHAR(75) null,
	birthday DATE null,
	ethnic VARCHAR(75) null,
	nationality VARCHAR(75) null,
	religion VARCHAR(75) null,
	joinedDate DATE null,
	titlesId LONG,
	unitGroupId LONG,
	unitId LONG,
	departmentId LONG,
	levelId LONG,
	promotedDate DATE null,
	laborContractSignedDate DATE null,
	laborContractExpiredDate DATE null,
	laborContractSignedTime INTEGER,
	laborContractType VARCHAR(75) null,
	gender VARCHAR(75) null,
	placeOfBirth VARCHAR(75) null,
	education VARCHAR(75) null,
	educationSpecialize VARCHAR(75) null,
	specializeId LONG,
	universityId LONG,
	maritalStatus VARCHAR(75) null,
	identityCardNo VARCHAR(75) null,
	issuedDate DATE null,
	issuedPlace VARCHAR(75) null,
	passport VARCHAR(75) null,
	addressId LONG,
	personalEmail VARCHAR(75) null,
	personalTaxCode VARCHAR(75) null,
	numberOfDependents INTEGER,
	dependentNames VARCHAR(75) null,
	socialInsuranceNo VARCHAR(75) null,
	healthInsuranceNo VARCHAR(75) null,
	healthInsurancePlace VARCHAR(75) null,
	baseWageRates DOUBLE,
	positionWageRates DOUBLE,
	capacitySalary DOUBLE,
	totalSalary DOUBLE,
	bonus DOUBLE,
	resignedDate DATE null,
	empUserId LONG,
	deleted BOOLEAN,
	companyEmailAddress VARCHAR(75) null,
	workingPlaceId LONG,
	status VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_EmpAnnualLeave (
	empAnnualLeaveId LONG not null primary key,
	empId LONG,
	totalAnualLeaveLeft DOUBLE,
	totalAnnualLeave DOUBLE,
	totalPreviousYearLeavesLeft DOUBLE,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_EmpAnualLeave (
	empAnualLeaveId LONG not null primary key,
	empId LONG,
	noOfAnualLeave DOUBLE,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_EmpBankInfo (
	empBankInfoId LONG not null primary key,
	empId LONG,
	bankAccountNo VARCHAR(75) null,
	bankName VARCHAR(75) null,
	branchName VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_EmpConcurrentTitles (
	empConcurrentTitlesId LONG not null primary key,
	empId LONG,
	titlesId LONG,
	unitGroupId LONG,
	unitId LONG,
	departmentId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_EmpDiscipline (
	empDisciplineId LONG not null primary key,
	empId LONG,
	decisionNo VARCHAR(75) null,
	content VARCHAR(1000) null,
	disciplineType VARCHAR(75) null,
	effectiveDate DATE null,
	additionalDisciplineType VARCHAR(75) null,
	description VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	deleted BOOLEAN
);

create table eco_em_portlet_EmpLaborContract (
	empLaborContractId LONG not null primary key,
	empId LONG,
	laborContractSignedDate DATE null,
	laborContractExpiredDate DATE null,
	laborContractSignedType VARCHAR(75) null,
	signedTimes INTEGER,
	latest BOOLEAN,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_EmpNotifyEmail (
	empNotifyEmailId LONG not null primary key,
	empId LONG,
	notifyType VARCHAR(75) null,
	status VARCHAR(75) null
);

create table eco_em_portlet_EmpOrgRelationship (
	empOrgRelationshipId LONG not null primary key,
	empId LONG,
	orgClassName VARCHAR(75) null,
	orgClassPK LONG,
	headOfOrg BOOLEAN,
	deputyOfOrg BOOLEAN,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_EmployeeTitlesHistory (
	employeeTitlesHistoryId LONG not null primary key,
	employeeId LONG,
	titlesId LONG,
	setDate DATE null,
	note VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_Level (
	levelId LONG not null primary key,
	name VARCHAR(75) null,
	level INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_Location (
	locationId LONG not null primary key,
	name VARCHAR(75) null,
	addressId LONG,
	type_ VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_PromotedHistory (
	promotedHistoryId LONG not null primary key,
	employeeId LONG,
	oldTitlesId LONG,
	newTitlesId LONG,
	promotedDate DATE null,
	comment_ VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	deleted BOOLEAN
);

create table eco_em_portlet_ResignationHistory (
	resignationHistoryId LONG not null primary key,
	employeeId LONG,
	resignedDate DATE null,
	resignedType VARCHAR(75) null,
	comment_ VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	deleted BOOLEAN
);

create table eco_em_portlet_ResourceConfig (
	resourceConfigId LONG not null primary key,
	key_ VARCHAR(75) null,
	value VARCHAR(2000) null,
	type_ VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);


create table eco_em_portlet_Specialized (
	specializedId LONG not null primary key,
	specializedCode VARCHAR(75) null,
	name VARCHAR(256) null,
	level INTEGER,
	parentId LONG,
	university BOOLEAN,
	college BOOLEAN,
	vocationalCollege BOOLEAN,
	vocational BOOLEAN,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_Titles (
	titlesId LONG not null primary key,
	name VARCHAR(75) null,
	name_en VARCHAR(75) null,
	code_ VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_TitlesDepartmentUnitUnitGroup (
	titlesDepartmentUnitUnitGroupId LONG not null primary key,
	titlesId LONG,
	departmentId LONG,
	unitId LONG,
	unitGroupId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_TitlesUnitUnitGroup (
	titlesUnitUnitGroupId LONG not null primary key,
	titlesId LONG,
	unitId LONG,
	unitGroupId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_Unit (
	unitId LONG not null primary key,
	name VARCHAR(75) null,
	departmentId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_UnitGroup (
	unitGroupId LONG not null primary key,
	name VARCHAR(75) null,
	unitId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_University (
	universityId LONG not null primary key,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	tel_fax VARCHAR(250) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table eco_em_portlet_VacationLeave (
	vacationLeaveId LONG not null primary key,
	empId LONG,
	leaveType VARCHAR(75) null,
	sign VARCHAR(75) null,
	leaveFrom DATE null,
	leaveTo DATE null,
	actualTo DATE null,
	numberOfHours INTEGER,
	reason VARCHAR(75) null,
	description VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	deleted BOOLEAN,
	status VARCHAR(75) null
);

create table eco_em_portlet_WorkingLocation (
	workingLocationId LONG not null primary key,
	name VARCHAR(75) null,
	locationId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);