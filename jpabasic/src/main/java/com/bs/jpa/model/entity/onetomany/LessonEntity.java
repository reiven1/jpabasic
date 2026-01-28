package com.bs.jpa.model.entity.onetomany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
import lombok.ToString;

@Data@AllArgsConstructor@NoArgsConstructor@Builder

@Entity
@Table(name="LESSON_HSW")
@SequenceGenerator(name="seqLessonNo",sequenceName = "SEQ_LESSONNO_HSW", 
	initialValue = 1, allocationSize = 1)
public class LessonEntity {

	@Id
	@GeneratedValue(generator = "seqLessonNo",strategy = GenerationType.SEQUENCE)
	private Long lessonNo;
	
	@Column(unique=true)
	private String lessonTitle;

	private String lessonContent;
	
	private String location;
	
	@ToString.Exclude
	@Builder.Default
	@OneToMany(mappedBy="lesson",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<StudentEntity> students=new ArrayList<>();
	
	public void setStudents(List<StudentEntity> students) {
		if(this.students.size()>0) {
			this.students.forEach(s->s.setLesson(null));
		}
		for(StudentEntity student : students) {
			student.setLesson(this);
		}
		this.students=students;
	}
	
	
}
