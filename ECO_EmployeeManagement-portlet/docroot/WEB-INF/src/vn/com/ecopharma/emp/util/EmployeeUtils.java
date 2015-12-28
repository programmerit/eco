package vn.com.ecopharma.emp.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.dto.AddressObjectItem;
import vn.com.ecopharma.emp.dto.BankInfoObject;
import vn.com.ecopharma.emp.dto.DependentName;
import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.enumeration.ResignationType;
import vn.com.ecopharma.emp.model.District;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpBankInfo;
import vn.com.ecopharma.emp.service.EmpBankInfoLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmployeeLocalServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * @author TaoTran
 *
 */
public class EmployeeUtils {

	private static final String ZIP_CODE = "70000";

	private static final String EMAIL_SUFFIX = "@ecopharma.com.vn";

	private EmployeeUtils() {

	}

	/**
	 * @param documents
	 * @return
	 */
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
		try {
			final List<AddressObjectItem> results = new ArrayList<>();

			for (Address address : AddressLocalServiceUtil.getAddresses(
					companyId, clazzName, primaryKey)) {
				results.add(new AddressObjectItem(address, false));
			}
			return results;
		} catch (SystemException e) {
			writeDebugLog(EmployeeUtils.class, e);
		}
		return new ArrayList<>();
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
		return StringUtils.trimToEmpty(user.getFirstName()) + " "
				+ StringUtils.trimToEmpty(user.getMiddleName()) + " "
				+ StringUtils.trimToEmpty(user.getLastName());
	}

	/**
	 * @param fullname
	 * @return
	 */
	public static String getFirstNameFromFullname(String fullname) {
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

		String[] fullnameArr = fullname.split(" ");
		int length = fullnameArr.length;
		// check if employee just have first and last name only
		if (length == 2) {
			return StringUtils.EMPTY;
		}
		String middleName = StringUtils.EMPTY;
		for (int i = 1; i < length - 1; i++) {
			middleName += fullnameArr[i] + " ";
		}
		return middleName;
	}

	/**
	 * @param fullname
	 * @return
	 */
	public static String getLastNameFromFullname(String fullname) {
		if (StringUtils.trimToNull(fullname) == null)
			return StringUtils.EMPTY;
		String[] fullnameArr = fullname.split(" ");
		return fullnameArr[fullnameArr.length - 1];
	}

	/**
	 * @param fullname
	 * @return
	 */
	public static String generateUsername1(String fullname) {
		if (StringUtils.trimToNull(fullname) == null)
			return StringUtils.EMPTY;

		fullname = VNCharacterUtils.removeAccent(fullname).toLowerCase(); // NOSONAR
		StringBuilder resultBuilder = new StringBuilder();
		char firstChar = getFirstNameFromFullname(fullname).toCharArray()[0];

		String[] middleNameArr = getMiddleNameFromFullname(fullname).split(" ");
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
		resultBuilder.append(getLastNameFromFullname(fullname));
		return resultBuilder.toString();
	}

	/**
	 * @param fullname
	 * @return
	 */
	public static String generateUsername(String fullname) {
		if (StringUtils.trimToNull(fullname) == null)
			return StringUtils.EMPTY;
		fullname = StringUtils.stripAccents(fullname); // NOSONAR
		LogFactoryUtil.getLog(EmployeeUtils.class).info(
				"FULL NAME AFTER STRIPPING ACCENTS: " + fullname);

		StringBuilder resultBuilder = new StringBuilder();
		char firstChar = getFirstNameFromFullname(fullname).toCharArray()[0];

		String[] middleNameArr = getMiddleNameFromFullname(fullname).split(" ");
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
		resultBuilder.append(getLastNameFromFullname(fullname));
		String resultString = resultBuilder.toString().toLowerCase();
		resultString = resultString.replaceAll("đ", "d");
		LogFactoryUtil.getLog(EmployeeUtils.class).info(
				"USERNAME AFTER STRIPPING ACCENTS: " + fullname);
		return regenerateUsername(resultString, 1);
	}

	/**
	 * @param id
	 * @return
	 */
	public static Emp getEmployeeById(long id) {
		try {
			return EmpLocalServiceUtil.getEmp(id);
		} catch (PortalException e) {
			writeDebugLog(EmployeeUtils.class, e);
		} catch (SystemException e) {
			writeDebugLog(EmployeeUtils.class, e);
		}
		return null;
	}

	/**
	 * @param id
	 * @return
	 */
	public static Emp getEmpById(long id) {
		try {
			return EmpLocalServiceUtil.getEmp(id);
		} catch (PortalException e) {
			writeDebugLog(EmployeeUtils.class, e);
		} catch (SystemException e) {
			writeDebugLog(EmployeeUtils.class, e);
		}
		return null;
	}

	public static void deleteAllEmployeeAndEmployeeUser() {
		for (Emp employee : EmpLocalServiceUtil.findAll()) {
			try {
				UserLocalServiceUtil.deleteUser(employee.getEmpUserId());

				EmployeeLocalServiceUtil.deleteEmployee(employee.getEmpId());
			} catch (PortalException e) {
				writeDebugLog(EmployeeUtils.class, e);
			} catch (SystemException e) {
				writeDebugLog(EmployeeUtils.class, e);
			}
		}
	}

	public static List<Long> getIdsFromBasedModelList(List<BaseModel<?>> list) {
		final List<Long> ids = new ArrayList<>();
		for (BaseModel<?> obj : list) {
			ids.add(new Long(obj.getPrimaryKeyObj().toString()));
		}
		return ids;
	}

	public static ServiceContext getServiceContext() {
		return LiferayFacesContext.getInstance().getServiceContext();
	}

	public static long getCompanyId() {
		return getServiceContext().getCompanyId();
	}

	public static long getBaseModelPrimaryKey(BaseModel<?> model) {
		if (model == null)
			return 0;
		return Long.valueOf(String.valueOf(model.getPrimaryKeyObj()));
	}

	public static String generateEmailByUsername(String username) {
		return username + EMAIL_SUFFIX;
	}

	public static String regenerateUsername(String currentUsername,
			int increment) {

		try {
			if (UserLocalServiceUtil.fetchUserByScreenName(getServiceContext()
					.getCompanyId(), currentUsername) == null) {
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
			writeDebugLog(EmployeeUtils.class, e);
		}
		return currentUsername;
	}

	public static void writeOutputStreamToPipedOutputStream(
			ByteArrayOutputStream originOut, PipedOutputStream pipedOutputStream) {
		try {
			originOut.writeTo(pipedOutputStream);
			originOut.flush();
		} catch (IOException e) {
			LogFactoryUtil.getLog(EmployeeUtils.class).info(e);
		} finally {
			closeOutputStream(originOut);
			closeOutputStream(pipedOutputStream);
		}
	}

	private static void closeOutputStream(OutputStream outputStream) {
		if (outputStream != null) {
			try {
				outputStream.close();
			} catch (IOException e) {
				LogFactoryUtil.getLog(EmployeeUtils.class).info(e);
			}
		}
	}

	public static String exceptionStacktraceToString(Exception e) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps); // NOSONAR
		ps.close();
		return baos.toString();
	}

	public static void writeDebugLog(Class<?> clazz, Exception e) {
		final Log log = LogFactoryUtil.getLog(clazz);
		if (log.isDebugEnabled())
			log.debug(exceptionStacktraceToString(e));
	}

	public static List<String> getResignationTypes() {
		final List<String> result = new ArrayList<>();
		for (ResignationType resignationType : ResignationType.values()) {
			result.add(resignationType.toString());
		}
		return result;
	}

	public static String getLocalizedResignationType(String r) {
		return StringUtils.trimToNull(r) != null ? ResignationType.valueOf(r)
				.getLocalizedString() : StringUtils.EMPTY;
	}
}
