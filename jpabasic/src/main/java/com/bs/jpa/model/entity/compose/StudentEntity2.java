package com.bs.jpa.model.entity.compose;

import java.util.ArrayList;
import java.util.List;

import com.bs.jpa.common.Gender;

import jakarta.persistence.Entity;
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
@Table(name = "STUDENT2_HSW")
@SequenceGenerator(name = "seqstdno", sequenceName = "seqstdno", allocationSize = 1, initialValue = 1)
public class StudentEntity2 {
	@Id
	@GeneratedValue(generator = "seqstdno", strategy = GenerationType.SEQUENCE)
	private Long stdNo;
	private String stdName;
	private Integer stdGrade;
	private Integer stdClass;
	private Integer stdNum;
	private Gender gender;

	@OneToMany(mappedBy = "student")
	private List<ChoiseLesson> lessons = new ArrayList<>();;
}
