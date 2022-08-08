package com.example.springbootstudyjpa.pojo;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Role {
	
	@Id
	private Integer id;
	private String role_name;
	
	private Integer user_id;

}
