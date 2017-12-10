package com.epam.mappers;

import com.epam.dto.UserDTO;
import com.epam.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public class UserMapper {
    UserDTO userToUserDto(UserEntity user);

    List<UserDTO> usersToUsersDto(List<UserEntity> users);

    UserEntity userDtoToUser(UserDTO user);

    List<UserEntity> usersDtoToUsers(List<UserDTO> users);
}
