package vn.com.ecopharma.hrm.rc.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

@FacesValidator(value = "userNameValidator")
public class UsernameValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		final LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();
		final ServiceContext serviceContext = liferayFacesContext
				.getServiceContext();
		final String userName = (String) value;

		FacesMessage message = null;
		try {
			if (UserLocalServiceUtil.fetchUserByScreenName(
					serviceContext.getCompanyId(), userName) != null) {
				message = new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Username Error", "This username has already existed");
				/*
				 * message = new FacesMessage(FacesMessage.SEVERITY_WARN,
				 * "Lỗi Username", "Username này đã tồn tại");
				 */
				throw new ValidatorException(message);
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}

	}
}
