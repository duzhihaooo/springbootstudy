package com.example.study.controller;

import com.example.study.demo.OneUser2NRoles;
import com.example.study.demo.User;
import com.example.study.demo.UserRole;
import com.example.study.service.UserRoleService;
import com.example.study.service.UserService;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private UserRoleService userRoleService;
    
    /**
     * 1.查询所有用户
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> userList(){
        return userService.listUser();
    }
    
    /**
     * 2.查询一个用户对应多个角色
     * @return
     */
    @RequestMapping(value = "one-user-n-roles",method = RequestMethod.GET)
    private List<OneUser2NRoles> getOneUser2NRoles(){
        return userService.getOneUser2NRoles();
    }
    
    /**
     * 添加user的同时添加role
     * 在userRole中实施关联
     */
    @RequestMapping(value = "/add-user-add-role",method = RequestMethod.POST)
    public OneUser2NRoles addUserAddRole(@RequestBody OneUser2NRoles oneUser2NRoles){
        
        return userRoleService.addUserAddRole(oneUser2NRoles);
    }
    


    
    /**
     * 添加一个用户
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        int re = userService.add(user);
        if (re >= 1){
            return "添加成功：" + user ;
        } else {
            return "添加失败";
        }
    }
    /**
     * 根据id 修改用户
     * @param user  用户信息
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.PUT)
    private User update(@RequestBody User user){
        userService.update(user);
        return user;
    }
    
    /**
     * 根据id 删除用户
     *
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.DELETE)
    private int delete(@PathVariable int id){
        return userService.delete(id);
    }

}