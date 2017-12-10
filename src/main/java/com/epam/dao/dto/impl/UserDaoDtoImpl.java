package com.epam.dao.dto.impl;

import com.epam.dao.UserDao;
import com.epam.dao.dto.UserDaoDto;
import com.epam.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoDtoImpl implements UserDaoDto {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDto save(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto findById(Long id) {
        return null;
    }

    @Override
    public UserDto delete(UserDto userDto) {
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        return null;
    }
}
