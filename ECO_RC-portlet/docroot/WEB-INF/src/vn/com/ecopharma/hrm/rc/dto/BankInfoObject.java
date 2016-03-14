package vn.com.ecopharma.hrm.rc.dto;

import org.apache.commons.lang.StringUtils;

import vn.com.ecopharma.emp.model.EmpBankInfo;
import vn.com.ecopharma.emp.service.EmpBankInfoLocalServiceUtil;

public class BankInfoObject extends AbstractUIBaseModelItem<EmpBankInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankInfoObject() {
		super();
	}

	public BankInfoObject(EmpBankInfo bankInfo) {
		super(bankInfo);
	}

	@Override
	protected EmpBankInfo createPrePersistedBaseModel() {
		return EmpBankInfoLocalServiceUtil.createPrePersistedEntity(0L,
				StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY);
	}

}
