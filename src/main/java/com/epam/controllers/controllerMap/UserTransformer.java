package com.epam.controllers.controllerMap;

import com.epam.controllers.ControllerModels.UserModel;
import com.epam.models.UserDto;
import com.epam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTransformer<S, T> implements Transformer<UserDto, UserModel> {
    @Autowired
    private UserService userService;

    @Override
    public UserDto bind(UserModel userModel) {
        UserDto userDto = userService.read(userModel.getId());
        if (userDto == null) {
            userDto = new UserDto();
            userDto.setId(0L);
        }
        userDto.setEmail(userModel.getEmail());
        userDto.setFirstName(userModel.getFirstName());
        userDto.setLastName(userModel.getLastName());
        userDto.setPassword(userModel.getPassword());
        return userDto;
    }

    @Override
    public UserModel unbind(UserDto userDto) {
        final UserModel userModel = new UserModel();
        userModel.setEmail(userDto.getEmail());
        userModel.setFirstName(userDto.getFirstName());
        userModel.setLastName(userDto.getLastName());
        userModel.setId(userDto.getId());
        userModel.setPassword(null);
        return userModel;
    }
}
