package template.choi.java_spring_clean_arci.infrastructure.persistence.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import template.choi.java_spring_clean_arci.domain.member.entity.Member;
import template.choi.java_spring_clean_arci.domain.member.port.out.LoadMemberPort;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements LoadMemberPort {

    private final MemberRepository memberRepository;

    @Override
    public Optional<Member> loadMemberByUserName(String userName) {
        return memberRepository.findByUserName(userName);
    }
}
