package com.epam.dao;

import com.epam.models.UserDto;

import java.util.List;

public interface UserDao {
    UserDto save(UserDto userDto);

    UserDto findById(Long id);

    void delete(UserDto userDto);

    List<UserDto> findAll();
}
