package vn.com.ecopharma.hrm.rc.bean.dialog;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.liferay.portal.kernel.exception.SystemException;

import vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue;
import vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaKeyValueLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

@ManagedBean(name = "critKeyValBean")
@ViewScoped
public class CriteriaKeyValBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EvaluationCriteriaKeyValue criteriaKeyValue;

	@PostConstruct
	public void init() {

		try {
			criteriaKeyValue = EvaluationCriteriaKeyValueLocalServiceUtil
					.creatPrePersistedEntity(RCUtils.getServiceContext());
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public EvaluationCriteriaKeyValue getCriteriaKeyValue() {
		return criteriaKeyValue;
	}

	public void setCriteriaKeyValue(EvaluationCriteriaKeyValue criteriaKeyValue) {
		this.criteriaKeyValue = criteriaKeyValue;
	}

}
