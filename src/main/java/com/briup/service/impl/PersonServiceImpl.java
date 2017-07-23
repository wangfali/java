package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.briup.entity.Person;
import com.briup.entity.UserRepository;
import com.briup.service.PersonService;

/**
 * 
* @ClassName: PersonServiceImpl
* @Description: 实现person的业务层接口
* @author wangfali
* @date 2017年7月23日 下午7:23:45
*
 */
@Service
@CacheConfig(cacheNames="user-cache")
public class PersonServiceImpl implements PersonService{
	public static final String CACHE_KEY="PERSONS_CACHE_KEY";
	@Autowired
	UserRepository repository;
	/**
	 * @param 使用id查询用户
	 * @see PersonService#findPersonById(Long)
	 */
	@Override
	@Cacheable(value={})
	public Person findPersonById(Long id) {
		return repository.findOne(id);
	}
	/**
	 * 查询所有的用户
	 * @see PersonService#findAllPerson()
	 * @return 用户的集合
	 */
	@Override
	@Cacheable
	public List<Person> findAllPerson() {
		return repository.findAll();
	}
	/**
	 * 更新或者新增用户的信息
	 * @see PersonService#saveAndFlush(Person)
	 * @param person
	 */
	@Override
	public void saveAndFlush(Person person) {
		repository.saveAndFlush(person);
	}
	/**
	 * 通过id删除一个用户
	 * @see PersonService#deletePersonById(long)
	 * @param id
	 */
	@Override
	public void deletePersonById(long id) {
		repository.delete(id);
	}
	
}
