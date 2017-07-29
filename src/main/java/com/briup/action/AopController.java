package com.briup.action;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.briup.service.BookInfoService;
import com.briup.service.CommonService;
import com.briup.service.OrderInfoService;
import com.briup.util.CommonUtil;

/**
 * 
* @ClassName: AopController
* @Description: 
* @author wangfali
* @date 2017年7月29日 上午11:31:56
*
 */
//@RestController
public class AopController {
	//注册日志对象
	private final static Logger LOGGER =LoggerFactory.getLogger(AopController.class);
	@Resource
	CommonService service;
	@Resource
	OrderInfoService orderInfoService;
	@Resource
	BookInfoService bookInfoService;
	@RequestMapping(value = { "/**", "/" }, method = RequestMethod.GET)
	public Long testAop(){
		LOGGER.info("\n================Spring aop===========\n");
		int i=1;
		i=CommonUtil.add(i);
		i=service.add(i);
		LOGGER.info("\n===========处理结果为："+i+"=========\n");
		String name="#######";
		name=orderInfoService.addOrderInfo(name);
		name=bookInfoService.addBookInfo(name);
		LOGGER.info("\n=========名称为\t"+name+"===============\n");
		return System.currentTimeMillis();
	}
}
