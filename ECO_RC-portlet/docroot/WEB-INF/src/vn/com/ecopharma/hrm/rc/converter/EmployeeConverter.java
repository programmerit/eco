package vn.com.ecopharma.hrm.rc.converter;

import com.liferay.portal.kernel.exception.SystemException;

import vn.com.ecopharma.emp.model.Employee;
import vn.com.ecopharma.emp.service.EmployeeLocalServiceUtil;

public class EmployeeConverter extends AbstractBaseModelConverter<Employee> {

	@Override
	protected Employee returnedObject(String value) {
		try {
			return EmployeeLocalServiceUtil.fetchEmployee(Long.valueOf(value));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

}
