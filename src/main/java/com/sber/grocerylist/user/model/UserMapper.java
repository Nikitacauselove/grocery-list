package com.sber.grocerylist.user.model;

import com.sber.grocerylist.user.dto.UserDto;
import com.sber.grocerylist.user.dto.UserShortDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserShortDto userShortDto);

    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "name", source = "userShortDto.name")
    @Mapping(target = "surname", source = "userShortDto.surname")
    User toUser(User user, UserShortDto userShortDto);

    UserDto toUserDto(User user);

    List<UserDto> toUserDto(List<User> users);
}
