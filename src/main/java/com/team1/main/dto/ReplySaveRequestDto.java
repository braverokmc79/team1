package com.team1.main.dto;

import com.team1.main.entity.Board;
import com.team1.main.entity.Member;
import com.team1.main.entity.Reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplySaveRequestDto {
	
	private String userId;
	private long boardId;
	private String content;


    private Board board;

    private Member user;


	
}
