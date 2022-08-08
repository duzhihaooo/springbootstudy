package com.example.study.demo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
		
		private Long id;
	
		@TableField("user_name")
		private String userName;
		
	
	
		
		
	
}