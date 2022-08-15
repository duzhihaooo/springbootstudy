package com.example.springbootstudyjpa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User2NRoles {
	private Integer id;
	private String userName;
	List<Role> roleList;
}
