package vn.com.ecopharma.hrm.rc.bean.dialog;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.liferay.portal.kernel.exception.SystemException;

import vn.com.ecopharma.hrm.rc.model.EvaluationCriteria;
import vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaLocalServiceUtil;

@ManagedBean(name = "criteriaBean")
@ViewScoped
public class CriteriaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EvaluationCriteria criteria;

	@PostConstruct
	public void init() {
		criteria = EvaluationCriteriaLocalServiceUtil
				.createPrePersistedEntity();
	}

	public void onSave(ActionEvent event) {
		try {
			EvaluationCriteriaLocalServiceUtil.addEvaluationCriteria(criteria);
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public EvaluationCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(EvaluationCriteria criteria) {
		this.criteria = criteria;
	}

}
