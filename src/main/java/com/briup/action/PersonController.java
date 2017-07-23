package com.briup.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.briup.entity.Person;
import com.briup.service.PersonService;

/**
 * 
* @ClassName: PersonController
* @Description: 使用缓存ehcache
* @author wangfali
* @date 2017年7月23日 下午8:07:21
*
 */
@RestController
@RequestMapping("/u")
public class PersonController {
	private static final Logger LOGGER=LoggerFactory.getLogger(PersonController.class);
	@Autowired
	PersonService service;
	/**
	 * 使用id查询用户
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Person findOnePerson(@PathVariable long id){
		LOGGER.info("传入的参数id"+id);
		return service.findPersonById(id);
	}
	/**
	 * 查询所有用户
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<Person>findAllPerson(){
		LOGGER.info("查询所有的用户信息");
		return service.findAllPerson();
	}
	/**
	 * 更新或者新增用户信息
	 * 
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	public Person saveAndFlushPerson(@ModelAttribute Person person){
		LOGGER.info("传入的参数 person："+person.toString());
		service.saveAndFlush(person);
		return person;
		
	}
	/**
	 * 通过id删除一个用户
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public Person deletePerson(@PathVariable long id){
		Person person = service.findPersonById(id);
		LOGGER.info("查询到的person信息是");
		service.deletePersonById(id);
		return person;
		
	}
}
