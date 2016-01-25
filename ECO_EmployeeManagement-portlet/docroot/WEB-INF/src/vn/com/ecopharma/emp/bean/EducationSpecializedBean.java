package vn.com.ecopharma.emp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import vn.com.ecopharma.emp.model.Specialized;
import vn.com.ecopharma.emp.service.SpecializedLocalServiceUtil;

@ManagedBean(name = "specializedBean")
@ViewScoped
public class EducationSpecializedBean {

	private Specialized firstLevelSpecialized;

	private Specialized secondLevelSpecialized;

	private Specialized thirdLevelSpecialized;

	@PostConstruct
	public void init() {

	}

	public void onUpdateSpecialized() {
		// EmployeeBean employeeBean = BeanUtils.getEmployeeViewBean();
		// employeeBean
		// .getModifyEmployeeInfoItem()
		// .getEmp()
		// .setEducationSpecialize(
		// thirdLevelSpecialized != null ? thirdLevelSpecialized
		// .getName() : StringUtils.EMPTY);
	}

	public void onFirstLevelChanged() {
		this.secondLevelSpecialized = null;
		this.thirdLevelSpecialized = null;

	}

	public void onSecondLevelChanged() {
		this.thirdLevelSpecialized = null;
	}

	public void onThirdLevelChanged() {

	}

	public Specialized getFirstLevelSpecialized() {
		return firstLevelSpecialized;
	}

	public void setFirstLevelSpecialized(Specialized firstLevelSpecialized) {
		this.firstLevelSpecialized = firstLevelSpecialized;
	}

	public List<Specialized> getFirstLevelSpecializeds() {
		return SpecializedLocalServiceUtil.findByLevel(1);
	}

	public Specialized getSecondLevelSpecialized() {
		return secondLevelSpecialized;
	}

	public void setSecondLevelSpecialized(Specialized secondLevelSpecialized) {
		this.secondLevelSpecialized = secondLevelSpecialized;
	}

	public List<Specialized> getSecondLevelSpecializeds() {
		return firstLevelSpecialized != null ? SpecializedLocalServiceUtil
				.findByLevelAndParent(2,
						firstLevelSpecialized.getSpecializedId())
				: new ArrayList<Specialized>();
	}

	public Specialized getThirdLevelSpecialized() {
		return thirdLevelSpecialized;
	}

	public void setThirdLevelSpecialized(Specialized thirdLevelSpecialized) {
		this.thirdLevelSpecialized = thirdLevelSpecialized;
	}

	public List<Specialized> getThirdLevelSpecializeds() {
		if (firstLevelSpecialized == null)
			return new ArrayList<>();

		if (secondLevelSpecialized == null)
			return SpecializedLocalServiceUtil.findByLevelAndParent(3,
					firstLevelSpecialized.getSpecializedId());

		return SpecializedLocalServiceUtil.findByLevelAndParent(3,
				secondLevelSpecialized.getSpecializedId());
	}

}
