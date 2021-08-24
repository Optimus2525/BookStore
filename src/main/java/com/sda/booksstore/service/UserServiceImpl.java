package com.sda.booksstore.service;

import com.sda.booksstore.model.AppUser;
import com.sda.booksstore.model.Role;
import com.sda.booksstore.repository.RoleRepository;
import com.sda.booksstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public AppUser saveAppUser(AppUser appUser) {
        log.info("Saving new AppUser {} to database", appUser.getName());
        return userRepository.save(appUser);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new Role {} to database", role.getRoleName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        log.info("Adding Role {} to AppUser {}", roleName, userName);
        AppUser user = userRepository.findByUserName(userName);
        Role role = roleRepository.findByRoleName(roleName);
        // Getting al roles and assigning one to user
        user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String userName) {
        log.info("Fetching user{}", userName);
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
