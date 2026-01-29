package com.bs.jpa.model.entity.compose;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "choiselesson_hsw")
public class ChoiseLesson {
	@Id
	@ManyToOne
	@JoinColumn(name = "student_ref")
	private StudentEntity2 student;
	@Id
	@ManyToOne
	@JoinColumn(name = "lesson_ref")
	private LessonEntity2 lesson;
	@Id
	private String year;
	@Id
	private String term;
	
}
