package com.epam.services.impl;

import com.epam.dao.UserDao;
import com.epam.entity.UserEntity;
import com.epam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userDao.save(userEntity);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        return userDao.save(userEntity);
    }

    @Override
    public UserEntity read(Long id) {
        return userDao.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void delete(UserEntity userEntity) {
        userDao.delete(userEntity);
    }

    @Override
    public List<UserEntity> getAll() {
        return userDao.findAll();
    }
}
