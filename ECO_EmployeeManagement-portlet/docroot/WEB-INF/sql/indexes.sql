create index IX_6AF09BB2 on eco_em_portlet_Certificate (certificateType);
create index IX_6F35C33F on eco_em_portlet_Certificate (className, classPK);
create index IX_1E579D02 on eco_em_portlet_Certificate (className, classPK, certificateType);

create index IX_CC3BB87E on eco_em_portlet_Department (devisionId);
create index IX_F722FD3D on eco_em_portlet_Department (name, devisionId);
create index IX_CAEC7918 on eco_em_portlet_Department (name, unitId);
create index IX_685EFCD9 on eco_em_portlet_Department (unitId);

create index IX_876A9F7E on eco_em_portlet_Devision (departmentId);
create index IX_9C73A17C on eco_em_portlet_Devision (name);
create index IX_F639B33D on eco_em_portlet_Devision (name, departmentId);

create index IX_79FB0426 on eco_em_portlet_DevisionGroup (devisionId);
create index IX_4414EAE5 on eco_em_portlet_DevisionGroup (name, devisionId);

create index IX_2E4AB057 on eco_em_portlet_District (regionCode);
create index IX_765F22D6 on eco_em_portlet_District (regionCode, name);

create index IX_2E18E11F on eco_em_portlet_Document (className, classPK);
create index IX_E7D74E88 on eco_em_portlet_Document (className, classPK, documentType);
create index IX_F26BFDD8 on eco_em_portlet_Document (documentType);
create index IX_1BF70BF2 on eco_em_portlet_Document (fileEntryId);

create index IX_D6092545 on eco_em_portlet_Emp (empCode);
create index IX_9C3E31DE on eco_em_portlet_Emp (empUserId);
create index IX_D6D1DE66 on eco_em_portlet_Emp (status);
create index IX_F272A48A on eco_em_portlet_Emp (titlesId);

create index IX_90AA9689 on eco_em_portlet_EmpBankInfo (empId);

create index IX_9FE130A5 on eco_em_portlet_EmpNotifyEmail (status);

create index IX_574F6C0B on eco_em_portlet_EmpOrgRelationship (empId);
create index IX_2ACF551C on eco_em_portlet_EmpOrgRelationship (empId, orgClassName, orgClassPK, headOfOrg);
create index IX_B7C33EDE on eco_em_portlet_EmpOrgRelationship (orgClassName, orgClassPK);
create index IX_5971BA94 on eco_em_portlet_EmpOrgRelationship (orgClassName, orgClassPK, deputyOfOrg);
create index IX_33B3165F on eco_em_portlet_EmpOrgRelationship (orgClassName, orgClassPK, headOfOrg);

create index IX_88F3517B on eco_em_portlet_Level (name);

create index IX_E1D2C12C on eco_em_portlet_Location (type_);

create index IX_2ED639A5 on eco_em_portlet_PromotedHistory (employeeId);
create index IX_EFECE7FE on eco_em_portlet_PromotedHistory (newTitlesId);
create index IX_7522FC5 on eco_em_portlet_PromotedHistory (oldTitlesId);

create index IX_561D4740 on eco_em_portlet_ResignationHistory (employeeId);

create index IX_2ED53758 on eco_em_portlet_ResourceConfig (key_);
create index IX_12CABF7D on eco_em_portlet_ResourceConfig (key_, type_);
create index IX_A98F64D1 on eco_em_portlet_ResourceConfig (type_);

create index IX_741AEFD3 on eco_em_portlet_Specialized (level);
create index IX_2B56E92C on eco_em_portlet_Specialized (level, parentId);
create index IX_FEA9F140 on eco_em_portlet_Specialized (name);

create index IX_F9B34D5B on eco_em_portlet_SubUnit (name);

create index IX_72E37C70 on eco_em_portlet_Titles (departmentId);
create index IX_4BFB1B83 on eco_em_portlet_Titles (departmentId, unitId, unitGroupId);
create index IX_D0104CF2 on eco_em_portlet_Titles (devisionGroupId);
create index IX_F0E46187 on eco_em_portlet_Titles (devisionId);
create index IX_2509906E on eco_em_portlet_Titles (name);
create index IX_444192AF on eco_em_portlet_Titles (name, departmentId);
create index IX_240F1A53 on eco_em_portlet_Titles (name, devisionGroupId);
create index IX_1633F96C on eco_em_portlet_Titles (name, devisionGroupId, devisionId, departmentId);
create index IX_D700FB86 on eco_em_portlet_Titles (name, devisionId);
create index IX_FF6126E1 on eco_em_portlet_Titles (name, subUnitId);
create index IX_4DCF12D8 on eco_em_portlet_Titles (name, unitGroupId);
create index IX_4833F7CC on eco_em_portlet_Titles (name, unitGroupId, unitId, departmentId);
create index IX_680F03E1 on eco_em_portlet_Titles (name, unitId);
create index IX_C6687CC0 on eco_em_portlet_Titles (subUnitId);
create index IX_70586CF7 on eco_em_portlet_Titles (unitGroupId);
create index IX_59DF60AB on eco_em_portlet_Titles (unitGroupId, unitId, departmentId);
create index IX_89CF9262 on eco_em_portlet_Titles (unitId);
create index IX_7FF6DD64 on eco_em_portlet_Titles (unitId, unitGroupId);

create index IX_9E27BF63 on eco_em_portlet_TitlesDepartmentUnitUnitGroup (departmentId);
create index IX_BE443E70 on eco_em_portlet_TitlesDepartmentUnitUnitGroup (departmentId, unitId, unitGroupId);
create index IX_53A3EAAC on eco_em_portlet_TitlesDepartmentUnitUnitGroup (titlesId);
create index IX_9696BFA6 on eco_em_portlet_TitlesDepartmentUnitUnitGroup (titlesId, departmentId, unitId, unitGroupId);
create index IX_D4D67FA4 on eco_em_portlet_TitlesDepartmentUnitUnitGroup (unitGroupId);
create index IX_271C795 on eco_em_portlet_TitlesDepartmentUnitUnitGroup (unitId);
create index IX_8881F311 on eco_em_portlet_TitlesDepartmentUnitUnitGroup (unitId, unitGroupId);

create index IX_E5C4D1D2 on eco_em_portlet_TitlesUnitUnitGroup (departmentId, unitId, titlesId);
create index IX_9C898E48 on eco_em_portlet_TitlesUnitUnitGroup (departmentId, unitId, unitGroupId, titlesId);
create index IX_15EE9E9E on eco_em_portlet_TitlesUnitUnitGroup (titlesId);
create index IX_7CA0C215 on eco_em_portlet_TitlesUnitUnitGroup (titlesId, unitId, unitGroupId);
create index IX_C818EE72 on eco_em_portlet_TitlesUnitUnitGroup (unitGroupId);
create index IX_535CD007 on eco_em_portlet_TitlesUnitUnitGroup (unitId);
create index IX_D087B3DF on eco_em_portlet_TitlesUnitUnitGroup (unitId, unitGroupId);

create index IX_F6B93659 on eco_em_portlet_Unit (departmentId);
create index IX_5F684357 on eco_em_portlet_Unit (name);
create index IX_5AB479D8 on eco_em_portlet_Unit (name, departmentId);

create index IX_641BF4C5 on eco_em_portlet_UnitGroup (name, unitId);
create index IX_B0BFE46 on eco_em_portlet_UnitGroup (unitId);

create index IX_D75F6660 on eco_em_portlet_University (code_);
create index IX_31BCD7E1 on eco_em_portlet_University (name);