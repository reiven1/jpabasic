package com.bs.jpa.model.entity.onetomany;

import java.util.ArrayList;
import java.util.List;

import com.bs.jpa.common.Local;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "DEPARTMENT_HSW")
@SequenceGenerator(name = "seq_deptno", sequenceName = "seq_dept_hsw", allocationSize = 1, initialValue = 1)
public class DepartmentEntity {
	@Id
	@GeneratedValue(generator = "seq_deptno", strategy = GenerationType.SEQUENCE)
	private Long deptNo;

	private String deptName;

	@Enumerated(EnumType.STRING)
	private Local localName;
	
	@OneToMany(mappedBy="dept")
	private List<EmployeeEntity> employees = new ArrayList<>();
}
