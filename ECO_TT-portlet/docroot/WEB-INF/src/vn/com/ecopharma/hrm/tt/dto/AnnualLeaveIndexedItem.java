package vn.com.ecopharma.hrm.tt.dto;

import vn.com.ecopharma.emp.service.EmpAnnualLeaveLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.constant.EmpAnnualLeaveField;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

import com.liferay.portal.kernel.search.Document;

public class AnnualLeaveIndexedItem extends BaseEmpInfoIndexedItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double totalLeaveLeft;

	private double totalLeave;

	private double totalPreviousYearLeavesLeft;

	public AnnualLeaveIndexedItem(Document document) {
		super(document);
		this.totalLeave = checkNullFieldAndReturnDoubleValue(EmpAnnualLeaveField.TOTAL_LEAVE);
		this.totalLeaveLeft = checkNullFieldAndReturnDoubleValue(EmpAnnualLeaveField.TOTAL_LEAVE_LEFT);
		this.totalPreviousYearLeavesLeft = checkNullFieldAndReturnDoubleValue(EmpAnnualLeaveField.TOTAL_PREVIOUS_YEAR_LEAVE);
	}

	public AnnualLeaveIndexedItem(String rowKey) {
		this(EmpAnnualLeaveLocalServiceUtil.getIndexedDocument(rowKey,
				TTUtils.getCurrentSearchContext()));
	}

	@Override
	protected String getIdFieldName() {
		return EmpAnnualLeaveField.ID;
	}

	public double getTotalLeaveLeft() {
		return totalLeaveLeft;
	}

	public void setTotalLeaveLeft(double totalLeaveLeft) {
		this.totalLeaveLeft = totalLeaveLeft;
	}

	public double getTotalLeave() {
		return totalLeave;
	}

	public void setTotalLeave(double totalLeave) {
		this.totalLeave = totalLeave;
	}

	public double getTotalPreviousYearLeavesLeft() {
		return totalPreviousYearLeavesLeft;
	}

	public void setTotalPreviousYearLeavesLeft(
			double totalPreviousYearLeavesLeft) {
		this.totalPreviousYearLeavesLeft = totalPreviousYearLeavesLeft;
	}

}
