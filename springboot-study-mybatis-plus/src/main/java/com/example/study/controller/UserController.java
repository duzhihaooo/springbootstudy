package com.example.study.controller;

import com.example.study.demo.OneRoles2NUser;
import com.example.study.demo.OneUser2NRoles;
import com.example.study.demo.Role;
import com.example.study.demo.User;
import com.example.study.service.RoleService;
import com.example.study.service.UserService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Resource
    private RoleService roleService;
    @Resource
    private UserService userService;
    
    
    
    @RequestMapping(value = "/list-role", method = RequestMethod.GET)
    private List<Role> listRole() {
        return roleService.listRole();
    }
    
    //需要自己了解加深value与method的用法
    @RequestMapping(value = "/get-roles-user", method = RequestMethod.GET)
    private List<OneRoles2NUser> getRolesUser() {
        //
        return roleService.getRolesUser();
    }
    
    
    
    //查询一个用户对应多个角色
    @RequestMapping(value = "get-oneUser-2NRoles")
    private List<OneUser2NRoles> getOneUser2NRoles(){
        
        return userService.getOneUser2NRoles();
    }
    
    
    @RequestMapping(value = { "/hello", "/hello-a" }, method = RequestMethod.GET)
    public String index() {
        return "hello springboot";
    }
}