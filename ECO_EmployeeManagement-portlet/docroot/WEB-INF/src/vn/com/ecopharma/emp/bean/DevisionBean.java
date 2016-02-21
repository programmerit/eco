package vn.com.ecopharma.emp.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Location;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
public class DevisionBean extends AbstractOrganizationBean {
	private static final long serialVersionUID = 1L;

	private Devision devision;
	private Location location;

	@PostConstruct
	public void init() {
		try {
			devision = DevisionLocalServiceUtil
					.createDevision(CounterLocalServiceUtil.increment());
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onSave(ActionEvent event) {
		final Devision result = DevisionLocalServiceUtil.addDevision(devision,
				EmployeeUtils.getServiceContext());
		if (result != null) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Create Devision successfully", "Devision "
							+ result.getName() + " has been created");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public Devision getDevision() {
		return devision;
	}

	public void setDevision(Devision devision) {
		this.devision = devision;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
