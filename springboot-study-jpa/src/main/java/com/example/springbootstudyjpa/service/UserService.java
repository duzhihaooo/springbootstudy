package com.example.springbootstudyjpa.service;

import com.example.springbootstudyjpa.pojo.User;
import com.example.springbootstudyjpa.pojo.User2NRoles;

import java.util.List;

public interface UserService {

	/**
	 * 查找用户
	 * @param id    用户id
	 */
	public User getUserInfo(Integer id);
	/**
	 * 删除用户
	 * @param id    删除id
	 */
	public void deleteUser(Integer id);
	
	/**
	 * 新增用户
	 * @param user  用户信息
	 */
	public User addUser(User user);
	/**
	 * 修改用户
	 * @param user  用户信息
	 */
	public void updateUser(User user);
	/**
	 * 查询所有用户信息
	 */
	public List<User> getAllUser();
	/**
	 * Repository接口方法名称命名查询
	 */
	public List<User> findByUserName(String str);
	public List<User> findByUserNameLike(String str);
	/**
	 * 基于@Query注解查询与更新
	 */
	public List<User> queryByNameUseSQL(String str);
	 /*//取消自动回滚
	public void updateUsersNameById(String name,String id);
	*/
	
	//查找一个用户对应多个角色
	List<User2NRoles> findUser2NRoles();
	
	User getUserById(int id);
	
	
	
}