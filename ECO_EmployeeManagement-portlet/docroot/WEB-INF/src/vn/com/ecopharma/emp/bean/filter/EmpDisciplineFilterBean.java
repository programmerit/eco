package vn.com.ecopharma.emp.bean.filter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;

@ManagedBean(name = "disciplineFilterBean")
@ViewScoped
public class EmpDisciplineFilterBean extends OrganizationFilterBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fullName = StringUtils.EMPTY;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
