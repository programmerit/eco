package vn.com.ecopharma.hrm.tt.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import vn.com.ecopharma.hrm.tt.enumeration.VacationLeaveStatus;

public class ReportTimeItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String FORMATTED_HOUR = "HH:mm";

	private static final String EMPTY_TIME = "--:--";

	private Date minIn;

	private Date maxOut;

	private VacationLeaveIndexedItem leaveIndexedItem;

	public ReportTimeItem(Date minIn, Date maxOut) {
		super();
		this.minIn = minIn;
		this.maxOut = maxOut;
	}

	public Date getMinIn() {
		return minIn;
	}

	public void setMinIn(Date minIn) {
		this.minIn = minIn;
	}

	public Date getMaxOut() {
		return maxOut;
	}

	public void setMaxOut(Date maxOut) {
		this.maxOut = maxOut;
	}

	public String getFormattedMinIn() {
		final SimpleDateFormat sdf = new SimpleDateFormat(FORMATTED_HOUR);
		return minIn != null ? sdf.format(minIn) : EMPTY_TIME;
	}

	public String getFormattedMaxOut() {
		final SimpleDateFormat sdf = new SimpleDateFormat(FORMATTED_HOUR);
		return maxOut != null ? sdf.format(maxOut) : EMPTY_TIME;
	}

	public VacationLeaveIndexedItem getLeaveIndexedItem() {
		return leaveIndexedItem;
	}

	public void setLeaveIndexedItem(VacationLeaveIndexedItem leaveIndexedItem) {
		this.leaveIndexedItem = leaveIndexedItem;
	}

	public boolean isHalfDayLeave() {
		return leaveIndexedItem != null
				&& leaveIndexedItem.getSign().contains("1/2");
	}

	public boolean isWholeDayLeave() {
		return leaveIndexedItem != null
				&& !leaveIndexedItem.getSign().contains("1/2");
	}

	public boolean isNotLeave() {
		return leaveIndexedItem == null;
	}

	public String getLeaveStatusCss() {
		VacationLeaveStatus status = VacationLeaveStatus
				.valueOf(this.leaveIndexedItem.getStatus());
		return status.getCSS();
	}

}
