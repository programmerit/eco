package vn.com.ecopharma.rc.client.util;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import vn.com.ecopharma.rc.client.bean.GuestViewBean;
import vn.com.ecopharma.rc.client.bean.VacancyBean;
import vn.com.ecopharma.rc.client.bean.VacancyDetailBean;
import vn.com.ecopharma.rc.client.bean.VacancyGuestBean;
import vn.com.ecopharma.rc.client.bean.filter.VacancyFilterBean;

public class BeanUtils {

	private static final String VACANCY_BEAN = "vacancyBean";
	private static final String VACANCY_FILTER_BEAN = "vacancyFilterBean";

	private static final String GUEST_VIEW_BEAN = "guestViewBean";

	private static final String VACANCY_GUEST_BEAN = "vacancyGuestBean";

	private static final String VACANCY_DETAIL_BEAN = "vacancyDetailBean";

	/**
	 * @param name
	 * @return
	 */
	public static Object getBackingBeanByName(String name) {
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		return FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(elContext, null, name);
	}

	public static VacancyBean getVacancyBean() {
		return (VacancyBean) getBackingBeanByName(VACANCY_BEAN);
	}

	public static VacancyFilterBean getVacancyFilterBean() {
		return (VacancyFilterBean) getBackingBeanByName(VACANCY_FILTER_BEAN);
	}

	public static GuestViewBean getGuestViewBean() {
		return (GuestViewBean) getBackingBeanByName(GUEST_VIEW_BEAN);
	}

	public static VacancyGuestBean getVacancyGuestBean() {
		return (VacancyGuestBean) getBackingBeanByName(VACANCY_GUEST_BEAN);
	}

	public static VacancyDetailBean getVacancyDetailBean() {
		return (VacancyDetailBean) getBackingBeanByName(VACANCY_DETAIL_BEAN);
	}

}
