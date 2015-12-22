package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.hrm.rc.constant.InterviewScheduleField;
import vn.com.ecopharma.hrm.rc.dm.InterviewScheduleLazyDM;
import vn.com.ecopharma.hrm.rc.dto.InterviewScheduleIndexedItem;
import vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.BeanUtils;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

import com.liferay.portal.kernel.search.SearchContext;

/**
 * @author TaoTran
 *
 */
@ManagedBean
@ViewScoped
public class InterviewManagementBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private LazyDataModel<InterviewScheduleIndexedItem> lazyDataModel;

	private List<InterviewScheduleIndexedItem> selectedItems;

	@PostConstruct
	public void init() {
		lazyDataModel = new InterviewScheduleLazyDM() {

			private static final long serialVersionUID = 1L;

			@Override
			public List<InterviewScheduleIndexedItem> load(int first,
					int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				final InterviewManagementFilterBean filterBean = BeanUtils
						.getInterviewManagementFilterBean();
				if (!filterBean.getGlobal().equals(StringUtils.EMPTY)) {
					filters.put(InterviewScheduleField.GLOBAL,
							filterBean.getGlobal());
				}

				if (!filterBean.getStatus().equals(StringUtils.EMPTY)
						&& !filterBean.getStatus().equals("ALL_STATUS")) {
					filters.put(InterviewScheduleField.STATUS,
							filterBean.getStatus());
				}

				if (!filterBean.getCandidate().equals(StringUtils.EMPTY)) {
					filters.put(InterviewScheduleField.CANDIDATE,
							filterBean.getCandidate());
				}

				if (!filterBean.getVacancy().equals(StringUtils.EMPTY)) {
					filters.put(InterviewScheduleField.VACANCY,
							filterBean.getVacancy());
				}

				if (filterBean.getInterviewDateFrom() != null) {
					filters.put(InterviewScheduleField.INTERVIEW_DATE_FROM,
							filterBean.getInterviewDateFrom());
				}

				if (filterBean.getInterviewDateTo() != null) {
					filters.put(InterviewScheduleField.INTERVIEW_DATE_TO,
							filterBean.getInterviewDateTo());
				}

				if (filterBean.getInterviewers() != null
						&& !filterBean.getInterviewers().isEmpty()) {
					filters.put(InterviewScheduleField.INTERVIEWERS,
							filterBean.getInterviewers());
				}

				return super.load(first, pageSize, sortField, sortOrder,
						filters);
			}
		};
	}

	public LazyDataModel<InterviewScheduleIndexedItem> getLazyDataModel() {
		return lazyDataModel;
	}

	public void setLazyDataModel(
			LazyDataModel<InterviewScheduleIndexedItem> lazyDataModel) {
		this.lazyDataModel = lazyDataModel;
	}

	public void indexAll() {
		InterviewScheduleLocalServiceUtil.indexAll();
	}

	public void removeIndexes() {
		final SearchContext searchContext = RCUtils.getCurrentSearchContext();
		InterviewScheduleLocalServiceUtil.removeAllIndexes(searchContext,
				searchContext.getCompanyId());

	}

	public List<InterviewScheduleIndexedItem> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(
			List<InterviewScheduleIndexedItem> selectedItems) {
		this.selectedItems = selectedItems;
	}
}
