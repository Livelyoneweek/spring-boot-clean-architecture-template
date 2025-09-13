package template.choi.java_spring_clean_arci.infrastructure.persistence.member.jpa;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import template.choi.java_spring_clean_arci.application.member.dto.MemberDto;

import java.util.List;

import static template.choi.java_spring_clean_arci.domain.member.entity.QMember.member;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberQueryDslImpl implements MemberQueryDsl {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MemberDto.Res.ResMember> searchMemberByName(String keyword) {
        return queryFactory
                .select(Projections.constructor(
                        MemberDto.Res.ResMember.class,
                        member.memberId,
                        member.userName,
                        member.mobile
                ))
                .from(member)
                .where(conditionSearchMember(keyword))
                .orderBy(member.lastModifiedDate.desc())
                .fetch();
    }

    private BooleanBuilder conditionSearchMember(String keyword) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(searchUserName(keyword));
        return builder;
    }

    private BooleanExpression searchUserName(String keyword) {
        return StringUtils.hasText(keyword) ? member.userName.containsIgnoreCase(keyword) : null;
    }
}
