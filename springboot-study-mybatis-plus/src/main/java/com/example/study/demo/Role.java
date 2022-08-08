package com.example.study.demo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

@Data
public class Role {
	
	private Long id;
	
	//指定属性所对应的字段名
	//@TableField("role_name")
	private String role_name;
	
	//指定属性所对应的字段名
	//@TableField("user_id")
	private Integer user_id;
	
	
	
}
