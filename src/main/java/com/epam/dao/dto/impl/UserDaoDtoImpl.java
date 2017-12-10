package com.epam.dao.dto.impl;

import com.epam.dao.UserDao;
import com.epam.dao.dto.UserDaoDto;
import com.epam.dto.UserDto;
import com.epam.mappers.UserMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserDaoDtoImpl implements UserDaoDto {
    private final UserDao userDao;
    private final UserMapper userMapper;

    @Override
    public UserDto save(UserDto userDto) {
        return userMapper.userToUserDto(userDao.save(userMapper.userDtoToUser(userDto)));
    }

    @Override
    public UserDto findById(Long id) {
        return userMapper.userToUserDto(userDao.findById(id).get());
    }

    @Override
    public void delete(UserDto userDto) {
        userDao.delete(userMapper.userDtoToUser(userDto));
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.usersToUsersDto(userDao.findAll());
    }
}
