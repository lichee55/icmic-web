package org.icmic.icmicweb.service;

import org.icmic.icmicweb.dto.MemberSaveDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    Long save(MemberSaveDTO saveDTO);
}
