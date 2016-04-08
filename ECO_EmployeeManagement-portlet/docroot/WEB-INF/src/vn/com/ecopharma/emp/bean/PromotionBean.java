package vn.com.ecopharma.emp.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.model.PromotedHistory;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.PromotedHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@ManagedBean
@ViewScoped
public class PromotionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(PromotionBean.class);

	private long employeeId;

	private PromotedHistory promotedHistory;

	@PostConstruct
	public void init() {
	}

	public void onSave() {
		FacesMessage msg = null;
		EmpIndexedItem employeeIndexedItem = getEmployeeIndexedItem();
		OrganizationPanelBean organizationPanelBean = BeanUtils
				.getOrganizationPanelBean();
		if (organizationPanelBean.getSelectedTitles().getTitlesId() != employeeIndexedItem
				.getTitlesId()) {
			long titlesId = organizationPanelBean.getSelectedTitles()
					.getTitlesId();
			long unitGroupId = EmployeeUtils
					.getBaseModelPrimaryKey(organizationPanelBean
							.getSelectedUnitGroup());
			long unitId = EmployeeUtils
					.getBaseModelPrimaryKey(organizationPanelBean
							.getSelectedUnit());
			long departmentId = EmployeeUtils
					.getBaseModelPrimaryKey(organizationPanelBean
							.getSelectedDepartment());

			promotedHistory.setOldTitlesId(employeeIndexedItem.getTitlesId());
			promotedHistory.setNewTitlesId(titlesId);
			promotedHistory.setEmployeeId(employeeIndexedItem.getId());
			PromotedHistory result = PromotedHistoryLocalServiceUtil
					.addPromotedHistory(promotedHistory, unitGroupId, unitId,
							departmentId, LiferayFacesContext.getInstance()
									.getServiceContext());
			if (result != null) {
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Promotion Info", "Employee "
								+ employeeIndexedItem.getFullName()
								+ " has been promoted to position ['"
								+ organizationPanelBean.getSelectedTitles()
										.getName() + "'] sucessfully");
				organizationPanelBean.afterSetOrganizationToEntity();
			}
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Duplicate titles", "Fail to promote "
							+ employeeIndexedItem.getFullName());
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public PromotedHistory getPromotedHistory() {
		return promotedHistory;
	}

	public void setPromotedHistory(PromotedHistory promotedHistory) {
		this.promotedHistory = promotedHistory;
	}

	public EmpIndexedItem getEmployeeIndexedItem() {
		if (employeeId != 0) {
			return new EmpIndexedItem(EmpLocalServiceUtil.getIndexedEmp(
					employeeId, EmployeeUtils.getCurrentSearchContext()));
		}
		return null;
	}

	public Titles getOldTitles() {
		try {
			return getEmployeeIndexedItem() != null ? TitlesLocalServiceUtil
					.getTitles(getEmployeeIndexedItem().getTitlesId()) : null;
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}
}
