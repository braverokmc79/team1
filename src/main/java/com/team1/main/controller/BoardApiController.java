package com.team1.main.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team1.main.dto.MemberFormDto;
import com.team1.main.dto.ReplySaveRequestDto;
import com.team1.main.entity.Board;
import com.team1.main.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	final private BoardService boardService;


	private final HttpSession session;

	@PostMapping("/api/review")
	public ResponseEntity<?> save(@RequestBody Board board) {
		try {
			MemberFormDto  loginUser =(MemberFormDto)session.getAttribute("LOGIN_USER");
			 
			if(loginUser==null)return new ResponseEntity<String>("로그인 후 이용가능합니다.", HttpStatus.BAD_REQUEST);
			
			log.info("save :  {} , {} ", loginUser.getUserId(), board);
			return new ResponseEntity<Integer>(boardService.boardSave(board, loginUser), HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("등록 처리 오류  입니다.", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/api/review/{id}")
	public ResponseEntity<?> deleteByid(@PathVariable("id") Long id) {
		boardService.deleteByid(id);
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}

	@PutMapping("/api/review/{id}")
	public ResponseEntity<Integer> updateBoard(@PathVariable long id, @RequestBody Board board) {
		boardService.updateBoard(id, board);
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}

	
	//데이터를 받을 때 컨트롤러에서 dto 를 만들어서 받는게 좋다.
	//dto 사용하지 않는 이유는
	// 댓글 등록
	@PostMapping("/api/review/{boardId}/reply")
	public ResponseEntity<?> replySave(@PathVariable(value = "boardId") long boardId, @RequestBody ReplySaveRequestDto replySaveRequestDto) {
		try {

			MemberFormDto  loginUser =(MemberFormDto)session.getAttribute("LOGIN_USER");
			if(loginUser==null)return new ResponseEntity<String>("로그인 후 이용가능합니다.", HttpStatus.BAD_REQUEST);
			
		
			boardService.replySave(replySaveRequestDto, boardId,   loginUser);
			return new ResponseEntity<Integer>(1, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("등록 처리 오류  입니다.", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	//댓글 삭제
	@DeleteMapping("/api/review/{boardId}/reply/{replyId}")
	public ResponseEntity<?> replyDelete(@PathVariable(value = "boardId") long boardId ,
			@PathVariable(value = "replyId") long replyId){

		MemberFormDto  loginUser =(MemberFormDto)session.getAttribute("LOGIN_USER");
		if(loginUser==null)return new ResponseEntity<String>("로그인 후 이용가능합니다.", HttpStatus.BAD_REQUEST);
		
		int result=boardService.replyDelete(replyId , loginUser);
		if(result!=1) {
			return new ResponseEntity<String>("삭제 처리 할수 없습니다.", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	
	
	
	

}
