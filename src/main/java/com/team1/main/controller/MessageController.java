package com.team1.main.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/message/*")
public class MessageController {

    @GetMapping("receiveList")
    private void messageListR() {
	}

    @GetMapping("sendList")
    private void messageListS() {
    }

    @GetMapping("info")
    private void messageRead() {
    }
    
    @GetMapping("register")
    private void messageRegister() {
	}
	

}
