package com.bs.jpa.model.entity.compose;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.SequenceGenerators;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Entity
@Table(name = "COMPOSE_HSW")
@SequenceGenerators({ @SequenceGenerator(name = "seqFirstId", sequenceName = "SEQ_FIRSTID", allocationSize = 1),
		@SequenceGenerator(name = "seqSecondId", sequenceName = "SEQ_SECONDID", allocationSize = 1) })
@IdClass(ComposeKeyMapping.class)
public class ComposeEntity {
	@Id
	@GeneratedValue(generator="seqFirstId", strategy=GenerationType.SEQUENCE)
	private Long firstId;
	
	@Id
	@GeneratedValue(generator="seqSecondId", strategy=GenerationType.SEQUENCE)
	private Long secondId;

	private String content;

}
