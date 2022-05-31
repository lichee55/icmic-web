package org.icmic.icmicweb.service.impl;

import lombok.RequiredArgsConstructor;
import org.icmic.icmicweb.domain.Board;
import org.icmic.icmicweb.domain.BoardRepository;
import org.icmic.icmicweb.dto.BoardDetailDTO;
import org.icmic.icmicweb.dto.BoardWriteDTO;
import org.icmic.icmicweb.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public Page<BoardDetailDTO> findBoardList(Pageable pageable) {
        Page<Board> list = boardRepository.findAllByOrderByCreatedAtDesc(pageable);
        return list.map(BoardDetailDTO::toDTO);
    }

    @Override
    public BoardDetailDTO findBoardDetail(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        return BoardDetailDTO.toDTO(board);
    }

    @Override
    public Long writeBoard(BoardWriteDTO boardWriteDTO) {
        String content = boardWriteDTO.getContent();
        content = content.replace("<", "&lt;");
        content = content.replace(">", "&gt;");

        Board board = Board.builder()
                .title(boardWriteDTO.getTitle())
                .content(content)
                .createdAt(LocalDateTime.now())
                .build();
        return boardRepository.save(board).getId();
    }
}
