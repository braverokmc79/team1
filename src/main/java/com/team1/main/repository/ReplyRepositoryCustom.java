package com.team1.main.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.team1.main.dto.ReplyDto;
import com.team1.main.entity.Board;

public interface ReplyRepositoryCustom {
	
	 Page<ReplyDto> replySearchList(Pageable pageable, Board getBoard);
	
}
