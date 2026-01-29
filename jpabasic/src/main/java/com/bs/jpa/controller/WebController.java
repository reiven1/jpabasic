package com.bs.jpa.controller;

import java.util.List;

import com.bs.jpa.model.entity.WebMemberEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class WebController {
	public void searchMember(EntityManager em, String id) {
		WebMemberEntity member = em.find(WebMemberEntity.class, id);
		System.out.println(member);
	}

	public void searchMemberAll(EntityManager em) {
		String sql = "SELECT m FROM WebMemberEntity m";
		Query query = em.createQuery(sql);
		List<WebMemberEntity> members = query.getResultList();
		members.forEach(System.out::println);
	}

	public void insertMember(EntityManager em, WebMemberEntity member) {
		em.getTransaction().begin();
		em.persist(member);
		em.getTransaction().commit();
	}

	public void updateMember(EntityManager em, String id, int age) {
		em.getTransaction().begin();
		WebMemberEntity member = em.find(WebMemberEntity.class, id);
		member.setAge(age);
		em.getTransaction().commit();
	}
}
