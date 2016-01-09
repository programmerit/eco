package vn.com.ecopharma.emp.node;

import java.io.Serializable;

import vn.com.ecopharma.emp.model.District;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Region;

public class LocationNodeItem implements Serializable,
		Comparable<LocationNodeItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String COUNTRY_TYPE = "Country";
	public static final String CITY_TYPE = "City";
	public static final String DISTRICT_TYPE = "District";

	private long id;
	private String name;
	private String type;

	public LocationNodeItem(long id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public LocationNodeItem(BaseModel<?> t) {
		this.id = Long.valueOf(String.valueOf(t.getPrimaryKeyObj()));
		this.setNameAndTypeFromBaseModel(t);
	}

	// for emptyNode
	public LocationNodeItem(String type) {
		this.type = type;
		this.id = 0;
		this.name = "Not available";
	}

	private void setNameAndTypeFromBaseModel(BaseModel<?> t) {
		if (t instanceof Country) {
			this.name = ((Country) t).getName();
			this.type = COUNTRY_TYPE;
		} else if (t instanceof Region) {
			this.name = ((Region) t).getName();
			this.type = CITY_TYPE;
		} else if (t instanceof District) {
			this.name = ((District) t).getName();
			this.type = DISTRICT_TYPE;
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

	@Override
	public int compareTo(LocationNodeItem o) {
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
		if (obj instanceof LocationNodeItem) {
			LocationNodeItem that = (LocationNodeItem) obj;
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
