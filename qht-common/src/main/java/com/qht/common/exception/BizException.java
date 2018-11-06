package com.qht.common.exception;

/**
 * 草原狼
 */
public class BizException extends RuntimeException {
	
	private static final long serialVersionUID = -8722032022479302659L;
	
	private String code;
	private String msg;

	public BizException() {
        super();
	}

	public BizException(String code, String msg) {
        super();
		this.code = code;
		this.msg = msg;
	}

	public BizException(String message, String code, String msg) {
		super(message);
		this.code = code;
		this.msg = msg;
	}

	public BizException(String message, Throwable cause, String code, String msg) {
		super(message, cause);
		this.code = code;
		this.msg = msg;
	}

	public BizException(Throwable cause, String code, String msg) {
		super(cause);
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "BizException{" + "code='" + code + '\'' + ", msg='" + msg + '\'' + '}';
	}
}
