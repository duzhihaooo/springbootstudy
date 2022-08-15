package com.example.springbootstudyjpa.dao;

import com.example.springbootstudyjpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	//基于@Query注解查询与更新
	//List<User> queryByNameUser(String name);
	/*
	//用来表示修改操作
	@Modifying      todo:不太了解事务回滚，所以实现不了基于@Query注解的更新  @Transactional
	@Query(value = "UPDATE user SET name = ?1 WHERE id = ?2",nativeQuery = true)
	void updateUsersNameById(String name,String id);
	*/
	//HQL :nativeQuery = false
	//SQL :nativeQuery = true
	@Modifying
	@Query(value = "update User set userName=:userName where id=:id")
	//@Query(value = "update user set user_name2=#{userName} where id=#{id}",nativeQuery = true)
	int updateUserNameById(String userName,Integer id);
	

	
	List<User> queryByUserName(String name);
	
	@Query(value = "select userName from User where id=:id")
	String queryUserNameById(Integer id);
	

}