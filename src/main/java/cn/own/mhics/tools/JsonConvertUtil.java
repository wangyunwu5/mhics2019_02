package cn.own.mhics.tools;

import com.alibaba.fastjson.JSONObject;

/**
 * Json和Object的相互转换，转List必须Json最外层加[ ],转Object,Json最外层不要加[ ]
 * @author Mr.wang
 *
 */
public class JsonConvertUtil {
	
	/**
	 * JSON转Object
	 * @param pojo
	 * @param clazz
	 * @return
	 */
	public static <T> T jsonToObject(String pojo,Class<T> clazz) {
		return JSONObject.parseObject(pojo,clazz);
	}
	/**
	 * Object 转 json
	 * @param t
	 * @return
	 */
	public static <T> String objectToJson(T t) {
		return JSONObject.toJSONString(t);
	}

}
