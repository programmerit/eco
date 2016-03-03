package vn.com.ecopharma.emp.dto;

import java.io.Serializable;
import java.util.Map;

import org.primefaces.model.SortOrder;

public class FilterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String sortField;

	private SortOrder sortOrder;

	private Map<String, Object> filters;

	private int start;

	private int end;

	public FilterDTO(String sortField, SortOrder sortOrder,
			Map<String, Object> filters, int start, int end) {
		super();
		this.sortField = sortField;
		this.sortOrder = sortOrder;
		this.filters = filters;
		this.start = start;
		this.end = end;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public SortOrder getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Map<String, Object> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, Object> filters) {
		this.filters = filters;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
