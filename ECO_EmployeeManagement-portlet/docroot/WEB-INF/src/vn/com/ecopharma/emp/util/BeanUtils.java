package vn.com.ecopharma.emp.util;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import vn.com.ecopharma.emp.bean.EmployeeBean;
import vn.com.ecopharma.emp.bean.EmployeeIndexedBean;
import vn.com.ecopharma.emp.bean.OrganizationTreeViewBean;
import vn.com.ecopharma.emp.bean.TitlesBean;
import vn.com.ecopharma.emp.bean.filter.EmpDisciplineFilterBean;
import vn.com.ecopharma.emp.bean.filter.OrganizationFilterBean;
import vn.com.ecopharma.emp.bean.filter.ResignationFilterBean;
import vn.com.ecopharma.emp.permission.EmpPermission;

public class BeanUtils {

	private static final String EMPLOYEE_BEAN = "empView";

	private static final String EMPLOYEE_INDEXED_BEAN = "employeeIndexedBean";

	private static final String TITLES_BEAN = "titlesBean";

	private static final String ORGANIZATION_TREE_VIEW_BEAN = "organizationTreeViewBean";

	private static final String ORGANIZATION_FILTER_BEAN = "organizationFilterBean";

	private static final String DISCIPLINE_FILTER_BEAN = "disciplineFilterBean";

	private static final String RESIGNATION_FILTER_BEAN = "resignationFilterBean";

	private static final String EMP_PERMISSION_BEAN = "empPermission";

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

	public static OrganizationFilterBean getOrganizationFilterBean() {
		return (OrganizationFilterBean) getBackingBeanByName(ORGANIZATION_FILTER_BEAN);
	}

	public static EmpDisciplineFilterBean getDisciplineFilterBean() {
		return (EmpDisciplineFilterBean) getBackingBeanByName(DISCIPLINE_FILTER_BEAN);
	}

	public static ResignationFilterBean getResignationFilterBean() {
		return (ResignationFilterBean) getBackingBeanByName(RESIGNATION_FILTER_BEAN);
	}

	public static EmpPermission getEmpPermissionBean() {
		return (EmpPermission) getBackingBeanByName(EMP_PERMISSION_BEAN);
	}
}
