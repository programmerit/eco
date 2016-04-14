package vn.com.ecopharma.emp.enumeration;

public enum EmpActionHistoryStatus {

	PREPERSISTED, SAVED, //
	PRE_UPDATE, SAVED_UPDATE, //
	PRE_RESIGNED, APPLIED_RESIGNED, //
	PRE_SET_BACK_TO_WORK, APPLIED_SET_BACK_TO_WORK;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}
}
