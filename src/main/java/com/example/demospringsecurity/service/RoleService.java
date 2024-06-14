package com.example.demospringsecurity.service;

import com.example.demospringsecurity.models.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);
    List<Role> listRoles();
    Role getRole(Long id);
    void editRole(Long id, Role role);
    void deleteRole(Long id);
}