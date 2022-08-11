package com.example.study.demo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
		@TableId(type = IdType.AUTO)
		private Long id;
	
		@TableField("user_name")
		private String userName;
		
	
	
		
		
	
}