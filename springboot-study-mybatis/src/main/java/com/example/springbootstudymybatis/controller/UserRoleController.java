package com.example.springbootstudymybatis.controller;

import com.example.springbootstudymybatis.pojo.UserRole;
import com.example.springbootstudymybatis.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRoleController {
	@Autowired
	UserRoleService userRoleService;
	
	//查询指定用户角色对应关系
	@RequestMapping(value = "/getUserRoleInfo",method = RequestMethod.GET)
	public UserRole getUserRoleInfo(){
		return userRoleService.getUserRoleInfo(5);
	}
	
	//删除用户角色对应关系
	@RequestMapping(value = "/deleteUserRole",method = RequestMethod.GET)
	public String deleteUserRole(){
		int result = userRoleService.deleteUserRole(2);
		if (result >= 1){
			return "删除成功";
		} else {
			return "删除失败";
		}
	}
	
	//新增用户角色对应关系
	@RequestMapping(value = "/addUserRole",method = RequestMethod.GET)
	public String  addUserRole(){
		UserRole userRole = new UserRole();
		//userRole.setId(16);
		userRole.setUserId(10);
		userRole.setRoleId(10);
		userRoleService.addUserRole(userRole);
		return "添加用户角色对应关系成功：" + userRole;
	}
	
	//修改用户角色对应关系
	@RequestMapping(value = "/updateUserRole",method = RequestMethod.GET)
	public String updateUserRole(){
		UserRole userRole = new UserRole();
		userRole.setId(14);
		userRole.setUserId(9);
		userRole.setRoleId(9);
		int result = userRoleService.updateUserRole(userRole);
		
		if (result >= 1){
			return "修改成功：" + userRole;
		} else {
			return "修改失败！";
		}
	}
	
	//查询所有用户角色对应关系信息
	@RequestMapping(value = "/getAllUserRole",method = RequestMethod.GET)
	public List<UserRole> getAllUserRole(){
		return userRoleService.getAllUserRole();
	}

}
