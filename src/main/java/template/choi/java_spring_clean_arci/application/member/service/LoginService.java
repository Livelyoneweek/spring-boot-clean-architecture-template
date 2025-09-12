package template.choi.java_spring_clean_arci.application.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.choi.java_spring_clean_arci.application.member.dto.TokenInfo;
import template.choi.java_spring_clean_arci.application.member.dto.LoginCommand;
import template.choi.java_spring_clean_arci.application.member.port.in.LoginUseCase;
import template.choi.java_spring_clean_arci.application.member.port.out.GenerateTokenPort;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final GenerateTokenPort generateTokenPort;

    @Override
    @Transactional
    public TokenInfo login(LoginCommand command) {
        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(command.getUserName(), command.getPassword());

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        return generateTokenPort.generateToken(authentication.getName(), authentication.getAuthorities().toString());
    }
}
