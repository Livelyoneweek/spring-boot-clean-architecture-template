package template.choi.java_spring_clean_arci.application.member.port.out;

import template.choi.java_spring_clean_arci.application.member.dto.TokenInfo;

public interface GenerateTokenPort {
    TokenInfo generateToken(String userName, String roles);
}
