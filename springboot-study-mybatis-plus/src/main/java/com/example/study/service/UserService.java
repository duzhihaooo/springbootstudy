package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.demo.OneUser2NRoles;
import com.example.study.demo.User;

import java.util.List;

public interface UserService extends IService<User> {
	//1.查询所有用户
	List<User> listUser();
	//2.查询一个用户对应多个角色
	List<OneUser2NRoles> getOneUser2NRoles();
    
	List<User> getUsersByIds(List<Integer> userIds);
	
	
	
	
	//添加用户
	public int add(User user);
	
	//修改用户
	public int update(User user);
	
	//删除用户
	public int delete(int id);
	
}