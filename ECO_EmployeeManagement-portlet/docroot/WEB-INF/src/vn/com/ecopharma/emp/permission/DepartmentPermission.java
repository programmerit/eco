package vn.com.ecopharma.emp.permission;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;

import com.liferay.faces.util.portal.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;

@ManagedBean
public class DepartmentPermission implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void check(PermissionChecker permissionChecker, long id,
			String actionId) throws PortalException {
		if (!contains(permissionChecker, id, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long id, String actionId) {
		try {
			final Department dept = DepartmentLocalServiceUtil
					.fetchDepartment(id);
			return dept != null ? permissionChecker.hasPermission(
					dept.getGroupId(), Department.class.getName(),
					dept.getDepartmentId(), actionId) : false;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkPermission(long id, String actionKey) {
		return contains(getPermissionChecker(), id, actionKey);
	}

	public boolean checkPermission(String id, String actionKey) {
		if (id != null && !id.equals(StringUtils.EMPTY)) {
			return contains(getPermissionChecker(), Long.valueOf(id), actionKey);
		}
		return false;
	}

	private PermissionChecker getPermissionChecker() {
		final PortletRequest request = ((PortletRequest) (FacesContext
				.getCurrentInstance().getExternalContext().getRequest()));

		final ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		final PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();
		return permissionChecker;
	}

}
