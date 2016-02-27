package vn.com.ecopharma.hrm.rc.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import vn.com.ecopharma.hrm.rc.constant.VacancyNavigation;
import vn.com.ecopharma.hrm.rc.dto.VacancyIndexItem;
import vn.com.ecopharma.hrm.rc.enumeration.VacancyStatus;
import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean(name = "vacancyViewBean")
@ViewScoped
public class VacancyViewBean extends EntityViewBean {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/views/pages/vacancyView.xhtml";

	private String currentNav = StringUtils.EMPTY;

	private String selectedStatus = StringUtils.EMPTY;

	@PostConstruct
	public void init() {
		currentNav = VIEW;
	}

	@Override
	public void switchMode(int mode) {
		switch (mode) {
		case VacancyNavigation.VIEW:
			currentNav = VIEW;
			break;
		case VacancyNavigation.CREATE:
		case VacancyNavigation.EDIT:
			currentNav = "/views/pages/modifyVacancy.xhtml";
			break;
		default:
			break;
		}
		super.switchMode(mode);
	}

	public String currentStatusCSS(String status) {
		return VacancyStatus.getCssClass(VacancyStatus.valueOf(status));
	}

	public List<String> getAvailableStatuses(String status) {
		return VacancyStatus.getAvailableStatus(status);
	}

	public void onStatusChange(VacancyIndexItem vacancyIndexItem) {
		try {

			final Vacancy vacancy = VacancyLocalServiceUtil
					.fetchVacancy(vacancyIndexItem.getId());
			vacancy.setStatus(selectedStatus);
			VacancyLocalServiceUtil.updateVacancy(vacancy);

			RequestContext.getCurrentInstance().update(
					"vacancyMainForm:vacancies");
			selectedStatus = StringUtils.EMPTY;
		} catch (SystemException e) {
			e.printStackTrace();
		}

	}

	public String getSelectedStatus() {
		return selectedStatus;
	}

	public void setSelectedStatus(String selectedStatus) {
		this.selectedStatus = selectedStatus;
	}

	public String getCurrentNav() {
		return currentNav;
	}

	public void setCurrentNav(String currentNav) {
		this.currentNav = currentNav;
	}
}
