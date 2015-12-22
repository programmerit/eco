package vn.com.ecopharma.emp.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;

@FacesValidator(value = "empCodeValidator")
public class EmpCodeValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent component, Object value)
			throws ValidatorException {
		final String empCode = (String) value;
		long empId = (Long) component.getAttributes().get("empId");

		if (EmpLocalServiceUtil.isOnAddingNewWithSameEmployeeCode(empId,
				empCode)) {
			FacesMessage msg = new FacesMessage("Invalid Employee Code.",
					"Employee Code has already existed.");
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
			throw new ValidatorException(msg);
		}
	}
}
