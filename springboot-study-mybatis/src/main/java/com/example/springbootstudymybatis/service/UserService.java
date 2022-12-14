package com.example.springbootstudymybatis.service;

import com.example.springbootstudymybatis.pojo.User;
import com.example.springbootstudymybatis.pojo.User2NRoles;

import java.util.List;

public interface UserService {
	
	//查找用户
	public User getUserInfo(int id);
	
	//删除用户
	public int deleteUser(int id);
	
	//新增用户
	public int addUser(User user);
	
	//修改用户
	public int updateUser(User user);
	
	//查询所有用户信息
	public List<User> getAllUser();
	
	//查找一个用户对应多个角色
	public List<User2NRoles> getOneUser2NRoles();
	
}
