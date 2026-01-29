package com.bs.jpa.jpql.run;

import com.bs.jpa.common.JPATemplate;
import com.bs.jpa.jpql.controller.JPQLController;

import jakarta.persistence.EntityManager;

public class JpqlMain {
	public static void main(String[] args) {
		EntityManager em = JPATemplate.getWebEntityManagerFactory().createEntityManager();
//		new JPQLController().basicJPQLTest(em);
//		new JPQLController().jpqlWhereTest(em);
		new JPQLController().groupFunction(em);
		
	}
}
