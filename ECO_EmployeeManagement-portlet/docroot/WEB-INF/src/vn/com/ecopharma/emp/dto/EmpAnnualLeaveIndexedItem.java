package vn.com.ecopharma.emp.dto;

import vn.com.ecopharma.emp.constant.EmpAnnualLeaveField;

import com.liferay.portal.kernel.search.Document;

public class EmpAnnualLeaveIndexedItem extends BaseEmpInfoIndexedItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int totalLeave;
	private double totalLeaveLeft;
	private double totalPreviousYearLeave;

	public EmpAnnualLeaveIndexedItem(Document document) {
		super(document);
		this.totalLeave = checkNullFieldAndReturnIntegerValue(EmpAnnualLeaveField.TOTAL_LEAVE);
		this.totalLeaveLeft = checkNullFieldAndReturnDoubleValue(EmpAnnualLeaveField.TOTAL_LEAVE_LEFT);
		this.totalPreviousYearLeave = checkNullFieldAndReturnDoubleValue(EmpAnnualLeaveField.TOTAL_PREVIOUS_YEAR_LEAVE);
	}

	public int getTotalLeave() {
		return totalLeave;
	}

	public void setTotalLeave(int totalLeave) {
		this.totalLeave = totalLeave;
	}

	public double getTotalLeaveLeft() {
		return totalLeaveLeft;
	}

	public void setTotalLeaveLeft(double totalLeaveLeft) {
		this.totalLeaveLeft = totalLeaveLeft;
	}

	public double getTotalPreviousYearLeave() {
		return totalPreviousYearLeave;
	}

	public void setTotalPreviousYearLeave(double totalPreviousYearLeave) {
		this.totalPreviousYearLeave = totalPreviousYearLeave;
	}

	@Override
	protected String getIdFieldName() {
		return EmpAnnualLeaveField.ID;
	}

}
