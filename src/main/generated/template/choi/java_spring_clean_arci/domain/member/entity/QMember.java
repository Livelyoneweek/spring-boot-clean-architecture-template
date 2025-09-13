package template.choi.java_spring_clean_arci.domain.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1237683914L;

    public static final QMember member = new QMember("member1");

    public final template.choi.java_spring_clean_arci.common.entity.QBaseEntity _super = new template.choi.java_spring_clean_arci.common.entity.QBaseEntity(this);

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final StringPath mobile = createString("mobile");

    public final StringPath password = createString("password");

    public final SetPath<template.choi.java_spring_clean_arci.domain.member.enums.MemberRole, EnumPath<template.choi.java_spring_clean_arci.domain.member.enums.MemberRole>> roles = this.<template.choi.java_spring_clean_arci.domain.member.enums.MemberRole, EnumPath<template.choi.java_spring_clean_arci.domain.member.enums.MemberRole>>createSet("roles", template.choi.java_spring_clean_arci.domain.member.enums.MemberRole.class, EnumPath.class, PathInits.DIRECT2);

    public final StringPath userName = createString("userName");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

