package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(value = "departmentConverter")
public class DepartmentConverter extends AbstractBaseModelConverter<Department> {

	@Override
	protected Department returnedObject(String value) {
		try {
			return DepartmentLocalServiceUtil.fetchDepartment(Long
					.valueOf(value));
		} catch (NumberFormatException e) {
			info(e);
		} catch (SystemException e) {
			info(e);
		}
		return null;
	}

	@Override
	protected Class<?> getLogClass() {
		return DepartmentConverter.class;
	}
}
