package vn.com.ecopharma.emp.util;

import org.apache.commons.lang.StringUtils;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.District;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Region;

public class TreeNodeUtils {

	public static final String DEVISION_TYPE = "Devision";
	public static final String DEPARTMENT_TYPE = "Department";
	public static final String UNIT_TYPE = "Unit";
	public static final String UNITGROUP_TYPE = "UnitGroup";
	public static final String TITLES_TYPE = "Titles";

	public static final String ROOT = "Root";

	public static final String COUNTRY_TYPE = "Country";
	public static final String CITY_TYPE = "City";
	public static final String DISTRICT_TYPE = "District";

	public static String getTypeFromBaseModel(BaseModel<?> t) {
		if (t instanceof Devision) {
			return DEVISION_TYPE;
		} else if (t instanceof Department) {
			return DEPARTMENT_TYPE;
		} else if (t instanceof Unit) {
			return UNIT_TYPE;
		} else if (t instanceof UnitGroup) {
			return UNITGROUP_TYPE;
		} else if (t instanceof Titles) {
			return TITLES_TYPE;
		} else if (t instanceof Country) {
			return COUNTRY_TYPE;
		} else if (t instanceof Region) {
			return CITY_TYPE;
		} else if (t instanceof District) {
			return DISTRICT_TYPE;
		}
		return StringUtils.EMPTY;
	}

	public static String getNameFromBaseModel(BaseModel<?> t) {
		if (t instanceof Devision) {
			return ((Devision) t).getName();
		} else if (t instanceof Department) {
			return ((Department) t).getName();
		} else if (t instanceof Unit) {
			return ((Unit) t).getName();
		} else if (t instanceof UnitGroup) {
			return ((UnitGroup) t).getName();
		} else if (t instanceof Titles) {
			return ((Titles) t).getName();
		} else if (t instanceof Country) {
			return ((Country) t).getName();
		} else if (t instanceof Region) {
			return ((Region) t).getName();
		} else if (t instanceof District) {
			return ((District) t).getName();
		}
		return StringUtils.EMPTY;
	}
}
