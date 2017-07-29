package com.briup.service;

import com.briup.annotation.MineAopBean;

/**
 * 
* @ClassName: OrderInfoService
* @Description: aop添加其他的消息
* @author wangfali
* @date 2017年7月29日 上午11:21:00
*
 */
@MineAopBean
public interface OrderInfoService {
	String addOrderInfo(String name);
}
