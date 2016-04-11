package vn.com.ecopharma.rc.client.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import vn.com.ecopharma.rc.client.enumeration.navigation.GuestNavigation;

@ManagedBean
@ViewScoped
public class VacancyGuestBean extends BaseViewBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		setNavigationOutcome(GuestNavigation.VACANCY_VIEW.getOutCome());
	}

}
