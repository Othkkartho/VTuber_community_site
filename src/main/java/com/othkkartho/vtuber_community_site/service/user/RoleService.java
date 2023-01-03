package com.othkkartho.vtuber_community_site.service.user;

import com.othkkartho.vtuber_community_site.domain.entity.Resources;
import com.othkkartho.vtuber_community_site.domain.entity.Role;

import java.util.List;

public interface RoleService {
    Role getRole(long id);
    List<Role> getRoles();

    void createRole(Role role);
    void deleteRole(long id);
}
