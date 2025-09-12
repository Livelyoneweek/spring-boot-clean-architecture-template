package template.choi.java_spring_clean_arci.application.member.port.in;

import template.choi.java_spring_clean_arci.application.member.dto.LoginCommand;
import template.choi.java_spring_clean_arci.application.member.dto.TokenInfo;

public interface LoginUseCase {
    TokenInfo login(LoginCommand command);
}
