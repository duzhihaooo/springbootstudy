package com.example.springbootstudyjpa.dao;

import com.example.springbootstudyjpa.pojo.User;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 *  Repository接口方法名称命名查询
 */
public interface UsersRepositoryByName extends Repository<User,Integer> {
	//方法名称必须要遵循驼峰式命名规则，findBy（关键字）+属性名称（首字母大写）+查询条件（首字母大写）
	List<User> findByUserName(String name);
	List<User> findByUserNameLike(String name);
	
}
