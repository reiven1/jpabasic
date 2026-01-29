package com.bs.jpa.model.entity.compose;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentLessonComposeKey implements Serializable{
	
	private static final long serialVersionUID = 195164679224380548L;
	
	private Long student;
	private Long lesson;
	private String year;
	private String term;
}
