package vn.com.ecopharma.hrm.tt.dto.ie;

import java.io.Serializable;

public class AnnualLeaveItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String empCode;

	private double totalPrevYearLeaves;

	private double totalLeavesUsed;

	private double totalLeavesLeft;

	public AnnualLeaveItem(String empCode, double totalPrevYearLeaves,
			double totalLeavesUsed) {
		this.empCode = empCode;
		this.totalPrevYearLeaves = totalPrevYearLeaves;
		this.totalLeavesUsed = totalLeavesUsed;
	}

	public AnnualLeaveItem(String empCode, double totalPrevYearLeaves,
			double leavesInMonth1, double leavesInMonth2) {
		
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public double getTotalPrevYearLeaves() {
		return totalPrevYearLeaves;
	}

	public void setTotalPrevYearLeaves(double totalPrevYearLeaves) {
		this.totalPrevYearLeaves = totalPrevYearLeaves;
	}

	public double getTotalLeavesUsed() {
		return totalLeavesUsed;
	}

	public void setTotalLeavesUsed(double totalLeavesUsed) {
		this.totalLeavesUsed = totalLeavesUsed;
	}

	public double getTotalLeavesLeft() {
		return totalLeavesLeft;
	}

	public void setTotalLeavesLeft(double totalLeavesLeft) {
		this.totalLeavesLeft = totalLeavesLeft;
	}

}
