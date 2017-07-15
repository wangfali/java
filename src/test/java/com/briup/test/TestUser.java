package com.briup.test;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.briup.LoveApplication;
import com.briup.entity.User;
import com.briup.mapper.UserMapper;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=LoveApplication.class,webEnvironment=WebEnvironment.RANDOM_PORT)
@Transactional
public class TestUser {
	@Autowired
	UserMapper userMapper;
	@Test
	public void test() throws Exception{
		System.out.println("进来了");
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setAccount("we");
		user.setName("we");
		user.setAddress("we");
		user.setPassword("23wrfe");
		userMapper.save(user);
		System.out.println("成功了！");
		
	}
}
