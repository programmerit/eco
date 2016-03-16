package vn.com.ecopharma.hrm.rc.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaLocalServiceUtil;

@FacesValidator(value = "criteriaValidator")
public class EvaluationCriteriaValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent c, Object arg2)
			throws ValidatorException {
		String type = (String) c.getAttributes().get("type");
		String name = (String) c.getAttributes().get("critName");

		FacesMessage message = null;
		if (EvaluationCriteriaLocalServiceUtil.findByNameAndType(name, type) != null) {
			message = new FacesMessage("Criteria existed",
					"Criteria with name='" + name + "' and Type: '" + type
							+ "' has already existed");
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			throw new ValidatorException(message);
		}

	}
}
