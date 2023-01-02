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
    @Column(nullable = false, columnDefinition = "DB의 자체 ID 값")
    private Long id;

    @Column(nullable = false, columnDefinition = "사이트에서 획득할 수 있는 무료 포인트")
    private long free_point;

    @Column(nullable = false, columnDefinition = "상품을 구매하고 얻을 수 있는 유료 포인트")
    private long fee_point;

    @Column(columnDefinition = "해당 유저의 프로필 이미지")
    private String image;

    @Column(columnDefinition = "유저 소개 문구")
    private String introduce;

    @Column(columnDefinition = "레벨을 위한 경험치")
    private long ep;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Account account;
}
