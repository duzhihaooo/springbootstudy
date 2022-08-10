package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.demo.Role;
import com.example.study.demo.OneRoles2NUser;

import com.example.study.demo.User;
import java.util.List;

public interface RoleService extends IService<Role> {
	List<Role> listRole();
	
	//
	List<OneRoles2NUser> getRolesUser();
	
	//设置通过List<Long> getRolesById(List<Long> roleList)的方法
	List<Role> getRolesById(List<Long> roleIdList);
	
	//1.添加
	//2.删除
	//3.修改

	
}