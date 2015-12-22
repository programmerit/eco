create table eco_ttp_TimeTracking (
	timeTrackingId LONG not null primary key,
	empId LONG,
	date_ DATE null,
	in1 DATE null,
	out1 DATE null,
	in2 DATE null,
	out2 DATE null,
	in3 DATE null,
	out3 DATE null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);