package vn.com.ecopharma.emp.permission;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;

import vn.com.ecopharma.emp.constant.EMInfo;

import com.liferay.faces.util.portal.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;

@ManagedBean
@ViewScoped
public class EmployeeModelPermission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void check(PermissionChecker permissionChecker, long groupId,
			String actionId) throws PortalException {
		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, String actionId) {

		return permissionChecker.hasPermission(groupId, EMInfo.RESOURCE_MODEL,
				groupId, actionId);
	}

	public boolean checkPermission(String actionKey) {
		final PortletRequest request = ((PortletRequest) (FacesContext
				.getCurrentInstance().getExternalContext().getRequest()));

		final ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		final PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();
		return contains(permissionChecker, themeDisplay.getScopeGroupId(),
				actionKey);
	}
}
