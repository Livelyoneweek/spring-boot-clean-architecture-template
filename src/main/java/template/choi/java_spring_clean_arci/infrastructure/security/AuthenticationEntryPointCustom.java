package template.choi.java_spring_clean_arci.infrastructure.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import template.choi.java_spring_clean_arci.common.dto.ResponseCode;
import template.choi.java_spring_clean_arci.common.dto.ResponseDto;

import java.io.IOException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthenticationEntryPointCustom implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException{
        log.warn("### AuthenticationEntryPointCustom.commence e.getMessage={}",e.getMessage());
        response.setContentType("application/json");
        ResponseDto<Object> resultResponse = new ResponseDto<>(ResponseCode.UNAUTHORIZED);
        response.getWriter().write(new ObjectMapper().writeValueAsString(resultResponse));
    }
}

