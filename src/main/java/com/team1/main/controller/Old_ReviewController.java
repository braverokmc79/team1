package com.team1.main.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/review/*")
public class Old_ReviewController {

    @GetMapping("list")
    private void reviewList() {
	}
    
    @GetMapping("register")
    private void reviewRegister() {
	}
    
    @GetMapping("modify")
    private void reviewModify() {
	}
    
    @GetMapping("info")
    private void info() {
	}

}
