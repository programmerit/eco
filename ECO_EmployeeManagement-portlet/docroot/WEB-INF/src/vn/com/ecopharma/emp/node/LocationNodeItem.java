package vn.com.ecopharma.emp.node;

import vn.com.ecopharma.emp.util.TreeNodeUtils;

import com.liferay.portal.model.BaseModel;

public class LocationNodeItem extends BaseModelNodeTypeItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String COUNTRY_TYPE = "Country";
	public static final String CITY_TYPE = "City";
	public static final String DISTRICT_TYPE = "District";

	public LocationNodeItem() {
		super();
	}

	public LocationNodeItem(long id, String name, String type) {
		super(id, type, name);
	}

	public LocationNodeItem(BaseModel<?> t) {
		super(t);
		setId(Long.valueOf(String.valueOf(t.getPrimaryKeyObj())));
		setType(TreeNodeUtils.getTypeFromBaseModel(t));
		setName(TreeNodeUtils.getNameFromBaseModel(t));
	}

}
