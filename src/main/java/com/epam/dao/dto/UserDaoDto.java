package com.epam.dao.dto;

import com.epam.dto.UserDto;

import java.util.List;

public interface UserDaoDto {
    UserDto save(UserDto userDto);

    UserDto findById(Long id);

    UserDto delete(UserDto userDto);

    List<UserDto> findAll();
}
