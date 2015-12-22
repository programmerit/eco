package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

public class EntityViewBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * mode 1: view
	 * 
	 * mode 2: create
	 * 
	 * mode 3: edit
	 */
	private int currentMode = 1;

	private boolean isFilteredShow = false;

	public void switchMode(int mode) {
		this.currentMode = mode;
	}

	public void showHideFilterPanel(ActionEvent event) {
		isFilteredShow = !isFilteredShow;
	}

	public int getCurrentMode() {
		return currentMode;
	}

	public void setCurrentMode(int currentMode) {
		this.currentMode = currentMode;
	}

	public boolean isFilteredShow() {
		return isFilteredShow;
	}

	public void setFilteredShow(boolean isFilteredShow) {
		this.isFilteredShow = isFilteredShow;
	}
}
