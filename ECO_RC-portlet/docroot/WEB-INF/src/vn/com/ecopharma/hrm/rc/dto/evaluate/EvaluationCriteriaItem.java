package vn.com.ecopharma.hrm.rc.dto.evaluate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import vn.com.ecopharma.hrm.rc.model.EvaluationCriteria;
import vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue;
import vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaKeyValueLocalServiceUtil;

public class EvaluationCriteriaItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EvaluationCriteria crit;

	private List<KeyValueItem> keyValueItems;

	public EvaluationCriteriaItem(EvaluationCriteria crit) {
		super();
		this.crit = crit;
		this.keyValueItems = getKeyValues();
	}

	private List<KeyValueItem> getKeyValues() {
		final List<KeyValueItem> results = new ArrayList<>();
		if (crit == null)
			return results;

		for (EvaluationCriteriaKeyValue item : EvaluationCriteriaKeyValueLocalServiceUtil
				.findByEvaluationCriteria(crit.getEvaluationCriteriaId())) {
			results.add(new KeyValueItem(item));
		}
		return results;
	}

	public List<KeyValueItem> getKeyValueItems() {
		return keyValueItems;
	}

	public void setKeyValueItems(List<KeyValueItem> keyValueItems) {
		this.keyValueItems = keyValueItems;
	}

	public EvaluationCriteria getCrit() {
		return crit;
	}

	public void setCrit(EvaluationCriteria crit) {
		this.crit = crit;
	}

}