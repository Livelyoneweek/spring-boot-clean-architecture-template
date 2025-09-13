package template.choi.java_spring_clean_arci.domain.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import template.choi.java_spring_clean_arci.domain.member.enums.MemberRole;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "member_roles", joinColumns = @JoinColumn(name = "member_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Set<MemberRole> roles = new HashSet<>();

    private String mobile;

    public Member(String userName, String password, Set<MemberRole> roles,  String mobile) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
        this.mobile = mobile;
    }

    public void update(String userName, String mobile) {
        if(userName != null) {
            this.userName = userName;
        }
        if(mobile != null) {
            this.mobile = mobile;
        }
    }
}
