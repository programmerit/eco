package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;

import com.liferay.portal.model.BaseModel;

import vn.com.ecopharma.hrm.rc.dto.AbstractBaseModelItem;

public interface CoreRCBean extends Serializable {

	public void onSave();

	public void addEntity();

	public void editEntity(AbstractBaseModelItem<? extends BaseModel<?>> object);

	public void editEntity(long id);

}
