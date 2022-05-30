package org.icmic.icmicweb.controller;

import lombok.RequiredArgsConstructor;
import org.icmic.icmicweb.dto.BoardDetailDTO;
import org.icmic.icmicweb.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final BoardService boardService;

    @GetMapping("/")
    public String hello(Model model) {
        Page<BoardDetailDTO> boardList = boardService.findBoardList(PageRequest.of(0, 5));
        model.addAttribute("boardList", boardList);
        return "index";
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

    @GetMapping("/program")
    public String program() {
        return "program";
    }

    @GetMapping("/history")
    public String history() {
        return "history";
    }
}
