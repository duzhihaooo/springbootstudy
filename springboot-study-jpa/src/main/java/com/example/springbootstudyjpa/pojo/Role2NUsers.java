package com.example.springbootstudyjpa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role2NUsers {
	private Integer id;
	private String roleName;
	List<User> userList;
}
