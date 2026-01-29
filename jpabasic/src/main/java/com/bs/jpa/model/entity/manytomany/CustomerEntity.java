package com.bs.jpa.model.entity.manytomany;

import java.util.ArrayList;
import java.util.List;

import com.bs.jpa.common.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "CUSTOMER_HSW")
@SequenceGenerator(name = "seqCusno", sequenceName = "seqCusno", allocationSize = 1, initialValue = 1)
public class CustomerEntity {
	@Id
	@GeneratedValue(generator = "seqCusno", strategy = GenerationType.SEQUENCE)
	private Long customerNo;
	private String customerName;
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	private Integer age;
	private String address;
	
	@ToString.Exclude
//	@ManyToMany(mappedBy = "customers")
	@OneToMany(mappedBy="customer")
	private List<CartEntity> products = new ArrayList<>();
}
