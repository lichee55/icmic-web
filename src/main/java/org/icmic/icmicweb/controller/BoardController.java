package org.icmic.icmicweb.controller;

import lombok.RequiredArgsConstructor;
import org.icmic.icmicweb.dto.BoardDetailDTO;
import org.icmic.icmicweb.dto.BoardWriteDTO;
import org.icmic.icmicweb.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    @ResponseBody
    public String board(Model model, Pageable pageable) {
        Page<BoardDetailDTO> boardList = boardService.findBoardList(pageable);
        model.addAttribute("boardList", boardList);
        return boardList.toString();
    }

    @GetMapping("/board/detail")
    public String boardDetail(Model model, Long id) {
        BoardDetailDTO boardDetailDTO = boardService.findBoardDetail(id);
        model.addAttribute("boardDetail", boardDetailDTO);
        return "boardDetail";
    }

    @GetMapping("/board/write")
    @ResponseBody
    public String boardWrite() {
        return "boardWrite";
    }

    @PostMapping("/board/write")
    public String writeBoard(BoardWriteDTO boardWriteDTO) {
        Long newBoardId = boardService.writeBoard(boardWriteDTO);
        return "redirect:/board/detail?boardId=" + newBoardId;
    }
}


