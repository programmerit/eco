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
import vn.com.ecopharma.emp.enumeration.DisciplineType;
import vn.com.ecopharma.emp.service.EmpDisciplineLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;
import vn.com.ecopharma.emp.util.SearchEngineUtils;

@ManagedBean(name = "disciplineBean")
@ViewScoped
public class DisciplineBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<EmpIndexedItem> emps;

	private EmpDisciplineItem empDisciplineItem;

	private String updateOnCompleteComponents;

	@PostConstruct
	public void init() {
		emps = new ArrayList<>();
		updateOnCompleteComponents = StringUtils.EMPTY;
	}

	public void onSave() {
		FacesMessage msg = null;

		if (emps.isEmpty()
				|| this.empDisciplineItem.getType().equals(StringUtils.EMPTY)
				|| this.empDisciplineItem.getEffectiveDate() == null) {

			msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Discipline Information", "Check required fields");
		} else {
			EmpDisciplineLocalServiceUtil.addEmpsDiscipline(
					SearchEngineUtils.getIdsFromEmpIndexedItems(emps),
					empDisciplineItem.getDecisionNo(),
					empDisciplineItem.getContent(),
					empDisciplineItem.getType(),
					empDisciplineItem.getEffectiveDate(),
					empDisciplineItem.getAdditionalType(),
					empDisciplineItem.getDescription(),
					EmployeeUtils.getServiceContext());

			msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Discipline Information",
					"All selected Employees were added to Discipline list sucessfully");

			RequestContext.getCurrentInstance().execute(
					"PF('wDisciplineDialog').hide();");
			onCancelAndReset();
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCancelAndReset() {
		this.empDisciplineItem = null;
		this.emps.clear();
	}

	public void onCancel() {

	}

	public List<EmpIndexedItem> completeEmps(String query) {
		return EmployeeUtils.searchEmpByName(query,
				new HashMap<String, Object>());
	}

	public String getShortenEmpName(String fullName) {
		return EmployeeUtils.getShortenDisplayFullName(fullName);
	}

	public EmpDisciplineItem getEmpDisciplineItem() {
		return empDisciplineItem;
	}

	public void setEmpDisciplineItem(EmpDisciplineItem empDisciplineItem) {
		this.empDisciplineItem = empDisciplineItem;
	}

	public List<EmpIndexedItem> getEmps() {
		return emps;
	}

	public void setEmps(List<EmpIndexedItem> emps) {
		this.emps = emps;
	}

	public List<String> getDisciplineTypes() {
		return DisciplineType.getAll();
	}

	public String getUpdateOnCompleteComponents() {
		return updateOnCompleteComponents;
	}

	public void setUpdateOnCompleteComponents(String updateOnCompleteComponents) {
		this.updateOnCompleteComponents = updateOnCompleteComponents;
	}

	public static class EmpDisciplineItem implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String decisionNo;
		private String content;
		private String type;
		private Date effectiveDate;
		private String additionalType;
		private String description;

		public EmpDisciplineItem() {
			this.decisionNo = StringUtils.EMPTY;
			this.content = StringUtils.EMPTY;
			this.type = StringUtils.EMPTY;
			this.effectiveDate = new Date();
			this.additionalType = StringUtils.EMPTY;
			this.description = StringUtils.EMPTY;
		}

		public String getDecisionNo() {
			return decisionNo;
		}

		public void setDecisionNo(String decisionNo) {
			this.decisionNo = decisionNo;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Date getEffectiveDate() {
			return effectiveDate;
		}

		public void setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate;
		}

		public String getAdditionalType() {
			return additionalType;
		}

		public void setAdditionalType(String additionalType) {
			this.additionalType = additionalType;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	}

}
