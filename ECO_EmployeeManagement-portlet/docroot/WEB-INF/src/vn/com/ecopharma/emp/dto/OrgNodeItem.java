package vn.com.ecopharma.emp.dto;

import java.io.Serializable;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;

import com.liferay.portal.model.BaseModel;

public class OrgNodeItem implements Serializable, Comparable<OrgNodeItem> {

	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private String type;

	public OrgNodeItem(long id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public OrgNodeItem(BaseModel<?> t) {
		this.id = Long.valueOf(String.valueOf(t.getPrimaryKeyObj()));
		if (t instanceof Devision) {
			this.name = ((Devision) t).getName();
			this.type = "DEVISION";
		} else if (t instanceof Department) {
			this.name = ((Department) t).getName();
			this.type = "DEPARTMENT";
		} else if (t instanceof Unit) {
			this.name = ((Unit) t).getName();
			this.type = "UNIT";
		} else if (t instanceof Titles) {
			this.name = ((Titles) t).getName();
			this.type = "TITLES";
		}
	}

	// for emptyNode
	public OrgNodeItem(String type) {
		this.type = type;
		this.id = 0;
		this.name = "Not available";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
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
}
