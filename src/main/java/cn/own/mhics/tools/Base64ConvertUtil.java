package cn.own.mhics.tools;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Base64工具
 * @author Mr.wang
 *
 */
public class Base64ConvertUtil {

	/**
	 * 加密
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String encode(String str)throws UnsupportedEncodingException{
		byte[] encodeBytes = Base64.getEncoder().encode(str.getBytes("utf-8"));
		return new String(encodeBytes);
	}
	/**
	 * 解密
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String decode(String str) throws UnsupportedEncodingException{
		byte[] decodeBytes = Base64.getDecoder().decode(str.getBytes("utf-8"));
		return new String(decodeBytes);
	}
}
