package vn.com.ecopharma.hrm.rc.util;

import java.util.Arrays;

/**
 * Lop tien ich xu ly ky tu tieng Viet
 * 
 * @author quyetdv
 * 
 */
public class VNCharacterUtils {
	// Using String instead of char array to avoid [Invalid character] with
	// Vietnamese characters when ant build
	public static final String SOURCE_CHARACTERS_STRING = "ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝýỸỹàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠạẢảẤấẦầẨẩẪẫẬậẮắẰằẲẳẴẵẶặẸẹẺẻẼẽẾếỀềỂểỄễỆệỈỉỊịỌọỎỏỐốỒồỔổỖỗỘộỚớỜờỞởỠỡỢợỤụỦủỨứỪừỬửỮữỰự";

	public static final String DEST_CHARACTERS_STRING = "AAAAEEEIIOOOOUUYyYyaaaaeeeiioooouuyAaDdIiUuOoUuAaAaAaAaAaAaAaAaAaAaAaAaEeEeEeEeEeEeEeEeIiIiOoOoOoOoOoOoOoOoOoOoOoOoUuUuUuUuUuUuUu";

	/**
	 * Bo dau 1 ky tu
	 * 
	 * @param ch
	 * @return
	 */
	public static char removeAccent(char ch) {
		char[] SOURCE_CHARACTERS = SOURCE_CHARACTERS_STRING.toCharArray();
		char[] DESTINATION_CHARACTERS = DEST_CHARACTERS_STRING.toCharArray();
		int index = Arrays.binarySearch(SOURCE_CHARACTERS, ch);

		if (index >= 0) {
			ch = DESTINATION_CHARACTERS[index];
		}
		return ch;
	}

	/**
	 * Bo dau 1 chuoi
	 * 
	 * @param s
	 * @return
	 */
	public static String removeAccent(String s) {
		// TODO figure out why these 2 characters are not able to replace
		s = s.replaceAll("ỹ", "y");
		s = s.replaceAll("ỳ", "y");
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < sb.length(); i++) {
			sb.setCharAt(i, removeAccent(sb.charAt(i)));
		}
		return sb.toString();
	}
}