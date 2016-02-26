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
			info(e);
		} catch (SystemException e) {
			info(e);
		}
		return null;
	}

	@Override
	protected Class<?> getLogClass() {
		return EmployeeConverter.class;
	}

}
