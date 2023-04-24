package com.team1.main.service;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team1.main.dto.BoardDto;
import com.team1.main.dto.MemberFormDto;
import com.team1.main.dto.ReplySaveRequestDto;
import com.team1.main.entity.Board;
import com.team1.main.entity.Member;
import com.team1.main.entity.Reply;
import com.team1.main.entity.SearchCond;
import com.team1.main.repository.BoardRepository;
import com.team1.main.repository.MemberRepository;
import com.team1.main.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;

/**
 * 서비스 1. 트랜잭션 관리 2. 두개 이상 서비스 create, update,
 *
 * select 만 있을 경우 : @Transactional(readOnly = true) 스프링이 컴포넌트 스캔을 통해서 Bean 에 등록을
 * 해줌. IoC 를 해준다. *
 */
@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private final BoardRepository boardRepository;

	final private MemberService userService;

	private final ReplyRepository replyRepository;
	
	private final MemberRepository userRepository;
	
	
	
	// 글쓰기
	public int boardSave(Board board, MemberFormDto  loginUser) {
		int result = 0;
		Member user = userService.findByUserId(loginUser.getUserId());
		if (user != null) {
			log.info("가져온 유저 정보  {} ", user.toString());
			board.setUser(user);
			board.setCount(0);
			boardRepository.save(board);
			result = 1;
		}
		return result;
	}

	@Transactional(readOnly = true)
	public Page<BoardDto> boardSearchList(SearchCond searchCond, Pageable pageable) {
		return boardRepository.boardSearchList(searchCond, pageable);
	}

	// 글 상세보기
	@Transactional(readOnly = true)
	public Board boardDetail(Long id) {
		return boardRepository.findById(id).orElseThrow(EntityExistsException::new);
	}

	public void deleteByid(Long id) {
		boardRepository.deleteById(id);
	}

	
	public void updateBoard(long id, Board requestBoard) {
		Board board=boardRepository.findById(id).orElseThrow(EntityExistsException::new); //영속화 완료
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		//해당 함수로 종료시에 트랜잭션이 service 가 종료될때) 트랜잭션이 종료. 이때 더티체킹 -자동 업데이트가 됨. flush		
	}

	//댓글 등록
	public void replySave(ReplySaveRequestDto replySaveRequestDto , long boardId, MemberFormDto  loginUser) {
		 
		Board  board=boardRepository.findById(boardId).orElseThrow(EntityExistsException::new);
		Member member =userService.findByUserId(loginUser.getUserId());
		replySaveRequestDto.setUserId(member.getUserId());
		replySaveRequestDto.setUser(member);
		replySaveRequestDto.setBoard(board);
		
		Reply result=replyRepository.save(Reply.createReply(replySaveRequestDto));
		
		
		//int result=replyRepository.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
		log.info("result   :  {}  "   , result);
	}

	
	//댓글 삭제
	public int replyDelete(long replyId,  MemberFormDto  loginUser) {
	  Reply reply= replyRepository.findById(replyId).orElseThrow(EntityExistsException::new);

	  Member member =userRepository.findByUserId(loginUser.getUserId());

	  if(reply.getUser().getUserId()==member.getUserId()) {
		  replyRepository.deleteById(replyId);
		  return 1;
	  }
	  
	  return 0;		
	}
	
	
	

}
