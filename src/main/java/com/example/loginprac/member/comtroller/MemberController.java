package com.example.loginprac.member.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class MemberController {
    ArrayList<HashMap<String,String>> memberList = new ArrayList<>();

    @PostMapping("/signup")
    public String signup(@RequestParam HashMap<String,String> params) {
        memberList.add(params);
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam HashMap<String,String> params, HttpSession session) {
        for (HashMap<String,String> mem : memberList) {
            if (params.get("email").equals(mem.get("email")) && params.get("password").equals(mem.get("password"))) {
                // 가입된 회원인 경우(이메일과 비밀번호가 일치하는경우)
                session.setAttribute("email", mem.get("email"));
                System.out.println(mem.get("email"));
                return "index";
            }
        }
        return "signup";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("email", null);
        return "index";
    }
}
