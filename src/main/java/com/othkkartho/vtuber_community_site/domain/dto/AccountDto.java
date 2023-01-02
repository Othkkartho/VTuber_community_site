package com.othkkartho.vtuber_community_site.domain.dto;

import com.othkkartho.vtuber_community_site.domain.entity.AccountDetail;
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
public class AccountDto {
    private String id;
    private String email;
    private String password;
    private String nickname;
    private String product;
    private String product_id;
    private AccountDetail accountDetail;
    private Set<Role> roles;
}
