package com.bs.jpa.jpql.model.entity;

import java.util.Date;

import com.bs.jpa.model.entity.WebMemberEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "BOARD")
@SequenceGenerator(name = "seqboardno", sequenceName = "seq_board_no", allocationSize = 1)
public class BoardEntity {
	@Id
	@GeneratedValue(generator = "seqboardno", strategy = GenerationType.SEQUENCE)
	@Column(name = "board_no")
	private Long boardNo;

	@Column(name = "board_title")
	private String boardTitle;

	@ManyToOne
	@JoinColumn(name = "board_writer")
	private WebMemberEntity boardWriter;

	@Column(name = "board_content")
	private String boardContent;

	@Column(name = "board_original_filename")
	private String boardOriginalFilename;

	@Column(name = "board_renamed_filename")
	private String boardRenamedFilename;

	@Column(name = "board_date")
	private Date boardDate;

	@Column(name = "board_readcount")
	private Integer boardReadcount;
	
	public BoardEntity(String boardTitle, String boardContent, Date boardDate) {
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
	}
}
