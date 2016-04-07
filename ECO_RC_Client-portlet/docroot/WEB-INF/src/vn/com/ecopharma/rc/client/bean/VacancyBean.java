package vn.com.ecopharma.rc.client.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.rc.client.bean.filter.VacancyFilterBean;
import vn.com.ecopharma.rc.client.constant.VacancyField;
import vn.com.ecopharma.rc.client.dm.VacancyLazyDM;
import vn.com.ecopharma.rc.client.dto.VacancyIndexItem;
import vn.com.ecopharma.rc.client.util.BeanUtils;

@ManagedBean
@ViewScoped
public class VacancyBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LazyDataModel<VacancyIndexItem> lazyDataModel;

	private VacancyIndexItem selectedItem;

	@PostConstruct
	public void init() {
		lazyDataModel = new VacancyLazyDM() {

			private static final long serialVersionUID = 1L;

			@Override
			public List<VacancyIndexItem> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				VacancyFilterBean filterBean = BeanUtils.getVacancyFilterBean();
				if (!filterBean.getGlobal().equals(StringUtils.EMPTY)) {
					filters.put(VacancyField.GLOBAL, filterBean.getGlobal());
				}

				if (!filterBean.getName().equals(StringUtils.EMPTY)) {
					filters.put(VacancyField.NAME, filterBean.getName());
				}

				if (!filterBean.getTitles().equals(StringUtils.EMPTY)) {
					filters.put(VacancyField.TITLES, filterBean.getTitles());
				}

				// if (filterBean.getNumberOfPositionFrom() != -1) {
				filters.put(VacancyField.NUMBER_POSITION_FROM,
						filterBean.getNumberOfPositionFrom());
				// }

				// if (filterBean.getNumberOfPositionTo() != -1) {
				filters.put(VacancyField.NUMBER_POSITION_TO,
						filterBean.getNumberOfPositionTo());
				// }

				return super.load(first, pageSize, sortField, sortOrder,
						filters);
			}
		};
	}

	public LazyDataModel<VacancyIndexItem> getLazyDataModel() {
		return lazyDataModel;
	}

	public void setLazyDataModel(LazyDataModel<VacancyIndexItem> lazyDataModel) {
		this.lazyDataModel = lazyDataModel;
	}

	public VacancyIndexItem getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(VacancyIndexItem selectedItem) {
		this.selectedItem = selectedItem;
	}

}
