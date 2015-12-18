package vn.com.ecopharma.emp.bean;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

public abstract class AbstractOrganizationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract void onSave(ActionEvent event);
}
