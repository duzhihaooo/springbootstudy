package com.example.springbootstudymybatis.service;

import com.example.springbootstudymybatis.pojo.User;
import com.example.springbootstudymybatis.pojo.UserRole;

import java.util.List;

public interface UserRoleService {
	
	//查询指定用户角色对应关系
	public UserRole getUserRoleInfo(int id);
	//删除用户角色对应关系
	public int deleteUserRole(int id);
	//新增用户角色对应关系
	public int addUserRole(UserRole userRole);
	//修改用户角色对应关系
	public int updateUserRole(UserRole userRole);
	//查询所有用户角色对应关系信息
	public List<UserRole> getAllUserRole();
	
	//通过uid拿到rid
	public List<Integer> getRoleIdListByUserId(int id);
	//通过rid拿到uid
	public List<Integer> getUserIdListByRoleId(int id);
	
}
