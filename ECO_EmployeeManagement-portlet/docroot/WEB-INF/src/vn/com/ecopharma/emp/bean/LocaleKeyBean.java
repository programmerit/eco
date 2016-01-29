package vn.com.ecopharma.emp.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.enumeration.DisciplineType;

/**
 * @author TaoTran
 *
 */
@ManagedBean
@RequestScoped
public class LocaleKeyBean {

	public String getDisciplineTypeKey(String type) {
		if (StringUtils.EMPTY.equals(type))
			return StringUtils.EMPTY;
		DisciplineType disciplineType = DisciplineType.valueOf(type);
		return disciplineType.getLocalizedString();
	}
}
