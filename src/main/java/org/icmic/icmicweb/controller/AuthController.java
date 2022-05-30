package org.icmic.icmicweb.controller;

import lombok.RequiredArgsConstructor;
import org.icmic.icmicweb.dto.MemberSaveDTO;
import org.icmic.icmicweb.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/signup")
    @ResponseBody
    public Long signup(@RequestBody Map<String, String> params) {
        MemberSaveDTO build = MemberSaveDTO.builder()
                .memberId(params.get("memberId"))
                .password(params.get("password"))
                .build();
        return memberService.save(build);
    }

}