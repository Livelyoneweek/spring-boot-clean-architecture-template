package template.choi.java_spring_clean_arci.infrastructure.security.dto;

import lombok.Getter;

@Getter
public enum MemberRole {
    USER(0),
    ADMIN(100);

    private final int priority;

    MemberRole(int priority) {
        this.priority = priority;
    }

    public static java.util.Optional<MemberRole> getTopRole(java.util.Collection<MemberRole> roles) {
        if (roles == null || roles.isEmpty()) {
            return java.util.Optional.empty();
        }
        return roles.stream().max(java.util.Comparator.comparingInt(MemberRole::getPriority));
    }
}
