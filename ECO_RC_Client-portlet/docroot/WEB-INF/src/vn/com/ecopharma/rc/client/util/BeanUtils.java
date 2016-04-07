package vn.com.ecopharma.rc.client.util;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import vn.com.ecopharma.rc.client.bean.VacancyBean;
import vn.com.ecopharma.rc.client.bean.filter.VacancyFilterBean;

public class BeanUtils {

	private static final String VACANCY_BEAN = "vacancyBean";
	private static final String VACANCY_FILTER_BEAN = "vacancyFilterBean";

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

}
