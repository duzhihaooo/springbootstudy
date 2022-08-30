package com.example.springbootstudymybatis.controller;

import com.example.springbootstudymybatis.pojo.User;
import com.example.springbootstudymybatis.pojo.User2NRoles;
import com.example.springbootstudymybatis.service.UserRoleService;
import com.example.springbootstudymybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	/**
	 * 添加user的同时添加role
	 * 在userRole中实施关联
	 */
	@RequestMapping(value = "/add-user-add-role",method = RequestMethod.POST)
	public User2NRoles addUserAddRole(@RequestBody User2NRoles user2NRoles){
		return userRoleService.addUserAddRole(user2NRoles);
	}
	
	
	
	/**
	 * 根据id 查找用户
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public User getUserInfo(@PathVariable int id){
		
		return userService.getUserInfo(id);
	}
	/**
	 * 查询所有用户信息
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public List<User> getAllUser(){
		List<User> list = userService.getAllUser();
		return list;
	}
	/**
	 * 查找一个用户对应多个角色
	 * @return
	 */
	@RequestMapping(value = "/one-user-n-roles",method = RequestMethod.GET)
	public List<User2NRoles> getOneUser2NRoles(){
		return userService.getOneUser2NRoles();
	}
	/**
	 * 根据id 删除用户
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable int id){
		int result = userService.deleteUser(id);
		if (result >= 1){
			return "删除成功";
		} else {
			return "删除失败";
		}
	}
	
	/**
	 * 新增用户
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public String addUser(@RequestBody User user){
		int result = userService.addUser(user);
		if (result >= 1){
			return "添加成功:" + user;
		} else {
			return "添加失败";
		}
	}
	
	/**
	 * 根据id 修改用户
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.PUT)
	public String updateUser(@RequestBody User user){
		int result = userService.updateUser(user);
		if(result >= 1 ){
			return "修改成功:"+user;
		} else {
			return "修改失败";
		}
	}
	
	
	
	@RequestMapping(value = {"/hello"})
	public String index() {
		return "hello springbootjpa";
	}
	

}
