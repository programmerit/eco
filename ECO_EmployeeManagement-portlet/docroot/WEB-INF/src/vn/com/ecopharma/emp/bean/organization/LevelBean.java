package vn.com.ecopharma.emp.bean.organization;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import vn.com.ecopharma.emp.bean.AbstractOrganizationBean;
import vn.com.ecopharma.emp.model.Level;
import vn.com.ecopharma.emp.service.LevelLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@ManagedBean
public class LevelBean extends AbstractOrganizationBean {
	private static final long serialVersionUID = 1L;

	private Level level;

	@PostConstruct
	public void init() {
		try {
			level = LevelLocalServiceUtil.createLevel(CounterLocalServiceUtil
					.increment());
		} catch (SystemException e) {
			LogFactoryUtil.getLog(LevelBean.class).info(e);
		}
	}

	@Override
	public void onSave(ActionEvent event) {
		try {
			LevelLocalServiceUtil.addLevel(level);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Create Level successfully", "Level " + level.getName()
							+ " has been created");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(LevelBean.class).info(e);
		}
	}

	public List<Integer> getLevelRanks() {
		return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
}