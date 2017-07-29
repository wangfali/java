package com.briup.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.briup.annotation.MineAopBean;

/**
 * 
 * @ClassName: CommonService
 * @Description: 用于实现aop功能的类
 * @author wangfali
 * @date 2017年7月24日 下午9:42:23
 *
 */
@Service
@MineAopBean
public class CommonService {
	private final static Logger LOGGER = LoggerFactory.getLogger(CommonService.class);

	public int add(int i){
		i+=1;
		LOGGER.info("commonServie处理的结果为"+i);
		return i;
	}
}
