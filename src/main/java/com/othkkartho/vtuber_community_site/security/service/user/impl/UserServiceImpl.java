package com.othkkartho.vtuber_community_site.security.service.user.impl;

import com.othkkartho.vtuber_community_site.domain.dto.AccountDto;
import com.othkkartho.vtuber_community_site.domain.entity.Account;
import com.othkkartho.vtuber_community_site.domain.entity.Role;
import com.othkkartho.vtuber_community_site.repository.user.RoleRepository;
import com.othkkartho.vtuber_community_site.repository.user.UserRepository;
import com.othkkartho.vtuber_community_site.security.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    private void setUserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void createUser(Account account) {
        Role role = roleRepository.findByRoleName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        account.setUserRoles(roles);
        userRepository.save(account);
    }

    @Override
    public void modifyUser(AccountDto accountDto) {
        ModelMapper modelMapper = new ModelMapper();
        Account account = modelMapper.map(accountDto, Account.class);

        if(accountDto.getRoles() != null){
            Set<Role> roles = new HashSet<>();
            accountDto.getRoles().forEach(role -> {
                Role r = roleRepository.findByRoleName(role);
                roles.add(r);
            });
            account.setUserRoles(roles);
        }
        account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        userRepository.save(account);
    }

    @Transactional
    public AccountDto getUser(Long id) {
        Account account = userRepository.findById(id).orElse(new Account());
        ModelMapper modelMapper = new ModelMapper();
        AccountDto accountDto = modelMapper.map(account, AccountDto.class);

        List<String> roles = account.getUserRoles()
                .stream()
                .map(Role::getRoleName)
                .collect(Collectors.toList());

        accountDto.setRoles(roles);
        return accountDto;
    }

    @Transactional
    public List<Account> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
