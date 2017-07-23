package com.briup.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.exception.MineException;

/**
 * 
 * @ClassName: ErrorTestContorller
 * @Description: 测试全局异常
 * @author wangfali
 * @date 2017年7月23日 下午3:39:35
 *
 */
@Controller
public class ErrorTestContorller {
	private final static Logger LOGGER =  LoggerFactory.getLogger(ErrorTestContorller.class);

	@RequestMapping("/")
	public String hello(ModelMap map) {
		LOGGER.info("访问到了 hello===");
		map.addAttribute("index", "一起尝试spring boot 全局异常的捕获吧!");
		return "index";
	}

	@RequestMapping("/anyone")
	public String anyone(ModelMap map) throws Exception {
		LOGGER.info("访问到了 index===");
		throw new Exception();
	}

	@RequestMapping("/mine")
	public String mine(ModelMap map) {
		LOGGER.info("访问到了mine");
		Throwable throwable = new Throwable();
		throw new MineException("我们访问到了mine" + throwable);
	}
	@ResponseBody
	@RequestMapping("/sum")
	public String sum(ModelMap map) throws ArithmeticException {
		int i = 1 / 0;
		return "" + i;
	}

}
