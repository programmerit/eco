package vn.com.ecopharma.rc.client.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

	private static final String EMAIL_PATTERN = "[\\w\\.-]*[a-zA-Z0-9._%-]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]";

	private Pattern pattern;
	private Matcher matcher;

	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value)
			throws ValidatorException {
		matcher = pattern.matcher(value.toString());
		FacesMessage msg = null;
		if (!matcher.matches()) {
			msg = new FacesMessage("Email validation failed",
					"Invalid Email format.");
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
			throw new ValidatorException(msg);
		}

	}

}
