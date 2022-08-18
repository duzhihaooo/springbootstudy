package com.example.springbootstudyjpa.dao;

import com.example.springbootstudyjpa.pojo.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    //方法名称必须要遵循驼峰式命名规则，findBy（关键字）+属性名称（首字母大写）+查询条件（首字母大写）
    List<User> findByUserName(String name);
    
    List<User> findByUserNameLike(String name);
    
}