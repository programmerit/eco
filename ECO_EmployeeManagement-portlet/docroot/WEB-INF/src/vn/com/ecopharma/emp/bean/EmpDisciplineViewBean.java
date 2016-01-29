package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import vn.com.ecopharma.emp.dm.AbstractIndexedLazyDataModel;
import vn.com.ecopharma.emp.dm.EmpDisciplineIndexLazyDataModel;
import vn.com.ecopharma.emp.dto.EmpDisciplineIndexedItem;
import vn.com.ecopharma.emp.enumeration.DisciplineType;
import vn.com.ecopharma.emp.service.EmpDisciplineLocalServiceUtil;

@ManagedBean(name = "disciplineViewBean")
@ViewScoped
public class EmpDisciplineViewBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AbstractIndexedLazyDataModel<EmpDisciplineIndexedItem> lazyDataModel;

	private EmpDisciplineIndexedItem selectedItem;

	@PostConstruct
	public void init() {
		lazyDataModel = new EmpDisciplineIndexLazyDataModel();
	}

	public void onRowEdit(RowEditEvent event) {
		EmpDisciplineIndexedItem item = (EmpDisciplineIndexedItem) event
				.getObject();

		EmpDisciplineLocalServiceUtil.updateEmpDiscipline(item.getId(),
				item.getType(), item.getContent(), item.getEffectiveDate(),
				item.getAdditionalType(), item.getDesc());
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage("Update Notice!",
						"Successfully update Discipline information for "
								+ item.getFullNameVi()));
	}

	public void onRowEditCancel(RowEditEvent event) {

	}

	public void onIndexAll() {

	}

	public void onRemoveAllIndex() {

	}

	public List<String> getDisciplineTypes() {
		return DisciplineType.getAll();
	}

	public AbstractIndexedLazyDataModel<EmpDisciplineIndexedItem> getLazyDataModel() {
		return lazyDataModel;
	}

	public void setLazyDataModel(
			AbstractIndexedLazyDataModel<EmpDisciplineIndexedItem> lazyDataModel) {
		this.lazyDataModel = lazyDataModel;
	}

	public EmpDisciplineIndexedItem getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(EmpDisciplineIndexedItem selectedItem) {
		this.selectedItem = selectedItem;
	}
}
