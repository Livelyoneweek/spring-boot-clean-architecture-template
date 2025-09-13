package template.choi.java_spring_clean_arci.infrastructure.security.dto;

import template.choi.java_spring_clean_arci.domain.member.entity.Member;
import template.choi.java_spring_clean_arci.domain.member.enums.MemberRole;

public record LoginMember (Long memberId,
                           String userName,
                           String password,
                           MemberRole role,
                           String mobile) {


    public LoginMember(Member member) {
        this(member.getMemberId(), member.getUserName(), member.getPassword(),
                MemberRole.getTopRole(member.getRoles()), member.getMobile());
    }
}
