package vn.com.ecopharma.hrm.rc.permission;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;

import com.liferay.faces.util.portal.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;

@ManagedBean
public class CandidatePermission implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void check(PermissionChecker permissionChecker,
			long candidateId, String actionId) throws PortalException {
		if (!contains(permissionChecker, candidateId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long candidateId, String actionId) {
		try {
			final Candidate candidate = CandidateLocalServiceUtil
					.fetchCandidate(candidateId);
			return candidate != null ? permissionChecker.hasPermission(
					candidate.getGroupId(), Candidate.class.getName(),
					candidate.getCandidateId(), actionId) : false;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkPermission(long candidateId, String actionKey) {
		return contains(getPermissionChecker(), candidateId, actionKey);
	}

	public boolean checkPermission(String candidateId, String actionKey) {
		if (candidateId != null && !candidateId.equals(StringUtils.EMPTY)) {
			return contains(getPermissionChecker(), Long.valueOf(candidateId),
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
