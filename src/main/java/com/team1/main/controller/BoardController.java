package com.team1.main.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.team1.main.dto.BoardDto;
import com.team1.main.dto.MemberFormDto;
import com.team1.main.dto.ReplyDto;
import com.team1.main.entity.Board;
import com.team1.main.entity.Member;
import com.team1.main.entity.Pagination;
import com.team1.main.entity.SearchCond;
import com.team1.main.service.BoardService;
import com.team1.main.service.MemberService;
import com.team1.main.service.ReplyService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	
	private final BoardService boardService;
	
	
	private final ReplyService replyService;
	
	private final MemberService memberService;
	

	//@PageableDefault(size = 1, sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    @GetMapping(value={"/review", "/review/","/review/list"})
    public String index(SearchCond searchCond ,
						@RequestParam(value = "page",defaultValue ="1", required = false)
    			Optional<Integer> page, Model model) {
        //페이징을 위해서 PageRequest.of 메소드를 통해 Pageable 객체를 생성합니다.
        //첫 번째 파라미터로 조회할 페이지 번호, 두 번째 파라미터로 한 번에 가지고 올 데이터 수를 넣어줍니다.
        //URL 경로에 페이지 번호가 있으면 해당 페이지르 조회하도록 세팅하고, 페이지 번호가 없으면 0페이지를 조회하도록 합니다.    	
    	int pageSize=5; //한 페이지당 게시글 수  5
        Pageable pageable= PageRequest.of(page.isPresent()? page.get()-1 :0, pageSize);
        
    	Page<BoardDto> boards= boardService.boardSearchList(searchCond , pageable);
    	
    	//페이지 블럭 계산을 위한 처리
    	//전체페이지, 현재페이지, 한 페이지당 게시글 수,  페이지 블럭(range)
    	Pagination pagination =new Pagination((int)boards.getTotalElements(),  page.get(),  pageSize , 5);

    	model.addAttribute("boards", boards);
    	model.addAttribute("searchCond", searchCond);
    	model.addAttribute("pagination", pagination);
    	return "review/index";
    }
    
    
    //상세보기
    @GetMapping("/review/{id}")
    public String findById(@PathVariable Long id, SearchCond searchCond ,  HttpSession session, 
			@RequestParam(value = "page",defaultValue ="1", required = false) 
			Optional<Integer> page,    		
    		Model model) {
    
    	int pageSize=5;

    	MemberFormDto  loginUser =(MemberFormDto)session.getAttribute("LOGIN_USER");
    
    	if(loginUser!=null) {
    		MemberFormDto auth=null;
    		Member member=memberService.findByUserId(loginUser.getUserId());  
    		auth=MemberFormDto.createMemberDTO(member);
    		model.addAttribute("auth",auth);
    	}
    	
    	
    	
    	Board  board=boardService.boardDetail(id);
   
    	
        Pageable pageable= PageRequest.of(page.isPresent()? page.get()-1 :0, pageSize);        
       	Page<ReplyDto> replyList= replyService.replySearchList(pageable, board);
       	Pagination pagination =new Pagination((int)replyList.getTotalElements(),  page.get(),  pageSize , 5);
 
    
    	model.addAttribute("board", board);
    	model.addAttribute("totalCount", replyList.getTotalElements());
    	model.addAttribute("replyList", replyList);
    	model.addAttribute("pagination", pagination);
    	return "review/detail";
    }
    

    
    
    
    @GetMapping("/review/saveForm")
    public String saveForm() {
    	return "review/saveForm";
    }
    
    
    @GetMapping("/review/{id}/updateForm")
    public String updateForm(@PathVariable long id, Model model) {
    	model.addAttribute("board", boardService.boardDetail(id));    	
    	return "review/updateForm";
    }
    
    
    
    
    
    
    
    
}

