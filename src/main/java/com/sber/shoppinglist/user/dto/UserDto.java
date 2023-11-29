package com.sber.shoppinglist.user.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class UserDto extends UserShortDto {
    private final Long id;
}
