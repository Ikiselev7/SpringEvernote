package com.epam.services;


import com.epam.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    /**
     * Create User.
     *
     * @param userDto user data
     * @return user entity
     */
    UserDto save(UserDto userDto);

    /**
     * Update user.
     *
     * @param userDto user data
     * @return updated data
     */
    UserDto update(UserDto userDto);

    /**
     * Read user data.
     *
     * @param id user id
     * @return user
     */
    UserDto read(Long id);

    /**
     * Delete user.
     *
     * @param userDto user
     */
    void delete(UserDto userDto);

    /**
     * Return all users.
     *
     * @return list of users
     */
    List<UserDto> getAll();
}
