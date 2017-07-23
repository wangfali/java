package com.briup.exception;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
* @ClassName: GlobalException
* @Description:全局异常处理类，创建全局异常处理类：通过使用@controllerAdvice定义统一的异常处理类，而不是
* 在每个controller中猪逐个定义
* controllerAdvice统一定义不同的Exception映射到不同的错误处理页面
* @author wangfali
* @date 2017年7月23日 下午2:17:48
*
 */
@ControllerAdvice
public class GlobalException {
	/**
	 * 在@ControllerAdvice类中根据抛出的具体exception
	 * 类型疲匹配  @ExceptionHandler中配置的异常类型来匹配错误映射和处理
	 */
	public static final String DEFAULT_ERROR_VIEW="error";
	/**
	 * 捕获自定义异常，返回json信息
	 */
	@ExceptionHandler(value=MineException.class)
	@ResponseBody //以json的方式返回对象
	public ErroeManager<Object>ErrorHandler(HttpServletRequest request,MineException e) throws Exception{
		ErroeManager<Object> error = new ErroeManager<>();
		error.setCode(404);
		error.setData(e);
		error.setMessgae("Not Found Exception!!!");
		error.setUrl(request.getRequestURI().toString());
		return error;
	}
	@ExceptionHandler(value=ArithmeticException.class)
	@ResponseBody
	public ErroeManager<Object> ErrorHandler(HttpServletRequest request,ArithmeticException e)throws Exception{
		ErroeManager<Object> erroeManager = new ErroeManager<>();
		erroeManager.setCode(405);
		erroeManager.setMessgae("java.lang.ArithmeticException");
		erroeManager.setUrl(request.getRequestURL().toString());
		erroeManager.setData(e);
		return erroeManager;
	}
	/**
	 * 
	* @Title: ErrorHandeler
	* @Description: TODO
	* @param @param request
	* @param  e
	* @param @throws Exception    
	* @return ModelAndView   
	 */
	public ModelAndView ErrorHandeler(HttpServletRequest request,Exception e) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		ErroeManager<Exception> erroeManager = new ErroeManager<Exception>();
		erroeManager.setCode(400);
		erroeManager.setMessgae("系统异常");
		erroeManager.setUrl(request.getRequestURL().toString());
		erroeManager.setData(e);
		modelAndView.addObject(erroeManager);
		return modelAndView;
	}
	
	
}
