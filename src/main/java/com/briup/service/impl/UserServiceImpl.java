package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.entity.User;
import com.briup.mapper.UserMapper;
import com.briup.service.UserService;
/**
 * 
* @ClassName: UserServiceImpl
* @Description: 实现用户业务层接口
* @author wangfali
* @date 2017年7月15日 下午4:18:15
*
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	 UserMapper userMapper;
	@Override
	public void save(User user) throws Exception {
		userMapper.save(user);
	}
	@Override
	public List<User> listAll() throws Exception {
		return userMapper.listAll();
	}

}
