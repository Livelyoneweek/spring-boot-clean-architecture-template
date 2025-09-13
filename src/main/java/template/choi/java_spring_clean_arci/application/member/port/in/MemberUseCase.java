package template.choi.java_spring_clean_arci.application.member.port.in;

import template.choi.java_spring_clean_arci.application.member.dto.MemberDto;

import java.util.List;

public interface MemberUseCase {
    MemberDto.Res.ResMember createMember(MemberDto.Req.Create dto);
    void deleteMember(Long memberId);
    MemberDto.Res.ResMember getMemberById(Long memberId);
    List<MemberDto.Res.ResMember> getAllMembers();
    MemberDto.Res.ResMember updateMember(Long memberId, MemberDto.Req.Update dto);
}
