package com.othkkartho.vtuber_community_site.service.user;

import com.othkkartho.vtuber_community_site.domain.entity.Resources;
import com.othkkartho.vtuber_community_site.domain.entity.Role;

import java.util.List;

public interface ResourcesService {
    Resources getResources(long id);
    List<Resources> getResources();

    void createResources(Resources Resources);
    void deleteResources(long id);
}
