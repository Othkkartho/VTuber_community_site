package com.othkkartho.vtuber_community_site.repository.user;

import com.othkkartho.vtuber_community_site.domain.entity.Resources;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resources, Long> {
    Resources findByResourceName(String resourceName);
}
