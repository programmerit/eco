package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.RateEvent;

import com.liferay.portal.kernel.exception.SystemException;

import vn.com.ecopharma.hrm.rc.dto.CandidateIndexItem;
import vn.com.ecopharma.hrm.rc.dto.evaluate.EvaluationCriteriaItem;
import vn.com.ecopharma.hrm.rc.dto.evaluate.EvaluationItem;
import vn.com.ecopharma.hrm.rc.dto.evaluate.KeyValueItem;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateStatus;
import vn.com.ecopharma.hrm.rc.enumeration.InterviewScheduleStatus;
import vn.com.ecopharma.hrm.rc.model.CandidateEvaluation;
import vn.com.ecopharma.hrm.rc.model.InterviewSchedule;
import vn.com.ecopharma.hrm.rc.service.CandidateEvaluationLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalServiceUtil;
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

	public void onEvaluate(ActionEvent event) {
		final List<KeyValueItem> evaluatedValues = new ArrayList<>();

		for (EvaluationItem item : evaluationItems) {
			for (EvaluationCriteriaItem item1 : item
					.getEvaluationCriteriaItems()) {
				evaluatedValues.addAll(item1.getKeyValueItems());
			}
		}
		for (CandidateIndexItem candidate : candidateIndexItems) {
			InterviewSchedule currentProcessingInterviewSchedule = InterviewScheduleLocalServiceUtil
					.findByVacancyCandidateAndStatus(
							candidate.getVacancyCandidateId(),
							InterviewScheduleStatus.PROCESSING.toString());
			for (KeyValueItem item : evaluatedValues) {
				long candidateId = candidate.getId();
				long interviewId = currentProcessingInterviewSchedule
						.getInterviewId();
				long critKeyValueId = item.getObject()
						.getEvaluationCriteriaKeyValueId();
				int ratingPoint = item.getEvaluateValue();

				CandidateEvaluation evaluation = CandidateEvaluationLocalServiceUtil
						.fetchByCandidateInterviewAndCritKey(candidateId,
								interviewId, critKeyValueId);
				if (evaluation == null) {
					CandidateEvaluationLocalServiceUtil
							.addCandidateEvaluation(candidate.getId(),
									currentProcessingInterviewSchedule
											.getInterviewId(), item.getObject()
											.getEvaluationCriteriaKeyValueId(),
									item.getEvaluateValue(), RCUtils
											.getServiceContext());
				} else {
					try {
						CandidateEvaluationLocalServiceUtil
								.updateCandidateEvaluation(evaluation,
										ratingPoint,
										RCUtils.getServiceContext());
					} catch (SystemException e) {
						e.printStackTrace();
					}
				}

			}
		}

		FacesMessage message = new FacesMessage("Evaluated Info",
				"Successfully evaluated candidates!");
		FacesContext.getCurrentInstance().addMessage(null, message);

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
