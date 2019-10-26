package cn.own.mhics.exception;

/**
 * 自定义401无权限异常
 * @author Mr.wang
 *
 */
public class CustomUnauthorizedException extends RuntimeException {
	
	public CustomUnauthorizedException(String msg) {
		super(msg);
	}
	
	public CustomUnauthorizedException() {
		super();
	}
}
