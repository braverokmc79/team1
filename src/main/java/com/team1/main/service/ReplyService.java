package com.team1.main.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team1.main.dto.ReplyDto;
import com.team1.main.entity.Board;
import com.team1.main.entity.Reply;
import com.team1.main.repository.ReplyPageRepository;
import com.team1.main.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ReplyService {
	
	private final ReplyRepository replyRepository;
	
	private final ReplyPageRepository replyPageRepository;
	
	public Page<Reply> replyList(Pageable pageable) {
		return replyRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<ReplyDto> replySearchList(Pageable pageable, Board getBoard) {
		return replyPageRepository.replySearchList(pageable,  getBoard);
	}
	
	
	public List<Reply>  replyList2(Pageable pageable, Long id) {
		return  replyRepository.replyList(id);
	}

	public int replyTotalCount(Pageable pageable, Long id) {
		return  replyRepository.replyTotalCount(id);
	}
	
	

}
