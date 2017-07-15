package com.briup.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.briup.entity.User;

/**
 * 
 * @ClassName: UserMapper
 * @Description: mybatis dao层数据接口
 * @author wangfali
 * @date 2017年7月15日 下午3:43:22
 *
 */
@Mapper
public interface UserMapper {
	/**
	 * 
	 * @Title: save
	 * @Description: 增加
	 * @param user
	 *            用户实例
	 * @return void
	 */
	@Insert("INSERT INTO user1(user_id,user_name,user_password,user_account,user_address) VALUES(#{id},#{name},#{password},#{account},#{address})")
	void save(User user);

	/**
	 * 
	 * @Title: update
	 * @Description: 更新用户
	 * @param user
	 *            用户实例
	 * @return void
	 */
	@Update("UPDATE user1 SET user_password=#{password} WHERE user_name=#{username}")
	void update(User user);

	/**
	 * 
	 * @Title: remove
	 * @Description: 删除用户
	 * @param id
	 *            用户id
	 * @return void
	 */
	@Delete("DELETE FROM user1 WHERE user_id=#{id}")
	void remove(@Param("id") String id);

	/**
	 * 
	 * @Title: listAll
	 * @Description: 获取所有用户的信息
	 * @return List<User> 返回值类型
	 */
	@Results(value = { @Result(property = "name", column = "user_name"),
			@Result(property = "password", column = "user_password"), @Result(property = "id", column = "user_id"),
			@Result(property = "account", column = "user_account"),
			@Result(property = "address", column = "user_address") })
	@Select("SELECT * FROM user1")
	List<User> listAll();
}
