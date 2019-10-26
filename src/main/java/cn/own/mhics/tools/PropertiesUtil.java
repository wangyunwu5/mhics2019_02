package cn.own.mhics.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.own.mhics.exception.CustomException;

/**
 * properties工具，即配置文件工具
 * @author Mr.wang
 *
 */
public class PropertiesUtil {

	/**
	 * 日志
	 */
	private static final Logger logger =LoggerFactory.getLogger(PropertiesUtil.class);
	
	/**
	 * prop
	 */
	private static final Properties PROP = new Properties();
	
	/**
	 * 读取配置文件
	 * @param fileName
	 */
	public static void readProperties(String fileName) {
		InputStream in =null;
		try {
			in = PropertiesUtil.class.getResourceAsStream("/"+fileName);
			BufferedReader bf = new BufferedReader(new InputStreamReader(in));
			PROP.load(bf);
		}
		catch(IOException e) {
			logger.error("PropertiesUtil工具类读取配置文件出现异常:"+e.getMessage());
			throw new CustomException("PropertiesUtil工具类读取配置文件出现异常:"+e.getMessage());
		}
		finally {
			try {
				if(in != null) {
					in.close();
				}
			}
			catch(IOException e) {
				logger.error("PropertiesUtil工具类读取配置文件出现异常:"+e.getMessage());
				throw new CustomException("PropertiesUtil工具类读取配置文件出现异常:"+e.getMessage());
			}
		}
	}
	/**
	 * 根据key读取对应的value
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return PROP.getProperty(key);
	}
}
