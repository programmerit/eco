package vn.com.ecopharma.hrm.tt.utils;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import vn.com.ecopharma.hrm.tt.bean.LeaveRequestBean;
import vn.com.ecopharma.hrm.tt.bean.OrganizationFilterBean;
import vn.com.ecopharma.hrm.tt.bean.TimeTrackingFilterBean;
import vn.com.ecopharma.hrm.tt.bean.filter.VacationLeaveFilterBean;

public class BeanUtils {

	private static final String TIME_TRACKING_FILTER_BEAN = "timeTrackingFilterBean";

	private static final String ORGANIZATION_FILTER_BEAN = "organizationFilterBean";

	private static final String LEAVE_REQUEST_BEAN = "leaveRequestBean";

	private static final String VACATION_LEAVE_FILTER_BEAN = "leaveFilterBean";

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

	public static OrganizationFilterBean getOrganizationFilterBean() {
		return (OrganizationFilterBean) getBackingBeanByName(ORGANIZATION_FILTER_BEAN);
	}

	public static LeaveRequestBean getLeaveRequestBean() {
		return (LeaveRequestBean) getBackingBeanByName(LEAVE_REQUEST_BEAN);
	}

	public static VacationLeaveFilterBean getLeaveFilterBean() {
		return (VacationLeaveFilterBean) getBackingBeanByName(VACATION_LEAVE_FILTER_BEAN);
	}

}
