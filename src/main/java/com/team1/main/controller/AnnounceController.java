package com.team1.main.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/announce/*")
public class AnnounceController {

    @GetMapping("list")
    public void announceList() {
    }

    @GetMapping("register")
    private void announceRegister() {
    }
    
    @GetMapping("modify")
    public void announceModify() {
    }
    
    @GetMapping("info")
    private void info() {
	}
    

}
