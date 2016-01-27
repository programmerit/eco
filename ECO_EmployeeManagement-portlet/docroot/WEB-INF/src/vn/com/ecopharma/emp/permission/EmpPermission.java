package vn.com.ecopharma.emp.permission;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;

import com.liferay.faces.util.portal.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;

@ManagedBean(name = "empPermission")
@ViewScoped
public class EmpPermission implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpPermission.class);

	public static void check(PermissionChecker permissionChecker, long empId,
			String actionId) throws PortalException {
		if (!contains(permissionChecker, empId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long empId, String actionId) {
		try {
			final Emp emp = EmpLocalServiceUtil.fetchEmp(empId);
			return emp != null ? permissionChecker.hasPermission(
					emp.getGroupId(), Emp.class.getName(), emp.getEmpId(),
					actionId) : false;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return false;
	}

	public boolean checkPermission(long empId, String actionKey) {
		return contains(getPermissionChecker(), empId, actionKey);
	}

	public boolean checkPermission(String empId, String actionKey) {
		if (empId != null && !empId.equals(StringUtils.EMPTY)) {
			return contains(getPermissionChecker(), Long.valueOf(empId),
					actionKey);
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
