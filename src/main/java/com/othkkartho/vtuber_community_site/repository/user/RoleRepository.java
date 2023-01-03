package com.othkkartho.vtuber_community_site.repository.user;

import com.othkkartho.vtuber_community_site.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String name);

    @Override
    void delete(Role role);
}
