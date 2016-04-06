package vn.com.ecopharma.emp.util;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import vn.com.ecopharma.emp.bean.ConcurrentTitlesBean;
import vn.com.ecopharma.emp.bean.EmpGlobalFilterHolderBean;
import vn.com.ecopharma.emp.bean.EmployeeBean;
import vn.com.ecopharma.emp.bean.EmployeeIndexedBean;
import vn.com.ecopharma.emp.bean.OrganizationPanelBean;
import vn.com.ecopharma.emp.bean.OrganizationRoleSetBean;
import vn.com.ecopharma.emp.bean.OrganizationTreeViewBean;
import vn.com.ecopharma.emp.bean.TitlesBean;
import vn.com.ecopharma.emp.bean.filter.EmpAnnualLeaveFilterBean;
import vn.com.ecopharma.emp.bean.filter.EmpDisciplineFilterBean;
import vn.com.ecopharma.emp.bean.filter.EmployeeFilterView;
import vn.com.ecopharma.emp.bean.filter.OrganizationFilterBean;
import vn.com.ecopharma.emp.bean.filter.PromotionFilterBean;
import vn.com.ecopharma.emp.bean.filter.ResignationFilterBean;
import vn.com.ecopharma.emp.bean.filter.VacationLeaveFilterBean;
import vn.com.ecopharma.emp.bean.global.AuthorityBean;
import vn.com.ecopharma.emp.permission.EmpPermission;
import vn.com.ecopharma.emp.permission.EmployeeModelPermission;

public class BeanUtils {

	private static final String AUTHORITY_BEAN = "authorityBean";

	private static final String EMPLOYEE_BEAN = "empView";

	private static final String EMPLOYEE_INDEXED_BEAN = "employeeIndexedBean";

	private static final String EMPLOYEE_FILTER_BEAN = "empFilterBean";

	private static final String TITLES_BEAN = "titlesBean";

	private static final String ORGANIZATION_TREE_VIEW_BEAN = "organizationTreeViewBean";

	private static final String ORGANIZATION_FILTER_BEAN = "organizationFilterBean";

	private static final String DISCIPLINE_FILTER_BEAN = "disciplineFilterBean";

	private static final String RESIGNATION_FILTER_BEAN = "resignationFilterBean";

	private static final String EMP_PERMISSION_BEAN = "empPermission";

	private static final String EMP_MODEL_PERMISSION_BEAN = "employeeModelPermission";

	private static final String ORGANIZATION_PANEL_BEAN = "organizationPanelBean";

	private static final String VACATION_LEAVE_FILTER_BEAN = "leaveFilterBean";

	private static final String PROMOTION_FILTER_BEAN = "promotionFilterBean";

	private static final String EMP_ANNUAL_LEAVE_FILTER_BEAN = "annualLeaveFilterBean";

	private static final String EMP_FILTER_HOLDER_BEAN = "empGlobalFilterHolderBean";

	private static final String CONCURRENT_TITLES_BEAN = "concurrentBean";

	private static final String ORGANIZTION_ROLE_SET_BEAN = "organizationRoleSetBean";

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

	public static AuthorityBean getAuthorityBean() {
		return (AuthorityBean) getBackingBeanByName(AUTHORITY_BEAN);
	}

	public static EmployeeBean getEmployeeViewBean() {
		return (EmployeeBean) getBackingBeanByName(EMPLOYEE_BEAN);
	}

	public static EmployeeIndexedBean getEmployeeIndexedBean() {
		return (EmployeeIndexedBean) getBackingBeanByName(EMPLOYEE_INDEXED_BEAN);
	}

	public static EmployeeFilterView getEmpFilterBean() {
		return (EmployeeFilterView) getBackingBeanByName(EMPLOYEE_FILTER_BEAN);
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

	public static EmpAnnualLeaveFilterBean getAnnualLeaveFilterBean() {
		return (EmpAnnualLeaveFilterBean) getBackingBeanByName(EMP_ANNUAL_LEAVE_FILTER_BEAN);
	}

	public static ResignationFilterBean getResignationFilterBean() {
		return (ResignationFilterBean) getBackingBeanByName(RESIGNATION_FILTER_BEAN);
	}

	public static EmpPermission getEmpPermissionBean() {
		return (EmpPermission) getBackingBeanByName(EMP_PERMISSION_BEAN);
	}

	public static EmployeeModelPermission getEmpModelPermission() {
		return (EmployeeModelPermission) getBackingBeanByName(EMP_MODEL_PERMISSION_BEAN);
	}

	public static OrganizationPanelBean getOrganizationPanelBean() {
		return (OrganizationPanelBean) getBackingBeanByName(ORGANIZATION_PANEL_BEAN);
	}

	public static VacationLeaveFilterBean getLeaveFilterBean() {
		return (VacationLeaveFilterBean) getBackingBeanByName(VACATION_LEAVE_FILTER_BEAN);
	}

	public static PromotionFilterBean getPromotionFilterBean() {
		return (PromotionFilterBean) getBackingBeanByName(PROMOTION_FILTER_BEAN);
	}

	public static EmpGlobalFilterHolderBean getEmpFilterHolderBean() {
		return (EmpGlobalFilterHolderBean) getBackingBeanByName(EMP_FILTER_HOLDER_BEAN);
	}

	public static ConcurrentTitlesBean getConcurrentTitlesBean() {
		return (ConcurrentTitlesBean) getBackingBeanByName(CONCURRENT_TITLES_BEAN);
	}

	public static OrganizationRoleSetBean getOrganizationRoleSetBean() {
		return (OrganizationRoleSetBean) getBackingBeanByName(ORGANIZTION_ROLE_SET_BEAN);
	}

}
