package com.example.springbootstudymybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole extends User{

	private Integer id;
	private Integer userId;
	private Integer roleId;

}
