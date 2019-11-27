package com.neuedu.ssm_shop.pojo;


import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4368808849344238299L;
	private Integer id;
	private String userName;
	private String userPassword;
	private String userPhone;
	private String userAddr;
	private Timestamp userRdate;
	public User(String userName, String userPassword, String userPhone, String userAddr) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userAddr = userAddr;
	}
	
	
}
