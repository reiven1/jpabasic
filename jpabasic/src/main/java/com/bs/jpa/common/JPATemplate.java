package com.bs.jpa.common;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPATemplate {
	private static EntityManagerFactory factory;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("basicjpa");
		}
		return factory;
	}
}
