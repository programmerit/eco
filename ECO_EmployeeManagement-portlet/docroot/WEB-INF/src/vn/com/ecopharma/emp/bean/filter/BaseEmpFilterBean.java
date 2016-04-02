package vn.com.ecopharma.emp.bean.filter;

import org.apache.commons.lang3.StringUtils;

public class BaseEmpFilterBean extends OrganizationFilterBean implements
		BaseEmpFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fullName = StringUtils.EMPTY;
	private String empCode = StringUtils.EMPTY;

	@Override
	public void init() {
		super.init();
	}

	@Override
	public String getFullName() {
		return fullName;
	}

	@Override
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String getEmpCode() {
		return empCode;
	}

	@Override
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

}
