package com.example.springbootstudymybatis.dao;

import com.example.springbootstudymybatis.pojo.User;
import com.example.springbootstudymybatis.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleDao {
	
	//查询指定用户角色对应关系
	UserRole getUserRoleInfo(int id);
	//删除用户角色对应关系
	int deleteUserRole(int id);
	//新增用户角色对应关系
	int addUserRole(UserRole userRole);
	//修改用户角色对应关系
	int updateUserRole(UserRole userRole);
	//查询所有用户角色对应关系信息
	List<UserRole> getAllUserRole();
	
	
	//通过uid拿到rid
	List<UserRole> getRoleIdListByUserId(int id);
	
	//通过rid拿到uid
	List<UserRole> getUserIdListByRoleId(int id);
	
	
}
