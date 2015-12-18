package vn.com.ecopharma.emp.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import com.liferay.faces.util.portal.WebKeys;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;

public class BaseEntityPermissionUtil<T extends BaseModel<T>> {

	private static final String EDITPERMISSIONSPORTLETID = "86";

	/**
	 * Get the permissionsURL for an BaseModel<T> entity.
	 * 
	 * @param <T>
	 *            Generic Type
	 * @param entity
	 *            BaseModel entity
	 * @return URL
	 */
	// public static <T> String getEntityPermissionsURL(final BaseModel<T>
	// entity) {
	//
	// final ThemeDisplay themeDisplay = PortletUtils.getThemeDisplay();
	// final Layout layout = themeDisplay.getLayout();
	//
	// final String entityClassName = entity.getClass().getInterfaces()[0]
	// .getName();
	// final String entityId = entity.getPrimaryKeyObj().toString();
	// String resourceDescription = null;
	//
	// try {
	// final Method method = entity.getClass().getMethod("getTitle",
	// new Class[] {});
	// if (method != null) {
	// resourceDescription = (String) method.invoke(entity,
	// new Object[] {});
	// }
	// } catch (Exception e) {
	// resourceDescription = entityId;
	// }
	//
	// final String baseURL = themeDisplay.getURLHome()
	// + layout.getFriendlyURL();
	//
	// String currentURL;
	// try {
	// final URL url = new URL(themeDisplay.getURLPortal()
	// + themeDisplay.getURLCurrent());
	// final Map<String, String> queryMap = StringUtils.getQueryMap(url
	// .getQuery());
	// final String key = PortletUtils.getPortletId()
	// + PortletUtils.TC_REDIRECT;
	// queryMap.put(key, PortletUtils.getViewId());
	// currentURL = URLEncoder.encode(
	// baseURL + "?" + StringUtils.createQuery(queryMap), "UTF-8");
	// } catch (UnsupportedEncodingException e) {
	// return null;
	// } catch (MalformedURLException e) {
	// return null;
	// }
	//
	// final StringBuilder permissionsPortletURL = new StringBuilder();
	// permissionsPortletURL.append(baseURL);
	// permissionsPortletURL.append("?");
	//
	// permissionsPortletURL.append("p_p_id=");
	// permissionsPortletURL.append(EDITPERMISSIONSPORTLETID);
	//
	// permissionsPortletURL.append("&p_p_lifecycle=0&p_p_state=maximized");
	//
	// permissionsPortletURL
	// .append("&p_p_col_id=column-2&p_p_col_pos=1&p_p_col_count=2");
	//
	// permissionsPortletURL.append("&_");
	// permissionsPortletURL.append(EDITPERMISSIONSPORTLETID);
	// permissionsPortletURL
	// .append("_struts_action=%2Fportlet_configuration%2Fedit_permissions");
	//
	// permissionsPortletURL.append("&_");
	// permissionsPortletURL.append(EDITPERMISSIONSPORTLETID);
	// permissionsPortletURL.append("_redirect=");
	// permissionsPortletURL.append(currentURL);
	//
	// permissionsPortletURL.append("&_");
	// permissionsPortletURL.append(EDITPERMISSIONSPORTLETID);
	// permissionsPortletURL.append("_returnToFullPageURL=");
	// permissionsPortletURL.append(currentURL);
	//
	// permissionsPortletURL.append("&_");
	// permissionsPortletURL.append(EDITPERMISSIONSPORTLETID);
	// permissionsPortletURL.append("_portletResource=");
	// permissionsPortletURL.append(PortletUtils.getLiferayPortletId());
	//
	// permissionsPortletURL.append("&_");
	// permissionsPortletURL.append(EDITPERMISSIONSPORTLETID);
	// permissionsPortletURL.append("_modelResource=");
	// permissionsPortletURL.append(entityClassName);
	//
	// permissionsPortletURL.append("&_");
	// permissionsPortletURL.append(EDITPERMISSIONSPORTLETID);
	// permissionsPortletURL.append("_modelResourceDescription=");
	// permissionsPortletURL.append(resourceDescription);
	//
	// permissionsPortletURL.append("&_");
	// permissionsPortletURL.append(EDITPERMISSIONSPORTLETID);
	// permissionsPortletURL.append("_resourcePrimKey=");
	// permissionsPortletURL.append(entityId);
	//
	// permissionsPortletURL.append("&_");
	// permissionsPortletURL.append(EDITPERMISSIONSPORTLETID);
	// permissionsPortletURL.append("_resourcePrimKey=");
	// permissionsPortletURL.append(entityId);
	//
	// return permissionsPortletURL.toString();
	// }
	//
	// public static String getURL() {
	// HttpServletRequest request = (HttpServletRequest) pageContext
	// .getRequest();
	// ThemeDisplay themeDisplay = (ThemeDisplay) request
	// .getAttribute(WebKeys.THEME_DISPLAY);
	// PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
	// Layout layout = themeDisplay.getLayout();
	// if (Validator.isNull(redirect)) {
	// redirect = PortalUtil.getCurrentURL(request);
	// }
	// PortletURL portletURL = new PortletURLImpl(request,
	// PortletKeys.PORTLET_CONFIGURATION, layout.getPlid(),
	// PortletRequest.RENDER_PHASE);
	// if (themeDisplay.isStatePopUp()) {
	// portletURL.setWindowState(LiferayWindowState.POP_UP);
	// } else {
	// portletURL.setWindowState(WindowState.MAXIMIZED);
	// }
	// portletURL.setParameter("struts_action",
	// "/portlet_configuration/edit_permissions");
	// portletURL.setParameter("redirect", redirect);
	// if (!themeDisplay.isStateMaximized()) {
	// portletURL.setParameter("returnToFullPageURL", redirect);
	// }
	// portletURL.setParameter("portletResource", portletDisplay.getId());
	// portletURL.setParameter("modelResource", modelResource);
	// portletURL.setParameter("modelResourceDescription",
	// modelResourceDescription);
	// portletURL.setParameter("resourcePrimKey", resourcePrimKey);
	// String portletURLToString = portletURL.toString();
	// if (Validator.isNotNull(var)) {
	// pageContext.setAttribute(var, portletURLToString);
	// } else if (writeOutput) {
	// pageContext.getOut().print(portletURLToString);
	// }
	// return portletURL.toString();
	// }

}
