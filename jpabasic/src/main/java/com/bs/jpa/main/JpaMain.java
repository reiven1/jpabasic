package com.bs.jpa.main;

import com.bs.jpa.common.JPATemplate;
import com.bs.jpa.controller.AssociationController;
import com.bs.jpa.controller.BasicController;
import com.bs.jpa.controller.WebController;
import com.bs.jpa.model.entity.WebMemberEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory factory = JPATemplate.getEntityManagerFactory();
		// 영속성 컨텍스트를 관리하는 EntityManager 클래스 생성
		EntityManager em = factory.createEntityManager();
		// 트랜젝션을 관리하는 EntityTransaction 클래스 생성
		EntityTransaction et = em.getTransaction();
		
		BasicController bc = new BasicController();
		
//		bc.basicEntityUse(em);
//		bc.basicTest2(em);
//		bc.basicTest3(em);
		
//		bc.insertTest(em);
//		bc.updateTest(em, (long) 10);
//		bc.deleteTest(em, (long) 10);
//		bc.selectTest(em);
		
		AssociationController ac = new AssociationController();
		
//		ac.oneToManyTest(em);
//		ac.oneToManyTest2(em);
		
//		ac.insertTest(em);
//		ac.removeStudent(em, 1L);
//		ac.removeLesson(em, 2L);
//		ac.searchData(em);
		
//		ac.manyToManyTest(em);
//		ac.manyToManySearch(em);
//		ac.manyToManyTest2(em);
		
//		ac.studentlesson(em);
		
		WebController wc = new WebController();
		EntityManager webem = JPATemplate.getWebEntityManagerFactory().createEntityManager();
		wc.searchMember(webem, "admin");
		WebMemberEntity m = WebMemberEntity.builder()
				.userId("dlrtneoajfl")
				.password("1234")
				.userName("익수")
				.age(25)
				.gender("M")
				.email("test@test.com")
				.phone("01049776038")
				.address("경남 남해")
				.hobby("중고차딜러")
				.build();
//		wc.insertMember(webem, m);
//		wc.updateMember(webem, "dlrtneoajfl", 19);
//		wc.searchMemberAll(webem);
//		wc.searchMember(webem, "dlrtneoajfl");
	}
}
