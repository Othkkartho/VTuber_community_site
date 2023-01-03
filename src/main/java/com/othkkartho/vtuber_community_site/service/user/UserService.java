package com.othkkartho.vtuber_community_site.service.user;

import com.othkkartho.vtuber_community_site.domain.dto.AccountDto;
import com.othkkartho.vtuber_community_site.domain.entity.Account;

import java.util.List;

public interface UserService {
    void createUser(Account account);
    void modifyUser(AccountDto accountDto);

    List<Account> getUsers();
    AccountDto getUser(Long id);

    void deleteUser(Long idx);
}
