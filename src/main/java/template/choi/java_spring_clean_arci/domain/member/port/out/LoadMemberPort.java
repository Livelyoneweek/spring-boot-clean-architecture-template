package template.choi.java_spring_clean_arci.domain.member.port.out;

import template.choi.java_spring_clean_arci.domain.member.entity.Member;

import java.util.Optional;

public interface LoadMemberPort {
    Optional<Member> loadMemberByUserName(String userName);
}
