package com.example.demospringsecurity.security;

import com.example.demospringsecurity.dao.UserDao;
import com.example.demospringsecurity.models.User;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public AccountDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> user = userDao.findByUsername(username);
        if (user.size() != 1) {
            throw new UsernameNotFoundException("User ot found");
        }
        return new AccountDetails(user.get(0));
    }
}