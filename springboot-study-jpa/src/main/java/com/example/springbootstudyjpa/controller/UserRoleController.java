package com.example.springbootstudyjpa.controller;

import com.example.springbootstudyjpa.pojo.UserRole;
import com.example.springbootstudyjpa.service.UserRoleService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRoleController {
    @Resource
    UserRoleService userRoleService;
    
    //查找指定id用户角色关系
    @RequestMapping(value = "/getUserRoleInfo", method = RequestMethod.GET)
    public UserRole getUserRoleInfo() {
        return userRoleService.getUserRoleInfo(5);
    }
    
    @RequestMapping(value = "/getUR/{id}", method = RequestMethod.GET)
    public UserRole getUR(@PathVariable int id) {
        return userRoleService.getUserRoleInfo(id);
    }
    
    //删除指定用户角色关系
    @RequestMapping(value = "/deleteUserRole", method = RequestMethod.GET)
    public void deleteUserRole() {
        userRoleService.deleteUserRole(15);
    }
    
    @RequestMapping(value = "/deleteUR", method = RequestMethod.POST)
    public void deleteUR(int id) {
        userRoleService.deleteUserRole(id);
    }
    
    //新增用户角色关系
    @RequestMapping(value = "/addUserRole", method = RequestMethod.GET)
    public UserRole addUserRole() {
        UserRole userRole = new UserRole();
        userRole.setUid(11);
        userRole.setRid(12);
        
        return userRoleService.addUserRole(userRole);
    }
    
    @RequestMapping(value = "/addUR", method = RequestMethod.POST)
    //http://localhost:8080/addUR?id=21&uid=7&rid=2
    public UserRole addUR(UserRole userRole) {
        return userRoleService.addUserRole(userRole);
    }
    
    //修改用户角色关系
    @RequestMapping(value = "/updateUserRole", method = RequestMethod.GET)
    public void updateUserRole() {
        UserRole userRole = new UserRole();
        userRole.setId(19);
        userRole.setUid(1);
        userRole.setRid(9);
        userRoleService.updateUserRole(userRole);
    }
    
    @RequestMapping(value = "/updateUR", method = RequestMethod.POST)
    //http://localhost:8080/updateUR?id=21&uid=7&rid=2
    public void updateUR(UserRole userRole) {
        userRoleService.updateUserRole(userRole);
    }
    
    //查找所有用户角色关系
    @RequestMapping(value = "/getAllUserRole", method = RequestMethod.GET)
    public List<UserRole> getAllUserRole() {
        return userRoleService.getAllUserRole();
    }
}