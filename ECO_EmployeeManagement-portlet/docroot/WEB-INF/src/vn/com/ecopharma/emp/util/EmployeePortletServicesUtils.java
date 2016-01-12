package vn.com.ecopharma.emp.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

public class EmployeePortletServicesUtils {

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmployeePortletServicesUtils.class);

	private EmployeePortletServicesUtils() {
	}

	/* ======================= USER PART ======================= */
	public static User createUser(String username, String firstName,
			String middleName, String lastName, String emailAddress,
			String jobTitle, String password, String comments) {
		long userId;
		try {
			userId = CounterLocalServiceUtil.increment();
			final User user = UserLocalServiceUtil.createUser(userId);
			user.setCreateDate(new Date(System.currentTimeMillis()));
			user.setModifiedDate(new Date(System.currentTimeMillis()));
			user.setScreenName(username);
			user.setFirstName(firstName);
			user.setMiddleName(middleName);
			user.setLastName(lastName);
			user.setEmailAddress(emailAddress);
			user.setJobTitle(jobTitle);
			user.setPassword(password);
			user.setComments(comments);
			return user;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public static boolean isUserExisted(long companyId, String emailAddress,
			String screenName) {
		try {
			return UserLocalServiceUtil.fetchUserByEmailAddress(companyId,
					emailAddress) != null
					|| UserLocalServiceUtil.fetchUserByScreenName(companyId,
							screenName) != null;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return false;
	}

	/* ======================= REGION PART ======================= */

	public static Region getRegion(long regionId) {
		try {
			return RegionServiceUtil.getRegion(regionId);
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public static List<Region> getRegionByCountry(long countryId) {
		try {
			return RegionServiceUtil.getRegions(countryId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

}
