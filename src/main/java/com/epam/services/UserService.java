package com.epam.services;


import com.epam.dao.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    /**
     * Create User.
     *
     * @param user user data
     * @return user entity
     */
    User save(User user);

    /**
     * Update user.
     *
     * @param user user data
     * @return updated data
     */
    User update(User user);

    /**
     * Read user data.
     *
     * @param id user id
     * @return user
     */
    Optional<User> read(Long id);

    /**
     * Delete user.
     *
     * @param user user
     */
    void delete(User user);

    /**
     * Return all users.
     *
     * @return list of users
     */
    List<User> getAll();
}
