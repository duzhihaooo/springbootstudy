package com.example.springbootstudyjpa.service;

import com.example.springbootstudyjpa.pojo.Role;
import com.example.springbootstudyjpa.pojo.Role2NUsers;
import com.example.springbootstudyjpa.pojo.User;

import java.util.List;

public interface RoleService {
	/**
	 * 查找角色
	 * @param id    用户id
	 */
	public Role getRoleInfo(int id);
	/**
	 * 删除角色
	 * @param id    删除id
	 */
	public void deleteRole(int id);
	/**
	 * 新增角色
	 * @param role  角色信息
	 */
	public Role addRole(Role role);
	/**
	 * 修改角色
	 * @param role  角色信息
	 */
	public void updateRole(Role role);
	/**
	 *查询所有角色信息
	 */
	public List<Role> getAllRole();
	/**
	 * Repository接口方法名称命名查询
	 */
	public List<Role> findByRoleName(String name);
	public List<Role> findByRoleNameLike(String name);
	/**
	 * 基于@Query注解查询
	 */
	public List<Role> queryByRoleName(String name);
	
	public Role getRolebyId(int id);
	
	//查询一个角色对应多个用户
	public List<Role2NUsers> findRole2NUsers();
}
