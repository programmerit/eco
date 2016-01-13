package vn.com.ecopharma.emp.node;

import java.io.Serializable;
import java.util.List;

public class BaseModelNodeTypeItem implements Serializable,
		Comparable<BaseModelNodeTypeItem> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5498196943755736696L;

	public static final String ROOT_TYPE = "Root";
	private long id;
	private String type;
	private String name;

	private Object modelObject;

	private BaseModelNodeTypeItem parentModel;

	private List<BaseModelNodeTypeItem> childrenModels;

	public BaseModelNodeTypeItem() {
		this.id = 0L;
		this.type = ROOT_TYPE;
	}

	public BaseModelNodeTypeItem(long id, String type, String name) {
		this.id = id;
		this.type = type;
		this.name = name;
	}

	public BaseModelNodeTypeItem(Object modelObject) {
		this.modelObject = modelObject;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getModelObject() {
		return modelObject;
	}

	public void setModelObject(Object modelObject) {
		this.modelObject = modelObject;
	}

	public BaseModelNodeTypeItem getParentModel() {
		return parentModel;
	}

	public void setParentModel(BaseModelNodeTypeItem parentModel) {
		this.parentModel = parentModel;
	}

	public List<BaseModelNodeTypeItem> getChildrenModels() {
		return childrenModels;
	}

	public void setChildrenModels(List<BaseModelNodeTypeItem> childrenModels) {
		this.childrenModels = childrenModels;
	}

	@Override
	public int compareTo(BaseModelNodeTypeItem o) {
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
		if (obj instanceof BaseModelNodeTypeItem) {
			BaseModelNodeTypeItem that = (BaseModelNodeTypeItem) obj;
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
