package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import vn.com.ecopharma.emp.service.EmployeeLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.constant.EmployeeField;
import vn.com.ecopharma.hrm.rc.dto.CandidateIndexItem;
import vn.com.ecopharma.hrm.rc.dto.EmpIndexedItem;
import vn.com.ecopharma.hrm.rc.dto.InterviewScheduleItem;
import vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.service.ServiceContext;

@ManagedBean(name = "interviewScheduleBean")
@ViewScoped
public class InterviewScheduleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private InterviewScheduleItem interviewScheduleItem;

	private CandidateIndexItem selectedCandidate;

	@PostConstruct
	public void init() {
	}

	public void saveInterviewSchedule(ActionEvent actionEvent) {
		if (interviewScheduleItem.getSelectedInterview() != null
				&& interviewScheduleItem.getCandidateIndexItem() != null
				&& interviewScheduleItem.getInterviewSchedule()
						.getInterviewDate() != null) {
			final ServiceContext serviceContext = LiferayFacesContext
					.getInstance().getServiceContext();
			interviewScheduleItem.getInterviewScheduleAfterSettingFields();

			InterviewScheduleLocalServiceUtil.addInterviewSchedule(
					interviewScheduleItem.getInterviewSchedule(),
					interviewScheduleItem.getCandidateIndexItem()
							.getVacancyCandidateId(),
					getEmpIds(interviewScheduleItem.getInterviewers()),
					interviewScheduleItem.getCandidateIndexItem()
							.getCandidateId(), serviceContext);

			RequestContext.getCurrentInstance().execute(
					"PF('wInterviewScheduleDialog').hide()");
			RequestContext.getCurrentInstance().update(
					":candidateMainForm:candidates");
		}
	}

	public List<EmpIndexedItem> completeInterviewers(String query) {
		final List<EmpIndexedItem> filteredItems = new ArrayList<EmpIndexedItem>();
		final SearchContext searchContext = RCUtils.getCurrentSearchContext();
		try {
			final BooleanQuery fullNameFilterBooleanQuery = BooleanQueryFactoryUtil
					.create(searchContext);
			fullNameFilterBooleanQuery.addTerm(EmployeeField.FULL_NAME, query,
					true, BooleanClauseOccur.MUST);
			final List<Query> queries = new ArrayList<Query>();

			queries.add(fullNameFilterBooleanQuery);
			Sort sort = new Sort();
			sort.setFieldName(EmployeeField.EMPLOYEE_ID);
			final List<Document> docs = EmployeeLocalServiceUtil
					.searchAllUnDeletedEmployeeIndexedDocument(searchContext,
							queries, searchContext.getCompanyId(), sort, 0, 10);
			for (Document doc : docs) {
				filteredItems.add(new EmpIndexedItem(doc));
			}
			return filteredItems;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<Long> getEmpIds(List<EmpIndexedItem> employeeIndexedItems) {
		final List<Long> ids = new ArrayList<Long>(employeeIndexedItems.size());
		for (EmpIndexedItem employeeIndexedItem : employeeIndexedItems) {
			ids.add(employeeIndexedItem.getEmployeeId());
		}
		return ids;
	}

	public InterviewScheduleItem getInterviewScheduleItem() {
		return interviewScheduleItem;
	}

	public void interviewChange() {
	}

	public void setInterviewScheduleItem(
			InterviewScheduleItem interviewScheduleItem) {
		this.interviewScheduleItem = interviewScheduleItem;
	}

	public CandidateIndexItem getSelectedCandidate() {
		return selectedCandidate;
	}

	public void setSelectedCandidate(CandidateIndexItem selectedCandidate) {
		this.selectedCandidate = selectedCandidate;
	}

	public Date getMinDate() {
		return new Date(System.currentTimeMillis());
	}
}
