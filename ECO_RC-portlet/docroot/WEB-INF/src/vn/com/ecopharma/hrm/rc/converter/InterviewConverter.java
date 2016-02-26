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
			info(e);
		} catch (SystemException e) {
			info(e);
		}
		return null;
	}

	@Override
	protected Class<?> getLogClass() {
		return InterviewConverter.class;
	}

}
