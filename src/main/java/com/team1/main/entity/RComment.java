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

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


//@Entity	
//@Getter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class RComment{
	//(댓글)일련번호
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long rcno;
    
    //댓글 작성자
    @ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Member writer;

    //댓글 달린 글
    @ManyToOne (fetch = FetchType.LAZY)
   	@JoinColumn(nullable = false)
   	private Old_Review ori_review ;
    

    //내용
    @Column(length = 1500, nullable = false)
    private String content;

	//작성일
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime c_date;
	
	
    //내용수정
    public void changeContent(String content){
        this.content = content;
    }
  
}
