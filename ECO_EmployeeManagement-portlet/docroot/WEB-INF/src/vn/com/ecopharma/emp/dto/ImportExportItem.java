package vn.com.ecopharma.emp.dto;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;

public class ImportExportItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int STRING_CELL_TYPE = 1;

	protected String getCellValueAsString(Cell cell) {
		if (cell == null)
			return StringUtils.EMPTY;
		cell.setCellType(STRING_CELL_TYPE);
		return StringUtils.trimToEmpty(cell.getStringCellValue());
	}

	protected String getActualEmpCode(String unformattedEmpCode) {
		if (StringUtils.trimToNull(unformattedEmpCode) == null) {
			return StringUtils.EMPTY;
		}
		String actualEmpCode = null;
		if (unformattedEmpCode.length() == 5) {
			actualEmpCode = "9"
					+ unformattedEmpCode.substring(1,
							unformattedEmpCode.length());
		} else if (unformattedEmpCode.length() == 4) {
			actualEmpCode = "9" + unformattedEmpCode;
		} else {
			actualEmpCode = unformattedEmpCode;
		}

		return actualEmpCode;
	}

}
