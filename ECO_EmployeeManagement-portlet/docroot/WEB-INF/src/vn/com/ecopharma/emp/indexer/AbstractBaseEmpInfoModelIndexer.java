package vn.com.ecopharma.emp.indexer;

import vn.com.ecopharma.emp.constant.EMInfo;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.util.SearchEngineUtils;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.model.BaseModel;

public abstract class AbstractBaseEmpInfoModelIndexer<T extends BaseModel<T>>
		extends AbstractBaseModelIndexer<T> {

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		@SuppressWarnings("unchecked")
		T t = (T) obj;
		final Emp emp = EmpLocalServiceUtil.fetchEmp(getEmpId(t));

		final Document document = getBaseModelDocument(EMInfo.PORTLET_ID, t);
		SearchEngineUtils.indexOrganizationFields(document, emp);
		SearchEngineUtils.indexEmpInfo(document, emp);

		return document;
	}

	protected abstract long getEmpId(T t);

}
