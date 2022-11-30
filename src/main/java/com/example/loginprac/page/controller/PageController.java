package com.example.loginprac.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class PageController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/goSignUp")
    public String goSignUp() {
        return "signup";
    }
    @GetMapping("/goLogin")
    public String goLogin() {
        return "login";
    }
    // 간단한 세션 방식으로 로그인 처리를 한 후에, 로그인 여부에 따라 회원전용 페이지에 이동 해야할지 말지를 정하도록 합니다.

    @PostMapping("/test")
    public String post(@RequestParam HashMap<String,String> params) {
        System.out.println(params);
        return "index";
    }

    @GetMapping("/goMember")
    public String goMember(HttpSession session){
        if(session.getAttribute("email")==null) {//로그인 안한 경우
            return "login";
        } else {
            return "index";
        }
    }
}
