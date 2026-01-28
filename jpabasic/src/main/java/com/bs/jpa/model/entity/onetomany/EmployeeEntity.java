package com.bs.jpa.model.entity.onetomany;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "EMPLOYEE_HSW")
@SequenceGenerator(name = "seq_empno", sequenceName = "seq_empno_hsw", allocationSize = 1, initialValue = 1)
public class EmployeeEntity {
	@Id
	@GeneratedValue(generator = "seq_empno", strategy = GenerationType.SEQUENCE)
	private Long empNo;

	private String empName;
	private String empAge;
	private String empAddress;
	private double empBonus;
	private int empSalary;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="dept_code")
	private DepartmentEntity dept;
	
	public void setDept(DepartmentEntity dept) {
		if(dept.getEmployees()==null) {
			dept.setEmployees(new ArrayList<>());
		}
		if(!dept.getEmployees().contains(this)) {
			dept.getEmployees().add(this);
		}
		dept.getEmployees().add(this);
		this.dept = dept;
	}
}
