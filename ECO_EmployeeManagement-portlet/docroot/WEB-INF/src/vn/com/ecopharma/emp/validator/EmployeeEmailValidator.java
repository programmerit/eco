package vn.com.ecopharma.emp.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

@FacesValidator("employeeEmailValidator")
public class EmployeeEmailValidator implements Validator {

	private static final String EMAIL_PATTERN = "[\\w\\.-]*[a-zA-Z0-9._%-]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]";

	private Pattern pattern;
	private Matcher matcher;

	public EmployeeEmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		matcher = pattern.matcher(value.toString());
		final LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();
		final ServiceContext serviceContext = liferayFacesContext
				.getServiceContext();
		FacesMessage msg = null;
		long userId = (Long) component.getAttributes().get("userId");

		if (!matcher.matches()) {
			msg = new FacesMessage("Email validation failed",
					"Invalid Email format.");
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
			throw new ValidatorException(msg);
		} else
			try {
				if (UserLocalServiceUtil.fetchUserByEmailAddress(
						serviceContext.getCompanyId(), value.toString()) != null
						&& !UserLocalServiceUtil.fetchUser(userId)
								.getEmailAddress()
								.equalsIgnoreCase(value.toString())) {
					msg = new FacesMessage("Invalid Email format.",
							"Email has already existed.");
					msg.setSeverity(FacesMessage.SEVERITY_WARN);
					throw new ValidatorException(msg);
				}
			} catch (SystemException e) {
				LogFactoryUtil.getLog(EmployeeEmailValidator.class).info(e);
			}

	}

}
