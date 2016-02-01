package vn.com.ecopharma.emp.bean.filter;

import java.io.Serializable;

public interface BaseEmpFilter extends OrganizationFilter, Serializable {

	public String getFullName();

	public void setFullName(String fullName);

	public String getEmpCode();

	public void setEmpCode(String empCode);

}
