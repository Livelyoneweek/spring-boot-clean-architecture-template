package template.choi.java_spring_clean_arci.application.member.dto;

import lombok.Getter;

public record LoginCommand (
        @Getter String userName,
        @Getter String password
) {}
