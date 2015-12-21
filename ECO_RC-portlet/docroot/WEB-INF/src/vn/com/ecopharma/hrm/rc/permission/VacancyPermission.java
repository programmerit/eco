package vn.com.ecopharma.hrm.rc.permission;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;

import com.liferay.faces.util.portal.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;

@ManagedBean
public class VacancyPermission implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void check(PermissionChecker permissionChecker,
			long vacancyId, String actionId) throws PortalException {
		if (!contains(permissionChecker, vacancyId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long candidateId, String actionId) {
		try {
			final Vacancy vacancy = VacancyLocalServiceUtil
					.fetchVacancy(candidateId);
			return vacancy != null ? permissionChecker.hasPermission(
					vacancy.getGroupId(), Vacancy.class.getName(),
					vacancy.getVacancyId(), actionId) : false;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkPermission(long vacancyId, String actionKey) {
		return contains(getPermissionChecker(), vacancyId, actionKey);
	}

	public boolean checkPermission(String vacancyId, String actionKey) {
		if (vacancyId != null && !vacancyId.equals(StringUtils.EMPTY)) {
			return contains(getPermissionChecker(), Long.valueOf(vacancyId),
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
