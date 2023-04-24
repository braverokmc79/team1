package com.team1.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Announce extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long aNo;
	
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn
	private Member id;
	
	@Column(nullable = true)
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = true)
	private String img;
	
	 public void changeTitle(String title){
	        this.title = title;
	 }

	 public void changeContent(String content){
	        this.content = content;
	 }
	
}
