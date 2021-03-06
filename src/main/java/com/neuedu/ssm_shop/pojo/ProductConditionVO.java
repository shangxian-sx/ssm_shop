package com.neuedu.ssm_shop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductConditionVO {
	private String keywords;
	private Category category;
	private String startDate;
	private String endDate;
	private Double lowPrice;
	private Double highPrice;
}
