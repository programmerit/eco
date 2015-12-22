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
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	regionCode VARCHAR(75) null,
	name VARCHAR(75) null
);

create table eco_em_portlet_Emp (
	empId LONG not null primary key,
	groupId LONG,
	empCode VARCHAR(75) null,
	contactNumber VARCHAR(75) null,
	birthday DATE null,
	ethnic VARCHAR(75) null,
	nationality VARCHAR(75) null,
	religion VARCHAR(75) null,
	joinedDate DATE null,
	titlesId LONG,
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
	universityId LONG,
	maritalStatus VARCHAR(75) null,
	identityCardNo VARCHAR(75) null,
	issuedDate DATE null,
	issuedPlace VARCHAR(75) null,
	passport VARCHAR(75) null,
	addressId LONG,
	companyEmail VARCHAR(75) null,
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


create table eco_em_portlet_Titles (
	titlesId LONG not null primary key,
	name VARCHAR(75) null,
	unitGroupId LONG,
	unitId LONG,
	departmentId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
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