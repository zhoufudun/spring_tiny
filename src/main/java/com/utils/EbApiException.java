package com.utils;



/**
 * 通用运行时异常
 * 
 * @author ful
 * @date 上午11:22:46
 * @version 1.0.0
 * Copyright 本内容仅限于杭州霖梓网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class EbApiException extends RuntimeException implements SimpleStackTracePrintable {
	private static final long serialVersionUID = -6613599522126934243L;
	private String code;
	private String msg;
	private Object data;

	public EbApiException() {
		this.code = RespCode.FAILED.code;
		this.msg = RespCode.FAILED.msg;
	}
	public EbApiException(String message, Throwable ex) {
		super(message, ex);
		this.code = RespCode.FAILED.code;
		this.msg = message;
	}
	public EbApiException(Throwable ex) {
		super(ex);
		this.code = RespCode.FAILED.code;
		this.msg = RespCode.FAILED.msg;
	}
	public EbApiException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public EbApiException(String code, String msg, Throwable ex) {
		super(ex);
		this.code = code;
		this.msg = msg;
	}

	public EbApiException(String code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}


	public EbApiException(RespCode respCode, Object data) {
		this.code = respCode.code;
		this.msg = respCode.msg;
		this.data = data;
	}

	public EbApiException(RespCode respCode) {
		this.code = respCode.code;
		this.msg = respCode.msg;
	}
	public EbApiException(RespCode respCode, String msg) {
		this.code = respCode.code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	@Override
	public String getMessage() {
		return MessageBuilder.buildMessage(code,msg);
	}
	@Override
	public StackTraceElement[] allStackTrace() {
		return this.getStackTrace();
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "EbApiException{" +
				"code='" + code + '\'' +
				", msg='" + msg + '\'' +
				", data=" + data +
				'}';
	}
}
