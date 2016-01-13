package vn.com.ecopharma.emp.node;

import vn.com.ecopharma.emp.util.TreeNodeUtils;

import com.liferay.portal.model.BaseModel;

/**
 * @author TaoTran
 * @version 1.0
 * @since 2016/01/05
 */
public class OrgNodeItem extends BaseModelNodeTypeItem {

	private static final long serialVersionUID = 1L;

	public static final String DEVISION_TYPE = "Devision";
	public static final String DEPARTMENT_TYPE = "Department";
	public static final String UNIT_TYPE = "Unit";
	public static final String UNITGROUP_TYPE = "UnitGroup";
	public static final String TITLES_TYPE = "Titles";
	public static final String ROOT = "Root";

	public OrgNodeItem() {
		super();
	}

	public OrgNodeItem(long id, String name, String type) {
		super(id, type, name);
	}

	public OrgNodeItem(BaseModel<?> t) {
		super(t);
		setId(Long.valueOf(String.valueOf(t.getPrimaryKeyObj())));
		setType(TreeNodeUtils.getTypeFromBaseModel(t));
		setName(TreeNodeUtils.getNameFromBaseModel(t));
	}
}
