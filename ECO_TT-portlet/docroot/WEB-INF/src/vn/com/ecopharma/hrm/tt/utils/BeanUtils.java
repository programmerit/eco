package vn.com.ecopharma.hrm.tt.utils;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import vn.com.ecopharma.hrm.tt.bean.TimeTrackingFilterBean;

public class BeanUtils {

	private static final String TIME_TRACKING_FILTER_BEAN = "timeTrackingFilterBean";

	/**
	 * @param name
	 * @return
	 */
	public static Object getBackingBeanByName(String name) {
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		return FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(elContext, null, name);
	}

	public static TimeTrackingFilterBean getTimeTrackingFilterBean() {
		return (TimeTrackingFilterBean) getBackingBeanByName(TIME_TRACKING_FILTER_BEAN);
	}

}
