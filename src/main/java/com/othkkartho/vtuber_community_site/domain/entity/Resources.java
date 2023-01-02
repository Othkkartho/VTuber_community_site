package com.othkkartho.vtuber_community_site.domain.entity;

import lombok.*;
import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "RESOURCES")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EntityListeners(value = { AuditingEntityListener.class })
@Builder
@AllArgsConstructor
public class Resources implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "resource_id")
    private Long id;

    @Column(name = "resource_name")
    @Comment("권리를 설정할 리소스 위치")
    private String resourceName;

    @Column(name = "order_num", nullable = false)
    @Comment("각 리소스들의 적용 순서")
    private int orderNum;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_resources", joinColumns = {@JoinColumn(name = "resource_id")},
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
    @ToString.Exclude
    private Set<Role> roleSet = new HashSet<>();
}
