package template.choi.java_spring_clean_arci.infrastructure.security.principal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import template.choi.java_spring_clean_arci.domain.member.entity.Member;
import template.choi.java_spring_clean_arci.infrastructure.persistence.member.MemberRepository;
import template.choi.java_spring_clean_arci.infrastructure.security.dto.LoginMember;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String mobile) {

        Optional<Member> optionalMember = memberRepository.findByMobile(mobile);
        if (Objects.isNull(optionalMember)) {
            throw new UsernameNotFoundException("USER NOT FOUND");
        }

        return new PrincipalDetails(new LoginMember(optionalMember.get()));
    }

}
