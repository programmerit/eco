package vn.com.ecopharma.rc.client.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import vn.com.ecopharma.rc.client.enumeration.navigation.GuestNavigation;

@ManagedBean
@ViewScoped
public class GuestViewBean implements Serializable {

	/*
	 * mode 1: add
	 * 
	 * mode 2: success
	 * 
	 * mode 3: fail
	 */

	private static final long serialVersionUID = 1L;

	private String navigationOutcome;

	@PostConstruct
	public void init() {
		navigationOutcome = GuestNavigation.GUEST_ADD.getOutCome();
	}

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
