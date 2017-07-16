package com.briup.action;
/**
 * 
* @ClassName: LogsAction
* @Description: 测试使用log组建
* @author wangfali
* @date 2017年7月15日 下午9:36:55
*
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.briup.util.LogUtil;

@Controller
public class LogsAction {
	private static final Logger LOGGER=LoggerFactory.getLogger(LogsAction.class);
	@RequestMapping(value={"/**","/"},method=RequestMethod.GET)
	public void createLog(){
		LOGGER.info("==============info");
		LOGGER.debug("=============debag");
		LOGGER.error("==============error");
		LogUtil.createLog();
		System.out.println("日志主键开始使用");
	}
}
