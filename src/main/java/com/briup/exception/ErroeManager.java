package com.briup.exception;
/**
 * 
* @ClassName: ErroeManager
* @Description: 全局异常的管理
* @author wangfali
* @date 2017年7月23日 下午1:30:38
*
 */


public class ErroeManager <T>{
	public static final Integer Ok=0;
	public static final Integer ERROR=100;
	private Integer code;
	private String messgae;
	private String url;
	private T data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessgae() {
		return messgae;
	}
	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
