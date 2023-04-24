package com.team1.main.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/offer/*")
public class OfferController {

    @GetMapping("list")
    private void offerList() {
	}
    
    @GetMapping("register")
    private void offerRegister() {
    }
    
    @GetMapping("modify")
    private void offerModify() {
	}
    
	@GetMapping("info")
	public void reviewinfo() {
	}
	

}
