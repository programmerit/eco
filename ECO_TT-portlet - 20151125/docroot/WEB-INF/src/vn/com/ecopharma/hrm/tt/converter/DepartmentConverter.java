package vn.com.ecopharma.hrm.tt.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter("departmentConverter")
public class DepartmentConverter extends AbstractBaseModelConverter<Department> {

	@Override
	protected Department returnedModelObject(String value) {
		try {
			return DepartmentLocalServiceUtil.fetchDepartment(Long
					.valueOf(value));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
}
