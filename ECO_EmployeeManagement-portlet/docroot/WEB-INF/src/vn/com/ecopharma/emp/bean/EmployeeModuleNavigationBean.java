package vn.com.ecopharma.emp.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.bean.global.AuthorityBean;
import vn.com.ecopharma.emp.enumeration.EmployeeNavigation;
import vn.com.ecopharma.emp.util.BeanUtils;

@ManagedBean
@ViewScoped
public class EmployeeModuleNavigationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String currentNav = StringUtils.EMPTY;

	@ManagedProperty(value = "#{authorityBean}")
	private AuthorityBean authorityBean;

	@PostConstruct
	public void init() {
		if (hasViewEmpsAuthorized())
			switchViewEmps();
		else
			switchNormalUserPage();
	}

	public void switchOutCome(EmployeeNavigation navigation) {
		currentNav = navigation.getOutCome();
	}

	public void switchOutCome(String navigation) {
		EmployeeNavigation navigationEnum = EmployeeNavigation
				.valueOf(navigation);
		switchOutCome(navigationEnum);
	}

	public void switchViewEmps() {
		switchOutCome(EmployeeNavigation.VIEW);
	}

	public void switchCreateEmp() {
		switchOutCome(EmployeeNavigation.CREATE);
	}

	public void switchEditEmp() {
		switchOutCome(EmployeeNavigation.EDIT);
	}

	public void switchImportExport() {
		switchOutCome(EmployeeNavigation.IMPORT_EXPORT);
	}

	public void switchNormalUserPage() {
		switchOutCome(EmployeeNavigation.NORMAL_USER_VIEW);
	}

	public boolean hasViewEmpsAuthorized() {
		if (BeanUtils.getEmpModelPermission().isHrPermission())
			return true;

		return authorityBean.isDepartmentManager()
				|| authorityBean.isUnitManager();
	}

	public String getCurrentNav() {
		return currentNav;
	}

	public void setCurrentNav(String currentNav) {
		this.currentNav = currentNav;
	}

	public AuthorityBean getAuthorityBean() {
		return authorityBean;
	}

	public void setAuthorityBean(AuthorityBean authorityBean) {
		this.authorityBean = authorityBean;
	}

}
