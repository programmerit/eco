package vn.com.ecopharma.emp.util;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import vn.com.ecopharma.emp.bean.EmployeeBean;
import vn.com.ecopharma.emp.bean.EmployeeIndexedBean;
import vn.com.ecopharma.emp.bean.OrganizationTreeViewBean;
import vn.com.ecopharma.emp.bean.TitlesBean;

public class BeanUtils {

	private static final String EMPLOYEE_BEAN = "empView";

	private static final String EMPLOYEE_INDEXED_BEAN = "employeeIndexedBean";

	private static final String TITLES_BEAN = "titlesBean";

	private static final String ORGANIZATION_TREE_VIEW_BEAN = "organizationTreeViewBean";

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

	public static TitlesBean getTitlesBean() {
		return (TitlesBean) getBackingBeanByName(TITLES_BEAN);
	}

	public static OrganizationTreeViewBean getOrganizationTreeViewBean() {
		return (OrganizationTreeViewBean) getBackingBeanByName(ORGANIZATION_TREE_VIEW_BEAN);
	}

}
