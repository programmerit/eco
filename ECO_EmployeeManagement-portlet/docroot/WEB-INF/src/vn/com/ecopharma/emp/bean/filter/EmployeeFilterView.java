package vn.com.ecopharma.emp.bean.filter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.component.link.Link;
import org.primefaces.context.RequestContext;

import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.enumeration.EmployeeStatus;

@ManagedBean(name = "empFilterBean")
@ViewScoped
public class EmployeeFilterView extends OrganizationFilterBean {

	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";

	private String globalString = StringUtils.EMPTY;
	private String employeeCode = StringUtils.EMPTY;
	private String fullName = StringUtils.EMPTY;
	private String status = EmployeeStatus.ALL.toString();
	private Date joinedDateFrom;
	private Date joinedDateTo;

	private List<String> selectedGenders;

	public void onGlobalFiltering() {
		// only execute search for more than 2 words
		if (this.globalString.length() >= 2) {
			RequestContext.getCurrentInstance().execute(
					"filterEmployees(); refreshFooter();");
		}
	}

	@Override
	public void onDeleteFilterBadges(int index) {
		super.onDeleteFilterBadges(index);
		String removeValue = getFilterBadges().get(index);
		if (globalString.equalsIgnoreCase(removeValue)) {
			globalString = StringUtils.EMPTY;
		} else if (fullName.equalsIgnoreCase(removeValue)) {
			fullName = StringUtils.EMPTY;
		} else if (employeeCode.equalsIgnoreCase(removeValue)) {
			employeeCode = StringUtils.EMPTY;
		} else if (selectedGenders.contains(removeValue)) {
			selectedGenders.remove(removeValue);
		} else if (status.equals(removeValue)) {
			status = EmployeeStatus.ALL.toString();
		}

		// for date
		if (removeValue.contains("-")) {
			joinedDateFrom = null;
			joinedDateTo = null;
		}
		getFilterBadges().remove(index);
	}

	public void resetJoinedDateFrom() {
		joinedDateFrom = null;
	}

	public void resetJoinedDateTo() {
		joinedDateTo = null;
	}

	public List<String> getFilterBadges() {
		final Set<String> badges = new HashSet<String>(super.getFilterBadges());
		checkAndAddFilterBadge(globalString, badges);
		checkAndAddFilterBadge(employeeCode, badges);
		checkAndAddFilterBadge(fullName, badges);
		checkAndAddFilterBadge(joinedDateFrom, badges);
		checkAndAddFilterBadge(joinedDateTo, badges);
		checkAndAddJoinedDateFilterBadge(badges);
		if (!status.equalsIgnoreCase(EmployeeStatus.ALL.toString()))
			checkAndAddFilterBadge(status, badges);

		if (selectedGenders != null && !selectedGenders.isEmpty()) {
			badges.addAll(selectedGenders);
		}

		return new ArrayList<>(badges);
	}

	private void checkAndAddFilterBadge(Object filterValue,
			Collection<String> badges) {
		if (filterValue instanceof String) {
			checkAndAddStringFilterBadge((String) filterValue, badges);
		}
	}

	private void checkAndAddStringFilterBadge(String filterValue,
			Collection<String> badges) {
		if (StringUtils.trimToNull(filterValue) != null)
			badges.add(filterValue);
	}

	private void checkAndAddJoinedDateFilterBadge(Collection<String> badges) {
		if (joinedDateFrom == null && joinedDateTo == null)
			return;

		final SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		StringBuilder resultBuilder = new StringBuilder();
		if (joinedDateFrom == null) {
			resultBuilder.append("Past-");
			resultBuilder.append(sdf.format(joinedDateTo));
			badges.add(resultBuilder.toString());
			return;
		}

		if (joinedDateTo == null) {
			resultBuilder.append(sdf.format(joinedDateFrom));
			resultBuilder.append("-Now");
			badges.add(resultBuilder.toString());
			return;
		}

		resultBuilder.append(sdf.format(joinedDateFrom));
		resultBuilder.append("-");
		resultBuilder.append(sdf.format(joinedDateTo));
		badges.add(resultBuilder.toString());
	}

	public String getGlobalString() {
		return globalString;
	}

	public void setGlobalString(String globalString) {
		this.globalString = globalString;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Date getJoinedDateFrom() {
		return joinedDateFrom;
	}

	public void setJoinedDateFrom(Date joinedDateFrom) {
		this.joinedDateFrom = joinedDateFrom;
	}

	public Date getJoinedDateTo() {
		return joinedDateTo;
	}

	public void setJoinedDateTo(Date joinedDateTo) {
		this.joinedDateTo = joinedDateTo;
	}

	public List<String> getSelectedGenders() {
		return selectedGenders;
	}

	public void setSelectedGenders(List<String> selectedGenders) {
		this.selectedGenders = selectedGenders;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getStatuses() {
		return EmployeeStatus.getAll();
	}

	public String getStatusLocaleKey(String value) {
		if (value == null || StringUtils.EMPTY.equals(value))
			return StringUtils.EMPTY;
		EmployeeStatus s = EmployeeStatus.valueOf(value);
		return s.getLocalizedString();
	}

	/* For Order */
	public String getJoinedDate() {
		return EmpField.JOINED_DATE;
	}

	public String getBirthDay() {
		return EmpField.BIRTHDAY;
	}
}
