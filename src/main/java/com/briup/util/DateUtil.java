package com.briup.util;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
* @ClassName: DateUtil
* @Description: 日期工具类
* @author wangfali
* @date 2017年7月24日 下午9:05:17
*
 */
public class DateUtil{
	public static String now(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}
}

