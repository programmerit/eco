package vn.com.ecopharma.hrm.rc.dto.evaluate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import vn.com.ecopharma.hrm.rc.model.EvaluationCriteria;
import vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaLocalServiceUtil;

public class EvaluationItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String type;

	private List<EvaluationCriteriaItem> evaluationCriteriaItems;

	public EvaluationItem(String type) {
		super();
		this.type = type;
		this.evaluationCriteriaItems = getEvaluationCriterias();
	}

	public List<EvaluationCriteriaItem> getEvaluationCriterias() {
		final List<EvaluationCriteriaItem> result = new ArrayList<>();
		for (EvaluationCriteria evaluationCriteria : EvaluationCriteriaLocalServiceUtil
				.findByType(type)) {
			result.add(new EvaluationCriteriaItem(evaluationCriteria));
		}
		return result;
	}

	public List<EvaluationCriteriaItem> getEvaluationCriteriaItems() {
		return evaluationCriteriaItems;
	}

	public void setEvaluationCriteriaItems(
			List<EvaluationCriteriaItem> evaluationCriteriaItems) {
		this.evaluationCriteriaItems = evaluationCriteriaItems;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
