package com.example.springbootstudyjpa.controller;

import com.example.springbootstudyjpa.pojo.UserRole;
import com.example.springbootstudyjpa.service.UserRoleService;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-role")
public class UserRoleController {
    @Resource
    UserRoleService userRoleService;
    
    /**
     * 根据id 得到用户角色关系
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserRole getUserRoleInfo(@PathVariable int id) {
        return userRoleService.getUserRoleInfo(id);
    }
    
    /**
     * 查找所有用户角色关系
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<UserRole> getAllUserRole() {
        return userRoleService.getAllUserRole();
    }
    
    /**
     * 删除指定用户角色关系
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUserRole(@PathVariable int id) {
        userRoleService.deleteUserRole(id);
    }
    
    /**
     * 新增用户角色关系
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public UserRole addUserRole(@RequestBody UserRole userRole) {
        return userRoleService.addUserRole(userRole);
    }
    
    /**
     * 修改用户角色关系
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void updateUserRole(@RequestBody UserRole userRole) {
        userRoleService.updateUserRole(userRole);
    }

}