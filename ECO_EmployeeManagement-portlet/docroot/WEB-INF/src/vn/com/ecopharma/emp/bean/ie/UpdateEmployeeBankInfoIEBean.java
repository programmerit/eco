package vn.com.ecopharma.emp.bean.ie;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import vn.com.ecopharma.emp.service.EmpBankInfoLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;
import vn.com.ecopharma.emp.util.ImportExportUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;

@ManagedBean(name = "updateBankInfoIEBean")
@ViewScoped
public class UpdateEmployeeBankInfoIEBean {

	public static final int START_ROW_NUM = 5;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(UpdateEmployeeBankInfoIEBean.class);

	@PostConstruct
	public void init() {

	}

	/**
	 * @param fileUploadEvent
	 */
	public void handleFileImport(FileUploadEvent fileUploadEvent) {

		InputStream is = null;
		try {
			final UploadedFile uploadedFile = fileUploadEvent.getFile();
			final ServiceContext serviceContext = EmployeeUtils
					.getServiceContext();
			is = uploadedFile.getInputstream();

			XSSFWorkbook wb = new XSSFWorkbook(is);
			final XSSFSheet sheet = wb.getSheetAt(1);

			final List<BankInfoItem> updateItems = new ArrayList<>();

			for (int i = START_ROW_NUM; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (sheet.getRow(i) != null) {
					updateItems.add(new BankInfoItem(row, 1));
					updateItems.add(new BankInfoItem(row, 2));
					updateItems.add(new BankInfoItem(row, 3));
				}
			}

			String prevEmpCode = StringUtils.EMPTY;
			for (BankInfoItem item : updateItems) {
				if (item.isValid()) {
					if (!prevEmpCode.equalsIgnoreCase(item.getEmpCode())) {
						// flush old addresses before update new ones
						prevEmpCode = item.getEmpCode();
						LOGGER.info("Flush " + prevEmpCode + " bank infos");
						EmpBankInfoLocalServiceUtil
								.removeAllBankInfoByEmpCode(item.getEmpCode());
					}

					LOGGER.info("Call update " + prevEmpCode + " bank info");

					EmpBankInfoLocalServiceUtil.createAndAddEmpBankInfo(
							item.getEmpCode(), item.getBankNo(),
							item.getBankName(), item.getBankBranchName(),
							serviceContext);

				}
			}

		} catch (IOException e) {
			LOGGER.info(e);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				LOGGER.info(e);
			}
		}

	}

	public final class BankInfoItem implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private static final int EMP_CODE_CELL = 1;

		private String empCode;

		private int bankIndex;

		private String bankNo;
		private String bankName;
		private String bankBranchName;

		public BankInfoItem(String empCode, String bankNo, String bankName,
				String bankBranchName, int bankIndex) {
			super();
			this.empCode = empCode;
			this.bankIndex = bankIndex;
			this.bankNo = bankNo;
			this.bankName = bankName;
			this.bankBranchName = bankBranchName;
		}

		public BankInfoItem(Row row, int bankIndex) {
			super();
			this.bankIndex = bankIndex;
			this.bindFieldsFromRow(row);
		}

		private void bindFieldsFromRow(Row row) {
			int bankNoCell = 0;
			int bankNameCell = 0;
			int bankBranchNameCell = 0;
			this.empCode = ImportExportUtils.getReturnValueFromStringCell(row
					.getCell(EMP_CODE_CELL));
			switch (bankIndex) {
			case 1:
				bankNoCell = 2;
				bankNameCell = 3;
				bankBranchNameCell = 4;
				break;
			case 2:
				bankNoCell = 5;
				bankNameCell = 6;
				bankBranchNameCell = 7;
				break;
			case 3:
				bankNoCell = 8;
				bankNameCell = 9;
				bankBranchNameCell = 10;
				break;
			default:
				break;
			}

			bankNo = ImportExportUtils.getReturnValueFromStringCell(row
					.getCell(bankNoCell));
			bankName = ImportExportUtils.getReturnValueFromStringCell(row
					.getCell(bankNameCell));
			bankBranchName = ImportExportUtils.getReturnValueFromStringCell(row
					.getCell(bankBranchNameCell));
		}

		public boolean isValid() {
			return StringUtils.trimToNull(bankNo) != null;
		}

		public String getEmpCode() {
			return empCode;
		}

		public void setEmpCode(String empCode) {
			this.empCode = empCode;
		}

		public int getBankIndex() {
			return bankIndex;
		}

		public void setBankIndex(int bankIndex) {
			this.bankIndex = bankIndex;
		}

		public String getBankNo() {
			return bankNo;
		}

		public void setBankNo(String bankNo) {
			this.bankNo = bankNo;
		}

		public String getBankName() {
			return bankName;
		}

		public void setBankName(String bankName) {
			this.bankName = bankName;
		}

		public String getBankBranchName() {
			return bankBranchName;
		}

		public void setBankBranchName(String bankBranchName) {
			this.bankBranchName = bankBranchName;
		}

	}
}
