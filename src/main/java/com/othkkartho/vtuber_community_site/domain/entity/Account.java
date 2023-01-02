package com.othkkartho.vtuber_community_site.domain.entity;

import com.othkkartho.vtuber_community_site.domain.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Account extends BaseTimeEntity implements Serializable {
    @Id
    @Comment("유저의 DB 상 ID")
    @Generated
    private long id;

    @Column(unique = true)
    @Comment("유저 이메일")
    private String email;

    @Column(nullable = false)
    @Comment("유저 패스워드")
    private String password;

    @Column()
    @Comment("사이트 상에서 유저 닉네임")
    private String nickname;

    @Column()
    @Comment("연결한 oauth 서비스 이름")
    private String product;

    @Column()
    @Comment("해당 oauth 서비스에서 받은 ID 값")
    private String product_id;

    @OneToOne(mappedBy = "account")
    private AccountDetail accountDetail;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinTable(name = "account_roles", joinColumns = { @JoinColumn(name = "account_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id")})
    @ToString.Exclude
    private Set<Role> userRoles = new HashSet<>();
}
