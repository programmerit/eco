package vn.com.ecopharma.emp.util;

import java.util.List;

import vn.com.ecopharma.emp.model.Emp;

public class MailServiceUtils {

	private MailServiceUtils() {

	}

	public static String getNewEmployeesHtmlTable(List<Emp> emps) {
		StringBuilder builder = new StringBuilder();

		builder.append("<table border='1' cellpadding='0' cellspacing='0' style='border-collapse:collapse;'>");
		builder.append("	<tr style='color: #0027C2; font-weight: bold; background-color: yellow;'>");
		builder.append("		<td>Stt</td>");
		builder.append("		<td>MSNV</td>");
		builder.append("		<td>Họ và tên</td>");
		builder.append("		<td>Chức danh</td>");
		builder.append("		<td>Phòng ban</td>");
		builder.append("		<td>Ngày nhận việc</td>");
		builder.append("		<td>Nơi làm việc</td>");
		builder.append("		<td>Điện thoại</td>");
		builder.append("		<td>Email</td>");
		builder.append("		<td>Ghi chú</td>");
		builder.append("	</tr>");
		// int count = 0;
		// for (Emp emp: emps) {
		//
		// }
		builder.append("	<tr>");
		builder.append("		<td>1</td>");
		builder.append("		<td>0001</td>");
		builder.append("		<td>Nhan Vien Test</td>");
		builder.append("		<td>Nhan vien</td>");
		builder.append("		<td>CNTT</td>");
		builder.append("		<td>20/11/2011</td>");
		builder.append("		<td>TP. HCM</td>");
		builder.append("		<td>0902 54 88 22</td>");
		builder.append("		<td>tvtao@gmail.com.vn</td>");
		builder.append("		<td>none</td>");
		builder.append("	</tr>");
		builder.append("</table>");
		return builder.toString();
	}

	public static String getEntireNewEmployeesHtmlMailContent(List<Emp> emps) {
		StringBuilder builder = new StringBuilder();
		builder.append("<p>Phòng HCNS trân trọng thông báo thông tin nhân sự sắp nhận việc đến các Đơn vị/Bộ phận có liên quan như sau:</p>");
		builder.append(getNewEmployeesHtmlTable(emps));
		builder.append("<p>Đề nghị các đơn vị có liên quan thực hiện công tác  chuẩn bị thật chu đáo và hoàn tất trước ngày nhân sự nhận việc ít nhất 3 ngày ");
		builder.append("(trừ trường hợp nhận việc ngay) để thể hiện sự chuyên nghiệp, thân thiện của Công ty và sự tôn trọng đối với nhân sự mới.</p>");
		builder.append("Trân trọng,<br />");
		builder.append("Phòng HCNS");
		return builder.toString();
	}
}
