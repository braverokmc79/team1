package com.team1.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
	
	@GetMapping("info")
	public void test() {
	}

	@GetMapping("/member")
	public void index() {
	}
	
	@GetMapping("/memberInfo")
	public void info() {
	}

}
