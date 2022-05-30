package org.icmic.icmicweb.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.icmic.icmicweb.domain.Member;

@Getter
@Setter
@Builder
public class MemberSaveDTO {
    private String memberId;
    private String password;

    public static Member toEntity(MemberSaveDTO dto) {
        return Member.builder()
                .loginId(dto.getMemberId())
                .password(dto.getPassword())
                .build();
    }
}
