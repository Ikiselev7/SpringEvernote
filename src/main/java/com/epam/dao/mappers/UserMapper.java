package com.epam.dao.mappers;

import com.epam.dao.entity.User;
import com.epam.models.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(User user);

    List<UserDto> usersToUsersDto(List<User> users);

    User userDtoToUser(UserDto user);

    List<User> usersDtoToUsers(List<UserDto> users);
}
