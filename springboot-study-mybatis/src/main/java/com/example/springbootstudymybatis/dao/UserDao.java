package com.example.springbootstudymybatis.dao;

import com.example.springbootstudymybatis.pojo.User;
import com.example.springbootstudymybatis.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
	
	//查询指定用户
	User getUserInfo(int id);
	
	//删除用户
	int deleteUser(int id);
	//新增用户
	int addUser(User user);
	//修改用户
	int updateUser(User user);
	//查询所有用户信息
	List<User> getAllUser();
	
	//
	
}
