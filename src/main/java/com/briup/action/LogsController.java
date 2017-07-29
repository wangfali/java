package com.briup.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogsController {
	private final static Logger LOGGER =LoggerFactory.getLogger(LogsController.class);
	public Long createLogs(){
		LOGGER.info("--------------------------INFO");
		LOGGER.debug("--------------------------debug");
		LOGGER.error("--------------------ERROR");
		return System.currentTimeMillis();
	}
}
