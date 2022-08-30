package com.example.springbootstudymybatis.dao;

import com.example.springbootstudymybatis.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleDao {
	
	//查询指定角色
	Role getRoleInfo(int id);
	
	//删除角色
	
	/**
	 *
	 * @param id id
	 * @return
	 */
	
	int deleteRole(int id);
	
	//新增角色
	int addRole(Role role);
	
	//修改角色
	int updateRole(Role role);
	
	//查询所有角色信息
	List<Role> getAllRole();
	
	void saveRoleGetId(Role role);
	
	
	
}
