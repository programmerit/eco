package vn.com.ecopharma.hrm.tt.bean;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;

@ManagedBean
@ViewScoped
public class TimeTrackingReportFilterBean {

	private int month;

	private Unit unit;

	private List<Unit> units;

	@PostConstruct
	public void init() {
		units = UnitLocalServiceUtil.findAll();
	}

	public void onUnitChanged(ActionEvent event) {

	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public List<Integer> getMonths() {
		return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
	}

	public List<Unit> getUnits() {
		return units;
	}

}
