package vn.com.ecopharma.emp.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import vn.com.ecopharma.emp.dto.FilterDTO;

@ManagedBean
@SessionScoped
public class EmpGlobalFilterHolderBean {

	private FilterDTO empFilterDTO;

	public FilterDTO getEmpFilterDTO() {
		return empFilterDTO;
	}

	public void setEmpFilterDTO(FilterDTO empFilterDTO) {
		this.empFilterDTO = empFilterDTO;
	}

}
