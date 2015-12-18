package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.List;

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
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@ManagedBean
@ViewScoped
public class PromotionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long employeeId;

	private PromotedHistory promotedHistory;

	private Titles promotedTitles;

	@PostConstruct
	public void init() {
		promotedHistory = PromotedHistoryLocalServiceUtil.createPrePersisted();
	}

	public void onSave() {
		FacesMessage msg = null;
		EmpIndexedItem employeeIndexedItem = getEmployeeIndexedItem();
		if (promotedTitles.getTitlesId() != employeeIndexedItem.getTitlesId()) {
			promotedHistory.setOldTitlesId(employeeIndexedItem.getTitlesId());
			promotedHistory.setNewTitlesId(promotedTitles.getTitlesId());
			promotedHistory.setEmployeeId(employeeIndexedItem.getEmployeeId());
			PromotedHistory result = PromotedHistoryLocalServiceUtil
					.addPromotedHistory(promotedHistory, LiferayFacesContext
							.getInstance().getServiceContext());
			if (result != null) {
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Promotion Info", "Employee "
								+ employeeIndexedItem.getFullName()
								+ " has been promoted to position ['"
								+ promotedTitles.getName() + "'] sucessfully");
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
			LogFactoryUtil.getLog(PromotionBean.class).info(e);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(PromotionBean.class).info(e);
		}
		return null;
	}

	public List<Titles> getTitlesList() {
		return TitlesLocalServiceUtil.findAll();
	}

	public Titles getPromotedTitles() {
		return promotedTitles;
	}

	public void setPromotedTitles(Titles promotedTitles) {
		this.promotedTitles = promotedTitles;
	}
}
