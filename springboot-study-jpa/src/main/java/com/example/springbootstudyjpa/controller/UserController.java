package com.example.springbootstudyjpa.controller;

import com.example.springbootstudyjpa.pojo.User;
import com.example.springbootstudyjpa.pojo.User2NRoles;
import java.util.List;
import javax.annotation.Resource;

import com.example.springbootstudyjpa.service.UserDbService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserDbService userService;
    
    // TODO: 2022/8/15 感觉做JPA的时候怪怪的 很多方法返回的是void 就是那种定义好了 你不能用实体类去接收他们
    
    /**
     * 根据id 获取user
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        return userService.getUserInfo(id);
    }
    
    /**
     * 查询所有用户信息
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
    
    /**
     * Repository接口方法名称命名查询
     * @return
     */
    @RequestMapping(value = "/user-name/{name}", method = RequestMethod.GET)
    public List<User> findByUserName(@PathVariable("name") String name) {
        return userService.findByUserName(name);
    }
    @RequestMapping(value = "/user-name-like/{name}", method = RequestMethod.POST)
    public List<User> findByUNLike(@PathVariable("name") String name) {
        return userService.findByUserNameLike(name);
    }
    //todo:这个功能实现不了
    
    /**
     * 查询一个用户对应多个角色
     * @return
     */
    @RequestMapping(value = "/one-user-n-roles", method = RequestMethod.GET)
    public List<User2NRoles> findUser2NRoles() {
        return userService.findUser2NRoles();
    }
    
    /**
     * 根据id 删除用户
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUserInfo(@PathVariable int id) {
        userService.deleteUser(id);
    }
    
    /**
     * 新增用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User addUserInfo(@RequestBody User user) {
        return userService.addUser(user);
    }
    
    /**
     * 根据id，修改用户
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void updateUserInfo(@RequestBody User user) {
        userService.updateUser(user);
    }
    
    
}