package vn.com.ecopharma.hrm.rc.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.model.District;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpBankInfo;
import vn.com.ecopharma.emp.service.EmpBankInfoLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.constant.EmpField;
import vn.com.ecopharma.hrm.rc.dto.AddressObjectItem;
import vn.com.ecopharma.hrm.rc.dto.BankInfoObject;
import vn.com.ecopharma.hrm.rc.dto.DependentName;
import vn.com.ecopharma.hrm.rc.dto.EmpIndexedItem;
import vn.com.ecopharma.hrm.rc.dto.EmpInfoItem;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * @author TaoTran
 *
 */
public class EmployeeUtils {

	private static final String ZIP_CODE = "70000";

	private static final String EMAIL_SUFFIX = "@ecopharma.com.vn";

	private static final String BLANK_SPACE = " ";

	/**
	 * @param documents
	 * @return
	 */

	private EmployeeUtils() {

	}

	public static List<EmpIndexedItem> getEmployeeIndexedItemsFromIndexedDocuments(
			List<Document> documents) {

		final List<EmpIndexedItem> results = new ArrayList<>(documents.size());
		for (final Document document : documents) {
			results.add(new EmpIndexedItem(document));
		}
		return results;
	}

	/**
	 * @param clazzName
	 * @param primaryKey
	 * @param companyId
	 * @return
	 */
	public static List<AddressObjectItem> getAddressObjectItemsFromClassNameAndPK(
			String clazzName, long primaryKey, long companyId) {
		final List<AddressObjectItem> results = new ArrayList<>();
		try {
			for (Address address : AddressLocalServiceUtil.getAddresses(
					companyId, clazzName, primaryKey)) {
				results.add(new AddressObjectItem(address, false));
			}
			return results;
		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmployeeUtils.class).info(e);
		}
		return results;
	}

	/**
	 * @param items
	 * @return
	 */
	/**
	 * @param items
	 * @return
	 */
	public static Map<Address, Boolean> transferAddressObjectListToAddressMap(
			List<AddressObjectItem> items) {
		final Map<Address, Boolean> resultMap = new HashMap<>(items.size());
		for (AddressObjectItem item : items) {
			final District district = item.getDistrict();
			final Address address = item.getAddress();
			long countryId = item.getCountry() != null ? item.getCountry()
					.getCountryId() : address.getCountryId();
			long regionId = item.getRegion() != null ? item.getRegion()
					.getRegionId() : address.getRegionId();
			address.setCountryId(countryId);
			address.setRegionId(regionId);
			if (StringUtils.trimToNull(address.getStreet3()) == null)
				address.setStreet3(item.isUIDeleted() ? StringUtils.EMPTY
						: district.getRegionCode() + "_" + district.getName());
			address.setZip(ZIP_CODE);
			resultMap.put(address, item.isUIDeleted());
		}
		return resultMap;
	}

	/**
	 * @param items
	 * @return
	 */
	public static Map<String, Boolean> transferDependentNameObjectListToDependentNameMap(
			List<DependentName> items) {
		final Map<String, Boolean> resultMap = new HashMap<>();

		for (DependentName item : items) {
			resultMap.put(item.getName(), item.isUIDeleted());
		}
		return resultMap;
	}

	public static int numberOfValidDependentName(List<DependentName> items) {
		int count = 0;
		for (DependentName item : items) {
			if (!item.isUIDeleted())
				count++;
		}
		return count;
	}

	/**
	 * @param s
	 * @return
	 */
	public static List<DependentName> getDependentNamesFromString(String s) {
		final List<DependentName> result = new ArrayList<>();
		if (org.apache.commons.lang.StringUtils.trimToNull(s) == null) {
			return result;
		}
		String[] splitNames = s.split(";");
		for (int i = 0; i < splitNames.length; i++) {
			result.add(new DependentName(splitNames[i], Boolean.FALSE));
		}
		return result;
	}

	public static List<BankInfoObject> getBankInfoObjectsFromEmp(long empId) {
		final List<BankInfoObject> result = new ArrayList<>();
		final List<EmpBankInfo> empBankInfos = EmpBankInfoLocalServiceUtil
				.findByEmp(empId);
		if (empBankInfos.isEmpty())
			result.add(new BankInfoObject());

		for (EmpBankInfo item : empBankInfos) {
			result.add(new BankInfoObject(item));
		}
		return result;
	}

	public static Map<EmpBankInfo, Boolean> transferBankInfoObjectListToBankInfoMap(
			List<BankInfoObject> items) {
		final Map<EmpBankInfo, Boolean> resultMap = new HashMap<>();
		for (BankInfoObject obj : items) {
			resultMap.put(obj.getEmpBankInfo(), obj.isUIDeleted());
		}

		return resultMap;
	}

	public static Map<EmpBankInfo, Boolean> transferEmpBankInfoListToBankInfoMap(
			List<EmpBankInfo> items) {
		final Map<EmpBankInfo, Boolean> resultMap = new HashMap<>();
		for (EmpBankInfo obj : items) {
			resultMap.put(obj, false);
		}

		return resultMap;
	}

	/**
	 * @return
	 */
	public static SearchContext getCurrentSearchContext() {
		final LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();

		final PortletRequest req = (PortletRequest) liferayFacesContext
				.getExternalContext().getRequest();

		final HttpServletRequest httpServletRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(req));
		return SearchContextFactory.getInstance(httpServletRequest);
	}

	public static String getFullnameFromUser(User user) {
		return StringUtils.trimToEmpty(user.getLastName()) + BLANK_SPACE
				+ StringUtils.trimToEmpty(user.getMiddleName()) + BLANK_SPACE
				+ StringUtils.trimToEmpty(user.getFirstName());
	}

	public static String getViFullnameFromUser(User user) {
		return StringUtils.trimToEmpty(user.getLastName()) + BLANK_SPACE
				+ StringUtils.trimToEmpty(user.getMiddleName()) + BLANK_SPACE
				+ StringUtils.trimToEmpty(user.getFirstName());
	}

	/**
	 * @param fullname
	 * @return
	 */
	public static String getLastName(String fullname) {
		return StringUtils.trimToNull(fullname) == null ? StringUtils.EMPTY
				: fullname.split(" ")[0];
	}

	/**
	 * @param fullname
	 * @return
	 */
	public static String getMiddleNameFromFullname(String fullname) {
		if (StringUtils.trimToNull(fullname) == null)
			return StringUtils.EMPTY;

		String[] fullnameArr = fullname.split(BLANK_SPACE);
		int length = fullnameArr.length;
		// check if employee just have first and last name only
		if (length == 2) {
			return StringUtils.EMPTY;
		}
		String middleName = StringUtils.EMPTY;
		for (int i = 1; i < length - 1; i++) {
			middleName += fullnameArr[i] + BLANK_SPACE;
		}
		return middleName;
	}

	/**
	 * @param fullname
	 * @return
	 */
	public static String getFirstName(String fullname) {
		if (StringUtils.trimToNull(fullname) == null)
			return StringUtils.EMPTY;
		String[] fullnameArr = fullname.split(BLANK_SPACE);
		return fullnameArr[fullnameArr.length - 1];
	}

	public static String generateOriginalUsername(String fullname) {
		if (StringUtils.trimToNull(fullname) == null)
			return StringUtils.EMPTY;
		fullname = StringUtils.stripAccents(fullname); // NOSONAR
		LogFactoryUtil.getLog(EmployeeUtils.class).info(
				"FULL NAME AFTER STRIPPING ACCENTS: " + fullname);

		StringBuilder resultBuilder = new StringBuilder();
		char firstChar = getLastName(fullname).toCharArray()[0];

		String[] middleNameArr = getMiddleNameFromFullname(fullname).split(
				BLANK_SPACE);
		char[] middleNameChars;
		if (middleNameArr.length > 0 && middleNameArr[0] != StringUtils.EMPTY) {
			middleNameChars = new char[middleNameArr.length];
			for (int i = 0; i < middleNameChars.length; i++) {
				middleNameChars[i] = middleNameArr[i].charAt(0);
			}
		} else {
			middleNameChars = null;
		}

		resultBuilder.append(firstChar);
		if (middleNameChars != null) {
			resultBuilder.append(middleNameChars);
		}
		resultBuilder.append(getFirstName(fullname));
		String resultString = resultBuilder.toString().toLowerCase();
		resultString = resultString.replaceAll("đ", "d");
		LogFactoryUtil.getLog(EmployeeUtils.class).info(
				"USERNAME AFTER STRIPPING ACCENTS: " + fullname);
		return resultString;
	}

	/**
	 * @param fullname
	 * @return
	 */
	public static String generateUsername(String fullname) {
		String resultString = generateOriginalUsername(fullname);
		return regenerateUsername(resultString, 1);
	}

	public static String generateEmailByUsername(String username) {
		return username + EMAIL_SUFFIX;
	}

	public static String regenerateUsername(String currentUsername,
			int increment) {

		try {
			if (UserLocalServiceUtil.fetchUserByScreenName(LiferayFacesContext
					.getInstance().getServiceContext().getCompanyId(),
					currentUsername) == null) {
				return currentUsername;
			}

			if (increment > 1) {
				currentUsername = currentUsername.substring(0, // NOSONAR
						currentUsername.length() - 1) + increment;
			} else {
				currentUsername = currentUsername + increment; // NOSONAR
			}

			increment += 1; // NOSONAR
			return regenerateUsername(currentUsername, increment);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmployeeUtils.class).info(e);
		}
		return currentUsername;
	}

	/**
	 * @param id
	 * @return
	 */
	public static Emp getEmpById(long id) {
		try {
			return EmpLocalServiceUtil.getEmp(id);
		} catch (PortalException e) {
			LogFactoryUtil.getLog(EmployeeUtils.class).info(e);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmployeeUtils.class).info(e);
		}
		return null;
	}

	/**
	 * Provide at least 2 employee's name characters to search employee
	 * 
	 * @param query
	 * @return
	 */
	public static List<EmpIndexedItem> searchEmpByName(String query) {
		final List<EmpIndexedItem> filteredItems = new ArrayList<>();
		final SearchContext searchContext = RCUtils.getCurrentSearchContext();
		try {
			final BooleanQuery fullNameFilterBooleanQuery = BooleanQueryFactoryUtil
					.create(searchContext);
			fullNameFilterBooleanQuery.addTerm(EmpField.FULL_NAME, query, true,
					BooleanClauseOccur.MUST);
			final List<Query> queries = new ArrayList<>();

			queries.add(fullNameFilterBooleanQuery);
			Sort sort = new Sort();
			sort.setFieldName(EmpField.EMP_ID);
			final List<Document> docs = EmpLocalServiceUtil
					.searchAllUnDeletedEmpIndexedDocument(searchContext,
							queries, searchContext.getCompanyId(), sort,
							QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (Document doc : docs) {
				filteredItems.add(new EmpIndexedItem(doc));
			}
			return filteredItems;
		} catch (ParseException e) {
			LogFactoryUtil.getLog(EmployeeUtils.class).info(e);
		}
		return filteredItems;
	}

	public static long getBaseModelPrimaryKey(BaseModel<?> model) {
		if (model == null)
			return 0;
		return Long.valueOf(String.valueOf(model.getPrimaryKeyObj()));
	}

	public static void setAttributesToEmpFromEditItem(Emp employee,
			EmpInfoItem empInfoItem) {
		employee.setTitlesId(getBaseModelPrimaryKey(empInfoItem.getTitles()));

		employee.setUnitGroupId(getBaseModelPrimaryKey(empInfoItem
				.getUnitGroup()));

		employee.setUnitId(getBaseModelPrimaryKey(empInfoItem.getUnit()));

		employee.setDepartmentId(getBaseModelPrimaryKey(empInfoItem
				.getDepartment()));

		employee.setLevelId(getBaseModelPrimaryKey(empInfoItem.getLevel()));
		employee.setUniversityId(getBaseModelPrimaryKey(empInfoItem
				.getUniversity()));
	}

}
