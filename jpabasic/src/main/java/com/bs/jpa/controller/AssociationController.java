package com.bs.jpa.controller;

import com.bs.jpa.model.entity.onetomany.DepartmentEntity;
import com.bs.jpa.model.entity.onetomany.EmployeeEntity;
import com.bs.jpa.model.entity.onetomany.LessonEntity;
import com.bs.jpa.model.entity.onetomany.StudentEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AssociationController {
	public void oneToManyTest(EntityManager em) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		/*
		EmployeeEntity e = EmployeeEntity.builder()
				.empName("하승우")
				.empAge("25")
				.empSalary(10)
				.empBonus(0.005)
				.empAddress("경남 남해")
				.build();
		DepartmentEntity dept = DepartmentEntity.builder()
				.deptName("경비실")
				.localName(Local.AFRICA)
				.build();
		
		e.setDept(dept);
		
		em.persist(e);
		em.persist(dept);
		*/
		EmployeeEntity e = em.find(EmployeeEntity.class, 4L);
		DepartmentEntity d = em.find(DepartmentEntity.class, 1L);
		
		System.out.println(e);
		System.out.println(d);
		
		et.commit();
	}
	
	public void oneToManyTest2(EntityManager em) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		EmployeeEntity e = EmployeeEntity.builder()
				.empName("누구")
				.empAge("1")
				.empSalary(1000)
				.empBonus(0.5)
				.empAddress("경남 남해")
				.build();
		DepartmentEntity d = em.find(DepartmentEntity.class, 1L);
		
		e.setDept(d);
//		d.getEmployees().add(e);
		
		em.persist(e);
		
		System.out.println(e.getDept());
		System.out.println(d.getEmployees());
		
		et.commit();
	}
	
	public void insertTest(EntityManager em) {
		em.getTransaction().begin();
		StudentEntity s=StudentEntity.builder()
				.name("김영호")
				.age(25)
				.address("경북 구미")
				.grade(4)
				.build();
		StudentEntity s3=StudentEntity.builder()
				.name("신동호")
				.age(26)
				.address("경남 창원")
				.grade(5)
				.build();
		StudentEntity s1=StudentEntity.builder()
				.name("황지한")
				.age(25)
				.address("서울시 강서구")
				.grade(4)
				.build();
		StudentEntity s2=StudentEntity.builder()
				.name("김태련")
				.age(23)
				.address("서울시 중랑구")
				.grade(4)
				.build();
		
		em.persist(s);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		
		LessonEntity l=LessonEntity.builder()
				.lessonTitle("이건 첫번째 레슨")
				.lessonContent("유노윤호의 레슨")
				.location("3강의장")
				.build();
		
		LessonEntity l2=LessonEntity.builder()
				.lessonTitle("이건 두번째 레슨")
				.lessonContent("유노윤호의 레슨2")
				.location("4강의장")
				.build();
		
		s.setLesson(l);
		s1.setLesson(l);
		s2.setLesson(l);
		s3.setLesson(l2);
		
		em.getTransaction().commit();
		
	}
	
	public void removeStudent(EntityManager em, Long studentNo) {
		em.getTransaction().begin();;
		StudentEntity s = em.find(StudentEntity.class, studentNo);
		em.remove(s);
		em.getTransaction().commit();
	}
	
	public void removeLesson(EntityManager em, Long lessonNo) {
		em.getTransaction().begin();;
		LessonEntity l = em.find(LessonEntity.class, lessonNo);
		em.remove(l);
		em.getTransaction().commit();
	}
	
	public void searchData(EntityManager em) {
		StudentEntity s = em.find(StudentEntity.class, 5L);
//		System.out.println(s);
		System.out.println(s.getName());
//		System.out.println(s.getLesson());
		
		LessonEntity l = em.find(LessonEntity.class, 3L);
		
	}
}
