package org.icmic.icmicweb.service.impl;

import lombok.RequiredArgsConstructor;
import org.icmic.icmicweb.domain.Member;
import org.icmic.icmicweb.domain.MemberRepository;
import org.icmic.icmicweb.domain.Role;
import org.icmic.icmicweb.dto.MemberSaveDTO;
import org.icmic.icmicweb.service.MemberService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByLoginId(username).orElseThrow(() -> new UsernameNotFoundException(username));
        List<GrantedAuthority> authorities = new ArrayList<>();

        Role role = member.getRole();
        authorities.add(new SimpleGrantedAuthority(role.name()));

        return new User(member.getLoginId(), member.getPassword(), authorities);
    }


    @Override
    public Long save(MemberSaveDTO saveDTO) {
        Member member = MemberSaveDTO.toEntity(saveDTO);
        member.setRole(Role.ROLE_GUEST);

        member.setPassword(passwordEncoder.encode(member.getPassword()));
        return memberRepository.save(member).getId();
    }

}
