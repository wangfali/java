package com.briup.action;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.briup.entity.User;
import com.briup.service.UserService;

/**
 * 
* @ClassName: LoginAction
* @Description:
* @author wangfali
* @date 2017年7月13日 下午9:33:32
*
 */
@Controller
@EnableCaching
@EnableWebMvc
public class LoginAction {
	@Autowired
	UserService userService;
	@RequestMapping(value="/login.action",method=RequestMethod.GET)
	public String login(Model model) throws Exception{
		List<User> listAll = userService.listAll();
		System.out.println(listAll.isEmpty());
		return "welcome";
	}
	/**
	 * 测试使用redis缓存
	 * @throws Exception 
	 */
	@RequestMapping(value="/findAll")
	@Cacheable(value="user_findAll")
	public  List<User> findAll() throws Exception{
		System.out.println("如果第二次没有执行此方法，则表示应用了缓存技术");
		return userService.listAll();
		
	}
	
}
