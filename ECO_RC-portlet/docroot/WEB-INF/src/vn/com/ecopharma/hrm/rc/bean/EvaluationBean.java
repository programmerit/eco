package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.RateEvent;

import vn.com.ecopharma.hrm.rc.dto.CandidateIndexItem;
import vn.com.ecopharma.hrm.rc.dto.EvaluationItem;
import vn.com.ecopharma.hrm.rc.dto.EvaluationItem.EvaluationKeyValueItem;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateStatus;
import vn.com.ecopharma.hrm.rc.model.CandidateEvaluation;
import vn.com.ecopharma.hrm.rc.model.EvaluationCriteria;
import vn.com.ecopharma.hrm.rc.service.CandidateEvaluationLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

@ManagedBean
@ViewScoped
public class EvaluationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<EvaluationItem> evaluationItems;
	private List<CandidateIndexItem> candidateIndexItems;

	@PostConstruct
	public void init() {
		this.evaluationItems = getEvaluationItemsFromEvaluationCriteria();
	}

	public void onOffer(ActionEvent event) {
		for (CandidateIndexItem item : candidateIndexItems) {
			for (EvaluationItem eItem : evaluationItems) {
				for (EvaluationKeyValueItem kvItem : eItem
						.getEvaluationKeyValueItems()) {
					CandidateEvaluation candidateEvaluation = CandidateEvaluationLocalServiceUtil
							.addCandidateEvaluation(item.getCandidateId(),
									eItem.getEvaluationCriteria()
											.getEvaluationCriteriaId(), kvItem
											.getEvaluationCriteriaKeyValue()
											.getEvaluationCriteriaKeyValueId(),
									kvItem.getValue(), RCUtils
											.getServiceContext());

					if (candidateEvaluation != null) {
						CandidateLocalServiceUtil.changeCandidateStatus(
								item.getCandidateId(),
								CandidateStatus.JOB_OFFERED.toString(),
								RCUtils.getServiceContext());
					}
				}
			}
		}
	}

	public void onOfferWORating(ActionEvent event) {
		for (CandidateIndexItem item : candidateIndexItems) {
			CandidateLocalServiceUtil.changeCandidateStatus(
					item.getCandidateId(),
					CandidateStatus.JOB_OFFERED.toString(),
					RCUtils.getServiceContext());
		}
	}

	public void onCancel(ActionEvent event) {
		this.evaluationItems = null;
	}

	public void onRating(RateEvent event) {
	}

	public List<EvaluationItem> getEvaluationItemsFromEvaluationCriteria() {
		final List<EvaluationItem> results = new ArrayList<EvaluationItem>();
		for (EvaluationCriteria item : EvaluationCriteriaLocalServiceUtil
				.findAll()) {
			results.add(new EvaluationItem(item));
		}
		return results;
	}

	public List<EvaluationItem> getEvaluationItems() {
		return evaluationItems;
	}

	public void setEvaluationItems(List<EvaluationItem> evaluationItems) {
		this.evaluationItems = evaluationItems;
	}

	public List<CandidateIndexItem> getCandidateIndexItems() {
		return candidateIndexItems;
	}

	public void setCandidateIndexItems(
			List<CandidateIndexItem> candidateIndexItems) {
		this.candidateIndexItems = candidateIndexItems;
	}

}
