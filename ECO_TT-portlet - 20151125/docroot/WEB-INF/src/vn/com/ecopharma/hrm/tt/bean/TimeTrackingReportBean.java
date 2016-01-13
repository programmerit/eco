package vn.com.ecopharma.hrm.tt.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import vn.com.ecopharma.hrm.tt.constant.TimeTrackingField;
import vn.com.ecopharma.hrm.tt.dto.SourceTimeItem;
import vn.com.ecopharma.hrm.tt.dto.TimeTrackingIndexItem;
import vn.com.ecopharma.hrm.tt.dto.TimeTrackingReport;
import vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;

@ManagedBean
@ViewScoped
public class TimeTrackingReportBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String DATE_FORMAT = "dd/MM";

	private static final String DAY_FORMAT = "EE";

	private List<TimeTrackingReport> timeTrackingReports;

	private TimeTrackingReport selectedTimeTrackingReport;

	@PostConstruct
	public void init() {
		try {
			List<Document> documents = TimeTrackingLocalServiceUtil.search(
					TTUtils.getCurrentSearchContext(), new ArrayList<Query>(),
					TTUtils.getCompanyId(),
					new Sort(TimeTrackingField.ID, true), QueryUtil.ALL_POS,
					QueryUtil.ALL_POS);
			List<TimeTrackingIndexItem> items = TTUtils
					.getTimeTrackingIndexItems(documents);
			timeTrackingReports = new ArrayList<TimeTrackingReport>();
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			for (TimeTrackingIndexItem item : items) {
				int indexOfExistedTimeTrackingRp = getExistedTimeTrackingReport(
						timeTrackingReports, item.getFullName());
				if (indexOfExistedTimeTrackingRp != -1) {
					timeTrackingReports
							.get(indexOfExistedTimeTrackingRp)
							.getSourceTimeMap()
							.put(sdf.format(item.getDate()),
									new SourceTimeItem(item.getDate(), item
											.getIn1(), item.getOut1(), item
											.getIn2(), item.getOut2(), item
											.getIn3(), item.getOut3(), 0, 0, 0,
											0, "", ""));
				} else {
					SourceTimeItem sourceTimeItem = new SourceTimeItem(
							item.getDate(), item.getIn1(), item.getOut1(),
							item.getIn2(), item.getOut2(), item.getIn3(),
							item.getOut3(), 0, 0, 0, 0, "", "");
					Map<String, SourceTimeItem> map = new LinkedHashMap<String, SourceTimeItem>();
					map.put(sdf.format(item.getDate()), sourceTimeItem);
					TimeTrackingReport timeTrackingReport = new TimeTrackingReport(
							item.getEmpId(), item.getFullName(),
							item.getEmpCode(), map);
					timeTrackingReports.add(timeTrackingReport);
				}
			}

			System.out.println(timeTrackingReports.size());

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SearchException e) {
			e.printStackTrace();
		}

		for (Date date : getDatesOfMonth(10)) {
			System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(date));
		}
	}

	// private boolean isExistTimeTrackingReport(
	// List<TimeTrackingReport> timeTrackingReports, String fullName) {
	// for (TimeTrackingReport timeTrackingReport : timeTrackingReports) {
	// if (timeTrackingReport.getFullName().equalsIgnoreCase(fullName)) {
	// return true;
	// }
	// }
	// return false;
	// }

	private int getExistedTimeTrackingReport(
			List<TimeTrackingReport> timeTrackingReports, String fullName) {
		for (TimeTrackingReport timeTrackingReport : timeTrackingReports) {
			if (timeTrackingReport.getFullName().equalsIgnoreCase(fullName)) {
				return timeTrackingReports.indexOf(timeTrackingReport);
			}
		}
		return -1;
	}

	public String getTest() {
		return "testString";
	}

	public List<Date> getDatesOfMonth(int month) {
		final List<Date> result = new ArrayList<Date>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month);
		int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i = 1; i <= maxDay; i++) {
			calendar.set(Calendar.DAY_OF_MONTH, i);
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			result.add(calendar.getTime());
		}
		return result;
	}

	public List<String> getDatesOfMonthString(int month) {
		final List<String> result = new ArrayList<String>();
		final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

		for (Date date : getDatesOfMonth(month)) {
			result.add(sdf.format(date));
		}
		return result;
	}

	public List<String> getDaysOfMonthString(int month) {
		final List<String> result = new ArrayList<String>();
		final SimpleDateFormat sdf = new SimpleDateFormat(DAY_FORMAT);

		for (Date date : getDatesOfMonth(month)) {
			result.add(sdf.format(date));
		}
		return result;
	}

	public int getDatesSize(int month) {
		return getDatesOfMonthString(month).size();
	}

	public List<TimeTrackingReport> getTimeTrackingReports() {
		return timeTrackingReports;
	}

	public void setTimeTrackingReports(
			List<TimeTrackingReport> timeTrackingReports) {
		this.timeTrackingReports = timeTrackingReports;
	}

	public TimeTrackingReport getSelectedTimeTrackingReport() {
		return selectedTimeTrackingReport;
	}

	public void setSelectedTimeTrackingReport(
			TimeTrackingReport selectedTimeTrackingReport) {
		this.selectedTimeTrackingReport = selectedTimeTrackingReport;
	}

}
