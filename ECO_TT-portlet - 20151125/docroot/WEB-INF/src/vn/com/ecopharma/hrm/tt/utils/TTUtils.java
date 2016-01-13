package vn.com.ecopharma.hrm.tt.utils;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import vn.com.ecopharma.hrm.tt.dto.TimeTrackingIndexItem;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

public class TTUtils {

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

	public static ServiceContext getServiceContext() {
		return LiferayFacesContext.getInstance().getServiceContext();
	}

	public static long getCompanyId() {
		return getServiceContext().getCompanyId();
	}

	public static List<TimeTrackingIndexItem> getTimeTrackingIndexItems(
			List<Document> documents) {
		final List<TimeTrackingIndexItem> result = new ArrayList<TimeTrackingIndexItem>(
				documents.size());
		for (Document document : documents) {
			result.add(new TimeTrackingIndexItem(document));
		}
		return result;
	}

}
