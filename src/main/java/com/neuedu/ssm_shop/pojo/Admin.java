package com.neuedu.ssm_shop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	private Integer id;
	private String adminName;
	private String adminPassword;
}
