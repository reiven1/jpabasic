package com.bs.jpa.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.bs.jpa.common.Gender;
import com.bs.jpa.model.entity.Address;
import com.bs.jpa.model.entity.BasicEntity;
import com.bs.jpa.model.entity.MemberEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class BasicController {
	public void basicEntityUse(EntityManager em) {
		EntityTransaction et = em.getTransaction();
		et.begin();

		// 엔티티로 선언된 클래스를 생성 -> 객체화(테이블의 1개 데이터(row))
		// 비영속 상태인 객체 -> 영속상태로 변경
		BasicEntity b = new BasicEntity();
		b.setBasicNo(7L);
		b.setBasicName("나의 첫 entity 데이터");
		b.setAccount(100);
		b.setWeight(1.2);
		System.out.println(b);

		// 영속상태로 만들어주기
		em.persist(b);

		BasicEntity b1 = BasicEntity.builder().basicNo(8L).basicName("두번째 entity 저장").account(20).weight(1.2).build();
		em.persist(b1);
		// 쿼리문 실행햐기
		et.commit();

		// 조회
		// em.find(클래스타입, "@Id 설정된 필드값") 메소드를 이용
		// 한 개 entity 객체(row)만 가져올 수 있음
		BasicEntity search = em.find(BasicEntity.class, 1L);
		System.out.println(search);

		search = em.find(BasicEntity.class, 8L);
		System.out.println(search);
	}

	public void basicTest2(EntityManager em) {
		BasicEntity be = em.getReference(BasicEntity.class, 1L);
//		BasicEntity be = em.find(BasicEntity.class, 1L);
		System.out.println(be);

		// 영속성 컨텍스트에 등록된 객체 제거
		em.clear();

		BasicEntity be2 = em.find(BasicEntity.class, 1L);
		System.out.println(be2);
	}

	public void basicTest3(EntityManager em) {
		EntityTransaction et = em.getTransaction();
		et.begin();

		MemberEntity member = MemberEntity.builder().memberId("user2").password("12345").memberName("유저2")
				.gender(Gender.M).phone("01034567891").birthDay(LocalDate.of(2002, 4, 10))
				.accessTime(LocalDateTime.now()).address(new Address("12345", "대한민국", "대한민국")).build();

//		System.out.println(member);
		em.persist(member);

		et.commit();

		MemberEntity searchMember = em.find(MemberEntity.class, 32L);
		System.out.println(searchMember);
	}

	public void insertTest(EntityManager em) {
		EntityTransaction et = em.getTransaction();
		BasicEntity b = BasicEntity.builder().basicName("12345").account(12345).weight(12.345).build();
		et.begin();
		em.persist(b);
		et.commit();

	}

	public void updateTest(EntityManager em, Long no) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		BasicEntity b = em.find(BasicEntity.class, no);
		b.setAccount(23456);
		et.commit();
		System.out.println(b);
	}

	public void deleteTest(EntityManager em, Long no) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		BasicEntity b = em.find(BasicEntity.class, no);
		em.remove(b);
		et.commit();
	}

	public void selectTest(EntityManager em) {
		String sql = "SELECT b FROM BasicEntity b";
		Query query = em.createQuery(sql);
		List<?> list = query.getResultList();
		if (list.isEmpty()) {
			System.out.println("찾을 수 없습니다");
			return;
		}
		list.forEach(System.out::println);
	}
}
