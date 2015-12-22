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

package vn.com.ecopharma.emp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.constant.EMInfo;
import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.enumeration.EmployeeStatus;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpBankInfo;
import vn.com.ecopharma.emp.model.PromotedHistory;
import vn.com.ecopharma.emp.model.ResignationHistory;
import vn.com.ecopharma.emp.service.base.EmpLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the emp local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.EmpLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.EmpLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.EmpLocalServiceUtil
 */
public class EmpLocalServiceImpl extends EmpLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.EmpLocalServiceUtil} to access the emp local
	 * service.
	 */

	public List<Emp> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<Emp> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<Emp> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return empPersistence.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public Emp findByEmpCode(String empCode) {
		try {
			return empPersistence.fetchByEmpCode(empCode);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Emp findByUser(long empUserId) {
		try {
			return empPersistence.fetchByUser(empUserId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.com.ecopharma.emp.service.EmpLocalService#
	 * isOnAddingNewWithSameEmployeeCode(long, java.lang.String)
	 */
	public boolean isOnAddingNewWithSameEmployeeCode(long prePersistedEmpId,
			String empCode) {
		try {
			return empPersistence.fetchByEmpCode(empCode) != null
					&& fetchEmp(prePersistedEmpId) == null;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int countAllUnDeletedIndexedEmpDocuments(
			SearchContext searchContext, List<Query> filterQueries,
			long companyId, Sort sort) {
		return searchAllUnDeletedEmpIndexedDocument(searchContext,
				filterQueries, companyId, sort, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS).size();
	}

	public List<Document> searchAllUnDeletedEmpIndexedDocument(
			SearchContext searchContext, List<Query> filterQueries,
			long companyId, Sort sort, int start, int end) {

		final BooleanQuery fullQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		final BooleanQuery allEmpEntriesBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		final BooleanQuery noneDeletedEmpsBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		allEmpEntriesBooleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				Emp.class.getName());
		noneDeletedEmpsBooleanQuery.addExactTerm(EmpField.IS_DELETED, "false");

		try {
			// add filter queries
			fullQuery.add(allEmpEntriesBooleanQuery, BooleanClauseOccur.MUST);
			if (filterQueries != null && filterQueries.size() > 0) {
				for (Query query : filterQueries) {
					fullQuery.add(query, BooleanClauseOccur.MUST);
				}
			}

			// always filter for none-delete item
			fullQuery.add(noneDeletedEmpsBooleanQuery, BooleanClauseOccur.MUST);

			System.out.println(fullQuery);
			final List<Document> documents = SearchEngineUtil.search(
					SearchEngineUtil.getDefaultSearchEngineId(), companyId,
					fullQuery, sort, start, end).toList();
			LogFactoryUtil.getLog(EmpLocalServiceImpl.class).info(
					"RESULT SIZE: " + documents.size());

			return documents;

		} catch (SearchException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Emp addEmp(ServiceContext serviceContext) {
		try {
			Emp emp = empPersistence.create(counterLocalService.increment());
			emp.setUserId(serviceContext.getUserId());
			emp.setGroupId(serviceContext.getScopeGroupId());
			emp.setCompanyId(serviceContext.getCompanyId());
			emp.setCreateDate(new Date());
			emp.setModifiedDate(new Date());
			emp = super.addEmp(emp);

			Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Emp.class);
			indexer.reindex(Emp.class.getName(), emp.getEmpId());
			return emp;
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SearchException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Emp addEmp(Emp e, boolean autoPassword, String password1,
			String password2, boolean autoScreenName, String screenName,
			String emailAddress, long facebookId, String openId, Locale locale,
			String firstName, String middleName, String lastName, int prefixId,
			int suffixId, boolean male, int birthdayMonth, int birthdayDay,
			int birthdayYear, long[] groupIds, long[] organizationIds,
			long[] roleIds,
			long[] userGroupIds,
			boolean sendEmail, // End user part
			long empUserId, Map<Address, Boolean> addresses,
			Map<String, Boolean> dependentNameMap, List<EmpBankInfo> bankInfos,
			ServiceContext serviceContext) throws SystemException,
			PortalException {
		// Add User Part
		final User user = UserLocalServiceUtil.addUser(
				serviceContext.getUserId(), serviceContext.getCompanyId(),
				autoPassword, password1, password2, autoScreenName, screenName,
				emailAddress, facebookId, openId, locale, firstName,
				middleName, lastName, prefixId, suffixId, male, birthdayMonth,
				birthdayDay, birthdayYear,
				titlesLocalService.getTitles(e.getTitlesId()).getName(),
				groupIds, organizationIds, roleIds, userGroupIds, sendEmail,
				serviceContext);

		e.setEmpUserId(user.getUserId());
		e.setUserId(serviceContext.getUserId());
		e.setGroupId(serviceContext.getScopeGroupId());
		e.setCompanyId(serviceContext.getCompanyId());
		e.setCreateDate(new Date(System.currentTimeMillis()));
		e.setModifiedDate(new Date(System.currentTimeMillis()));

		e.setStatus(EmployeeStatus.NEWLY_ADDED.toString());
		// Add to Emp_Titles History
		// employeeTitlesHistoryLocalService.addEmpTitlesHistory(e.getEmpId(),
		// e.getTitlesId(), "FIRST PROMOTED", e.getPromotedDate(),
		// serviceContext);

		// Add employee's addresses
		for (Map.Entry<Address, Boolean> address : addresses.entrySet()) {
			// check UIDeleted flag
			if (!address.getValue()) {
				final Address addressEntity = address.getKey();
				addressEntity.setClassName(Emp.class.getName());
				addressEntity.setClassPK(e.getEmpId());
				addressEntity.setCompanyId(serviceContext.getCompanyId());
				AddressLocalServiceUtil.updateAddress(addressEntity);
			}
		}

		// Add employee's dependences
		final StringBuilder namesBuilder = new StringBuilder();
		int dependentNamesCount = 0;
		for (Map.Entry<String, Boolean> entry : dependentNameMap.entrySet()) {
			if (!entry.getValue()
					&& StringUtils.trimToNull(entry.getKey()) != null) {
				namesBuilder.append(entry.getKey());
				namesBuilder.append(";");
				dependentNamesCount++;
			}
		}
		// set back to employee
		e.setNumberOfDependents(dependentNamesCount);
		e.setDependentNames(namesBuilder.toString());

		// Add employee's banking info
		for (EmpBankInfo empBankInfo : bankInfos) {
			empBankInfo.setEmpId(e.getEmpId());
			empBankInfoLocalService.addEmpBankInfo(empBankInfo, serviceContext);
		}

		// persist to DB
		Emp result = super.addEmp(e);

		// add permission
		resourceLocalService.addResources(e.getCompanyId(), e.getGroupId(),
				serviceContext.getUserId(), Emp.class.getName(), e.getEmpId(),
				false, true, true);

		// index new employee
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Emp.class);
		indexer.reindex(Emp.class.getName(), result.getEmpId());
		return result;
	}

	public Emp addEmp(Emp e, User user, Map<Address, Boolean> addresses,
			Map<String, Boolean> dependentNameMap, ServiceContext serviceContext)
			throws SystemException, PortalException {

		e.setBirthday(user.getBirthday());
		e.setEmpUserId(user.getUserId());
		e.setUserId(serviceContext.getUserId());
		e.setGroupId(serviceContext.getScopeGroupId());
		e.setCompanyId(serviceContext.getCompanyId());
		e.setCreateDate(new Date(System.currentTimeMillis()));
		e.setModifiedDate(new Date(System.currentTimeMillis()));

		e.setStatus(EmployeeStatus.NEWLY_ADDED.toString());
		// Add to Emp_Titles History
		// employeeTitlesHistoryLocalService.addEmpTitlesHistory(e.getEmpId(),
		// e.getTitlesId(), "FIRST PROMOTED", e.getPromotedDate(),
		// serviceContext);

		// Add employee's addresses
		for (Map.Entry<Address, Boolean> address : addresses.entrySet()) {
			// check UIDeleted flag
			if (!address.getValue()) {
				final Address addressEntity = address.getKey();
				addressEntity.setClassName(Emp.class.getName());
				addressEntity.setClassPK(e.getEmpId());
				addressEntity.setCompanyId(serviceContext.getCompanyId());
				AddressLocalServiceUtil.updateAddress(addressEntity);
			}
		}

		// Add employee's dependences
		final StringBuilder namesBuilder = new StringBuilder();
		int dependentNamesCount = 0;
		for (Map.Entry<String, Boolean> entry : dependentNameMap.entrySet()) {
			if (!entry.getValue()
					&& StringUtils.trimToNull(entry.getKey()) != null) {
				namesBuilder.append(entry.getKey());
				namesBuilder.append(";");
				dependentNamesCount++;
			}
		}
		// set back to employee
		e.setNumberOfDependents(dependentNamesCount);
		e.setDependentNames(namesBuilder.toString());

		// persist to DB
		Emp result = super.addEmp(e);

		// add permission
		resourceLocalService.addResources(e.getCompanyId(), e.getGroupId(),
				serviceContext.getUserId(), Emp.class.getName(), e.getEmpId(),
				false, true, true);

		// index new employee
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Emp.class);
		indexer.reindex(Emp.class.getName(), result.getEmpId());
		return result;
	}

	public Emp update(Emp employee, User user, long oldTitlesId,
			Map<Address, Boolean> addressesMap,
			Map<String, Boolean> dependentNameMap, boolean isImportAction,
			ServiceContext serviceContext) {
		try {
			boolean isPositionChanged = false;
			isPositionChanged = employee.getTitlesId() != oldTitlesId;
			employee.setModifiedDate(new Date(System.currentTimeMillis()));
			// Update User for Email, name info
			userPersistence.update(user);

			// Insert log (history) in case Employee is promoted to new position
			if (isPositionChanged) {
				employeeTitlesHistoryLocalService.addEmployeeTitlesHistory(
						employee.getEmpId(), employee.getTitlesId(),
						"PROMOTED TO NEW TITLES",
						new Date(System.currentTimeMillis()), serviceContext);
			}
			// check where update on Importing or not
			if (isImportAction) {
				final List<Address> addresses = AddressLocalServiceUtil
						.getAddresses(serviceContext.getCompanyId(),
								Emp.class.getName(), employee.getEmpId());
				// to ensure that the address will not be DUPLICATE while update
				// -> remove all
				for (Address address : addresses) {
					AddressLocalServiceUtil.deleteAddress(address
							.getAddressId());
				}
			}

			// update/add addresses
			for (Map.Entry<Address, Boolean> entry : addressesMap.entrySet()) {
				boolean isUIDeleted = entry.getValue();
				Address address = entry.getKey();
				if (!isUIDeleted) {
					if (AddressLocalServiceUtil.fetchAddress(address
							.getAddressId()) != null) {
						AddressLocalServiceUtil.updateAddress(address);
					} else {
						// create new Address
						address.setCompanyId(serviceContext.getCompanyId());
						address.setUserId(serviceContext.getUserId());
						address.setClassName(Emp.class.getName());
						address.setClassPK(employee.getEmpId());
						AddressLocalServiceUtil.updateAddress(address);
					}
				} else {
					AddressLocalServiceUtil.deleteAddress(address
							.getAddressId());
				}
			}

			// Add employee's dependences
			final StringBuilder namesBuilder = new StringBuilder();
			int dependentNamesCount = 0;
			for (Map.Entry<String, Boolean> entry : dependentNameMap.entrySet()) {
				if (!entry.getValue()) {
					if (StringUtils.trimToNull(entry.getKey()) != null) {
						namesBuilder.append(entry.getKey());
						namesBuilder.append(";");
						dependentNamesCount++;
					}
				}
			}
			// set back to employee
			employee.setNumberOfDependents(dependentNamesCount);
			employee.setDependentNames(namesBuilder.toString());

			employee = empPersistence.update(employee);
			if (employee != null) {
				resourceLocalService.updateResources(employee.getCompanyId(),
						employee.getGroupId(), Emp.class.getName(),
						employee.getEmpId(),
						serviceContext.getGroupPermissions(),
						serviceContext.getGuestPermissions());

				// re-index modified employee
				Indexer indexer = IndexerRegistryUtil
						.nullSafeGetIndexer(Emp.class);
				indexer.reindex(employee);
			}
			return employee;
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Emp createEmployee(String employeeCode, long titlesId, long levelId,
			Date promotedDate, Date joinedDate, Date laborContractSignedDate,
			Date laborContractExpiredDate, String laborContractType,
			int laborContractSignedTime, Date dob, String gender,
			String placeOfBirth, String education, String educationSpecialize,
			long universityId, String maritalStatus, String identityCardNo,
			Date issuedDate, String issuedPlace, String contactNumber,
			String companyEmailAddress, String taxCode, int numberOfDependents,
			String dependentNames, String insurranceCode,
			String healthInsuranceNo) {
		try {
			final long employeeId = CounterLocalServiceUtil.increment();
			final Emp employee = createEmp(employeeId);
			return setInfoToEmp(employee, employeeCode, titlesId, levelId,
					promotedDate, joinedDate, laborContractSignedDate,
					laborContractExpiredDate, laborContractType,
					laborContractSignedTime, dob, gender, placeOfBirth,
					education, educationSpecialize, universityId,
					maritalStatus, identityCardNo, issuedDate, issuedPlace,
					contactNumber, companyEmailAddress, taxCode,
					numberOfDependents, dependentNames, insurranceCode,
					healthInsuranceNo);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmpLocalServiceImpl.class).info(e);
		}
		return null;

	}

	public Emp updateExistedEmployee(Emp employee, String employeeCode,
			long titlesId, long levelId, Date promotedDate, Date joinedDate,
			Date laborContractSignedDate, Date laborContractExpiredDate,
			String laborContractType, int laborContractSignedTime, Date dob,
			String gender, String placeOfBirth, String education,
			String educationSpecialize, long universityId,
			String maritalStatus, String identityCardNo, Date issuedDate,
			String issuedPlace, String contactNumber,
			String companyEmailAddress, String taxCode, int numberOfDependents,
			String dependentNames, String insurranceCode,
			String healthInsuranceNo) {
		return setInfoToEmp(employee, employeeCode, titlesId, levelId,
				promotedDate, joinedDate, laborContractSignedDate,
				laborContractExpiredDate, laborContractType,
				laborContractSignedTime, dob, gender, placeOfBirth, education,
				educationSpecialize, universityId, maritalStatus,
				identityCardNo, issuedDate, issuedPlace, contactNumber,
				companyEmailAddress, taxCode, numberOfDependents,
				dependentNames, insurranceCode, healthInsuranceNo);
	}

	private Emp setInfoToEmp(Emp employee, String employeeCode, long titlesId,
			long levelId, Date promotedDate, Date joinedDate,
			Date laborContractSignedDate, Date laborContractExpiredDate,
			String laborContractType, int laborContractSignedTime, Date dob,
			String gender, String placeOfBirth, String education,
			String educationSpecialize, long universityId,
			String maritalStatus, String identityCardNo, Date issuedDate,
			String issuedPlace, String contactNumber,
			String companyEmailAddress, String taxCode, int numberOfDependents,
			String dependentNames, String insurranceCode,
			String healthInsuranceNo) {
		employee.setEmpCode(employeeCode);
		employee.setContactNumber(contactNumber);
		employee.setTitlesId(titlesId);
		employee.setLevelId(levelId);
		employee.setPromotedDate(promotedDate);
		employee.setJoinedDate(joinedDate);
		employee.setLaborContractSignedDate(laborContractSignedDate);
		employee.setLaborContractExpiredDate(laborContractExpiredDate);
		employee.setLaborContractType(laborContractType);
		employee.setLaborContractSignedTime(laborContractSignedTime);
		employee.setBirthday(dob);
		employee.setGender(gender);
		employee.setPlaceOfBirth(placeOfBirth);
		employee.setEducation(education);
		employee.setEducationSpecialize(educationSpecialize);
		employee.setUniversityId(universityId);
		employee.setMaritalStatus(maritalStatus);
		employee.setIdentityCardNo(identityCardNo);
		employee.setIssuedDate(issuedDate);
		employee.setIssuedPlace(issuedPlace);
		employee.setPersonalTaxCode(taxCode);
		employee.setNumberOfDependents(numberOfDependents);
		employee.setDependentNames(dependentNames);
		employee.setSocialInsuranceNo(insurranceCode);
		employee.setHealthInsuranceNo(healthInsuranceNo);
		return employee;
	}

	public List<Document> searchAllEmpDocs(SearchContext searchContext,
			List<Query> queries, long companyId) {
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);

		try {
			for (Query query : queries) {
				fullQuery.add(query, BooleanClauseOccur.MUST);
			}

			LogFactoryUtil.getLog(fullQuery.toString());

			return SearchEngineUtil.search(
					SearchEngineUtil.getDefaultSearchEngineId(), companyId,
					fullQuery, new Sort("empId", false), QueryUtil.ALL_POS,
					QueryUtil.ALL_POS).toList();
		} catch (SearchException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new ArrayList<Document>();
	}

	public Document getIndexedEmp(String employeeIdString,
			SearchContext searchContext) {
		return getIndexedEmp(Long.valueOf(employeeIdString), searchContext);
	}

	public Document getIndexedEmp(long employeeId, SearchContext searchContext) {
		searchContext.setPortletIds(new String[] { EMInfo.PORTLET_ID });
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME,
				Emp.class.getName());
		booleanQuery.addExactTerm(EmpField.EMP_ID, employeeId);

		try {
			fullQuery.add(booleanQuery, BooleanClauseOccur.MUST);
			Hits hits = SearchEngineUtil.search(searchContext, fullQuery);
			return !hits.toList().isEmpty() ? hits.toList().get(0) : null;
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SearchException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Emp markDeletedEmp(Emp employee) {
		try {
			employee.setDeleted(true);

			employee = empPersistence.update(employee);

			// re-index modified employee
			Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Emp.class
					.getName());
			indexer.reindex(employee);
			return employee;
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SearchException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Emp markDeletedEmp(long employeeId) {
		try {
			return markDeletedEmp(empPersistence.fetchByPrimaryKey(employeeId));
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * =================== OTHER FUNCTIONALITIES ===================
	 */

	public void indexAllEmps() {
		final Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(Emp.class.getName());
		final List<Emp> allEmps = findAll();
		for (Emp employee : allEmps) {
			// index employee
			try {
				indexer.reindex(employee);
			} catch (SearchException e) {
				e.printStackTrace();
			}
		}

	}

	public void indexSomeEmps() {
		final Indexer indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(Emp.class.getName());
		final List<Emp> emps = findAll(1, 10);
		for (Emp employee : emps) {
			// index employee
			try {
				indexer.reindex(employee);
			} catch (SearchException e) {
				e.printStackTrace();
			}
		}

	}

	public void removeAllEmpIndexes(SearchContext searchContext, long companyId) {
		final BooleanQuery booleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		booleanQuery.addExactTerm(Field.ENTRY_CLASS_NAME, Emp.class.getName());
		try {
			final Hits hits = SearchEngineUtil.search(
					SearchEngineUtil.getDefaultSearchEngineId(), companyId,
					booleanQuery, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			final List<Document> docs = hits.toList();
			for (Document doc : docs) {
				SearchEngineUtil.deleteDocument(
						SearchEngineUtil.getDefaultSearchEngineId(), companyId,
						doc.getUID());

			}
		} catch (SearchException e) {
			e.printStackTrace();
		}
	}

	public void completelyRemoveAllEmp(long companyId) {
		List<Emp> allEmps = findAll();
		try {
			for (Emp employee : allEmps) {
				// delete user first
				long userId = employee.getEmpUserId();
				final User user = userLocalService.deleteUser(userId);
				if (user != null) {
					final List<Address> employeeAddresses = AddressLocalServiceUtil
							.getAddresses(companyId, Emp.class.getName(),
									employee.getEmpId());
					for (Address address : employeeAddresses) {
						AddressLocalServiceUtil.deleteAddress(address
								.getAddressId());
					}

					Indexer indexer = IndexerRegistryUtil
							.nullSafeGetIndexer(Emp.class.getName());
					indexer.delete(employee);

					// delete promoted info of employee
					for (PromotedHistory p : promotedHistoryLocalService
							.findByEmployee(employee.getEmpId())) {
						promotedHistoryLocalService.deletePromotedHistory(p
								.getPromotedHistoryId());
					}

					// delete resignation info of employee
					for (ResignationHistory r : resignationHistoryLocalService
							.findByEmployee(employee.getEmpId())) {
						resignationHistoryLocalService
								.deleteResignationHistory(r
										.getResignationHistoryId());
					}

					LogFactoryUtil.getLog(EmpLocalServiceImpl.class).debug(
							"On Deleting Employee: " + employee.getEmpId());
					empLocalService.deleteEmp(employee.getEmpId());

				}
			}
		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmpLocalServiceImpl.class).info(e);
		} catch (PortalException e) {
			LogFactoryUtil.getLog(EmpLocalServiceImpl.class).info(e);
		}
	}
	
	public void completelyRemoveAllEmpFromDB(long companyId) {
		List<Emp> allEmps = findAll();
		try {
			for (Emp employee : allEmps) {
				// delete user first
				long userId = employee.getEmpUserId();
				final User user = userLocalService.deleteUser(userId);
				if (user != null) {
					final List<Address> employeeAddresses = AddressLocalServiceUtil
							.getAddresses(companyId, Emp.class.getName(),
									employee.getEmpId());
					for (Address address : employeeAddresses) {
						AddressLocalServiceUtil.deleteAddress(address
								.getAddressId());
					}

					// delete promoted info of employee
					for (PromotedHistory p : promotedHistoryLocalService
							.findByEmployee(employee.getEmpId())) {
						promotedHistoryLocalService.deletePromotedHistory(p
								.getPromotedHistoryId());
					}

					// delete resignation info of employee
					for (ResignationHistory r : resignationHistoryLocalService
							.findByEmployee(employee.getEmpId())) {
						resignationHistoryLocalService
								.deleteResignationHistory(r
										.getResignationHistoryId());
					}

					LogFactoryUtil.getLog(EmpLocalServiceImpl.class).debug(
							"On Deleting Employee: " + employee.getEmpId());
					empLocalService.deleteEmp(employee.getEmpId());

				}
			}
		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmpLocalServiceImpl.class).info(e);
		} catch (PortalException e) {
			LogFactoryUtil.getLog(EmpLocalServiceImpl.class).info(e);
		}
	}
}