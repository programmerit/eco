package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.RateEvent;

import vn.com.ecopharma.hrm.rc.dto.CandidateIndexItem;
import vn.com.ecopharma.hrm.rc.dto.evaluate.EvaluationCriteriaItem;
import vn.com.ecopharma.hrm.rc.dto.evaluate.EvaluationItem;
import vn.com.ecopharma.hrm.rc.dto.evaluate.KeyValueItem;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateStatus;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

@ManagedBean
@ViewScoped
public class EvaluationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<CandidateIndexItem> candidateIndexItems;

	private List<EvaluationItem> evaluationItems;

	@PostConstruct
	public void init() {
	}

	public void onOffer(ActionEvent event) {
		// for (CandidateIndexItem item : candidateIndexItems) {
		// for (EvaluationItem eItem : evaluationItems) {
		// for (EvaluationKeyValueItem kvItem : eItem
		// .getEvaluationKeyValueItems()) {
		// CandidateEvaluation candidateEvaluation =
		// CandidateEvaluationLocalServiceUtil
		// .addCandidateEvaluation(item.getId(), eItem
		// .getEvaluationCriteria()
		// .getEvaluationCriteriaId(), kvItem
		// .getEvaluationCriteriaKeyValue()
		// .getEvaluationCriteriaKeyValueId(), kvItem
		// .getValue(), RCUtils.getServiceContext());
		//
		// if (candidateEvaluation != null) {
		// CandidateLocalServiceUtil.changeCandidateStatus(
		// item.getId(),
		// CandidateStatus.JOB_OFFERED.toString(),
		// RCUtils.getServiceContext());
		// }
		// }
		// }
		// }
	}

	public void onEvaluate(ActionEvent event) {
		for (EvaluationItem item : evaluationItems) {
			System.out.println(item.getType());
			for (EvaluationCriteriaItem item1 : item
					.getEvaluationCriteriaItems()) {
				for (KeyValueItem item2 : item1.getKeyValueItems()) {
					System.out.println(item2.getEvaluateValue());
				}
			}
		}
	}

	public void onOfferWORating(ActionEvent event) {
		for (CandidateIndexItem item : candidateIndexItems) {
			CandidateLocalServiceUtil.changeCandidateStatus(item.getId(),
					CandidateStatus.JOB_OFFERED.toString(),
					RCUtils.getServiceContext());
		}
	}

	public void onCancel(ActionEvent event) {

	}

	public void onRating(RateEvent event) {

	}

	public void onCloseDialog(CloseEvent event) {

	}

	public List<CandidateIndexItem> getCandidateIndexItems() {
		return candidateIndexItems;
	}

	public void setCandidateIndexItems(
			List<CandidateIndexItem> candidateIndexItems) {
		this.candidateIndexItems = candidateIndexItems;
	}

	public List<EvaluationItem> getEvaluationItems() {
		return evaluationItems;
	}

	public void setEvaluationItems(List<EvaluationItem> evaluationItems) {
		this.evaluationItems = evaluationItems;
	}

}
