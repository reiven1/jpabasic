package com.bs.jpa.jpql.controller;

import java.util.List;

import com.bs.jpa.jpql.model.entity.BoardEntity;
import com.bs.jpa.model.entity.WebMemberEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class JPQLController {
	public void basicJPQLTest(EntityManager em) {
		// JPQL 이용하기
		// 1. SELECT문 이용하기
		// 1) SELECT문의 대소문자를 구분함 -> 예약어는 예외 (select, from as ... )
		// 2) 설정한 Entity 명으로 조회(Table 명 아님)
		// @Entity(name="엔티티명") / 설정 안하면 클래스명
		// 3) from 뒤에 엔티티명을 작성하고 반드시 별칭을 부여
		BoardEntity b = em.find(BoardEntity.class, 2);
		String sql = "select b from BoardEntity b";
		// createQuery() 메소드를 이용해서 쿼리 실행 객체를 생성
		// Query/TypedQuery 두 객체로 반환
		Query query = em.createQuery(sql);
		TypedQuery<BoardEntity> tquery = em.createQuery(sql, BoardEntity.class);
//		List<BoardEntity> result = query.getResultList();
//		result.forEach(System.out::println);

		sql = """
				select m.boardTitle,m.boardContent,m.boardDate
				from BoardEntity m
				""";
		query = em.createQuery(sql);
		List<Object[]> result2 = query.getResultList();
//		result2.forEach(arrObj -> {
//			System.out.println(arrObj[0] + " " + arrObj[1] + " " + arrObj[2]);
//		});

		List<BoardEntity> boards = tquery.getResultList();
//		boards.forEach(board -> {
//			System.out.println(board.getBoardTitle() + " " + board.getBoardContent());
//		});

		sql = """
				select NEW com.bs.jpa.jpql.model.entity.BoardEntity(b.boardTitle, b.boardContent, b.boardDate)
				from BoardEntity b
				""";
		tquery = em.createQuery(sql, BoardEntity.class);
		boards = tquery.getResultList();
//		System.out.println(boards);
	}

	public void jpqlWhereTest(EntityManager em) {
		// where 절 사용하기
		// SELECT 프로젝션 입력 FROM 엔티티명 별칭
		// WHERE 별칭.필드명 = 값(리터럴)
		String sql = """
				select m from member m where m.userId='admin'
				""";
		TypedQuery<WebMemberEntity> tquery = em.createQuery(sql, WebMemberEntity.class);
//		tquery.getResultList().forEach(System.out::println);

		// WHERE 절에 변수 활용하기
		int age = 100;
		sql = """
				select m from member m where m.age >= %d
				""".formatted(age);
		tquery = em.createQuery(sql, WebMemberEntity.class);
//		tquery.getResultStream().forEach(System.out::println);

		// 변수를 파라미터로 처리하기
		// 인덱스값
		sql = "select m from member m where m.age >= ?1";
		tquery = em.createQuery(sql, WebMemberEntity.class);
		tquery.setParameter(1, age);
//		System.out.println(tquery.getResultStream().count());
		// key 값
		String userId = "admin";
		sql = "select m from member m where m.userId = :id";
		tquery = em.createQuery(sql, WebMemberEntity.class);
		tquery.setParameter("id", userId);
//		System.out.println(tquery.getResultStream().count());

		// 다수값 WHERE 절에 설정하기
		sql = "select m from member m where m.userId = :id and m.age <= :age";
		tquery = em.createQuery(sql, WebMemberEntity.class);
		tquery.setParameter("id", userId);
		tquery.setParameter("age", age);
//		System.out.println(tquery.getResultStream().count());
		// ROW 가 한 개일 때 getSingleResult() 를 이용할 수 있음
//		System.out.println(tquery.getSingleResult().getUserId());

		// LIKE 조회
		String userName = "바";
		sql = "select m from member m where m.userName like '%'||:name||'%'";
		tquery = em.createQuery(sql, WebMemberEntity.class);
		tquery.setParameter("name", userName);
//		tquery.getResultStream().forEach(System.out::println);
	}
	
	public void groupFunction(EntityManager em) {
		// 그룹함수
		// count, min, max, avg, sum
		String sql = """
				select count(m), min(m.age), max(m.age), sum(m.age), avg(m.age)
				from member m
				""";
		Query query = em.createQuery(sql);
		List<Object[]> resultArr = query.getResultList();
		resultArr.forEach(e->{
			for(Object o : e) {
//				System.out.println(o);
			}
		});
		
		// groupby 절 사용하기
		sql="select m.gender, count(m) from member m group by m.gender";
		query = em.createQuery(sql);
		resultArr = query.getResultList();
		resultArr.forEach(e->{
			for(Object o : e) {
				System.out.print(o+" ");
			}
			System.out.println();
		});
	}
	// 1. 전체 게시글 조회
	// 2. 게시글 번호가 10인 게시글 조회
	// 3. 게시글 제목을 기준으로 조회하는 기능 만들기
	// 4. 게시글 조회 -> 제목, 작성자만 
	// 5. 최근 게시글 5개 조회
	// 6. 게시글 읽은 수와 제목이 전달된 값으로 조회, 읽은 수는 더 큰 값(>=), 제목은 부분일치(LIKE '%'||:parameter||'%')
	// 7. 회원별 작성한 게시글 수 조회하기
	// 8. 게시글 평균 읽은 수(avg), 최대 읽은 수(max), 최소 읽은 수 조회하기(min)
}
