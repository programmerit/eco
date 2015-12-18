package vn.com.ecopharma.emp.util;

import java.util.Date;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class EmployeePortletServicesUtils {

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
			e.printStackTrace();
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
			e.printStackTrace();
		}
		return false;
	}

}
