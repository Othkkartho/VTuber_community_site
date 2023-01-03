package com.othkkartho.vtuber_community_site.security.service;

import com.othkkartho.vtuber_community_site.domain.entity.Account;
import com.othkkartho.vtuber_community_site.domain.entity.Role;
import com.othkkartho.vtuber_community_site.repository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    private void setUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {

        Account account = userRepository.findByNickname(nickname);
        if (account == null) {
            if (userRepository.countByNickname(nickname) == 0) {
                throw new UsernameNotFoundException("No user found with username: " + nickname);
            }
        }
        assert account != null;
        List<GrantedAuthority> collect = account.getUserRoles()
                .stream()
                .map(Role::getRoleName)
                .collect(Collectors.toSet())
                .stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        //List<GrantedAuthority> collect = userRoles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return new AccountContext(account, collect);
    }
}