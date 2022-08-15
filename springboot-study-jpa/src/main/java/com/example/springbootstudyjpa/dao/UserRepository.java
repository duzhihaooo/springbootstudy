package com.example.springbootstudyjpa.dao;

import com.example.springbootstudyjpa.pojo.Role;
import com.example.springbootstudyjpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	//基于@Query注解查询与更新
	@Query(value = "select * from user where user_name = ?",nativeQuery = true)
	List<User> queryByNameUseSQL(String name);
	/*
	//用来表示修改操作
	@Modifying      todo:不太了解事务回滚，所以实现不了基于@Query注解的更新  @Transactional
	@Query(value = "UPDATE user SET name = ?1 WHERE id = ?2",nativeQuery = true)
	void updateUsersNameById(String name,String id);
	*/
	
	@Query(value = "select * from user where id = ?",nativeQuery = true)
	User getUserbyId(int id);

}
