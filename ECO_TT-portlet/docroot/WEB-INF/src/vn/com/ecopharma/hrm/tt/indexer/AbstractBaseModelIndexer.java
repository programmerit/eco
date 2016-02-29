package vn.com.ecopharma.hrm.tt.indexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.PortletURL;

import vn.com.ecopharma.hrm.tt.constant.ECO_TT_Info;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.BaseModel;

public abstract class AbstractBaseModelIndexer<T extends BaseModel<T>> extends
		BaseIndexer {

	@Override
	public abstract String[] getClassNames();

	@Override
	public String getPortletId() {
		return ECO_TT_Info.PORTLET_ID;
	}

	@Override
	protected abstract void doDelete(Object obj) throws Exception;

	@Override
	protected abstract Document doGetDocument(Object obj) throws Exception;

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception {
		Summary summary = createSummary(document);
		summary.setMaxContentLength(200);
		return summary;
	}

	@Override
	protected abstract void doReindex(Object obj) throws Exception;

	@Override
	protected abstract void doReindex(String className, long classPK)
			throws Exception;

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexBaseModel(companyId);
	}

	protected abstract BaseActionableDynamicQuery getActionableDynamicQuery(
			Collection<Document> documents) throws SystemException;

	protected void reindexBaseModel(long companyId) throws SystemException,
			PortalException {
		final Collection<Document> documents = new ArrayList<>();

		final ActionableDynamicQuery actionableDynamicQuery = getActionableDynamicQuery(documents);

		actionableDynamicQuery.setCompanyId(companyId);
		actionableDynamicQuery.performActions();
		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId,
				documents);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return ECO_TT_Info.PORTLET_ID;
	}
}
