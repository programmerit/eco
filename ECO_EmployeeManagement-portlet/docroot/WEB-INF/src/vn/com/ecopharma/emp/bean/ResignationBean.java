package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.enumeration.ResignationType;
import vn.com.ecopharma.emp.service.ResignationHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;
import vn.com.ecopharma.emp.util.SearchEngineUtils;

/**
 * @author TaoTran
 *
 */
@ManagedBean
@ViewScoped
public class ResignationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<EmpIndexedItem> emps;

	private EmpResignedItem resignedItem;

	@PostConstruct
	public void init() {
		emps = new ArrayList<>();
	}

	public void onSave() {
		FacesMessage msg = null;

		if (emps.isEmpty() || resignedItem.reason.equals(StringUtils.EMPTY)
				|| resignedItem.getResignedDate() == null) {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Resignation Information", "Check required fields");
		} else {
			ResignationHistoryLocalServiceUtil.addEmpsResignationHistory(
					SearchEngineUtils.getIdsFromEmpIndexedItems(emps),
					resignedItem.getResignedDate(), resignedItem.getReason(),
					resignedItem.getComment(),
					EmployeeUtils.getServiceContext());

			msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Resignation Info",
					"All selected Employees were added to Resigned list successfully");
			RequestContext.getCurrentInstance().execute(
					"PF('wResignationDialog').hide();");

		}
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public List<EmpIndexedItem> completeEmps(String query) {
		return EmployeeUtils.searchEmpByName(query,
				new HashMap<String, Object>());
	}

	public String getShortenEmpName(String fullName) {
		return EmployeeUtils.getShortenDisplayFullName(fullName);
	}

	public List<String> getResignationTypes() {
		return EmployeeUtils.getResignationTypes();
	}

	public String getLocalizedResignationType(String r) {
		return EmployeeUtils.getLocalizedResignationType(r);
	}

	public List<EmpIndexedItem> getEmps() {
		return emps;
	}

	public void setEmps(List<EmpIndexedItem> emps) {
		this.emps = emps;
	}

	public EmpResignedItem getResignedItem() {
		return resignedItem;
	}

	public void setResignedItem(EmpResignedItem resignedItem) {
		this.resignedItem = resignedItem;
	}

	public static class EmpResignedItem implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private Date resignedDate;
		private String reason;
		private String comment;

		public EmpResignedItem() {
			this.resignedDate = new Date();
			this.reason = ResignationType.NONE.toString();
			this.comment = StringUtils.EMPTY;
		}

		public Date getResignedDate() {
			return resignedDate;
		}

		public void setResignedDate(Date resignedDate) {
			this.resignedDate = resignedDate;
		}

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

	}

}
