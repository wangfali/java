package com.briup.exception;
/**
 * 
* @ClassName: MineException
* @Description: 自定义运行时异常
* @author wangfali
* @date 2017年7月23日 下午1:34:11
*
 */


public class MineException extends RuntimeException{
	public MineException(int code, String msgFormat,Object... args) {
		super(String.format(msgFormat, args));
		this.code=code;
		this.msg=String.format(msgFormat, args);
	}
	
	private static final long serialVersionUID = 7826875884540770720L;
	/**
	 * 生成序列异常时
	 */
	public static final MineException DB_GET_SEQ_NEXT_VALUE_ERROR = new MineException(10040007, "序列生成超时");
	/**
	 * 具体的异常码
	 */
	protected int code;
	/**
	 * 异常信息
	 */
	protected String msg;
	/**
	 * @param message
	 */
	public MineException(String message){
		super(message);
	}
	public MineException newinstance(String msgFormat,Object...args){
		return new MineException(this.code, msgFormat, args);
	}
	
}
