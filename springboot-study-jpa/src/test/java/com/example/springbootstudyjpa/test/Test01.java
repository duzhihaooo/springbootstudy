package com.example.springbootstudyjpa.test;

import com.example.springbootstudyjpa.dao.UserRepository;
import com.example.springbootstudyjpa.dao.UserRoleRepository;
import com.example.springbootstudyjpa.pojo.User;
import com.example.springbootstudyjpa.pojo.User2NRoles;
import com.example.springbootstudyjpa.service.UserDbService;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Test01 {
    
    @Resource
    UserDbService userService;
    @Resource
    UserRoleRepository userRoleRepository;
    @Test
    public void test01() {
    
       /* List<User2NRoles> list_ur = new ArrayList<>();
        for (User user:userService.getAllUser()){
            User2NRoles user2NRoles = new User2NRoles();
            user2NRoles.setId(user.getId());
            user2NRoles.setUserName(user.getUserName());
            List<Integer> roleIdList = userRoleRepository.findRidByUid(user2NRoles.getId());
            
            
            */
            
        }
    
    
    @Test
    public void test02(){
        List<Integer> list = userRoleRepository.findRidByUid(1);
        System.out.println(list);
    }
    
}