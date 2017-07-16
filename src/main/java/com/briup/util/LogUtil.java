package com.briup.util;
/**
 * 
* @ClassName: LogUtil
* @Description: 日志的工具包
* @author wangfali
* @date 2017年7月15日 下午9:26:13
*
 */

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(LogUtil.class);
	public static void createLog(){
		LOGGER.info("-------------------info");
		LOGGER.debug("-------------------debug");
		LOGGER.error("--------------------error");
	}
}
