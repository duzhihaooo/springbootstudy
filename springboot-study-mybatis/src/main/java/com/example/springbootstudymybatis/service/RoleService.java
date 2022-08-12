package com.example.springbootstudymybatis.service;

import com.example.springbootstudymybatis.pojo.Role;
import com.example.springbootstudymybatis.pojo.Role_2NUser;

import java.util.List;

public interface RoleService {
	
	//查询指定用户
	public Role getRoleInfo(int id);
	
	//删除角色
	public int deleteRole(int id);
	
	//新增角色
	public int addRole(Role role);
	
	//修改角色
	public int updateRole(Role role);
	
	//查询所有角色信息
	public List<Role> getAllRole();
	
	//查找一个角色对应多个用户
	public List<Role_2NUser> getOneRole2NUsers();


}
