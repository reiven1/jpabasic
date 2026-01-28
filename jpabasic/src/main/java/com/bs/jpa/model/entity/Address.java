package com.bs.jpa.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Embeddable
public class Address {
	
	@Column(name="MEMBER_ZIPCODE")
	private String zipCode;
	
	private String sido;
	private String gungu;
	
}
