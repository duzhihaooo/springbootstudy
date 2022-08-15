package com.example.springbootstudyjpa.controller;

import com.example.springbootstudyjpa.pojo.User;
import com.example.springbootstudyjpa.pojo.User2NRoles;
import com.example.springbootstudyjpa.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
	@Resource
	UserService userService;
	
	// TODO: 2022/8/15 感觉做JPA的时候怪怪的 很多方法返回的是void 就是那种定义好了 你不能用实体类去接收他们 
	//查找用户
	@RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
	public User getUserInfo(){
		return userService.getUserInfo(19);
	}
	//删除用户
	@RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
	public void deleteUser(){
		 userService.deleteUser(20);
	}
	 //新增用户
	@RequestMapping(value = "/addUser",method = RequestMethod.GET)
	public void addUser(){
		User user = new User();
		user.setUserName("Kristen");
		userService.addUser(user);
	}
	//修改用户
	@RequestMapping(value = "/updateUser",method = RequestMethod.GET)
	public void updateUser(){
		User user = new User();
		user.setId(19);
		user.setUserName("Justhis");
		userService.updateUser(user);
	}
	//查询所有用户信息
	@RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	//Repository接口方法名称命名查询
	@RequestMapping(value = "/findByUserName",method = RequestMethod.GET)
	public List<User> findByUserName(){
		List<User> list = userService.findByUserName("Justhis");
		return list;
	}
	//Repository接口方法名称命名查询
	@RequestMapping(value = "/findByUserNameLike",method = RequestMethod.GET)
	public List<User> findByUserNameLike(){
		List<User> list = userService.findByUserNameLike("K%");
		return list;
	}
	//基于@Query注解查询
	@RequestMapping(value = "/queryByNameUseSQL",method = RequestMethod.GET)
	public List<User> queryByNameUseSQL(){
		List<User> list = userService.queryByNameUseSQL("Justhis");
		return list;
	}
	/*
	//基于@Query注解更新
	@RequestMapping(value = "/updateUsersNameById",method = RequestMethod.GET)
	public void updateUsersNameById(){
		userService.updateUsersNameById("Kid Mili","19");
	}
	*/
	
	//查询一个用户对应多个角色
	@RequestMapping(value = "/findUser2NRoles",method = RequestMethod.GET)
	public List<User2NRoles> findUser2NRoles(){
		return userService.findUser2NRoles();
	}

}
