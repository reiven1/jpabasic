package com.bs.jpa.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//@Entity
//@Table(name = "BASICENTITY_HSW")
//@SequenceGenerator(name = "seqBasicNo", sequenceName = "seq_member_no_HSW", initialValue = 10, allocationSize = 1)
public class BasicEntity {
	// pk 설정을 무조건 해줘야함
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqBasicNo")
	private Long basicNo;

	private String basicName;
	private int account;

	@Column(nullable = true)
	private double weight;
}
