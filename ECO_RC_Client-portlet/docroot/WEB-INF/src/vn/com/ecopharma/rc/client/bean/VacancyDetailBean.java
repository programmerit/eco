package vn.com.ecopharma.rc.client.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import vn.com.ecopharma.rc.client.dto.VacancyIndexItem;

@ManagedBean
@ViewScoped
public class VacancyDetailBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VacancyIndexItem vacancy;

	public VacancyIndexItem getVacancy() {
		return vacancy;
	}

	public void setVacancy(VacancyIndexItem vacancy) {
		this.vacancy = vacancy;
	}

}
