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
import org.springframework.data.annotation.LastModifiedDate;

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
public class Old_Review{
	//(리뷰)일련번호
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long rno;
    
    //리뷰 작성자
    @ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (nullable = false)
	private Member writer;

    //제목
    @Column(length = 100, nullable = false)
    private String title;

    //내용
    @Column(length = 1500, nullable = false)
    private String content;

    //이미지
    @Column (length = 1000, nullable = false)
	private String img;
	
	//작성일
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime c_date;
	
	//수정일
	@LastModifiedDate
	@Column
	private LocalDateTime m_date;

	//제목수정
    public void changeTitle(String title){
        this.title = title;
    }
    //내용수정
    public void changeContent(String content){
        this.content = content;
    }
    //이미지수정
    public void changeImg(String img){
        this.img = img;
    }
}
