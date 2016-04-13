package vn.com.ecopharma.emp.bean.filter;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "disciplineFilterBean")
@ViewScoped
public class EmpDisciplineFilterBean extends BaseEmpFilterBean {

	private static final long serialVersionUID = 1L;

	private Date effectiveDateFrom;

	private Date effectiveDateTo;

	@PostConstruct
	@Override
	public void init() {
		super.init();
	}

	public void resetEffectiveDateFrom() {
		effectiveDateFrom = null;
	}

	public void resetEffectiveDateTo() {
		effectiveDateTo = null;
	}

	public Date getEffectiveDateFrom() {
		return effectiveDateFrom;
	}

	public void setEffectiveDateFrom(Date effectiveDateFrom) {
		this.effectiveDateFrom = effectiveDateFrom;
	}

	public Date getEffectiveDateTo() {
		return effectiveDateTo;
	}

	public void setEffectiveDateTo(Date effectiveDateTo) {
		this.effectiveDateTo = effectiveDateTo;
	}
}
