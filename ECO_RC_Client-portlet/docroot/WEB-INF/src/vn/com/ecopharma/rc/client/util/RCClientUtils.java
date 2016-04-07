package vn.com.ecopharma.rc.client.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import vn.com.ecopharma.rc.client.dto.VacancyIndexItem;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.util.PortalUtil;

public class RCClientUtils {

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
}
