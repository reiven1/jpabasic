package com.bs.jpa.model.entity.compose;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "LESSON2_HSW")
@SequenceGenerator(name = "seqlessonno", sequenceName = "seqlessonno", allocationSize = 1, initialValue = 1)
public class LessonEntity2 {
	@Id
	@GeneratedValue(generator = "seqlessonno", strategy = GenerationType.SEQUENCE)
	private Long lessonNo;
	private String lessonName;
	private Integer lessonCost;

	@OneToMany(mappedBy = "lesson")
	private List<ChoiseLesson> student = new ArrayList<>();
}
