package vn.com.ecopharma.hrm.rc.util;

import org.apache.commons.lang3.StringUtils;

public class CandidateUtils {

	/**
	 * @param fullname
	 * @return
	 */
	public static String getFirstNameFromFullname(String fullname) {
		return fullname.split(" ")[0];
	}

	/**
	 * @param fullname
	 * @return
	 */
	public static String getMiddleNameFromFullname(String fullname) {
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
		String[] fullnameArr = fullname.split(" ");
		return fullnameArr[fullnameArr.length - 1];
	}

}
