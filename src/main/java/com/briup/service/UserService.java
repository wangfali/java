package com.briup.service;

import java.util.List;

import com.briup.entity.User;

/**
 * 
* @ClassName: UserService
* @Description: 用户业务层接口
* @author wangfali
* @date 2017年7月15日 下午4:08:34
*
 */
public interface UserService {
	/**
	 * 
	* @Title: save
	* @Description: 保存用户
	* @param @param user 用户实例
	* @param @throws Exception    
	* @return void   
	 */
	void save(User user)throws Exception;
	List<User> listAll()throws Exception;
}
