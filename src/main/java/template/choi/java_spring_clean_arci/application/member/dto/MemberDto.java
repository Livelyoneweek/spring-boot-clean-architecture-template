package template.choi.java_spring_clean_arci.application.member.dto;

import jakarta.validation.constraints.NotBlank;
import template.choi.java_spring_clean_arci.domain.member.entity.Member;

public class MemberDto {

    public static class Req {

        public record Search(
                @NotBlank(message = "검색어를 입력해주세요.")
                String keyword
        ) {}

        public record Create(
                @NotBlank(message = "사용자 이름은 필수입니다.")
                String userName,
                @NotBlank(message = "비밀번호는 필수입니다.")
                String password,
                @NotBlank(message = "휴대폰 번호는 필수입니다.")
                String mobile
        ) {}

        public record Update(
                @NotBlank(message = "사용자 이름은 필수입니다.")
                String userName,
                @NotBlank(message = "휴대폰 번호는 필수입니다.")
                String mobile
        ) {}
    }

    public static class Res {

        public record ResMember(
                Long memberId,
                String userName,
                String mobile
        ) {
            public static ResMember from(Member member) {
                return new ResMember(
                        member.getMemberId(),
                        member.getUserName(),
                        member.getMobile()
                );
            }
        }
    }
}
