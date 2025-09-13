package template.choi.java_spring_clean_arci.application.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.choi.java_spring_clean_arci.application.member.dto.TokenInfo;
import template.choi.java_spring_clean_arci.application.member.dto.LoginCommand;
import template.choi.java_spring_clean_arci.application.member.port.in.LoginUseCase;
import template.choi.java_spring_clean_arci.application.member.port.out.GenerateTokenPort;

import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class LoginService implements LoginUseCase {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final GenerateTokenPort generateTokenPort;

    @Override
    @Transactional
    public TokenInfo login(LoginCommand command) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(command.getUserName(), command.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        String roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        return generateTokenPort.generateToken(authentication.getName(), roles);
    }
}
