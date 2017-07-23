package com.briup.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
* @ClassName: Person
* @Description: jpa entity bean Entity Bean与其他Java类没有任何区别。事实上，
* 创建一个Entity Bean对象相当于新建一条记录，
* 删除一个Entity Bean会同时从数据库中删除对应记录，
* 修改一个Entity Bean时，容器会自动将Entity Bean的状态和数据库同步
* @author wangfali
* @date 2017年7月23日 下午6:46:01
*
 */
@Entity
public class Person implements Serializable{
	private static final long serialVersionUID = -544882768995686433L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private Integer age;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Person(Long id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
