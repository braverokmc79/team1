package com.team1.main.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/page/*")
public class PageController {

	@GetMapping("myPage")
	public void myPage() {
	}

	@GetMapping("myJobOpen")
	public void myJobOpen() {
	}
	
	@GetMapping("myReview")
	public void myReview() {
	}
	
	@GetMapping("myApply")
	public void myApply() {
	}
	
	@GetMapping("myInfo")
	public void myinfo() {
	}
	
	@GetMapping("yourInfo")
	public void yourinfo() {
	}

}
