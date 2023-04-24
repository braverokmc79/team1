package com.team1.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team1.main.dto.MemberFormDto;
import com.team1.main.entity.Member;
import com.team1.main.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/main/*")
public class MainController {

	private final MemberService memberService;
	

    
	@GetMapping("/")
	public String mainpage() {
		return "main/mainpage";
	}

	@GetMapping("login")
	public void login() {
	}

	@PostMapping("login")
	public String login(MemberFormDto memberFormDto, HttpSession session , RedirectAttributes rttr ) {
		log.info("로그인 전:  {}" );
		if(!StringUtils.hasText(memberFormDto.getUserId()) || !StringUtils.hasText(memberFormDto.getPassword())) {	
			rttr.addFlashAttribute("errMsg", "아이디외 비밀번호를 입력해 주세요.");
			return "redirect:/";
		}
		
		Member  member=   memberService.login(memberFormDto);

	
		log.info("로그인 후: ");
		if(member!=null) {
			session.setAttribute("LOGIN_USER", MemberFormDto.createMemberDTO(member));
			rttr.addFlashAttribute("errMsg", "로그인 되었습니다.");
			return "redirect:/";
		}
		
		rttr.addFlashAttribute("errMsg", "아이디외 비밀번호가 일치하지 않습니다.");
		return "redirect:/";
	}
	
	@GetMapping("register")
	public void register(Model model) {
		model.addAttribute("memberFormDto", new MemberFormDto());
	}

	@PostMapping("register")
	public String register( MemberFormDto memberFormDto, BindingResult bindingResult, RedirectAttributes rttr) {
		log.info("회원 가입 :  {}"  , memberFormDto.toString());
//		if (bindingResult.hasErrors()) return "main/register";
//
//		try {
//			Member member = Member.createMember(memberFormDto, passwordEncoder);
//			memberService.saveMember(member);
//		} catch (IllegalStateException e) {
//			model.addAttribute("errorMessage", e.getMessage());
//			return "main/register";
//		}
		
		Member member = Member.createMember(memberFormDto);
		memberService.saveMember(member);
		rttr.addFlashAttribute("joinMsg", "회원가입을 축하합니다.");
		return "redirect:/";
	}

	
	@GetMapping("find")
	private void find() {
	}

}
