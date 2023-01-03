package com.othkkartho.vtuber_community_site.security.service;

import com.othkkartho.vtuber_community_site.domain.entity.Account;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
@Setter
@ToString
public class AccountContext extends User {
    private Account account;

    public AccountContext(Account account, List<GrantedAuthority> roles) {
      super(account.getNickname(), account.getPassword(), roles);
      this.account = account;
    }
}
