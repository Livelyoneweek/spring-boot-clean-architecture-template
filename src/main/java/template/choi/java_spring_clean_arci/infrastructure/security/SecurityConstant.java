package template.choi.java_spring_clean_arci.infrastructure.security;

import java.util.Set;

public class SecurityConstant {

    public static final Set<String> PUBLIC_URLS = Set.of(
            "/favicon.ico/**",
            "/swagger-ui/**", // SWAGGER UI 허용
            "/v3/**",
            "/swagger-resources/**",
            "/api-docs/**",   // SWAGGER API JSON 허용
            "/api/auth/v1/**" // 인증 API 허용

    );

    public static final String[] ALLOW_HEADERS = {
            "Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization", "Refresh-Token",
    };
}
