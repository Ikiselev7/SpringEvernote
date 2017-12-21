package com.epam.controllers.mappers;

import com.epam.controllers.ControllerModels.UserModel;
import com.epam.models.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userModelToUserDto(UserModel user);

    List<UserDto> usersModelToUsersDto(List<UserModel> users);

    UserModel userDtoToUserModel(UserDto user);

    List<UserModel> usersDtoToUsersModel(List<UserDto> users);
}
