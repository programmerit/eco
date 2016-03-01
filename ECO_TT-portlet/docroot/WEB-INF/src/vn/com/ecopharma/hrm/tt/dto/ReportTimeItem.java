package vn.com.ecopharma.hrm.tt.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportTimeItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String FORMATTED_HOUR = "HH:mm";

	private static final String EMPTY_TIME = "--:--";

	private Date minIn;

	private Date maxOut;

	private boolean isLeaveApplied;

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
		if (isLeaveApplied && minIn == null)
			return "LEAVE";

		return minIn != null ? sdf.format(minIn) : EMPTY_TIME;
	}

	public String getFormattedMaxOut() {
		final SimpleDateFormat sdf = new SimpleDateFormat(FORMATTED_HOUR);
		return maxOut != null ? sdf.format(maxOut) : EMPTY_TIME;
	}

	public boolean isLeaveApplied() {
		return isLeaveApplied;
	}

	public void setLeaveApplied(boolean isLeaveApplied) {
		this.isLeaveApplied = isLeaveApplied;
	}

}
