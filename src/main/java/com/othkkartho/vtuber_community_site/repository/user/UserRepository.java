package com.othkkartho.vtuber_community_site.repository.user;

import com.othkkartho.vtuber_community_site.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Account, Long> {
    Account findByNickname(String nickname);
    int countByNickname(String nickname);
}
