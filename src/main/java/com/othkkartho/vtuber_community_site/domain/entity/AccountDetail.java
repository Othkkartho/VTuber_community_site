package com.othkkartho.vtuber_community_site.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class AccountDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private long free_point;

    @Column
    private long fee_point;

    @Column
    private String image;

    @Column
    private String introduce;

    @Column
    private long ep;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Account account;
}
