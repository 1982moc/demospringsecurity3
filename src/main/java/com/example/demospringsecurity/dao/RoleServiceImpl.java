package com.example.demospringsecurity.dao;

import com.example.demospringsecurity.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> listRoles() {
        return roleDao.listRoles();
    }

    @Transactional(readOnly = true)
    @Override
    public Role getRole(Long id) {
        return roleDao.getRole(id);
    }

    @Transactional
    @Override
    public void editRole(Long id, Role role) {
        roleDao.editRole(id, role);
    }

    @Transactional
    @Override
    public void deleteRole(Long id) {
        roleDao.deleteRole(id);
    }
}