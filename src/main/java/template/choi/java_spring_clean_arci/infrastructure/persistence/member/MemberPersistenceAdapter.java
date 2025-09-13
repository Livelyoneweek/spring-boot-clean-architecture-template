package template.choi.java_spring_clean_arci.infrastructure.persistence.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import template.choi.java_spring_clean_arci.application.member.dto.MemberDto;
import template.choi.java_spring_clean_arci.application.member.port.out.MemberPort;
import template.choi.java_spring_clean_arci.domain.member.entity.Member;
import template.choi.java_spring_clean_arci.infrastructure.persistence.member.jpa.MemberRepository;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class MemberPersistenceAdapter implements MemberPort {

    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Transactional
    @Override
    public void deleteById(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Member> loadMemberByUserName(String userName) {
        return memberRepository.findByUserName(userName);
    }

    @Transactional(readOnly = true)
    @Override
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found. id=" + memberId));
    }


    @Override
    public List<MemberDto.Res.ResMember> getMemberByName(String userName) {
        return memberRepository.searchMemberByName(userName);
    }
}
