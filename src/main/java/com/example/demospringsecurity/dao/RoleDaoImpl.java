package com.example.demospringsecurity.dao;

import com.example.demospringsecurity.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    private final EntityManager entityManager;

    @Autowired
    public RoleDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> listRoles() {
        return entityManager.createQuery("FROM Role").getResultList();
    }

    @Override
    public Role getRole(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void editRole(Long id, Role role) {
        Role edit = entityManager.find(Role.class, id);
        edit.setName(role.getName());
    }

    @Override
    public void deleteRole(Long id) {
        entityManager.remove(entityManager.find(Role.class, id));
    }
}