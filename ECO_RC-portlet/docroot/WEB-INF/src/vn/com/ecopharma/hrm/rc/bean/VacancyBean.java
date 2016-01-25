package vn.com.ecopharma.hrm.rc.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.hrm.rc.constant.VacancyField;
import vn.com.ecopharma.hrm.rc.constant.VacancyNavigation;
import vn.com.ecopharma.hrm.rc.dm.VacancyLazyDM;
import vn.com.ecopharma.hrm.rc.dto.DocumentItem;
import vn.com.ecopharma.hrm.rc.dto.VacancyIndexItem;
import vn.com.ecopharma.hrm.rc.dto.VacancyItem;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateCertificateType;
import vn.com.ecopharma.hrm.rc.enumeration.VacancyStatus;
import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.DocumentLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.BeanUtils;
import vn.com.ecopharma.hrm.rc.util.DLUtils;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

@ManagedBean
@ViewScoped
public class VacancyBean extends PersistableBean {

	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactoryUtil.getLog(VacancyBean.class);

	private VacancyIndexItem selectedItem;

	private VacancyItem vacancyItem;

	private LazyDataModel<VacancyIndexItem> lazyDataModel;

	private long deletedVacancyId;

	private List<Long> fileEntryIds;

	private DocumentItem deletedDocument;

	@PostConstruct
	public void init() {
		lazyDataModel = new VacancyLazyDM() {

			private static final long serialVersionUID = 1L;

			@Override
			public List<VacancyIndexItem> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				VacancyFilterBean filterBean = BeanUtils.getVacancyFilterBean();
				if (!filterBean.getGlobal().equals(StringUtils.EMPTY)) {
					filters.put(VacancyField.GLOBAL, filterBean.getGlobal());
				}

				if (!filterBean.getName().equals(StringUtils.EMPTY)) {
					filters.put(VacancyField.NAME, filterBean.getName());
				}

				if (!filterBean.getTitles().equals(StringUtils.EMPTY)) {
					filters.put(VacancyField.TITLES, filterBean.getTitles());
				}

				// if (filterBean.getNumberOfPositionFrom() != -1) {
				filters.put(VacancyField.NUMBER_POSITION_FROM,
						filterBean.getNumberOfPositionFrom());
				// }

				// if (filterBean.getNumberOfPositionTo() != -1) {
				filters.put(VacancyField.NUMBER_POSITION_TO,
						filterBean.getNumberOfPositionTo());
				// }

				return super.load(first, pageSize, sortField, sortOrder,
						filters);
			}
		};
		fileEntryIds = new ArrayList<Long>();
	}

	@Override
	public void onSave() {
		try {
			ServiceContext serviceContext = LiferayFacesContext.getInstance()
					.getServiceContext();
			Vacancy vacancy = VacancyLocalServiceUtil.fetchVacancy(vacancyItem
					.getVacancy().getVacancyId());
			if (vacancy == null) { // create new
				vacancy = vacancyItem.getVacancy();
				vacancy.setTitlesId(vacancyItem.getTitles() != null ? vacancyItem
						.getTitles().getTitlesId() : 0);

				VacancyLocalServiceUtil.addVacancy(vacancy, 0, fileEntryIds,
						serviceContext);
			} else {
				VacancyLocalServiceUtil.updateVacancy(vacancyItem.getVacancy(),
						fileEntryIds, serviceContext);
			}
			BeanUtils.getVacancyViewBean().switchMode(VacancyNavigation.VIEW);
			;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}

	public void handleFileUpload(FileUploadEvent fileUploadEvent) {
		FileEntry fe = DLUtils.handleFileUpload(fileUploadEvent.getFile(),
				"vacancyDocs");
		try {
			long vacancyId = vacancyItem.getVacancy().getVacancyId();
			if (CandidateLocalServiceUtil.fetchCandidate(vacancyId) != null
					&& DocumentLocalServiceUtil
							.findByClassAndClassPKAndFileEntryId(
									Vacancy.class.getName(), vacancyId,
									fe.getFileEntryId()) == null) {
				DocumentLocalServiceUtil.addDocument(Vacancy.class.getName(),
						vacancyId, fe.getFileEntryId(), LiferayFacesContext
								.getInstance().getServiceContext());
			}
			fileEntryIds.add(fe.getFileEntryId());
			vacancyItem.getDocumentItems().add(new DocumentItem(fe));

		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}

	public void addVacancy() {
		this.vacancyItem = new VacancyItem();
	}

	public void editVacancy(VacancyIndexItem vacancyIndexItem) {
		try {
			this.vacancyItem = new VacancyItem(
					VacancyLocalServiceUtil.fetchVacancy(vacancyIndexItem
							.getId()));
			BeanUtils.getVacancyViewBean().switchMode(VacancyNavigation.EDIT);
			;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}

	public void onCancel(ActionEvent event) {
		for (DocumentItem documentItem : vacancyItem.getDocumentItems()) {
			if (documentItem.getDocumentId() == 0) {
				try {
					DLFileEntryLocalServiceUtil.deleteDLFileEntry(documentItem
							.getFileEntryId());
					LOGGER.info("### sucessfully deleted FILE ENTRY "
							+ documentItem.getFileEntryId());
				} catch (PortalException e) {
					LOGGER.info(e);
				} catch (SystemException e) {
					LOGGER.info(e);
				}
			}
		}
		VacancyViewBean vacancyViewBean = BeanUtils.getVacancyViewBean();
		vacancyViewBean.switchMode(VacancyNavigation.VIEW);
		;
	}

	public void onPreviewFile(long fileEntryId) {
		PreviewBean previewBean = (PreviewBean) BeanUtils
				.getBackingBeanByName("previewBean");
		previewBean.getFilePreviewInfo(fileEntryId);
		RequestContext.getCurrentInstance().update(
				":previewForm:previewOutputPanel");
		RequestContext.getCurrentInstance().update(
				":previewForm:previewFileContainer");
	}

	public void markDeleteVacancy() {
		VacancyLocalServiceUtil.markDeleted(deletedVacancyId);
	}

	public void onRowDblSelect(SelectEvent selectEvent) {
		try {
			final VacancyIndexItem vacancyIndexItem = (VacancyIndexItem) selectEvent
					.getObject();

			this.vacancyItem = new VacancyItem(
					VacancyLocalServiceUtil.fetchVacancy(vacancyIndexItem
							.getId()));
			BeanUtils.getVacancyViewBean().switchMode(VacancyNavigation.EDIT);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}

	public String getCurrentTitlesName() {
		final Titles currentTitles = vacancyItem.getTitles();
		return currentTitles != null ? currentTitles.getName() : "(Empty)";
	}

	public void deleteFileEntry(ActionEvent event) {
		vacancyItem.getDocumentItems().remove(deletedDocument);
		DocumentLocalServiceUtil.deleteByFileEntry(deletedDocument
				.getFileEntryId());
	}

	public LazyDataModel<VacancyIndexItem> getLazyDataModel() {
		return lazyDataModel;
	}

	public List<Vacancy> getVacancies() {
		return VacancyLocalServiceUtil.findAll();
	}

	public VacancyIndexItem getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(VacancyIndexItem selectedItem) {
		this.selectedItem = selectedItem;
	}

	public VacancyItem getVacancyItem() {
		return vacancyItem;
	}

	public void setVacancyItem(VacancyItem vacancyItem) {
		this.vacancyItem = vacancyItem;
	}

	public long getDeletedVacancyId() {
		return deletedVacancyId;
	}

	public void setDeletedVacancyId(long deletedVacancyId) {
		this.deletedVacancyId = deletedVacancyId;
	}

	public void indexAll() {
		VacancyLocalServiceUtil.indexAllVacancies();
	}

	public void removeIndexes() {

		final SearchContext searchContext = RCUtils.getCurrentSearchContext();

		VacancyLocalServiceUtil.removeAllVacanciesIndexes(searchContext,
				searchContext.getCompanyId());

	}

	public List<String> getVacancyStatuses() {
		final List<String> result = new ArrayList<String>();
		for (VacancyStatus vacancyStatus : VacancyStatus.values()) {
			result.add(vacancyStatus.toString());
		}
		return result;
	}

	public DocumentItem getDeletedDocument() {
		return deletedDocument;
	}

	public void setDeletedDocument(DocumentItem deletedDocument) {
		this.deletedDocument = deletedDocument;
	}

	public List<String> getCertificateTypes() {
		return CandidateCertificateType.getAll();
	}

	public String getTypeLocalizedString(String type) {
		return CandidateCertificateType.valueOf(type).getLocalizedString();
	}

}