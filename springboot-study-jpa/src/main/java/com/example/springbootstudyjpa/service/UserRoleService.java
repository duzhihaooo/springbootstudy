package com.example.springbootstudyjpa.service;

import com.example.springbootstudyjpa.pojo.User;
import com.example.springbootstudyjpa.pojo.UserRole;

import java.util.List;

public interface UserRoleService {
	/**
	 * 查找指定id用户角色关系
	 * @param id    用户角色id
	 */
	public UserRole getUserRoleInfo(int id);
	/**
	 *  删除指定用户角色关系
	 * @param id    用户角色id
	 */
	public void deleteUserRole(int id);
	/**
	 *  新增用户角色关系
	 * @param userRole  用户角色关系信息
	 */
	public UserRole addUserRole(UserRole userRole);
	
	/**
	 * 修改用户角色关系
	 * @param userRole  用户角色关系信息
	 */
	public void updateUserRole(UserRole userRole);
	
	/**
	 * 查找所有用户角色关系
	 */
	public List<UserRole> getAllUserRole();
	
	//通过传入的rid拿到对应的uid
	public List<Integer> findRidByUid(int id);
	//通过传入的uid拿到对应的rid
	public List<Integer> findUidByRid(int id);
}
