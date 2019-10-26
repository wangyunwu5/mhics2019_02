package cn.own.mhics.tools;

/**
 * String工具
 * @author Mr.wang
 *
 */
public class StringUtil {

	/**
	 * 下划线
	 */
	private static final char UNDERLINE = '_';
	
	/**
	 * String 为空判断,不允许为空格
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return str ==null || "".equals(str.trim());
	}
	
	/**
	 * String 不为空判断，不允许为空格
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	/**
	 * Byte数组为空判断
	 * @param bytes
	 * @return
	 */
	public static boolean isNUll(byte[] bytes) {
		return bytes == null || bytes.length == 0;
	}
	/**
	 * byte数据不为空判断
	 * @param bytes
	 * @return
	 */
	public static boolean isNotNull(byte[] bytes) {
		return !isNUll(bytes);
	}
	
	/**
	 * 驼峰转下划线工具
	 * @param param
	 * @return
	 */
	public static String camelToUnderline(String param) {
		if(isNotBlank(param)) {
			int length = param.length();
			StringBuilder sb = new StringBuilder(length);
			for(int i =0;i<length;i++) {
				char c = param.charAt(i);
				if(Character.isUpperCase(c)) {
					sb.append(UNDERLINE);
					sb.append(Character.toLowerCase(c));
				}
				else {
					sb.append(c);
				}
			}
			return sb.toString();
		}
		else {
			return "";
		}
	}
	
	/**
	 * 下划线转驼峰工具
	 * @param param
	 * @return
	 */
	public static String underlineTOCamel(String param) {
		if(isNotBlank(param)) {
			int length = param.length();
			StringBuilder sb = new StringBuilder(length);
			for(int i =0;i<length;i++) {
				char c = param.charAt(i);
				if(c == 95) {//在ASCLL码中，95对应字符为下划线
					++i;
					if(i <length) {
						sb.append(Character.toUpperCase(i));
					}
				}
				else {
					sb.append(c);
				}
			}
			return sb.toString();
		}
		else {
			return "";
		}
	}
	/**
	 * 给字符串添加单引号
	 * @param param
	 * @return
	 */
	public static String addSingleQuotes(String param) {
		return "\'"+param+"\'";
	}
}
