package vn.com.ecopharma.emp.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.permission.PortletPermissionUtil;

@ManagedBean(name = "permissionsURLModelBean")
@RequestScoped
public class PermissionURLModelBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private String portletResourcePrimaryKey;
	
	public String getPortletResourcePrimaryKey() {

		if (portletResourcePrimaryKey == null) {
			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			long plid = liferayFacesContext.getPlid();
			Portlet portlet = liferayFacesContext.getPortlet();
			String portletId = portlet.getPortletId();
			portletResourcePrimaryKey = PortletPermissionUtil.getPrimaryKey(plid, portletId);
			
			System.out.println("permissionsURLModelBean: " + portletResourcePrimaryKey);
		}

		return portletResourcePrimaryKey;
	}
}
