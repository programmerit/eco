package vn.com.ecopharma.emp.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import vn.com.ecopharma.emp.dto.FilterDTO;

@ManagedBean
@SessionScoped
public class EmpGlobalFilterHolderBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FilterDTO empFilterDTO;

	public FilterDTO getEmpFilterDTO() {
		return empFilterDTO;
	}

	public void setEmpFilterDTO(FilterDTO empFilterDTO) {
		this.empFilterDTO = empFilterDTO;
	}

}
