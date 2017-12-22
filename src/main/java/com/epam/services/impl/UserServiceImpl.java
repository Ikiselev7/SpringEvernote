package com.epam.services.impl;

import com.epam.dao.entity.User;
import com.epam.dao.jparepositories.UserJpaRepository;
import com.epam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public User save(User user) {
        return userJpaRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userJpaRepository.save(user);
    }

    @Override
    public Optional<User> read(Long id) {
        return userJpaRepository.findById(id);
    }

    @Override
    public void delete(User user) {
        userJpaRepository.delete(user);
    }

    @Override
    public List<User> getAll() {
        return userJpaRepository.findAll();
    }
}
