package com.example.springbootstudyjpa;

import com.example.springbootstudyjpa.dao.UserRepository;
import java.util.Optional;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class SpringbootStudyJpaApplicationTests {
    
    @Test
    void contextLoads() {
    }
    
    @Autowired
    private UserRepository userRepository;
    
    @Test
    @Transactional(rollbackFor = Exception.class)
    void setUserRepository() {
        System.out.println(userRepository.queryUserNameById(1));
        System.out.println(userRepository.updateUserNameById("aaa", 1));
        System.out.println(userRepository.queryUserNameById(1));
        
    }
    
    @Transactional(rollbackFor = Exception.class)
    @Test
    void setUserRepository2() {
        System.err.println(userRepository.getReferenceById(100));
        
    }
}