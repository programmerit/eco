package vn.com.ecopharma.hrm.rc.dto.evaluate;

import java.io.Serializable;

import vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue;

public class KeyValueItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EvaluationCriteriaKeyValue object;
	private int evaluateValue;

	public KeyValueItem(EvaluationCriteriaKeyValue object) {
		this.object = object;
		this.evaluateValue = 0;
	}

	public int getEvaluateValue() {
		return evaluateValue;
	}

	public void setEvaluateValue(int evaluateValue) {
		this.evaluateValue = evaluateValue;
	}

	public EvaluationCriteriaKeyValue getObject() {
		return object;
	}

	public void setObject(EvaluationCriteriaKeyValue object) {
		this.object = object;
	}

}