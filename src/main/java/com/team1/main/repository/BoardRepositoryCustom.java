package com.team1.main.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.team1.main.dto.BoardDto;
import com.team1.main.entity.SearchCond;

public interface BoardRepositoryCustom {
	
	 Page<BoardDto> boardSearchList(SearchCond searchCond, Pageable pageable);
	
}
