package com.example.study.controller;

import com.example.study.demo.OneRoles2NUser;
import com.example.study.demo.OneUser2NRoles;
import com.example.study.demo.Role;
import com.example.study.demo.User;
import com.example.study.service.RoleService;
import com.example.study.service.UserService;
import java.util.List;
import java.util.Objects;
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
    @RequestMapping(value = "get-oneUser-2NRoles",method = RequestMethod.GET)
    private List<OneUser2NRoles> getOneUser2NRoles(){
        System.out.println(" ");
        return userService.getOneUser2NRoles();
    }
    
    //添加一个用户
    @RequestMapping(value = "add",method = RequestMethod.GET)
    
    //为什么是用Object？ 因为是添加的一个对象原因吗？ String那里的含义！ 因为只是回复的是一条数据吗
    private Object add(String msg){
        User user1 = new User();
        //数据库中已经设置id为主键，不是传数据进去会自增吗
        //我不传setId的话 会报错
        //user1.setId(15L);
        //我在实体类User中添加了 @TableId(type = IdType.AUTO) 好像就实现了自动添加id功能，但我单独添加@TableId时却不默认id为主键
        user1.setUserName("Taylor");
        int row = userService.add(user1);
        
        return user1;
    }
    
    //修改一个用户
    @RequestMapping(value = "update",method = RequestMethod.GET)
    private Object update(String msg){
        User user = new User();
        user.setId(11L);
        user.setUserName("7kk");
        
        int row = userService.update(user);
        return user;
    }
    
    //删除一个用户
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    private Object delete(String msg){
        User user = new User();
        user.setId(15L);
        userService.delete(user);
        return userService.listUser();
    }

    @RequestMapping(value = { "/hello", "/hello-a" }, method = RequestMethod.GET)
    public String index() {
        return "hello springboot";
    }
}