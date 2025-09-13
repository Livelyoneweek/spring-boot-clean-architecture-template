package template.choi.java_spring_clean_arci.common.config.filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

/**
 * MDC(Mapped Diagnostic Context)는 SLF4J와 Logback 등에서 제공하는 스레드 로컬 기반의 데이터 저장소
 */
@Component
@Slf4j
public class RequestIdInterceptor implements HandlerInterceptor {

    private static final String TX_ID = "txId";
    private static final String START_TIME  = "startTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String txId = UUID.randomUUID().toString();
        MDC.put(TX_ID, txId);

        // 시작 시간 기록
        request.setAttribute(START_TIME, System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            long start    = (Long) request.getAttribute(START_TIME);
            long latency  = System.currentTimeMillis() - start;

            int status    = response.getStatus();
            String method = request.getMethod();
            String uri    = request.getRequestURI();

            // SecurityContext 에서 userId 추출
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String userId = (auth != null && auth.isAuthenticated())
                    ? auth.getName()
                    : "anonymous";

            // 로그 출력 (structured logging 사용 시 JSON encoder 자동 포맷팅)
            log.info("### ☘️ [API_RES_INFO] : requestId={}, userName={}, method={}, uri={}, status={}, latencyMs={}",
                    MDC.get(TX_ID),
                    userId,
                    method,
                    uri,
                    status,
                    latency);
        } finally {
            // MDC 정리
            MDC.remove(TX_ID);
        }
    }
}
