package com.briup.swaggerWeb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.briup.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: UserController
 * @Description: 使用swagger搭建restful api
 * @author wangfali
 * @date 2017年7月29日 下午5:08:28
 *
 */
@Api(value ="UserController 接口")
@RestController
@RequestMapping(value = "/users") // 通过这里配置使下面的映射都在/users下，可以去掉
public class UserController {
	// 创建一个线程同步的map集合
	static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());
	@ApiOperation(value="获取用户列表",notes="")
	@RequestMapping(value={""},method=RequestMethod.GET)
	public List<User> getUserList() {
		return new ArrayList<>(users.values());
	}
	@ApiOperation(value="获取用户详细信息",notes="根据url的id来获取用户的详细信息")
	@ApiImplicitParam(name="id",value="用户ID",required=true,dataType="Long")
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User getUser(@PathVariable Long id){
		return users.get(id);
	}
	@ApiOperation(value="更新用户详细信息",notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="用户ID",required=true,dataType="Long"),
		@ApiImplicitParam(name="user",value="用户详细实体user",required=true,dataType="User")
	})
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String putUser(@PathVariable Long id,@RequestBody User user){
		User u = users.get(id);
		u.setName(user.getName());
		u.setAccount(user.getAccount());
		u.setAddress(user.getAddress());
		users.put(id, user);
		return "success";
	}
	@ApiOperation(value="删除用户",notes="根据url的id来指定删除对象")
	@ApiImplicitParam(name="id",value="用户ID",required=true,dataType="Long")
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id){
		users.remove(id);
		return "succese";
	}
	
	
}
