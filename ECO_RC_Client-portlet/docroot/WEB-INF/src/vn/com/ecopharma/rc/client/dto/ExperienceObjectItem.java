package vn.com.ecopharma.rc.client.dto;

import java.io.Serializable;

import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.model.Experience;
import vn.com.ecopharma.hrm.rc.service.ExperienceLocalServiceUtil;

public class ExperienceObjectItem implements Serializable {
	private static final long serialVersionUID = 1L;

	private Experience experience;
	private boolean UIDeleted;

	public ExperienceObjectItem() {
		this.experience = createExperience();
		this.UIDeleted = false;
	}

	public ExperienceObjectItem(Experience experience) {
		this.experience = experience;
		this.UIDeleted = false;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	public boolean isUIDeleted() {
		return UIDeleted;
	}

	public void setUIDeleted(boolean uIDeleted) {
		UIDeleted = uIDeleted;
	}

	private Experience createExperience() {
		return ExperienceLocalServiceUtil.createPrePersitedExperience(
				Candidate.class.getName(), 0);
	}
}
