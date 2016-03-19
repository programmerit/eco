package vn.com.ecopharma.emp.dto;

import java.util.Date;

import vn.com.ecopharma.emp.model.EmpLaborContract;
import vn.com.ecopharma.emp.service.EmpLaborContractLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

public class LaborContractItem extends
		AbstractUIBaseModelItem<EmpLaborContract> implements
		Comparable<LaborContractItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LaborContractItem() {
		super();
	}

	public LaborContractItem(EmpLaborContract obj) {
		super(obj);
	}

	@Override
	protected EmpLaborContract createPrePersistedBaseModel() {
		return EmpLaborContractLocalServiceUtil
				.createPrePersistedEntity(EmployeeUtils.getServiceContext());
	}

	@Override
	public int compareTo(LaborContractItem that) {
		Date thisSignedDate = this.getObject().getLaborContractSignedDate();
		Date thatSignedDate = that.getObject().getLaborContractSignedDate();

		if (thisSignedDate == null && thatSignedDate == null)
			return 0;

		if (thatSignedDate == null)
			if (thisSignedDate != null)
				return 1;
		
		if (thisSignedDate == null)
			if (thatSignedDate != null)
				return -1;

		return thisSignedDate.compareTo(thatSignedDate);
	}

}
