package com.example.springbootstudymybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	
	private Long id;
	private String role_name;
	private Integer user_id;
	
	
}
