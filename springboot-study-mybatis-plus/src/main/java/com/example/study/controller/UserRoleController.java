package com.example.study.controller;

import com.example.study.demo.UserRole;
import com.example.study.service.UserRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user-role")
public class UserRoleController {
	
	@Resource
	UserRoleService userRoleService;
	
	/**
	 * 查找所有用户角色对应表
	 * @return
	 */
	@RequestMapping(value = "",method = RequestMethod.GET)
	public List<UserRole> listUserRole(){
		return userRoleService.listUserRole();
	}
	
	/**
	 * 添加用户角色对应关系
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public UserRole add(@RequestBody UserRole userRole){
		userRoleService.add(userRole);
		return userRole;
	}
	/**
	 * 根据id 删除用户角色对应关系
	 * @return
	 */
	@RequestMapping(value = "、",method = RequestMethod.DELETE)
	public int delete(@PathVariable int id){
		return userRoleService.delete(id);
	}
	
	/**
	 * 根据id 修改用户角色关系
	 * @return
	 */
	@RequestMapping(value = "",method = RequestMethod.PUT)
	public UserRole update(@RequestBody UserRole userRole){
		userRoleService.update(userRole);
		return userRole;
	}
	
	
}
