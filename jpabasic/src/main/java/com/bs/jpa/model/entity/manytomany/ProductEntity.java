package com.bs.jpa.model.entity.manytomany;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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

@Entity
@Table(name = "PRODUCT_HSW")
@SequenceGenerator(name = "seqProductNo", sequenceName = "seq_product_no_bs", allocationSize = 1, initialValue = 1)
public class ProductEntity {
	@Id
	@GeneratedValue(generator = "seqProductNo", strategy = GenerationType.SEQUENCE)
	private Long productNo;

	private String productName;
	private Integer price;
	private double discount;

//	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//	@JoinTable(name = "product_customer_hsw", joinColumns = @JoinColumn(name = "product_ref"), inverseJoinColumns = @JoinColumn(name = "customer_ref"))
	@OneToMany(mappedBy="product")
	private List<CartEntity> customers;
}
