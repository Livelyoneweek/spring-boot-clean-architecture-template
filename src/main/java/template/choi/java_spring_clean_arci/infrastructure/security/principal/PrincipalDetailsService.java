package template.choi.java_spring_clean_arci.infrastructure.security.principal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import template.choi.java_spring_clean_arci.domain.member.entity.Member;
import template.choi.java_spring_clean_arci.infrastructure.persistence.member.jpa.MemberRepository;
import template.choi.java_spring_clean_arci.infrastructure.security.dto.LoginMember;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        Member member = memberRepository.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("USER NOT FOUND"));
        log.info("### PrincipalDetailsService.loadUserByUsername");
        return new PrincipalDetails(new LoginMember(member));
    }

}
