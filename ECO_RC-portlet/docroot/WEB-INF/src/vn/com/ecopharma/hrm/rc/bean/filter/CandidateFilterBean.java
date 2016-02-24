package vn.com.ecopharma.hrm.rc.bean.filter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.hrm.rc.constant.VacancyField;
import vn.com.ecopharma.hrm.rc.dto.VacancyIndexItem;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateStatus;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;

@ManagedBean
@ViewScoped
public class CandidateFilterBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(CandidateFilterBean.class);

	private String global = StringUtils.EMPTY;
	private String fullName = StringUtils.EMPTY;
	private String emailAddress = StringUtils.EMPTY;
	private String contactNumber = StringUtils.EMPTY;
	private String vacancy = StringUtils.EMPTY;
	private String status = StringUtils.EMPTY;

	private Date applyDateFrom;
	private Date applyDateTo;
	private List<VacancyIndexItem> vacancyItems;

	private String applyDate;

	public List<VacancyIndexItem> onCompleteVacancies(String query) {
		final List<VacancyIndexItem> filteredItems = new ArrayList<>();
		final SearchContext searchContext = RCUtils.getCurrentSearchContext();
		try {
			final BooleanQuery nameFilterBooleanQuery = BooleanQueryFactoryUtil
					.create(searchContext);
			nameFilterBooleanQuery.addTerm(VacancyField.NAME, query, true,
					BooleanClauseOccur.MUST);
			final List<Query> queries = new ArrayList<Query>();

			queries.add(nameFilterBooleanQuery);
			Sort sort = new Sort();
			sort.setFieldName(VacancyField.VACANCY_ID);
			final List<Document> docs = VacancyLocalServiceUtil
					.searchAllUnDeletedAndPublishedVacanciesIndexedDocument(
							searchContext, queries,
							searchContext.getCompanyId(), sort, 0, 10);
			for (Document doc : docs) {
				filteredItems.add(new VacancyIndexItem(doc));
			}
			return filteredItems;
		} catch (ParseException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public void resetApplyDateFrom() {
		applyDateFrom = null;
	}

	public void resetApplyDateTo() {
		applyDateTo = null;
	}

	public String getGlobal() {
		return global;
	}

	public void setGlobal(String global) {
		this.global = global;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String name) {
		this.fullName = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String email) {
		this.emailAddress = email;
	}

	public String getVacancy() {
		return vacancy;
	}

	public void setVacancy(String vacancy) {
		this.vacancy = vacancy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contact) {
		this.contactNumber = contact;
	}

	public Date getApplyDateFrom() {
		return applyDateFrom;
	}

	public void setApplyDateFrom(Date applyDateFrom) {
		this.applyDateFrom = applyDateFrom;
	}

	public Date getApplyDateTo() {
		return applyDateTo;
	}

	public void setApplyDateTo(Date applyDateTo) {
		this.applyDateTo = applyDateTo;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public List<String> getAllStatus() {
		final List<String> statuses = new ArrayList<String>();
		for (CandidateStatus s : CandidateStatus.values()) {
			statuses.add(s.toString());
		}
		return statuses;
	}

	public List<VacancyIndexItem> getVacancyItems() {
		return vacancyItems;
	}

	public void setVacancyItems(List<VacancyIndexItem> vacancyItems) {
		this.vacancyItems = vacancyItems;
	}
}
