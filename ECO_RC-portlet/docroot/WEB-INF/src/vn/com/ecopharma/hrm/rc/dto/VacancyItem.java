package vn.com.ecopharma.hrm.rc.dto;

import java.util.Date;

import vn.com.ecopharma.hrm.rc.enumeration.VacancyStatus;
import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.BeanUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.RegionServiceUtil;

public class VacancyItem extends AbstractDocumentableBaseModelItem<Vacancy> {

	private static final long serialVersionUID = 1L;

	private RegionItem workingPlace;

	public VacancyItem() {
		super();
		this.getObject().setPostedDate(new Date());
		this.getObject().setStatus(VacancyStatus.NEW.toString());
		BeanUtils.getOrganizationPanelBean().afterSetOrganizationToEntity();
	}

	public VacancyItem(Vacancy vacancy) throws PortalException, SystemException {
		super(vacancy);
		workingPlace = vacancy.getWorkPlaceId() != 0L ? new RegionItem(
				RegionServiceUtil.getRegion(vacancy.getWorkPlaceId())) : null;
		BeanUtils.getOrganizationPanelBean().setSelectedValuesFromVacancy(
				vacancy);
	}

	@Override
	public Vacancy createPrepersistedEntity() {
		return VacancyLocalServiceUtil.createPrePersistedVacancy();
	}

	public RegionItem getWorkingPlace() {
		return workingPlace;
	}

	public void setWorkingPlace(RegionItem workingPlace) {
		this.workingPlace = workingPlace;
	}

}
