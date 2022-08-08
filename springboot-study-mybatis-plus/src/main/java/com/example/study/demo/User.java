package com.example.study.demo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
		
		private Long id;
	
		//指定属性所对应的字段名
		//@TableField("user_name")
		private String user_name;
		
		//与Role的关联
		private Role role;
	
		
		
	
}
