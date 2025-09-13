package template.choi.java_spring_clean_arci.application.member.port.out;

import template.choi.java_spring_clean_arci.application.member.dto.MemberDto;
import template.choi.java_spring_clean_arci.domain.member.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberPort {
    Member save(Member member);
    void deleteById(Long memberId);
    Optional<Member> loadMemberByUserName(String userName);
    Member findById(Long memberId);
    List<MemberDto.Res.ResMember> getMemberByName(String userName);
}
