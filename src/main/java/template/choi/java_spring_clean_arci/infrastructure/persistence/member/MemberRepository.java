package template.choi.java_spring_clean_arci.infrastructure.persistence.member;

import org.springframework.data.jpa.repository.JpaRepository;
import template.choi.java_spring_clean_arci.domain.member.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUserName(String userName);

    Optional<Member> findByMobile(String mobile);
}
