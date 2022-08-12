package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.demo.Role;
import com.example.study.demo.OneRoles2NUser;

import com.example.study.demo.User;
import java.util.List;

public interface RoleService extends IService<Role> {
	List<Role> listRole();
	

	
	//设置通过List<Long> getRolesById(List<Long> roleList)的方法
	List<Role> getRolesById(List<Long> roleIdList);
	
	//查找    1个角色对应多个用户
	List<OneRoles2NUser> getRolesUser();
	
	//1.添加一个用户
	public int add(Role role);
	
	//2.删除一个用户
	public int delete(Role role);
	
	//3.修改一个用户
	public int update(Role role);

	
}