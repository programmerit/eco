package vn.com.ecopharma.hrm.rc.dto;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import vn.com.ecopharma.emp.model.EmpBankInfo;
import vn.com.ecopharma.emp.service.EmpBankInfoLocalServiceUtil;

public class BankInfoObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmpBankInfo empBankInfo;

	private boolean UIDeleted = false; // NOSONAR

	public BankInfoObject() {
		this.empBankInfo = EmpBankInfoLocalServiceUtil
				.createPrePersistedEntity(0L, StringUtils.EMPTY,
						StringUtils.EMPTY, StringUtils.EMPTY);
		this.UIDeleted = false;
	}

	public BankInfoObject(EmpBankInfo bankInfo) {
		this.empBankInfo = bankInfo;
		this.UIDeleted = false;
	}

	public boolean isUIDeleted() {
		return UIDeleted;
	}

	public void setUIDeleted(boolean uIDeleted) {
		UIDeleted = uIDeleted;
	}

	public EmpBankInfo getEmpBankInfo() {
		return empBankInfo;
	}

	public void setEmpBankInfo(EmpBankInfo empBankInfo) {
		this.empBankInfo = empBankInfo;
	}
	
	
}
