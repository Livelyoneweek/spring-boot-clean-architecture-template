package template.choi.java_spring_clean_arci.interfaces.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import template.choi.java_spring_clean_arci.application.member.dto.TokenInfo;
import template.choi.java_spring_clean_arci.application.member.dto.LoginCommand;
import template.choi.java_spring_clean_arci.application.member.port.in.LoginUseCase;

@RestController
@RequestMapping("/api/auth/v1")
@RequiredArgsConstructor
public class AuthController {

    private final LoginUseCase loginUseCase;

    @PostMapping("/login")
    public TokenInfo login(@RequestBody LoginCommand command) {
        return loginUseCase.login(command);
    }
}
