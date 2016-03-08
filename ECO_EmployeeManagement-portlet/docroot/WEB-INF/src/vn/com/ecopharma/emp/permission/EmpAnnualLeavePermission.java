package vn.com.ecopharma.emp.permission;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.model.EmpAnnualLeave;
import vn.com.ecopharma.emp.service.EmpAnnualLeaveLocalServiceUtil;

import com.liferay.faces.util.portal.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;

@ManagedBean
@ViewScoped
public class EmpAnnualLeavePermission implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpAnnualLeavePermission.class);

	public static void check(PermissionChecker permissionChecker,
			long empAnnualLeaveId, String actionId) throws PortalException {
		if (!contains(permissionChecker, empAnnualLeaveId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long id, String actionId) {
		try {
			final EmpAnnualLeave o = EmpAnnualLeaveLocalServiceUtil
					.fetchEmpAnnualLeave(id);
			return o != null ? permissionChecker.hasPermission(o.getGroupId(),
					EmpAnnualLeave.class.getName(), o.getEmpAnnualLeaveId(),
					actionId) : false;
		} catch (SystemException e) {
			LOGGER.info(e);
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
