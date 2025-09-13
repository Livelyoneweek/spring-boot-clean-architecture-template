package template.choi.java_spring_clean_arci.domain.member.enums;

import lombok.Getter;
import java.util.Comparator;
import java.util.Optional;

@Getter
public enum MemberRole {
    USER(0),
    ADMIN(100);

    private final int priority;

    MemberRole(int priority) {
        this.priority = priority;
    }

    public static MemberRole getTopRole(java.util.Collection<MemberRole> roles) {
        if (roles == null || roles.isEmpty()) {
            return null;
        }
        Optional<MemberRole> optionalMemberRole = roles.stream().max(Comparator.comparingInt(MemberRole::getPriority));
        return optionalMemberRole.orElse(null);
    }
}
