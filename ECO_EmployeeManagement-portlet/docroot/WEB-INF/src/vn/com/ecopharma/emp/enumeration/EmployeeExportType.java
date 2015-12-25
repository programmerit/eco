package vn.com.ecopharma.emp.enumeration;

public enum EmployeeExportType {
	CSV, XLS, XLSX, PDF;

	private static final String XLS_MIME_TYPE = "application/vnd.ms-excel";

	private static final String XLSX_MIME_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	private static final String CSV_MIME_TYPE = "text/csv";

	private static final String XLS_EXT = ".xls";

	private static final String XLSX_EXT = ".xlsx";

	private static final String CSV_EXT = ".csv";

	public String getExension() {
		switch (this) {
		case XLS:
			return XLS_EXT;
		case XLSX:
			return XLSX_EXT;
		case CSV:
			return CSV_EXT;
		default:
			break;
		}
		return XLSX_EXT;
	}

	public String getMimeType() {
		switch (this) {
		case XLS:
			return XLS_MIME_TYPE;
		case XLSX:
			return XLSX_MIME_TYPE;
		case CSV:
			return CSV_MIME_TYPE;
		default:
			break;
		}
		return XLS_MIME_TYPE;
	}

}
