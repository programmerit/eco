package vn.com.ecopharma.hrm.rc.util;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import vn.com.ecopharma.hrm.rc.bean.CandidateBean;
import vn.com.ecopharma.hrm.rc.bean.CandidateViewBean;
import vn.com.ecopharma.hrm.rc.bean.InterviewManagementFilterBean;
import vn.com.ecopharma.hrm.rc.bean.RCViewBean;
import vn.com.ecopharma.hrm.rc.bean.TitlesActionBean;
import vn.com.ecopharma.hrm.rc.bean.VacancyBean;
import vn.com.ecopharma.hrm.rc.bean.VacancyViewBean;
import vn.com.ecopharma.hrm.rc.bean.filter.CandidateFilterBean;
import vn.com.ecopharma.hrm.rc.bean.filter.VacancyFilterBean;

public class BeanUtils {

	private static final String CANDIDATE_BEAN = "candidateBean";

	private static final String VACANCY_BEAN = "vacancyBean";

	private static final String CANDIDATE_VIEW_BEAN = "candidateViewBean";
	private static final String CANDIDATE_FILTER_BEAN = "candidateFilterBean";

	private static final String VACANCY_VIEW_BEAN = "vacancyViewBean";
	private static final String VACANCY_FILTER_BEAN = "vacancyFilterBean";

	private static final String RCVIEW_BEAN = "RCViewBean";

	private static final String INTERVIEWS_MANAGEMENT_BEAN = "interviewManagementFilterBean";

	private static final String TITLES_ACTION_BEAN = "titlesActionBean";

	/**
	 * @param name
	 * @return
	 */
	public static Object getBackingBeanByName(String name) {
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		return FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(elContext, null, name);
	}

	public static CandidateBean getCandidateBean() {
		return (CandidateBean) getBackingBeanByName(CANDIDATE_BEAN);
	}

	public static VacancyBean getVacancyBean() {
		return (VacancyBean) getBackingBeanByName(VACANCY_BEAN);
	}

	public static CandidateViewBean getCandidateViewBean() {
		return (CandidateViewBean) getBackingBeanByName(CANDIDATE_VIEW_BEAN);
	}

	public static VacancyViewBean getVacancyViewBean() {
		return (VacancyViewBean) getBackingBeanByName(VACANCY_VIEW_BEAN);
	}

	public static CandidateFilterBean getCandidateFilterBean() {
		return (CandidateFilterBean) getBackingBeanByName(CANDIDATE_FILTER_BEAN);
	}

	public static VacancyFilterBean getVacancyFilterBean() {
		return (VacancyFilterBean) getBackingBeanByName(VACANCY_FILTER_BEAN);
	}

	public static RCViewBean getRCViewBean() {
		return (RCViewBean) getBackingBeanByName(RCVIEW_BEAN);
	}

	public static InterviewManagementFilterBean getInterviewManagementFilterBean() {
		return (InterviewManagementFilterBean) getBackingBeanByName(INTERVIEWS_MANAGEMENT_BEAN);
	}

	public static TitlesActionBean getTitlesActionBean() {
		return (TitlesActionBean) getBackingBeanByName(TITLES_ACTION_BEAN);
	}

}
