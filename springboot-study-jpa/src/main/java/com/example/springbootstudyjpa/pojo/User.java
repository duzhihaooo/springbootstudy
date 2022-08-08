package com.example.springbootstudyjpa.pojo;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {

	@Id
	private Integer id;
	private String user_name;
	
	
	
}
