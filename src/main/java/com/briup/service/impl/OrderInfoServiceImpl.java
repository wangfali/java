package com.briup.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.briup.service.OrderInfoService;
/**
 * 
* @ClassName: OrderInfoServiceImpl
* @Description: 实现接口
* @author wangfali
* @date 2017年7月29日 上午11:25:53
*
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService{
	private final static Logger LOGGER=LoggerFactory.getLogger(OrderInfoServiceImpl.class);
	@Override
	public String addOrderInfo(String name) {
		LOGGER.info("新增的订单名称是"+name);
		return name+"o";
	}

}
