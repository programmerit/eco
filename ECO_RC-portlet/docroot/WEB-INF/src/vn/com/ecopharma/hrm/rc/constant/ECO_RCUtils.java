package vn.com.ecopharma.hrm.rc.constant;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import vn.com.ecopharma.hrm.rc.dto.CandidateIndexItem;
import vn.com.ecopharma.hrm.rc.dto.VacancyIndexItem;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.util.PortalUtil;

public class ECO_RCUtils {
	public static final String PORTLET_ID = "ECO_RC";
	public static final String RESOURCE_MODEL = "vn.com.ecopharma.hrm.rc.model";

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

	public static List<CandidateIndexItem> getCandidateIndexItems(
			List<Document> documents) {
		List<CandidateIndexItem> result = new ArrayList<CandidateIndexItem>();
		for (Document document : documents) {
			final CandidateIndexItem candidateIndexItem = new CandidateIndexItem(
					document);
			System.out
					.println("IS DELETED:  " + candidateIndexItem.isDeleted());
			result.add(candidateIndexItem);
		}
		return result;
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
