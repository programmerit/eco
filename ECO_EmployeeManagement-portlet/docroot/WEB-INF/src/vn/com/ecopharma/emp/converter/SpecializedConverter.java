package vn.com.ecopharma.emp.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.model.Specialized;
import vn.com.ecopharma.emp.service.SpecializedLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@FacesConverter(value = "specializedConverter")
public class SpecializedConverter extends
		AbstractBaseModelConverter<Specialized> {

	private static final Log LOGGER = LogFactoryUtil
			.getLog(SpecializedConverter.class);

	@Override
	protected Specialized returnedModelObject(String value) {
		try {
			return SpecializedLocalServiceUtil.fetchSpecialized(Long
					.valueOf(value));
		} catch (NumberFormatException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}
}
