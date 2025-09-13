package template.choi.java_spring_clean_arci.application.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.choi.java_spring_clean_arci.application.member.dto.MemberDto;
import template.choi.java_spring_clean_arci.application.member.port.in.MemberUseCase;
import template.choi.java_spring_clean_arci.application.member.port.out.MemberPort;
import template.choi.java_spring_clean_arci.domain.member.entity.Member;
import template.choi.java_spring_clean_arci.domain.member.enums.MemberRole;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class MemberService implements MemberUseCase {

    private final MemberPort memberPort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public MemberDto.Res.ResMember createMember(MemberDto.Req.Create createMemberDto) {
        log.info("### MemberService.createMember - username: {}, mobile: {}",
                createMemberDto.getUserName(), createMemberDto.getMobile());
        Member member = new Member(
                createMemberDto.getUserName(),
                passwordEncoder.encode(createMemberDto.getPassword()),
                Set.of(MemberRole.USER),
                createMemberDto.getMobile()
        );
        return MemberDto.Res.ResMember.from(memberPort.save(member));
    }

    @Override
    public void deleteMember(Long memberId) {
        memberPort.deleteById(memberId);
        log.info("### MemberService.deleteMember - memberId: {} deleted", memberId);
    }

    @Transactional(readOnly = true)
    @Override
    public MemberDto.Res.ResMember getMemberById(Long memberId) {
        return MemberDto.Res.ResMember.from(memberPort.findById(memberId));
    }

    @Transactional(readOnly = true)
    @Override
    public List<MemberDto.Res.ResMember> getAllMembers() {
        return memberPort.findAll().stream()
                .map(MemberDto.Res.ResMember::from)
                .collect(Collectors.toList());
    }

    @Override
    public MemberDto.Res.ResMember updateMember(Long memberId, MemberDto.Req.Update updateMemberDto) {
        log.info("### MemberService.updateMember - memberId: {}, newUsername: {}, newMobile: {}",
                memberId, updateMemberDto.getUserName(), updateMemberDto.getMobile());
        Member member = memberPort.findById(memberId);
        member.update(
                updateMemberDto.getUserName(),
                updateMemberDto.getMobile()
        );
        return MemberDto.Res.ResMember.from(member);
    }
}
