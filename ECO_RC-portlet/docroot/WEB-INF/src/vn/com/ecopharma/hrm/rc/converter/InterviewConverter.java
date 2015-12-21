package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.hrm.rc.model.Interview;
import vn.com.ecopharma.hrm.rc.service.InterviewLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(value = "interviewConverter")
public class InterviewConverter extends AbstractBaseModelConverter<Interview> {

	@Override
	protected Interview returnedObject(String value) {
		try {
			return InterviewLocalServiceUtil
					.fetchInterview(Long.valueOf(value));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

}
