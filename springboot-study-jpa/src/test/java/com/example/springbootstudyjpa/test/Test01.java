package com.example.springbootstudyjpa.test;

import com.example.springbootstudyjpa.service.UserDbService;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test01 {
    
    @Resource
    UserDbService userService;
    
    @Test
    public void test01() {
        //User user = userService.getUserInfo(1);
        userService.deleteUser(20);
        
    }
    
}