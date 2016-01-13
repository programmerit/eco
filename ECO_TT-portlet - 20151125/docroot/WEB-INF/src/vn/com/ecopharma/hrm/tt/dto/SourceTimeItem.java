package vn.com.ecopharma.hrm.tt.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Row;

/**
 * Created by TaoTran on 11/19/2015.
 */

public final class SourceTimeItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private static final String SOURCE_FORMAT = "mm/dd/yyyy";

	private Date date;
	private String day;

	private Date in1;
	private Date out1;

	private Date in2;
	private Date out2;

	private Date in3;
	private Date out3;

	private int workingTimeHours;
	private int OT_TimeHours;
	private int soonLateMins;

	private double total;
	private String shift;
	private String signal;

	public SourceTimeItem(Date date, Date in1, Date out1, Date in2, Date out2,
			Date in3, Date out3, int workingTimeHours, int OT_TimeHours,
			int soonLateMins, double total, String shift, String signal) {
		this.date = date;
		this.in1 = in1;
		this.out1 = out1;
		this.in2 = in2;
		this.out2 = out2;
		this.in3 = in3;
		this.out3 = out3;
		this.workingTimeHours = workingTimeHours;
		this.OT_TimeHours = OT_TimeHours;
		this.soonLateMins = soonLateMins;
		this.total = total;
		this.shift = shift;
		this.signal = signal;
	}

	public SourceTimeItem(Row row) {
		this.bindRowToObjectFields(row);

	}

	private void bindRowToObjectFields(Row row) {
		this.date = row.getCell(5).getDateCellValue();
		this.day = row.getCell(6).toString();
		// this.in1 = getDetailDateTime(date, row.getCell(7) != null ?
		// row.getCell(7).toString() : StringUtils.EMPTY);
		// this.out1 = getDetailDateTime(date, row.getCell(8) != null ?
		// row.getCell(8).toString() : StringUtils.EMPTY);
		// this.in2 = getDetailDateTime(date, row.getCell(9) != null ?
		// row.getCell(9).toString() : StringUtils.EMPTY);
		// this.out2 = getDetailDateTime(date, row.getCell(10) != null ?
		// row.getCell(10).toString() : StringUtils.EMPTY);
		// this.in3 = getDetailDateTime(date, row.getCell(11) != null ?
		// row.getCell(11).toString() : StringUtils.EMPTY);
		// this.out3 = getDetailDateTime(date, row.getCell(12) != null ?
		// row.getCell(12).toString() : StringUtils.EMPTY);
		this.in1 = row.getCell(7) != null ? fixDate(row.getCell(7)
				.getDateCellValue(), date) : null;
		this.out1 = row.getCell(8) != null ? fixDate(row.getCell(8)
				.getDateCellValue(), date) : null;
		this.in2 = row.getCell(9) != null ? fixDate(row.getCell(9)
				.getDateCellValue(), date) : null;
		this.out2 = row.getCell(10) != null ? fixDate(row.getCell(10)
				.getDateCellValue(), date) : null;
		this.in3 = row.getCell(11) != null ? fixDate(row.getCell(11)
				.getDateCellValue(), date) : null;
		this.out3 = row.getCell(12) != null ? fixDate(row.getCell(12)
				.getDateCellValue(), date) : null;
		if (row.getCell(13) != null) {
			this.workingTimeHours = ((Double) row.getCell(13)
					.getNumericCellValue()).intValue();
		} else {
			this.workingTimeHours = 0;
		}

	}

	// private Date getDetailDateTime(Date date, String hhmmString) {
	// if (StringUtils.trimToNull(hhmmString) == null || date == null)
	// return null;
	// int hour = Integer.parseInt(hhmmString.split(":")[0]);
	// int min = Integer.parseInt(hhmmString.split(":")[1]);
	//
	// final Calendar calendar = Calendar.getInstance();
	// calendar.setTime(date);
	// calendar.set(Calendar.HOUR, hour);
	// calendar.set(Calendar.MINUTE, min);
	// return calendar.getTime();
	// }

	private Date fixDate(Date srcDate, Date destDate) {
		if (srcDate == null)
			return null;
		final Calendar calendar = Calendar.getInstance();
		System.out.println("SRC_DATE: " + srcDate);
		calendar.setTime(srcDate);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int min = calendar.get(Calendar.MINUTE);

		calendar.setTime(destDate);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, min);

		return calendar.getTime();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Date getIn1() {
		return in1;
	}

	public void setIn1(Date in1) {
		this.in1 = in1;
	}

	public Date getOut1() {
		return out1;
	}

	public void setOut1(Date out1) {
		this.out1 = out1;
	}

	public Date getIn2() {
		return in2;
	}

	public void setIn2(Date in2) {
		this.in2 = in2;
	}

	public Date getOut2() {
		return out2;
	}

	public void setOut2(Date out2) {
		this.out2 = out2;
	}

	public Date getIn3() {
		return in3;
	}

	public void setIn3(Date in3) {
		this.in3 = in3;
	}

	public Date getOut3() {
		return out3;
	}

	public void setOut3(Date out3) {
		this.out3 = out3;
	}

	public int getWorkingTimeHours() {
		return workingTimeHours;
	}

	public void setWorkingTimeHours(int workingTimeHours) {
		this.workingTimeHours = workingTimeHours;
	}

	public int getOT_TimeHours() {
		return OT_TimeHours;
	}

	public void setOT_TimeHours(int OT_TimeHours) {
		this.OT_TimeHours = OT_TimeHours;
	}

	public int getSoonLateMins() {
		return soonLateMins;
	}

	public void setSoonLateMins(int soonLateMins) {
		this.soonLateMins = soonLateMins;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getSignal() {
		return signal;
	}

	public void setSignal(String signal) {
		this.signal = signal;
	}

	@Override
	public String toString() {
		return "SourceTimeItem{" + "date=" + date + ", day='" + day + '\''
				+ ", in1=" + in1 + ", out1=" + out1 + ", in2=" + in2
				+ ", out2=" + out2 + ", in3=" + in3 + ", out3=" + out3
				+ ", workingTimeHours=" + workingTimeHours + ", OT_TimeHours="
				+ OT_TimeHours + ", soonLateMins=" + soonLateMins + ", total="
				+ total + ", shift='" + shift + '\'' + ", signal='" + signal
				+ '\'' + '}';
	}
}