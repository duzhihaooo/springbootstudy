package com.example.springbootstudyjpa.controller;

import com.example.springbootstudyjpa.pojo.User;
import com.example.springbootstudyjpa.pojo.User2NRoles;
import com.example.springbootstudyjpa.service.UserService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Resource
    UserService userService;
    
    // TODO: 2022/8/15 感觉做JPA的时候怪怪的 很多方法返回的是void 就是那种定义好了 你不能用实体类去接收他们
    //查找用户
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public User getUserInfo() {
        return userService.getUserInfo(19);
    }
    
    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    //http://localhost:8080/getUser/19
    public User getUser(@PathVariable int id) {
        return userService.getUserInfo(id);
    }
    
    //删除用户
    @RequestMapping(value = "/deleteUserInfo", method = RequestMethod.GET)
    public void deleteUserInfo() {
        userService.deleteUser(21);
    }
    
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    //http://localhost:8080/deleteUser?id=24
    public void deleteUser(int id) {
        userService.deleteUser(id);
    }
    
    //新增用户
    @RequestMapping(value = "/addUserInfo", method = RequestMethod.GET)
    public void addUserInfo() {
        User user = new User();
        user.setId(21);     //todo:设置id为固定值添加时，数据库中增加的数据id不对，可能时实体类中id自增的原因吗
        user.setUserName("Kristen");
        userService.addUser(user);
    }
    
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    //http://localhost:8080/insertUser?id=25&userName=Kristen   todo:如何在浏览器实现post请求
    public User insertUser(User user) {
        return userService.addUser(user);
    }
    
    //修改用户
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.GET)
    public void updateUserInfo() {
        User user = new User();
        user.setId(21);
        user.setUserName("Kristen");
        userService.updateUser(user);
    }
    
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    //http://localhost:8080/updateUser?id=17&userName=Minnie
    public void updateUser(User user) {
        userService.updateUser(user);
    }
    
    //查询所有用户信息
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
    
    //Repository接口方法名称命名查询
    @RequestMapping(value = "/findByUserName", method = RequestMethod.GET)
    public List<User> findByUserName() {
        List<User> list = userService.findByUserName("Justhis");
        return list;
    }
    
    @RequestMapping(value = "/findByUN", method = RequestMethod.POST)
    public List<User> findByUN(String str) {
        return userService.findByUserName(str);
    }
    
    //Repository接口方法名称命名查询
    @RequestMapping(value = "/findByUserNameLike", method = RequestMethod.GET)
    public List<User> findByUserNameLike() {
        List<User> list = userService.findByUserNameLike("K%");
        return list;
    }
    
    @RequestMapping(value = "/findByUNLike", method = RequestMethod.POST)
    public List<User> findByUNLike(String str) {
        return userService.findByUserNameLike(str);
    }
    //todo:这个功能实现不了
    
    //查询一个用户对应多个角色
    @RequestMapping(value = "/findUser2NRoles", method = RequestMethod.GET)
    public List<User2NRoles> findUser2NRoles() {
        return userService.findUser2NRoles();
    }
    
}