package com.boot.mvc20220916junho.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.model.IAttribute;

import java.time.LocalDateTime;

@Controller
public class PageController {

    @GetMapping({"/", "/index"})
    public String loadIndex(Model model) {
        model.addAttribute("name","김준일");
        return "index";
    }

    @GetMapping("/helloboot")
    public String loadHelloBoot(Model model) {
        model.addAttribute("nowData", LocalDateTime.now());
        return "hello";
    }

    @GetMapping("/myinfo")
    public String loadMyInfo(Model model) {
        model.addAttribute("name", "이름: 김준일");
        model.addAttribute("age", "나이: 29");
        model.addAttribute("phone", "연락처: 010-9988-1916");
        model.addAttribute("address", "주소: 부산 동래구 사직동");
        return "myinfo";
    }
}
