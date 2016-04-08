package vn.com.ecopharma.rc.client.bean;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.model.Certificate;
import vn.com.ecopharma.hrm.rc.model.Experience;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.rc.client.dto.CandidateItem;
import vn.com.ecopharma.rc.client.dto.CertificateObjectItem;
import vn.com.ecopharma.rc.client.dto.ExperienceObjectItem;
import vn.com.ecopharma.rc.client.enumeration.navigation.GuestNavigation;
import vn.com.ecopharma.rc.client.util.BeanUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;

@ManagedBean
@ViewScoped
public class CandidateGuestBean extends BaseCandidateBean {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(CandidateGuestBean.class);

	@PostConstruct
	public void init() {
		super.init();
		setCandidateItem(new CandidateItem());
	}

	/**
	 * 
	 */
	public void onSave() {
		try {
			FacesMessage message = null;
			if (!CandidateLocalServiceUtil.isEmailExisted(getCandidateItem()
					.getObject().getEmailAddress())) {
				ServiceContext serviceContext = LiferayFacesContext
						.getInstance().getServiceContext();
				Candidate candidate = CandidateLocalServiceUtil
						.fetchCandidate(getCandidateItem().getObject()
								.getCandidateId());
				final Map<Experience, Boolean> experienceMap = new LinkedHashMap<>();
				for (ExperienceObjectItem experienceObjectItem : getCandidateItem()
						.getExperiences()) {
					experienceMap.put(experienceObjectItem.getExperience(),
							experienceObjectItem.isUIDeleted());
				}

				final Map<Certificate, Boolean> certificateMap = new LinkedHashMap<>();
				for (CertificateObjectItem item : getCandidateItem()
						.getCertificates()) {
					// set University Id -> certificate
					item.getObject().setUniversityId(item.getUniversityId());
					certificateMap.put(item.getObject(), item.isUIDeleted());
				}

				if (candidate == null) { // create new
					candidate = getCandidateItem().getObject();
					CandidateLocalServiceUtil.addCandidate(candidate,
							getCandidateItem().getVacancyIndexItem().getId(),
							getCandidateItem().getPossibleDesiredVacancies(),
							getFileEntryIds(), experienceMap, certificateMap,
							serviceContext);
				} else { // update

					CandidateLocalServiceUtil.updateCandidate(
							getCandidateItem().getObject(), getCandidateItem()
									.getVacancyIndexItem().getId(),
							getCandidateItem().getPossibleDesiredVacancies(),
							getFileEntryIds(), experienceMap, certificateMap,
							serviceContext);
				}

				BeanUtils.getGuestViewBean().switchOutcome(
						GuestNavigation.SUCCESS_ADD);

			} else {
				message = new FacesMessage("Email Existed",
						"This email has already existed");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}

		} catch (SystemException e) {
			LOGGER.info(e);
		}
	}
}
