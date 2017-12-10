package com.epam.services;


import com.epam.entity.UserEntity;

import java.util.List;

public interface UserService {
    /**
     * Create User.
     *
     * @param userEntity user data
     * @return user entity
     */
    UserEntity save(UserEntity userEntity);

    /**
     * Update user.
     *
     * @param userEntity user data
     * @return updated data
     */
    UserEntity update(UserEntity userEntity);

    /**
     * Read user data.
     *
     * @param id user id
     * @return user
     */
    UserEntity read(Long id);

    /**
     * Delete user.
     *
     * @param userEntity user
     */
    void delete(UserEntity userEntity);

    /**
     * Return all users.
     *
     * @return list of users
     */
    List<UserEntity> getAll();
}
