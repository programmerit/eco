package vn.com.ecopharma.rc.client.bean;

import java.io.Serializable;

import vn.com.ecopharma.rc.client.enumeration.navigation.GuestNavigation;

public class BaseViewBean implements Serializable {

	/*
	 * mode 1: add
	 * 
	 * mode 2: success
	 * 
	 * mode 3: fail
	 */

	private static final long serialVersionUID = 1L;

	private String navigationOutcome;

	public void switchOutcome(GuestNavigation navigation) {
		navigationOutcome = navigation.getOutCome();
	}

	public void switchOutCome(String navigation) {
		GuestNavigation navigationEnum = GuestNavigation.valueOf(navigation);
		switchOutcome(navigationEnum);
	}

	public String getNavigationOutcome() {
		return navigationOutcome;
	}

	public void setNavigationOutcome(String navigationOutcome) {
		this.navigationOutcome = navigationOutcome;
	}
}
