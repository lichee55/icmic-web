package org.icmic.icmicweb.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BoardWriteDTO {

    private String title;
    private String content;
}
