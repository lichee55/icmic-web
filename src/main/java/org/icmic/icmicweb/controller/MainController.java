package org.icmic.icmicweb.controller;

import lombok.RequiredArgsConstructor;
import org.icmic.icmicweb.dto.BoardDetailDTO;
import org.icmic.icmicweb.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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

    @GetMapping("/registration")
    public String registration(Model model) {
        String datetime = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());

        int leftLimit = 'A';
        int rightLimit = 'Z';
        int targetStringLength = 4;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        model.addAttribute("Tradeid",
                "icmic_" + datetime + "_" + generatedString);

        return "registration";
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

    @GetMapping("/speech")
    public String speech() {
        return "speech";
    }
}
