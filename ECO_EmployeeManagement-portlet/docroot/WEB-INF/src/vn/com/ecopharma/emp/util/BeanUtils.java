package vn.com.ecopharma.emp.util;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import vn.com.ecopharma.emp.bean.EmployeeBean;
import vn.com.ecopharma.emp.bean.EmployeeIndexedBean;

public class BeanUtils {

	private static final String EMPLOYEE_BEAN = "empView";

	private static final String EMPLOYEE_INDEXED_BEAN = "employeeIndexedBean";

	private BeanUtils() {
	}

	/**
	 * @param name
	 * @return
	 */
	public static Object getBackingBeanByName(String name) {
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		return FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(elContext, null, name);
	}

	public static EmployeeBean getEmployeeViewBean() {
		return (EmployeeBean) getBackingBeanByName(EMPLOYEE_BEAN);
	}

	public static EmployeeIndexedBean getEmployeeIndexedBean() {
		return (EmployeeIndexedBean) getBackingBeanByName(EMPLOYEE_INDEXED_BEAN);
	}

}
