package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.demo.OneUser2NRoles;
import com.example.study.demo.User;

import java.util.List;

public interface UserService extends IService<User> {
	List<User> listUser();
    
	List<User> getUsersByIds(List<Integer> userIds);
	
	
	List<OneUser2NRoles> getOneUser2NRoles();
	
	//添加用户
	public int add(User user);
	
	//修改用户
	public int update(User user);
	
	//删除用户
	public int delete(int id);
	
}