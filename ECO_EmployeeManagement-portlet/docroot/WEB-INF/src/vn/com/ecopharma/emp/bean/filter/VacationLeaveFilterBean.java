package vn.com.ecopharma.emp.bean.filter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "leaveFilterBean")
@ViewScoped
public class VacationLeaveFilterBean extends BaseEmpFilterBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PostConstruct
	@Override
	public void init() {
		super.init();
	}
}
