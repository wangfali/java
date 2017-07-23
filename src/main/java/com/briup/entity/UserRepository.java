package com.briup.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
* @ClassName: UserRepository
* @Description:使用spring集成的jpa技术
* @author wangfali
* @date 2017年7月23日 下午6:36:54
*
 */
public interface UserRepository extends JpaRepository<Person,Long>{
	/**
	 * 
	* @Title: findByName
	* @Description:通过用户名查询用户 
	* @param  name
	* @return Person   
	 */
	Person findByName(String name);
	/**
	 * 
	* @Title: findById
	* @Description: 通过用户的id查询用户
	* @param  id
	* @return Person   
	 */
	Person findById(String id);
	
}
