package org.icmic.icmicweb.service;

import org.icmic.icmicweb.dto.BoardDetailDTO;
import org.icmic.icmicweb.dto.BoardWriteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {

    Page<BoardDetailDTO> findBoardList(Pageable pageable);

    BoardDetailDTO findBoardDetail(Long id);

    Long writeBoard(BoardWriteDTO boardWriteDTO);
}
