package com.epam.dao.impl;

import com.epam.dao.jparepositories.UserJpaRepository;
import com.epam.dao.UserDao;
import com.epam.models.UserDto;
import com.epam.dao.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto save(UserDto userDto) {
        return userMapper.userToUserDto(userJpaRepository.save(userMapper.userDtoToUser(userDto)));
    }

    @Override
    public UserDto findById(Long id) {
        return userMapper.userToUserDto(userJpaRepository.findById(id).get());
    }

    @Override
    public void delete(UserDto userDto) {
        userJpaRepository.delete(userMapper.userDtoToUser(userDto));
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.usersToUsersDto(userJpaRepository.findAll());
    }
}
