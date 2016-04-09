package vn.com.ecopharma.rc.client.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author TaoTran
 *
 */
@ManagedBean
@SessionScoped
public class GlobalBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Long> appliedVacancies;

	public void init() {
		if (appliedVacancies != null && !appliedVacancies.isEmpty())
			return;
		appliedVacancies = new ArrayList<>();
	}

	public List<Long> getAppliedVacancies() {
		return appliedVacancies;
	}

	public void setAppliedVacancies(List<Long> appliedVacancies) {
		this.appliedVacancies = appliedVacancies;
	}

}
