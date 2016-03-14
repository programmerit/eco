package vn.com.ecopharma.hrm.rc.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import vn.com.ecopharma.hrm.rc.dto.AbstractIndexedItem;
import vn.com.ecopharma.hrm.rc.dto.CandidateIndexItem;
import vn.com.ecopharma.hrm.rc.dto.IndexedEntity;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateStatus;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

public class RCUtils {

	private static final Log LOGGER = LogFactoryUtil.getLog(RCUtils.class);

	private static final String DEFAULT_COUNTRY_NAME = "vietnam";

	private RCUtils() {

	}

	@SuppressWarnings("unchecked")
	public static void onStatusProcessing(CandidateStatus status, Object entity) {
		boolean isMultipleCandidates = entity instanceof List<?>;
		StringBuilder messageBuilder = new StringBuilder();
		messageBuilder.append("State of ");
		if (isMultipleCandidates) {
			int size = ((List<CandidateIndexItem>) entity).size();
			messageBuilder.append(size
					+ (size > 1 ? " Candidates were " : " Candidate was ")
					+ " changed to ");
		} else {
			CandidateIndexItem candidate = (CandidateIndexItem) entity;
			messageBuilder.append(" Candidate [" + candidate.getFullName()
					+ "] was changed to");
		}
		switch (status) {
		case SHORTLIST:
			messageBuilder.append(CandidateStatus.SHORTLIST.toString());
			break;
		default:
			break;
		}
	}

	/**
	 * @return
	 */
	public static SearchContext getCurrentSearchContext() {
		final LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();

		final PortletRequest req = (PortletRequest) liferayFacesContext
				.getExternalContext().getRequest();

		final HttpServletRequest httpServletRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(req));
		final SearchContext searchContext = SearchContextFactory
				.getInstance(httpServletRequest);
		return searchContext;
	}

	/**
	 * @param list
	 * @return
	 */
	public static List<Long> getIdsFromBasedModelList(
			List<? extends BaseModel<?>> list) {
		final List<Long> ids = new ArrayList<Long>();
		for (BaseModel<?> obj : list) {
			// ids.add((long) obj.getPrimaryKeyObj());
			ids.add(new Long(obj.getPrimaryKeyObj().toString()));
		}
		return ids;
	}

	/**
	 * @param list
	 * @return
	 */
	public static List<Long> getIdsFromIndexedItemList(
			List<? extends AbstractIndexedItem> list) {
		final List<Long> ids = new ArrayList<Long>();
		for (IndexedEntity i : list) {
			ids.add(i.getId());
		}
		return ids;
	}

	public static Country getDefaultCountry() {
		try {
			return CountryServiceUtil.getCountryByName(DEFAULT_COUNTRY_NAME);
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public static Country getCountryById(long id) {
		if (id == 0)
			return null;
		try {
			return CountryServiceUtil.fetchCountry(id);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public static ServiceContext getServiceContext() {
		return LiferayFacesContext.getInstance().getServiceContext();
	}
}
