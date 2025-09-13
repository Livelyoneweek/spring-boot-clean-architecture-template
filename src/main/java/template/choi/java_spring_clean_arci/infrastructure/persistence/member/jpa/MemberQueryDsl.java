package template.choi.java_spring_clean_arci.infrastructure.persistence.member.jpa;

import template.choi.java_spring_clean_arci.application.member.dto.MemberDto;

import java.util.List;

public interface MemberQueryDsl {
    List<MemberDto.Res.ResMember> searchMemberByName(String userName);
}
