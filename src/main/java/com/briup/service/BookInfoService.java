package com.briup.service;

import com.briup.annotation.MineAopBean;

/**
 * 
* @ClassName: BookInfoService
* @Description: 本接口是为了展示aop的处理功能
* @author wangfali
* @date 2017年7月24日 下午9:47:55
*
 */
@MineAopBean
public interface BookInfoService {
	String addBookInfo(String name)throws IllegalArgumentException;
}
