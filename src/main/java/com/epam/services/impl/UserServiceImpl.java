package com.epam.services.impl;

import com.epam.dao.UserDao;
import com.epam.models.UserDto;
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
    public UserDto save(UserDto userDto) {
        return userDao.save(userDto);
    }

    @Override
    public UserDto update(UserDto userDto) {
        return userDao.save(userDto);
    }

    @Override
    public UserDto read(Long id) {
        return userDao.findById(id);
    }

    @Override
    public void delete(UserDto userDto) {
        userDao.delete(userDto);
    }

    @Override
    public List<UserDto> getAll() {
        return userDao.findAll();
    }
}
