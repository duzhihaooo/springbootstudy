package com.example.study.controller;

import com.example.study.demo.OneRoles2NUser;
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
    
    @RequestMapping(value = "/list-user", method = RequestMethod.GET)
    private List<User> listUser() {
        return userService.listUser();
    }
    
    @RequestMapping(value = "/list-role", method = RequestMethod.GET)
    private List<Role> listRole() {
        return roleService.listRole();
    }
    
    @RequestMapping(value = "/get-roles-user", method = RequestMethod.GET)
    private List<OneRoles2NUser> getRolesUser() {
        return roleService.getRolesUser();
    }
    
    @RequestMapping(value = { "/hello", "/hello-a" }, method = RequestMethod.GET)
    public String index() {
        return "hello springboot";
    }
}