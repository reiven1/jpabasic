package com.bs.jpa.model.entity.compose;

import java.io.Serializable;

import lombok.Data;

/*
복합키로 설정한 값을 연결해주는 객체
조건
1. public 클래스
2. 기본 생성자가 있어야함
3. Serializable 인터페이스 구현
4. equals, hasCode 오버라이딩 되어 있어야함
*/
@Data
public class ComposeKeyMapping implements Serializable {
	private static final long serialVersionUID = 9082384909349538146L;

	// 복합키로 설정한 필드와 이름, 타입이 동일
	private Long firstId;
	private Long secondId;

}
