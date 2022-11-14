package com.othkkartho.vtuber_community_site.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Account extends BaseTimeEntity {
    @Id
    @Generated
    private long id;

    @Column
    private String pw;

    @Column
    private String email;

    @Column
    private String nickname;

    @Column
    private String product;

    @Column
    private String product_id;

    @OneToOne(mappedBy = "account")
    private AccountDetail accountDetail;
    @OneToMany(mappedBy = "account")
    private Set<AccountRole> accountRoles = new HashSet<>();
}
