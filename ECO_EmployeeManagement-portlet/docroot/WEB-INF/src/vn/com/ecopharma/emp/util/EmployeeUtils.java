package vn.com.ecopharma.emp.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.dto.AbstractBaseModelItem;
import vn.com.ecopharma.emp.dto.AddressObjectItem;
import vn.com.ecopharma.emp.dto.BankInfoObject;
import vn.com.ecopharma.emp.dto.DependentName;
import vn.com.ecopharma.emp.dto.DocumentItem;
import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.dto.LaborContractItem;
import vn.com.ecopharma.emp.enumeration.ResignationType;
import vn.com.ecopharma.emp.model.District;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpBankInfo;
import vn.com.ecopharma.emp.model.EmpLaborContract;
import vn.com.ecopharma.emp.service.DocumentLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpBankInfoLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLaborContractLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmployeeLocalServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.faces.util.portal.WebKeys;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.AddressServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * @author TaoTran
 *
 */
public class EmployeeUtils {

	private static final String ZIP_CODE = "70000";

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmployeeUtils.class);

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
			EmpIndexedItem empIndexedItem = new EmpIndexedItem(document);

			results.add(empIndexedItem);
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
				results.add(new AddressObjectItem(address));
			}
			return results;
		} catch (SystemException e) {
			LOGGER.info(e);
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
			// if (StringUtils.trimToNull(address.getStreet3()) == null)
			if (district != null)
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
		if (empBankInfos.isEmpty()) {
			result.add(new BankInfoObject());
			return result;
		}

		for (EmpBankInfo item : empBankInfos) {
			result.add(new BankInfoObject(item));
		}
		return result;
	}

	public static List<DocumentItem> getDocumentItemsFromEmp(long empId) {
		final List<DocumentItem> result = new ArrayList<>();
		final List<vn.com.ecopharma.emp.model.Document> documents = DocumentLocalServiceUtil
				.findByClassNameAndClassPK(Emp.class.getName(), empId);
		for (vn.com.ecopharma.emp.model.Document document : documents)
			result.add(new DocumentItem(document));
		return result;
	}

	public static List<LaborContractItem> getLaborContractItemsFromEmp(
			long empId) {
		final List<LaborContractItem> result = new ArrayList<>();
		final List<EmpLaborContract> empLaborContracts = EmpLaborContractLocalServiceUtil
				.findByEmp(empId);
		for (EmpLaborContract item : empLaborContracts)
			result.add(new LaborContractItem(item));
		return result;
	}

	public static Map<EmpBankInfo, Boolean> transferBankInfoObjectListToBankInfoMap(
			List<BankInfoObject> items) {
		final Map<EmpBankInfo, Boolean> resultMap = new HashMap<>();
		for (BankInfoObject obj : items) {
			resultMap.put(obj.getObject(), obj.isUIDeleted());
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

	public static Map<EmpLaborContract, Boolean> transferEmpLaborContractInfoListToEmpLaborContractMap(
			List<LaborContractItem> items) {
		final Map<EmpLaborContract, Boolean> resultMap = new HashMap<>();
		for (LaborContractItem obj : items) {
			resultMap.put(obj.getObject(), obj.isUIDeleted());
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
		return StringUtils.trimToEmpty(user.getLastName()) + " "
				+ StringUtils.trimToEmpty(user.getMiddleName()) + " "
				+ StringUtils.trimToEmpty(user.getFirstName());
	}

	public static String getViFullnameFromUser(User user) {
		return StringUtils.trimToEmpty(user.getLastName()) + " "
				+ StringUtils.trimToEmpty(user.getMiddleName()) + " "
				+ StringUtils.trimToEmpty(user.getFirstName());
	}

	public static void deleteAllEmployeeAndEmployeeUser() {
		for (Emp employee : EmpLocalServiceUtil.findAll()) {
			try {
				UserLocalServiceUtil.deleteUser(employee.getEmpUserId());

				EmployeeLocalServiceUtil.deleteEmployee(employee.getEmpId());
			} catch (PortalException e) {
				LOGGER.info(e);
			} catch (SystemException e) {
				LOGGER.info(e);
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

	public static long getBaseModelItemPrimaryKey(AbstractBaseModelItem<?> model) {
		if (model == null)
			return 0;
		return model.getId();
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

	public static List<String> getResignationTypes() {
		final List<String> result = new ArrayList<>();
		for (ResignationType resignationType : ResignationType.values()) {
			result.add(resignationType.toString());
		}
		return result;
	}

	public static String getLocalizedResignationType(String r) {
		return StringUtils.trimToNull(r) != null ? ResignationType.valueOf(r)
				.getLocalizedString() : ResignationType.NONE
				.getLocalizedString();
	}

	public static String removeDashChar(String s) {
		final String[] dashChars = new String[] { "-", "_" };

		for (String dashChar : dashChars)
			if (s.contains(dashChar)) {
				s = s.replaceAll(dashChar, " "); // NOSONAR
			}
		return s.replaceAll("\\s+", " ").trim();
	}

	public static List<Address> findAllEmpAddress(long employeeId) {
		try {
			return AddressServiceUtil.getAddresses(Emp.class.getName(),
					employeeId);
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public static Address getPresentAddress(long companyId, long employeeId) {
		List<Address> empAddresses = EmpLocalServiceUtil.findAllEmpAddress(
				companyId, employeeId);
		if (empAddresses.isEmpty())
			return null;
		return empAddresses.get(0);
	}

	/**
	 * Provide at least 2 employee's name characters to search employee
	 * 
	 * @param query
	 * @return
	 */
	public static List<EmpIndexedItem> searchEmpByName(String query,
			Map<String, Object> additionFilterMap) {
		try {
			return getEmployeeIndexedItemsFromIndexedDocuments(EmpLocalServiceUtil
					.filterEmployeeByAutocompleteQuery(query,
							additionFilterMap, getCurrentSearchContext(),
							QueryUtil.ALL_POS, QueryUtil.ALL_POS));
		} catch (ParseException e) {
			LogFactoryUtil.getLog(EmployeeUtils.class).info(e);
		}
		return new ArrayList<>();
	}

	public static String getShortenDisplayFullName(String fullName) {
		fullName = fullName.replaceAll("\\s+", " ");
		String[] fullNameArr = fullName.split(" ");
		String namePart = fullNameArr[fullNameArr.length - 1];
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < fullNameArr.length - 1; i++) {
			String separatedChar = fullNameArr[i].substring(0, 1);
			result.append(separatedChar + ".");
		}
		result.append(namePart);
		return result.toString();
	}

	public static Emp getCurrentLoggedInEmp() {
		long userId = getServiceContext().getUserId();
		return EmpLocalServiceUtil.findByUser(userId);
	}

	public static PermissionChecker getPermissionChecker() {
		final PortletRequest request = ((PortletRequest) (FacesContext
				.getCurrentInstance().getExternalContext().getRequest()));

		final ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		return themeDisplay.getPermissionChecker();
	}

}
