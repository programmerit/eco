package vn.com.ecopharma.hrm.rc.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.portlet.PortletRequest;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.model.University;
import vn.com.ecopharma.emp.service.DocumentLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.bean.filter.CandidateFilterBean;
import vn.com.ecopharma.hrm.rc.constant.CandidateField;
import vn.com.ecopharma.hrm.rc.constant.CandidateNavigation;
import vn.com.ecopharma.hrm.rc.constant.ECO_RCUtils;
import vn.com.ecopharma.hrm.rc.constant.VacancyField;
import vn.com.ecopharma.hrm.rc.dm.CandidateLazyDataModel;
import vn.com.ecopharma.hrm.rc.dto.CandidateIndexItem;
import vn.com.ecopharma.hrm.rc.dto.CandidateItem;
import vn.com.ecopharma.hrm.rc.dto.CertificateObjectItem;
import vn.com.ecopharma.hrm.rc.dto.DocumentItem;
import vn.com.ecopharma.hrm.rc.dto.ExperienceObjectItem;
import vn.com.ecopharma.hrm.rc.dto.InterviewScheduleForAllItem;
import vn.com.ecopharma.hrm.rc.dto.InterviewScheduleItem;
import vn.com.ecopharma.hrm.rc.dto.VacancyIndexItem;
import vn.com.ecopharma.hrm.rc.dto.evaluate.EvaluationItem;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateCertificateType;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateStatus;
import vn.com.ecopharma.hrm.rc.enumeration.DocumentType;
import vn.com.ecopharma.hrm.rc.enumeration.EvaluationCriteriaType;
import vn.com.ecopharma.hrm.rc.enumeration.InterviewScheduleStatus;
import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.model.Certificate;
import vn.com.ecopharma.hrm.rc.model.Experience;
import vn.com.ecopharma.hrm.rc.model.InterviewSchedule;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.CertificateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.ExperienceLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.BeanUtils;
import vn.com.ecopharma.hrm.rc.util.EmployeeUtils;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.ServiceContext;

@ManagedBean(name = "candidateBean")
@ViewScoped
public class CandidateBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactoryUtil
			.getLog(CandidateBean.class);

	private CandidateIndexItem selectedItem;

	private List<CandidateIndexItem> selectedItems;

	private CandidateItem candidateItem;

	private LazyDataModel<CandidateIndexItem> lazyDataModel;

	private List<VacancyIndexItem> vacancyIndexItems;

	private List<Long> fileEntryIds;

	private long deletedCandidateId;

	private String rejectReason = StringUtils.EMPTY;// TODO refactor

	private String selectedDocumentType;

	private int deletedDocumentIndex = -1;

	private String onCompleteUpdate = StringUtils.EMPTY;

	private String selectedStatus = StringUtils.EMPTY;

	private String includedDialog = StringUtils.EMPTY;

	@ManagedProperty(value = "#{candidateViewBean}")
	private CandidateViewBean candidateViewBean;

	@PostConstruct
	public void init() {
		selectedItems = new ArrayList<>();

		lazyDataModel = new CandidateLazyDataModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public List<CandidateIndexItem> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				CandidateFilterBean filterBean = BeanUtils
						.getCandidateFilterBean();
				if (!filterBean.getGlobal().equals(StringUtils.EMPTY)) {
					filters.put(CandidateField.GLOBAL, filterBean.getGlobal());
				}

				if (filterBean.getSelectedStatuses() != null
						&& !filterBean.getSelectedStatuses().isEmpty()) {
					List<String> removedDashStatuses = new ArrayList<>();
					for (String status : filterBean.getSelectedStatuses()) {
						removedDashStatuses.add(EmpLocalServiceUtil
								.removeDashChar(status));
					}
					filters.put(CandidateField.STATUS,
							filterBean.getSelectedStatuses());
				}

				if (!filterBean.getFullName().equals(StringUtils.EMPTY)) {
					filters.put(CandidateField.FULLNAME,
							filterBean.getFullName());
				}

				if (!filterBean.getEmailAddress().equals(StringUtils.EMPTY)) {
					filters.put(CandidateField.EMAIL,
							filterBean.getEmailAddress());
				}

				if (!filterBean.getContactNumber().equals(StringUtils.EMPTY)) {
					filters.put(CandidateField.CONTACT_NUMBER,
							filterBean.getContactNumber());
				}

				if (filterBean.getVacancyItems() != null
						&& !filterBean.getVacancyItems().isEmpty()) {
					filters.put(CandidateField.VACANCY,
							filterBean.getVacancyItems());
				}

				if (filterBean.getApplyDateFrom() != null) {
					filters.put(CandidateField.APPLY_DATE_FROM,
							filterBean.getApplyDateFrom());
				}

				if (filterBean.getApplyDateTo() != null) {
					filters.put(CandidateField.APPLY_DATE_TO,
							filterBean.getApplyDateTo());
				}
				return super.load(first, pageSize, sortField, sortOrder,
						filters);

			}
		};
		fileEntryIds = new ArrayList<>();
		vacancyIndexItems = ECO_RCUtils
				.getVacancyIndexItems(VacancyLocalServiceUtil
						.searchAllUnDeletedVacanciesIndexedDocument(RCUtils
								.getCurrentSearchContext(),
								new ArrayList<Query>(), RCUtils
										.getCurrentSearchContext()
										.getCompanyId(), null,
								QueryUtil.ALL_POS, QueryUtil.ALL_POS));
	}

	public void onStatusChange(AjaxBehaviorEvent event) {
		final CandidateIndexItem item = lazyDataModel.getRowData();
		final CandidateStatus status = CandidateStatus.valueOf(selectedStatus);

		final ServiceContext serviceContext = LiferayFacesContext.getInstance()
				.getServiceContext();

		switch (status) {
		case INTERVIEW_SCHEDULED:
			ScheduleInterviewForCandidatesBean bean = (ScheduleInterviewForCandidatesBean) BeanUtils
					.getBackingBeanByName("scheduleInterviewForCandidatesBean");
			bean.setInterviewScheduleItems(Arrays
					.asList(new InterviewScheduleItem(item)));
			bean.setInterviewScheduleForAllItem(new InterviewScheduleForAllItem());
			candidateViewBean
					.switchMode(CandidateNavigation.SCHEDULE_INTERVIEW);
			onCompleteUpdate = "updateCandidatePanelGroup();";
			break;

		case EVALUATE_CANDIDATE:
			onEvaluateCandidates(Arrays.asList(item));
			break;
		case HIRE:
			EmployeeBean employeeBean = (EmployeeBean) BeanUtils
					.getBackingBeanByName("employeeBean");
			if (employeeBean.transferCandidateInfo(item) != null) {
				candidateViewBean.switchMode(4);
			}
			onCompleteUpdate = "updateCandidatePanelGroup();";
			break;
		case MARK_INTERVIEW_PASS:
		case MARK_INTERVIEW_FAIL:
			InterviewSchedule interviewSchedule = InterviewScheduleLocalServiceUtil
					.findByVacancyCandidateAndStatus(
							item.getVacancyCandidateId(),
							InterviewScheduleStatus.PROCESSING.toString());
			InterviewScheduleLocalServiceUtil
					.setInterviewStatusByCandidateStatus(status.toString(),
							item.getId(), interviewSchedule, serviceContext);
			onCompleteUpdate = "updateCandidatesAndGrowl();";
			break;
		case REJECT:
			setSelectedItems(Arrays.asList(item));
			onCompleteUpdate = "PF('wRejectConfirmDialog').show();";
			break;
		default:
			CandidateLocalServiceUtil.changeCandidateStatus(item.getId(),
					selectedStatus, serviceContext);
			onCompleteUpdate = "updateCandidatesAndGrowl();";
			break;
		}
		selectedStatus = StringUtils.EMPTY;
		// RequestContext.getCurrentInstance().update("refreshStatusGroup();");
	}

	public void onEvaluateCandidates(List<CandidateIndexItem> candidates) {
		EvaluationBean evaluationBean = (EvaluationBean) BeanUtils
				.getBackingBeanByName("evaluationBean");
		evaluationBean.setCandidateIndexItems(candidates);
		evaluationBean.setEvaluationItems(initEvaluationItems());
		this.includedDialog = "/views/dialogs/evaluation.xhtml";
		RequestContext.getCurrentInstance().update(
				":CandidatePanelGroup:includedDialog");
		RequestContext.getCurrentInstance().execute(
				"PF('wEvaluationDialog').show();");
	}

	public void onValueChangeListener(ValueChangeEvent event) {
		System.out.println(lazyDataModel.getRowData().getId());
		if (event.getNewValue() != null) {
			String statusString = (String) event.getNewValue();
			CandidateStatus status = CandidateStatus.valueOf(statusString);
			selectedStatus = statusString;
			switch (status) {
			case REJECT:
				setSelectedItems(Arrays.asList(lazyDataModel.getRowData()));
				RequestContext.getCurrentInstance().execute(
						"PF('wRejectConfirmDialog').show();");
				this.onCompleteUpdate = "updateCandidatePanelGroupAndCallRejectDialog()";
				break;
			case MARK_INTERVIEW_PASS:
			case MARK_INTERVIEW_FAIL:
				InterviewSchedule interviewSchedule = InterviewScheduleLocalServiceUtil
						.findByVacancyCandidateAndStatus(lazyDataModel
								.getRowData().getVacancyCandidateId(),
								InterviewScheduleStatus.PROCESSING.toString());
				InterviewScheduleLocalServiceUtil
						.setInterviewStatusByCandidateStatus(status.toString(),
								lazyDataModel.getRowData().getId(),
								interviewSchedule, RCUtils.getServiceContext());
				onCompleteUpdate = "updateCandidatesAndGrowl();";
				break;
			default:
				break;
			}
		}
	}

	/**
	 * 
	 */
	public void onSave() {
		try {
			ServiceContext serviceContext = LiferayFacesContext.getInstance()
					.getServiceContext();
			Candidate candidate = CandidateLocalServiceUtil
					.fetchCandidate(candidateItem.getObject().getCandidateId());
			final Map<Experience, Boolean> experienceMap = new LinkedHashMap<Experience, Boolean>();
			for (ExperienceObjectItem experienceObjectItem : candidateItem
					.getExperiences()) {
				experienceMap.put(experienceObjectItem.getExperience(),
						experienceObjectItem.isUIDeleted());
			}

			final Map<Certificate, Boolean> certificateMap = new LinkedHashMap<Certificate, Boolean>();
			for (CertificateObjectItem item : candidateItem.getCertificates()) {
				// set University Id -> certificate
				item.getObject().setUniversityId(item.getUniversityId());
				certificateMap.put(item.getObject(), item.isUIDeleted());
			}

			if (candidate == null) { // create new
				candidate = candidateItem.getObject();
				candidate
						.setNationalityId(EmployeeUtils
								.getBaseModelPrimaryKey(candidateItem
										.getNationality()));
				CandidateLocalServiceUtil.addCandidate(candidate, candidateItem
						.getVacancyIndexItem().getId(), candidateItem
						.getPossibleDesiredVacancies(), fileEntryIds,
						experienceMap, certificateMap, serviceContext);
			} else { // update
				candidateItem.getObject().setNationalityId(
						EmployeeUtils.getBaseModelPrimaryKey(candidateItem
								.getNationality()));
				CandidateLocalServiceUtil.updateCandidate(candidateItem
						.getObject(), candidateItem.getVacancyIndexItem()
						.getId(), candidateItem.getPossibleDesiredVacancies(),
						fileEntryIds, experienceMap, certificateMap,
						serviceContext);
			}
			BeanUtils.getCandidateViewBean().switchMode(
					CandidateNavigation.VIEW);

		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}

	public void onChangeMultipleItemStatus(String status) {
		final CandidateStatus candidateStatus = CandidateStatus.valueOf(status);
		final ServiceContext serviceContext = LiferayFacesContext.getInstance()
				.getServiceContext();
		final FacesMessage msg;
		final CandidateViewBean candidateViewBean = BeanUtils
				.getCandidateViewBean();
		switch (candidateStatus) {
		case SHORTLIST:
			for (CandidateIndexItem candidateIndexItem : selectedItems) {
				CandidateLocalServiceUtil.changeCandidateStatus(
						candidateIndexItem.getId(),
						CandidateStatus.SHORTLIST.toString(), serviceContext);
			}
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Add to SHORTLIST Information", selectedItems.size()
							+ (selectedItems.size() > 1 ? " were" : " was")
							+ " added to SHORTLIST");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			break;
		case INTERVIEW_SCHEDULED:

			ScheduleInterviewForCandidatesBean bean = (ScheduleInterviewForCandidatesBean) BeanUtils
					.getBackingBeanByName("scheduleInterviewForCandidatesBean");
			final List<InterviewScheduleItem> interviewScheduleItems = new ArrayList<>();
			for (CandidateIndexItem candidateIndexItem : selectedItems) {
				interviewScheduleItems.add(new InterviewScheduleItem(
						candidateIndexItem));
			}
			bean.setInterviewScheduleItems(interviewScheduleItems);
			bean.setInterviewScheduleForAllItem(new InterviewScheduleForAllItem());
			candidateViewBean
					.switchMode(CandidateNavigation.SCHEDULE_INTERVIEW);
			break;
		case EVALUATE_CANDIDATE:
			EvaluationBean evaluationBean = (EvaluationBean) BeanUtils
					.getBackingBeanByName("evaluationBean");
			evaluationBean.setCandidateIndexItems(selectedItems);
			evaluationBean.setEvaluationItems(initEvaluationItems());
			candidateViewBean
					.setIncludedDialog("/views/dialogs/evaluation.xhtml");
			break;
		case MARK_INTERVIEW_PASS:
		case MARK_INTERVIEW_FAIL:
			for (CandidateIndexItem item : selectedItems) {
				InterviewSchedule is = InterviewScheduleLocalServiceUtil
						.findByVacancyCandidateAndStatus(
								item.getVacancyCandidateId(),
								InterviewScheduleStatus.PROCESSING.toString());
				is.setStatus(candidateStatus.toString());
				try {
					InterviewScheduleLocalServiceUtil
							.updateInterviewSchedule(is);
					CandidateLocalServiceUtil.changeCandidateStatus(
							item.getId(), status, serviceContext);
				} catch (SystemException e) {
					LOGGER.info(e);
				}
			}

			break;
		case JOB_OFFERED:

			// call Offered

			break;
		case DECLINE_OFFERED:

			break;
		case HIRE:
			EmployeeBean employeeBean = (EmployeeBean) BeanUtils
					.getBackingBeanByName("employeeBean");

			if (employeeBean.transferCandidateInfo(selectedItems.get(0)) != null) {
				candidateViewBean.switchMode(4);
			}
			break;
		case REJECT:
			RequestContext.getCurrentInstance().execute(
					"PF('wRejectConfirmDialog').show()");
			break;
		default:
			break;
		}
		// for (CandidateIndexItem item : selectedItems) {
		// final Candidate candidate = CandidateLocalServiceUtil
		// .fetchCandidate(item.getId());
		// candidate.setStatus(status);
		// CandidateLocalServiceUtil.updateCandidate(candidate);
		// }
	}

	public List<VacancyIndexItem> completeVacancies(String query) {
		final List<VacancyIndexItem> filteredItems = new ArrayList<>();
		final SearchContext searchContext = RCUtils.getCurrentSearchContext();
		try {
			final BooleanQuery nameFilterBooleanQuery = BooleanQueryFactoryUtil
					.create(searchContext);
			nameFilterBooleanQuery.addTerm(VacancyField.TITLES, query, true,
					BooleanClauseOccur.MUST);
			final List<Query> queries = new ArrayList<>();

			queries.add(nameFilterBooleanQuery);
			final Sort sort = new Sort();
			sort.setFieldName(VacancyField.VACANCY_ID);
			final List<Document> docs = VacancyLocalServiceUtil
					.searchAllUnDeletedAndPublishedVacanciesIndexedDocument(
							searchContext, queries,
							searchContext.getCompanyId(), sort,
							QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (Document doc : docs) {
				VacancyIndexItem vacancyIndexItem = new VacancyIndexItem(doc);
				filteredItems.add(vacancyIndexItem);
			}
			return filteredItems;
		} catch (ParseException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public void addCandidate() {
		this.candidateItem = new CandidateItem();
		BeanUtils.getCandidateViewBean().switchMode(CandidateNavigation.CREATE);
	}

	public void editCandidate(CandidateIndexItem candidateIndexItem) {
		try {
			this.candidateItem = new CandidateItem(candidateIndexItem.getId());
			BeanUtils.getCandidateViewBean().switchMode(
					CandidateNavigation.EDIT);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}

	public void editCandidate(long candidateId) {
		try {
			this.candidateItem = new CandidateItem(candidateId);
			BeanUtils.getCandidateViewBean().switchMode(
					CandidateNavigation.EDIT);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}

	public void onRowDblSelect(SelectEvent selectEvent) {
		CandidateIndexItem candidateIndexItem = (CandidateIndexItem) selectEvent
				.getObject();
		// candidateIndexItem.getEvaluationItems();
		try {
			this.candidateItem = new CandidateItem(candidateIndexItem.getId());
			BeanUtils.getCandidateViewBean().switchMode(
					CandidateNavigation.EDIT);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}

	public void markDeleteCandidate() {
		CandidateLocalServiceUtil.markDeleted(deletedCandidateId,
				LiferayFacesContext.getInstance().getServiceContext());
	}

	public void handleDocumentUpload(FileUploadEvent event) {
		try {
			PortletRequest request = (PortletRequest) FacesContext
					.getCurrentInstance().getExternalContext().getRequest();
			final vn.com.ecopharma.emp.model.Document uploadDocument = DocumentLocalServiceUtil
					.uploadAndLinkEntity(candidateItem.getObject(), request,
							event.getFile().getInputstream(), event.getFile()
									.getFileName(), "CandidateDocuments",
							DocumentType.CANDIDATE_CV.toString(), true,
							LiferayFacesContext.getInstance()
									.getServiceContext());
			if (uploadDocument != null)
				candidateItem.getDocuments().add(
						new DocumentItem(uploadDocument));
		} catch (IOException e) {
			LOGGER.info(e);
		}
	}

	public void onContextShow(SelectEvent event) {
		if (selectedItems == null || selectedItems.size() == 0) {
			CandidateIndexItem candidateIndexItem = (CandidateIndexItem) event
					.getObject();
			selectedItems.add(candidateIndexItem);
		}
	}

	public void onCancel() {
		// for (DocumentItem documentItem : candidateItem.getDocuments()) {
		// if (documentItem.getDocumentId() == 0) {
		// try {
		// DLFileEntryLocalServiceUtil.deleteDLFileEntry(documentItem
		// .getFileEntryId());
		// LOGGER.info("### sucessfully deleted FILE ENTRY "
		// + documentItem.getFileEntryId());
		// } catch (PortalException e) {
		// LOGGER.info(e);
		// } catch (SystemException e) {
		// LOGGER.info(e);
		// }
		// }
		// }
		CandidateViewBean candidateViewBean = BeanUtils.getCandidateViewBean();
		candidateViewBean.switchMode(CandidateNavigation.VIEW);
	}

	// private void onEditCandidate(CandidateIndexItem candidateIndexItem) {
	// try {
	// Candidate candidate = CandidateLocalServiceUtil
	// .getCandidate(candidateIndexItem.getId());
	// this.candidateItem = new CandidateItem(candidate);
	// BeanUtils.getCandidateViewBean().setCurrentMode(3);
	// } catch (PortalException e) {
	// LOGGER.info(e);
	// } catch (SystemException e) {
	// LOGGER.info(e);
	// }
	// }

	public void onPreviewFile(long fileEntryId) {
		PreviewBean previewBean = (PreviewBean) BeanUtils
				.getBackingBeanByName("previewBean");
		previewBean.getFilePreviewInfo(fileEntryId);

		if (previewBean.getPreviewFileCount() > 0) {

			RequestContext.getCurrentInstance().update(
					":previewForm:previewOutputPanel");
			RequestContext.getCurrentInstance().update(
					":previewForm:previewFileContainer");

			RequestContext.getCurrentInstance().execute(
					"PF('wPreviewDialog').show()");
		} else {
			RequestContext.getCurrentInstance().update(
					":previewForm:noPreviewOutputPanel");
			RequestContext.getCurrentInstance().execute(
					"PF('wNoPreviewDialog').show()");
		}
	}

	public List<EvaluationItem> initEvaluationItems() {
		final List<String> types = new ArrayList<>(new HashSet<>(
				EvaluationCriteriaType.getAll()));
		final List<EvaluationItem> results = new ArrayList<>();

		for (String type : types) {
			results.add(new EvaluationItem(type));
		}
		return results;
	}

	public void onRejectConfirm(ActionEvent event) {
		for (CandidateIndexItem item : selectedItems) {
			if (item.getStatus().equalsIgnoreCase(
					CandidateStatus.INTERVIEW_SCHEDULED.toString())) {
				final InterviewSchedule interviewSchedule = InterviewScheduleLocalServiceUtil
						.findByVacancyCandidateAndStatus(
								item.getVacancyCandidateId(),
								InterviewScheduleStatus.PROCESSING.toString());
				interviewSchedule.setStatus(InterviewScheduleStatus.FAILED
						.toString());
			}
			try {
				Candidate candidate = CandidateLocalServiceUtil
						.getCandidate(item.getId());
				candidate.setDescription(rejectReason);
				CandidateLocalServiceUtil.changeCandidateStatus(item.getId(),
						CandidateStatus.REJECT.toString(), LiferayFacesContext
								.getInstance().getServiceContext());

			} catch (PortalException e) {
				LOGGER.info(e);
			} catch (SystemException e) {
				LOGGER.info(e);
			}
		}
	}

	public boolean isExistedInSameAvailableStatuses(String status) {
		if (status == null || StringUtils.trimToNull(status) == null)
			return false;
		List<CandidateStatus> statuses = getCandidateStatusListFromSelectedItems();
		boolean checked = selectedItems.size() > 0
				&& statuses.size() > 0
				&& CandidateStatus.getSameAvailableStatusesForStatuses(
						statuses, null, statuses.size() - 1).contains(
						CandidateStatus.valueOf(status));
		return checked;
	}

	public boolean isNoneAvailableStatus() {
		return getCandidateStatusListFromSelectedItems().contains(
				CandidateStatus.REJECT)
				|| getCandidateStatusListFromSelectedItems().contains(
						CandidateStatus.HIRE);
	}

	private List<CandidateStatus> getCandidateStatusListFromSelectedItems() {
		final List<CandidateStatus> candidateStatuses = new ArrayList<>();
		for (CandidateIndexItem candidateIndexItem : selectedItems) {
			candidateStatuses.add(CandidateStatus.valueOf(candidateIndexItem
					.getStatus()));
		}
		return candidateStatuses;
	}

	public void onMouseOver(ActionEvent event) {
		LOGGER.info("############ On Mouse Over ################");
	}

	public void onSelectAllHotKeyInvoke(ActionEvent event) {
	}

	public void onRowToggle(ToggleEvent event) {
		CandidateIndexItem candidateIndexItem = (CandidateIndexItem) event
				.getData();
		candidateIndexItem.setExperiences(ExperienceLocalServiceUtil
				.findByClassNameAndClassPK(Candidate.class.getName(),
						candidateIndexItem.getId()));

		candidateIndexItem.setCertificates(CertificateLocalServiceUtil
				.findByClassNameAndClassPK(Candidate.class.getName(),
						candidateIndexItem.getId()));
	}

	public void onShow() {
	}

	public void removeOneExperience(int index) {
		candidateItem.getExperiences().get(index).setUIDeleted(true);
	}

	public void addOneExperience(ActionEvent event) {
		candidateItem.getExperiences().add(new ExperienceObjectItem());
	}

	public void removeOneCertificate(int index) {
		candidateItem.getCertificates().get(index).setUIDeleted(true);
	}

	public void addOneCertificate(ActionEvent event) {
		candidateItem.getCertificates().add(new CertificateObjectItem() {

			private static final long serialVersionUID = 1L;

			@Override
			public String getClassName() {
				return Candidate.class.getName();
			}
		});
	}

	public void indexAll() {
		CandidateLocalServiceUtil.indexAllCandidates();
	}

	public void removeIndexes() {

		final SearchContext searchContext = RCUtils.getCurrentSearchContext();

		CandidateLocalServiceUtil.removeAllCandidateIndexes(searchContext,
				searchContext.getCompanyId());

	}

	public void deleteDocument() {
		if (deletedDocumentIndex != -1) {
			DocumentItem item = candidateItem.getDocuments().get(
					deletedDocumentIndex);
			DocumentLocalServiceUtil.completelyDeleteDocuments(item
					.getFileEntry().getFileEntryId());
			candidateItem.getDocuments().remove(deletedDocumentIndex);
		}
	}

	public LazyDataModel<CandidateIndexItem> getLazyDataModel() {
		return lazyDataModel;
	}

	public CandidateIndexItem getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(CandidateIndexItem selectedItem) {
		this.selectedItem = selectedItem;
	}

	public CandidateItem getCandidateItem() {
		return candidateItem;
	}

	public void setCandidateItem(CandidateItem candidateItem) {
		this.candidateItem = candidateItem;
	}

	// public List<Vacancy> getVacancies() {
	// return vacancies;
	// }

	public long getDeletedCandidateId() {
		return deletedCandidateId;
	}

	public void setDeletedCandidateId(long deletedCandidateId) {
		this.deletedCandidateId = deletedCandidateId;
	}

	public List<VacancyIndexItem> getVacancyIndexItems() {
		return vacancyIndexItems;
	}

	public void setVacancyIndexItems(List<VacancyIndexItem> vacancyIndexItems) {
		this.vacancyIndexItems = vacancyIndexItems;
	}

	public List<CandidateIndexItem> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<CandidateIndexItem> selectedItems) {
		this.selectedItems = selectedItems;
	}

	public List<String> getCertificateTypes() {
		return CandidateCertificateType.getAll();
	}

	public String getTypeLocalizedString(String type) {
		return CandidateCertificateType.valueOf(type).getLocalizedString();
	}

	public List<University> getUniversities() {
		return UniversityLocalServiceUtil.findAll();
	}

	public String getUniversityName(long universityId) {
		try {
			return UniversityLocalServiceUtil.getUniversity(universityId)
					.getName();
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return StringUtils.EMPTY;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public String getSelectedDocumentType() {
		return selectedDocumentType;
	}

	public void setSelectedDocumentType(String selectedDocumentType) {
		this.selectedDocumentType = selectedDocumentType;
	}

	public int getDeletedDocumentIndex() {
		return deletedDocumentIndex;
	}

	public void setDeletedDocumentIndex(int deletedDocumentIndex) {
		this.deletedDocumentIndex = deletedDocumentIndex;
	}

	public List<String> getAllDocumentTypes() {
		return DocumentType.getAll();
	}

	public List<Country> getAllCountries() {
		try {
			return CountryServiceUtil.getCountries();
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public Date getMaxBirthdayDate() {
		Calendar now = Calendar.getInstance();
		// backward 18 years
		now.add(Calendar.YEAR, -18);
		return now.getTime();
	}

	public String getOnCompleteUpdate() {
		return onCompleteUpdate;
	}

	public void setOnCompleteUpdate(String onCompleteUpdate) {
		this.onCompleteUpdate = onCompleteUpdate;
	}

	public String getSelectedStatus() {
		return selectedStatus;
	}

	public void setSelectedStatus(String selectedStatus) {
		this.selectedStatus = selectedStatus;
	}

	public CandidateViewBean getCandidateViewBean() {
		return candidateViewBean;
	}

	public void setCandidateViewBean(CandidateViewBean candidateViewBean) {
		this.candidateViewBean = candidateViewBean;
	}

	public String getIncludedDialog() {
		return includedDialog;
	}

	public void setIncludedDialog(String includedDialog) {
		this.includedDialog = includedDialog;
	}

}
