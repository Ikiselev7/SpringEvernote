package com.epam.services.impl;

import com.epam.dao.dto.UserDaoDto;
import com.epam.dto.UserDto;
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
    private UserDaoDto userDaoDto;

    @Override
    public UserDto save(UserDto userDto) {
        return userDaoDto.save(userDto);
    }

    @Override
    public UserDto update(UserDto userDto) {
        return userDaoDto.save(userDto);
    }

    @Override
    public UserDto read(Long id) {
        return userDaoDto.findById(id);
    }

    @Override
    public void delete(UserDto userDto) {
        userDaoDto.delete(userDto);
    }

    @Override
    public List<UserDto> getAll() {
        return userDaoDto.findAll();
    }
}
