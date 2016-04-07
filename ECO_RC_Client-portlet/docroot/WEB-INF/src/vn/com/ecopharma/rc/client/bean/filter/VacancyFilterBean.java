package vn.com.ecopharma.rc.client.bean.filter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

@ManagedBean(name = "vacancyFilterBean")
@ViewScoped
public class VacancyFilterBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String global = StringUtils.EMPTY;
	private String name = StringUtils.EMPTY;
	private String subUnit = StringUtils.EMPTY;
	private String titles = StringUtils.EMPTY;
	private String status = StringUtils.EMPTY;
	private int numberOfPositionFrom = -1;
	private int numberOfPositionTo = -1;

	/* */
	private int numberOfPosition;

	public String getGlobal() {
		return global;
	}

	public void setGlobal(String global) {
		this.global = global;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubUnit() {
		return subUnit;
	}

	public void setSubUnit(String subUnit) {
		this.subUnit = subUnit;
	}

	public String getTitles() {
		return titles;
	}

	public void setTitles(String titles) {
		this.titles = titles;
	}

	public int getNumberOfPositionFrom() {
		return numberOfPositionFrom;
	}

	public void setNumberOfPositionFrom(int numberOfPositionFrom) {
		this.numberOfPositionFrom = numberOfPositionFrom;
	}

	public int getNumberOfPositionTo() {
		return numberOfPositionTo;
	}

	public void setNumberOfPositionTo(int numberOfPositionTo) {
		this.numberOfPositionTo = numberOfPositionTo;
	}

	public int getNumberOfPosition() {
		return numberOfPosition;
	}

	public void setNumberOfPosition(int numberOfPosition) {
		this.numberOfPosition = numberOfPosition;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
