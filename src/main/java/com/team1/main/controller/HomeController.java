package com.team1.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
public class HomeController {

	
	@GetMapping("/")
	public String mainpage() {
		return "main/mainpage";
	}
	
}
