package org.icmic.icmicweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @GetMapping("/invite")
    public String invite() {
        return "invite";
    }

    @GetMapping("/committee")
    public String committee() {
        return "committee";
    }

    @GetMapping("/steering")
    public String steering() {
        return "steering";
    }

    @GetMapping("/organizing")
    public String organizing() {
        return "organizing";
    }

    @GetMapping("/technical")
    public String technical() {
        return "technical";
    }

    @GetMapping("/symposia")
    public String symposia() {
        return "symposia";
    }

    @GetMapping("/cfp")
    public String cfp() {
        return "cfp";
    }

    @GetMapping("/submission")
    public String submission() {
        return "submission";
    }

    @GetMapping("/registerInfo")
    public String registerInfo() {
        return "registerInfo";
    }

    @GetMapping("/venue")
    public String venue() {
        return "venue";
    }

    @GetMapping("/accommodation")
    public String accommodation() {
        return "accommodation";
    }

    @GetMapping("/travel")
    public String travel() {
        return "travel";
    }
}
