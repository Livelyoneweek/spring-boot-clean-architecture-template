package template.choi.java_spring_clean_arci.infrastructure.security.dto;

import lombok.Getter;
import template.choi.java_spring_clean_arci.domain.member.entity.Member;
import template.choi.java_spring_clean_arci.domain.member.enums.MemberRole;

public record LoginMember (@Getter Long memberId,
                           @Getter String userName,
                           @Getter MemberRole role,
                           @Getter String mobile) {

    public LoginMember(Member member) {
        this(member.getMemberId(), member.getUserName(), MemberRole.getTopRole(member.getRoles()), member.getMobile());
    }
}
