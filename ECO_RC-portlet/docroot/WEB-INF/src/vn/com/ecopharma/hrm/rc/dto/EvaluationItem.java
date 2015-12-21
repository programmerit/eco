package vn.com.ecopharma.hrm.rc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import vn.com.ecopharma.hrm.rc.model.EvaluationCriteria;
import vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue;
import vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaKeyValueLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaLocalServiceUtil;

public class EvaluationItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EvaluationCriteria evaluationCriteria;

	private List<EvaluationKeyValueItem> evaluationKeyValueItems;

	public EvaluationItem(EvaluationCriteria evaluationCriteria) {
		super();
		this.evaluationCriteria = evaluationCriteria;
		this.evaluationKeyValueItems = getEvaluationKeyValueItemsByEvaluationCriteria(this.evaluationCriteria);
	}

	public EvaluationItem(String evaluationType) {
		this(EvaluationCriteriaLocalServiceUtil.findByType(evaluationType));
	}

	private List<EvaluationKeyValueItem> getEvaluationKeyValueItemsByEvaluationCriteria(
			EvaluationCriteria evaluationCriteria) {
		final List<EvaluationKeyValueItem> results = new ArrayList<EvaluationItem.EvaluationKeyValueItem>();
		if (evaluationCriteria == null)
			return results;

		for (EvaluationCriteriaKeyValue item : EvaluationCriteriaKeyValueLocalServiceUtil
				.findByEvaluationCriteria(evaluationCriteria
						.getEvaluationCriteriaId())) {
			results.add(new EvaluationKeyValueItem(item));
		}
		return results;
	}

	public EvaluationCriteria getEvaluationCriteria() {
		return evaluationCriteria;
	}

	public void setEvaluationCriteria(EvaluationCriteria evaluationCriteria) {
		this.evaluationCriteria = evaluationCriteria;
	}

	public List<EvaluationKeyValueItem> getEvaluationKeyValueItems() {
		return evaluationKeyValueItems;
	}

	public void setEvaluationKeyValueItems(
			List<EvaluationKeyValueItem> evaluationKeyValueItems) {
		this.evaluationKeyValueItems = evaluationKeyValueItems;
	}

	public class EvaluationKeyValueItem implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String key;
		private EvaluationCriteriaKeyValue evaluationCriteriaKeyValue;
		private int value = 0;
		private int maxValue;

		public EvaluationKeyValueItem(
				EvaluationCriteriaKeyValue evaluationCriteriaKeyValue) {
			this.evaluationCriteriaKeyValue = evaluationCriteriaKeyValue;
			this.key = evaluationCriteriaKeyValue.getKey();
			this.maxValue = evaluationCriteriaKeyValue.getValue();
			this.value = 0;
		}

		public int getMaxValue() {
			return maxValue;
		}

		public void setMaxValue(int maxValue) {
			this.maxValue = maxValue;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public EvaluationCriteriaKeyValue getEvaluationCriteriaKeyValue() {
			return evaluationCriteriaKeyValue;
		}

		public void setEvaluationCriteriaKeyValue(
				EvaluationCriteriaKeyValue evaluationCriteriaKeyValue) {
			this.evaluationCriteriaKeyValue = evaluationCriteriaKeyValue;
		}
	}
}
