package com.epam.mappers;

import com.epam.dto.UserDto;
import com.epam.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(UserEntity user);

    List<UserDto> usersToUsersDto(List<UserEntity> users);

    UserEntity userDtoToUser(UserDto user);

    List<UserEntity> usersDtoToUsers(List<UserDto> users);
}
