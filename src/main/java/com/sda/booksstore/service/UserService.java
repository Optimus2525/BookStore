package com.sda.booksstore.service;

import com.sda.booksstore.model.AppUser;
import com.sda.booksstore.model.Role;

import java.util.List;

public interface UserService {

    AppUser saveAppUser(AppUser appUser);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    AppUser getUser(String userName);

    List<AppUser> getUsers();
}
