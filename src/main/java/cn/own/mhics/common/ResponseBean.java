package cn.own.mhics.common;
/**
 * 返回格式
 * @author Mr.wang
 *
 */
public class ResponseBean {

	/**
	 * HTTP状态码
	 */
	private Integer code;
	
	/**
	 * 返回的信息
	 */
	private String msg;
	
	/**
	 * 返回的数据
	 */
	private Object data;
	
	public ResponseBean(int code,String msg,Object  data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
