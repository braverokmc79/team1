package com.team1.main.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.querydsl.core.annotations.QueryProjection;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity //User 클래스가 MySQL 에 테이블이 생성이 된다.
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "board_id")
    private Long id;

    @Column(nullable = false, length =100)
    private String title;


    @Lob //대용량 데이터
    private String content;

    //@ColumnDefault("0")
    private int count;//조회수

    
    
    /** 원래 LAZY 전략으로 사용해야 하지만 시간상 EAGER 전략 사용  */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId")
    private Member user; 


    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) 
    @JsonIgnore  
    @OrderBy("id desc")
    private List<Reply> replys;


    @CreationTimestamp
    private LocalDateTime createDate; //등록일


     


}





