package template.choi.java_spring_clean_arci.infrastructure.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import template.choi.java_spring_clean_arci.common.dto.ResponseCode;
import template.choi.java_spring_clean_arci.common.dto.ResponseDto;

import java.io.IOException;


import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AccessDeniedHandlerCustom implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        log.warn("### AccessDeniedHandlerCustom.handle,  e.getMessage={}",e.getMessage());
        ResponseDto<Object> resultResponse =
                new ResponseDto<>(ResponseCode.FORBIDDEN);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.addHeader("Content-Type", "application/json;charset=UTF-8");
        new ObjectMapper().writeValue(response.getWriter(), resultResponse);
    }
}

