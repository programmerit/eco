package vn.com.ecopharma.emp.node;

import java.io.Serializable;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;

import com.liferay.portal.model.BaseModel;

/**
 * @author TaoTran
 * @version 1.0
 * @since 2016/01/05
 */
public class OrgNodeItem implements Serializable, Comparable<OrgNodeItem> {

	private static final long serialVersionUID = 1L;

	public static final String DEVISION_TYPE = "Devision";
	public static final String DEPARTMENT_TYPE = "Department";
	public static final String UNIT_TYPE = "Unit";
	public static final String UNITGROUP_TYPE = "UnitGroup";
	public static final String TITLES_TYPE = "Titles";

	private long id;
	private String name;
	private String type;
	private Object modelObject;

	public OrgNodeItem(long id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public OrgNodeItem(BaseModel<?> t) {
		this.modelObject = t;
		this.id = Long.valueOf(String.valueOf(t.getPrimaryKeyObj()));
		this.setNameAndTypeFromBaseModel(t);
	}

	// for emptyNode
	public OrgNodeItem(String type) {
		this.type = type;
		this.id = 0;
		this.name = "Not available";
	}

	private void setNameAndTypeFromBaseModel(BaseModel<?> t) {
		if (t instanceof Devision) {
			this.name = ((Devision) t).getName();
			this.type = DEVISION_TYPE;
		} else if (t instanceof Department) {
			this.name = ((Department) t).getName();
			this.type = DEPARTMENT_TYPE;
		} else if (t instanceof Unit) {
			this.name = ((Unit) t).getName();
			this.type = UNIT_TYPE;
		} else if (t instanceof UnitGroup) {
			this.name = ((UnitGroup) t).getName();
			this.type = UNITGROUP_TYPE;
		} else if (t instanceof Titles) {
			this.name = ((Titles) t).getName();
			this.type = TITLES_TYPE;
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getModelObject() {
		return modelObject;
	}

	public void setModelObject(Object modelObject) {
		this.modelObject = modelObject;
	}

	@Override
	public int compareTo(OrgNodeItem o) {
		int i = name.compareTo(o.getName());
		if (i != 0)
			return i;
		i = type.compareTo(o.getType());
		if (i != 0)
			return i;
		return Long.compare(id, o.getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof OrgNodeItem) {
			OrgNodeItem that = (OrgNodeItem) obj;
			return this.type.equals(that.getType()) && this.id == that.id
					&& this.name == that.name;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				* (this.type == null ? 0 : this.type.hashCode());
		result = prime * result
				* (this.name == null ? 0 : this.name.hashCode());
		result = prime * result
				* (this.id == 0 ? 0 : Long.valueOf(this.id).hashCode());
		return result;
	}

}
