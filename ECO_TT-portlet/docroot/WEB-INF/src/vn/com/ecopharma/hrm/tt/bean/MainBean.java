package vn.com.ecopharma.hrm.tt.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpOrgRelationshipLocalServiceUtil;
import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.dto.VacationLeaveIndexedItem;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.service.ServiceContext;

@ManagedBean
@ViewScoped
public class MainBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {

	}

	public boolean isCurrentManager() {
		long currentUserId = TTUtils.getServiceContext().getUserId();
		return EmpOrgRelationshipLocalServiceUtil
				.isHeadOfAtLeastOneDepartment(currentUserId);
	}

	public List<VacationLeaveIndexedItem> getPendingVacationLeaveRequests() {
		final List<VacationLeaveIndexedItem> result = new ArrayList<>();
		if (isCurrentManager()) {
			ServiceContext serviceContext = TTUtils.getServiceContext();
			long currentUserId = serviceContext.getUserId();
			Emp emp = EmpLocalServiceUtil.findByUser(currentUserId);
			List<Document> pendingRequests = VacationLeaveLocalServiceUtil
					.searchPendingRequestsOfManager(emp.getEmpId(),
							TTUtils.getCurrentSearchContext(),
							serviceContext.getCompanyId());

			for (Document r : pendingRequests) {
				result.add(new VacationLeaveIndexedItem(r));
			}
		}
		return result;
	}

}
