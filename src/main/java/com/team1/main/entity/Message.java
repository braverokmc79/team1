package com.team1.main.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long meno;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Member sender;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Member receiver;
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime regdate_;
	
	@Column(length = 1500, nullable = false)
	private String content;
	
	@Column(length = 1, nullable = false)
	@ColumnDefault("0")
	private int check;
	
	// 수신 확인을 하지 않았으면 전송 취소하는 것도 가능하게 할까?
	
}
