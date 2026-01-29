package com.bs.jpa.common;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPATemplate {
	private static EntityManagerFactory factory;
	private static EntityManagerFactory webFactory;
	
	public static EntityManagerFactory getWebEntityManagerFactory() {
		if(webFactory==null) {
			webFactory = Persistence.createEntityManagerFactory("webdb");
		}
		return webFactory;
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("basicjpa");
		}
		return factory;
	}
}
