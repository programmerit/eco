package vn.com.ecopharma.rc.client.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.portlet.PortletRequest;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.FileUploadEvent;

import vn.com.ecopharma.emp.model.University;
import vn.com.ecopharma.emp.service.DocumentLocalServiceUtil;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.rc.client.constant.VacancyField;
import vn.com.ecopharma.rc.client.dto.CandidateItem;
import vn.com.ecopharma.rc.client.dto.CertificateObjectItem;
import vn.com.ecopharma.rc.client.dto.DocumentItem;
import vn.com.ecopharma.rc.client.dto.ExperienceObjectItem;
import vn.com.ecopharma.rc.client.dto.VacancyIndexItem;
import vn.com.ecopharma.rc.client.enumeration.CandidateCertificateType;
import vn.com.ecopharma.rc.client.enumeration.DocumentType;
import vn.com.ecopharma.rc.client.util.RCClientUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
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

public class BaseCandidateBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CandidateItem candidateItem;

	private List<Long> fileEntryIds;

	private List<VacancyIndexItem> vacancyIndexItems;

	private String selectedDocumentType;

	private int deletedDocumentIndex = -1;

	public void init() {
		vacancyIndexItems = RCClientUtils
				.getVacancyIndexItems(VacancyLocalServiceUtil
						.searchAllUnDeletedVacanciesIndexedDocument(
								RCClientUtils.getCurrentSearchContext(),
								new ArrayList<Query>(), RCClientUtils
										.getCurrentSearchContext()
										.getCompanyId(), null,
								QueryUtil.ALL_POS, QueryUtil.ALL_POS));
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
			e.printStackTrace();
		}
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

	public List<VacancyIndexItem> completeVacancies(String query) {
		final List<VacancyIndexItem> filteredItems = new ArrayList<>();
		final SearchContext searchContext = RCClientUtils
				.getCurrentSearchContext();
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
			e.printStackTrace();
		}
		return null;
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

	public CandidateItem getCandidateItem() {
		return candidateItem;
	}

	public void setCandidateItem(CandidateItem candidateItem) {
		this.candidateItem = candidateItem;
	}

	public List<Long> getFileEntryIds() {
		return fileEntryIds;
	}

	public void setFileEntryIds(List<Long> fileEntryIds) {
		this.fileEntryIds = fileEntryIds;
	}

	public List<VacancyIndexItem> getVacancyIndexItems() {
		return vacancyIndexItems;
	}

	public void setVacancyIndexItems(List<VacancyIndexItem> vacancyIndexItems) {
		this.vacancyIndexItems = vacancyIndexItems;
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
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public Date getMaxBirthdayDate() {
		Calendar now = Calendar.getInstance();
		// backward 18 years
		now.add(Calendar.YEAR, -18);
		return now.getTime();
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

}
