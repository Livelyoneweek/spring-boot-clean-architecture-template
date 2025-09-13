package template.choi.java_spring_clean_arci.infrastructure.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import template.choi.java_spring_clean_arci.infrastructure.security.dto.LoginMember;
import template.choi.java_spring_clean_arci.infrastructure.security.principal.PrincipalDetails;


import java.util.Optional;

@Slf4j
public class AuditorAwareImpl implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }
        if (authentication.getPrincipal().equals("anonymousUser")){
            return Optional.empty();
        }

        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        LoginMember user = principalDetails.getUser();
        return Optional.of(user.memberId());
    }
}
