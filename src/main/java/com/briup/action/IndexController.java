package com.briup.action;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.briup.service.ArithmeticService;
@Controller
public class IndexController {
	private final static Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private ArithmeticService arithmeticService;

	@SuppressWarnings("static-access")
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public void index() {
		long start = System.currentTimeMillis();
		try {
			LOGGER.info("--------------------------------------------\n");
			LOGGER.info("每个任务执行的时间是：" + arithmeticService.DoTime + "（毫秒）");

			Future<Long> task = arithmeticService.subByAsync();

			arithmeticService.subByVoid();

			long sync = arithmeticService.subBySync();

			while (true) {
				if (task.isDone()) {
					long async = task.get();
					LOGGER.info("异步任务执行的时间是：" + async + "（毫秒）");
					// logger.info("注解任务执行的时间是： -- （毫秒）");
					LOGGER.info("同步任务执行的时间是：" + sync + "（毫秒）");
					break;
				}
			}
			LOGGER.info("--------------------------------------------\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		LOGGER.info("\t........请求响应时间为：" + (end - start) + "（毫秒）");
	}

	/**
	 * 自定义实现线程异步
	 */
	@RequestMapping(value = { "/mine", "/m*" }, method = RequestMethod.GET)
	public void mineAsync() {
		for (int i = 0; i < 100; i++) {
			try {
				arithmeticService.doMineAsync(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
