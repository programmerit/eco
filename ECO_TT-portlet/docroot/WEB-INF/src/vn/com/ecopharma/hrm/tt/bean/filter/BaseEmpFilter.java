package vn.com.ecopharma.hrm.tt.bean.filter;

import java.io.Serializable;

import vn.com.ecopharma.hrm.tt.bean.OrganizationFilter;

public interface BaseEmpFilter extends OrganizationFilter, Serializable {

	public String getFullName();

	public void setFullName(String fullName);

	public String getEmpCode();

	public void setEmpCode(String empCode);

}
