package com.epam.controllers.controllerMap;

import com.epam.controllers.ControllerModels.UserModel;
import com.epam.dao.entity.User;

public interface UserTransformer extends Transformer<User, UserModel> {
    @Override
    User bind(UserModel userModel);

    @Override
    UserModel unbind(User user);
}
