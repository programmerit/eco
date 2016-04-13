package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.bean.filter.EmpDisciplineFilterBean;
import vn.com.ecopharma.emp.constant.EmpDisciplineField;
import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.dm.AbstractIndexedLazyDataModel;
import vn.com.ecopharma.emp.dm.EmpDisciplineIndexLazyDataModel;
import vn.com.ecopharma.emp.dto.EmpDisciplineIndexedItem;
import vn.com.ecopharma.emp.enumeration.DisciplineType;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpDiscipline;
import vn.com.ecopharma.emp.service.EmpDisciplineLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;

import com.liferay.portal.kernel.exception.SystemException;

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
		lazyDataModel = new EmpDisciplineIndexLazyDataModel() {

			private static final long serialVersionUID = 1L;

			@Override
			public List<EmpDisciplineIndexedItem> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				final EmpDisciplineFilterBean filterBean = BeanUtils
						.getDisciplineFilterBean();

				if (filterBean.getEffectiveDateFrom() != null) {
					filters.put(EmpDisciplineField.EFFECTIVE_DATE_FROM,
							filterBean.getEffectiveDateFrom());
				}

				if (filterBean.getEffectiveDateTo() != null) {
					filters.put(EmpDisciplineField.EFFECTIVE_DATE_TO,
							filterBean.getEffectiveDateTo());
				}

				if (!StringUtils.EMPTY.equals(filterBean.getFullName())) {
					filters.put(EmpField.VN_FULL_NAME, filterBean.getFullName());
				}

				if (!StringUtils.EMPTY.equals(filterBean.getEmpCode())) {
					filters.put(EmpField.EMP_CODE, filterBean.getEmpCode());
				}

				return super.load(first, pageSize, sortField, sortOrder,
						filters);
			}
		};
	}

	public void onRowEdit(RowEditEvent event) {
		EmpDisciplineIndexedItem item = (EmpDisciplineIndexedItem) event
				.getObject();

		EmpDisciplineLocalServiceUtil.updateEmpDiscipline(item.getId(),
				item.getDecisionNo(), item.getType(), item.getContent(),
				item.getEffectiveDate(), item.getAdditionalType(),
				item.getDesc());
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage("Update Notice!",
						"Successfully update Discipline information for "
								+ item.getFullNameVi()));
	}

	public void onRowEditCancel(RowEditEvent event) {

	}

	public void onIndexAll() {
		EmpDisciplineLocalServiceUtil.indexAll();
	}

	public void onRemoveAllIndex() {

	}

	public void reUpdateEmp() {
		for (EmpDiscipline empDiscipline : EmpDisciplineLocalServiceUtil
				.findAll()) {
			try {
				Emp emp = EmpLocalServiceUtil
						.fetchEmp(empDiscipline.getEmpId());
				EmpLocalServiceUtil.updateEmp(emp);
			} catch (SystemException e) {
				e.printStackTrace();
			}

		}
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
