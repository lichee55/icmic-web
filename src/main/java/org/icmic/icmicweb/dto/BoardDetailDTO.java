package org.icmic.icmicweb.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.icmic.icmicweb.domain.Board;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
public class BoardDetailDTO {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public static BoardDetailDTO toDTO(Board board) {
        return BoardDetailDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .createdAt(board.getCreatedAt())
                .build();
    }

}