package vn.com.ecopharma.emp.dto;

import java.io.Serializable;

public class BankInfoObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bankNo;
	private String bankName;
	private String bankBranchName;
	
	private boolean UIDeleted = false;

	public BankInfoObject(String bankNo, String bankName,
			String bankBranchName, boolean uIDeleted) {
		this.bankNo = bankNo;
		this.bankName = bankName;
		this.bankBranchName = bankBranchName;
		this.UIDeleted = uIDeleted;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranchName() {
		return bankBranchName;
	}

	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}

	public boolean isUIDeleted() {
		return UIDeleted;
	}

	public void setUIDeleted(boolean uIDeleted) {
		UIDeleted = uIDeleted;
	}
}
