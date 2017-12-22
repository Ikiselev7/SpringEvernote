package com.epam.controllers.controllerMap;

import com.epam.controllers.ControllerModels.UserModel;
import com.epam.dao.entity.User;
import com.epam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserTransformerImpl implements UserTransformer {
    @Autowired
    private UserService userService;

    @Override
    public User bind(UserModel userModel) {
        User user = userService.read(userModel.getId())
                .orElseGet(
                        () -> {
                            User user1 = new User();
                            user1.setId(0L);
                            return user1;
                        }
                );
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setPassword(userModel.getPassword());
        return user;
    }

    @Override
    public UserModel unbind(User user) {
        final UserModel userModel = new UserModel();
        userModel.setEmail(user.getEmail());
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setId(user.getId());
        userModel.setPassword(null);
        return userModel;
    }
}
