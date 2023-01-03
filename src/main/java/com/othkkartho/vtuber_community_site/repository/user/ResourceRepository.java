package com.othkkartho.vtuber_community_site.repository.user;

import com.othkkartho.vtuber_community_site.domain.entity.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resources, Long> {
    Resources findByResourceName(String resourceName);

    @Query("select r from Resources r join fetch r.roleSet order by r.orderNum desc")
    List<Resources> findAllResources();
}
