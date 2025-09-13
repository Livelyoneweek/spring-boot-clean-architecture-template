package template.choi.java_spring_clean_arci.application.member.dto;

import lombok.Getter;
import template.choi.java_spring_clean_arci.domain.member.entity.Member;

public class MemberDto {

    public static class Req {

        public record Create (
                @Getter String userName,
                @Getter String password,
                @Getter String mobile
        ) {}

        public record Update (
                @Getter String userName,
                @Getter String mobile
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
