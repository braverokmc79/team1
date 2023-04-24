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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team1.main.dto.ReplySaveRequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "reply")
@ToString
@SequenceGenerator(
        name="REPLY_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="REPLY_SEQ", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
        )
public class Reply {

    @Id
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
            generator="REPLY_SEQ_GEN" //식별자 생성기를 설정해놓은  REPLY_SEQ_GEN 설정
            )
    private Long id; //시퀀스

    @Column(nullable = false, length = 200)
    private String content;


    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "board_id")
    @JsonIgnore
    private Board board;


    /** 원래 LAZY 전략으로 사용해야 하지만 시간상 EAGER 전략 사용  */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId")    
    private Member user;


    @CreationTimestamp
    private LocalDateTime createDate;


	public static Reply createReply(ReplySaveRequestDto replySaveRequestDto) {
		return Reply.builder()
				 .content(replySaveRequestDto.getContent())
				 .board(replySaveRequestDto.getBoard())
				 .user(replySaveRequestDto.getUser())
				 .createDate(LocalDateTime.now())
				.build();
	}


}
