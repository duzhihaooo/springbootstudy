package com.example.springbootstudymybatis.controller;

import com.example.springbootstudymybatis.pojo.UserRole;
import com.example.springbootstudymybatis.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-role")
public class UserRoleController {
	@Autowired
	UserRoleService userRoleService;
	
	/**
	 * 查询指定用户角色对应关系
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public UserRole getUserRoleInfo(@PathVariable int id){
		
		return userRoleService.getUserRoleInfo(id);
	}
	/**
	 * 查询所有用户角色对应关系信息
	 * @return
	 */
	//todo:查询结果有一个userName字段 没找出哪里来的
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public List<UserRole> getAllUserRole(){
		return userRoleService.getAllUserRole();
	}
	
	/**
	 * 根据id 删除用户角色对应关系
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.DELETE)
	public String deleteUserRole(@PathVariable int id){
		int result = userRoleService.deleteUserRole(id);
		if (result >= 1){
			return "删除成功";
		} else {
			return "删除失败";
		}
	}
	
	/**
	 * 新增用户角色对应关系
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public String  addUserRole(@RequestBody UserRole userRole){
		userRoleService.addUserRole(userRole);
		return "添加用户角色对应关系成功：" + userRole;
	}
	
	/**
	 * 修改用户角色对应关系
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.PUT)
	public String updateUserRole(@RequestBody UserRole userRole){
		int result = userRoleService.updateUserRole(userRole);
		if (result >= 1){
			return "修改成功：" + userRole;
		} else {
			return "修改失败！";
		}
	}
	
}
