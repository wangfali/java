package com.briup.service;
/**
 * 
* @ClassName: PersonService
* @Description: 用户业务层接口
* @author wangfali
* @date 2017年7月23日 下午7:17:41
*
 */

import java.util.List;

import com.briup.entity.Person;

public interface PersonService {
	/**
	 * 
	* @Title: findPersonById
	* @Description: 使用id查询用户
	* @param @param id
	* @return Person   
	* @throws
	 */
	public Person findPersonById(Long id);
	/**
	 * 
	* @Title: findAllPerson
	* @Description: 查询所有用户
	* @return List<Person>   
	* @throws
	 */
	public List<Person>findAllPerson();
	/**
	 * 
	* @Title: saveAndFlush
	* @Description: 添加或更新用户信息
	* @param person    
	* @return void   
	 */
	public void saveAndFlush(Person person);
	/**
	 * 
	* @Title: deletePersonById
	* @Description: 通过id删除一个用户
	* @param  id    
	* @return void   
	* @throws
	 */
	public void deletePersonById(long id);
	
}
