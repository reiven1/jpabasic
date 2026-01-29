package com.bs.jpa.model.entity.manytomany;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "CART_HSW")
@SequenceGenerator(name = "seqCartno", sequenceName = "seq_cartno", allocationSize = 1, initialValue = 1)
public class CartEntity {
	@Id
	@GeneratedValue(generator = "seqCartno", strategy = GenerationType.SEQUENCE)
	private Long cartNo;
	
	
	private Integer proCount;
	
	@Temporal(TemporalType.DATE)
	private LocalDate proDate;

	@ManyToOne
	@JoinColumn(name="customer_ref")
	private CustomerEntity customer;
	
	@ManyToOne
	@JoinColumn(name="product_ref")
	private ProductEntity product;

}
