package com.example.springbootstudymybatis.controller;

import com.example.springbootstudymybatis.pojo.Role;
import com.example.springbootstudymybatis.pojo.Role_2NUser;
import com.example.springbootstudymybatis.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	//查找指定角色
	@RequestMapping(value = "getRoleInfo",method = RequestMethod.GET)
	public Role getRoleInfo(){
		return roleService.getRoleInfo(6);
	}
	
	//删除角色
	@RequestMapping(value = "/deleteRole",method = RequestMethod.GET)
	public String deleteRole(){
		int result = roleService.deleteRole(2);
		if (result >= 1){
			return "删除成功";
		} else {
			return "删除失败";
		}
	}
	
	//新增角色
	@RequestMapping(value = "/addRole",method = RequestMethod.GET)
	public String addRole(){
		Role role = new Role();
		role.setRoleName("Cop");
		roleService.addRole(role);
		return "添加成功：" + role;
	}
	
	//修改角色
	@RequestMapping(value = "/updateRole",method = RequestMethod.GET)
	public String updateRole(){
		Role role = new Role();
		role.setId(5);
		role.setRoleName("BusinessMan");
		int result = roleService.updateRole(role);
		if (result >= 1){
			return "修改成功:" + role;
		} else {
			return "修改失败";
		}
	}
	
	//查询所有角色信息
	@RequestMapping(value = "/getAllRole",method = RequestMethod.GET)
	public List<Role> getAllRole(){
		return roleService.getAllRole();
	}
	
	//查找一个角色对应多个用户
	@RequestMapping(value = "/getOneRole2NUsers",method = RequestMethod.GET)
	public List<Role_2NUser> getOneRole2NUsers(){
		return roleService.getOneRole2NUsers();
	}
	
	
	
}