package com.othkkartho.vtuber_community_site.security.service.user.impl;

import com.othkkartho.vtuber_community_site.domain.entity.Resources;
import com.othkkartho.vtuber_community_site.repository.user.ResourceRepository;
import com.othkkartho.vtuber_community_site.security.service.user.ResourcesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ResourcesServiceImpl implements ResourcesService {
    private ResourceRepository resourceRepository;

    @Autowired
    private void setResourcesServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Transactional
    public Resources getResources(long id) {
        return resourceRepository.findById(id).orElse(new Resources());
    }

    @Transactional
    public List<Resources> getResources() {
        return resourceRepository.findAll(Sort.by(Sort.Order.asc("orderNum")));
    }

    @Transactional
    public void createResources(Resources resources) {
        resourceRepository.save(resources);
    }

    @Transactional
    public void deleteResources(long id) {
        resourceRepository.deleteById(id);
    }
}
