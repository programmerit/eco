package vn.com.ecopharma.emp.dto;

import org.primefaces.model.DefaultTreeNode;

import com.liferay.portal.model.BaseModel;

public class DefaultBaseModelTreeNode<T extends BaseModel<T>> extends
		DefaultTreeNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7993984653551072800L;

	private T object;

	public DefaultBaseModelTreeNode(T t) {
		this.object = t;
	}

	public long getId() {
		return new Long(object.getPrimaryKeyObj().toString());
	}
	
}
