package com.briup.util;
/**
 * 
* @ClassName: CommonUtil
* @Description: 用于测试aop的普通工具类
* @author wangfali
* @date 2017年7月24日 下午9:09:49
*
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtil {
	private static final Logger LOGGER=LoggerFactory.getLogger(CommonUtil.class);
	public static int add(int i){
		i+=1;
		LOGGER.info("commonUtil的处理结果为"+i);
		return i;
	}
}
