package vn.com.ecopharma.rc.client.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import vn.com.ecopharma.rc.client.dto.AbstractIndexedItem;
import vn.com.ecopharma.rc.client.dto.IndexedEntity;
import vn.com.ecopharma.rc.client.dto.VacancyIndexItem;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class RCClientUtils {
	private static final Log LOGGER = LogFactoryUtil
			.getLog(RCClientUtils.class);

	private static final String DEFAULT_COUNTRY_NAME = "vietnam";

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

	public static List<VacancyIndexItem> getVacancyIndexItems(
			List<Document> documents) {
		List<VacancyIndexItem> result = new ArrayList<VacancyIndexItem>();
		for (Document document : documents) {
			result.add(new VacancyIndexItem(document));
		}
		return result;
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

}
