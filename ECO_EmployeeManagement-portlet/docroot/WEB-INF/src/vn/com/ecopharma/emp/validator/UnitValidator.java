package vn.com.ecopharma.emp.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;

@FacesValidator("unitValidator")
public class UnitValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent component, Object arg2)
			throws ValidatorException {

		boolean isEdit = (Boolean) component.getAttributes().get("isEdit");

		FacesMessage msg = null;
		if (!isEdit) {
			long departmentId = (Long) component.getAttributes().get(
					"departmentId");
			if (UnitLocalServiceUtil.findByNameAndDepartment(arg2.toString(),
					departmentId) != null) {
				msg = new FacesMessage(
						"A unit with the same name has already existed!");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
			}

		}
	}

}
