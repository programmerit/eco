package vn.com.ecopharma.hrm.rc.util;

import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import vn.com.ecopharma.hrm.rc.dto.AbstractIndexEntityItem;
import vn.com.ecopharma.hrm.rc.dto.IndexedEntity;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

public class RCUtils {

	/**
	 * @param name
	 * @return
	 */
	public static Object getBackingBeanByName(String name) {
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		return FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(elContext, null, name);
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
			List<? extends AbstractIndexEntityItem> list) {
		final List<Long> ids = new ArrayList<Long>();
		for (IndexedEntity<?> i : list) {
			ids.add(i.getId());
		}
		return ids;
	}

	public static ServiceContext getServiceContext() {
		return LiferayFacesContext.getInstance().getServiceContext();
	}
}
