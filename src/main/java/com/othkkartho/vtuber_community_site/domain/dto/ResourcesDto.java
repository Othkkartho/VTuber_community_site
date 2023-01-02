package com.othkkartho.vtuber_community_site.domain.dto;

import com.othkkartho.vtuber_community_site.domain.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourcesDto {
    private String id;
    private String resourceName;
    private int orderNum;
    private Set<Role> roleSet;
}
