package com.team1.main.entity;

import lombok.*;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "id")
@SequenceGenerator(name = "OFFER_SEQ_GENERATOR", sequenceName = "OFFER_SEQ", initialValue = 1, allocationSize = 1 
)
public class Offer extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OFFER_SEQ_GENERATOR")
	private Long ono;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Member id;

	@Column(length = 100, nullable = false)
	private String title;

	@Column(length = 100, nullable = true)
	private String img;

	@Column(length = 100, nullable = false)
	private String category;

	@Column(length = 100, nullable = false)
	private String region;

	@Column(length = 1500, nullable = false)
	private String content;

	@Column(length = 100, nullable = false)
	private String map;

	public void changeTitle(String title) {
		this.title = title;
	}

	public void changeContent(String content) {
		this.content = content;
	}

}
