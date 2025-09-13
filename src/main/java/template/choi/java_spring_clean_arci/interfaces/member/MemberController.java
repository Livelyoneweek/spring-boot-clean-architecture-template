package template.choi.java_spring_clean_arci.interfaces.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import template.choi.java_spring_clean_arci.application.member.dto.MemberDto;
import template.choi.java_spring_clean_arci.application.member.port.in.MemberUseCase;
import template.choi.java_spring_clean_arci.common.dto.ResponseCode;
import template.choi.java_spring_clean_arci.common.dto.ResponseDto;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/member/v1")
@RestController
public class MemberController {

    private final MemberUseCase memberUseCase;

    /** 회원 생성 */
    @PostMapping
    public ResponseEntity<ResponseDto<MemberDto.Res.ResMember>> create(@Valid @RequestBody MemberDto.Req.Create req) {
        MemberDto.Res.ResMember resMember = memberUseCase.createMember(req);
        return ResponseEntity.ok(new ResponseDto<>(
                ResponseCode.SUCCESS,
                resMember
        ));
    }

    /** 회원 단건 조회 */
    @GetMapping("/{memberId}")
    public ResponseEntity<ResponseDto<MemberDto.Res.ResMember>> getById(@PathVariable Long memberId) {
        MemberDto.Res.ResMember resMember = memberUseCase.getMemberById(memberId);
        return ResponseEntity.ok(new ResponseDto<>(
                ResponseCode.SUCCESS,
                resMember
        ));
    }

    /** 회원 전체 조회 */
    @GetMapping
    public ResponseEntity<ResponseDto<List<MemberDto.Res.ResMember>>> getAll() {
        List<MemberDto.Res.ResMember> res = memberUseCase.getAllMembers();
        return ResponseEntity.ok(new ResponseDto<>(
                ResponseCode.SUCCESS,
                res
        ));
    }

    /** 회원 수정 */
    @PutMapping("/{memberId}")
    public ResponseEntity<ResponseDto<MemberDto.Res.ResMember>> update(@PathVariable Long memberId,
                                                    @Valid @RequestBody MemberDto.Req.Update req) {
        MemberDto.Res.ResMember resMember = memberUseCase.updateMember(memberId, req);
        return ResponseEntity.ok(new ResponseDto<>(
                ResponseCode.SUCCESS,
                resMember
        ));
    }

    /** 회원 삭제 */
    @DeleteMapping("/{memberId}")
    public ResponseEntity<ResponseDto<Void>> delete(@PathVariable Long memberId) {
        memberUseCase.deleteMember(memberId);
        return ResponseEntity.ok(new ResponseDto<>(ResponseCode.SUCCESS));
    }
}
