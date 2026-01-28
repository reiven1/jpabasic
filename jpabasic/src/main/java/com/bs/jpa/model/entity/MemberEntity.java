package com.bs.jpa.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.bs.jpa.common.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity(name = "member_entity")
// 테이블에 관련된 내용을 설정
@Table(name = "MEMBERENTITY_HSW", uniqueConstraints = {
		@UniqueConstraint(name = "unique", columnNames = { "MEMBER_ID", "MEMBER_PHONE" }) }, indexes = {
				@Index(name = "idx_memberid_membername", columnList = "MEMBER_ID, memberName") })
// 시퀀스 객체 만들기
@SequenceGenerator(name = "seqMemberNo", sequenceName = "seq_member_no", initialValue = 1, allocationSize = 1)
public class MemberEntity {
	@Id
	@GeneratedValue(generator = "seqMemberNo", strategy = GenerationType.SEQUENCE)
	@Column(name = "MEMBER_NO")
	private Long memberNo;

	@Column(name = "MEMBER_ID", nullable = false)
	private String memberId;

	@Column(name = "MEMBER_PWD", length = 100)
	private String password;

	private String memberName;

	@Enumerated(EnumType.STRING)
	@Column(name = "MEMBER_GENDER")
	private Gender gender;

	@Column(name = "MEMBER_PHONE", columnDefinition = "varchar(20) default '없음' NOT NULL")
	private String phone;

	@Temporal(TemporalType.DATE)
	private LocalDate birthDay;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime accessTime;

	@Embedded
	private Address address;

	@Transient
	private int count;

}
