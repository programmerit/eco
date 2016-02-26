package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;

import vn.com.ecopharma.emp.model.University;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.constant.VacancyField;
import vn.com.ecopharma.hrm.rc.dto.CandidateItem;
import vn.com.ecopharma.hrm.rc.dto.CertificateObjectItem;
import vn.com.ecopharma.hrm.rc.dto.DocumentItem;
import vn.com.ecopharma.hrm.rc.dto.ExperienceObjectItem;
import vn.com.ecopharma.hrm.rc.dto.VacancyIndexItem;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateCertificateType;
import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.model.Certificate;
import vn.com.ecopharma.hrm.rc.model.Experience;
import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.DocumentLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.BeanUtils;
import vn.com.ecopharma.hrm.rc.util.DLUtils;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.service.ServiceContext;

@ManagedBean
@ViewScoped
public class CandidateGuestBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Vacancy> vacancies;

	private CandidateItem candidateItem;

	private List<Long> fileEntryIds;

	private DocumentItem deletedDocument;

	@PostConstruct
	public void init() {
		candidateItem = new CandidateItem();
		vacancies = VacancyLocalServiceUtil.findAllUnDeleted();
		fileEntryIds = new ArrayList<Long>();
	}

	/**
	 * 
	 */
	public String onSave() {
		try {
			FacesMessage message = null;
			if (!CandidateLocalServiceUtil.isEmailExisted(candidateItem
					.getObject().getEmailAddress())) {
				ServiceContext serviceContext = LiferayFacesContext
						.getInstance().getServiceContext();
				Candidate candidate = CandidateLocalServiceUtil
						.fetchCandidate(candidateItem.getObject()
								.getCandidateId());
				final Map<Experience, Boolean> experienceMap = new LinkedHashMap<Experience, Boolean>();
				for (ExperienceObjectItem experienceObjectItem : candidateItem
						.getExperiences()) {
					experienceMap.put(experienceObjectItem.getExperience(),
							experienceObjectItem.isUIDeleted());
				}

				final Map<Certificate, Boolean> certificateMap = new LinkedHashMap<Certificate, Boolean>();
				for (CertificateObjectItem item : candidateItem
						.getCertificates()) {
					// set University Id -> certificate
					item.getObject().setUniversityId(item.getUniversityId());
					certificateMap.put(item.getObject(), item.isUIDeleted());
				}

				if (candidate == null) { // create new
					candidate = candidateItem.getObject();
					CandidateLocalServiceUtil.addCandidate(candidate, 0,
							candidateItem.getVacancyItem().getObject()
									.getVacancyId(),
							candidateItem.getPossibleDesiredVacancies(),
							fileEntryIds, experienceMap, certificateMap,
							serviceContext);
				} else { // update

					CandidateLocalServiceUtil.updateCandidate(
							candidateItem.getObject(), candidateItem
									.getVacancyItem().getObject()
									.getVacancyId(),
							candidateItem.getPossibleDesiredVacancies(),
							fileEntryIds, experienceMap, certificateMap,
							serviceContext);
				}
			} else {
				message = new FacesMessage("Email Existed",
						"This email has already existed");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}

		} catch (SystemException e) {
			e.printStackTrace();
		}
		return "candidateGuestSavedSuccess";
	}

	public List<VacancyIndexItem> completeVacancies(String query) {
		final List<VacancyIndexItem> filteredItems = new ArrayList<VacancyIndexItem>();
		final SearchContext searchContext = RCUtils.getCurrentSearchContext();
		try {
			final BooleanQuery nameFilterBooleanQuery = BooleanQueryFactoryUtil
					.create(searchContext);
			nameFilterBooleanQuery.addTerm(VacancyField.NAME, query, true,
					BooleanClauseOccur.MUST);
			final List<Query> queries = new ArrayList<Query>();

			queries.add(nameFilterBooleanQuery);
			Sort sort = new Sort();
			sort.setFieldName(VacancyField.VACANCY_ID);
			final List<Document> docs = VacancyLocalServiceUtil
					.searchAllUnDeletedAndPublishedVacanciesIndexedDocument(
							searchContext, queries,
							searchContext.getCompanyId(), sort,
							QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (Document doc : docs) {
				VacancyIndexItem vacancyIndexItem = new VacancyIndexItem(doc);
				// if (!candidateItem.getDesiredVacancies().contains(
				// vacancyIndexItem)
				// && (vacancyIndexItem.getId() != candidateItem
				// .getVacancyIndexItem().getId()))
				filteredItems.add(vacancyIndexItem);
			}
			return filteredItems;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void handleFileUpload(FileUploadEvent fileUploadEvent) {
		final FileEntry fe = DLUtils.handleFileUpload(
				fileUploadEvent.getFile(), "candidateDocs");
		final long candidateId = candidateItem.getObject().getCandidateId();
		// try {
		// if (CandidateLocalServiceUtil.fetchCandidate(candidateId) != null
		// && DocumentLocalServiceUtil
		// .findByClassAndClassPKAndFileEntryId(
		// Candidate.class.getName(), candidateId,
		// fe.getFileEntryId()) == null) {
		// vn.com.ecopharma.hrm.rc.model.Document document =
		// DocumentLocalServiceUtil
		// .addDocument(Candidate.class.getName(), candidateId, fe
		// .getFileEntryId(), LiferayFacesContext
		// .getInstance().getServiceContext());
		// candidateItem.getDocumentItems()
		// .add(new DocumentItem(document));
		// } else {
		// candidateItem.getDocumentItems().add(new DocumentItem(fe));
		// }
		// fileEntryIds.add(fe.getFileEntryId());
		//
		// } catch (SystemException e) {
		// e.printStackTrace();
		// }
	}

	public void deleteFileEntry(ActionEvent event) {
		// candidateItem.getDocumentItems().remove(deletedDocument);
		// DocumentLocalServiceUtil.deleteByFileEntry(deletedDocument
		// .getFileEntryId());
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
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return StringUtils.EMPTY;
	}

	public CandidateItem getCandidateItem() {
		return candidateItem;
	}

	public void setCandidateItem(CandidateItem candidateItem) {
		this.candidateItem = candidateItem;
	}

	public List<Vacancy> getVacancies() {
		return vacancies;
	}

	public void setVacancies(List<Vacancy> vacancies) {
		this.vacancies = vacancies;
	}

	public List<Long> getFileEntryIds() {
		return fileEntryIds;
	}

	public void setFileEntryIds(List<Long> fileEntryIds) {
		this.fileEntryIds = fileEntryIds;
	}

	public DocumentItem getDeletedDocument() {
		return deletedDocument;
	}

	public void setDeletedDocument(DocumentItem deletedDocument) {
		this.deletedDocument = deletedDocument;
	}

}
