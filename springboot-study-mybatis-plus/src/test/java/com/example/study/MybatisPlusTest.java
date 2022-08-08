package com.example.study;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.study.demo.Role;
import com.example.study.demo.User;
import com.example.study.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusTest {
	
	@Autowired
	private UserMapper userMapper;
	User user;
	
	@Test
	public void testSelectTest01(){
		List<User> list = userMapper.selectList(null);
		
		list.forEach(System.out::println);
	}
	
	
	
	
}
