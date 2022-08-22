package com.example.springbootstudymybatis.controller;

import com.example.springbootstudymybatis.pojo.Role;
import com.example.springbootstudymybatis.pojo.Role2NUser;
import com.example.springbootstudymybatis.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")    //todo:这里的role不就是和jpa项目中的role冲突了吗
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	/**
	 * 根据id 查找角色
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Role getRoleInfo(@PathVariable int id){
		
		return roleService.getRoleInfo(id);
	}
	
	/**
	 * 查询所有角色信息
	 * @return
	 */
	@RequestMapping(value = "",method = RequestMethod.GET)
	public List<Role> getAllRole(){
		return roleService.getAllRole();
	}
	
	/**
	 * 查找一个角色对应多个用户
	 * @return
	 */
	@RequestMapping(value = "/one-role-n-users",method = RequestMethod.GET)
	public List<Role2NUser> getOneRole2NUsers(){
		
		return roleService.getOneRole2NUsers();
	}
	
	
	/**
	 * 根据id 删除角色
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public String deleteRole(@PathVariable int id){
		int result = roleService.deleteRole(id);
		if (result >= 1){
			return "删除成功";
		} else {
			return "删除失败";
		}
	}
	
	/**
	 * 新增角色
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public String addRole(@RequestBody Role role){
		roleService.addRole(role);
		return "添加成功：" + role;
	}
	
	/**
	 * 修改角色
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.PUT)
	public String updateRole(@RequestBody Role role){
		int result = roleService.updateRole(role);
		if (result >= 1){
			return "修改成功:" + role;
		} else {
			return "修改失败";
		}
	}
	
	
	
}
