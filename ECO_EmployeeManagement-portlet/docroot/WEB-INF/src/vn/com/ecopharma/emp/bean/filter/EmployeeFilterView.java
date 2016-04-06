package vn.com.ecopharma.emp.bean.filter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.enumeration.EmployeeStatus;

@ManagedBean(name = "empFilterBean")
@ViewScoped
public class EmployeeFilterView extends BaseEmpFilterBean {

	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";

	private String globalString = StringUtils.EMPTY;
	private Date joinedDateFrom;
	private Date joinedDateTo;

	private List<String> selectedGenders;
	private List<String> selectedStatuses;

	@PostConstruct
	public void init() {
		super.init();
	}

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
		} else if (getFullName().equalsIgnoreCase(removeValue)) {
			setFullName(StringUtils.EMPTY);
		} else if (getEmpCode().equalsIgnoreCase(removeValue)) {
			setEmpCode(StringUtils.EMPTY);
		} else if (selectedGenders.contains(removeValue)) {
			selectedGenders.remove(removeValue);
		} else if (selectedStatuses.contains(removeValue)) {
			selectedStatuses.remove(removeValue);
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

	@Override
	public List<String> getFilterBadges() {
		final Set<String> badges = new HashSet<String>(super.getFilterBadges());
		checkAndAddFilterBadge(globalString, badges);
		checkAndAddFilterBadge(getEmpCode(), badges);
		checkAndAddFilterBadge(getFullName(), badges);
		checkAndAddFilterBadge(joinedDateFrom, badges);
		checkAndAddFilterBadge(joinedDateTo, badges);
		checkAndAddJoinedDateFilterBadge(badges);
		if (selectedStatuses != null && !selectedStatuses.isEmpty()) {
			badges.addAll(selectedStatuses);
		}

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

	@Override
	public void onDevisionChanged() {
		super.onDevisionChanged();
	}

	@Override
	public void onDepartmentChanged() {
		super.onDepartmentChanged();
	}

	@Override
	public void onUnitChanged() {
		super.onUnitChanged();
		// bindFieldsByAuthorities();
	}

	@Override
	public void onUnitGroupChanged() {
		super.onUnitGroupChanged();
	}

	public String getGlobalString() {
		return globalString;
	}

	public void setGlobalString(String globalString) {
		this.globalString = globalString;
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

	public List<String> getSelectedStatuses() {
		return selectedStatuses;
	}

	public void setSelectedStatuses(List<String> selectedStatuses) {
		this.selectedStatuses = selectedStatuses;
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
